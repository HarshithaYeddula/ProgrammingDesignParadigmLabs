package document.elements;

import document.TextElementVisitor;

/**
 * Representation for any of the text elements of a document.
 */
public interface TextElement {

  /**
   * Returns the text of the element.
   * 
   * @return the text
   */
  public String getText();

  /**
   * Transform a visitor into elements.
   *
   * @param <R>     the type of elements in the visitor
   * @param visitor the visitor to use
   * @return the accepted element
   * @throws IllegalArgumentException for invalid values of visitor
   */
  public <R> R accept(TextElementVisitor<R> visitor) throws IllegalArgumentException;
}
