package org.kempersoft.weather_parser;

import org.junit.Test;
import org.kempersoft.weather_parser.domain.weather.WeatherReading;

import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by bkemper on 3/2/17.
 */
public class WeatherParserTest {

  private static String badLine = "0108724645230702016080106596+37262-104338SOM  +1750KTAD V030999999999999999999999999999+99999+99999999999REM\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u000016 07:54:02 METAR KTAD 111454Z 27010KT 10SM CLR 29/M02 A2994 RMK AO2 SLP031 T02941022 51005 $";

  private static String basicLineNoAdds = "0000111111222222000010100004-33500+021283FM-12+053899999V0209999C000019999999N999999999+01861+00951999999";

  private static String testFileName = "747870-12834-2017.gz";

  private static String testDirecory = "/Users/bkemper/weather/all_2016/2017";
//  @Test
  public void parseSimpleLine() throws Exception {

    WeatherReading value = WeatherParser.parseLine( basicLineNoAdds );
//    System.out.println(value.toString());
//    value = WeatherParser.parseLine( badLine );
  }

//  @Test
  public void parseGZipFile( ) throws Exception {
    ClassLoader classLoader = getClass().getClassLoader();
    File file = new File(classLoader.getResource(testFileName).getFile());
    List<WeatherReading> readings = WeatherParser.parseFile( file.getAbsolutePath() );
    for (Map.Entry<String, Integer> entry : WeatherParser.usedKeys.entrySet()) {
      System.out.println( entry.getKey() + " (" + entry.getValue().toString() + ")");
    }
    // for now we're ignoring the results of this - although would probably be better to validate some base things about the file...
  }

  @Test
  public void parseDirectory( ) throws Exception {
    int iCount = 0;
    File fileDir = new File( testDirecory );
    if (!fileDir.exists( ) || !fileDir.isDirectory( ) ) {
      fail("Not a directory?");
    }
    for (File file : fileDir.listFiles(  )) {
      if (file.getName().endsWith( ".gz" ) && file.getName().startsWith( "7" ) ) {
//        if ((iCount % 100 ) == 0 ) {
          System.out.println( "Processing file : " + file.getName() );
//        }
        iCount++;
        WeatherParser.parseFile( file.getAbsolutePath() );
      }
    }

    List<String> keys = new ArrayList<>(  );
    keys.addAll( WeatherParser.usedKeys.keySet() );
    keys.sort( new Comparator<String>() {
      @Override public int compare( String o1, String o2 ) {
        return WeatherParser.usedKeys.get( o1 ).compareTo( WeatherParser.usedKeys.get( o2 ) );
      }
    } );

    for (String key : keys) {
      System.out.println( key + " (" + WeatherParser.usedKeys.get( key ).toString() + ")");
    }

  }

  @Test
  public void getObservationTime( ) throws Exception {
    Timestamp ts = WeatherParser.getDateTime( "20010101", "0000" );
    Timestamp comp = new Timestamp( 2001 - 1900, 0, 1, 0, 0, 0, 0 );
    assertEquals( comp, ts );
  }

}
