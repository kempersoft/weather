package org.kempersoft.weather_parser.domain.weather.basefields;

public enum EObservationType {

	C1("1","USAF SURFACE HOURLY observation, candidate for merge with NCEI SURFACE HOURLY (not yet merged, failed element cross-checks)"),
	C2("2","NCEI SURFACE HOURLY observation, candidate for merge with USAF SURFACE HOURLY (not yet merged, failed element cross-checks)"),
	C3("3","USAF SURFACE HOURLY/NCEI SURFACE HOURLY merged observation"),
	C4("4","USAF SURFACE HOURLY observation"),
	C5("5","NCEI SURFACE HOURLY observation"),
	C6("6","ASOS/AWOS observation from NCEI"),
	C7("7","ASOS/AWOS observation merged with USAF SURFACE HOURLY observation"),
	C8("8","MAPSO observation (NCEI)"),
	CA("A","USAF SURFACE HOURLY/NCEI HOURLY PRECIPITATION merged observation, candidate for merge with	NCEI SURFACE HOURLY (not yet merged, failed element cross-checks)"),
	CB("B","NCEI SURFACE HOURLY/NCEI HOURLY PRECIPITATION merged observation, candidate for merge with	USAF SURFACE HOURLY (not yet merged, failed element cross-checks)"),
	CC("C","USAF SURFACE HOURLY/NCEI SURFACE HOURLY/NCEI HOURLY PRECIPITATION merged observation"),
	CD("D","USAF SURFACE HOURLY/NCEI HOURLY PRECIPITATION merged observation"),
	CE("E","NCEI SURFACE HOURLY/NCEI HOURLY PRECIPITATION merged observation"),
	CF("F","Form OMR/1001 – Weather Bureau city office (keyed data)"),
	CG("G","SAO surface airways observation, pre-1949 (keyed data)"),
	CH("H","SAO surface airways observation, 1965-1981 format/period (keyed data)"),
	CI("I","Climate Reference Network observation"),
	CJ("J","Cooperative Network observation"),
	CK("K","Radiation Network observation"),
	CL("L","Data from Climate Data Modernization Program (CDMP) data source"),
	CM("M","Data from National Renewable Energy Laboratory (NREL) data source"),
	CN("N","NCAR / NCEI cooperative effort (various national datasets)"),
	CO("O","Summary observation created by NCEI using hourly observations that may not share the same data source flag"),
	MISSING("9","Missing");

	
	public String getOriginal_code() {
		return original_code;
	}

	public String getDescription() {
		return description;
	}


	private String original_code;
	private String description;

	private EObservationType(String original_code, String description) {
		this.original_code = original_code;
		this.description = description;
	}

	public static EObservationType toObservationType(String originalCode) throws Exception {
		if (originalCode == null || originalCode.isEmpty()) {
			throw new Exception("Invalid observation type : " + originalCode);
		}
	      for(EObservationType code : values()) {
	         if (code.original_code.equals(originalCode)) {
	            return code;
	         }
	      }
		   throw new Exception("Invalid observation type : " + originalCode);
	   }


}
