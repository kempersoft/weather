package org.kempersoft.weather_parser.domain.weather;



import org.kempersoft.weather_parser.domain.weather.additionaldata.WeatherReadingAdditionalData;
import org.kempersoft.weather_parser.domain.weather.basefields.ObservationValue;
import org.kempersoft.weather_parser.domain.weather.basefields.SkyCondition;
import org.kempersoft.weather_parser.domain.weather.basefields.VisibilityVariabilityReading;
import org.kempersoft.weather_parser.domain.weather.basefields.WindDirection;
import org.kempersoft.weather_parser.domain.weather.remarks.RemarkRecord;
import org.kempersoft.weather_parser.domain.weather.basefields.EObservationType;
import org.kempersoft.weather_parser.domain.weather.basefields.EReportType;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;


public class WeatherReading {
	
	public WindDirection getWindDirection() {
		return windDirection;
	}
	public void setWindDirection(WindDirection windDirection) {
		this.windDirection = windDirection;
	}
	public ObservationValue getWindSpeed() {
		return windSpeed;
	}
	public void setWindSpeed(ObservationValue windSpeed) {
		this.windSpeed = windSpeed;
	}
	public SkyCondition getSkyCondition() {
		return skyCondition;
	}
	public void setSkyCondition(SkyCondition skyCondition) {
		this.skyCondition = skyCondition;
	}
	public ObservationValue getVisibilityDistance() {
		return visibilityDistance;
	}
	public void setVisibilityDistance(ObservationValue visibilityDistance) {
		this.visibilityDistance = visibilityDistance;
	}
	public VisibilityVariabilityReading getVisibilityVariability() {
		return visibilityVariability;
	}
	public void setVisibilityVariability(VisibilityVariabilityReading visibilityVariability) {
		this.visibilityVariability = visibilityVariability;
	}
	public ObservationValue getAirTemperature() {
		return airTemperature;
	}
	public void setAirTemperature(ObservationValue airTemperature) {
		this.airTemperature = airTemperature;
	}
	public ObservationValue getDewPoint() {
		return dewPoint;
	}
	public void setDewPoint(ObservationValue dewPoint) {
		this.dewPoint = dewPoint;
	}
	public ObservationValue getSeaLevelPressure() {
		return seaLevelPressure;
	}
	public void setSeaLevelPressure(ObservationValue seaLevelPressure) {
		this.seaLevelPressure = seaLevelPressure;
	}
	private String USAF;
	
	private String WBAN;

	private Timestamp observeDate;

	private EObservationType observationType;

	private Double latitude;

	private Double longitude;
	
	private Double elevation;
	
	private EReportType reportType;
	
	private String fixedWeatherStationCallLetters;
	
	private String qualityControlProcess;
	
	private WindDirection windDirection;
	
	private ObservationValue windSpeed;
	
	private SkyCondition skyCondition;
	
	private ObservationValue visibilityDistance;
	
	private VisibilityVariabilityReading visibilityVariability;
	
	private ObservationValue airTemperature;
	
	private ObservationValue dewPoint;
	
	private ObservationValue seaLevelPressure;

	private List<RemarkRecord> remarks;
	
	private WeatherReadingAdditionalData additionalData = new WeatherReadingAdditionalData();
	
	public List<RemarkRecord> getRemarks() {
		return remarks;
	}
	public void setRemarks(List<RemarkRecord> remarks) {
		this.remarks = remarks;
	}
	public EReportType getReportType() {
		return reportType;
	}
	public void setReportType(EReportType reportType) {
		this.reportType = reportType;
	}
	public WeatherReading() {
		super();
	}
	public WeatherReading(String USAF, String WBAN, Timestamp observeDate) {
		this.USAF = USAF;
		this.WBAN = WBAN;
		this.observeDate = observeDate;
	}

	private String getDateKeyString() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmm");
		return formatter.format(observeDate.getTime());
	}

	public String getKey() {
		return USAF + "_" + WBAN + "_" + getDateKeyString();
	}
	public Double getLatitude() {
		return latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public EObservationType getObservationType() {
		return observationType;
	}
	public Timestamp getObserveDate() {
		return observeDate;
	}
	public String getUSAF() {
		return USAF;
	}
	
	public String getWBAN() {
		return WBAN;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
	public void setObservationType(EObservationType observationType) {
		this.observationType = observationType;
	}

	public void setObserveDate(Timestamp observeDate) {
		this.observeDate = observeDate;
	}

	public void setUSAF(String uSAF) {
		USAF = uSAF;
	}
	
	public void setWBAN(String wBAN) {
		WBAN = wBAN;
	}
	public Double getElevation() {
		return elevation;
	}
	public void setElevation(Double elevation) {
		this.elevation = elevation;
	}
	public String getFixedWeatherStationCallLetters() {
		return fixedWeatherStationCallLetters;
	}
	public void setFixedWeatherStationCallLetters(String fixedWeatherStationCallLetters) {
		this.fixedWeatherStationCallLetters = fixedWeatherStationCallLetters;
	}
	public String getQualityControlProcess() {
		return qualityControlProcess;
	}
	public void setQualityControlProcess(String qualityControlProcess) {
		this.qualityControlProcess = qualityControlProcess;
	}
	public WeatherReadingAdditionalData getAdditionalData() {
		return additionalData;
	}
	public void setAdditionalData(WeatherReadingAdditionalData additionalData) {
		this.additionalData = additionalData;
	}


	@Override public String toString() {
		return "WeatherReading{" +
			"USAF='" + USAF + '\'' +
			", WBAN='" + WBAN + '\'' +
			", observeDate=" + observeDate +
			", observationType=" + observationType +
			", latitude=" + latitude +
			", longitude=" + longitude +
			", elevation=" + elevation +
			", reportType=" + reportType +
			", fixedWeatherStationCallLetters='" + fixedWeatherStationCallLetters + '\'' +
			", qualityControlProcess='" + qualityControlProcess + '\'' +
			", windDirection=" + windDirection +
			", windSpeed=" + windSpeed +
			", skyCondition=" + skyCondition +
			", visibilityDistance=" + visibilityDistance +
			", visibilityVariability=" + visibilityVariability +
			", airTemperature=" + airTemperature +
			", dewPoint=" + dewPoint +
			", seaLevelPressure=" + seaLevelPressure +
			", remarks=" + remarks +
			", additionalData=" + additionalData +
			'}';
	}
}
