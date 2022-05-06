import static org.junit.Assert.assertEquals;

import org.junit.Test;
import questions.AbstractQuestion;
import questions.Question;
import questions.TrueFalse;

/**
 * Test class for TrueFalse implementation.
 * 
 * @author Harshitha
 *
 */
public class TrueFalseTest {

  /**
   * true False Invalid Question.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIfInValidTrueFalseQuestions1() {
    trueFalseItem(null, "true");
  }

  /**
   * true False Invalid Answer.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIfInValidTrueFalseQuestions2() {
    trueFalseItem("Harshitha is a good girl", null);
  }

  /**
   * Verify TrueFalse implementation when provided answer is valid and is equal to
   * the correct answer.
   */
  @Test
  public void testTrueFalseQuestionWhenAnswerGivenIsValidAndCorrect() {
    Question q = new TrueFalse("Is PDP taking worth it?", "true");
    assertEquals(AbstractQuestion.CORRECT, q.answer("TRUE"));

  }

  /**
   * Verify TrueFalse implementation when provided answer is null.
   */
  @Test
  public void testTrueFalseQuestionWhenAnswerGivenIsNull() {
    Question q = new TrueFalse("Is PDP taking worth it?", "true");
    assertEquals(AbstractQuestion.INCORRECT, q.answer(null));

  }

  /**
   * Verify TrueFalse implementation when provided answer is Empty.
   */
  @Test
  public void testTrueFalseQuestionWhenAnswerGivenIsEmpty() {
    Question q = new TrueFalse("Is PDP taking worth it?", "true");
    assertEquals(AbstractQuestion.INCORRECT, q.answer(""));

  }

  /**
   * Verify TrueFalse implementation when provided answer is Invalid.
   */
  @Test
  public void testTrueFalseQuestionWhenAnswerGivenIsInvalid() {
    Question q = new TrueFalse("Is PDP taking worth it?", "true");
    assertEquals(AbstractQuestion.INCORRECT, q.answer("par"));

  }

  /**
   * Verify TrueFalse implementation when provided answer is Valid but wrong.
   */
  @Test
  public void testTrueFalseQuestionWhenAnswerGivenIsValidButWrong() {
    Question q = new TrueFalse("Is PDP taking worth it?", "true");
    assertEquals(AbstractQuestion.INCORRECT, q.answer("FALSE"));

  }

  protected TrueFalse trueFalseItem(String trueFalseQuestion, String correctAnswer) {
    return new TrueFalse(trueFalseQuestion, correctAnswer);
  }
}
