package org.kempersoft.weather_parser.domain.weather.additionaldata.cloudandsolar;


import java.util.List;

/*Cloud and Solar Data

 

 
▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀          

                       FLD LEN: 3
              Solar Irradiance Section identifier
              The identifier that indicates an observation of solar irradiance data integrated over the specified
              time period.
               DOM: A specific domain comprised of the characters in the ASCII character set.
                        GM1  An indicator of the following items:
                                 Solar irradiance data time period
                                 Global irradiance 
                                 Global irradiance data flag
                                 Global irradiance quality code
                                 Direct beam irradiance 
                                 Direct beam irradiance data flag
                                 Direct beam irradiance quality code
                                 Diffuse irradiance 
                                 Diffuse irradiance data flag
                                 Diffuse irradiance quality code
                                 UVB global irradiance 
                                 UVB global irradiance data flag
                                 UVB global irradiance quality code

FLD LEN: 4
              Time period in minutes, for which the data in this section (GM1) pertains—eg, 0060 = 60 minutes (1 hour).
               MIN:   0001           MAX:   9998        UNITS:  Minutes
              DOM:  A general domain comprised of the numeric characters (0‑9).
                         9999 = Missing.

FLD LEN: 4
              Global irradiance 
              	              Global horizontal irradiance measured using a pyranometer.  Unit is watts per square
              	              meter
                                      (W/m2) in whole values.  Waveband ranges from 0.4 - 2.3 micrometers.
              MIN:  0000        MAX:  9998         UNITS: watts per square meter
              SCALING FACTOR: 1
              DOM:  A general domain comprised of the numeric characters (0‑9).
                         9999 = Missing.

FLD LEN: 2
              Global irradiance data flag
              The code that provides additional information regarding the global irradiance data.
              DOM:  A specific domain comprised of the numeric characters (00-99).
00 = Untested (raw data)
01 = Passed one-component test; data fall within max-min limits
of Kt, Kn, or Kd
02 = Passed two-component test; data fall within 0.03 of the
Gompertz boundaries
03 = Passed three-component test; data come within + 0.03 of
satisfying Kt = Kn + Kd
04 = Passed visual inspection: not used by SERI_QC1
05 = Failed visual inspection: not used by SERI_QC1
06 = Value estimated; passes all pertinent SERI_QC tests
07 = Failed one-component test; lower than allowed minimum
08 = Failed one-component test; higher than allowed maximum
09 = Passed three-component test but failed two-component test by
0.05
10-93 = Failed two- or three- component tests in one of four ways.
94-97 = Data fails into physically impossible region where Kn > Kt
by K-space distances of 0.05 to 0.10 (94), 0.10 to 0.15
(95), 0.15 to 0.20 (96), and > 0.20 (97).
98 = Not used
99 = Missing data

FLD LEN: 1
              Global irradiance quality code
                              The code that denotes a quality status of the reported global irradiance value.
              DOM:  A specific domain comprised of the numeric characters (0-9).
                          0 = Passed gross limits check 
                          1 = Passed all quality control checks
                          2 = Suspect
                          3 = Erroneous
	          9 = Missing

FLD LEN: 4
              Direct beam irradiance  
  Direct beam irradiance measured using a pyrheliometer or other instrument.  Unit is watts per square meter (W/m2) in 
  whole values.  Waveband ranges from 0.4 - 2.3 micrometers.  
              MIN:  0000        MAX:  9998         UNITS: watts per square meter
              SCALING FACTOR: 1
              DOM:  A general domain comprised of the numeric characters (0‑9).
                         9999 = Missing.

FLD LEN: 2
              Direct beam irradiance data flag
              The code that provides additional information regarding the direct beam irradiance data.
              DOM:  A specific domain comprised of the numeric characters (00-99).
00 = Untested (raw data)
01 = Passed one-component test; data fall within max-min limits
of Kt, Kn, or Kd
02 = Passed two-component test; data fall within 0.03 of the
Gompertz boundaries
03 = Passed three-component test; data come within + 0.03 of
satisfying Kt = Kn + Kd
04 = Passed visual inspection: not used by SERI_QC1
05 = Failed visual inspection: not used by SERI_QC1
06 = Value estimated; passes all pertinent SERI_QC tests
07 = Failed one-component test; lower than allowed minimum
08 = Failed one-component test; higher than allowed maximum
09 = Passed three-component test but failed two-component test by
0.05
10-93 = Failed two- or three- component tests in one of four ways.
94-97 = Data fails into physically impossible region where Kn > Kt
by K-space distances of 0.05 to 0.10 (94), 0.10 to 0.15
(95), 0.15 to 0.20 (96), and > 0.20 (97).
98 = Not used
99 = Missing data

FLD LEN: 1
              Direct beam irradiance quality code
                              The code that denotes a quality status of the reported direct beam irradiance value.
              DOM:  A specific domain comprised of the numeric characters (0-9).
                          0 = Passed gross limits check 
                          1 = Passed all quality control checks
                          2 = Suspect
                          3 = Erroneous
		          9 = Missing

FLD LEN: 4
              Diffuse irradiance  
              	              Diffuse irradiance measured using a pyranometer under a shading device.  Unit is watts
              	              per square meter (W/m2) in
                                      whole values.  Waveband ranges from 0.4 - 2.3 micrometers.  Instrument is
                                      mounted under a shadowband.
              MIN:  0000        MAX:  9998         UNITS: watts per square meter
              SCALING FACTOR: 1
              DOM:  A general domain comprised of the numeric characters (0‑9).
                         9999 = Missing.

FLD LEN: 2
              Diffuse irradiance data flag
              The code that provides additional information regarding the diffuse irradiance data.
              DOM:  A specific domain comprised of the numeric characters (00-99).
00 = Untested (raw data)
01 = Passed one-component test; data fall within max-min limits
of Kt, Kn, or Kd
02 = Passed two-component test; data fall within 0.03 of the
Gompertz boundaries
03 = Passed three-component test; data come within + 0.03 of
satisfying Kt = Kn + Kd
04 = Passed visual inspection: not used by SERI_QC1
05 = Failed visual inspection: not used by SERI_QC1
06 = Value estimated; passes all pertinent SERI_QC tests
07 = Failed one-component test; lower than allowed minimum
08 = Failed one-component test; higher than allowed maximum
09 = Passed three-component test but failed two-component test by
0.05
10-93 = Failed two- or three- component tests in one of four ways.
94-97 = Data fails into physically impossible region where Kn > Kt
by K-space distances of 0.05 to 0.10 (94), 0.10 to 0.15
(95), 0.15 to 0.20 (96), and > 0.20 (97).
98 = Not used
99 = Missing data

FLD LEN: 1
              Diffuse irradiance quality code
                              The code that denotes a quality status of the reported diffuse irradiance value.
              DOM:  A specific domain comprised of the numeric characters (0-9).
                          0 = Passed gross limits check 
                          1 = Passed all quality control checks
                          2 = Suspect
                          3 = Erroneous
		          9 = Missing

FLD LEN: 4
              UVB global irradiance  
              	              Ultra-violet global irradiance measured using a Ultra-violet Biometer (Solar Light).
              	              Unit is milli-watts per square
                                      meter (mW/m2) of erythema effective irradiance in whole values.  Waveband
                                      ranges from 290-320 nanometers.
              MIN:  0000        MAX:  9998         UNITS: milli-watts per square meter
              SCALING FACTOR: 1
              DOM:  A general domain comprised of the numeric characters (0‑9).
                         9999 = Missing.

FLD LEN: 1
              UVB global irradiance quality code
                              The code that denotes a quality status of the reported UVB global irradiance  value.
              DOM:  A specific domain comprised of the numeric characters (0-9).
                          0 = Passed gross limits check 
                          1 = Passed all quality control checks
                          2 = Suspect
                          3 = Erroneous
	          9 = Missing


▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀          

	FLD LEN: 3
              Solar Radiation Section identifier
              The identifier that indicates an observation of solar radiation data. 
               DOM: A specific domain comprised of the characters in the ASCII character set.
                        GN1  An indicator of the following items:
                                 Solar radiation data time period
                                 Upwelling global solar radiation
                                 Upwelling global solar radiation quality code
                                 Downwelling thermal infrared radiation 
                                 Downwelling thermal infrared radiation quality code
                                 Upwelling thermal infrared radiation
                                 Upwelling thermal infrared radiation quality code
                                 Photosynthetically active radiation  
                                 Photosynthetically active radiation quality code
                                 Solar zenith angle     
                                 Solar zenith angle quality code
     
FLD LEN: 4
              Time period in minutes, for which the data in this section (GN1) pertains—eg, 0060 = 60 minutes (1 hour).
              MIN:   0001           MAX:   9998        UNITS:  Minutes
              DOM:  A general domain comprised of the numeric characters (0‑9).
                         9999 = Missing.

FLD LEN: 4
              Upwelling global solar radiation  
              	              Global radiation measured using an Epply Precision Spectral Pyranometer mounted upside
              	              down ten meters above the                     surface on a meteorological tower.  Unit
              	              is milli-watts per square meter (mW/m2).  Waveband ranges from 270 to 3000
              	                      nanometers.
              MIN:  0000        MAX:  9998         UNITS: milli-watts per square meter
              SCALING FACTOR: 1
              DOM:  A general domain comprised of the numeric characters (0‑9).
                         9999 = Missing.

FLD LEN: 1
              Upwelling global solar radiation quality code
                              The code that denotes a quality status of the reported upwelling global solar radiation
                               value.
              DOM:  A specific domain comprised of the numeric characters (0-9).
                          0 = Passed gross limits check 
                          1 = Passed all quality control checks
                          2 = Suspect
                          3 = Erroneous
	          9 = Missing

FLD LEN: 4
              Downwelling thermal infrared radiation   
                      Infrared radiation measured using an Epply Precision Infrared Radiometer mounted upright ten
                      meters above the surface
                      on a meteorological tower.  Unit is milli-watts per square meter (mW/m2).  Waveband ranges from
                       3000 to 50,000
                      nanometers.
              MIN:  0000        MAX:  9998         UNITS: milli-watts per square meter
              SCALING FACTOR: 1
              DOM:  A general domain comprised of the numeric characters (0‑9).
                         9999 = Missing.

FLD LEN: 1
              Downwelling thermal infrared radiation quality code
                              The code that denotes a quality status of the reported downwelling thermal infrared
                              radiation value.
              DOM:  A specific domain comprised of the numeric characters (0-9).
                          0 = Passed gross limits check 
                          1 = Passed all quality control checks
                          2 = Suspect
                          3 = Erroneous
		          9 = Missing

FLD LEN: 4
              Upwelling thermal infrared radiation  
              	              Infrared radiation measured using an Epply Precision Infrared Radiometer mounted
              	              upside-down ten meters above the                      surface on a meteorological tower.
              	                Unit is Watts per meter per meter (mW/m2).  Waveband ranges from 3000 to 50,000
              	                            nanometers.
              MIN:  0000        MAX:  9998         UNITS: watts per square meter
              SCALING FACTOR: 1
              DOM:  A general domain comprised of the numeric characters (0‑9).
                         9999 = Missing.

FLD LEN: 1
              Upwelling thermal infrared radiation quality code
                              The code that denotes a quality status of the reported upwelling thermal infrared
                              radiation value.
              DOM:  A specific domain comprised of the numeric characters (0-9).
                          0 = Passed gross limits check 
                          1 = Passed all quality control checks
                          2 = Suspect
                          3 = Erroneous
		          9 = Missing

FLD LEN: 4
              Photosynthetically active radiation    
              	              The PAR sensor measures global solar radiation from 400 to 700 nm in Watts per square
              	              meter (mW/m2), which                                approximates the spectral band
              	              active in photosynthesis.
              MIN:  0000        MAX:  9998         UNITS: watts per square meter
              SCALING FACTOR: 1
              DOM:  A general domain comprised of the numeric characters (0‑9).
                         9999 = Missing.

FLD LEN: 1
              Photosynthetically active radiation quality code
                              The code that denotes a quality status of the reported photosynthetically active
                              radiation value.
              DOM:  A specific domain comprised of the numeric characters (0-9).
                          0 = Passed gross limits check 
                          1 = Passed all quality control checks
                          2 = Suspect
                          3 = Erroneous
	          9 = Missing

FLD LEN: 3
              Solar zenith angle     
              The Solar Zenith Angle is the angle in degrees between the sun and the perpendicular to the earth’s
              surface.  At sunrise it                 is 90 degrees, at noon it is a function of latitude, and at
              sunset it is again 90 degrees.  Below the horizon value is 100.                       Values are
              reported to the nearest tens of degrees (eg, 090).
              MIN:  000        MAX:  998         UNITS: angular degrees 
              SCALING FACTOR: 1
              DOM:  A general domain comprised of the numeric characters (0‑9).
                         999 = Missing.

FLD LEN: 1
              Solar zenith angle quality code
                              The code that denotes a quality status of the reported solar zenith angle value.
              DOM:  A specific domain comprised of the numeric characters (0-9).
                          0 = Passed gross limits check 
                          1 = Passed all quality control checks
                          2 = Suspect
                          3 = Erroneous
	          9 = Missing


▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀          

         	 FLD LEN: 3
              Net Solar Radiation Section identifier
              The identifier that indicates an observation of net solar radiation data. 
               DOM: A specific domain comprised of the characters in the ASCII character set.
                        GO1  An indicator of the following items:
                                 Net solar radiation data time period
                                 Net solar radiation
                                 Net solar radiation quality code
                                 Net infrared radiation 
                                 Net infrared radiation quality code
                                 Net radiation 
                                 Net radiation quality code

FLD LEN: 4
              Time period in minutes, for which the data in this section (GO1) pertains—eg, 0060 = 60 minutes (1 hour).
              MIN:   0001           MAX:   9998        UNITS:  Minutes
              DOM:  A general domain comprised of the numeric characters (0‑9).
                         9999 = Missing.

FLD LEN: 4
              Net solar radiation   
              	              The difference between global radiation and upwelling global radiation measured in Watts
              	               per square meter (W/m2).  If
                                       negative, left most position contains a "-" sign.
              MIN:  -999        MAX:  9998         UNITS: watts per square meter
              SCALING FACTOR: 1
              DOM:  A general domain comprised of the numeric characters (0‑9).
                         9999 = Missing.

FLD LEN: 1
              Net solar radiation quality code
                              The code that denotes a quality status of the reported net solar radiation value.
              DOM:  A specific domain comprised of the numeric characters (0-9).
                          0 = Passed gross limits check 
                          1 = Passed all quality control checks
                          2 = Suspect
                          3 = Erroneous
	          9 = Missing

FLD LEN: 4
              Net infrared radiation    
                                      The difference between downwelling infrared and upwelling infrared measured in
                                      Watts per square meter (W/m2).  If
                                      negative, left most position contains a "-" sign.
              MIN:  -999        MAX:  9998         UNITS: watts per square meter
              SCALING FACTOR: 1
              DOM:  A general domain comprised of the numeric characters (0‑9).
                         9999 = Missing.

FLD LEN: 1
              Net infrared radiation quality code
                              The code that denotes a quality status of the reported net infrared radiation value.
              DOM:  A specific domain comprised of the numeric characters (0-9).
                          0 = Passed gross limits check 
                          1 = Passed all quality control checks
                          2 = Suspect
                          3 = Erroneous
		          9 = Missing

FLD LEN: 4
              Net radiation   
              	              The total of Net Solar and Net Infrared radiation measured in Watts per square meter
              	              (W/m2).
              MIN:  -999        MAX:  9998         UNITS: watts per square meter
              SCALING FACTOR: 1
              DOM:  A general domain comprised of the numeric characters (0‑9).
                         9999 = Missing.

FLD LEN: 1
              Net radiation quality code
                              The code that denotes a quality status of the reported net radiation value.
              DOM:  A specific domain comprised of the numeric characters (0-9).
                          0 = Passed gross limits check 
                          1 = Passed all quality control checks
                          2 = Suspect
                          3 = Erroneous
		          9 = Missing

▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀          

                         FLD LEN: 3
               Modeled  Solar Irradiance Section identifier
               The identifier that indicates modeled broadband solar irradiance data integrated over the specified
               time period.
               DOM: A specific domain comprised of the characters in the ASCII character set.
                        GP1  An indicator of the following items:
                                 Modeled solar irradiance data time period
                                 Modeled global horizontal 
                                 Modeled global horizontal source flag
                                 Modeled global horizontal uncertainty
                                 Modeled direct normal 
                                 Modeled direct normal source flag
                                 Modeled direct normal  uncertainty
                                 Modeled diffuse horizontal 
                                 Modeled diffuse horizontal source flag
                                 Modeled diffuse horizontal uncertainty

FLD LEN: 4
              Time period in minutes, for which the data in this section pertains—eg, 0060 = 60 minutes (1 hour).
              MIN:   0001           MAX:   9998        UNITS:  Minutes
              DOM:  A general domain comprised of the numeric characters (0‑9).
                         9999 = Missing.

FLD LEN: 4
              Modeled global horizontal 
              	              Total amount of direct and diffuse solar radiation (modeled) received on a horizontal
              	              surface.  Unit is watts per
                                      square meter (W/m2) in  whole values.  
              MIN:  0000        MAX:  9998         UNITS: watts per square meter
              SCALING FACTOR: 1
              DOM:  A general domain comprised of the numeric characters (0‑9).
                         9999 = Missing.

FLD LEN: 2
              Modeled global horizontal source  flag
              The code that provides source information regarding the global horizontal data.
              DOM:  A specific domain comprised of the numeric characters (00-99).
01 = Value modeled from METSTAT model
02 = Value time-shifted from SUNY satellite model
03 =  Value time-shifted from SUNY satellite model, adjusted to a minimum low-diffuse envelope
99 = Missing data 

FLD LEN: 3
              Modeled global horizontal uncertainty
             The uncertainty values are based on model type and quality of input data.
              MIN:   000           MAX:   100        UNITS:  Percent
              SCALING FACTOR: 1
              DOM:  A general domain comprised of the numeric characters (0‑9).
                         999 = Missing data

FLD LEN: 4
              Modeled direct normal   
              	             The amount of solar radiation (modeled) on a surface normal to the sun. Unit is watts per
              	              square meter (W/m2) in
                                      whole values.              
              MIN:  0000        MAX:  9998         UNITS: watts per square meter
              SCALING FACTOR: 1
              DOM:  A general domain comprised of the numeric characters (0‑9).
                         9999 = Missing.

FLD LEN: 2
              Modeled direct normal source  flag
               The code that provides source information regarding the direct normal data.
               DOM:  A specific domain comprised of the numeric characters (00-99).
01 = Value modeled from METSTAT model
02 = Value time-shifted from SUNY satellite model
03 =  Value time-shifted from SUNY satellite model, adjusted to a minimum low-diffuse envelope
                99 = Missing data 

FLD LEN: 3
             Modeled direct normal uncertainty
             The uncertainty values are based on model type and quality of input data.
              MIN:   000           MAX:   100        UNITS:  Percent
              SCALING FACTOR: 1
              DOM:  A general domain comprised of the numeric characters (0‑9).
                        999 = Missing data

FLD LEN: 4
              Modeled diffuse horizontal  
              	              The amount of solar radiation (modeled) received from the sky (excluding the solar disk)
              	               on a horizontal surface.
                                      Unit is watts per square meter (W/m2) in whole values.  Waveband ranges from
                                      0.4 - 2.3 micrometers.
              MIN:  0000        MAX:  9998         UNITS: watts per square meter
              SCALING FACTOR: 1
              DOM:  A general domain comprised of the numeric characters (0‑9).
                         9999 = Missing.

FLD LEN: 2
              Modeled diffuse horizontal source flag
              The code that provides source information regarding the diffuse horizontal data.
              DOM:  A specific domain comprised of the numeric characters (00-99).
01 = Value modeled from METSTAT model
02 = Value time-shifted from SUNY satellite model
03 =  Value time-shifted from SUNY satellite model, adjusted to a minimum low-diffuse envelope
99 = Missing data 

FLD LEN: 3
             Modeled diffuse horizontal uncertainty
             The uncertainty values are based on model type and quality of input data.
              MIN:   000           MAX:   100        UNITS:  Percent
              SCALING FACTOR: 1
              DOM:  A general domain comprised of the numeric characters (0‑9)
                         999 = Missing data

▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀          


                        FLD LEN: 3
                                        Hourly Solar Angle Section identifier
                 The identifier that denotes the start of the Hourly Solar angle data section.
                 DOM:  A specific domain comprised of the characters in the ASCII character set.
                 GQ1    An indicator of the occurrence of the following items:
                            Hourly solar angle time period                        
                            Hourly mean zenith angle
                            Hourly mean zenith angle quality code
                            Hourly mean azimuth angle
                            Hourly mean azimuth angle quality code

FLD LEN: 4
              Time period in minutes, for which the data in this section pertains—eg, 0060 = 60 minutes (1 hour).
              MIN:   0001           MAX:   9998        UNITS:  Minutes
              DOM:  A general domain comprised of the numeric characters (0‑9).
                        9999 = Missing data

FLD LEN: 4
                Hourly mean zenith angle (for sunup periods)
                The angle between sun and the zenith as the mean of all 1-minute sunup zenith angle values. 
                MIN:  0000          MAX:  3600        UNITS: Angular Degrees
                SCALING FACTOR: 10
                DOM:  A general domain comprised of the numeric characters (0‑9).
                           9999 = Missing data

FLD LEN: 1
             Hourly mean zenith angle quality code
                              The code that denotes a quality status of the hourly mean zenith angle.
              DOM:  A specific domain comprised of the numeric characters (0-9).
                          0 = Passed gross limits check 
                          1 = Passed all quality control checks
                          2 = Suspect
                          3 = Erroneous
		          9 = Missing

FLD LEN: 4
                Hourly mean azimuth angle (for sunup periods)
                The angle between sun and north as the mean of all 1-minute sunup azimuth angle values. 
                MIN:  0000          MAX:  3600        UNITS: Angular Degrees
                SCALING FACTOR: 10
                DOM:  A general domain comprised of the numeric characters (0‑9).
                          9999 = Missing data

FLD LEN: 1
             Hourly mean azimuth angle quality code
                              The code that denotes a quality status of the hourly mean azimuth angle.
              DOM:  A specific domain comprised of the numeric characters (0-9).
                          0 = Passed gross limits check 
                          1 = Passed all quality control checks
                          2 = Suspect
                          3 = Erroneous
		          9 = Missing

▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀          

                        FLD LEN: 3
                                        Hourly Extraterrestrial Radiation Section identifier
                 The identifier that denotes the start of the  Hourly Extraterrestrial radiation  data section.
                 DOM:  A specific domain comprised of the characters in the ASCII character set.
                 GR1    An indicator of the occurrence of the following items:
                            Hourly extraterrestrial radiation time period                        
                            Hourly extraterrestrial radiation on a horizontal surface
                            Hourly extraterrestrial radiation on a horizontal surface quality code
                            Hourly extraterrestrial radiation normal to the sun
                            Hourly extraterrestrial radiation normal to the sun quality code

FLD LEN: 4
              Time period in minutes, for which the data in this section pertains—eg, 0060 = 60 minutes (1 hour).
              MIN:   0001           MAX:   9998        UNITS:  Minutes
              SCALING FACTOR: 1
              DOM:  A general domain comprised of the numeric characters (0‑9).
                        9999 = Missing data

FLD LEN: 4
               Hourly extraterrestrial radiation on a horizontal surface
                                       The amount of solar radiation received (modeled)  on a horizontal surface at
                                       the top of the atmosphere. Unit is watts per
                                        square meter (W/m2) in whole values.              
                MIN:  0000        MAX:  9998         UNITS: watts per square meter
                SCALING FACTOR: 1
                DOM:  A general domain comprised of the numeric characters (0‑9).
                          9999 = Missing data

FLD LEN: 1
             Hourly extraterrestrial radiation on a horizontal surface quality code
                              The code that denotes a quality status of the hourly extraterrestrial radiation on a
                              horizontal surface value .
              DOM:  A specific domain comprised of the numeric characters (0-9).
                          0 = Passed gross limits check 
                          1 = Passed all quality control checks
                          2 = Suspect
                          3 = Erroneous
		          9 = Missing

FLD LEN: 4
               Hourly extraterrestrial radiation normal to the sun
                                       The amount of solar radiation received (modeled) on a surface normal to the
                                       sun at the top of the atmosphere. Unit is
                                        watts per square meter (W/m2) in whole values.              
                MIN:  0000        MAX:  9998         UNITS: watts per square meter
                SCALING FACTOR: 1
                DOM:  A general domain comprised of the numeric characters (0‑9).
                           9999 = Missing data

FLD LEN: 1
              Hourly extraterrestrial radiation normal to the sun quality code
                              The code that denotes a quality status of the hourly extraterrestrial radiation normal
                              to the sun value.
              DOM:  A specific domain comprised of the numeric characters (0-9).
                          0 = Passed gross limits check 
                          1 = Passed all quality control checks
                          2 = Suspect
                          3 = Erroneous
		          9 = Missing

▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀          
*/

