package org.kempersoft.weather_parser.domain.weather.additionaldata.precipitation;

import java.util.List;

/**
 * Created by bkemper on 3/3/17.
 */
public class AdditionalDataPrecipitation {

  private List<LiquidPrecipitationOccurence> liquidPrecipitationOccurences;
  private LiquidPrecipitationMonthlyTotal liquidPrecipitationMonthlyTotal;
  private PrecipitationObservationHistory precipitationObservationHistory;



  public LiquidPrecipitationMonthlyTotal getLiquidPrecipitationMonthlyTotal() {
    return liquidPrecipitationMonthlyTotal;
  }

  public void setLiquidPrecipitationMonthlyTotal(
    LiquidPrecipitationMonthlyTotal liquidPrecipitationMonthlyTotal ) {
    this.liquidPrecipitationMonthlyTotal = liquidPrecipitationMonthlyTotal;
  }

  public List<LiquidPrecipitationOccurence> getLiquidPrecipitationOccurences() {
    return liquidPrecipitationOccurences;
  }

  public void setLiquidPrecipitationOccurences(
    List<LiquidPrecipitationOccurence> liquidPrecipitationOccurences ) {
    this.liquidPrecipitationOccurences = liquidPrecipitationOccurences;
  }

  public PrecipitationObservationHistory getPrecipitationObservationHistory() {
    return precipitationObservationHistory;
  }

  public void setPrecipitationObservationHistory(
    PrecipitationObservationHistory precipitationObservationHistory ) {
    this.precipitationObservationHistory = precipitationObservationHistory;
  }

