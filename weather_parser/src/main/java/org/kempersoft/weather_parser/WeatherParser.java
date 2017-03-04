package org.kempersoft.weather_parser;


import com.google.common.annotations.VisibleForTesting;
import org.kempersoft.weather_parser.domain.weather.basefields.EWindDirectionTypeCode;
import org.kempersoft.weather_parser.domain.weather.basefields.ObservationValue;
import org.kempersoft.weather_parser.domain.weather.basefields.SkyCondition;
import org.kempersoft.weather_parser.domain.weather.basefields.WindDirection;
import org.kempersoft.weather_parser.domain.weather.remarks.RemarkRecord;
import org.kempersoft.weather_parser.domain.weather.additionaldata.EAdditionalWeatherData;
import org.kempersoft.weather_parser.domain.weather.basefields.EObservationType;
import org.kempersoft.weather_parser.domain.weather.EQualityCode;
import org.kempersoft.weather_parser.domain.weather.basefields.EReportType;
import org.kempersoft.weather_parser.domain.weather.basefields.VisibilityVariabilityReading;
import org.kempersoft.weather_parser.domain.weather.WeatherReading;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Hashtable;
import java.util.List;
import java.util.zip.GZIPInputStream;

public class WeatherParser {

  public static List<WeatherReading> parseFile( String fileName ) throws Exception {
    File file = new File( fileName );
    if ( !file.exists() ) {
      throw new Exception( "Error - file with name " + fileName + " doesn't exist" );
    }
    BufferedReader in = null;
    // see if it's a zip file..
    if ( file.getName().endsWith( "gz" ) ) {
      in = new BufferedReader( new InputStreamReader( new GZIPInputStream( new FileInputStream( file ) ) ) );
    } else {
      in = new BufferedReader( new InputStreamReader( new FileInputStream( file ) ) );
    }
    List<WeatherReading> readings = new ArrayList<>();
    String line = "";
    while ( ( line = in.readLine() ) != null ) {
      WeatherReading reading = WeatherParser.parseLine( line );
      readings.add( reading );
    }
    in.close();
    return readings;
  }

  public static WeatherReading parseLine( String line ) throws Exception {
    WeatherStringReader sReader = new WeatherStringReader( line );
    int numVariableChars = sReader.getIntField( 4 , null);
    if ( line.length() != numVariableChars + 105 ) {
      sReader.close();
      throw new Exception( "Error - invalid line length.  Expected " + ( numVariableChars + 105 ) + " - actual "
        + line.length() );
    }
    String USAF = sReader.getStringField( 6 );
    String WBAN = sReader.getStringField( 5 );
    String observeDate = sReader.getStringField( 8 );
    String observeTime = sReader.getStringField( 4 );
    Timestamp dateTime = getDateTime( observeDate, observeTime );
    WeatherReading reading = new WeatherReading( USAF, WBAN, dateTime );
    EObservationType otc = EObservationType.toObservationType( sReader.getStringField( 1 ) );
    reading.setObservationType( otc );
    reading.setLatitude( sReader.getDoubleValue( 6, "99999", 1000.0 ) );
    reading.setLongitude( sReader.getDoubleValue( 7, "999999", 1000.0 ) );
    reading.setReportType( EReportType.getReportTypeType( sReader.getStringField( 5 ) ) );
    reading.setElevation( sReader.getDoubleValue( 5, "9999", null ) );
    String callLetters = sReader.getStringField( 5 );
    if ( callLetters.equals( "99999" ) ) {
      callLetters = null;
    }
    reading.setFixedWeatherStationCallLetters( callLetters );

    reading.setQualityControlProcess( sReader.getStringField( 4 ) );
    setWindDirection( reading, sReader );
    setWindSpeed( reading, sReader );
    setSkyCondition( reading, sReader );
    setVisibility( reading, sReader );
    setAirTemperature( reading, sReader );
    setSeaLevelPressure( reading, sReader );

    sReader.mark( 1000000 );

    if ( numVariableChars > 0 ) {
      processOptionalFields( reading, sReader );
    }
    sReader.close();
    return reading;
  }