public class AdditionalDataCloudAndSolar {

  private List<SkyCoverLayer> skyCoverLayers;              // GA1 - GA6
  private List<SkyCoverSummation> skyCoverSummations;          // GD1 - G6
  private SkyConditionObservationGroup1 skyConditionObservationGroup1;  // GE1
  private SkyConditionObservationGroup2 skyConditionObservationGroup2;  // GF1
  private List<BelowStationCloudLayer> belowStationCloudLayers;    // GG1 - GG6
  private HourlySolarRadiation hourlySolarRadiation;          // GH1
  private SunshineObservationDuration sunshineObservationDuration;  // GJ1
  private SunshineObservationPercent sunshineObservationPercent;    // GK1
  private SunshineObservationMonthly sunshineObservationMonthly;    // GL1

  public List<SkyCoverLayer> getSkyCoverLayers() {
    return skyCoverLayers;
  }

  public void setSkyCoverLayers( List<SkyCoverLayer> skyCoverLayers ) {
    this.skyCoverLayers = skyCoverLayers;
  }

  public List<SkyCoverSummation> getSkyCoverSummations() {
    return skyCoverSummations;
  }

  public void setSkyCoverSummations( List<SkyCoverSummation> skyCoverSummations ) {
    this.skyCoverSummations = skyCoverSummations;
  }

