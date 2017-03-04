package org.kempersoft.weather_parser.domain.weather.additionaldata.cloudandsolar;


public class BelowStationCloudLayer {
/*
  
FLD LEN: 3
              BELOW-STATION-CLOUD-LAYER identifier
              The identifier that represents a BELOW-STATION-CLOUD-LAYER.
              DOM:  A specific domain comprised of the characters in the ASCII character set.
                         GG1-GG6     An indicator of up to 6 repeating fields of the following items:
                                              BELOW-STATION-CLOUD-LAYER coverage code
                                              BELOW-STATION-CLOUD-LAYER coverage quality code
                                              BELOW-STATION-CLOUD-LAYER top height dimension
                                              BELOW-STATION-CLOUD-LAYER top height dimension quality code
                                              BELOW-STATION-CLOUD-LAYER type code
                                              BELOW-STATION-CLOUD-LAYER type quality code
                                              BELOW-STATION-CLOUD-LAYER top code
                                              BELOW-STATION-CLOUD-LAYER top quality code

FLD LEN: 2
              BELOW-STATION-CLOUD-LAYER coverage code
              The code that denotes the extent of coverage of a BELOW-STATION-CLOUD-LAYER.
              DOM:   A specific domain comprised of the characters in the ASCII character set.
                                                    00: None
                           01: One okta - 1/10 or less but not zero
                           02: Two oktas - 2/10 ‑ 3/10
                           03: Three oktas - 4/10
                           04: Four oktas - 5/10
                           05: Five oktas  - 6/10
                           06: Six oktas  - 7/10 ‑ 8/10
                           07: Seven oktas - 9/10 or more but not 10/10
                           08: Eight oktas - 10/10
                           09: Sky obscured, or cloud amount cannot be estimated
                           10: Partial obscuration
                           99: Missing

FLD LEN: 1
                BELOW-STATION-CLOUD-LAYER coverage quality code
                The code that denotes a quality status of the reported BELOW-STATION-CLOUD-LAYER coverage.
                DOM:  A specific domain comprised of the characters in the ASCII character set.
                            0 = Passed gross limits check 
                            1 = Passed all quality control checks
                            2 = Suspect
                            3 = Erroneous
                            9 = Passed gross limits check if element is present

FLD LEN: 5
              BELOW-STATION-CLOUD-LAYER top height dimension
                                      The height above mean sea level (MSL) of the top of a BELOW-STATION-CLOUD-LAYER.
              MIN: 00000        MAX:  35000       UNITS:  Meters
                                      SCALING FACTOR:  1
              DOM:  A general domain comprised of the numeric characters (0‑9).
                         99999 = Missing

FLD LEN: 1
                BELOW-STATION-CLOUD-LAYER top height dimension quality code
                The code that denotes a quality status of the reported BELOW-STATION-CLOUD-LAYER top height dimension.
                DOM:  A specific domain comprised of the characters in the ASCII character set.
                            0 = Passed gross limits check 
                            1 = Passed all quality control checks
                            2 = Suspect
                            3 = Erroneous
                            9 = Passed gross limits check if element is present
 
FLD LEN: 2
              BELOW-STATION-CLOUD-LAYER type code
              The code that denotes the classification of the clouds that comprise a BELOW-STATION-CLOUD-
              LAYER.
              DOM:  A specific domain comprised of the characters in the ASCII character set.
                         00: Cirrus (Ci)
                         01: Cirrocumulus (Cc)
                         02: Cirrostratus (Cs)
                         03: Altocumulus (Ac)
                         04: Altostratus (As)
                         05: Nimbostratus (Ns)
                         06: Stratocumulus (Sc)
                         07: Stratus (St)
                         08: Cumulus (Cu)
                         09: Cumulonimbus (Cb)
                         10: Cloud not visible owing to darkness, fog, dust storm, sandstorm, or other analogous
                               phenomena
                         99: Missing

FLD LEN: 1
                BELOW-STATION-CLOUD-LAYER type quality code
                The code that denotes a quality status of the reported BELOW-STATION-CLOUD-LAYER type.
                DOM:  A specific domain comprised of the characters in the ASCII character set.
                            0 = Passed gross limits check 
                            1 = Passed all quality control checks
                            2 = Suspect
                            3 = Erroneous
                            9 = Passed gross limits check if element is present

FLD LEN: 2
              BELOW-STATION-CLOUD-LAYER top code
              The code that denotes the characteristics of the upper surface of a BELOW-STATION-CLOUD-
              LAYER
              DOM:  A specific domain comprised of the characters in the ASCII character set.
                        00: Isolated cloud or fragments of clouds
                        01: Continuous flat tops
                        02: Broken cloud - small breaks, flat tops
                        03: Broken cloud - large breaks, flat tops
                        04: Continuous cloud, undulation tops
                        05: Broken cloud - small breaks, undulating tops
                        06: Broken cloud - large breaks, undulating tops
                        07: Continuous or almost continuous with towering clouds above the top of the layer
                        08: Groups of waves with towering clouds above the top of the layer
                        09: Two of more layers at different levels
                                                99: Missing

FLD LEN: 1
                BELOW-STATION-CLOUD-LAYER top quality code
                The code that denotes a quality status of the reported BELOW-STATION-CLOUD-LAYER top.
                DOM:  A specific domain comprised of the characters in the ASCII character set.
                            0 = Passed gross limits check 
                            1 = Passed all quality control checks
                            2 = Suspect
                            3 = Erroneous
                            9 = Passed gross limits check if element is present


 
 */
}
