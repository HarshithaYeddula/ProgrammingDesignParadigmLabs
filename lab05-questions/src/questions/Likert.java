package questions;

/**
 * This class represents a Likert Question that implements all the
 * functionalities provided in the Question interface.
 * 
 * @author mail2
 *
 */
public class Likert extends AbstractQuestion {

  /**
   * Constructs an object of type Likert Question.
   * @param question    Question
   */
  public Likert(String question) {
    super(question);
    this.question = question;
  }

  @Override
  public String answer(String answer) {
    if (answer == null || "".equals(answer)
        || (Integer.parseInt(answer) < 1 || Integer.parseInt(answer) > 5)) {
      return INCORRECT;
    } else {
      return AbstractQuestion.CORRECT;
    }

  }

  @Override
  public int compareToLikertQuestion(Question that) {
    return that.getText().compareTo(this.getText());
  }

  @Override
  public int compareToTrueFalseQuestion(Question that) {
    return -1;
  }

  @Override 
  public int compareToMultipleChoiceQuestion(Question that) {
    return -1;
  }

  @Override
  public int compareToMultipleSelectQuestion(Question that) {
    return -1;
  }

  @Override
  public int compareTo(Question o) {
    if (o instanceof AbstractQuestion) {
      AbstractQuestion abstractQuestion = (AbstractQuestion) o;
      return abstractQuestion.compareToLikertQuestion(this);
    }
    return 0;
  }

  @Override
  public String toString() {
    return String.format("LikertQuestion\n{\nQuestion = %s\n}", this.question);
  }

}
