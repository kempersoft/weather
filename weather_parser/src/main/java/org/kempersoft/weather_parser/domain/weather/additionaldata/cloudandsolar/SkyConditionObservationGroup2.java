package org.kempersoft.weather_parser.domain.weather.additionaldata.cloudandsolar;


import org.kempersoft.weather_parser.WeatherStringReader;
import org.kempersoft.weather_parser.domain.weather.EQualityCode;
import org.kempersoft.weather_parser.domain.weather.WeatherReading;

public class SkyConditionObservationGroup2 {



  private String totalCoverageCode;
  private String totalOpaqueCoverageCode;
  private EQualityCode qualityTotalCoverageCode;
  private String totalLowestCloudCoverCode;
  private EQualityCode qualityTotalLowestCloudeCoverCode;
  private String lowCloudGenusCode;
  private EQualityCode qualityLowCloudGenusCode;
  private String lowestCloudBaseHeightDimension;
  private EQualityCode qualityLowestCloudBaseHeightDimension;
  private String midCloudGenusCode;
  private EQualityCode qualityMidCloudGenusCode;
  private String highCloudGenusCode;
  private EQualityCode qualityHighCloudGenusCode;

  public String getTotalCoverageCode() {
    return totalCoverageCode;
  }

  public void setTotalCoverageCode( String totalCoverageCode ) {
    this.totalCoverageCode = totalCoverageCode;
  }

  public String getTotalOpaqueCoverageCode() {
    return totalOpaqueCoverageCode;
  }

  public void setTotalOpaqueCoverageCode( String totalOpaqueCoverageCode ) {
    this.totalOpaqueCoverageCode = totalOpaqueCoverageCode;
  }

  public EQualityCode getQualityTotalCoverageCode() {
    return qualityTotalCoverageCode;
  }

  public void setQualityTotalCoverageCode( EQualityCode qualityTotalCoverageCode ) {
    this.qualityTotalCoverageCode = qualityTotalCoverageCode;
  }

  public String getTotalLowestCloudCoverCode() {
    return totalLowestCloudCoverCode;
  }

  public void setTotalLowestCloudCoverCode( String totalLowestCloudCoverCode ) {
    this.totalLowestCloudCoverCode = totalLowestCloudCoverCode;
  }

  public EQualityCode getQualityTotalLowestCloudeCoverCode() {
    return qualityTotalLowestCloudeCoverCode;
  }

  public void setQualityTotalLowestCloudeCoverCode(
    EQualityCode qualityTotalLowestCloudeCoverCode ) {
    this.qualityTotalLowestCloudeCoverCode = qualityTotalLowestCloudeCoverCode;
  }

  public String getLowCloudGenusCode() {
    return lowCloudGenusCode;
  }

  public void setLowCloudGenusCode( String lowCloudGenusCode ) {
    this.lowCloudGenusCode = lowCloudGenusCode;
  }

  public EQualityCode getQualityLowCloudGenusCode() {
    return qualityLowCloudGenusCode;
  }

  public void setQualityLowCloudGenusCode( EQualityCode qualityLowCloudGenusCode ) {
    this.qualityLowCloudGenusCode = qualityLowCloudGenusCode;
  }

  public String getLowestCloudBaseHeightDimension() {
    return lowestCloudBaseHeightDimension;
  }

  public void setLowestCloudBaseHeightDimension( String lowestCloudBaseHeightDimension ) {
    this.lowestCloudBaseHeightDimension = lowestCloudBaseHeightDimension;
  }

  public EQualityCode getQualityLowestCloudBaseHeightDimension() {
    return qualityLowestCloudBaseHeightDimension;
  }

  public void setQualityLowestCloudBaseHeightDimension(
    EQualityCode qualityLowestCloudBaseHeightDimension ) {
    this.qualityLowestCloudBaseHeightDimension = qualityLowestCloudBaseHeightDimension;
  }

  public String getMidCloudGenusCode() {
    return midCloudGenusCode;
  }

  public void setMidCloudGenusCode( String midCloudGenusCode ) {
    this.midCloudGenusCode = midCloudGenusCode;
  }

  public EQualityCode getQualityMidCloudGenusCode() {
    return qualityMidCloudGenusCode;
  }

  public void setQualityMidCloudGenusCode( EQualityCode qualityMidCloudGenusCode ) {
    this.qualityMidCloudGenusCode = qualityMidCloudGenusCode;
  }

