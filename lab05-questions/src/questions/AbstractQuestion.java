package questions;

/**
 * An abstract class that contains all of the code that is shared by all types
 * of Questions.
 * 
 * @author Harshitha
 *
 */
public abstract class AbstractQuestion implements Question {

  protected String question;

  /**
   * Constructs an object of type AbstractQuestion.
   * @param question    Question
   */
  public AbstractQuestion(String question) {
    if (question == null || "".equals(question) || " ".equals(question)) {
      throw new IllegalArgumentException("Question cannot be blank or Null");
    }
    this.question = question;
  }
  
  @Override
  public String getText() {
    return this.question; 
  }

  /**
   * Determine whether this Question is equal to a Likert object.
   *
   * @param other the Question object to which this shape must be compared
   * @return -1 by default, subclasses may override
   */
  protected int compareToLikertQuestion(Question that) {
    return -1;
  }

  /**
   * Determine whether this Question is equal to a TrueFalse object.
   *
   * @param other the Question object to which this shape must be compared
   * @return -1 by default, subclasses may override
   */

  protected int compareToTrueFalseQuestion(Question that) {
    return -1;
  }

  /**
   * Determine whether this Question is equal to a MultipleChoice object.
   *
   * @param other the Question object to which this shape must be compared
   * @return -1 by default, subclasses may override
   */

  protected int compareToMultipleChoiceQuestion(Question that) {
    return -1;
  }

  /**
   * Determine whether this Question is equal to a MultipleSelect object.
   *
   * @param other the Question object to which this shape must be compared
   * @return -1 by default, subclasses may override
   */

  protected int compareToMultipleSelectQuestion(Question that) {
    return -1;
  }

}
