package org.kempersoft.weather_parser.domain.weather.additionaldata.precipitation;

import org.kempersoft.weather_parser.WeatherStringReader;
import org.kempersoft.weather_parser.domain.weather.EQualityCode;
import org.kempersoft.weather_parser.domain.weather.WeatherReading;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bkemper on 3/3/17.
 */
public class LiquidPrecipitationOccurence {

  private Integer periodInHours;
  private Double depthInMillimeters;
  private EPrecipitationConditionCode conditionCode;
  private EQualityCode qualityCode;

  public static void parseLine( WeatherReading reading, WeatherStringReader reader) throws Exception {

    String identifier = reader.getStringField(3);		// should be - AA1-AA4
    if (identifier == null || !identifier.startsWith("AA")) {
      throw new Exception("Error :  In LiquidPrecipitationOccurence reading with an invalid code.  Should have AA1 - 4, got " + identifier);
    }
    LiquidPrecipitationOccurence precipitationOccurence = new LiquidPrecipitationOccurence( );
    precipitationOccurence.periodInHours = reader.getIntField( 2, "99") ;    // time period (number of hours)
    precipitationOccurence.depthInMillimeters = reader.getDoubleValue( 4, "9999" , 10.0);    // depth (millimeters)
    String precipCode = reader.getStringField( 1 );
    if (precipCode != null) {
      precipitationOccurence.conditionCode =  EPrecipitationConditionCode.toPrecipitationConditionCode( precipCode ) ;
    }
    precipitationOccurence.qualityCode = reader.getQualityCode( );             // quality code...

    AdditionalDataPrecipitation precipitation = reading.getAdditionalData().getPrecipitationReadings();
    List<LiquidPrecipitationOccurence> occurences = precipitation.getLiquidPrecipitationOccurences();
    if (occurences == null) {
      occurences = new ArrayList<>(  );
      precipitation.setLiquidPrecipitationOccurences( occurences );
    }
    occurences.add( precipitationOccurence );
  }

  public Integer getPeriodInHours() {
    return periodInHours;
  }

  public void setPeriodInHours( Integer periodInHours ) {
    this.periodInHours = periodInHours;
  }

  public Double getDepthInMillimeters() {
    return depthInMillimeters;
  }

  public void setDepthInMillimeters( Double depthInMillimeters ) {
    this.depthInMillimeters = depthInMillimeters;
  }

  public EPrecipitationConditionCode getConditionCode() {
    return conditionCode;
  }

  public void setConditionCode( EPrecipitationConditionCode conditionCode ) {
    this.conditionCode = conditionCode;
  }

  public EQualityCode getQualityCode() {
    return qualityCode;
  }

  public void setQualityCode( EQualityCode qualityCode ) {
    this.qualityCode = qualityCode;
  }

  @Override public String toString() {
    return "LiquidPrecipitationOccurence{" +
      "periodInHours=" + periodInHours +
      ", depthInMillimeters=" + depthInMillimeters +
      ", conditionCode=" + conditionCode +
      ", qualityCode=" + qualityCode +
      '}';
  }

/*
  FLD LEN: 3
  LIQUID-PRECIPITATION occurrence identifier
  The identifier that represents an episode of LIQUID-PRECIPITATION.
    DOM: A specific domain comprised of the characters in the ASCII character set.
  AA1 - AA4   An indicator of up to 4 repeating fields of the following items:
  LIQUID-PRECIPITATION period quantity
  LIQUID-PRECIPITATION depth dimension
  LIQUID-PRECIPITATION condition code
  LIQUID-PRECIPITATION quality code

  FLD LEN: 2
  LIQUID-PRECIPITATION period quantity in hours
  The quantity of time over which the LIQUID-PRECIPITATION was measured.
    MIN:  00         MAX:  98        UNITS:  Hours
  SCALING FACTOR:  1
  DOM:  A specific domain comprised of the characters in the ASCII character set
                           99 = Missing.

  FLD LEN: 4
  LIQUID-PRECIPITATION depth dimension
  The depth of LIQUID-PRECIPITATION that is measured at the time of an observation.
  MIN:  0000        MAX:  9998         UNITS:  millimeters
  SCALING FACTOR: 10
  DOM:  A general domain comprised of the numeric characters (0‑9).
    9999 = Missing.

  FLD LEN: 1
  LIQUID-PRECIPITATION condition code
  The code that denotes whether a LIQUID-PRECIPITATION depth dimension was a trace value.
    DOM:  A specific domain comprised of the characters in the ASCII character set.
    1: Measurement impossible or inaccurate
                         2: Trace
                         3: Begin accumulated period (precipitation amount missing until end of accumulated period)
                         4: End accumulated period
                         5: Begin deleted period (precipitation amount missing due to data problem)
                         6: End deleted period
                         7: Begin missing period
                         8: End missing period
  E: Estimated data value (eg, from nearby station)
                                          I:  Incomplete precipitation amount, excludes one or more missing reports, such as one or more 15-minute                                              reports not included in the 1-hour precipitation total   
                             J:  Incomplete precipitation amount, excludes one or more erroneous reports, such as one or more 1-hour                                               precipitation amounts excluded from the 24-hour total  
    9: Missing

  FLD LEN: 1
  LIQUID-PRECIPITATION quality code
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

  public enum EPrecipitationConditionCode {

    C1( "1", "Measurement impossible or inaccurate" ),
    C2( "2", "Trace" ),
    C3( "3", "Begin accumulated period (precipitation amount missing until end of accumulated period)" ),
    C4( "4", "End accumulated period" ),
    C5( "5", "Begin deleted period (precipitation amount missing due to data problem)" ),
    C6( "6", "End deleted period" ),
    C7( "7", "Begin missing period" ),
    C8( "8", "End missing period" ),
    CE( "E", "Estimated data value (eg, from nearby station)" ),
    CI( "I",
      "Incomplete precipitation amount, excludes one or more missing reports, such as one or more 15-minute reports not"
        + " included in the 1-hour precipitation total" ),
    CJ( "J",
      "Incomplete precipitation amount, excludes one or more erroneous reports, such as one or more 1-hour "
        + "precipitation amounts excluded from the 24-hour total" ),
    C9( "9", "Missing" );

    public String getOriginal_code() {
      return original_code;
    }

    public String getDescription() {
      return description;
    }


    private String original_code;
    private String description;

    private EPrecipitationConditionCode( String original_code, String description ) {
      this.original_code = original_code;
      this.description = description;
    }

    public static EPrecipitationConditionCode toPrecipitationConditionCode( String originalCode ) throws Exception {
      if ( originalCode == null || originalCode.isEmpty() ) {
        throw new Exception( "Invalid observation type : " + originalCode );
      }
      for ( EPrecipitationConditionCode code : EPrecipitationConditionCode.values() ) {
        if ( code.original_code.equals( originalCode ) ) {
          return code;
        }
      }
      throw new Exception( "Invalid Precipitation Condition Code : " + originalCode );
    }


    @Override public String toString() {
      return "EPrecipitationConditionCode{" +
        "original_code='" + original_code + '\'' +
        ", description='" + description + '\'' +
        "} " + super.toString();
    }
  }
}
