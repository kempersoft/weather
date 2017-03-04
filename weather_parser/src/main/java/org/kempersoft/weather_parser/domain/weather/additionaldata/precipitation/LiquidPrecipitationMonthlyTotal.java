package org.kempersoft.weather_parser.domain.weather.additionaldata.precipitation;

import org.kempersoft.weather_parser.WeatherStringReader;
import org.kempersoft.weather_parser.domain.weather.EQualityCode;
import org.kempersoft.weather_parser.domain.weather.WeatherReading;

/**
 * Created by bkemper on 3/3/17.
 */
public class LiquidPrecipitationMonthlyTotal {

  private Double totalDepthInMillimeters;
  private EMonthlyTotalConditionCode conditionCode;
  private EQualityCode qualityCode;

  public static void parseLine( WeatherReading reading, WeatherStringReader reader ) throws Exception {

    String identifier = reader.getStringField( 3 );    // should be - AA1-AA4
    if ( identifier == null || !identifier.startsWith( "AB1" ) ) {
      throw new Exception(
        "Error :  In LiquidPrecipitationMontlyTotal reading with an invalid code.  Should have AB1 - got "
          + identifier );
    }
    LiquidPrecipitationMonthlyTotal precipitationMonthlyTotal = new LiquidPrecipitationMonthlyTotal();
    precipitationMonthlyTotal.totalDepthInMillimeters = reader.getDoubleValue( 5, "99999", 10.0 );
    String totalCode = reader.getStringField( 1 );
    if ( totalCode != null ) {
      precipitationMonthlyTotal.conditionCode = EMonthlyTotalConditionCode.toMonthlyTotalConditionCode( totalCode );
    }
    precipitationMonthlyTotal.qualityCode = reader.getQualityCode();             // quality code...

    AdditionalDataPrecipitation precipitation = reading.getAdditionalData().getPrecipitationReadings();
    precipitation.setLiquidPrecipitationMonthlyTotal( precipitationMonthlyTotal );
  }

  @Override public String toString() {
    return "LiquidPrecipitationMonthlyTotal{" +
      "totalDepthInMillimeters=" + totalDepthInMillimeters +
      ", conditionCode=" + conditionCode +
      ", qualityCode=" + qualityCode +
      '}';
  }

  private enum EMonthlyTotalConditionCode {
    C1( "1", "Measurement impossible or inaccurate" ),
    C2( "2", "Trace" ),
    C9( "9", "Missing" );

    private String original_code;
    private String description;


    private EMonthlyTotalConditionCode( String original_code, String description ) {
      this.original_code = original_code;
      this.description = description;
    }

    public static EMonthlyTotalConditionCode toMonthlyTotalConditionCode( String originalCode ) throws Exception {
      if ( originalCode == null || originalCode.isEmpty() ) {
        throw new Exception( "Invalid monthly total condition code : " + originalCode );
      }
      for ( EMonthlyTotalConditionCode code : values() ) {
        if ( code.original_code.equals( originalCode ) ) {
          return code;
        }
      }
      throw new Exception( "Invalid Monthly Total Condition Code : " + originalCode );
    }

    public String getOriginal_code() {
      return original_code;
    }

    public String getDescription() {
      return description;
    }

    @Override public String toString() {
      return "EMonthlyTotalConditionCode{" +
        "original_code='" + original_code + '\'' +
        ", description='" + description + '\'' +
        "} " + super.toString();
    }
  }

/*
  FLD LEN: 3
  LIQUID-PRECIPITATION MONTHLY TOTAL identifier
  The identifier that represents LIQUID-PRECIPITATION MONTHLY TOTAL data.
  DOM: A specific domain comprised of the characters in the ASCII character set.
  AB1   An indicator of the following items:
  LIQUID-PRECIPITATION depth dimension
  LIQUID-PRECIPITATION condition code
  LIQUID-PRECIPITATION quality code

  FLD LEN: 5
  LIQUID-PRECIPITATION MONTHLY TOTAL depth dimension
  The depth of LIQUID-PRECIPITATION for the month.
  MIN:  00000        MAX:  50000         UNITS:  millimeters
  SCALING FACTOR: 10
  DOM:  A general domain comprised of the numeric characters (0‑9).
    99999 = Missing.

  FLD LEN: 1
  LIQUID-PRECIPITATION MONTHLY TOTAL condition code
  The code that denotes whether a LIQUID-PRECIPITATION depth dimension was a trace value.
    DOM:  A specific domain comprised of the characters in the ASCII character set.
    1: Measurement impossible or inaccurate
                         2: Trace
                                         9: Missing

  FLD LEN: 1
  LIQUID-PRECIPITATION MONTHLY TOTAL quality code
  The code that denotes a quality status of the reported LIQUID-PRECIPITATION data.
  DOM:  A specific domain comprised of the characters in the ASCII character set.
    0 = Passed gross limits check
                            1 = Passed all quality control checks
                            2 = Suspect
                            3 = Erroneous
                            4 = Passed gross limits check , data originate from an NCEI data source
                            5 = Passed all quality control checks, data originate from an NCEI data source
                            6 = Suspect, data originate from an NCEI data source
                            7 = Erroneous, data originate from an NCEI data source
                            9 = Passed gross limits check if element is present
    A = Data value flagged as suspect, but accepted as good value
  I = Data value not originally in data, but inserted by validator
    M = Manual change made to value based on information provided by NWS or FAA
  P = Data value not originally flagged as suspect, but replaced by validator
  R = Data value replaced with value computed by NCEI software
    U = Data value replaced with edited value

*/
}
