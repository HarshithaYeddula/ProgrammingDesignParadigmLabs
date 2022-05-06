
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Objects;
import java.util.Random;
import org.junit.Test;
import weather.StevensonReading;

/**
 * Class for testing StevensonReading class.
 * 
 * @author Harshitha Yeddula
 */
public class StevensonReadingTest {

  @Test
  public void testGetRelativeHumidity() {
    double airTemp = -10.6;
    double dewPointTemp = -23;
    double windSpeed = 3;
    double totalRain = 40;

    StevensonReading reading = new StevensonReading(airTemp, dewPointTemp, windSpeed, totalRain);

    double actualVapourPressure = ((7.5 * dewPointTemp) / (237.3 + dewPointTemp)) * (6.11 * 10);
    double saturatedVapourPressure = ((7.5 * airTemp) / (237.3 + airTemp)) * (6.11 * 10);
    double relativeHumidity = (actualVapourPressure / saturatedVapourPressure) * 100;
    assertEquals((int) Math.round(relativeHumidity), reading.getRelativeHumidity());

    // performing Fuzzy test
    // all Readings are +ve with Dew Point Temperature>Air Temperature
    for (int i = 0; i < 50000; i++) {
      Random r = new Random();
      airTemp = r.nextDouble();
      dewPointTemp = airTemp - 0.1;
      windSpeed = r.nextDouble();
      totalRain = r.nextDouble();

      reading = new StevensonReading(airTemp, dewPointTemp, windSpeed, totalRain);

      actualVapourPressure = ((7.5 * dewPointTemp) / (237.3 + dewPointTemp)) * (6.11 * 10);
      saturatedVapourPressure = ((7.5 * airTemp) / (237.3 + airTemp)) * (6.11 * 10);
      relativeHumidity = (actualVapourPressure / saturatedVapourPressure) * 100;
      assertEquals((int) Math.round(relativeHumidity), reading.getRelativeHumidity());
    }
  }
  

  @Test(expected = ArithmeticException.class)
  public void testGetRelativeHumidityWithZerAirTemperature() {
    // zero Air Temperature
    double airTemp = 0;
    double dewPointTemp = -1;
    double windSpeed = 3;
    double totalRain = 40;
    StevensonReading reading = new StevensonReading(airTemp, dewPointTemp, windSpeed, totalRain);
    assertEquals("", reading.getRelativeHumidity());
    
  }


