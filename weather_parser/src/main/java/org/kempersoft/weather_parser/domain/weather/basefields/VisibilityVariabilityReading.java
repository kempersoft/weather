package org.kempersoft.weather_parser.domain.weather.basefields;


import org.kempersoft.weather_parser.domain.weather.EQualityCode;

public class VisibilityVariabilityReading {
	
	
	public VisibilityVariabilityReading(String value, EQualityCode qualityCode) {
		super();
		this.value = value;
		this.qualityCode = qualityCode;
	}
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public EQualityCode getQualityCode() {
		return qualityCode;
	}
	public void setQualityCode(EQualityCode qualityCode) {
		this.qualityCode = qualityCode;
	}
	private String value;
	private EQualityCode qualityCode;
	

}
