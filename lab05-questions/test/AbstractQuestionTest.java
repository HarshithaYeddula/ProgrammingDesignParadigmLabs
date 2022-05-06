import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import org.junit.Test;
import questions.Likert;
import questions.MultipleChoice;
import questions.MultipleSelect;
import questions.Question;
import questions.TrueFalse;

/**
 * test Abstract Question tests the order sequence of different questions and
 * also order sequence for similar type questions.
 */

public class AbstractQuestionTest {

  /**
   * Testing Ordering of Questions and similar Type questions.
   */
  @Test
  public void testOrdering() {

    MultipleSelect multipleSelect1 = new MultipleSelect("Is harshitha coming back to boston", "1 2",
        "1. Yes", "2. MayBe", "3. No");
    MultipleSelect multipleSelect2 = new MultipleSelect("Is harshitha love Mr.", "1 2", "1. Yes",
        "2. MayBe", "3. No");
    MultipleSelect multipleSelect3 = new MultipleSelect("Friends of Harshitha?", "1 3 4",
        "1. Raghu", "2. Ujwala", "3. Bindu", "4. Senior");

    Likert likert1 = new Likert("Harshitha is a Good Girl and Harshitha is always dedicated");
    Likert likert2 = new Likert("Tim Cook is the founder of APPLE company");
    Likert likert3 = new Likert("Sundar Pichai is the current CEO of GOOGLE");

    MultipleChoice multipleChoice1 = new MultipleChoice("Where does Harshitha " + "Lives in?", "4",
        "1. INDIA", "2. JAPAN", "3. KOREA", "4. USA");
    MultipleChoice multipleChoice2 = new MultipleChoice("Harshitha is Daughter of?", "3",
        "1. Jyothi", "2. Murali", "3. Both A&B", "4. Lokesh");
    MultipleChoice multipleChoice3 = new MultipleChoice("Murali " + "wife is?", "2", "1. Lokesh",
        "2. Jyothi", "3. Rakshitha", "4. None");

    TrueFalse trueFalse1 = new TrueFalse("Harshitha is a Bad Girl", "False");
    TrueFalse trueFalse2 = new TrueFalse("Lokesh works at GoldmanSachs", "True");
    TrueFalse trueFalse3 = new TrueFalse("Jyothi is the mother of Harshitha and Deepu", "True");

    ArrayList<Question> arrayList = new ArrayList<Question>();
    arrayList.add(likert1);
    arrayList.add(likert2);
    arrayList.add(likert3);
    arrayList.add(multipleChoice1);
    arrayList.add(multipleChoice2);
    arrayList.add(multipleChoice3);
    arrayList.add(multipleSelect1);
    arrayList.add(multipleSelect2);
    arrayList.add(multipleSelect3);
    arrayList.add(trueFalse1);
    arrayList.add(trueFalse2);
    arrayList.add(trueFalse3);

    Collections.sort(arrayList);
    String expectedValue = "[TrueFalseQuestion\n" + "{\n" + "Question = Harshitha is a Bad Girl\n"
        + "CorrectAnswer = False\n" + "}, TrueFalseQuestion\n" + "{\n"
        + "Question = Jyothi is the mother of Harshitha and Deepu\n" + "CorrectAnswer = True\n"
        + "}, TrueFalseQuestion\n" + "{\n" + "Question = Lokesh works at GoldmanSachs\n"
        + "CorrectAnswer = True\n" + "}, MultipleChoiceQuestion\n" + "{\n"
        + "Question = Harshitha is Daughter of?\n" + "CorrectAnswer = 3\n"
        + "}, MultipleChoiceQuestion\n" + "{\n" + "Question = Murali wife is?\n"
        + "CorrectAnswer = 2\n" + "}, MultipleChoiceQuestion\n" + "{\n"
        + "Question = Where does Harshitha Lives in?\n" + "CorrectAnswer = 4\n"
        + "}, MultipleSelectionQuestion\n" + "{\n" + "Question = Friends of Harshitha?\n"
        + "CorrectAnswer = 1 3 4\n" + "}, MultipleSelectionQuestion\n" + "{\n"
        + "Question = Is harshitha coming back to boston\n" + "CorrectAnswer = 1 2\n"
        + "}, MultipleSelectionQuestion\n" + "{\n" + "Question = Is harshitha love Mr.\n"
        + "CorrectAnswer = 1 2\n" + "}, LikertQuestion\n" + "{\n"
        + "Question = Harshitha is a Good Girl and Harshitha is always dedicated\n"
        + "}, LikertQuestion\n" + "{\n" + "Question = Sundar Pichai is the current CEO of GOOGLE\n"
        + "}, LikertQuestion\n" + "{\n" + "Question = Tim Cook is the founder of APPLE company\n"
        + "}]";
    assertEquals(expectedValue, arrayList.toString());
  }

}
