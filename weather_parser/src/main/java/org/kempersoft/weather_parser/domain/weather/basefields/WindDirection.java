package org.kempersoft.weather_parser.domain.weather.basefields;


import org.kempersoft.weather_parser.domain.weather.EQualityCode;

public class WindDirection extends ObservationValue {

	
	private EWindDirectionTypeCode typeCode;
	
	public EWindDirectionTypeCode getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(EWindDirectionTypeCode typeCode) {
		this.typeCode = typeCode;
	}

	public WindDirection( Double angle, EQualityCode qualityCode, EWindDirectionTypeCode typeCode) {
		super(angle, qualityCode);
		this.typeCode = typeCode;
	}
}
