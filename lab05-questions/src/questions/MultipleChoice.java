package questions;

/**
 * This class represents a MultipleChoice Question that implements all the
 * functionalities provided in the Question interface.
 * 
 * @author Harshitha
 *
 */
public class MultipleChoice extends MultipleSelect {
  
  /**
   * Constructs an object of type MultipleChoice.
   * 
   * @param question      Question
   * @param correctAnswer Correct Answer
   * @param options       Available options
   */
  public MultipleChoice(String question, String correctAnswer, String... options) {
    super(question, correctAnswer, options);
  }

  @Override
  public String answer(String answer) {
    if (answer == null || "".equals(answer)) {
      return AbstractQuestion.INCORRECT;
    } else if (this.correctAnswer.equals(answer)) {
      return AbstractQuestion.CORRECT;
    }
    return AbstractQuestion.INCORRECT;
  }

  @Override
  public int compareToLikertQuestion(Question that) {
    return 1;
  }

  @Override
  public int compareToTrueFalseQuestion(Question that) {
    return -1;
  }

  @Override
  public int compareToMultipleChoiceQuestion(Question that) {
    return that.getText().compareTo(this.getText());
  }

  @Override
  public int compareToMultipleSelectQuestion(Question that) {
    return 1;
  }

  @Override
  public int compareTo(Question o) {
    if (o instanceof AbstractQuestion) {
      AbstractQuestion abstractQuestion = (AbstractQuestion) o;
      return abstractQuestion.compareToMultipleChoiceQuestion(this);
    }
    return 0;
  }

  @Override
  public String toString() {
    return String.format("MultipleChoiceQuestion\n{\nQuestion = %s\nCorrectAnswer = %s\n}",
        this.question, this.correctAnswer);
  }

}