  @VisibleForTesting
  static Timestamp getDateTime( String observeDate, String observeTime ) {
    Calendar cal = Calendar.getInstance();
    int year = Integer.parseInt( observeDate.substring( 0, 4 ) );
    int month = Integer.parseInt( observeDate.substring( 4, 6 ) );
    int day = Integer.parseInt( observeDate.substring( 6, 8 ) );
    int hour = Integer.parseInt( observeTime.substring( 0, 2 ) );
    int minute = Integer.parseInt( observeTime.substring( 2, 4 ) );
    cal.set( year, month - 1, day, hour, minute );
    cal.set( Calendar.SECOND, 0 );
    cal.set( Calendar.MILLISECOND, 0 );
    Timestamp date = new Timestamp( cal.getTimeInMillis() );
    return date;
  }


  @VisibleForTesting
  static void setAirTemperature( WeatherReading reading, WeatherStringReader sReader ) throws Exception {

    Double airTemp = sReader.getDoubleValue( 5, "9999", 10.0 );
    EQualityCode qualityCode = sReader.getQualityCode();
    if ( !( airTemp == null && qualityCode == EQualityCode.C9 ) ) {
      reading.setAirTemperature( new ObservationValue( airTemp, qualityCode ) );
    }
    Double dewpoint = sReader.getDoubleValue( 5, "9999", 10.0 );
    EQualityCode dpQualityCode = sReader.getQualityCode();
    if ( !( dewpoint == null && dpQualityCode == EQualityCode.C9 ) ) {
      reading.setDewPoint( new ObservationValue( dewpoint, dpQualityCode ) );
    }
  }

  @VisibleForTesting
  static void setSeaLevelPressure( WeatherReading reading, WeatherStringReader sReader ) throws Exception {
    Double slpValue = sReader.getDoubleValue( 5, "9999", 10.0 );
    EQualityCode qcode = sReader.getQualityCode();
    if ( slpValue == null && qcode == EQualityCode.C9 ) {
      return;
    }
    reading.setSeaLevelPressure( new ObservationValue( slpValue, qcode ) );
  }

  @VisibleForTesting
  static void setSkyCondition( WeatherReading reading, WeatherStringReader sReader ) throws Exception {
    Double ceiling = sReader.getDoubleValue( 5, "99999", null );
    EQualityCode ccode = sReader.getQualityCode();
    String determination = sReader.getStringField( 1 );
    String strCAVOK = sReader.getStringField( 1 );

    if ( ceiling == null && ccode == EQualityCode.C9 ) {
      return;
    }

    SkyCondition condition = new SkyCondition( ceiling, ccode );
    condition.setCAVOK( strCAVOK );
    condition.setDetermination( determination );
    reading.setSkyCondition( condition );
  }

  @VisibleForTesting
  static void setVisibility( WeatherReading reading, WeatherStringReader sReader ) throws Exception {
    Double visibilityDistance = sReader.getDoubleValue( 6, "999999", null );
    EQualityCode qualCode = sReader.getQualityCode();
    if ( !( visibilityDistance == null && qualCode == EQualityCode.C9 ) ) {
      reading.setVisibilityDistance( new ObservationValue( visibilityDistance, qualCode ) );
    }
    String visVariable = sReader.getStringField( 1 );
    EQualityCode visVariableQuality = sReader.getQualityCode();
    if ( visVariable == null || visVariable.equals( "9" ) ) {
      return;
    }

    reading.setVisibilityVariability( new VisibilityVariabilityReading( visVariable, visVariableQuality ) );
  }

  @VisibleForTesting
  static void setWindDirection( WeatherReading reading, WeatherStringReader sReader ) throws Exception {
    Double angle = sReader.getDoubleValue( 3, "999", null );
    EQualityCode qualCode = sReader.getQualityCode();
    EWindDirectionTypeCode typeCode = EWindDirectionTypeCode.toTypeCode( sReader.getStringField( 1 ) );
    if ( angle == null && qualCode == EQualityCode.C9 ) {
      return;
    }
    WindDirection wd = new WindDirection( angle, qualCode, typeCode );
    reading.setWindDirection( wd );
  }

