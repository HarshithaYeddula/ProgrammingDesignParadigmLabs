package transmission;

import java.util.Objects;
import java.util.stream.IntStream;

/**
 * Automatic Transmission class has been implemented that accepts 5 thresholds
 * to perform automatic gear change.
 * 
 * @author Harshitha
 *
 */
public final class AutomaticTransmission implements Transmission {

  private final int gear1Threshold;
  private final int gear2Threshold;
  private final int gear3Threshold;
  private final int gear4Threshold;
  private final int gear5Threshold;
  private int speed;
  private int gear;

  /**
   * Provides a automatic transmission object from the arguments passed to the
   * constructor.
   * 
   * @param gear1Threshold in MPH
   * @param gear2Threshold in MPH
   * @param gear3Threshold in MPH
   * @param gear4Threshold in MPH
   * @param gear5Threshold in MPH
   */
  public AutomaticTransmission(int gear1Threshold, int gear2Threshold, int gear3Threshold,
      int gear4Threshold, int gear5Threshold) {
    super();

    int[] thresholds = new int[] { gear1Threshold, gear2Threshold, gear3Threshold, gear4Threshold,
        gear5Threshold };

    if (gear1Threshold == 0) {
      throw new IllegalArgumentException("First GearThreshold cannot be zero!");
    }

    if (IntStream.of(thresholds).anyMatch(x -> x < 0)) {
      throw new IllegalArgumentException("Any Threashold cannot be Less Than Zero!");
    }

    if (IntStream.range(1, thresholds.length).reduce(0,
        (acc, e) -> acc + (thresholds[e - 1] < thresholds[e] ? 0 : 1)) != 0) {
      throw new IllegalArgumentException("Thresholds should be in Increasing order!");
    }

    this.gear1Threshold = gear1Threshold;
    this.gear2Threshold = gear2Threshold;
    this.gear3Threshold = gear3Threshold;
    this.gear4Threshold = gear4Threshold;
    this.gear5Threshold = gear5Threshold;
    this.speed = 0;
    this.gear = 0;
  }

  @Override
  public void increaseSpeed() {
    speed = speed + 1;
    updateGear(speed);

  }

  private void updateGear(int speed) {
    // TODO: Enum class can be defined to achieve this
    if (speed > 0 && speed < gear1Threshold) {
      gear = 1;
    } else if (speed >= gear1Threshold && speed < gear2Threshold) {
      gear = 2;
    } else if (speed >= gear2Threshold && speed < gear3Threshold) {
      gear = 3;
    } else if (speed >= gear3Threshold && speed < gear4Threshold) {
      gear = 4;
    } else if (speed >= gear4Threshold && speed < gear5Threshold) {
      gear = 5;
    } else if (speed >= gear5Threshold) {
      gear = 6;
    }

  }

  @Override
  public void decreaseSpeed() throws IllegalStateException {
    speed = speed - 1;
    if (speed < 0) {
      throw new IllegalStateException("Speed cannot be negative");
    }
    updateGear(speed);
  }

  @Override
  public int getSpeed() {
    return this.speed;
  }

  @Override
  public int getGear() {
    return this.gear;
  }

  /**
   * Returns a String representation of the current speed and gear of the
   * transmission.
   * 
   * @return the String representation of the speed and gear.
   */
  @Override
  public String toString() {
    return String.format("Transmission (speed = %d, gear = %d)", speed, gear);
  }

  /**
   * Checks if the incoming object is of type AutomaticTransmission and compares
   * it. with the existing AutomaticTransmission object.
   * 
   * @param obj of type Object
   * @return true if both the objects are equal else false
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof AutomaticTransmission)) {
      return false;
    }
    AutomaticTransmission that = (AutomaticTransmission) obj;
    if (this.gear1Threshold == that.gear1Threshold && this.gear2Threshold == that.gear2Threshold
        && this.gear3Threshold == that.gear3Threshold && this.gear4Threshold == that.gear4Threshold
        && this.gear5Threshold == that.gear5Threshold && this.getSpeed() == that.getSpeed()
        && this.getGear() == that.getGear()) {
      return true;
    }
    return false;
  }

  /**
   * Used for calculating hash for the class variables.
   * 
   * @return value of hash on the objects
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.gear1Threshold, this.gear2Threshold, this.gear3Threshold,
        this.gear4Threshold, this.gear5Threshold, this.getSpeed(), this.getGear());

  }

}
