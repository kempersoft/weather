package org.kempersoft.weather_parser.domain.weather.additionaldata.pressure;

import org.kempersoft.weather_parser.WeatherStringReader;
import org.kempersoft.weather_parser.domain.weather.EQualityCode;
import org.kempersoft.weather_parser.domain.weather.WeatherReading;

public class AtmosphericPressure {

  public Double getAltimeterSettingRate() {
    return altimeterSettingRate;
  }

  public void setAltimeterSettingRate( Double altimeterSettingRate ) {
    this.altimeterSettingRate = altimeterSettingRate;
  }

  public EQualityCode getAltimeterQualityCode() {
    return altimeterQualityCode;
  }

  public void setAltimeterQualityCode( EQualityCode altimeterQualityCode ) {
    this.altimeterQualityCode = altimeterQualityCode;
  }

  public Double getStationPressureRate() {
    return stationPressureRate;
  }

  public void setStationPressureRate( Double stationPressureRate ) {
    this.stationPressureRate = stationPressureRate;
  }

  public EQualityCode getStationPressureQualityCode() {
    return stationPressureQualityCode;
  }

  public void setStationPressureQualityCode( EQualityCode stationPressureQualityCode ) {
    this.stationPressureQualityCode = stationPressureQualityCode;
  }

  public static void parseLine( WeatherReading reading, WeatherStringReader reader ) throws Exception {
    String identifier = reader.getStringField( 3 );    // should be - MA1
    if ( !"MA1".equals( identifier ) ) {
      throw new Exception(
        "Error : In AtmposphericPressure reading with an invalid code.  Should have MA1, got " + identifier );
    }
    // get the setting rate...
    AtmosphericPressure amp = new AtmosphericPressure();
    amp.altimeterSettingRate = reader.getDoubleValue( 5, "99999", 10.0 );
    amp.altimeterQualityCode = reader.getQualityCode();
    amp.stationPressureRate = reader.getDoubleValue( 5, "99999", 10.0 );
    amp.stationPressureQualityCode = reader.getQualityCode();
    reading.getAdditionalData().getPressureReadings().setAtmosphericPressure( amp );
  }


  private Double altimeterSettingRate;      // in Hectopascals, whatever they are!
  private EQualityCode altimeterQualityCode;    // reading value
  private Double stationPressureRate;        // station pressure
  private EQualityCode stationPressureQualityCode;    // station pressure quality
/*
  FLD LEN: 3
	              ATMOSPHERIC-PRESSURE-OBSERVATION identifier
	             The identifier that denotes the start of an ATMOSPHERIC-PRESSURE-OBSERVATION data section.
	              DOM:  A specific domain comprised of the characters in the ASCII character set.
	                         MA1   An indicator of the occurrence of the following items:
	                                   ATMOSPHERIC-PRESSURE-OBSERVATION altimeter setting rate
	                                                            ATMOSPHERIC-PRESSURE-OBSERVATION altimeter quality code
	                                   ATMOSPHERIC-PRESSURE-OBSERVATION station pressure rate
	                                                            ATMOSPHERIC-PRESSURE-OBSERVATION station pressure
	                                                            quality code

	FLD LEN: 5
	               ATMOSPHERIC-PRESSURE-OBSERVATION altimeter setting rate
	               The pressure value to which an aircraft altimeter is set so that it will indicate the altitude
	               relative
	               to mean sea level of an aircraft on the ground at the location for which the value was determined.
	               MIN:  08635        MAX:  10904      UNITS:  Hectopascals
	               SCALING FACTOR:  10
	               DOM:  A general domain comprised of the numeric characters (0‑9).
	                                               Missing = 99999

	FLD LEN: 1
	                 ATMOSPHERIC-PRESSURE-OBSERVATION altimeter quality code
	                 The code that denotes a quality status of an altimeter setting rate.
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

	FLD LEN: 5
	              ATMOSPHERIC-PRESSURE-OBSERVATION station pressure rate
	              The atmospheric pressure at the observation point.
	              MIN:  04500        MAX:  10900    UNITS:  Hectopascals
	              SCALING FACTOR:  10
	              DOM:  A general domain comprised of the numeric characters (0‑9).
	                         99999 = Missing.

	FLD LEN: 1
	              ATMOSPHERIC-PRESSURE-OBSERVATION station pressure quality code
	              The code that denotes a quality status of the station pressure of an
	              ATMOSPHERIC-PRESSURE-OBSERVATION.
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
