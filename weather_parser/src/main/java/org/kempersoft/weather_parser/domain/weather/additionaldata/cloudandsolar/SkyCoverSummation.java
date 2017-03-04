package org.kempersoft.weather_parser.domain.weather.additionaldata.cloudandsolar;

import org.kempersoft.weather_parser.WeatherStringReader;
import org.kempersoft.weather_parser.domain.weather.EQualityCode;
import org.kempersoft.weather_parser.domain.weather.WeatherReading;

import java.util.ArrayList;
import java.util.List;

public class SkyCoverSummation {

	
	
	public String getCoverageCode() {
		return coverageCode;
	}
	public void setCoverageCode(String coverageCode) {
		this.coverageCode = coverageCode;
	}
	public String getCoverageCodeOktas() {
		return coverageCodeOktas;
	}
	public void setCoverageCodeOktas(String coverageCodeOktas) {
		this.coverageCodeOktas = coverageCodeOktas;
	}
	public EQualityCode getCoverageCodeQualityCode() {
		return coverageCodeQualityCode;
	}
	public void setCoverageCodeQualityCode(EQualityCode coverageCodeQualityCode) {
		this.coverageCodeQualityCode = coverageCodeQualityCode;
	}
	public Double getHeight() {
		return height;
	}
	public void setHeight(Double height) {
		this.height = height;
	}
	public EQualityCode getHeightQualityCode() {
		return heightQualityCode;
	}
	public void setHeightQualityCode(EQualityCode heightQualityCode) {
		this.heightQualityCode = heightQualityCode;
	}
	public String getCharacteristicCode() {
		return characteristicCode;
	}
	public void setCharacteristicCode(String characteristicCode) {
		this.characteristicCode = characteristicCode;
	}
	public static void parseLine( WeatherReading reading, WeatherStringReader reader) throws Exception {
		
		String identifier = reader.getStringField(3);		// should be - MA1
		if (identifier == null || !identifier.startsWith("GD")) {
			throw new Exception("Error :  In SkyCoverSummation reading with an invalid code.  Should have GD1 - 6, got " + identifier);
		}
		// get the setting rate...
		SkyCoverSummation summation = new SkyCoverSummation();
		summation.coverageCode = reader.getStringField(1);
		summation.coverageCodeOktas = reader.getStringField(2);
		summation.coverageCodeQualityCode = reader.getQualityCode();
		summation.height = reader.getDoubleValue(6,  "+99999",  null);
		summation.heightQualityCode = reader.getQualityCode();
		summation.characteristicCode = reader.getStringField(1);
		List<SkyCoverSummation> summations = reading.getAdditionalData().getCloudAndSolarReadings().getSkyCoverSummations();
		if (summations == null) {
			summations = new ArrayList<>();
			reading.getAdditionalData().getCloudAndSolarReadings().setSkyCoverSummations(summations);
		}
		summations.add(summation);
		
	}


	private String coverageCode;		// 1 char
	private String coverageCodeOktas;	// 2 chars
	private EQualityCode coverageCodeQualityCode;	// 1 char
	private Double height;				// 6 chars,  scale 1, missing +99999
	private EQualityCode heightQualityCode;
	private String characteristicCode;	// 1 char



	
	
	
	
	/*
	 
                FLD LEN: 3
                             SKY-COVER-SUMMATION-STATE identifier
                             The identifier that denotes the availability of a SKY-COVER-SUMMATION-STATE.
                             DOM:  A specific domain comprised of the ASCII characters.
                                        GD1 - GD6  An indicator of up to 6 repeating fields of the following items:
                                                           SKY-COVER-SUMMATION-STATE coverage code
                                                           SKY-COVER-SUMMATION-STATE coverage code #2
                                                           SKY-COVER-SUMMATION-STATE coverage quality code                                                           
                                                           SKY-COVER-SUMMATION-STATE height dimension
                                                           SKY-COVER-SUMMATION-STATE height dimension quality code
                                                           SKY-COVER-SUMMATION-STATE characteristic code

                FLD LEN: 1
                              SKY-COVER-SUMMATION-STATE coverage code
                              The code that denotes the portion of the total celestial dome covered by all layers of clouds and other
                              obscuring phenomena at or below a given height.
                              DOM:  A specific domain comprised of the ASCII characters
                                         0:  Clear - No coverage
                                         1:  FEW - 2/8 or less coverage (not including zero)
                                         2:  SCATTERED - 3/8-4/8 coverage
                                         3:  BROKEN - 5/8-7/8 coverage
                                         4:  OVERCAST - 8/8 coverage
                                         5:  OBSCURED
                                         6:  PARTIALLY OBSCURED
                                         9:  MISSING

FLD LEN: 2
              SKY-COVER-SUMMATION coverage code #2
                              The code that denotes the fraction of the total celestial dome covered by a by all layers of clouds and other
                              obscuring phenomena at or below a given height, if reported by the station in octas.
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
                        10: Partial Obscuration
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
                SKY-COVER-SUMMATION-STATE coverage quality code
                The code that denotes a quality status of the reported SKY-COVER-SUMMATION-STATE coverage.
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

FLD LEN: 6
                SKY-COVER-SUMMATION-STATE height dimension
                The height above ground level (AGL) of the base of the cloud layer or obscuring phenomena.
                MIN:  -00400                  MAX:  +35000                 UNITS:  meters
                SCALING FACTOR: 1
                DOM:  A general domain compirsed of the ASCII characters 0-9, a plus (+) and a minus sign (-).
                           +99999 = Missing

FLD LEN: 1
                SKY-COVER-SUMMATION-STATE height dimension quality code
                The code that denotes a quality status of the reported SKY-COVER-SUMMATION-STATE height dimension.
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

FLD LEN: 1
              SKY-COVER-SUMMATION-STATE characteristic code
              The code that represents a characteristic of a specific cloud or other obscuring phenomena layer.
              DOM:  A specific domain comprised of the characters in the ASCII character set.
                         1: Variable height
                         2: Variable amount
                         3: Thin clouds
	         4: Dark layer (reported in data prior to 1950)
                         9: Missing

▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀      
	 */
	
}
