package polynomial;

/**
 * Represents a real term node.
 *
 */
public class RealTermNode implements TermsNode {

  static int count;
  private final PolynomialTerm polyTerm;
  private final TermsNode remainingTerms;

  /**
   * Constructs a RealTermNode object.
   * 
   * @param polynomialTerm polynomialTerm
   * @param restOfTerms    rest of the terms
   */
  public RealTermNode(PolynomialTerm polynomialTerm, TermsNode restOfTerms) {
    this.polyTerm = polynomialTerm;
    this.remainingTerms = restOfTerms;
  }

  @Override
  public TermsNode addTerm(PolynomialTerm polyTerm) {
    validatePolynomialTerm(polyTerm);
    return constructPolynomialTerm(polyTerm);
  }

  private void validatePolynomialTerm(PolynomialTerm polyTerm) {
    if (polyTerm == null) {
      throw new IllegalArgumentException("Polynomial Term cannot be Null");
    }
  }

  private TermsNode constructPolynomialTerm(PolynomialTerm polyTerm) {
    final int polyTermDegree1 = polyTerm.getPolynomialTermDegree();
    final int polyTermDegree2 = this.polyTerm.getPolynomialTermDegree();
    if (polyTermDegree1 == polyTermDegree2) {
      PolynomialTerm t = new PolynomialTerm(
          this.polyTerm.getPolynomialTermCoefficient() + polyTerm.getPolynomialTermCoefficient(),
          polyTerm.getPolynomialTermDegree());
      return new RealTermNode(t, this.remainingTerms);
    } else if (polyTermDegree2 < polyTermDegree1) {
      return new RealTermNode(polyTerm, this);
    } else {
      return new RealTermNode(this.polyTerm, remainingTerms.addTerm(polyTerm));
    }
  }

  @Override
  public Polynomial add(Polynomial other) {
    validatePolynomial(other);
    final int coefficient = this.polyTerm.getPolynomialTermCoefficient();
    final int degree = this.polyTerm.getPolynomialTermDegree();
    other.addTerm(coefficient, degree);
    return remainingTerms.add(other);
  }

  /**
   * Validates Polynomial.
   * 
   * @param polynomial polynomial to be validated
   * @throws IllegalArgumentException when Provided Polynomial is null or not of
   *                                  type PolynomialImpl
   */
  private void validatePolynomial(Polynomial polynomial) {
    if (polynomial == null) {
      throw new IllegalArgumentException("Provided Polynomial to be compared cannot be null!");
    }
    if (!(polynomial instanceof PolynomialImpl)) {
      throw new IllegalArgumentException("Provided Polynomial is not of type Polynomial!");
    }

  }

  @Override
  public int getCoefficient(int power) {
    validatePower(power);
    if (this.polyTerm.getPolynomialTermDegree() == power) {
      return this.polyTerm.getPolynomialTermCoefficient();
    } else {
      return remainingTerms.getCoefficient(power);
    }
  }

  /**
   * Validates Power.
   * 
   * @param power power to be validated
   * @throws IllegalArgumentException when Power is negative
   */
  private void validatePower(int power) {
    if (power < 0) {
      throw new IllegalArgumentException("Power cannot be negative");
    }
  }

  @Override
  public int getDegree() {
    if (this.polyTerm.getPolynomialTermDegree() >= remainingTerms.getDegree()) {
      return this.polyTerm.getPolynomialTermDegree();
    }
    return remainingTerms.getDegree();
  }

  @Override
  public boolean isSame(Polynomial polynomial) {
    return this.toString().trim().equals(polynomial.toString().trim());
  }

  @Override
  public double evaluate(double x, double evaluationValue) {
    evaluationValue = evaluationValue + polyTerm.getPolynomialTermValue(x);
    return this.remainingTerms.evaluate(x, evaluationValue);
  }

  @Override
  public String toString() {
    count = 0;
    return toStringHelper(new StringBuilder());
  }

  @Override
  public String toStringHelper(StringBuilder stringBuilder) {
    if (this.polyTerm.getPolynomialTermDegree() == 0) {
      count++;
      return remainingTerms.toStringHelper(new StringBuilder(stringBuilder
          .append(String.format("%+d", this.polyTerm.getPolynomialTermCoefficient()))));
    }
    if ((polyTerm.toString().charAt(0)) == '+' && count == 0) {
      count++;
      return remainingTerms.toStringHelper(new StringBuilder(
          stringBuilder.append(polyTerm.toString().substring(1)) + String.format(" ")));
    }
    count++;
    return remainingTerms.toStringHelper(
        new StringBuilder(stringBuilder.append(polyTerm.toString() + String.format(" "))));
  }
}
