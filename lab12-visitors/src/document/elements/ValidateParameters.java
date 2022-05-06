package document.elements;

import document.TextElementVisitor;

/**
 * Abstract class for validating paramaters.
 * 
 * @author mail2
 *
 */
public abstract class ValidateParameters {

  /**
   * Validates visitor.
   * 
   * @param <R>     {@link TextElementVisitor}
   * @param visitor visitor to be validated
   */
  protected <R> void validateVisitor(TextElementVisitor<R> visitor) {

    if (visitor == null) {
      throw new IllegalArgumentException("Visitor cannot be null!!!");
    }

  }

  /**
   * Validates Text.
   * 
   * @param text to be validated.
   */
  protected void validateText(String text) {
    if (text == null) {
      throw new IllegalArgumentException("Text cannot be null!!!");
    }
  }

}
