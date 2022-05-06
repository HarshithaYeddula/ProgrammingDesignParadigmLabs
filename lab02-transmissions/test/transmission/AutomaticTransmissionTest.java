package transmission;

import static org.junit.Assert.assertEquals;

import java.util.Objects;
import org.junit.Test;

/**
 * Class for testing AutomaticTransmission class.
 * 
 * @author Harshitha Yeddula
 */
public class AutomaticTransmissionTest {

  @Test(expected = IllegalArgumentException.class)
  public void testInValidConstructorIfThresholdIsNegative() {
    Transmission automaticTransmission = new AutomaticTransmission(-10, 20, 30, 40, 50);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInValidConstructorIfFirstThresholdIsZero() {
    Transmission automaticTransmission = new AutomaticTransmission(0, 20, 30, 40, 50);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInValidConstructorIfThresholdIsNotMonotonicallyIncreasing() {
    Transmission automaticTransmission = new AutomaticTransmission(10, 30, 20, 40, 50);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInValidConstructorIfTwoThresholdsAreSame() {
    Transmission automaticTransmission = new AutomaticTransmission(10, 10, 20, 40, 50);
  }

  @Test
  public void testValidConstructor() {
    Transmission automaticTransmission = new AutomaticTransmission(10, 20, 30, 40, 50);
  }

  @Test(expected = IllegalStateException.class)
  public void testDecereasingSpeedWhenSpeedBecomesNegative() {
    Transmission automaticTransmission = new AutomaticTransmission(10, 20, 30, 40, 50);
    automaticTransmission.decreaseSpeed();
  }

  @Test
  public void testIncreaseSpeed() {
    Transmission automaticTransmission = new AutomaticTransmission(10, 20, 30, 40, 50);
    for (int i = 0; i < 51; i++) {
      automaticTransmission.increaseSpeed();
    }
    assertEquals(51, automaticTransmission.getSpeed());
    assertEquals(6, automaticTransmission.getGear());
    String expected = String.format("Transmission (speed = %d, gear = %d)", 51, 6);
    assertEquals(expected, automaticTransmission.toString());
  }

  @Test
  public void testDecreaseSpeed() {
    Transmission automaticTransmission = new AutomaticTransmission(10, 20, 30, 40, 50);
    for (int i = 0; i < 51; i++) {
      automaticTransmission.increaseSpeed();
    }
    for (int i = 0; i < 31; i++) {
      automaticTransmission.decreaseSpeed();
    }
    assertEquals(20, automaticTransmission.getSpeed());
    assertEquals(3, automaticTransmission.getGear());
    String expected = String.format("Transmission (speed = %d, gear = %d)", 20, 3);
    assertEquals(expected, automaticTransmission.toString());
  }

  @Test
  public void testIdleState() {
    Transmission automaticTransmission = new AutomaticTransmission(10, 20, 30, 40, 50);
    assertEquals(0, automaticTransmission.getSpeed());
    assertEquals(0, automaticTransmission.getGear());
    String expected = String.format("Transmission (speed = %d, gear = %d)", 0, 0);
    assertEquals(expected, automaticTransmission.toString());
  }

  @Test
  public void testHashCode() {
    Transmission automaticTransmission = new AutomaticTransmission(10, 20, 30, 40, 50);
    assertEquals(Objects.hash(10, 20, 30, 40, 50, 0, 0), automaticTransmission.hashCode());
  }

  @Test
  public void testEquals() {
    Transmission automaticTransmission = new AutomaticTransmission(10, 20, 30, 40, 50);

    Transmission that = new AutomaticTransmission(10, 20, 30, 40, 50);
    assertEquals(false, automaticTransmission.equals(""));
    assertEquals(true, automaticTransmission.equals(automaticTransmission));
    assertEquals(true, automaticTransmission.equals(that));
    assertEquals(false,
        automaticTransmission.equals(new AutomaticTransmission(20, 30, 40, 50, 60)));
  }

}