  @Test
  public void testGetHeatIndex() {
    double airTemp = -10.6;
    double dewPointTemp = -23;
    double windSpeed = 3;
    double totalRain = 40;

    StevensonReading reading = new StevensonReading(airTemp, dewPointTemp, windSpeed, totalRain);

    double actualVapourPressure = ((7.5 * dewPointTemp) / (237.3 + dewPointTemp)) * (6.11 * 10);
    double saturatedVapourPressure = ((7.5 * airTemp) / (237.3 + airTemp)) * (6.11 * 10);
    double relativeHumidity = (actualVapourPressure / saturatedVapourPressure) * 100;

    final double c1 = -8.78469475556;
    final double c2 = 1.61139411;
    final double c3 = 2.33854883889;
    final double c4 = -0.14611605;
    final double c5 = -0.012308094;
    final double c6 = -0.0164248277778;
    final double c7 = 0.002211732;
    final double c8 = 0.00072546;
    final double c9 = -0.000003582;
    double heatIndex = (c1) + (c2 * airTemp) + (c3 * relativeHumidity)
        + (c4 * airTemp * relativeHumidity) + (c5 * Math.pow(airTemp, 2))
        + (c6 * Math.pow(relativeHumidity, 2)) + (c7 * Math.pow(airTemp, 2) * relativeHumidity)
        + (c8 * airTemp * Math.pow(relativeHumidity, 2))
        + (c9 * Math.pow(airTemp, 2) * Math.pow(relativeHumidity, 2));

    assertEquals((int) Math.round(heatIndex), reading.getHeatIndex());

    // performing Fuzzy test
    // all Readings are +ve with Dew Point Temperature>Air Temperature
    for (int i = 0; i < 50000; i++) {
      Random r = new Random();
      airTemp = r.nextDouble();
      dewPointTemp = airTemp - 0.1;
      windSpeed = r.nextDouble();
      totalRain = r.nextDouble();

      reading = new StevensonReading(airTemp, dewPointTemp, windSpeed, totalRain);
      actualVapourPressure = ((7.5 * dewPointTemp) / (237.3 + dewPointTemp)) * (6.11 * 10);
      saturatedVapourPressure = ((7.5 * airTemp) / (237.3 + airTemp)) * (6.11 * 10);
      relativeHumidity = (actualVapourPressure / saturatedVapourPressure) * 100;

      heatIndex = (c1) + (c2 * airTemp) + (c3 * relativeHumidity)
          + (c4 * airTemp * relativeHumidity) + (c5 * Math.pow(airTemp, 2))
          + (c6 * Math.pow(relativeHumidity, 2)) + (c7 * Math.pow(airTemp, 2) * relativeHumidity)
          + (c8 * airTemp * Math.pow(relativeHumidity, 2))
          + (c9 * Math.pow(airTemp, 2) * Math.pow(relativeHumidity, 2));

      assertEquals((int) Math.round(relativeHumidity), reading.getRelativeHumidity());
      assertEquals((int) Math.round(heatIndex), reading.getHeatIndex());

    }

  }

  @Test
  public void testGetWindChill() {
    double airTemp = -10.6;
    double dewPointTemp = -23;
    double windSpeed = 3;
    double totalRain = 40;

    StevensonReading reading = new StevensonReading(airTemp, dewPointTemp, windSpeed, totalRain);

    double airTempInF = ((9 * airTemp) / 5) + 32;
    double windChill = 35.74 + (0.6215 * airTempInF) - (35.75 * Math.pow(windSpeed, 0.16))
        + (0.4275 * airTempInF * Math.pow(windSpeed, 0.16));
    windChill = ((windChill - 32) / 9) * 5;
    assertEquals((int) Math.round(windChill), reading.getWindChill());

    // performing Fuzzy test
    // all Readings are +ve with Dew Point Temperature>Air Temperature
    for (int i = 0; i < 50000; i++) {
      Random r = new Random();
      airTemp = r.nextDouble();
      dewPointTemp = airTemp - 0.1;
      windSpeed = r.nextDouble();
      totalRain = r.nextDouble();
      reading = new StevensonReading(airTemp, dewPointTemp, windSpeed, totalRain);
      airTempInF = ((9 * airTemp) / 5) + 32;
      windChill = 35.74 + (0.6215 * airTempInF) - (35.75 * Math.pow(windSpeed, 0.16))
          + (0.4275 * airTempInF * Math.pow(windSpeed, 0.16));
      windChill = ((windChill - 32) / 9) * 5;
      assertEquals((int) Math.round(windChill), reading.getWindChill());

    }

  }

