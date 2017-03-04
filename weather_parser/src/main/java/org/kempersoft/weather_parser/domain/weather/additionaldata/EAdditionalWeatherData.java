package org.kempersoft.weather_parser.domain.weather.additionaldata;

import org.kempersoft.weather_parser.domain.weather.additionaldata.cloudandsolar.SkyConditionObservationGroup1;
import org.kempersoft.weather_parser.domain.weather.additionaldata.cloudandsolar.SkyConditionObservationGroup2;
import org.kempersoft.weather_parser.domain.weather.additionaldata.cloudandsolar.SkyCoverSummation;
import org.kempersoft.weather_parser.domain.weather.additionaldata.observedweather.AutomatedWeatherReport;
import org.kempersoft.weather_parser.domain.weather.additionaldata.observedweather.DailyPresentWeatherObservation;
import org.kempersoft.weather_parser.domain.weather.additionaldata.observedweather.PresentWeatherObservation;
import org.kempersoft.weather_parser.domain.weather.additionaldata.precipitation.LiquidPrecipitationMonthlyTotal;
import org.kempersoft.weather_parser.domain.weather.additionaldata.precipitation.LiquidPrecipitationOccurence;
import org.kempersoft.weather_parser.domain.weather.additionaldata.precipitation.PrecipitationObservationHistory;
import org.kempersoft.weather_parser.domain.weather.additionaldata.pressure.AtmosphericPressure;
import org.kempersoft.weather_parser.domain.weather.additionaldata.cloudandsolar.SkyCoverLayer;

public enum EAdditionalWeatherData {


  AA1( 11, LiquidPrecipitationOccurence.class ),
  AA2( 11, LiquidPrecipitationOccurence.class ),
  AA3( 11, LiquidPrecipitationOccurence.class ),
  AA4( 11, LiquidPrecipitationOccurence.class ),
  AB1( 10, LiquidPrecipitationMonthlyTotal.class ),
  AC1( 6, PrecipitationObservationHistory.class ),
  AD1( 22, null ),
  AE1( 15, null ),
  AG1( 7, null ),
  AH1( 18, null ),
  AH2( 18, null ),
  AH3( 18, null ),
  AH4( 18, null ),
  AH5( 18, null ),
  AH6( 18, null ),
  AI1( 18, null ),
  AI2( 18, null ),
  AI3( 18, null ),
  AI4( 18, null ),
  AI5( 18, null ),
  AI6( 18, null ),
  AJ1( 17, null ),
  AK1( 15, null ),
  AL1( 10, null ),
  AL2( 10, null ),
  AL3( 10, null ),
  AL4( 10, null ),
  AM1( 21, null ),
  AN1( 12, null ),
  AO1( 11, null ),
  AO2( 11, null ),
  AO3( 11, null ),
  AO4( 11, null ),
  AP1( 9, null ),
  AP2( 9, null ),
  AP3( 9, null ),
  AP4( 9, null ),
  AT1( 12, DailyPresentWeatherObservation.class ),
  AT2( 12, DailyPresentWeatherObservation.class ),
  AT3( 12, DailyPresentWeatherObservation.class ),
  AT4( 12, DailyPresentWeatherObservation.class ),
  AT5( 12, DailyPresentWeatherObservation.class ),
  AT6( 12, DailyPresentWeatherObservation.class ),
  AT7( 12, DailyPresentWeatherObservation.class ),
  AT8( 12, DailyPresentWeatherObservation.class ),
  AU1( 11, PresentWeatherObservation.class ),
  AU2( 11, PresentWeatherObservation.class ),
  AU3( 11, PresentWeatherObservation.class ),
  AU4( 11, PresentWeatherObservation.class ),
  AU5( 11, PresentWeatherObservation.class ),
  AU6( 11, PresentWeatherObservation.class ),
  AU7( 11, PresentWeatherObservation.class ),
  AU8( 11, PresentWeatherObservation.class ),
  AU9( 11, PresentWeatherObservation.class ),
  AW1( 6, AutomatedWeatherReport.class ),
  AW2( 6, AutomatedWeatherReport.class ),
  AW3( 6, AutomatedWeatherReport.class ),
  AW4( 6, AutomatedWeatherReport.class ),
  AW5( 6, AutomatedWeatherReport.class ),  // unexepcted - system said up to 4, but found a fifth!
  AW6( 6, AutomatedWeatherReport.class ),  // unexepcted - system said up to 4, but found a fifth!
  AX1( 9, null ),
  AX2( 9, null ),
  AX3( 9, null ),
  AX4( 9, null ),
  AX5( 9, null ),
  AX6( 9, null ),
  AY1( 8, null ),
  AY2( 8, null ),
  AZ1( 8, null ),
  AZ2( 8, null ),
  CB1( 13, null ),
  CB2( 13, null ),
  CF1( 9, null ),
  CF2( 9, null ),
  CF3( 9, null ),
  CG1( 11, null ),
  CG2( 11, null ),
  CG3( 11, null ),
  CH1( 18, null ),
  CH2( 18, null ),
  CI1( 31, null ),
  CN1( 21, null ),
  CN2( 21, null ),
  CN3( 19, null ),
  CN4( 22, null ),    // this seems to be invalid for some reason??  Doc says 19, but there's something missing here...

