package org.kempersoft.weather_parser.domain.weather;

public enum EQualityCode {

	
	C0("0","Passed gross limits check"),
	C1("1","Passed all quality control checks"),
	C2("2","Suspect"),
	C3("3","Erroneous"),
	C4("4","Passed gross limits check , data originate from an NCEI data source"),
	C5("5","Passed all quality control checks, data originate from an NCEI data source"),
	C6("6","Suspect, data originate from an NCEI data source"),
	C7("7","Erroneous, data originate from an NCEI data source"),
	C9("9","Passed gross limits check if element is present"),
	CA("A","Data value flagged as suspect, but accepted as a good value"),
	CC("C","Temperature and dew point received from Automated Weather Observing System (AWOS) are reported in whole degrees Celsius. Automated QC flags these values, but they are accepted as valid."),
	CI("I","Data value not originally in data, but inserted by validator"),
	CM("M","Manual changes made to value based on information provided by NWS or FAA"),
	CP("P","Data value not originally flagged as suspect, but replaced by validator"),
	CR("R","Data value replaced with value computed by NCEI software"),
	CU("U","Data value replaced with edited value");
			
			public String getOriginal_code() {
				return original_code;
			}

			public String getDescription() {
				return description;
			}


			private String original_code;
			private String description;

			private EQualityCode(String original_code, String description) {
				this.original_code = original_code;
				this.description = description;
			}

			public static EQualityCode toQualityCode(String originalCode) throws Exception {
				if (originalCode == null || originalCode.isEmpty()) {
					throw new Exception("Invalid quality code : " + originalCode);
				}
			      for(EQualityCode code : values()) {
			         if (code.original_code.equals(originalCode)) {
			            return code;
			         }
			      }
				   throw new Exception("Invalid quality code : " + originalCode);
			   }

		

	
}
