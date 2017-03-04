package org.kempersoft.weather_parser.domain.weather.additionaldata.observedweather;

import org.kempersoft.weather_parser.WeatherStringReader;
import org.kempersoft.weather_parser.domain.weather.EQualityCode;
import org.kempersoft.weather_parser.domain.weather.WeatherReading;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bkemper on 3/3/17.
 */
public class PresentWeatherObservation {

  private String intensityAndProximityCode;
  private String descriptorCode;
  private String precipitationCode;
  private String obscurationCode;
  private String otherPhenomenaCode;
  private String combinationIndicatorCode;
  private EQualityCode qualityCode;

  public static void parseLine( WeatherReading reading, WeatherStringReader reader ) throws Exception {

    String identifier = reader.getStringField( 3 );
    if ( identifier == null || !identifier.startsWith( "AU" ) ) {
      throw new Exception(
        "Error :  In PresentWeatherObservation reading with an invalid code.  Should have AU1-9 - got "
          + identifier );
    }
    PresentWeatherObservation presentWeatherObservation = new PresentWeatherObservation();
    presentWeatherObservation.intensityAndProximityCode = reader.getStringField( 1 );
    presentWeatherObservation.descriptorCode = reader.getStringField( 1 );
    presentWeatherObservation.precipitationCode = reader.getStringField( 2 );
    presentWeatherObservation.obscurationCode = reader.getStringField( 1 );
    presentWeatherObservation.otherPhenomenaCode = reader.getStringField( 1 );
    presentWeatherObservation.combinationIndicatorCode = reader.getStringField( 1 );
    presentWeatherObservation.qualityCode = reader.getQualityCode();
    AdditionalDataObservedWeather observedWeather = reading.getAdditionalData().getObservedWeather();
    List<PresentWeatherObservation> observations = observedWeather.getPresentWeatherObservations();
    if ( observations == null ) {
      observations = new ArrayList<>();
      observedWeather.setPresentWeatherObservations( observations );
    }
    observations.add( presentWeatherObservation );
  }

  @Override public String toString() {
    return "PresentWeatherObservation{" +
      "intensityAndProximityCode='" + intensityAndProximityCode + '\'' +
      ", descriptorCode='" + descriptorCode + '\'' +
      ", precipitationCode='" + precipitationCode + '\'' +
      ", obscurationCode='" + obscurationCode + '\'' +
      ", otherPhenomenaCode='" + otherPhenomenaCode + '\'' +
      ", combinationIndicatorCode='" + combinationIndicatorCode + '\'' +
      ", qualityCode=" + qualityCode +
      '}';
  }

  public String getIntensityAndProximityCode() {
    return intensityAndProximityCode;
  }

  public void setIntensityAndProximityCode( String intensityAndProximityCode ) {
    this.intensityAndProximityCode = intensityAndProximityCode;
  }

  public String getDescriptorCode() {
    return descriptorCode;
  }

  public void setDescriptorCode( String descriptorCode ) {
    this.descriptorCode = descriptorCode;
  }

  public String getPrecipitationCode() {
    return precipitationCode;
  }

  public void setPrecipitationCode( String precipitationCode ) {
    this.precipitationCode = precipitationCode;
  }

  public String getObscurationCode() {
    return obscurationCode;
  }

  public void setObscurationCode( String obscurationCode ) {
    this.obscurationCode = obscurationCode;
  }

  public String getOtherPhenomenaCode() {
    return otherPhenomenaCode;
  }

  public void setOtherPhenomenaCode( String otherPhenomenaCode ) {
    this.otherPhenomenaCode = otherPhenomenaCode;
  }

  public String getCombinationIndicatorCode() {
    return combinationIndicatorCode;
  }

  public void setCombinationIndicatorCode( String combinationIndicatorCode ) {
    this.combinationIndicatorCode = combinationIndicatorCode;
  }

  public EQualityCode getQualityCode() {
    return qualityCode;
  }