  CO1( 8, null ),

  CO2( 11, null ),
  CO3( 11, null ),
  CO4( 11, null ),
  CO5( 11, null ),
  CO6( 11, null ),
  CO7( 11, null ),
  CO8( 11, null ),
  CO9( 11, null ),

  CR1( 10, null ),

  CT1( 10, null ),
  CT2( 10, null ),
  CT3( 10, null ),

  CU1( 16, null ),
  CU2( 16, null ),
  CU3( 16, null ),


  CV1( 29, null ),
  CV2( 29, null ),
  CV3( 29, null ),


  CW1( 17, null ),

  CX1( 29, null ),
  CX2( 29, null ),
  CX3( 29, null ),

  ED1( 11, null ),


  GA1( 16, SkyCoverLayer.class ),
  GA2( 16, SkyCoverLayer.class ),
  GA3( 16, SkyCoverLayer.class ),
  GA4( 16, SkyCoverLayer.class ),
  GA5( 16, SkyCoverLayer.class ),
  GA6( 16, SkyCoverLayer.class ),
  GD1( 15, SkyCoverSummation.class ),
  GD2( 15, SkyCoverSummation.class ),
  GD3( 15, SkyCoverSummation.class ),
  GD4( 15, SkyCoverSummation.class ),
  GD5( 15, SkyCoverSummation.class ),
  GD6( 15, SkyCoverSummation.class ),
  GE1( 22, SkyConditionObservationGroup1.class ),
  GF1( 26, SkyConditionObservationGroup2.class ),

  GG1( 18, null ),
  GG2( 18, null ),
  GG3( 18, null ),
  GG4( 18, null ),
  GG5( 18, null ),
  GG6( 18, null ),

  GH1( 31, null ),
  GJ1( 8, null ),
  GK1( 7, null ),
  GL1( 9, null ),
  GM1( 33, null ),
  GN1( 31, null ),
  GO1( 22, null ),
  GP1( 34, null ),
  GQ1( 17, null ),

  GR1( 17, null ),

  HL1( 7, null ),

  IA1( 6, null ),
  IA2( 12, null ),

  IB1( 30, null ),
  IB2( 16, null ),
  IC1( 28, null ),


  KA1( 13, null ),
  KA2( 13, null ),
  KA3( 13, null ),
  KA4( 13, null ),

  KB1( 13, null ),
  KB2( 13, null ),
  KB3( 13, null ),

  KC1( 17, null ),
  KC2( 17, null ),

  KD1( 12, null ),
  KD2( 12, null ),

  KE1( 15, null ),

  KF1( 9, null ),

  KG1( 14, null ),
  KG2( 14, null ),


  MA1( 15, AtmosphericPressure.class ),
  MD1( 14, null ),
  ME1( 9, null ),
  MF1( 15, null ),
  MG1( 15, null ),
  MH1( 15, null ),
  MK1( 27, null ),

  MW1( 6, null ),
  MW2( 6, null ),
  MW3( 6, null ),
  MW4( 6, null ),
  MW5( 6, null ),
  MW6( 6, null ),
  MW7( 6, null ),

  MV1( 6, null ),
  MV2( 6, null ),
  MV3( 6, null ),
  MV4( 6, null ),
  MV5( 6, null ),
  MV6( 6, null ),
  MV7( 6, null ),

  OA1( 11, null ),
  OA2( 11, null ),
  OA3( 11, null ),


  OB1( 31, null ),
  OB2( 31, null ),

  OC1( 8, null ),

  OD1( 14, null ),
  OD2( 14, null ),
  OD3( 14, null ),

  OE1( 19, null ),
  OE2( 19, null ),
  OE3( 19, null ),

  RH1( 12, null ),
  RH2( 12, null ),
  RH3( 12, null ),


  SA1( 8, null ),


  UA1( 13, null ),
  UG1( 12, null ),
  UG2( 12, null ),

  WA1( 9, null ),

  WD1( 23, null );

  public int getLength() {
    return length;
  }

  public void setLength( int length ) {
    this.length = length;
  }

  public Class<?> getClazz() {
    return clazz;
  }

  public void setClazz( Class<?> clazz ) {
    this.clazz = clazz;
  }

  private int length;
  private Class<?> clazz;

  EAdditionalWeatherData( int length, Class<?> clazz ) {
    this.length = length;
    this.clazz = clazz;
  }


}