  @VisibleForTesting
  static void setWindSpeed( WeatherReading reading, WeatherStringReader sReader ) throws Exception {
    Double speed = sReader.getDoubleValue( 4, "9999", 10.0 );
    EQualityCode qualCode = sReader.getQualityCode();
    if ( speed == null && qualCode == EQualityCode.C9 ) {
      return; // don't set if it's empty
    }
    reading.setWindSpeed( new ObservationValue( speed, qualCode ) );
  }

  @VisibleForTesting
  static void processOptionalFields( WeatherReading reading, WeatherStringReader sReader ) throws Exception {
    boolean bContinue = true;
    char chars[] = new char[ 3 ]; // for the headers
    while ( bContinue ) {
      int numRead = sReader.read( chars, 0, 3 );
      if ( numRead == -1 ) {
        break;
      }
      if ( numRead != 3 ) {
        throw new Exception( "Not enough characters to get string field!" );
      }
      String recordType = new String( chars );
      if ( recordType.equals( "ADD" ) ) {
        processAdditionalData( reading, sReader );
      } else if ( recordType.equals( "REM" ) ) {
        processRemarks( reading, sReader );
      } else if ( recordType.equals( "EQD" ) ) {
        bContinue = false; // TODO : process equipment records
      } else {
        System.out.println( "Unknown key!" + recordType );
        bContinue = false;
      }
    }

  }

  public static Hashtable<String, Integer> usedKeys = new Hashtable<String, Integer>();

  @VisibleForTesting
  static void processAdditionalData( WeatherReading reading, WeatherStringReader sReader ) throws Exception {
    boolean bContinue = true;
    char chars[] = new char[ 3 ];
    while ( bContinue ) {
      sReader.mark( 11111111 ); // point to the beginning
      int numRead = sReader.read( chars, 0, 3 );
      if ( numRead == -1 ) {
        return; // out of data
      }
      if ( numRead != 3 ) {
        throw new Exception( "Error reading buffers - not enough characters on line!" );
      }
      sReader.reset(); // back up to the last characters
      String subRecord = new String( chars );
      if ( subRecord.equals( "REM" ) || subRecord.equals( "EQD" ) ) {
        // done with standard processing...
        return;
      }


      EAdditionalWeatherData adh = null;
      try {
        adh = EAdditionalWeatherData.valueOf( subRecord );
      } catch ( Exception ex ) {
        bContinue = false;
        throw new Exception( "Missing code " + subRecord );
      }
      if ( adh != null ) {
        if ( adh.getClazz() != null ) {
          Class<?> claz = adh.getClazz();
          Method adhMethod = claz.getMethod( "parseLine", WeatherReading.class, WeatherStringReader.class );
          adhMethod.invoke( null, reading, sReader );
        } else {
          sReader.skip( adh.getLength() );
					if (usedKeys.containsKey(subRecord)) {
            Integer iVal = usedKeys.get(subRecord);
						iVal = iVal + 1;
						usedKeys.put(subRecord, iVal);
					} else {
						Integer iVal = new Integer(1);
						usedKeys.put(subRecord, iVal);
					}

        }
      } else {
        bContinue = false;
      }
    }
    return;
  }

  private static List<String> knownRemarkTypes = Arrays
    .asList( new String[] { "SYN", "AWY", "MET", "SOD", "SOM", "HPD" } );

  @VisibleForTesting
  static void processRemarks( WeatherReading reading, WeatherStringReader sReader ) throws Exception {
    boolean bContinue = true;
    char chars[] = new char[ 3 ]; // for the headers
    while ( bContinue ) {
      sReader.mark( 11111111 );
      int numRead = sReader.read( chars, 0, 3 );
      if ( numRead == -1 ) {
        break;
      }
      if ( numRead != 3 ) {
        throw new Exception( "Not enough characters to get remarks type field!" );
      }

      String remarksType = new String( chars );
      if ( !knownRemarkTypes.contains( remarksType ) ) {
        sReader.reset();
        return;
      }
      int remarksLength = sReader.getIntField( 3 , null);
      String remarksString = sReader.getStringField( remarksLength );
      List<RemarkRecord> records = reading.getRemarks();
      if ( records == null ) {
        records = new ArrayList<RemarkRecord>();
        reading.setRemarks( records );
      }
      RemarkRecord remark = new RemarkRecord( remarksType, remarksString );
      records.add( remark );
    }
    return;
  }
}
