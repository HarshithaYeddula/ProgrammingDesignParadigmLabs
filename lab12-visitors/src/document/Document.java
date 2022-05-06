package document;

import document.elements.TextElement;
import document.elements.ValidateParameters;
import java.util.ArrayList;
import java.util.List;

/**
 * A class that represents a document. It contains a list of the elements of the
 * document in the order that they appear in the document. This class is
 * provided as a starting point for the Visitor lab in CS 5010.
 */
public class Document extends ValidateParameters {

  private List<TextElement> content;

  /** Default constructor initializes the fields of the class. */
  public Document() {
    content = new ArrayList<>();
  }

  /**
   * Add an element to the document. Elements are added in order.
   * 
   * @param e the element to add
   */
  public void add(TextElement e) {
    content.add(e);
  }

  /**
   * Word count of the document.
   *
   * @return words in the document as an Integer.
   */
  public int countWords() {
    TextElementVisitor<Integer> countVisitor = new WordCountVisitor();
    int count = 0;
    for (TextElement element : content) {
      count += element.accept(countVisitor);
    }
    return count;
  }

  /**
   * String values of the Text element.
   * 
   * @param visitor the string visitor
   * @return accumulated string value of the elements in the document
   * @throws IllegalArgumentException for invalid visitor
   */
  public String toText(TextElementVisitor<Void> visitor) throws IllegalArgumentException {
    validateVisitor(visitor);
    for (TextElement element : content) {
      element.accept(visitor);
    }
    return visitor.toString();
  }
}
