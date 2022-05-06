package questions;

/**
 * This class represents a TrueFalse Question that implements all the
 * functionalities provided in the Question interface.
 * 
 * @author Harshitha
 *
 */
public class TrueFalse extends AbstractQuestion {

  private final String correctAnswer;
  private final String question;
  
  /**
   * Constructs an object of type TrueFalse.
   * 
   * @param question         Question
   * @param correctAnswer    Correct Answer
   */
  public TrueFalse(String question, String correctAnswer) {
    super(question);
    if (correctAnswer == null || correctAnswer.length() == 0) {
      throw new IllegalArgumentException("Correct Answer cannot be null or empty!");
    }
    if (!"true".equalsIgnoreCase(correctAnswer) && !"false".equalsIgnoreCase(correctAnswer)) {
      throw new IllegalArgumentException(
          "Only True/False can be accpted as valid answers for the TRueFalse Questions");
    }
    this.question = question;
    this.correctAnswer = correctAnswer;
  }

  @Override
  public String answer(String answer) {
    if (this.correctAnswer.equalsIgnoreCase(answer)) {
      return AbstractQuestion.CORRECT;
    } else {
      return AbstractQuestion.INCORRECT;
    }
  }

  @Override
  public int compareToLikertQuestion(Question that) {
    return 1;
  }

  @Override
  public int compareToTrueFalseQuestion(Question that) {
    return that.getText().compareTo(this.getText());
  }

  @Override
  public int compareToMultipleChoiceQuestion(Question that) {
    return 1;
  }

  @Override 
  public int compareToMultipleSelectQuestion(Question that) {
    return 1;
  }
  
  @Override
  public int compareTo(Question o) {
    if (o instanceof AbstractQuestion) {
      AbstractQuestion abstractQuestion = (AbstractQuestion) o;
      return abstractQuestion.compareToTrueFalseQuestion(this);
    }
    return 0;
  }

  @Override
  public String toString() {
    return String.format("TrueFalseQuestion\n{\nQuestion = %s\nCorrectAnswer = %s\n}",
        this.question, this.correctAnswer);
  }

}