  public String getHighCloudGenusCode() {
    return highCloudGenusCode;
  }

  public void setHighCloudGenusCode( String highCloudGenusCode ) {
    this.highCloudGenusCode = highCloudGenusCode;
  }

  public EQualityCode getQualityHighCloudGenusCode() {
    return qualityHighCloudGenusCode;
  }

  public void setQualityHighCloudGenusCode( EQualityCode qualityHighCloudGenusCode ) {
    this.qualityHighCloudGenusCode = qualityHighCloudGenusCode;
  }

  @Override public String toString() {
    return "SkyConditionObservationGroup2{" +
      "totalCoverageCode='" + totalCoverageCode + '\'' +
      ", totalOpaqueCoverageCode='" + totalOpaqueCoverageCode + '\'' +
      ", qualityTotalCoverageCode=" + qualityTotalCoverageCode +
      ", totalLowestCloudCoverCode='" + totalLowestCloudCoverCode + '\'' +
      ", qualityTotalLowestCloudeCoverCode=" + qualityTotalLowestCloudeCoverCode +
      ", lowCloudGenusCode='" + lowCloudGenusCode + '\'' +
      ", qualityLowCloudGenusCode=" + qualityLowCloudGenusCode +
      ", lowestCloudBaseHeightDimension='" + lowestCloudBaseHeightDimension + '\'' +
      ", qualityLowestCloudBaseHeightDimension=" + qualityLowestCloudBaseHeightDimension +
      ", midCloudGenusCode='" + midCloudGenusCode + '\'' +
      ", qualityMidCloudGenusCode=" + qualityMidCloudGenusCode +
      ", highCloudGenusCode='" + highCloudGenusCode + '\'' +
      ", qualityHighCloudGenusCode=" + qualityHighCloudGenusCode +
      '}';
  }


  public static void parseLine( WeatherReading reading, WeatherStringReader reader) throws Exception {

    String identifier = reader.getStringField(3);		// should be - GF1
    if (identifier == null || !identifier.startsWith("GF1")) {
      throw new Exception("Error :  In SkyConditionObservationGroup2 reading with an invalid code.  Should have GF1, got " + identifier);
    }
    // get the setting rate...
    SkyConditionObservationGroup2 observation = new SkyConditionObservationGroup2();
    observation.totalCoverageCode = reader.getStringField( 2 );
    observation.totalOpaqueCoverageCode = reader.getStringField( 2 );
    observation.qualityTotalCoverageCode = reader.getQualityCode( );
    observation.totalLowestCloudCoverCode = reader.getStringField( 2 );
    observation.qualityTotalLowestCloudeCoverCode = reader.getQualityCode( );
    observation.lowCloudGenusCode = reader.getStringField( 2 );
    observation.qualityLowCloudGenusCode = reader.getQualityCode( );
    observation.lowestCloudBaseHeightDimension = reader.getStringField( 5 );
    observation.qualityLowestCloudBaseHeightDimension = reader.getQualityCode( );
    observation.midCloudGenusCode = reader.getStringField( 2 );
    observation.qualityMidCloudGenusCode = reader.getQualityCode( );
    observation.highCloudGenusCode = reader.getStringField( 2 );
    observation.qualityHighCloudGenusCode = reader.getQualityCode( );
    reading.getAdditionalData().getCloudAndSolarReadings().setSkyConditionObservationGroup2( observation );
     }

