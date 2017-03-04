package org.kempersoft.weather_parser.domain.weather.basefields;

public enum EWindDirectionTypeCode {

	Abridged("A","Abridged Beaufort"),
	Beaufort("B","Beaufort"),
	Calm("C","Calm"),
	FiveMinAvg("H","5-Minute Average Speed"),
	Normal("N","Normal"),
	OneHourAvg("R","60-Minute Average Speed"),
	Squall("Q","Squall"),
	ThreeHourAverage("T","180 Minute Average Speed"),
	Variable("V","Variable"),
	Mssing("9","Missing");
	
	
	public String getOriginal_code() {
		return original_code;
	}

	public String getDescription() {
		return description;
	}


	private String original_code;
	private String description;

	private EWindDirectionTypeCode(String original_code, String description) {
		this.original_code = original_code;
		this.description = description;
	}

	public static EWindDirectionTypeCode toTypeCode(String originalCode) throws Exception {
		if (originalCode == null || originalCode.isEmpty()) {
			throw new Exception("Invalid wind direction type code : " + originalCode);
		}
	      for(EWindDirectionTypeCode code : values()) {
	         if (code.original_code.equals(originalCode)) {
	            return code;
	         }
	      }
		   throw new Exception("Invalid wind direction type code : " + originalCode);
	   }



}
