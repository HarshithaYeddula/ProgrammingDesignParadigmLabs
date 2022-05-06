package document;

import document.elements.BasicText;
import document.elements.BoldText;
import document.elements.Heading;
import document.elements.HyperText;
import document.elements.ItalicText;
import document.elements.Paragraph;
import document.elements.TextElement;

/**
 * MarkdownStringVisitor helps in adding the individual string elements.
 */
public class MarkdownStringVisitor extends AbstractVisitor implements TextElementVisitor<Void> {

  @Override
  public Void visitBasicText(BasicText text) {
    validateText(text);
    return contentAppend(text.getText(), "\n", "", "");
  }

  @Override
  public Void visitBoldText(BoldText text) {
    validateText(text);
    return contentAppend(text.getText(), "\n", "**", "**");
  }

  @Override
  public Void visitHeading(Heading text) {
    validateText(text);
    return contentAppend(text.getText(),
            "\n",
            "#".repeat(text.getLevel()) + " ",
            "");
  }

  @Override
  public Void visitItalicText(ItalicText text) {
    validateText(text);
    return contentAppend(text.getText(), "\n", "*", "*");
  }

  @Override
  public Void visitParagraph(Paragraph text) {
    validateText(text);
    TextElementVisitor<Void> markdownVisitor = new MarkdownStringVisitor();
    for (TextElement element : text.getContent()) {
      element.accept(markdownVisitor);
    }
    return contentAppend(markdownVisitor.toString(), "\n", "\n", "");
  }

  @Override
  public Void visitHyperText(HyperText text) {
    validateText(text);
    return contentAppend(text.getText(), "\n", "[", "](" + text.getUrl() + ")");
  }
}
