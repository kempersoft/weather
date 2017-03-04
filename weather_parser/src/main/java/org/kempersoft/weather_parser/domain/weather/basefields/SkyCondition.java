package org.kempersoft.weather_parser.domain.weather.basefields;


import org.kempersoft.weather_parser.domain.weather.EQualityCode;

public class SkyCondition extends ObservationValue {

	
	public SkyCondition(Double value, EQualityCode qualityCode) {
		super(value, qualityCode);
	}
	public String getDetermination() {
		return determination;
	}
	public void setDetermination(String determination) {
		this.determination = determination;
	}
	public String getCAVOK() {
		return CAVOK;
	}
	public void setCAVOK(String cAVOK) {
		CAVOK = cAVOK;
	}
	private String determination;
	private String CAVOK;	
	// really both codes, but feeling lazy right now :-)
	

	
}
