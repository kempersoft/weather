package org.kempersoft.weather_parser.domain.weather.additionaldata.cloudandsolar;

import org.kempersoft.weather_parser.WeatherStringReader;
import org.kempersoft.weather_parser.domain.weather.EQualityCode;
import org.kempersoft.weather_parser.domain.weather.WeatherReading;

import java.util.ArrayList;
import java.util.List;

public class SkyCoverLayer {

	
	public String getCoverageLayer() {
		return coverageLayer;
	}
	public void setCoverageLayer(String coverageLayer) {
		this.coverageLayer = coverageLayer;
	}
	public EQualityCode getCoverageLayerQuality() {
		return coverageLayerQuality;
	}
	public void setCoverageLayerQuality(EQualityCode coverageLayerQuality) {
		this.coverageLayerQuality = coverageLayerQuality;
	}
	public Double getBaseHeight() {
		return baseHeight;
	}
	public void setBaseHeight(Double baseHeight) {
		this.baseHeight = baseHeight;
	}
	public EQualityCode getBaseHeightQualityCode() {
		return baseHeightQualityCode;
	}
	public void setBaseHeightQualityCode(EQualityCode baseHeightQualityCode) {
		this.baseHeightQualityCode = baseHeightQualityCode;
	}
	public String getCloudTypeCode() {
		return cloudTypeCode;
	}
	public void setCloudTypeCode(String cloudTypeCode) {
		this.cloudTypeCode = cloudTypeCode;
	}
	public String getCloudTypeQuality() {
		return cloudTypeQuality;
	}
	public void setCloudTypeQuality(String cloudTypeQuality) {
		this.cloudTypeQuality = cloudTypeQuality;
	}

	public static void parseLine( WeatherReading reading, WeatherStringReader reader) throws Exception {
		
		String identifier = reader.getStringField(3);		// should be - MA1
		if (identifier == null || !identifier.startsWith("GA")) {
			throw new Exception("Error :  In SkyCoverLayer reading with an invalid code.  Should have GA1 - 6, got " + identifier);
		}
		// get the setting rate...
		SkyCoverLayer layer = new SkyCoverLayer();
		layer.coverageLayer = reader.getStringField(2);
		layer.coverageLayerQuality = reader.getQualityCode();
		layer.baseHeight = reader.getDoubleValue(6, "+99999", null);
		layer.baseHeightQualityCode = reader.getQualityCode();
		layer.cloudTypeCode = reader.getStringField(2);
		layer.coverageLayerQuality = reader.getQualityCode();
		List<SkyCoverLayer> layers = reading.getAdditionalData().getCloudAndSolarReadings().getSkyCoverLayers();
		if (layers == null) {
			layers = new ArrayList<>();
			reading.getAdditionalData().getCloudAndSolarReadings().setSkyCoverLayers(layers);
		}
		layers.add(layer);
	}

