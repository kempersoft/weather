package org.kempersoft.weather_parser.domain.weather.additionaldata.cloudandsolar;


public class SunshineObservationDuration {

/*    
FLD LEN: 3
                       SUNSHINE-OBSERVATION identifier
                       The identifier that denotes the availability of sunshine information.
                       DOM:  A specific domain comprised of the ASCII characters
GJ1   An indicator of the occurrence of the following items:
      SUNSHINE-OBSERVATION sunshine duration quantity
                               SUNSHINE-OBSERVATION sunshine duration quality code


       FLD LEN: 4
                       SUNSHINE-OBSERVATION sunshine duration quantity
                       The quantity of time sunshine occurred over the reporting period.
                       MIN:  0000          MAX:  6000         UNITS:  minutes
                      DOM:  A general domain comprised of the ASCII characters 0-9.
                                 9999 = Missing

      FLD LEN: 1
SUNSHINE-OBSERVATION sunshine duration quality code
The code that denotes a quality status of the reported SUNSHINE-OBSERVATION sunshine duration.
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
