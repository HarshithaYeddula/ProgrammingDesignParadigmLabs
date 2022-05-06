import static org.junit.Assert.assertEquals;

import org.junit.Test;
import polynomial.Polynomial;
import polynomial.PolynomialImpl;

/**
 * Test class for Polynomial Implementation.
 *
 */
public class PolynomialImplTest {

  @Test
  public void testDefaultConstructor() {
    Polynomial poly = new PolynomialImpl();
    assertEquals("0", poly.toString());
    assertEquals(0, poly.getDegree());
  }

  @Test
  public void testParamaterizedConstructor() {
    Polynomial poly = new PolynomialImpl("4x^3 +3x^1 -5");
    assertEquals("4x^3 +3x^1 -5", poly.toString());
  }

  @Test
  public void testParamaterizedConstructorTermsWithSamePower() {
    Polynomial poly = new PolynomialImpl("4x^3 +3x^3 +2x^2 +4x^2 +9x^2 +3x^1 -5");
    assertEquals("7x^3 +15x^2 +3x^1 -5", poly.toString());
  }

  @Test
  public void testParamaterizedConstructorWithConstantPolynomial() {
    Polynomial poly = new PolynomialImpl("10");
    assertEquals("10", poly.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testParamaterizedConstructorWithEmptyString() {
    new PolynomialImpl("");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testParamaterizedConstructorWithInvalidString() {
    new PolynomialImpl("abc");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testParamaterizedConstructorWithNullString() {
    new PolynomialImpl("null");
  }

  @Test
  public void testAddWithUniquePowers() {
    Polynomial p1 = new PolynomialImpl("4x^3 +9x^2 +3x^1 -5");
    Polynomial p2 = new PolynomialImpl("10x^6 +11x^5 +12x^4");
    Polynomial p = p1.add(p2);
    assertEquals("10x^6 +11x^5 +12x^4 +4x^3 +9x^2 +3x^1 -5", p.toString());
  }

  @Test
  public void testAddWithSamePowers() {
    Polynomial p1 = new PolynomialImpl("4x^3 +9x^2 +3x^1 -5");
    Polynomial p2 = new PolynomialImpl("4x^3 +9x^2 +3x^1 -5");
    Polynomial p = p1.add(p2);
    assertEquals("8x^3 +18x^2 +6x^1 -10", p.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddTermWithPowerNegative() {
    new PolynomialImpl("4x^-3 +9x^2 +3x^1 -5");
  }

  @Test
  public void testAddTermWithTermAlredayExisting() {
    Polynomial p = new PolynomialImpl("4x^3 +4x^3 +9x^2 +3x^1 -5");
    assertEquals("8x^3 +9x^2 +3x^1 -5", p.toString());
  }

  @Test
  public void testAddTermWithTermUnique() {
    Polynomial p = new PolynomialImpl("4x^3 +9x^2 +3x^1 -5");
    assertEquals("4x^3 +9x^2 +3x^1 -5", p.toString());
  }

  @Test
  public void testisSameWithUniqueTerms() {
    Polynomial p1 = new PolynomialImpl("4x^3 +9x^2 +3x^1 -5");
    Polynomial p2 = new PolynomialImpl("10x^6 +11x^5 +12x^4");
    assertEquals(false, p1.isSame(p2));
  }

  @Test
  public void testisSameWithSameTerms() {
    Polynomial p1 = new PolynomialImpl("4x^3 +9x^2 +3x^1 -5");
    Polynomial p2 = new PolynomialImpl("4x^3 +9x^2 +3x^1 -5");
    assertEquals(true, p1.isSame(p2));
  }

  @Test
  public void testgetDegreeWithPositiveDegree() {
    Polynomial p1 = new PolynomialImpl("4x^3 +9x^2 +3x^1 -5");
    assertEquals(3, p1.getDegree());
  }

  @Test
  public void testgetDegreeWithConstantPolynomial() {
    Polynomial p1 = new PolynomialImpl("4");
    assertEquals(0, p1.getDegree());
  }

  @Test
  public void testgetCoefficientIfaTermExistsWithThepower() {
    Polynomial p1 = new PolynomialImpl("4x^3 +9x^2 +3x^1 -5");
    assertEquals(4, p1.getCoefficient(3));
  }

  @Test
  public void testgetCoefficientIfaTermDoesNotExistWithThepower() {
    Polynomial p1 = new PolynomialImpl("4x^3 +9x^2 +3x^1 -5");
    assertEquals(0, p1.getCoefficient(4));
  }

  @Test
  public void testEvaluateWithNegativeX() {
    Polynomial p1 = new PolynomialImpl("4x^3 +9x^2 +3x^1 -5");
    assertEquals(-200.75, p1.evaluate(-4.5), 0.001);
  }

  @Test
  public void testEvaluateWithPositiveX() {
    Polynomial p1 = new PolynomialImpl("4x^3 +9x^2 +3x^1 -5");
    assertEquals(555.25, p1.evaluate(4.5), 0.001);
  }

}
