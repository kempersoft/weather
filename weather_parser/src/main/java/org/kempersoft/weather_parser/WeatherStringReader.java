package org.kempersoft.weather_parser;


import org.kempersoft.weather_parser.domain.weather.EQualityCode;

import java.io.StringReader;

public class WeatherStringReader extends StringReader {

  public WeatherStringReader( String line ) {
    super( line );
  }

  public EQualityCode getQualityCode() throws Exception {
    return EQualityCode.toQualityCode( getStringField( 1 ) );
  }

  public Integer getIntField( int numChars, String nullString ) throws Exception {
    char chars[] = new char[ numChars ];
    int numRead = this.read( chars, 0, numChars );
    if ( numRead != numChars ) {
      throw new Exception( "Not enough characters to get integer field!" );
    }
    String intString = new String( chars ).trim();
    if ( intString == null || intString.isEmpty() ) {
      return null;
    }
    if ((nullString != null) && nullString.equals( intString )) {
      return null;
    }
    return Integer.parseInt( intString );
  }

  public String getStringField( int numChars ) throws Exception {
    char chars[] = new char[ numChars ];
    int numRead = this.read( chars, 0, numChars );
    if ( numRead != numChars ) {
      throw new Exception( "Not enough characters to get string field!" );
    }
    String theString = new String( chars ).trim();
    return theString;
  }

  public Double getDoubleValue( int numChars, String missingStr, Double scaleValue ) throws Exception {
    String field = getStringField( numChars );
    if ( field == null || field.isEmpty() ) {
      return null;
    }
    if ( field.endsWith( missingStr ) ) {
      return null;
    }
    Double dVal = Double.parseDouble( field );
    if ( scaleValue != null ) {
      dVal = dVal / scaleValue;
    }
    return dVal;
  }


}
