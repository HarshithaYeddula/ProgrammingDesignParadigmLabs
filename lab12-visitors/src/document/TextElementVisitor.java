package document;

import document.elements.BasicText;
import document.elements.BoldText;
import document.elements.Heading;
import document.elements.HyperText;
import document.elements.ItalicText;
import document.elements.Paragraph;

/**
 * Interface that provides methods to visit every type of text elements.
 * @param <R> the type of the return parameter for the visit
 */
public interface TextElementVisitor<R> {

  /**
   * Action to be taken when visiting basic text element.
   *
   * @param text basic text element
   * @return element
   */
  R visitBasicText(BasicText text);

  /**
   * Action to be taken when visiting bold text element.
   *
   * @param text bold text element
   * @return element
   */
  R visitBoldText(BoldText text);

  /**
   * Action to be taken when visiting heading element.
   *
   * @param text heading text element
   * @return the element
   */
  R visitHeading(Heading text);

  /**
   * Action to be taken when visiting Italic element.
   *
   * @param text italic text element
   * @return element
   */
  R visitItalicText(ItalicText text);

  /**
   * Action to be taken when visiting paragraph element.
   *
   * @param text basic text element
   * @return the element
   */
  R visitParagraph(Paragraph text);

  /**
   * Action to be taken when visiting Hypertext element.
   *
   * @param text basic text element
   * @return the element
   */
  R visitHyperText(HyperText text);
}