  public SkyConditionObservationGroup1 getSkyConditionObservationGroup1() {
    return skyConditionObservationGroup1;
  }

  public void setSkyConditionObservationGroup1( SkyConditionObservationGroup1 skyConditionObservationGroup1 ) {
    this.skyConditionObservationGroup1 = skyConditionObservationGroup1;
  }

  public SkyConditionObservationGroup2 getSkyConditionObservationGroup2() {
    return skyConditionObservationGroup2;
  }

  public void setSkyConditionObservationGroup2( SkyConditionObservationGroup2 skyConditionObservationGroup2 ) {
    this.skyConditionObservationGroup2 = skyConditionObservationGroup2;
  }

  public List<BelowStationCloudLayer> getBelowStationCloudLayers() {
    return belowStationCloudLayers;
  }

  public void setBelowStationCloudLayers( List<BelowStationCloudLayer> belowStationCloudLayers ) {
    this.belowStationCloudLayers = belowStationCloudLayers;
  }

  public HourlySolarRadiation getHourlySolarRadiation() {
    return hourlySolarRadiation;
  }

  public void setHourlySolarRadiation( HourlySolarRadiation hourlySolarRadiation ) {
    this.hourlySolarRadiation = hourlySolarRadiation;
  }

  public SunshineObservationDuration getSunshineObservationDuration() {
    return sunshineObservationDuration;
  }

  public void setSunshineObservationDuration( SunshineObservationDuration sunshineObservationDuration ) {
    this.sunshineObservationDuration = sunshineObservationDuration;
  }

  public SunshineObservationPercent getSunshineObservationPercent() {
    return sunshineObservationPercent;
  }

  public void setSunshineObservationPercent( SunshineObservationPercent sunshineObservationPercent ) {
    this.sunshineObservationPercent = sunshineObservationPercent;
  }

  public SunshineObservationMonthly getSunshineObservationMonthly() {
    return sunshineObservationMonthly;
  }

  public void setSunshineObservationMonthly( SunshineObservationMonthly sunshineObservationMonthly ) {
    this.sunshineObservationMonthly = sunshineObservationMonthly;
  }
}
