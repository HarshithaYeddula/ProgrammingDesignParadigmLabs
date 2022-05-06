package document;

import document.elements.BasicText;
import document.elements.BoldText;
import document.elements.Heading;
import document.elements.HyperText;
import document.elements.ItalicText;
import document.elements.Paragraph;
import document.elements.TextElement;

/**
 * BasicStringVisitor helps in adding the individual string elements.
 */
public class BasicStringVisitor extends AbstractVisitor implements TextElementVisitor<Void> {

  @Override
  public Void visitBasicText(BasicText text) {
    validateText(text);
    return contentAppendHelper(text);
  }

  @Override
  public Void visitBoldText(BoldText text) {
    validateText(text);
    return contentAppendHelper(text);
  }

  @Override
  public Void visitHeading(Heading text) {
    validateText(text);
    return contentAppendHelper(text);
  }

  @Override
  public Void visitItalicText(ItalicText text) {
    validateText(text);
    return contentAppendHelper(text);
  }

  @Override
  public Void visitParagraph(Paragraph text) {
    validateText(text);
    return contentAppendHelper(text);
  }

  @Override
  public Void visitHyperText(HyperText text) {
    validateText(text);
    return contentAppendHelper(text);
  }

}
