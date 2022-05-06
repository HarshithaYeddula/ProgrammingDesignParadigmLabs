package polynomial;

/**
 * Polynomial implementation represents the creation of polynomial by splitting
 * the polynomial and performing operation such as add term , add polynomial,
 * getting coefficient or getting degree.
 */
public class PolynomialImpl implements Polynomial {

  private TermsNode termsNode;

  /**
   * Constructing a polynomial object.
   */
  public PolynomialImpl() {
    termsNode = new EmptyTermNode();
  }

  /**
   * Constructing a polynomial object.
   * 
   * @param polynomial input polyniomial
   * @throws IllegalArgumentException when Polynomial is null or empty.
   */
  public PolynomialImpl(String polynomial) throws IllegalArgumentException {
    validatePolynomial(polynomial);
    this.termsNode = parsePolynomial(polynomial);
  }

  @Override
  public Polynomial add(Polynomial other) throws IllegalArgumentException {
    validatePolynomial(other);
    return this.termsNode.add(other);
  }

  @Override
  public void addTerm(int coefficient, int power) throws IllegalArgumentException {
    validatePower(power);
    termsNode = termsNode.addTerm(new PolynomialTerm(coefficient, power));
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
  public boolean isSame(Polynomial poly) {
    if (!(poly instanceof PolynomialImpl)) {
      return false;
    }
    if (poly.getDegree() != this.getDegree()) {
      return false;
    }
    return this.termsNode.isSame(poly);
  }

  @Override
  public double evaluate(double x) {
    return termsNode.evaluate(x, 0);
  }

  @Override
  public int getCoefficient(int power) {
    validatePower(power);
    return termsNode.getCoefficient(power);
  }

  @Override
  public int getDegree() {
    return termsNode.getDegree();
  }

  @Override
  public String toString() {
    if (termsNode.toString().charAt(0) == '+') {
      return termsNode.toString().substring(1).trim();
    }
    return termsNode.toString().trim();
  }

  /**
   * Validates Polynomial.
   * 
   * @param polynomial Polynomial object passed to the constructor
   */
  private void validatePolynomial(String polynomial) {
    if (polynomial == null || "".equals(polynomial)) {
      throw new IllegalArgumentException("Polynomial cannot be null or empty");
    }
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

  /**
   * Parses Polynomial.
   * 
   * @param polynomial Polynomial object passed to the constructor
   * @return TermsNode
   */
  private TermsNode parsePolynomial(String polynomial) {
    TermsNode polynomialTerm = new EmptyTermNode();
    int coefficient;
    int power;
    String[] terms = polynomial.split(" ");
    for (int i = 0; i < terms.length; i++) {
      String individualTerm = terms[i];
      String[] term = individualTerm.split("\\^");
      if (term.length > 1) {
        coefficient = Integer.parseInt(term[0].substring(0, term[0].length() - 1));
        power = Integer.parseInt(term[1]);
      } else {
        coefficient = Integer.parseInt(term[0]);
        power = 0;
      }
      polynomialTerm = polynomialTerm.addTerm(new PolynomialTerm(coefficient, power));
    }
    return polynomialTerm;

  }
}
