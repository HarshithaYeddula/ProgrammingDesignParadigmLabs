import static org.junit.Assert.assertEquals;

import org.junit.Test;
import questions.AbstractQuestion;
import questions.MultipleChoice;
import questions.Question;

/**
 * Test class for MultipleChoice implementation.
 * 
 * @author Harshitha
 *
 */
public class MultipleChoiceTest {

  /**
   * Verify MultipleChoice implementation when provided answer is valid and is
   * equal to the correct answer.
   */
  @Test
  public void testMultipleChoiceQuestionWhenProvidedAnswerIsValidAndCorrect() {
    Question q = new MultipleChoice("Is harshitha going to Raleigh?", "1", "1. Yes", "2. No",
        "3. Maybe");
    assertEquals(AbstractQuestion.CORRECT, q.answer("1"));
  }

  /**
   * Verify MultipleChoice implementation when provided answer null.
   */
  @Test
  public void testMultipleChoiceQuestionWhenProvidedAnswerIsNull() {
    Question q = new MultipleChoice("Is harshitha going to Raleigh?", "1", "1. Yes", "2. No",
        "3. Maybe");
    assertEquals(AbstractQuestion.INCORRECT, q.answer(null));
  }

  /**
   * Verify MultipleChoice implementation when provided answer empty.
   */
  @Test
  public void testMultipleChoiceQuestionWhenProvidedAnswerIsEmpty() {
    Question q = new MultipleChoice("Is harshitha going to Raleigh?", "1", "1. Yes", "2. No",
        "3. Maybe");
    assertEquals(AbstractQuestion.INCORRECT, q.answer(""));
  }

  /**
   * Verify MultipleChoice implementation when provided answer Invalid.
   */
  @Test
  public void testMultipleChoiceQuestionWhenProvidedAnswerIsInvalid() {
    Question q = new MultipleChoice("Is harshitha going to Raleigh?", "1", "1. Yes", "2. No",
        "3. Maybe");
    assertEquals(AbstractQuestion.INCORRECT, q.answer("par"));
  }

  /**
   * Verify MultipleChoice implementation when provided answer valid but not
   * correct.
   */
  @Test
  public void testMultipleChoiceQuestionWhenProvidedAnswerIsValidButNotCorrect() {
    Question q = new MultipleChoice("Is harshitha going to Raleigh?", "1", "1. Yes", "2. No",
        "3. Maybe");
    assertEquals(AbstractQuestion.INCORRECT, q.answer("4"));
  }

}
