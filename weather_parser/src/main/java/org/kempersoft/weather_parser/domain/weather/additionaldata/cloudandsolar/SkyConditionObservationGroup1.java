package org.kempersoft.weather_parser.domain.weather.additionaldata.cloudandsolar;


import org.kempersoft.weather_parser.WeatherStringReader;
import org.kempersoft.weather_parser.domain.weather.WeatherReading;

public class SkyConditionObservationGroup1 {

  private String convectiveCloudAttribute;
  private String verticalDatumAttribute;
  private Double baseHeightUpperRangeAttributeMeters;
  private Double baseHeightLowerRangeAttributeMeters;

  public String getConvectiveCloudAttribute() {
    return convectiveCloudAttribute;
  }

  public void setConvectiveCloudAttribute( String convectiveCloudAttribute ) {
    this.convectiveCloudAttribute = convectiveCloudAttribute;
  }

  public String getVerticalDatumAttribute() {
    return verticalDatumAttribute;
  }

  public void setVerticalDatumAttribute( String verticalDatumAttribute ) {
    this.verticalDatumAttribute = verticalDatumAttribute;
  }

  public Double getBaseHeightUpperRangeAttributeMeters() {
    return baseHeightUpperRangeAttributeMeters;
  }

  public void setBaseHeightUpperRangeAttributeMeters( Double baseHeightUpperRangeAttributeMeters ) {
    this.baseHeightUpperRangeAttributeMeters = baseHeightUpperRangeAttributeMeters;
  }

  public Double getBaseHeightLowerRangeAttributeMeters() {
    return baseHeightLowerRangeAttributeMeters;
  }

  public void setBaseHeightLowerRangeAttributeMeters( Double baseHeightLowerRangeAttributeMeters ) {
    this.baseHeightLowerRangeAttributeMeters = baseHeightLowerRangeAttributeMeters;
  }

  @Override public String toString() {
    return "SkyConditionObservationGroup1{" +
      "convectiveCloudAttribute='" + convectiveCloudAttribute + '\'' +
      ", verticalDatumAttribute='" + verticalDatumAttribute + '\'' +
      ", baseHeightUpperRangeAttributeMeters=" + baseHeightUpperRangeAttributeMeters +
      ", baseHeightLowerRangeAttributeMeters=" + baseHeightLowerRangeAttributeMeters +
      '}';
  }

  public static void parseLine( WeatherReading reading, WeatherStringReader reader ) throws Exception {

    String identifier = reader.getStringField( 3 );    // should be - GE1
    if ( identifier == null || !identifier.startsWith( "GE1" ) ) {
      throw new Exception(
        "Error :  In SkyConditionObservationGroup1 reading with an invalid code.  Should have GE1, got " + identifier );
    }
    // get the setting rate...
    SkyConditionObservationGroup1 observation = new SkyConditionObservationGroup1();
    observation.convectiveCloudAttribute = reader.getStringField( 1 );
    observation.verticalDatumAttribute = reader.getStringField( 6 );
    observation.baseHeightLowerRangeAttributeMeters = reader.getDoubleValue( 6, "+99999", 1.0 );
    observation.baseHeightUpperRangeAttributeMeters = reader.getDoubleValue( 6, "+99999", 1.0 );
    reading.getAdditionalData().getCloudAndSolarReadings().setSkyConditionObservationGroup1( observation );
  }
/*
    
FLD LEN: 3
              SKY-CONDITION-OBSERVATION identifier
              An indicator that denotes the start of a SKY‑CONDITION‑OBSERVATION data group.
              DOM:  A specific domain comprised of the characters in the ASCII character set.
                         GE1:    An indicator of the occurrence of the following data items:
                                     SKY-CONDITION-OBSERVATION convective cloud attribute
                                     SKY-CONDITION-OBSERVATION vertical datum attribute
                                                     SKY-CONDITION-OBSERVATION base height upper range attribute
                                     SKY-CONDITION-OBSERVATION base height lower range attribute

FLD LEN: 1
              SKY‑CONDITION‑OBSERVATION convective cloud attribute
              The code that denotes the convective cloud type in an observation.

              DOM:  A specific domain comprised of the characters in the ASCII character set.
                                        0: None
                        1: ACSL (Altocumulus Standing Lenticular)
                        2: ACCAS (Altocumulus Castelanus)
                        3: TCU (Towering Cumulus)
                        4: MDT CU (Moderate Cumulus)
                        5: CB/CB MAM DISTANT (Cumulonimbus or Cumulonimbus Mammatus in the distance)
                        6: CB/CBMAM (Cumulonimbus or Cumulonimbus Mammatus within 20 nautical miles)
                        7: Unknown
                        9: missing
FLD LEN: 6
              SKY‑CONDITION‑OBSERVATION vertical datum attribute
              The code that represents a VERTICAL-REFERENCE-DATUM. Under the stewardship of the FDAD for Intelligence. 

              DOM:  A specific domain comprised of the characters in the ASCII character set.
                                        
                        AGL: Above Ground Level
                        ALAT: Approximate lowest astronomical tide
                        AP: Apparent
                        CFB: Crest of first berm
                        CRD: Columbia River datum
                        ESLW: Equatorial Spring low water
                        GCLWD: Gulf Coast low water datum
                        HAT: Highest astronomical tide
                        HHW: Higher high water
                        HTWW: High tide wave wash
                        HW: High water
                        HWFC: High water full and change
                        IND: Indefinite
                         ISLW: Indian Spring low water
                         LAT: Lowest astronomical tide
                         LLW: Lowest low water
                         LNLW: Lowest normal low water
                         LRLW: Lower low water
                         LSD: Land survey datum
                         LW: Low water
                         LWD: Low water datum
                         LWFC: Low water full and charge
                         MHHW: Mean higher high water
                         MHLW: Mean higher low water
                         MHW: Mean high water
                         MHWN: Mean high water neap
                         MHWS: Mean high water spring
                         MLHW: Mean lower high water
                         MLLW: Mean lower low water
                         MLLWS: Mean lower low water springs
                         MLWN: Mean low water neap
                         MLW: Mean low water
                         MLWS: Mean low water spring
                         MSL: Mean sea level
                         MTL: Mean tide level
                         NC: No correction
                         NT: Neap tide
                         ST: Spring tide
                         SWA: Storm wave action
                         TLLW: Tropic lower low water
                         UD: Undetermined
                         UK: Unknown
                         WGS84E: WGS84 Ellispoid
                         WGS84G: WGS84 GEOID
                         999999: missing

FLD LEN: 6
              SKY‑CONDITION‑OBSERVATION base height upper range attribute
              The height relative to a VERTICAL-REFERENCE-DATUM for cloud bases reported in a range or the highest
              height for a                     variable cloud height report. The concept of a range is to accommodate
               the WMO practice of reporting a cloud layer by a                    range of heights.

                MIN:  -0400                  MAX:  +15000                 UNITS:  meters
                DOM:  A general domain compirsed of the ASCII characters 0-9, a plus (+) and a minus sign (-).
                           +99999 = Missing

FLD LEN: 6
              SKY‑CONDITION‑OBSERVATION base height lower range attribute
              The height relative to a VERTICAL-REFERENCE-DATUM for cloud bases reported in a range or lowest height
              for a                            variable cloud height report. The concept of a range is to accommodate
               the WMO practice of reporting a cloud layer by a                    range of heights.

                MIN:  -0400                  MAX:  +15000                 UNITS:  meters
                DOM:  A general domain compirsed of the ASCII characters 0-9, a plus (+) and a minus sign (-).
                           +99999 = Missing


▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀
*/

}
