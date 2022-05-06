import static org.junit.Assert.assertEquals;

import org.junit.Test;
import questions.Likert;
import questions.Question;

/**
 * Likert Implementation Test.
 * 
 * @author Harshitha
 *
 */
public class LikertTest {

  protected Likert likertItem(String likertQuestion) {
    return new Likert(likertQuestion);
  }

  /**
   * Testing Invalid Question null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIfInValidMultipleChoiceQuestions1() {
    likertItem(null);
  }

  /**
   * Testing Invalid Question.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIfInValidMultipleChoiceQuestions2() {
    likertItem(" ");
  }

  /**
   * Testing Invalid Question.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIfInValidMultipleChoiceQuestions3() {
    likertItem("");
  }

  /**
   * Testing Valid Question along with Correct Answers..
   */
  @Test
  public void correctAnswers() {
    Question q1 = likertItem("PDP course provides great knowledge");
    assertEquals("Correct", q1.answer("5"));
    assertEquals("Correct", q1.answer("1"));
    assertEquals("Correct", q1.answer("3"));
  }

  /**
   * Testing Valid Question along with InCorrect Answers..
   */
  @Test
  public void inCorrectAnswers() {
    Question q1 = likertItem("PDP course provides great knowledge");
    assertEquals("Incorrect", q1.answer("0"));
    assertEquals("Incorrect", q1.answer("6"));
    assertEquals("Incorrect", q1.answer("-10"));
  }

}
