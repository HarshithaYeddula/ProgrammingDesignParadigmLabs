package document;

import document.elements.BasicText;
import document.elements.BoldText;
import document.elements.Heading;
import document.elements.HyperText;
import document.elements.ItalicText;
import document.elements.Paragraph;
import document.elements.TextElement;

/**
 * WordCountVisitor helps in adding the individual words and returns the count.
 */
public class WordCountVisitor implements TextElementVisitor<Integer> {

  @Override
  public Integer visitBasicText(BasicText text) {
    return getCount(text);
  }

  @Override
  public Integer visitBoldText(BoldText text) {
    return getCount(text);
  }

  @Override
  public Integer visitHeading(Heading text) {
    return getCount(text);
  }

  @Override
  public Integer visitItalicText(ItalicText text) {
    return getCount(text);
  }

  @Override
  public Integer visitParagraph(Paragraph text) {
    return getCount(text);
  }

  @Override
  public Integer visitHyperText(HyperText text) {
    return getCount(text);
  }

  private Integer getCount(TextElement element) {
    return element.getText().split(" ").length;
  }
}
