package questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * This class represents a MultipleSelect Question that implements all the
 * functionalities provided in the Question interface.
 * 
 * @author Harshitha
 *
 */
public class MultipleSelect extends AbstractQuestion {

  protected final String correctAnswer;
  private final List<String> optionsList = new ArrayList<String>();

  /**
   * Constructs a MultipleSelect Object.
   * 
   * @param question         Question
   * @param correctAnswer    correct answer
   * @param availableOptions available options
   */
  public MultipleSelect(String question, String correctAnswer, String... availableOptions) {
    super(question);
    if (availableOptions.length < 3 || availableOptions.length > 8) {
      throw new IllegalArgumentException("Minimum Number of options are 3 and Maximum are 8!");
    } else if (correctAnswer == null || correctAnswer.length() == 0) {
      throw new IllegalArgumentException("Answer cannot be empty or Null!");
    }
    this.correctAnswer = correctAnswer;
    String[] in = correctAnswer.split(" ");
    int[] optionsOfCorrectAnswer = new int[in.length];
    for (int i = 0; i < in.length; i++) {
      optionsOfCorrectAnswer[i] = Integer.parseInt(in[i]);
      if (optionsOfCorrectAnswer[i] <= 0) {
        throw new IllegalArgumentException("Number of Options selected cannot be Negative!");
      }
    }
    optionsList.addAll(Arrays.asList(availableOptions));
  }

  @Override
  public String answer(String answer) {
    if (answer == null || "".equals(answer)) {
      return AbstractQuestion.INCORRECT;
    }
    List<Integer> actualAnswersList = getOptionsFromString(this.correctAnswer);
    List<Integer> userAnswersList = getOptionsFromString(answer);
    if (actualAnswersList.equals(userAnswersList)) {
      return CORRECT;
    } else {
      return INCORRECT;
    }
  }

  /**
   * Reads each option selected from the list of options.
   * 
   * @param answer Answer
   * @return List of Integers
   */
  private List<Integer> getOptionsFromString(String answer) {
    String[] ans = answer.split(" ");
    List<Integer> answerNumbers = new ArrayList<>();
    for (String a : ans) {
      try {
        answerNumbers.add(Integer.parseInt(a));
      } catch (NumberFormatException nfe) {
        throw new NumberFormatException(String.format("Cannot convert % to number", a));
      }
    }
    Collections.sort(answerNumbers);
    return answerNumbers;

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
    return -1;
  }

  @Override
  public int compareToMultipleSelectQuestion(Question that) {
    return that.getText().compareTo(this.getText());
  }

  @Override
  public int compareTo(Question o) {
    if (o instanceof AbstractQuestion) {
      AbstractQuestion abstractQuestion = (AbstractQuestion) o;
      return abstractQuestion.compareToMultipleSelectQuestion(this);
    }
    return 0;
  }

  @Override
  public String toString() {
    return String.format("MultipleSelectionQuestion\n{\nQuestion = %s\nCorrectAnswer = %s\n}",
        this.question, this.correctAnswer);
  }

}
