package org.kempersoft.weather_parser.domain.weather.basefields;


import org.kempersoft.weather_parser.domain.weather.EQualityCode;

public class ObservationValue {

	
	public ObservationValue() {
	}
	
	public ObservationValue(Double value, EQualityCode qualityCode) {
		super();
		this.value = value;
		this.qualityCode = qualityCode;
	}
	
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	public EQualityCode getQualityCode() {
		return qualityCode;
	}
	public void setQualityCode(EQualityCode qualityCode) {
		this.qualityCode = qualityCode;
	}
	
	private Double value;
	private EQualityCode qualityCode;
}
