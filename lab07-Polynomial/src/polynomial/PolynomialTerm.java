package polynomial;

/**
 * Represents a polynomial term with a coefficient and a degree.
 *
 */
public class PolynomialTerm {

  private final int coefficient;
  private final int degree;

  /**
   * Constructs a Polynomial object with a coefficient and a degree.
   * 
   * @param coefficient coefficient of the polynomial.
   * @param degree      degree of the polynomial.
   * @throws IllegalArgumentException when degree is negative.
   */
  public PolynomialTerm(int coefficient, int degree) {
    if (degree < 0) {
      throw new IllegalArgumentException("Polynomial Term degree cannot be negative");
    }
    this.coefficient = coefficient;
    this.degree = degree;
  }

  protected double getPolynomialTermValue(double x) {
    return this.coefficient * Math.pow(x, this.degree);
  }

  protected int getPolynomialTermCoefficient() {
    return this.coefficient;
  }

  protected int getPolynomialTermDegree() {
    return this.degree;
  }

  @Override
  public String toString() {
    if (this.coefficient < 0) {
      return String.format(this.coefficient + "x^" + this.degree);
    }
    return String.format("+" + this.coefficient + "x^" + this.degree);
  }
}
