package document;

import document.elements.BasicText;
import document.elements.Paragraph;
import document.elements.TextElement;

/**
 * AbstractVisitor is common class that orovides a method to append as well as
 * for tostring with the content.
 */
public abstract class AbstractVisitor implements TextElementVisitor<Void> {
  private String content;

  /**
   * Constructs the AbstractVisitor by assigning the content.
   */
  public AbstractVisitor() {
    this.content = "";
  }

  protected Void contentAppend(String text, String separator, String startTag,
                               String endTag) {
    if (!("").equals(this.content)) {
      this.content = this.content + separator + startTag + text + endTag;
    } else {
      this.content = startTag + text + endTag;
    }
    return null;
  }

  @Override
  public String toString() {
    return content;
  }
  
  protected Void contentAppendHelper(TextElement element) {
    return contentAppend(element.getText(), " ", "", "");
  }
  
  protected void validateText(Paragraph text) {
    if (text == null) {
      throw new IllegalArgumentException("Text cannot be null!!!");
    }

  }

  protected void validateText(BasicText text) {
    if (text == null) {
      throw new IllegalArgumentException("Text cannot be null!!!");
    }

  }
}