  public void setQualityCode( EQualityCode qualityCode ) {
    this.qualityCode = qualityCode;
  }


/*

▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀

  AU1 – AU9   An indicator of up to 9 repeating fields of the following items:
  PRESENT-WEATHER-OBSERVATION intensity code
  PRESENT-WEATHER-OBSERVATION descriptor code
  PRESENT-WEATHER-OBSERVATION precipitation code
  PRESENT-WEATHER-OBSERVATION obscuration code
  PRESENT-WEATHER-OBSERVATION other weather phenomena code
  PRESENT-WEATHER-OBSERVATION combination indicator code
  PRESENT-WEATHER-OBSERVATION quality code

  FLD LEN: 1
  PRESENT-WEATHER-OBSERVATION intensity and proximity code
  DOM:  A specific domain comprised of the characters in the ASCII character set.
    0 = Not Reported
                         1 = Light (-)
                         2 = Moderate or Not Reported (no entry in original observation)
                         3 = Heavy (+)
                         4 = Vicinity (VC)
                         9 = Missing

  FLD LEN: 1
  PRESENT-WEATHER-OBSERVATION descriptor code
  DOM:  A specific domain comprised of the characters in the ASCII character set.
    0 = No Descriptor
                         1 = Shallow (MI)
                         2 = Partial (PR)
                         3 = Patches (BC)
                         4 = Low Drifting (DR)
                         5 = Blowing (BL)
                         6 = Shower(s) (SH)
    7 = Thunderstorm (TS)
                         8 = Freezing (FZ)
                         9 = Missing

  FLD LEN: 2
  PRESENT-WEATHER-OBSERVATION precipitation code
  DOM:  A specific domain comprised of the characters in the ASCII character set.
    00 = No Precipitation
                        01 = Drizzle (DZ)
                        02 = Rain (RA)
                        03 = Snow (SN)
                        04 = Snow Grains (SG)
                        05 = Ice Crystals (IC)
                        06 = Ice Pellets (PL)
                        07 = Hail (GR)
                        08 = Small Hail and/or Snow Pellets (GS)
                        09 = Unknown Precipitation (UP)
                        99 = Missing

  FLD LEN: 1
  PRESENT-WEATHER-OBSERVATION obscuration code
  DOM:  A specific domain comprised of the characters in the ASCII character set.
    0 = No Obscuration
                         1 = Mist (BR)
                         2 = Fog (FG)
                         3 = Smoke (FU)
                         4 = Volcanic Ash (VA)
                         5 = Widespread Dust (DU)
                         6 = Sand (SA)
                         7 = Haze (HZ)
                         8 = Spray (PY)
                         9 = Missing

  FLD LEN: 1
  PRESENT-WEATHER-OBSERVATION other weather phenomena code
  DOM:  A specific domain comprised of the characters in the ASCII character set.
    0 = None Reported
                         1 = Well-Developed Dust/Sand Whirls (PO)
                         2 = Squalls (SQ)
                         3 = Funnel Cloud, Tornado, Waterspout(FC)
    4 = Sandstorm (SS)
                         5 = Duststorm (DS)
                         9 = Missing

  FLD LEN: 1
  PRESENT-WEATHER-OBSERVATION combination indicator code
  DOM:  A specific domain comprised of the characters in the ASCII character set.
    1 = Not part of combined weather elements
                        2 = Beginning element of combined weather elements
                        3 = Combined with previous weather element to form a single weather report
                        9 = Missing

  FLD LEN: 1
  PRESENT-WEATHER-OBSERVATION quality code
  The code that denotes a quality status of the reported PRESENT-WEATHER-OBSERVATION.
    DOM:  A specific domain comprised of the characters in the ASCII character set.
    0 = Passed gross limits check
                            1 = Passed all quality control checks
                            2 = Suspect
                            3 = Erroneous
                            4 = Passed gross limits check , data originate from an NCEI data source
                            5 = Passed all quality control checks, data originate from an NCEI data source
                            6 = Suspect, data originate from an NCEI data source
                            7 = Erroneous, data originate from an NCEI data source
    M = Manual change made to value based on information provided by NWS or FAA
                            9 = Passed gross limits check if element is present

*/
}