	private String coverageLayer;
	private EQualityCode coverageLayerQuality;
	private Double baseHeight;
	private EQualityCode baseHeightQualityCode;
	private String cloudTypeCode;
	private String cloudTypeQuality;

	
	
	
	/*	
	FLD LEN: 3
    SKY-COVER-LAYER identifier
    The identifier that represents a SKY-COVER-LAYER.
    DOM:  A specific domain comprised of the characters in the ASCII character set.
               GA1-GA6    An indicator of up to 6 repeating fields of the following items:
                                   SKY-COVER-LAYER coverage code
                                   SKY-COVER-LAYER coverage quality code
                                   SKY-COVER-LAYER base height dimension
                                   SKY-COVER-LAYER base height quality code
                                   SKY-COVER-LAYER cloud type code
                                   SKY-COVER-LAYER cloud type quality code

FLD LEN: 2
    SKY-COVER-LAYER coverage code
    The code that denotes the fraction of the total celestial dome covered by a SKY-COVER-LAYER.
    Note:  This is for a discrete cloud layer, as opposed to the cloud later summation data in the GD1-GD6 section.
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
              99: Missing

FLD LEN: 1
      SKY-COVER-LAYER coverage quality code
      The code that denotes a quality status of the reported SKY-COVER-LAYER coverage.
      DOM:  A specific domain comprised of the characters in the ASCII character set.
                  0 = Passed gross limits check 
                  1 = Passed all quality control checks
                  2 = Suspect
                  3 = Erroneous
                  4 = Passed gross limits check , from NCEI SURFACE HOURLY
                  5 = Passed all quality control checks, from NCEI SURFACE HOURLY
                  6 = Suspect, from NCEI SURFACE HOURLY
                  7 = Erroneous, from NCEI SURFACE HOURLY
                  M = Manual change made to value based on information provided by NWS or FAA   
                  9 = Passed gross limits check if element is present
FLD LEN: 6
     SKY-COVER-LAYER base height dimension
                              The height relative to a VERTICAL-REFERENCE-DATUM of the lowest surface of a cloud.
      MIN:  -00400      MAX:  +35000       UNITS:  Meters
                              SCALING FACTOR:  1
     DOM:  A general domain comprised of the numeric characters (0‑9), a plus sign (+), and a minus sign (‑).
              +99999 = Missing

FLD LEN: 1
      SKY-COVER-LAYER base height quality code
      The code that denotes a quality status of the reported SKY-COVER-LAYER base height.
      DOM:  A specific domain comprised of the characters in the ASCII character set.
                  0 = Passed gross limits check 
                  1 = Passed all quality control checks
                  2 = Suspect
                  3 = Erroneous
                  4 = Passed gross limits check , from NCEI SURFACE HOURLY
                  5 = Passed all quality control checks, from NCEI SURFACE HOURLY
                  6 = Suspect, from NCEI SURFACE HOURLY
                  7 = Erroneous, from NCEI SURFACE HOURLY
                  M = Manual change made to value based on information provided by NWS or FAA
  9 = Passed gross limits check if element is present

FLD LEN: 2
    SKY-COVER-LAYER cloud type code 
    The code that denotes the classification of the clouds that comprise a SKY-COVER-LAYER.
    DOM:  A specific domain comprised of the characters in the ASCII character set.
               00: Cirrus (Ci)
               01: Cirrocumulus (Cc)
               02: Cirrostratus (Cs)
               03: Altocumulus (Ac)
               04: Altostratus (As)
               05: Nimbostratus (Ns)
               06: Stratocumulus (Sc)
               07: Stratus (St)
               08: Cumulus (Cu)
               09: Cumulonimbus (Cb)
               10: Cloud not visible owing to darkness, fog, duststorm, sandstorm, or other analogous
                     phenomena / sky obscured
               11: Not used
               12: Towering Cumulus (Tcu)
               13: Stratus fractus (Stfra)
               14: Stratocumulus Lenticular (Scsl)
               15: Cumulus Fractus (Cufra)
               16: Cumulonimbus Mammatus (Cbmam)
               17: Altocumulus Lenticular (Acsl)
               18: Altocumulus Castellanus (Accas)
               19: Altocumulus Mammatus (Acmam)
               20: Cirrocumulus Lenticular (Ccsl)
               21: Cirrus and/or Cirrocumulus
               22: Stratus and/or Fracto-stratus
               23: Cumulus and/or Fracto-cumulus
               99: Missing

FLD LEN: 1
      SKY-COVER-LAYER cloud type quality code
      The code that denotes a quality status of the reported SKY-COVER-LAYER cloud type.
      DOM:  A specific domain comprised of the characters in the ASCII character set.
                  0 = Passed gross limits check 
                  1 = Passed all quality control checks
                  2 = Suspect
                  3 = Erroneous
                  4 = Passed gross limits check , from NCEI SURFACE HOURLY
                  5 = Passed all quality control checks, from NCEI SURFACE HOURLY
                  6 = Suspect, from NCEI SURFACE HOURLY
                  7 = Erroneous, from NCEI SURFACE HOURLY
                  M = Manual change made to value based on information provided by NWS or FAA 
  9 = Passed gross limits check if element is present
*/
}
