package org.kempersoft.weather_parser.domain.weather.additionaldata.cloudandsolar;


public class SunshineObservationPercent {
/*	 
    ▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀          
               
               FLD LEN: 3
                               SUNSHINE-OBSERVATION identifier
                               The identifier that denotes the availability of percent of possible sunshine information.
                               DOM:  A specific domain comprised of the ASCII characters
                 GK1    An indicator of the occurrence of the following items:
                                                     SUNSHINE-OBSERVATION percent of possible sunshine quantity
                                                     SUNSHINE-OBSERVATION percent of possible sunshine quality code

               FLD LEN: 3
                               SUNSHINE-OBSERVATION percent of possible sunshine quantity
                               The percent of possible sunshine that occurred over the previous 24-hour period.
                               MIN:  000          MAX:  100         UNITS:  percentage
                               DOM:  A general domain comprised of the ASCII characters 0-9.
                                          999 = Missing.

              FLD LEN: 1
       SUNSHINE-OBSERVATION percent of possible sunshine quality code
       The code that denotes a quality status of the reported SUNSHINE-OBSERVATION percent of possible sunshine.
       DOM:  A specific domain comprised of the characters in the ASCII character set.
                   4 = Passed gross limits check, data originate from an NCEI data source
                   5 = Passed all quality control checks, data originate from an NCEI data source
                   6 = Suspect, data originate from an NCEI data source
                   7 = Erroneous, data originate from an NCEI data source
                   M = Manual change made to value based on information provided by NWS or FAA  
                   9 = Passed gross limits check if element is present

 
▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀           
*/
	}
