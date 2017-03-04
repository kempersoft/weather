package org.kempersoft.weather_parser.domain.weather.additionaldata.cloudandsolar;


public class HourlySolarRadiation {

	/*
	 
▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀          

FLD LEN: 3
              Hourly Solar Radiation Section identifier
              The identifier that indicates an hourly observation of solar radiation. This section appears in the last ISD record of 
               the hour.  
               DOM: A specific domain comprised of the characters in the ASCII character set.
                        GH1  An indicator of the following items:
                                 SOLARAD hourly average solar radiation
                                 SOLARAD_QC quality code
                                 SOLARAD_FLAG quality code
                                 SOLARAD_MIN minimum solar radiation
                                 SOLARAD_MIN_QC quality code
                                 SOLARAD_MIN_FLAG quality code
                                 SOLARAD_MAX maximum solar radiation
                                 SOLARAD_MAX_QC quality code
                                 SOLARAD_MAX_FLAG quality code
                                 SOLARAD_STD solar radiation standard deviation
                                 SOLARAD_STD_QC quality code
                                 SOLARAD_STD_FLAG quality code

FLD LEN: 5
              SOLARAD hourly average solar radiation
              The hourly average solar radiation.
              MIN:  0000        MAX:  99998         UNITS: watts per square meter
              SCALING FACTOR: 10
              DOM:  A general domain comprised of the numeric characters (0‑9).
                         99999 = Missing.

FLD LEN: 1
             SOLARAD_QC quality code
              The code that indicates ISD’s evaluation of the quality status of the hourly average solar radiation.
              DOM:  A specific domain comprised of the numeric characters (0-9).
                                         1 = Passed all quality control checks
                         3 = Failed all quality control checks
                         9 = Missing

FLD LEN: 1
              SOLARAD_FLAG quality code
                              The code that indicates the network’s internal evaluation of the quality status of the hourly average solar radiation. Most 
                              users will find the preceding quality code SOLARAD_QC to be the simplest and most useful quality indicator.
              DOM:  A specific domain comprised of the numeric characters (0-9).
                         0 = Passed all quality control checks
                         other – Did not pass all quality checks

FLD LEN: 5
              SOLARAD_MIN minimum solar radiation
              The minimum 10 second solar radiation for the hour.
              MIN:  00000        MAX:  99998         UNITS:   watts per square meter
              SCALING FACTOR: 10
              DOM:  A general domain comprised of the numeric characters (0‑9).
                         99999 = Missing.

FLD LEN: 1
              SOLARAD_MIN_QC quality code
              The code that indicates ISD’s evaluation of the quality status of the hourly minimum solar radiation.
              DOM:  A specific domain comprised of the numeric characters (0-9).
                                         1 = Passed all quality control checks
                         3 = Failed all quality control checks
                         9 = Missing

FLD LEN: 1
              SOLARAD_MIN_FLAG quality code
                             The code that indicates the network’s internal evaluation of the quality status of the hourly minimum solar radiation. Most 
                              users will find the preceding quality code SOLARAD_MIN_QC to be the simplest and most useful quality
                              indicator.
              DOM:  A specific domain comprised of the numeric characters (0-9).
                         0 = Passed all quality control checks
                         other – Did not pass all quality checks

FLD LEN: 5
              SOLARAD_MAX maximum solar radiation
              The maximum 10 second solar radiation for the hour.
              MIN:  00000        MAX:  99998         UNITS:  watts per square meter
              SCALING FACTOR: 10
              DOM:  A general domain comprised of the numeric characters (0‑9).
                         99999 = Missing.

FLD LEN: 1
              SOLARAD_MAX_QC quality code
              The code that indicates ISD’s evaluation of the quality status of the hourly maximum solar radiation.
              DOM:  A specific domain comprised of the numeric characters (0-9).
                                         1 = Passed all quality control checks
                         3 = Failed all quality control checks
                         9 = Missing

FLD LEN: 1
              SOLARAD_MAX_FLAG quality code
                              The code that indicates the network’s internal evaluation of the quality status of the hourly maximum solar radiation. 
                              Most users will find the preceding quality code SOLARAD_MAX_QC to be the simplest and most useful quality
                              indicator.
              DOM:  A specific domain comprised of the numeric characters (0-9).
                         0 = Passed all quality control checks
                         other – Did not pass all quality checks
                
FLD LEN: 5
              SOLARAD_STD solar radiation standard deviation
              The hourly 10 second hourly solar radiation standard deviation.
              MIN:  00000        MAX:   99998
              SCALING FACTOR: 10
              DOM:  A general domain comprised of the numeric characters (0‑9).
                         99999 = Missing.

FLD LEN: 1
              SOLARAD_STD_QC quality code
              The code that indicates ISD’s evaluation of the quality status of the hourly solar radiation standard deviation.
              DOM:  A specific domain comprised of the numeric characters (0-9).
                                         1 = Passed all quality control checks
                         3 = Failed all quality control checks
                         9 = Missing

FLD LEN: 1
              SOLARAD_STD_FLAG quality code
                              The code that indicates the network’s internal evaluation of the quality status of hourly solar radiation standard 
                              deviation.  Most users will find the preceding quality code SOLARAD_STD_QC to be the simplest and most 
                              useful quality indicator.
              DOM:  A specific domain comprised of the numeric characters (0-9).
                         0 = Passed all quality control checks
                         other – Did not pass all quality checks

▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀         	  
	 */
}
