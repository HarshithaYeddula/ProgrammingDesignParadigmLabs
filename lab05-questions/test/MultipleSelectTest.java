import static org.junit.Assert.assertEquals;

import org.junit.Test;
import questions.AbstractQuestion;
import questions.MultipleSelect;
import questions.Question;

/**
 * Test class for MultipleSelect implementation.
 * 
 * @author Harshitha
 *
 */
public class MultipleSelectTest {

  protected MultipleSelect multipleSelect(String multipleSelectQuestion, String answer,
      String... options) {
    return new MultipleSelect(multipleSelectQuestion, answer, options);
  }

  /**
   * Multiple Select Invalid Question.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIfInValidMultipleChoiceQuestions1() {
    multipleSelect(null, "1");
  }

  /**
   * Multiple Select valid Question with Invalid Answer.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIfInValidMultipleChoiceQuestions2() {
    multipleSelect("Select the US City", null);
  }

  /**
   * Verify MultipleSelect implementation when provided answer is valid and is
   * equal to the correct answer.
   */
  @Test
  public void testMultipleSelectQuestionWhenProvidedAnswerIsValidAndCorrect() {
    Question q = new MultipleSelect("Is harshitha coming back to boston", "1 2", "1. Yes",
        "2. MayBe", "3. No");
    assertEquals(AbstractQuestion.CORRECT, q.answer("1 2"));
  }

  /**
   * Verify MultipleSelect implementation when provided answer null.
   */
  @Test
  public void testMultipleSelectQuestionWhenProvidedAnswerIsNull() {
    Question q = new MultipleSelect("Is harshitha coming back to boston", "2", "1", "2", "3");
    assertEquals(AbstractQuestion.INCORRECT, q.answer(null));
  }

  /**
   * Verify MultipleSelect implementation when provided answer is empty.
   */
  @Test
  public void testMultipleSelectQuestionWhenProvidedAnswerIsEmpty() {
    Question q = new MultipleSelect("Is harshitha coming back to boston", "2", "1", "2", "3");
    assertEquals(AbstractQuestion.INCORRECT, q.answer(""));
  }

  /**
   * Verify MultipleSelect implementation when provided answer is valid but not
   * correct.
   */
  @Test
  public void testMultipleSelectQuestionWhenProvidedAnswerIsValidButIncorrect() {
    Question q = new MultipleSelect("Is harshitha coming back to boston", "2", "1. Yes", "2. MayBe",
        "3. No");
    assertEquals(AbstractQuestion.INCORRECT, q.answer("1 4"));
  }

}