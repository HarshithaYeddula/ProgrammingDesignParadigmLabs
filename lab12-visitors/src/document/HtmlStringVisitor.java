package document;

import document.elements.BasicText;
import document.elements.BoldText;
import document.elements.Heading;
import document.elements.HyperText;
import document.elements.ItalicText;
import document.elements.Paragraph;
import document.elements.TextElement;

/**
 * HtmlStringVisitor helps in adding the individual string elements.
 */
public class HtmlStringVisitor extends AbstractVisitor implements TextElementVisitor<Void> {

  @Override
  public Void visitBasicText(BasicText text) {
    validateText(text);
    return contentAppend(text.getText(), "\n", "", "");
  }

  @Override
  public Void visitBoldText(BoldText text) {
    validateText(text);
    return contentAppend(text.getText(), "\n", "<b>", "</b>");
  }

  @Override
  public Void visitHeading(Heading text) {
    validateText(text);
    return contentAppend(text.getText(),
            "\n",
            "<h" + text.getLevel() + ">",
            "</h" + text.getLevel() + ">");
  }

  @Override
  public Void visitItalicText(ItalicText text) {
    validateText(text);
    return contentAppend(text.getText(), "\n", "<i>", "</i>");
  }

  @Override
  public Void visitParagraph(Paragraph text) {
    validateText(text);
    TextElementVisitor<Void> htmlVisitor = new HtmlStringVisitor();
    for (TextElement element : text.getContent()) {
      element.accept(htmlVisitor);
    }
    return contentAppend(htmlVisitor.toString(), "\n", "<p>", "\n</p>");
  }

  @Override
  public Void visitHyperText(HyperText text) {
    validateText(text);
    return contentAppend(text.getText(), "\n", "<a href=\"" + text.getUrl() + "\">", "</a>");
  }
}
