package polynomial;

/**
 * Terms representing the common operations that will be performed recursively on the polynomial.
 */
public interface TermsNode {

  /**
   * Adding term to the existing terms.
   * @param term polynomial term that has to be added.
   * @return termNode after adding the polynomial
   */
  TermsNode addTerm(PolynomialTerm term);

  /**
   * Adding polynomial to the existing polynomial.
   * @param other the polynomial that needs to be added.
   * @return the polynomial after addition.
   */
  Polynomial add(Polynomial other);

  /**
   * Getting the coefficient of the current term of the polynomial.
   * @param power power of the polynomial for which the coefficient
   *                             needs to be returned.
   * @return coefficient of the current polynomial.
   */
  int getCoefficient(int power);

  /**
   * Getting the power of the current Term of the polynomial.
   * @return the power of the polynomial.
   */
  int getDegree();

  /**
   * Checking if the polynomial given and the current polynomial are same.
   * @param polynomial the polynomial that needs to be checked with the current polynomial.
   * @return true if both are same, or else false.
   */
  boolean isSame(Polynomial polynomial);

  /**
   * Evaluating the value of the polynomial at a given point.
   * @param x the point at which the polynomial has to be evaluated.
   * @param evaluationValue the value of the polynomial at the point x.
   * @return  evaluation value of the polynomial at the point x.
   */
  double evaluate(double x, double evaluationValue);

  /**
   * Helper method for the toString() to display the polynomial terms.
   * @param stringBuilder to append multiple terms.
   * @return string that needs to be displayed.
   */
  String toStringHelper(StringBuilder stringBuilder);
}
