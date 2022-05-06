package weather;

import java.util.Objects;

/**
 * StevensonReading has been implemented to store readings - Air Temperature,
 * Dew Point Temperature, Wind Speed and Total Rain- from Stevenson Station and
 * calculate Relative Humidity, Wind Chill and Heat Index.
 */
public final class StevensonReading implements WeatherReading {

  private final double airTemp;
  private final double dewPointTemp;
  private final double windSpeed;
  private final double totalRain;

  /**
   * Provides a StevensonReading object from the given parameters.
   * 
   * @param airTemp      in Celsius
   * @param dewPointTemp in Celsius
   * @param windSpeed    in miles per hour
   * @param totalRain    in the last 24 hours in milliemeters
   * @throws IllegalArgumentException in the following cases:- Dew Point
   *                                  Temperature>Air Temperature Wind Speed<0
   *                                  Total Rain<0
   */
  public StevensonReading(double airTemp, double dewPointTemp, double windSpeed, double totalRain)
      throws IllegalArgumentException {
    if (dewPointTemp > airTemp) {
      throw new IllegalArgumentException(
          "Dew Point Temperature Cannot be greater than Air Temperature");
    }
    if (windSpeed < 0) {
      throw new IllegalArgumentException("Wind Speed cannot be negative");
    }
    if (totalRain < 0) {
      throw new IllegalArgumentException("Total Rain cannot be negative");
    }
    this.airTemp = airTemp;
    this.dewPointTemp = dewPointTemp;
    this.windSpeed = windSpeed;
    this.totalRain = totalRain;
  }

  @Override
  public int getTemperature() {
    return (int) Math.round(airTemp);
  }

  @Override
  public int getDewPoint() {
    return (int) Math.round(dewPointTemp);
  }

  @Override
  public int getWindSpeed() {
    return (int) Math.round(windSpeed);
  }

  @Override
  public int getTotalRain() {
    return (int) Math.round(totalRain);
  }

  @Override
  public int getRelativeHumidity() {
    if (airTemp == 0) {
      throw new ArithmeticException(
          "Air Temperature cannot be zero while calculating Air Temperature.");
    }
    return (int) Math.round(getUnroundedRelativeHumidity());
  }

  /**
   * Relative Humidity calculated in double.
   * 
   * @return the Relative Humidity
   */
  public double getUnroundedRelativeHumidity() {
    double actualVapourPressure = ((7.5 * dewPointTemp) / (237.3 + dewPointTemp)) * (6.11 * 10);
    double saturatedVapourPressure = ((7.5 * airTemp) / (237.3 + airTemp)) * (6.11 * 10);
    return (actualVapourPressure / saturatedVapourPressure) * 100.0;
  }

  @Override
  public int getHeatIndex() {
    final double c1 = -8.78469475556;
    final double c2 = 1.61139411;
    final double c3 = 2.33854883889;
    final double c4 = -0.14611605;
    final double c5 = -0.012308094;
    final double c6 = -0.0164248277778;
    final double c7 = 0.002211732;
    final double c8 = 0.00072546;
    final double c9 = -0.000003582;
    final double relativeHumidity = getUnroundedRelativeHumidity();
    final double heatIndex = c1 + (c2 * airTemp) + (c3 * relativeHumidity)
        + (c4 * airTemp * relativeHumidity) + (c5 * Math.pow(airTemp, 2))
        + (c6 * Math.pow(relativeHumidity, 2)) + (c7 * Math.pow(airTemp, 2) * relativeHumidity)
        + (c8 * airTemp * Math.pow(relativeHumidity, 2))
        + (c9 * Math.pow(airTemp, 2) * Math.pow(relativeHumidity, 2));
    return (int) Math.round(heatIndex);
  }

  @Override
  public int getWindChill() {
    final double airTempInF = toFarenhite(airTemp);
    double windChill = 35.74 + (0.6215 * airTempInF) - (35.75 * Math.pow(windSpeed, 0.16))
        + (0.4275 * airTempInF * Math.pow(windSpeed, 0.16));
    windChill = toCelsius(windChill);
    return (int) Math.round(windChill);
  }

  private double toFarenhite(double temp) {
    return ((9 * temp) / 5) + 32;
  }

  private double toCelsius(double temp) {
    return ((temp - 32) / 9) * 5;
  }

  /**
   * Returns a String representation of the readings where each reading is rounded
   * to the nearest integer. This String is of the form Reading: T = Air
   * Temperature, D = Dew Point Temperature, v = Wind Speed in miles per hour,
   * rain = Total rain in millimeters
   * 
   * @return the String representation of the readings.
   */
  public String toString() {

    return String.format("Reading: T = %d, D = %d, v = %d, rain = %d", getTemperature(),
        getDewPoint(), getWindSpeed(), getTotalRain());

  }

  /**
   * Checks if the incoming object is of type StevensonReading and compares it.
   * with the existing StevensonReading object.
   * 
   * @param obj of type Object
   * @return true if both the objects are equal else false
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof StevensonReading)) {
      return false;
    }
    StevensonReading that = (StevensonReading) obj;
    if (this.getTemperature() == that.getTemperature() && this.getDewPoint() == that.getDewPoint()
        && this.getWindSpeed() == that.getWindSpeed()
        && this.getTotalRain() == that.getTotalRain()) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Used for calculating hash for the class variables.
   * 
   * @return value of hash on the objects
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.airTemp, this.dewPointTemp, this.windSpeed, this.totalRain);

  }

}