	/*

FLD LEN: 3
              SKY-CONDITION-OBSERVATION identifier
              An indicator that denotes the start of a SKY‑CONDITION‑OBSERVATION data group.
              DOM:  A specific domain comprised of the characters in the ASCII character set.
                         GF1:    An indicator of the occurrence of the following data items:
                                     SKY-CONDITION-OBSERVATION total coverage code
                                     SKY-CONDITION-OBSERVATION total opaque coverage code
                                     SKY-CONDITION-OBSERVATION quality total coverage code
                                     SKY-CONDITION-OBSERVATION total lowest cloud cover code
                                     SKY-CONDITION-OBSERVATION quality total lowest cloud cover code
                                     SKY-CONDITION-OBSERVATION low cloud genus code
                                     SKY-CONDITION-OBSERVATION quality low cloud genus code
                                     SKY-CONDITION-OBSERVATION lowest cloud base height dimension
                                                     SKY-CONDITION-OBSERVATION lowest cloud base height quality code
                                     SKY-CONDITION-OBSERVATION mid cloud genus code
                                                     SKY-CONDITION-OBSERVATION quality mid cloud genus code
                                     SKY-CONDITION-OBSERVATION high cloud genus code
                                                     SKY-CONDITION-OBSERVATION quality high cloud genus code

FLD LEN: 2
              SKY‑CONDITION‑OBSERVATION total coverage code
              The code that denotes the fraction of the total celestial dome covered by clouds or other obscuring
              phenomena.
              DOM:  A specific domain comprised of the characters in the ASCII character set.
                                        00: None, SKC or CLR
                        01: One okta - 1/10 or less but not zero
                        02: Two oktas - 2/10 ‑ 3/10, or FEW
                        03: Three oktas - 4/10
                        04: Four oktas - 5/10, or SCT
                        05: Five oktas - 6/10
                        06: Six oktas - 7/10 ‑ 8/10
                        07: Seven oktas - 9/10 or more but not 10/10, or BKN
                        08: Eight oktas - 10/10, or OVC
                        09: Sky obscured, or cloud amount cannot be estimated
                        10: Partial obscuration
                        11: Thin scattered
        12: Scattered
        13: Dark scattered
        14: Thin broken
        15: Broken
        16: Dark broken
        17: Thin overcast
        18: Overcast
        19: Dark overcast
	        99: Missing

FLD LEN: 2
              SKY‑CONDITION‑OBSERVATION total opaque coverage code
              The code that denotes the fraction of the total celestial dome covered by opaque clouds or
              other obscuring phenomena.  Only reported by selected U.S. stations during selected periods.
              DOM:  A specific domain comprised of the characters in the ASCII character set.
                                        00: None, SKC or CLR
                        01: One okta - 1/10 or less but not zero
                        02: Two oktas - 2/10 ‑ 3/10, or FEW
                        03: Three oktas - 4/10
                        04: Four oktas - 5/10, or SCT
                        05: Five oktas - 6/10
                        06: Six oktas - 7/10 ‑ 8/10
                        07: Seven oktas - 9/10 or more but not 10/10, or BKN
                        08: Eight oktas - 10/10, or OVC
                        09: Sky obscured, or cloud amount cannot be estimated
                        10: Partial obscuration
                        12: Scattered
                        13: Dark scattered
                        15: Broken
                        16: Dark broken
                        18: Overcast
                        19: Dark overcast
                         99: Missing

FLD LEN: 1
               SKY-CONDITION-OBSERVATION quality total coverage code
               The code that denotes a quality status of a reported total sky coverage code.
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

FLD LEN: 2
              SKY-CONDITION-OBSERVATION total lowest cloud cover code
              The code that represents the fraction of the celestial dome covered by all low clouds present.  If
              no low clouds are present; the code denotes the fraction covered by all middle level clouds present.
              DOM:  A specific domain comprised of the characters in the ASCII character set.
                        00: None
                        01: One okta or 1/10 or less but not zero
                        02: Two oktas or 2/10 ‑ 3/10
                        03: Three oktas or 4/10
                        04: Four oktas or 5/10
                        05: Five oktas or 6/10
                        06: Six oktas or 7/10 ‑ 8/10
                        07: Seven oktas or 9/10 or more but not 10/10
                        08: Eight oktas or 10/10
                        09: Sky obscured, or cloud amount cannot be estimated
                        10: Partial obscuration
                        11: Thin Scattered
                        12: Scattered
                        13: Dark Scattered
                        14: Thin Broken
                        15: Broken
                        16: Dark Broken
                        17: Thin Overcast
                        18: Overcast
                        19: Dark overcast
                        99: Missing

FLD LEN: 1
               SKY-CONDITION-OBSERVATION quality total lowest cloud cover code
               The code that denotes a quality status of a reported total lowest cloud cover code.
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

FLD LEN: 2
              SKY-CONDITION-OBSERVATION low cloud genus code
              The code that denotes a type of low cloud.
              DOM:  A specific domain comprised of the characters in the ASCII Character set.
                         00: No low clouds
                         01: Cumulus humulis or Cumulus fractus other than of bad weather or both
                         02: Cumulus mediocris or congestus, with or without Cumulus of species  fractus or humulis or 
                               Stratocumulus all having bases at the same level
                         03: Cumulonimbus calvus, with or without Cumulus, Stratocumulus or Stratus
                         04: Stratocumulus cumulogenitus
                         05: Stratocumulus other than Stratocumulus cumulogenitus
                         06: Stratus nebulosus or Stratus fractus other than of bad weather, or both
                         07: Stratus fractus or Cumulus fractus of bad weather, or both (pannus) usually below
                               Altostratus or Nimbostratus
                         08: Cumulus and Stratocumulus other than Stratocumulus cumulogenitus, with bases at
                               different levels
                         09: Cumulonimbus capillatus (often with an anvil), with or without Cumulonimbus calvus,
                               Cumulus, Stratocumulus, Stratus or pannus
                         99: Missing

FLD LEN: 1
               SKY-CONDITION-OBSERVATION quality low cloud genus code
               The code that denotes a quality status of a reported low cloud type.
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

FLD LEN: 5
              SKY-CONDITION-OBSERVATION lowest cloud base height dimension
              The height, above ground level (AGL), of the base of the lowest cloud.
              MIN:  -0400        MAX:  15000      UNITS:  Meters
                              SCALING FACTOR:  1
              DOM:  A general domain comprised of the numeric characters (0‑9).
                         99999 = Missing.

FLD LEN: 1
               SKY-CONDITION-OBSERVATION lowest cloud base height quality code
               The code that denotes a quality status of a lowest cloud base height.
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

FLD LEN: 2
              SKY-CONDITION-OBSERVATION mid cloud genus code
              The code that denotes a type of middle level cloud.
              DOM:  A specific domain comprised of the characters in the ASCII character set.
                         00: No middle clouds
                         01: Altostratus translucidus
                         02: Altostratus opacus or Nimbostratus
                         03: Altocumulus translucidus at a single level
                         04: Patches (often lenticular) of Altocumulus translucidus, continually changing and occurring
                               at one or more levels
                         05: Altocumulus translucidus in bands, or one or more layers of Altocumulus translucidus or
                               opacus, progressively invading the sky;  these Altocumulus clouds generally thicken as a
                               whole
                         06: Altocumulus cumulogentis (or cumulonimbogentus)
                         07: Altocumulus translucidus or opacus in two or more layers, or Altocumulus opacus in a
                               single layer, not progressively invading the sky, or Altocumulus with Altostratus or
                               Nimbostratus
                         08: Altocumulus castellanus or floccus
                         09: Altocumulus of a chaotic sky; generally at several levels
                         99: Missing

FLD LEN: 1
               SKY-CONDITION-OBSERVATION quality mid cloud genus code
               The code that denotes a quality status of a reported mid cloud type.
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

FLD LEN: 2
              SKY-CONDITION-OBSERVATION high cloud genus code
              The code that denotes a type of high cloud.
              DOM:  A specific domain comprised of the characters in the ASCII character set.
                         00: No High Clouds
                         01: Cirrus fibratus, sometimes uncinus, not progressively invading the sky
                         02: Cirrus spissatus, in patches or entangled sheaves, which usually do not increase and
                               sometimes seem to be the remains of the upper part  of a Cumulonimbus; or Cirrus
                               castellanus or floccus
                         03: Cirrus spissatus cumulonimbogenitus
                         04: Cirrus unicinus or fibratus, or both, progressively invading the sky; they generally thicken as
                               a whole
                         05: Cirrus (often in bands) and Cirrostratus, or Cirrostratus alone, progressively invading the
                               sky; they generally thicken as a whole, but the continuous veil does not reach 45 degrees
                               above the horizon
                         06: Cirrus (often in bands) and Cirrostratus, or Cirrostratus alone, progressively invading the
                               sky; they generally thicken as a whole; the continuous veil extends more than 45 degrees
                               above the horizon, without the sky being totally covered.
                         07: Cirrostratus covering the whole sky
                         08: Cirrostratus not progressively invading the sky and not entirely covering it
                         09: Cirrocumulus alone, or Cirrocumulus predominant among the High clouds
                         99: Missing

FLD LEN: 1
               SKY-CONDITION-OBSERVATION quality high cloud genus code
               The code that denotes a quality status of a reported high cloud type.
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

▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀          
 
	 */
}
