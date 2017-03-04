package org.kempersoft.weather_parser.domain.weather.additionaldata;


/* This class represents the additional data fields possible on a weather reading file... 
 * It's actually broken into subsections relative to the ISD File format documents
 */

import org.kempersoft.weather_parser.domain.weather.additionaldata.cloudandsolar.AdditionalDataCloudAndSolar;
import org.kempersoft.weather_parser.domain.weather.additionaldata.observedweather.AdditionalDataObservedWeather;
import org.kempersoft.weather_parser.domain.weather.additionaldata.pressure.AdditionalDataPressure;
import org.kempersoft.weather_parser.domain.weather.additionaldata.precipitation.AdditionalDataPrecipitation;

public class WeatherReadingAdditionalData {

	private AdditionalDataPressure pressureReadings = new AdditionalDataPressure();
	private AdditionalDataCloudAndSolar cloudAndSolarReadings = new AdditionalDataCloudAndSolar();
	private AdditionalDataPrecipitation precipitationReadings = new AdditionalDataPrecipitation();
	private AdditionalDataObservedWeather observedWeather = new AdditionalDataObservedWeather();
	public AdditionalDataPressure getPressureReadings() {
		return pressureReadings;
	}
	public void setPressureReadings(AdditionalDataPressure pressureReadings) {
		this.pressureReadings = pressureReadings;
	}
	public AdditionalDataCloudAndSolar getCloudAndSolarReadings() {
		return cloudAndSolarReadings;
	}
	public void setCloudAndSolarReadings(AdditionalDataCloudAndSolar cloudAndSolarReadings) {
		this.cloudAndSolarReadings = cloudAndSolarReadings;
	}


	public AdditionalDataPrecipitation getPrecipitationReadings() {
		return precipitationReadings;
	}

	public void setPrecipitationReadings(
		AdditionalDataPrecipitation precipitationReadings ) {
		this.precipitationReadings = precipitationReadings;
	}

	public AdditionalDataObservedWeather getObservedWeather() {
		return observedWeather;
	}

	public void setObservedWeather(
		AdditionalDataObservedWeather observedWeather ) {
		this.observedWeather = observedWeather;
	}
}
