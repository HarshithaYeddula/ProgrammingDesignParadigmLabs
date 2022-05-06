package polynomial;

/**
 * Empty Term represents there are no terms in the polynomial initially and when
 * tries to add then add term creates an real term to the empty term.
 */
public class EmptyTermNode implements TermsNode {

  @Override
  public TermsNode addTerm(PolynomialTerm polynomialTerm) {
    return new RealTermNode(polynomialTerm, this);
  }

  @Override
  public Polynomial add(Polynomial otherPolynomial) {
    return otherPolynomial;
  }

  @Override
  public int getCoefficient(int polynomialTermDegree) {
    return 0;
  }

  @Override
  public int getDegree() {
    return 0;
  }

  @Override
  public boolean isSame(Polynomial polynomial) {
    return true;
  }

  @Override
  public double evaluate(double x, double evaluationValue) {
    return evaluationValue;
  }

  @Override
  public String toString() {
    return String.format("0");
  }

  @Override
  public String toStringHelper(StringBuilder stringBuilder) {
    return stringBuilder.toString();
  }
}
