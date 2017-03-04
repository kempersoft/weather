package org.kempersoft.weather_parser.domain.weather.basefields;

public enum EReportType {
	

	
	AERO ("Aerological report"),
	AUST ("Dataset from Australia"),
	AUTO ("Report from an automatic station"),
	BOGUS ("Bogus report"),
	BRAZ ("Dataset from Brazil"),
	COOPD ("US Cooperative Network summary of day report"),
	COOPS ("US Cooperative Network soil temperature report"),
	CRB ("Climate Reference Book data from CDMP"),
	CRN05("Climate Reference Network report, with 5-minute reporting interval"),
	CRN15 ("Climate Reference Network report, with 15-minute reporting interval"),
	FM_12("SYNOP Report of surface observation form a fixed land station"),
	FM_13("SHIP Report of surface observation from a sea station"),
	FM_14("SYNOP MOBIL Report of surface observation from a mobile land station"),
	FM_15("METAR Aviation routine weather report"),
	FM_16 ("SPECI Aviation selected special weather report"),
	FM_18 ("BUOY Report of a buoy observation"),
	GREEN ("Dataset from Greenland"),
	MESOH ("Hydrological observations from MESONET operated civilian or government agency"),
	MESOS ("MESONET operated civilian or government agency"),
	MESOW ("Snow observations from MESONET operated civilian or government agency "),
	MEXIC ("Dataset from Mexico"),
	NSRDB ("National Solar Radiation Data Base"),
	PCP15 ("US 15-minute precipitation network report"),
	PCP60 ("US 60-minute precipitation network report "),
	S_S_A ("Synoptic, airways, and auto merged report "),
	SA_AU ("Airways and auto merged report"),
	SAO ("Airways report (includes record specials)"),
	SAOSP ("Airways special report (excluding record specials)"),
	SHEF ("Standard Hydrologic Exchange Format"),
	SMARS ("Supplementary airways station report"),
	SOD ("Summary of day report from U.S. ASOS or AWOS station "),
	SOM ("Summary of month report from U.S. ASOS or AWOS station "),
	SURF ("Surface Radiation Network report"),
	SY_AE ("Synoptic and aero merged report"), 
	SY_AU ("Synoptic and auto merged report"), 
	SY_MT ("Synoptic and METAR merged report"), 
	SY_SA ("Synoptic and airways merged report"), 
	WBO ("Weather Bureau Office"),
	WNO ("Washington Naval Observatory"), 
	MISSING ("Missing");

	
	private String description;
	
	public String getDescription() {
		return description;
	}

	EReportType(String description) {
		this.description = description;
	}
	
	public static EReportType getReportTypeType( String string ) {
		if ( string == null || string.length() == 0 ) {
			return null;
			  }
		    String codedString = string.trim();
		    if (codedString.equals("99999")) {
		    	return MISSING;
		    }
		    codedString = codedString.replaceAll("-",  "_");
		    return valueOf( codedString );
		  }


}