  @Test
  public void testValidReading() {
    double airTemp = -10.6;
    double dewPointTemp = -23;
    double windSpeed = 3;
    double totalRain = 40;

    int roundedAirTemp = (int) Math.round(airTemp);
    int roundedDewPointTemp = (int) Math.round(dewPointTemp);
    int roundedWindSpeed = (int) Math.round(windSpeed);
    int roundedTotalRain = (int) Math.round(totalRain);

    StevensonReading reading = new StevensonReading(airTemp, dewPointTemp, windSpeed, totalRain);
    String expectedReading = String.format("Reading: T = %d, D = %d, v = %d, rain = %d",
        roundedAirTemp, roundedDewPointTemp, roundedWindSpeed, roundedTotalRain);
    assertEquals(expectedReading, reading.toString());
    assertEquals(roundedAirTemp, reading.getTemperature());
    assertEquals(roundedDewPointTemp, reading.getDewPoint());
    assertEquals(roundedWindSpeed, reading.getWindSpeed());
    assertEquals(roundedTotalRain, reading.getTotalRain());

    // performing Fuzzy test
    // all Readings are +ve with Dew Point Temperature>Air Temperature
    for (int i = 0; i < 50000; i++) {
      Random r = new Random();
      airTemp = r.nextDouble();
      dewPointTemp = airTemp - 0.1;
      windSpeed = r.nextDouble();
      totalRain = r.nextDouble();

      roundedAirTemp = (int) Math.round(airTemp);
      roundedDewPointTemp = (int) Math.round(dewPointTemp);
      roundedWindSpeed = (int) Math.round(windSpeed);
      roundedTotalRain = (int) Math.round(totalRain);

      reading = new StevensonReading(airTemp, dewPointTemp, windSpeed, totalRain);
      expectedReading = String.format("Reading: T = %d, D = %d, v = %d, rain = %d", roundedAirTemp,
          roundedDewPointTemp, roundedWindSpeed, roundedTotalRain);
      assertEquals(expectedReading, reading.toString());
      assertEquals(roundedAirTemp, reading.getTemperature());
      assertEquals(roundedDewPointTemp, reading.getDewPoint());
      assertEquals(roundedWindSpeed, reading.getWindSpeed());
      assertEquals(roundedTotalRain, reading.getTotalRain());

    }

  }

  @Test(expected = IllegalArgumentException.class)
  public void testInValidReadingForDewPointTempGreaterThanAirTemp() {
    // dew point temperature > air temperature
    double airTemp = -23;
    double dewPointTemp = -10;
    double windSpeed = 3;
    double totalRain = 40;
    StevensonReading reading = new StevensonReading(airTemp, dewPointTemp, windSpeed, totalRain);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInValidReadingForNegativeWindSpeed() {
    // negative wind speed
    double airTemp = 23;
    double dewPointTemp = 10;
    double windSpeed = -3;
    double totalRain = 40;
    StevensonReading reading = new StevensonReading(airTemp, dewPointTemp, windSpeed, totalRain);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInValidReadingForNegativeTotalRain() {
    // negative wind speed
    double airTemp = 23;
    double dewPointTemp = 10;
    double windSpeed = 3;
    double totalRain = -40;
    StevensonReading reading = new StevensonReading(airTemp, dewPointTemp, windSpeed, totalRain);
    
  }
  
  @Test
  public void testEquals() {
    for (int i = 0; i < 50000; i++) {
      Random r = new Random();
      double airTemp = r.nextDouble();
      double dewPointTemp = airTemp - 0.1;
      double windSpeed = r.nextDouble();
      double totalRain = r.nextDouble();

      StevensonReading reading = new StevensonReading(airTemp, dewPointTemp, windSpeed, totalRain);
      StevensonReading sameReading = new StevensonReading(airTemp, dewPointTemp, windSpeed,
          totalRain);
      StevensonReading differentReading = new StevensonReading(airTemp + 1, dewPointTemp, windSpeed,
          totalRain);
      assertTrue(reading.equals(reading));
      assertTrue(reading.equals(sameReading));
      assertFalse(reading.equals(differentReading));
      assertFalse(reading.equals("harshitha"));
    }
  }

  @Test
  public void testHashCode() {
    for (int i = 0; i < 50000; i++) {
      Random r = new Random();
      double airTemp = r.nextDouble();
      double dewPointTemp = airTemp - 0.1;
      double windSpeed = r.nextDouble();
      double totalRain = r.nextDouble();

      StevensonReading reading = new StevensonReading(airTemp, dewPointTemp, windSpeed, totalRain);
      assertEquals(Objects.hash(airTemp, dewPointTemp, windSpeed, totalRain), reading.hashCode());
    }
  }
}