  @Override public String toString() {
    return "AdditionalDataPrecipitation{" +
      "liquidPrecipitationOccurences=" + liquidPrecipitationOccurences +
      ", liquidPrecipitationMonthlyTotal=" + liquidPrecipitationMonthlyTotal +
      ", precipitationObservationHistory=" + precipitationObservationHistory +
      '}';
  }

/*  Precipitation Data


  FLD LEN: 3
  PRECIPITATION-OBSERVATION-HISTORY identifier
  The identifier that indicates the occurrence of precipitation history information.
  DOM:  A specific domain comprised of the characters in the ASCII character set.
  AC1  An indicator of the following items:
  PRECIPITATION-OBSERVATION-HISTORY duration code
  PRECIPITATION-OBSERVATION-HISTORY characteristic code
  PRECIPITATION-OBSERVATION-HISTORY quality code

  FLD LEN: 1
  PRECIPITATION-OBSERVATION-HISTORY duration code
  The code that denotes the duration of precipitation.
  DOM:  A specific domain comprised of the characters in the ASCII character set.
    0 = Lasted less than 1 hour
                                          1 = Lasted 1 - 3 hours
                                          2 = Lasted 3 - 6 hours
                                          3 = Lasted more than 6 hours
                                          9 = Missing

  FLD LEN: 1
  PRECIPITATION-OBSERVATION-HISTORY characteristic code
  The code that denotes whether precipitation is continuous or intermittent.
  DOM:  A specific domain comprised of the characters in the ASCII character set.
  C = Continuous
    I = Intermittent
                         9 = Missing

  FLD LEN: 1
  PRECIPITATION duration/characteristic quality code
  The code that denotes a quality status of the reported PRECIPITATION duration/characteristic.
    DOM:  A specific domain comprised of the characters in the ASCII character set.
    0 = Passed gross limits check
                            1 = Passed all quality control checks
                            2 = Suspect
                            3 = Erroneous
                            9 = Passed gross limits check if element is present
    A = Data value flagged as suspect, but accepted as good value
  I = Data value not originally in data, but inserted by validator
    M = Manual change made to value based on information provided by NWS or FAA
  P = Data value not originally flagged as suspect, but replaced by validator
  R = Data value replaced with value computed by NCEI software
    U = Data value replaced with edited value


▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀

  FLD LEN: 3
  LIQUID-PRECIPITATION GREATEST AMOUNT IN 24 HOURS, FOR THE MONTH identifier
  The identifier that represents LIQUID-PRECIPITATION, GREATEST IN 24 HOURS, data.
    DOM: A specific domain comprised of the characters in the ASCII character set.
  AD1   An indicator of the following items:
  LIQUID-PRECIPITATION depth dimension
  LIQUID-PRECIPITATION condition code
  LIQUID-PRECIPITATION dates of occurrence (3 fields)
  LIQUID-PRECIPITATION quality code

  FLD LEN: 5
  LIQUID-PRECIPITATION GREATEST AMOUNT IN 24 HOURS, FOR THE MONTH depth dimension
  The depth of LIQUID-PRECIPITATION for the 24-hour period.
  MIN:  00000        MAX:  20000         UNITS:  millimeters
  SCALING FACTOR: 10
  DOM:  A general domain comprised of the numeric characters (0‑9).
    99999 = Missing.

  FLD LEN: 1
  LIQUID-PRECIPITATION GREATEST AMOUNT IN 24 HOURS, FOR THE MONTH condition code
  The code that denotes whether a LIQUID-PRECIPITATION depth dimension was a trace value.
    DOM:  A specific domain comprised of the characters in the ASCII character set.
    1: Measurement impossible or inaccurate
                         2: Trace
                         3: The amount occurred on other dates in addition to those listed
                         4: Trace amount occurred on other dates in addition to those listed
                                          9: Missing or N/A

  FLD LEN: 4
  LIQUID-PRECIPITATION GREATEST AMOUNT IN 24 HOURS, FOR THE MONTH dates of occurrence
  The dates of occurrence of LIQUID-PRECIPITATION, given as the begin-end date for the 24-hour period, for
  up to 3 occurrences; e.g., 0405 indicates 24-hour period on days 04-05.
  MIN:  0101        MAX:  3131
  DOM:  A general domain comprised of the numeric characters (0‑9).
    9999 = Missing.

  FLD LEN: 4
  LIQUID-PRECIPITATION GREATEST AMOUNT IN 24 HOURS, FOR THE MONTH dates of occurrence
  The dates of occurrence of LIQUID-PRECIPITATION, given as the begin-end date for the 24-hour period, for
  up to 3 occurrences; e.g., 0405 indicates 24-hour period on days 04-05.
  MIN:  0101        MAX:  3131
  DOM:  A general domain comprised of the numeric characters (0‑9).
    9999 = Missing.

  FLD LEN: 4
  LIQUID-PRECIPITATION GREATEST AMOUNT IN 24 HOURS, FOR THE MONTH dates of occurrence
  The dates of occurrence of LIQUID-PRECIPITATION, given as the begin-end date for the 24-hour period, for
  up to 3 occurrences; e.g., 0405 indicates 24-hour period on days 04-05.
  MIN:  0101        MAX:  3131
  DOM:  A general domain comprised of the numeric characters (0‑9).
    9999 = Missing.

  FLD LEN: 1
  LIQUID-PRECIPITATION GREATEST AMOUNT IN 24 HOURS, FOR THE MONTH quality code
  The code that denotes a quality status of the reported LIQUID-PRECIPITATION data.
  DOM:  A specific domain comprised of the characters in the ASCII character set.
    0 = Passed gross limits check
                            1 = Passed all quality control checks
                            2 = Suspect
                            3 = Erroneous
                            4 = Passed gross limits check , data originate from an NCEI data source
                            5 = Passed all quality control checks, data originate from an NCEI data source
                            6 = Suspect, data originate from an NCEI data source
                            7 = Erroneous, data originate from an NCEI data source
                            9 = Passed gross limits check if element is present
    A = Data value flagged as suspect, but accepted as good value
  I = Data value not originally in data, but inserted by validator
    M = Manual change made to value based on information provided by NWS or FAA
  P = Data value not originally flagged as suspect, but replaced by validator
  R = Data value replaced with value computed by NCEI software
    U = Data value replaced with edited value

▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀

  FLD LEN: 3
  LIQUID-PRECIPITATION, NUMBER OF DAYS WITH SPECIFIC AMOUNTS, FOR THE MONTH identifier
  The identifier that represents NUMBER OF DAYS WITH LIQUID-PRECIPITATION data.
  DOM: A specific domain comprised of the characters in the ASCII character set.
  AE1   An indicator of the following items:
  LIQUID-PRECIPITATION number of days with .01 inch or more
  LIQUID-PRECIPITATION quality code
  LIQUID-PRECIPITATION number of days with .10 inch or more
  LIQUID-PRECIPITATION quality code
  LIQUID-PRECIPITATION number of days with .50 inch or more
  LIQUID-PRECIPITATION quality code
  LIQUID-PRECIPITATION number of days with 1.00 inch or more
  LIQUID-PRECIPITATION quality code

  FLD LEN: 2
  LIQUID-PRECIPITATION, NUMBER OF DAYS WITH SPECIFIC AMOUNTS, FOR THE MONTH
  The number of days with .01 inch (.25 mm) or more precipitation.
  MIN:  00        MAX:  31
  DOM:  A general domain comprised of the numeric characters (0‑9).
    99 = Missing.

  FLD LEN: 1
  LIQUID-PRECIPITATION, NUMBER OF DAYS WITH SPECIFIC AMOUNTS, FOR THE MONTH quality code
  The code that denotes a quality status of the reported days with .01 or more.
  DOM:  A specific domain comprised of the characters in the ASCII character set.
    0 = Passed gross limits check
                            1 = Passed all quality control checks
                            2 = Suspect
                            3 = Erroneous
                            4 = Passed gross limits check , data originate from an NCEI data source
                            5 = Passed all quality control checks, data originate from an NCEI data source
                            6 = Suspect, data originate from an NCEI data source
                            7 = Erroneous, data originate from an NCEI data source
            9 = Passed gross limits check if element is present
    A = Data value flagged as suspect, but accepted as good value
  I = Data value not originally in data, but inserted by validator
    M = Manual change made to value based on information provided by NWS or FAA
  P = Data value not originally flagged as suspect, but replaced by validator
  R = Data value replaced with value computed by NCEI software
    U = Data value replaced with edited value


  FLD LEN: 2
  LIQUID-PRECIPITATION, NUMBER OF DAYS WITH SPECIFIC AMOUNTS, FOR THE MONTH
  The number of days with .10 inch (2.5 mm) or more precipitation.
  MIN:  00        MAX:  31
  DOM:  A general domain comprised of the numeric characters (0‑9).
    99 = Missing.

  FLD LEN: 1
  LIQUID-PRECIPITATION, NUMBER OF DAYS WITH SPECIFIC AMOUNTS, FOR THE MONTH quality code
  The code that denotes a quality status of the reported days with .10 or more.
  DOM:  A specific domain comprised of the characters in the ASCII character set.
    0 = Passed gross limits check
                            1 = Passed all quality control checks
                            2 = Suspect
                            3 = Erroneous
                            4 = Passed gross limits check , data originate from an NCEI data source
                            5 = Passed all quality control checks, data originate from an NCEI data source
                            6 = Suspect, data originate from an NCEI data source
                            7 = Erroneous, data originate from an NCEI data source
            9 = Passed gross limits check if element is present
    A = Data value flagged as suspect, but accepted as good value
  I = Data value not originally in data, but inserted by validator
    M = Manual change made to value based on information provided by NWS or FAA
  P = Data value not originally flagged as suspect, but replaced by validator
  R = Data value replaced with value computed by NCEI software
    U = Data value replaced with edited value


  FLD LEN: 2
  LIQUID-PRECIPITATION, NUMBER OF DAYS WITH SPECIFIC AMOUNTS, FOR THE MONTH
  The number of days with .50 inch (12.7 mm) or more precipitation.
  MIN:  00        MAX:  31
  DOM:  A general domain comprised of the numeric characters (0‑9).
    99 = Missing.

  FLD LEN: 1
  LIQUID-PRECIPITATION, NUMBER OF DAYS WITH SPECIFIC AMOUNTS, FOR THE MONTH quality code
  The code that denotes a quality status of the reported days with .50 or more.
  DOM:  A specific domain comprised of the characters in the ASCII character set.
    0 = Passed gross limits check
                            1 = Passed all quality control checks
                            2 = Suspect
                            3 = Erroneous
                            4 = Passed gross limits check , data originate from an NCEI data source
                            5 = Passed all quality control checks, data originate from an NCEI data source
                            6 = Suspect, data originate from an NCEI data source
                            7 = Erroneous, data originate from an NCEI data source
                            9 = Passed gross limits check if element is present
    A = Data value flagged as suspect, but accepted as good value
  I = Data value not originally in data, but inserted by validator
    M = Manual change made to value based on information provided by NWS or FAA
  P = Data value not originally flagged as suspect, but replaced by validator
  R = Data value replaced with value computed by NCEI software
    U = Data value replaced with edited value

  FLD LEN: 2
  LIQUID-PRECIPITATION, NUMBER OF DAYS WITH SPECIFIC AMOUNTS, FOR THE MONTH
  The number of days with 1.00 inch (25 mm) or more precipitation.
  MIN:  00        MAX:  31
  DOM:  A general domain comprised of the numeric characters (0‑9).
    99 = Missing.

  FLD LEN: 1
  LIQUID-PRECIPITATION, NUMBER OF DAYS WITH SPECIFIC AMOUNTS, FOR THE MONTH quality code
  The code that denotes a quality status of the reported days with 1.00 or more.
  DOM:  A specific domain comprised of the characters in the ASCII character set.
    0 = Passed gross limits check
                            1 = Passed all quality control checks
                            2 = Suspect
                            3 = Erroneous
                            4 = Passed gross limits check , data originate from an NCEI data source
                            5 = Passed all quality control checks, data originate from an NCEI data source
                            6 = Suspect, data originate from an NCEI data source
                            7 = Erroneous, data originate from an NCEI data source
                            9 = Passed gross limits check if element is present
    A = Data value flagged as suspect, but accepted as good value
  I = Data value not originally in data, but inserted by validator
    M = Manual change made to value based on information provided by NWS or FAA
  P = Data value not originally flagged as suspect, but replaced by validator
  R = Data value replaced with value computed by NCEI software
    U = Data value replaced with edited value

▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀

  FLD LEN: 3
  PRECIPITATION-ESTIMATED-OBSERVATION identifier
  The identifier that represents a PRECIPITATION-ESTIMATED-OBSERVATION, from AFCCC.
  DOM: A specific domain comprised of the characters in the ASCII character set.
  AG1  An indicator of the occurrence of the following items:
  PRECIPITATION-OBSERVATION discrepancy code
  PRECIPITATION-OBSERVATION estimated water depth dimension

  FLD LEN: 1
  PRECIPITATION-ESTIMATED-OBSERVATION discrepancy code
  The code that denotes the type of discrepancy between a PRECIPITATION‑OBSERVATION and other related observations at the same location.
    DOM:  A specific domain comprised of the characters in the ASCII character set.
    0: Reported amount of precipitation and reported weather agree
              		1: Precipitation missing or not reported and none inferred by weather
              		2: Precipitation missing, but precipitation inferred by weather
              		3: Precipitation reported, but none inferred by weather
              		4: Zero precipitation reported, but precipitation inferred by weather
              	5: Zero precipitation reported, no precipitation inferred and precipitation not occurring at the reporting station
              		9: Missing

  FLD LEN: 3
  PRECIPITATION-ESTIMATED-OBSERVATION estimated water depth dimension
  The estimated depth of precipitation in water depth for a 3-hour synoptic period.
    MIN:  000        MAX:  998       UNITS: millimeters
  SCALING FACTOR:  1
  DOM:  A general domain comprised of the numeric characters (0‑9).
    999 = Missing.

▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀

  FLD LEN: 3
  LIQUID-PRECIPITATION MAXIMUM SHORT DURATION, FOR THE MONTH identifier
  The identifier that represents MAXIMUM SHORT DURATION PRECIPITATION data.
    DOM: A specific domain comprised of the characters in the ASCII character set.
  AH1-AH6:  An indicator of up to 6 repeating fields for the following items:
  LIQUID-PRECIPITATION period quantity
  LIQUID-PRECIPITATION depth dimension
  LIQUID-PRECIPITATION condition code
  LIQUID-PRECIPITATION end date
  LIQUID-PRECIPITATION end time
  LIQUID-PRECIPITATION quality code

  FLD LEN: 3
  LIQUID-PRECIPITATION MAXIMUM SHORT DURATION, FOR THE MONTH period quantity
  The quantity of time over which the LIQUID-PRECIPITATION was measured.
    MIN:  005        MAX:  045        UNITS:  Minutes
  SCALING FACTOR:  1
  DOM:  A specific domain comprised of the characters in the ASCII character set
                           999 = Missing.

  FLD LEN: 4
  LIQUID-PRECIPITATION MAXIMUM SHORT DURATION, FOR THE MONTH depth dimension
  The depth of LIQUID-PRECIPITATION for the defined time period.
  MIN:  0000        MAX:  3000         UNITS:  millimeters
  SCALING FACTOR: 10
  DOM:  A general domain comprised of the numeric characters (0‑9).
    9999 = Missing.

  FLD LEN: 1
  LIQUID-PRECIPITATION MAXIMUM SHORT DURATION, FOR THE MONTH condition code
  The code that denotes whether a LIQUID-PRECIPITATION depth dimension was a trace value.
    DOM:  A specific domain comprised of the characters in the ASCII character set.
    1: Measurement impossible or inaccurate
                         2: Trace
                                          9: Missing

  FLD LEN: 6
  LIQUID-PRECIPITATION MAXIMUM SHORT DURATION, FOR THE MONTH ending date-time
  The ending date of occurrence of the event , given as the date-time in GMT; e.g., 051010 indicates
                1010 Z-time on day 05 of the month.
    MIN:  010000        MAX:  312359
  DOM:  A general domain comprised of the numeric characters (0‑9).
    999999 = Missing.

  FLD LEN: 1
  LIQUID-PRECIPITATION MAXIMUM SHORT DURATION, FOR THE MONTH quality code
  The code that denotes a quality status of the reported LIQUID-PRECIPITATION data.
  DOM:  A specific domain comprised of the characters in the ASCII character set.
    0 = Passed gross limits check
                            1 = Passed all quality control checks
                            2 = Suspect
                            3 = Erroneous
                            4 = Passed gross limits check , data originate from an NCEI data source
                            5 = Passed all quality control checks, data originate from an NCEI data source
                            6 = Suspect, data originate from an NCEI data source
                            7 = Erroneous, data originate from an NCEI data source
           9 = Passed gross limits check if element is present
    A = Data value flagged as suspect, but accepted as good value
  I = Data value not originally in data, but inserted by validator
    M = Manual change made to value based on information provided by NWS or FAA
  P = Data value not originally flagged as suspect, but replaced by validator
  R = Data value replaced with value computed by NCEI software
    U = Data value replaced with edited value

▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀

  FLD LEN: 3
  LIQUID-PRECIPITATION MAXIMUM SHORT DURATION, FOR THE MONTH identifier
  The identifier that represents MAXIMUM SHORT DURATION PRECIPITATION data.
    DOM: A specific domain comprised of the characters in the ASCII character set.
  NOTE:  This data group is identical to the AH1-6 group above, for the purpose of allowing
  up to 12 occurrences of these reports.
  AI1-AI6:  An indicator of up to 6 repeating fields for the following items:
  LIQUID-PRECIPITATION period quantity
  LIQUID-PRECIPITATION depth dimension
  LIQUID-PRECIPITATION condition code
  LIQUID-PRECIPITATION end date
  LIQUID-PRECIPITATION end time
  LIQUID-PRECIPITATION quality code

  FLD LEN: 3
  LIQUID-PRECIPITATION MAXIMUM SHORT DURATION, FOR THE MONTH period quantity
  The quantity of time over which the LIQUID-PRECIPITATION was measured.
    MIN:  060        MAX:  180        UNITS:  Minutes
  SCALING FACTOR:  1
  DOM:  A specific domain comprised of the characters in the ASCII character set
                           999 = Missing.

  FLD LEN: 4
  LIQUID-PRECIPITATION MAXIMUM SHORT DURATION, FOR THE MONTH depth dimension
  The depth of LIQUID-PRECIPITATION for the defined time period.
  MIN:  0000        MAX:  3000         UNITS:  millimeters
  SCALING FACTOR: 10
  DOM:  A general domain comprised of the numeric characters (0‑9).
    9999 = Missing.

  FLD LEN: 1
  LIQUID-PRECIPITATION MAXIMUM SHORT DURATION, FOR THE MONTH condition code
  The code that denotes whether a LIQUID-PRECIPITATION depth dimension was a trace value.
    DOM:  A specific domain comprised of the characters in the ASCII character set.
    1: Measurement impossible or inaccurate
                         2: Trace
                                         9: Missing

  FLD LEN: 6
  LIQUID-PRECIPITATION MAXIMUM SHORT DURATION, FOR THE MONTH ending date-time
  The ending date of occurrence of the event , given as the date-time in GMT; e.g., 051010 indicates
                1010 Z-time on day 05 of the month.
    MIN:  010000        MAX:  312359
  DOM:  A general domain comprised of the numeric characters (0‑9).
    999999 = Missing.

  FLD LEN: 1
  LIQUID-PRECIPITATION MAXIMUM SHORT DURATION, FOR THE MONTH quality code
  The code that denotes a quality status of the reported LIQUID-PRECIPITATION data.
  DOM:  A specific domain comprised of the characters in the ASCII character set.
    0 = Passed gross limits check
                            1 = Passed all quality control checks
                            2 = Suspect
                            3 = Erroneous
                            4 = Passed gross limits check , data originate from an NCEI data source
                            5 = Passed all quality control checks, data originate from an NCEI data source
                            6 = Suspect, data originate from an NCEI data source
                            7 = Erroneous, data originate from an NCEI data source
           9 = Passed gross limits check if element is present
    A = Data value flagged as suspect, but accepted as good value
  I = Data value not originally in data, but inserted by validator
    M = Manual change made to value based on information provided by NWS or FAA
  P = Data value not originally flagged as suspect, but replaced by validator
  R = Data value replaced with value computed by NCEI software
    U = Data value replaced with edited value


▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀

  FLD LEN: 3
  SNOW-DEPTH identifier
  The identifier that denotes the start of a SNOW-DEPTH data section.
    DOM: A specific domain comprised of the characters in the ASCII character set.
  AJ1  An indicator of the occurrence of the following items:
  SNOW-DEPTH dimension
  SNOW-DEPTH condition code
  SNOW‑DEPTH quality code
  SNOW-DEPTH equivalent water depth dimension
  SNOW-DEPTH equivalent water condition code
  SNOW-DEPTH equivalent water condition quality code

  FLD LEN: 4
  SNOW‑DEPTH dimension
  The depth of snow and ice on the ground.
    MIN:  0000       MAX:  1200      UNITS:  centimeters
  SCALING FACTOR:  1
  DOM:  A general domain comprised of the numeric characters (0‑9).
    9999 = Missing.

  FLD LEN: 1
  SNOW‑DEPTH condition code
  The code that denotes specific conditions associated with the measurement of snow in a
  PRECIPITATION-OBSERVATION.
    DOM:  A specific domain comprised of the characters in the ASCII character set.
    1: Measurement impossible or inaccurate
                           2: Snow cover not continuous
                           3: Trace
                           4: End accumulated period (data include more than one day)
                           5: End deleted period (data eliminated due to quality problems)
                           6: End missing period
  E: Estimated data value (eg, from nearby station)
                           9: Missing

  FLD LEN: 1
  SNOW‑DEPTH quality code
  The code that denotes a quality status of the reported SNOW‑DEPTH data.
  DOM:  A specific domain comprised of the characters in the ASCII character set.
    0 = Passed gross limits check
                            1 = Passed all quality control checks
                            2 = Suspect
                            3 = Erroneous
                            4 = Passed gross limits check , data originate from an NCEI data source
                            5 = Passed all quality control checks, data originate from an NCEI data source
                            6 = Suspect, data originate from an NCEI data source
                            7 = Erroneous, data originate from an NCEI data source
                            9 = Passed gross limits check if element is present
    A = Data value flagged as suspect, but accepted as good value
  I = Data value not originally in data, but inserted by validator
    M = Manual change made to value based on information provided by NWS or FAA
  P = Data value not originally flagged as suspect, but replaced by validator
  R = Data value replaced with value computed by NCEI software
    U = Data value replaced with edited value


  FLD LEN: 6
  SNOW‑DEPTH equivalent water depth dimension
  The depth of the liquid content of solid precipitation that has accumulated on the ground.
    MIN: 000000       MAX: 120000      UNITS: millimeters
  SCALING FACTOR: 10
  DOM:  A general domain comprised of the numeric characters (0‑9).
    999999 = Missing.

  FLD LEN: 1
  SNOW-DEPTH equivalent water condition code
  The code that denotes specific conditions associated with the measurement of the SNOW-DEPTH.
    DOM:  A specific domain comprised of the characters in the ASCII character set.
    1: Measurement impossible or inaccurate
                                            2: Trace
		           9: Missing (no special code to report)

  FLD LEN: 1
  SNOW-DEPTH equivalent water condition quality code
  The code that denotes a quality status of the reported SNOW-DEPTH equivalent water condition.
  DOM:  A specific domain comprised of the characters in the ASCII character set.
    0 = Passed gross limits check
                            1 = Passed all quality control checks
                            2 = Suspect
                            3 = Erroneous
                            4 = Passed gross limits check , data originate from an NCEI data source
                            5 = Passed all quality control checks, data originate from an NCEI data source
                            6 = Suspect, data originate from an NCEI data source
                            7 = Erroneous, data originate from an NCEI data source
                            9 = Passed gross limits check if element is present
    A = Data value flagged as suspect, but accepted as good value
  I = Data value not originally in data, but inserted by validator
    M = Manual change made to value based on information provided by NWS or FAA
  P = Data value not originally flagged as suspect, but replaced by validator
  R = Data value replaced with value computed by NCEI software
    U = Data value replaced with edited value


▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀

  FLD LEN: 3
  SNOW-DEPTH GREATEST DEPTH ON THE GROUND, FOR THE MONTH identifier
  The identifier that represents SNOW-DEPTH GREATEST SNOW DEPTH ON THE GROUND, data.
    DOM: A specific domain comprised of the characters in the ASCII character set.
  AK1   An indicator of the following items:
  SNOW-DEPTH depth dimension
  SNOW-DEPTH condition code
  SNOW-DEPTH dates of occurrence
  SNOW-DEPTH quality code

  FLD LEN: 4
  SNOW-DEPTH GREATEST DEPTH ON THE GROUND, FOR THE MONTH depth dimension
  The depth of GREATEST SNOW DEPTH FOR THE MONTH.
    MIN:  0000        MAX:  1500         UNITS:  centimeters
  SCALING FACTOR: 1
  DOM:  A general domain comprised of the numeric characters (0‑9).
    9999 = Missing.

  FLD LEN: 1
  SNOW-DEPTH GREATEST DEPTH ON THE GROUND, FOR THE MONTH condition code
  The code that denotes whether a SNOW-DEPTH dimension was a trace value.
  DOM:  A specific domain comprised of the characters in the ASCII character set.
    1: Measurement impossible or inaccurate
                         2: Trace
                         3: The amount occurred on other dates in addition to those listed
                         4: Trace amount occurred on other dates in addition to those listed
                                          9: Missing or N/A

  FLD LEN: 6
  SNOW-DEPTH GREATEST DEPTH ON THE GROUND, FOR THE MONTH dates of occurrence
  The dates of occurrence of SNOW-DEPTH, given as the date for each occurrence, for up to 3
  occurrences; e.g., 041016 indicates days 04, 10, and 16.
  MIN:  01        MAX:  31
  DOM:  A general domain comprised of the numeric characters (0‑9).
    99 = missing for each of the 3 sub-fields.

  FLD LEN: 1
  SNOW-DEPTH GREATEST DEPTH ON THE GROUND, FOR THE MONTH quality code
  The code that denotes a quality status of the reported SNOW-DEPTH data.
  DOM:  A specific domain comprised of the characters in the ASCII character set.
    0 = Passed gross limits check
                            1 = Passed all quality control checks
                            2 = Suspect
                            3 = Erroneous
                            4 = Passed gross limits check , data originate from an NCEI data source
                            5 = Passed all quality control checks, data originate from an NCEI data source
                            6 = Suspect, data originate from an NCEI data source
                            7 = Erroneous, data originate from an NCEI data source
            9 = Passed gross limits check if element is present

▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀

  FLD LEN: 3
  SNOW‑ACCUMULATION occurrence identifier
  The identifier that represents an episode of SNOW-ACCUMULATION.
    DOM:  A specific domain comprised of the characters in the ASCII character set.
  AL1 - AL4   An indicator of up to 4 repeating fields of the following items:
  SNOW-ACCUMULATION period quantity
  SNOW-ACCUMULATION depth dimension
  SNOW-ACCUMULATION condition code
  SNOW‑ACCUMULATION quality code

  FLD LEN: 2
  SNOW-ACCUMULATION period quantity
  The quantity of time over which the SNOW-ACCUMULATION occurred.
  MIN:  00         MAX:  72        UNITS:  Hours
  SCALING FACTOR:  1
  DOM:  A general domain comprised of the characters in the ASCII character set.
    99 = Missing.

  FLD LEN: 3
  SNOW‑ACCUMULATION depth dimension
  The depth of a SNOW-ACCUMULATION.
    MIN:  000        MAX:  500       UNITS:  centimeters
  SCALING FACTOR:  1
  DOM:  A general domain comprised of the numeric characters (0‑9).
    999 = Missing.

  FLD LEN: 1
  SNOW‑ACCUMULATION condition code
  The code that denotes specific conditions associated with the measurement of the
  depth of a SNOW‑ACCUMULATION.
    DOM:  A specific domain comprised of the characters in the ASCII character set.
    1: Measurement impossible or inaccurate
                         2: Snow cover not continuous
                         3: Trace
                         4: End accumulated period (data include more than one day)
                         5: End deleted period (data eliminated due to quality problems)
                         6: End missing period
  E: Estimated data value (eg, from nearby station)
                         9: Missing

  FLD LEN: 1
  SNOW‑ACCUMULATION quality code
  The code that denotes a quality status of the reported SNOW‑ACCUMULATION.
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

▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀

  FLD LEN: 3
  SNOW-ACCUMULATION GREATEST AMOUNT IN 24 HOURS, FOR THE MONTH identifier
  The identifier that represents SNOW-ACCUMULATION, GREATEST IN 24 HOURS, data.
    DOM: A specific domain comprised of the characters in the ASCII character set.
  AM1   An indicator of the following items:
  SNOW-ACCUMULATION depth dimension
  SNOW-ACCUMULATION condition code
  SNOW-ACCUMULATION dates of occurrence (3 fields)
  SNOW-ACCUMULATION quality code

  FLD LEN: 4
  SNOW-ACCUMULATION GREATEST AMOUNT IN 24 HOURS, FOR THE MONTH depth dimension
  The depth of SNOW-ACCUMULATION for the 24-hour period.
  MIN:  0000        MAX:  2000         UNITS:  centimeters
  SCALING FACTOR: 10
  DOM:  A general domain comprised of the numeric characters (0‑9).
    9999 = Missing.

  FLD LEN: 1
  SNOW-ACCUMULATION GREATEST AMOUNT IN 24 HOURS, FOR THE MONTH condition code
  The code that denotes whether a SNOW-ACCUMULATION depth dimension was a trace value.
    DOM:  A specific domain comprised of the characters in the ASCII character set.
    1: Measurement impossible or inaccurate
                         2: Trace
                         3: The amount occurred on other dates in addition to those listed
                         4: Trace amount occurred on other dates in addition to those listed
                                          9: Missing

  FLD LEN: 4
  SNOW-ACCUMULATION GREATEST AMOUNT IN 24 HOURS, FOR THE MONTH dates of occurrence
  The dates of occurrence of SNOW-ACCUMULATION, given as the begin-end date for the 24-hour period, for
  up to 3 occurrences; e.g., 0405 indicates 24-hour period on days 04-05.
  MIN:  0101        MAX:  3131
  DOM:  A general domain comprised of the numeric characters (0‑9).
    9999 = Missing.

  FLD LEN: 4
  SNOW-ACCUMULATION GREATEST AMOUNT IN 24 HOURS, FOR THE MONTH dates of occurrence
  The dates of occurrence of SNOW-ACCUMULATION, given as the begin-end date for the 24-hour period, for
  up to 3 occurrences; e.g., 0405 indicates 24-hour period on days 04-05.
  MIN:  0101        MAX:  3131
  DOM:  A general domain comprised of the numeric characters (0‑9).
    9999 = Missing.

  FLD LEN: 4
  SNOW-ACCUMULATION GREATEST AMOUNT IN 24 HOURS, FOR THE MONTH dates of occurrence
  The dates of occurrence of SNOW-ACCUMULATION, given as the begin-end date for the 24-hour period, for
  up to 3 occurrences; e.g., 0405 indicates 24-hour period on days 04-05.
  MIN:  0101        MAX:  3131
  DOM:  A general domain comprised of the numeric characters (0‑9).
    9999 = Missing.

  FLD LEN: 1
  SNOW-ACCUMULATION GREATEST AMOUNT IN 24 HOURS, FOR THE MONTH quality code
  The code that denotes a quality status of the reported SNOW-ACCUMULATION data.
  DOM:  A specific domain comprised of the characters in the ASCII character set.
    0 = Passed gross limits check
                            1 = Passed all quality control checks
                            2 = Suspect
                            3 = Erroneous
                            4 = Passed gross limits check , data originate from an NCEI data source
                            5 = Passed all quality control checks, data originate from an NCEI data source
                            6 = Suspect, data originate from an NCEI data source
                            7 = Erroneous, data originate from an NCEI data source
            9 = Passed gross limits check if element is present

▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀

  FLD LEN: 3
  SNOW‑ACCUMULATION FOR THE DAY/MONTH occurrence identifier
  The identifier that represents SNOW-ACCUMULATION MONTHLY TOTAL.
    DOM:  A specific domain comprised of the characters in the ASCII character set.
  AN1:  An indicator for the occurrence of the following items:
  SNOW-ACCUMULATION period quantity
  SNOW-ACCUMULATION depth dimension
  SNOW-ACCUMULATION condition code
  SNOW‑ACCUMULATION quality code

  FLD LEN: 3
                    SNOW-ACCUMULATION period quantity
                The quantity of time over which the SNOW-ACCUMULATION occurred (usually 024 for daily, 744 for monthly)
                MIN:  001         MAX:  744        UNITS:  Hours
                SCALING FACTOR:  1
                    DOM:  A general domain comprised of the characters in the ASCII character set.
                               999 = Missing.

  FLD LEN: 4
                  SNOW ACCUMULATION FOR THE MONTH depth dimension
              The depth of a SNOW-ACCUMULATION.
              MIN:  0000        MAX:  9998       UNITS:  centimeters
              SCALING FACTOR:  10
                  DOM:  A general domain comprised of the numeric characters (0-9).
                             9999 = Missing.

  FLD LEN: 1
  SNOW‑ACCUMULATION FOR THE MONTH condition code
  The code that denotes specific conditions associated with the measurement of the
  depth of a SNOW‑ACCUMULATION.
    DOM:  A specific domain comprised of the characters in the ASCII character set.
    1: Measurement impossible or inaccurate
                         2: Snow cover not continuous
                         3: Trace
                         4: End accumulated period (data may include more than one month)
                         5: End deleted period (data eliminated due to quality problems)
                         6: End missing period
                         7: Data will be included in subsequent observation
  E: Estimated data value (eg, from nearby station)
                         9: Missing

  FLD LEN: 1
  SNOW‑ACCUMULATION FOR THE MONTH quality code
  The code that denotes a quality status of the reported SNOW‑ACCUMULATION FOR THE MONTH.
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

▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀

  FLD LEN: 3
  LIQUID-PRECIPITATION occurrence identifier
  The identifier that represents an episode of LIQUID-PRECIPITATION.
    DOM: A specific domain comprised of the characters in the ASCII character set.
  AO1 - AO4   An indicator of up to 4 repeating fields of the following items:
  LIQUID-PRECIPITATION period quantity
  LIQUID-PRECIPITATION depth dimension
  LIQUID-PRECIPITATION condition code
  LIQUID-PRECIPITATION quality code

  FLD LEN: 2
  LIQUID-PRECIPITATION period quantity in minutes
  The quantity of time over which the LIQUID-PRECIPITATION was measured.
    MIN:  00         MAX:  98        UNITS:  Minutes
  SCALING FACTOR:  1
  DOM:  A specific domain comprised of the characters in the ASCII character set
                           99 = Missing.

  FLD LEN: 4
  LIQUID-PRECIPITATION depth dimension
  The depth of LIQUID-PRECIPITATION that is measured at the time of an observation.
  MIN:  0000        MAX:  9998         UNITS:  millimeters
  SCALING FACTOR: 10
  DOM:  A general domain comprised of the numeric characters (0‑9).
    9999 = Missing.

  FLD LEN: 1
  LIQUID-PRECIPITATION condition code
  The code that denotes whether a LIQUID-PRECIPITATION depth dimension was a trace value.
    DOM:  A specific domain comprised of the characters in the ASCII character set.
    1: Measurement impossible or inaccurate
                         2: Trace
                         3: Begin accumulated period (precipitation amount missing until end of accumulated period)
                         4: End accumulated period
                         5: Begin deleted period (precipitation amount missing due to data problem)
                         6: End deleted period
                         7: Begin missing period
                         8: End missing period
  E: Estimated data value (eg, from nearby station)
                                          I:  Incomplete precipitation amount, excludes one or more missing reports, such as one or more 15-minute                                              reports not included in the 1-hour precipitation total   
                             J:  Incomplete precipitation amount, excludes one or more erroneous reports, such as one or more 1-hour                                               precipitation amounts excluded from the 24-hour total  
    9: Missing

  FLD LEN: 1
  LIQUID-PRECIPITATION quality code
  The code that denotes a quality status of the reported LIQUID-PRECIPITATION data.
  DOM:  A specific domain comprised of the characters in the ASCII character set.
    0 = Passed gross limits check
                            1 = Passed all quality control checks
                            2 = Suspect
                            3 = Erroneous
                            4 = Passed gross limits check , from DSI-3260 or NCEI ASOS/AWOS
                            5 = Passed all quality control checks, from DSI-3260 or NCEI ASOS/AWOS
                            6 = Suspect, from DSI-3260 or NCEI ASOS/AWOS
                            7 = Erroneous, from DSI-3260 or NCEI ASOS/AWOS
            9 = Passed gross limits check if element is present


 ▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀
  FLD LEN: 3
    15 Minute LIQUID-PRECIPITATION occurrence identifier
  The identifier that represents an episode of LIQUID-PRECIPITATION.
    DOM: A specific domain comprised of the characters in the ASCII character set.
  IMPORTANT NOTE:  These data are also provided in the AAx section for typical 	use in applications.  The APx data are mainly
  intended for quality control processing.
  AP1 Indicates HPD gauge value 45 minutes prior to observation time
  AP2 Indicates HPD gauge value 30 minutes prior to observation time
  AP3 Indicates HPD gauge value 15 minutes prior to observation time
  AP4 Indicates HPD gauge value at observation time
  LIQUID-PRECIPITATION depth dimension
  LIQUID-PRECIPITATION condition code
  LIQUID-PRECIPITATION quality code

  FLD LEN: 4
  HPD (Hourly Precipitation Data network) gauge value
  The HPD Gauge value that is measured at the time indicated.
    MIN: 0000     MAX: 9998    UNITS: millimeters
  SCALING FACTOR: 10
  DOM: A general domain comprised of the numeric characters (0-9).
    9999 = Missing

  FLD LEN: 1
  HPD gauge value condition code
  Not used at this time.  Value set to missing.
  DOM: A specific domain comprised of the characters in the ASCII character set.
    9=Missing

  FLD LEN: 1
  HPD gauge value quality code
  The code that denotes a quality status of the reported gauge value.
  DOM: A specific domain comprised of the characters in the ASCII character set.
    0 = Passed gross limits check
                          1 = Passed all quality control checks
   	          2 = Suspect
   	          3 = Erroneous
     	          4 = Passed gross limits check, data originate from an NCEI data source
  	          5 = Passed all quality control checks, data originate from an NCEI data source
  	          6 = Suspect, data originate from an NCEI data source
  	          7 = Erroneous, data originate from an NCEI data source
  	          9 = Passed gross limits check if element is present

▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀

  Weather Occurrence Data

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
  The abbreviation that denotes the type of daily present weather being reported. These abbreviations correspond to the Daily                Present Weather Observation weather type.
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

▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀

  FLD LEN: 3
  PRESENT-WEATHER-OBSERVATION automated occurrence identifier
  The identifier that signifies the reporting of present weather.
    DOM:  A specific domain comprised of the ASCII characters.
  AW1   First automated weather report
  AW2   Second automated weather report
  AW3   Third automated weather report
  AW4   Fourth automated weather report
  PRESENT‑WEATHER‑OBSERVATION automated atmospheric condition code
  PRESENT-WEATHER-OBSERVATION quality automated atmospheric condition code

  FLD LEN: 2
  PRESENT-WEATHER-OBSERVATION automated atmospheric condition code
  The code that denotes a specific type of weather reported by an automated device.
  DOM:  A specific domain comprised of the characters in the ASCII character set.
    00: No significant weather observed
               01: Clouds generally dissolving or becoming less developed
               02: State of sky on the whole unchanged during the past hour
               03: Clouds generally forming or developing during the past hour
               04: Haze, smoke, or dust in suspension in the air, visibility equal to or greater than 1km
               05: Smoke
               07: Dust or sand raised by wind at or near the station at the time of observation, but no
  well‑developed dust whirl(s) or sand whirl(s), and no duststorm or sandstorm seen or, in the case
  of ships, blowing spray at the station
               10: Mist
               11: Diamond dust
               12: Distant lightning
               18: Squalls

    (Code figures 20‑26 are used to report precipitation, fog, or thunderstorm at the station during
      the preceding hour, but not at the time of observation.)

              20: Fog
              21: Precipitation
              22: Drizzle (not freezing) or snow grains
              23: Rain (not freezing)
              24: Snow
              25: Freezing drizzle or freezing rain
              26: Thunderstorm (with or without precipitation)
              27: Blowing or drifting snow or sand
              28: Blowing or drifting snow or sand, visibility equal to or greater than 1 km
              29: Blowing or drifting snow or sand, visibility less than 1 km
              30: Fog
              31: Fog or ice fog in patches
              32: Fog or ice fog, has become thinner during the past hour
              33: Fog or ice fog, no appreciable change during the past hour
              34: Fog or ice fog, has begun or become thicker during the past hour
              35: Fog, depositing rime
              40: Precipitation
              41: Precipitation, slight or moderate
              42: Precipitation, heavy
              43: Liquid precipitation, slight or moderate
              44: Liquid precipitation, heavy
              45: Solid precipitation, slight or moderate
              46: Solid precipitation, heavy
              47: Freezing precipitation, slight or moderate
              48: Freezing precipitation, heavy
              50: Drizzle
              51: Drizzle, not freezing, slight
              52: Drizzle, not freezing, moderate
              53: Drizzle, not freezing, heavy
              54: Drizzle, freezing, slight
              55: Drizzle, freezing, moderate
              56: Drizzle, freezing, heavy
              57: Drizzle and rain, slight
              58: Drizzle and rain, moderate or heavy
              60: Rain
              61: Rain, not freezing, slight
              62: Rain, not freezing, moderate
              63: Rain, not freezing, heavy
              64: Rain, freezing, slight
              65: Rain, freezing, moderate
              66: Rain, freezing, heavy
              67: Rain or drizzle and snow, slight
              68: Rain or drizzle and snow, moderate or heavy
              70: Snow
              71: Snow, slight
              72: Snow, moderate
              73: Snow, heavy
              74: Ice pellets, slight
              75: Ice pellets, moderate
              76: Ice pellets, heavy
              77: Snow grains
              78: Ice crystals
              80: Showers or intermittent precipitation
              81: Rain showers or intermittent rain, slight
              82: Rain showers or intermittent rain, moderate
              83: Rain showers or intermittent rain, heavy
              84: Rain showers or intermittent rain, violent
              85: Snow showers or intermittent snow, slight
              86: Snow showers or intermittent snow, moderate
              87: Snow showers or intermittent snow, heavy
              89: Hail
              90: Thunderstorm
              91: Thunderstorm, slight or moderate, with no precipitation
              92: Thunderstorm, slight or moderate, with rain showers and/or snow showers
              93: Thunderstorm, slight or moderate, with hail
              94: Thunderstorm, heavy, with no precipitation
              95: Thunderstorm, heavy, with rain showers and/or snow
              96: Thunderstorm, heavy, with hail
              99: Tornado

  FLD LEN: 1
  PRESENT-WEATHER-OBSERVATION quality automated atmospheric condition code
  The code that denotes a quality status of a reported present weather observation from an
  automated station.
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

▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀

  FLD LEN: 3
  PAST-WEATHER-OBSERVATION summary of day occurrence identifier
  The identifier that signifies the reporting of past weather as summarized for the calendar day.
    DOM:  A specific domain comprised of the characters in the ASCII character set.
  AX1 – AX6  An indicator of up to 6 repeating fields of the following item:
  PAST‑WEATHER‑OBSERVATION atmospheric condition code
  PAST-WEATHER-OBSERVATION quality atmospheric condition code
  PAST-WEATHER-OBSERVATION period quantity
  PAST-WEATHER-OBSERVATION period quality code

  FLD LEN: 2
  PAST-WEATHER-OBSERVATION atmospheric condition code
  The code that denotes a specific type of past weather observed.
    DOM:  A specific domain comprised of the characters in the ASCII character set.
    00: none to report
              		01: fog
              		02: fog reducing visibility to ¼ mile or less
              		03: thunder
              		04: ice pellets
              		05: hail
              		06: glaze or rime
              		07: blowing dust or sand, visibility ½ mile or less
              		08: smoke or haze
              		09: blowing snow
	              		10: tornado
                              		11: high or damaging winds
                              		99: missing

  FLD LEN: 1
  PAST-WEATHER-OBSERVATION quality manual atmospheric condition code
  The code that denotes a quality status of a reported past weather observation from a manual
  station.
    DOM:  A specific domain comprised of the characters in the ASCII character set.
    4 = Passed gross limits check, data originate from an NCEI data source
                            5 = Passed all quality control checks, data originate from an NCEI data source
                            6 = Suspect, data originate from an NCEI data source
                            7 = Erroneous, data originate from an NCEI data source
                            9 = Passed gross limits check if element is present

  FLD LEN: 2
  PAST-WEATHER-OBSERVATION period quantity
  The quantity of time over which a PAST-WEATHER-OBSERVATION occurred.
  MIN:  24                MAX:  24               UNITS:  hours
  DOM:  A general domain comprised of the ASCII characters 0-9.
    99 = Missing

  FLD LEN: 1
  PAST-WEATHER-OBSERVATION  period quality code
  The code that denotes a quality status of a reported past weather period.
    DOM:  A specific domain comprised of the characters in the ASCII character set.
    4 = Passed gross limits check, data originate from an NCEI data source
                            5 = Passed all quality control checks, data originate from an NCEI data source
                            6 = Suspect, data originate from an NCEI data source
                            7 = Erroneous, data originate from an NCEI data source
                            9 = Passed gross limits check if element is present

▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀

  FLD LEN: 3
  PAST-WEATHER-OBSERVATION manual occurrence identifier
  The identifier that signifies the reporting of past weather.
    DOM:  A specific domain comprised of the characters in the ASCII character set.
  AY1 - AY2   An indicator of up to 2 repeating fields of the following item:
  PAST‑WEATHER‑OBSERVATION manual atmospheric condition code
  PAST-WEATHER-OBSERVATION quality manual atmospheric condition code
  PAST-WEATHER-OBSERVATION period quantity
  PAST-WEATHER-OBSERVATION period quality code

  FLD LEN: 1
  PAST-WEATHER-OBSERVATION manual atmospheric condition code
  The code that denotes a specific type of past weather observed manually.
  DOM:  A specific domain comprised of the characters in the ASCII character set.
  Domain Value ID: Domain Value Definition Text
              		0: Cloud covering 1/2 or less of the sky throughout the appropriate period
1: Cloud covering more than 1/2 of the sky during part of the appropriate period and covering 1/2 or less during part of the period
              		2: Cloud covering more than 1/2 of the sky throughout the appropriate period
              		3: Sandstorm, duststorm or blowing snow
              		4: Fog or ice fog or thick haze
              		5: Drizzle
              		6: Rain
              		7: Snow, or rain and snow mixed
             		8: Shower(s)
              		9: Thunderstorm(s) with or without precipitation

  FLD LEN: 1
  PAST-WEATHER-OBSERVATION quality manual atmospheric condition code
  The code that denotes a quality status of a reported past weather observation from a manual
  station.
    DOM:  A specific domain comprised of the characters in the ASCII character set.
    0 = Passed gross limits check
                            1 = Passed all quality control checks
                            2 = Suspect
                            3 = Erroneous
                            9 = Passed gross limits check if element is present

  FLD LEN: 2
  PAST-WEATHER-OBSERVATION period quantity
  The quantity of time over which a PAST-WEATHER-OBSERVATION occurred.
  MIN:  01                MAX:  24               UNITS:  hours
  DOM:  A general domain comprised of the ASCII characters 0-9.
    99 = Missing

  FLD LEN: 1
  PAST-WEATHER-OBSERVATION  period quality code
  The code that denotes a quality status of a reported past weather period.
    DOM:  A specific domain comprised of the characters in the ASCII character set.
    0 = Passed gross limits check
                            1 = Passed all quality control checks
                            2 = Suspect
                            3 = Erroneous
                            9 = Passed gross limits check if element is present

▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀

  FLD LEN: 3
  PAST-WEATHER-OBSERVATION automated occurrence identifier
  The identifier that signifies the reporting of present weather.
    DOM: A specific domain comprised of the characters in the ASCII character set.
  AZ1- AZ2   An indicator of the following item: (this may occur 0 - 2 times)
  PAST‑WEATHER‑OBSERVATION automated atmospheric condition code
  PAST-WEATHER-OBSERVATION quality automated atmospheric condition code
  PAST‑WEATHER‑OBSERVATION period quantity
  PAST-WEATHER-OBSERVATION period quality code

  FLD LEN: 1
  PAST-WEATHER-OBSERVATION automated atmospheric condition code
  The code that denotes a specific type of past weather reported by an automated device.
    DOM: A specific domain comprised of the characters in the ASCII character set.
    0: No significant weather observed
                        1: Visibility reduced
                        2: Blowing phenomena, visibility reduced
                        3: Fog
                        4: Precipitation
                        5: Drizzle
                        6: Rain
                        7: Snow or ice pellets
                        8: Showers or intermittent precipitation
                        9: Thunderstorm

  FLD LEN: 1
  PAST-WEATHER-OBSERVATION quality automated atmospheric condition code
  The code that denotes a quality status of a reported past weather observation from an
  automated station.
  DOM:  A specific domain comprised of the characters in the ASCII character set.
    0 = Passed gross limits check
                             1 = Passed all quality control checks
                             2 = Suspect
                             3 = Erroneous
                             9 = Passed gross limits check if element is present

  FLD LEN: 2
  PAST‑WEATHER‑OBSERVATION period quantity
  The quantity of time over which a PAST-WEATHER-OBSERVATION occurred.
  MIN:  01                MAX:  24               UNITS:  hours
  DOM:  A general domain comprised of the ASCII characters 0-9.
    99 = Missing

  FLD LEN: 1
  PAST-WEATHER-OBSERVATION  period quality code
  The code that denotes a quality status of a reported past weather period.
    DOM:  A specific domain comprised of the characters in the ASCII character set.
    0 = Passed gross limits check
                            1 = Passed all quality control checks
                            2 = Suspect
                            3 = Erroneous
                            9 = Passed gross limits check if element is present


*/
}
