package org.kempersoft.weather_parser.domain.weather.additionaldata.observedweather;

import org.kempersoft.weather_parser.WeatherStringReader;
import org.kempersoft.weather_parser.domain.weather.WeatherReading;
import org.kempersoft.weather_parser.domain.weather.EQualityCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bkemper on 3/3/17.
 */
public class DailyPresentWeatherObservation {


  private String sourceElement;
  private String weatherType;
  private String weatherTypeAbbreviation;
  private EQualityCode qualityCode;

  public static void parseLine( WeatherReading reading, WeatherStringReader reader ) throws Exception {

    String identifier = reader.getStringField( 3 );    // should be - AA1-AA4
    if ( identifier == null || !identifier.startsWith( "AT" ) ) {
      throw new Exception(
        "Error :  In DailyPresentWeatherObservation reading with an invalid code.  Should have AT1-8 - got "
          + identifier );
    }
    DailyPresentWeatherObservation dailyPresentWeatherObservation = new DailyPresentWeatherObservation();
    dailyPresentWeatherObservation.setSourceElement( reader.getStringField( 2 ) );
    dailyPresentWeatherObservation.setWeatherType( reader.getStringField( 2 ) );
    dailyPresentWeatherObservation.setWeatherTypeAbbreviation( reader.getStringField( 4 ) );
    dailyPresentWeatherObservation.setQualityCode( reader.getQualityCode() );
    AdditionalDataObservedWeather observedWeather = reading.getAdditionalData().getObservedWeather();
    List<DailyPresentWeatherObservation> observations = observedWeather.getDailyPresentWeatherObservations();
    if ( observations == null ) {
      observations = new ArrayList<>();
      observedWeather.setDailyPresentWeatherObservations( observations );
    }
    observations.add( dailyPresentWeatherObservation );
  }

  public String getSourceElement() {
    return sourceElement;
  }

  public void setSourceElement( String sourceElement ) {
    this.sourceElement = sourceElement;
  }

  public String getWeatherType() {
    return weatherType;
  }

  public void setWeatherType( String weatherType ) {
    this.weatherType = weatherType;
  }

  public String getWeatherTypeAbbreviation() {
    return weatherTypeAbbreviation;
  }

  public void setWeatherTypeAbbreviation( String weatherTypeAbbreviation ) {
    this.weatherTypeAbbreviation = weatherTypeAbbreviation;
  }

  public EQualityCode getQualityCode() {
    return qualityCode;
  }

  public void setQualityCode( EQualityCode qualityCode ) {
    this.qualityCode = qualityCode;
  }

  @Override public String toString() {
    return "DailyPresentWeatherObservation{" +
      "sourceElement='" + sourceElement + '\'' +
      ", weatherType='" + weatherType + '\'' +
      ", weatherTypeAbbreviation='" + weatherTypeAbbreviation + '\'' +
      ", qualityCode=" + qualityCode +
      '}';
  }

/*
  FLD LEN: 3
  PRESENT-WEATHER-OBSERVATION automated occurrence identifier for ASOS/AWOS data
  The identifier that signifies the reporting of present weather.
    DOM:  A specific domain comprised of the ASCII characters.
  AT1 – AT8   An indicator of up to 8 repeating fields of the following items:
  DAILY-PRESENT-WEATHER-OBSERVATION source element
  DAILY-PRESENT-WEATHER-OBSERVATION weather type
  DAILY-PRESENT-WEATHER-OBSERVATION weather type abbreviation
  DAILY-PRESENT-WEATHER-OBSERVATION quality code

  FLD LEN: 2
  DAILY-PRESENT-WEATHER-OBSERVATION source element
  The code that denotes the source of the daily present weather observation.
  DOM:  A specific domain comprised of the ASCII characters.
  AU = sourced from automated ASOS/AWOS sensors
  AW = sourced from automated sensors
  MW = sourced from manually reported present weather

  FLD LEN: 2
  DAILY-PRESENT-WEATHER-OBSERVATION weather type
  The numeric code that denotes the type of daily present weather being reported.
    DOM:  A specific domain comprised of the ASCII characters.
    01 = Fog, ice fog or freezing fog (may include heavy fog)
                         02 = Heavy fog or heavy freezing fog (not always distinguished from fog)
                         03 = Thunder
        04 = Ice pellets, sleet, snow pellets or small hail
	        05 = Hail (may include small hail)
                         06 = Glaze or rime
	        07 = Dust, volcanic ash, blowing dust, blowing sand or blowing obstruction
	        08 = Smoke or haze
                         09 = Blowing or drifting snow
	        10 = Tornado, water spout or funnel cloud
	        11 = High or damaging winds
	        12 = Blowing spray
	        13 = Mist
	        14 = Drizzle
      	        15 = Freezing drizzle
	        16 = Rain
	        17 = Freezing rain
	        18 = Snow, snow pellets, snow grains or ice crystals
	        19 = Unknown precipitation
	        21 = Ground fog
	        22 = Ice fog or freezing fog

  FLD LEN: 4
  DAILY-PRESENT-WEATHER-OBSERVATION weather type abbreviation
  The abbreviation that denotes the type of daily present weather being reported. These abbreviations correspond to
  the Daily                Present Weather Observation weather type.
    DOM:  A specific domain comprised of the ASCII characters.
  FG = Fog, ice fog or freezing fog (may include heavy fog)
  FG+ = Heavy fog or heavy freezing fog (not always distinguished from fog)
  TS = Thunder
    PL = Ice pellets, sleet, snow pellets or small hail
    GR = Hail (may include small hail)
  GL = Glaze or rime
  DU = Dust, volcanic ash, blowing dust, blowing sand or blowing obstruction
    HZ = Smoke or haze
  BLSN = Blowing or drifting snow
  FC = Tornado, water spout or funnel cloud
    WIND = High or damaging winds
    BLPY = Blowing spray
    BR = Mist
  DZ = Drizzle
    FZDZ = Freezing drizzle
    RA = Rain
  FZRA = Freezing rain
  SN = Snow, snow pellets, snow grains or ice crystals
  UP = Unknown precipitation
  MIFG = Ground fog
  FZFG = Ice fog or freezing fog

  FLD LEN: 1
  DAILY-PRESENT-WEATHER-OBSERVATION quality code
  The code that denotes a quality status of the reported DAILY-PRESENT-WEATHER-OBSERVATION.
    DOM:  A specific domain comprised of the characters in the ASCII character set.
    0 = Passed gross limits check
                            1 = Passed all quality control checks
                            2 = Suspect
                            3 = Erroneous
                            4 = Passed gross limits check, data originate from an NCEI data source
                            5 = Passed all quality control checks, data originate from an NCEI data source
                            6 = Suspect, data originate from an NCEI data source
                            7 = Erroneous, data originate from an NCEI data source
    M = Manual change made to value based on information provided by NWS or FAA
                            9 = Passed gross limits check if element is present


*/

}
