package org.kempersoft.weather_parser.domain.weather.additionaldata.precipitation;

import org.kempersoft.weather_parser.WeatherStringReader;
import org.kempersoft.weather_parser.domain.weather.EQualityCode;
import org.kempersoft.weather_parser.domain.weather.WeatherReading;

/**
 * Created by bkemper on 3/3/17.
 */
public class PrecipitationObservationHistory {

  private EObservationDurationCode durationCode;
  private EObservationCharacteristicCode characteristicCode;
  private EQualityCode qualityCode;

  public static void parseLine( WeatherReading reading, WeatherStringReader reader ) throws Exception {

    String identifier = reader.getStringField( 3 );    // should be - AC1
    if ( identifier == null || !identifier.startsWith( "AB1" ) ) {
      throw new Exception(
        "Error :  In PrecipitationObservationHistory reading with an invalid code.  Should have AC1 - got "
          + identifier );
    }
    PrecipitationObservationHistory precipitationObservationHistory = new PrecipitationObservationHistory();
    String durationCode = reader.getStringField( 1 );
    if ( durationCode != null ) {
      precipitationObservationHistory.durationCode = EObservationDurationCode.toObservationDurationCode( durationCode );
    }
    String characteristicCode = reader.getStringField( 1 );
    if ( characteristicCode != null ) {
      precipitationObservationHistory.characteristicCode = EObservationCharacteristicCode.toObservationCharacteristicCode( characteristicCode );
    }
    precipitationObservationHistory.qualityCode = reader.getQualityCode();
    AdditionalDataPrecipitation precipitation = reading.getAdditionalData().getPrecipitationReadings();
    precipitation.setPrecipitationObservationHistory( precipitationObservationHistory );
  }

  public EObservationDurationCode getDurationCode() {
    return durationCode;
  }

  public void setDurationCode(
    EObservationDurationCode durationCode ) {
    this.durationCode = durationCode;
  }

  public EObservationCharacteristicCode getCharacteristicCode() {
    return characteristicCode;
  }

  public void setCharacteristicCode(
    EObservationCharacteristicCode characteristicCode ) {
    this.characteristicCode = characteristicCode;
  }

  public EQualityCode getQualityCode() {
    return qualityCode;
  }

  public void setQualityCode( EQualityCode qualityCode ) {
    this.qualityCode = qualityCode;
  }

  @Override public String toString() {
    return "PrecipitationObservationHistory{" +
      "qualityCode=" + qualityCode +
      '}';
  }

  private enum EObservationDurationCode {
    C0( "0", "Lasted less than 1 hour" ),
    C1( "1", "Lasted 1 - 3 hours" ),
    C2( "2", "Lasted 3 - 6 hours" ),
    C3( "3", "Lasted more than 6 hours" ),
    C9( "9", "Missing" );

    private String original_code;
    private String description;


    private EObservationDurationCode( String original_code, String description ) {
      this.original_code = original_code;
      this.description = description;
    }

    public static EObservationDurationCode toObservationDurationCode( String originalCode ) throws Exception {
      if ( originalCode == null || originalCode.isEmpty() ) {
        throw new Exception( "Invalid precipitation observation duration code : " + originalCode );
      }
      for ( EObservationDurationCode code : values() ) {
        if ( code.original_code.equals( originalCode ) ) {
          return code;
        }
      }
      throw new Exception( "Invalid precipitation observation duration code : " + originalCode );
    }

    public String getOriginal_code() {
      return original_code;
    }

    public String getDescription() {
      return description;
    }

    @Override public String toString() {
      return "EObservationDurationCode{" +
        "original_code='" + original_code + '\'' +
        ", description='" + description + '\'' +
        "} " + super.toString();
    }
  }

  private enum EObservationCharacteristicCode {
    CC("C", "Continuous"),
    CI("I", "Intermittent"),
    C9("9", "Missing");

    private String original_code;
    private String description;


    private EObservationCharacteristicCode( String original_code, String description ) {
      this.original_code = original_code;
      this.description = description;
    }

    public static EObservationCharacteristicCode toObservationCharacteristicCode( String originalCode ) throws Exception {
      if ( originalCode == null || originalCode.isEmpty() ) {
        throw new Exception( "Invalid precipitation observation characteristic code : " + originalCode );
      }
      for ( EObservationCharacteristicCode code : values() ) {
        if ( code.original_code.equals( originalCode ) ) {
          return code;
        }
      }
      throw new Exception( "Invalid precipitation observation characteristic code : " + originalCode );
    }

    public String getOriginal_code() {
      return original_code;
    }

    public String getDescription() {
      return description;
    }


    @Override public String toString() {
      return "EObservationCharacteristicCode{" +
        "original_code='" + original_code + '\'' +
        ", description='" + description + '\'' +
        "} " + super.toString();
    }
  }

/*
 FLD LEN: 3
  PRECIPITATION-OBSERVATION-HISTORY identifier
  The identifier that indicates the occurrence of precipitation history information.
  DOM:  A specific domain comprised of the characters in the ASCII character set.
  AC1  An indicator of the following items:
  PRECIPITATION-OBSERVATION-HISTORY duration code
  PRECIPITATION-OBSERVATION-HISTORY characteristic code
  PRECIPITATION-OBSERVATION-HISTORY quality code

  FLD LEN: 1
  PRECIPITATION-OBSERVATION-HISTORY duration code
  The code that denotes the duration of precipitation.
  DOM:  A specific domain comprised of the characters in the ASCII character set.
    0 = Lasted less than 1 hour
                                          1 = Lasted 1 - 3 hours
                                          2 = Lasted 3 - 6 hours
                                          3 = Lasted more than 6 hours
                                          9 = Missing

  FLD LEN: 1
  PRECIPITATION-OBSERVATION-HISTORY characteristic code
  The code that denotes whether precipitation is continuous or intermittent.
  DOM:  A specific domain comprised of the characters in the ASCII character set.
  C = Continuous
    I = Intermittent
                         9 = Missing

  FLD LEN: 1
  PRECIPITATION duration/characteristic quality code
  The code that denotes a quality status of the reported PRECIPITATION duration/characteristic.
    DOM:  A specific domain comprised of the characters in the ASCII character set.
    0 = Passed gross limits check
                            1 = Passed all quality control checks
                            2 = Suspect
                            3 = Erroneous
                            9 = Passed gross limits check if element is present
    A = Data value flagged as suspect, but accepted as good value
  I = Data value not originally in data, but inserted by validator
    M = Manual change made to value based on information provided by NWS or FAA
  P = Data value not originally flagged as suspect, but replaced by validator
  R = Data value replaced with value computed by NCEI software
    U = Data value replaced with edited value


▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀
 */

}
