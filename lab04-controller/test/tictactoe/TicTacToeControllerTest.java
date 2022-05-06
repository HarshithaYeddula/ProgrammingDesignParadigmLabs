package tictactoe;

import static org.junit.Assert.assertEquals;

import java.io.StringReader;
import org.junit.Test;

/**
 * Test class for TicTacToeConsoleController Implementation.
 * @author mail2
 *
 */
public class TicTacToeControllerTest {

  @Test(expected = IllegalStateException.class)
  public void testFailingAppendable() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("2 2 1 1 3 3 1 2 1 3 2 3 2 1 3 1 3 2");
    Appendable gameLog = new FailingAppendable();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
  }

  /**
   * If model is Invalid.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testControllerIfModelIsInvalid() {
    StringReader input = new StringReader("2 2");
    Appendable gameLog = new FailingAppendable();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(null);
  }

  /**
   * test invalid row.
   */
  @Test
  public void testControllerForInvalidRow() {
    StringReader input = new StringReader("One 1 1 1 2 2 2 1 3 1 1 3 1 2 3 2 2 3 3 3 1");
    Appendable gameLog = new StringBuilder();
    TicTacToe model = new TicTacToeModel();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(model);
    String expected = " X | O | O\n" + "-----------\n" + "   | X | O\n" + "-----------\n"
        + " X |   | X";
    assertEquals(expected, model.toString());
  }

  /**
   * test invalid column.
   */
  @Test
  public void testControllerForInvalidColumn() {
    StringReader input = new StringReader("1 One 1 1 2 2 2 1 3 1 1 3 1 2 3 2 2 3 3 3 1");
    Appendable gameLog = new StringBuilder();
    TicTacToe model = new TicTacToeModel();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(model);
    String expected = " X | O | O\n" + "-----------\n" + "   | X | O\n" + "-----------\n"
        + " X |   | X";
    assertEquals(expected, model.toString());
  }

  /**
   * Row value as q.
   */
  @Test
  public void testControllerForRowAsQ() {
    StringReader input = new StringReader("1 1 q 1 2 2 2 1 3 1 1 3 1 2 3 2 2 3 3 3 1");
    Appendable gameLog = new StringBuilder();
    TicTacToe model = new TicTacToeModel();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(model);
    String expected = " X |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  ";
    assertEquals(expected, model.toString());
  }
  
  /**
   * Column value as q.
   */
  @Test
  public void testControllerForColumnAsQ() {
    StringReader input = new StringReader("1 1 1 q 2 2 2 1 3 1 1 3 1 2 3 2 2 3 3 3 1");
    Appendable gameLog = new StringBuilder();
    TicTacToe model = new TicTacToeModel();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(model);
    String expected = " X |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  ";
    assertEquals(expected, model.toString());
  }

  /**
   * Test valid move.
   */
  @Test
  public void testValidMove() {

    TicTacToe model = new TicTacToeModel();
    StringReader input = new StringReader("1 1 2 2 2 1 3 1 1 3 1 2 3 2 2 3 3 3");
    Appendable gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(model);
    String expectedOutput = "   |   |  \n" + "-----------\n" + "   |   |  \n" + "-----------\n"
        + "   |   |  \n" + "Enter a move for X:\n" + " X |   |  \n" + "-----------\n"
        + "   |   |  \n" + "-----------\n" + "   |   |  \n" + "Enter a move for O:\n"
        + " X |   |  \n" + "-----------\n" + "   | O |  \n" + "-----------\n" + "   |   |  \n"
        + "Enter a move for X:\n" + " X |   |  \n" + "-----------\n" + " X | O |  \n"
        + "-----------\n" + "   |   |  \n" + "Enter a move for O:\n" + " X |   |  \n"
        + "-----------\n" + " X | O |  \n" + "-----------\n" + " O |   |  \n"
        + "Enter a move for X:\n" + " X |   | X\n" + "-----------\n" + " X | O |  \n"
        + "-----------\n" + " O |   |  \n" + "Enter a move for O:\n" + " X | O | X\n"
        + "-----------\n" + " X | O |  \n" + "-----------\n" + " O |   |  \n"
        + "Enter a move for X:\n" + " X | O | X\n" + "-----------\n" + " X | O |  \n"
        + "-----------\n" + " O | X |  \n" + "Enter a move for O:\n" + " X | O | X\n"
        + "-----------\n" + " X | O | O\n" + "-----------\n" + " O | X |  \n"
        + "Enter a move for X:\n" + " X | O | X\n" + "-----------\n" + " X | O | O\n"
        + "-----------\n" + " O | X | X\n" + "Game is over! Tie game.";
    assertEquals(expectedOutput, gameLog.toString());
  }
  
  /**
   * occupied space.
   */
  @Test
  public void testWhenSpaceIsOccupied() {

    TicTacToe model = new TicTacToeModel();
    StringReader input = new StringReader("1 1 1 1 2 2 2 1 3 1 1 3 1 2 3 2 2 3 3 3");
    Appendable gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(model);
    String expectedOutput = "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "Enter a move for X:\n"
        + " X |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "Enter a move for O:\n"
        + "Not a valid move: 1, 1\n"
        + " X |   |  \n"
        + "-----------\n"
        + "   | O |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "Enter a move for X:\n"
        + " X |   |  \n"
        + "-----------\n"
        + " X | O |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "Enter a move for O:\n"
        + " X |   |  \n"
        + "-----------\n"
        + " X | O |  \n"
        + "-----------\n"
        + " O |   |  \n"
        + "Enter a move for X:\n"
        + " X |   | X\n"
        + "-----------\n"
        + " X | O |  \n"
        + "-----------\n"
        + " O |   |  \n"
        + "Enter a move for O:\n"
        + " X | O | X\n"
        + "-----------\n"
        + " X | O |  \n"
        + "-----------\n"
        + " O |   |  \n"
        + "Enter a move for X:\n"
        + " X | O | X\n"
        + "-----------\n"
        + " X | O |  \n"
        + "-----------\n"
        + " O | X |  \n"
        + "Enter a move for O:\n"
        + " X | O | X\n"
        + "-----------\n"
        + " X | O | O\n"
        + "-----------\n"
        + " O | X |  \n"
        + "Enter a move for X:\n"
        + " X | O | X\n"
        + "-----------\n"
        + " X | O | O\n"
        + "-----------\n"
        + " O | X | X\n"
        + "Game is over! Tie game.";
    assertEquals(expectedOutput, gameLog.toString());
  }

  /**
   * Invalid move.
   */
  @Test
  public void testControllerInvalidMove() {
    TicTacToe model = new TicTacToeModel();
    StringReader input = new StringReader("10 10 1 1 2 2 2 1 3 1 1 3 1 2 3 2 2 3 3 3");
    Appendable gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(model);
    String expectedOutput = "   |   |  \n" + "-----------\n" + "   |   |  \n" + "-----------\n"
        + "   |   |  \n" + "Enter a move for X:\n" + "Not a valid move: 10, 10\n" + " X |   |  \n"
        + "-----------\n" + "   |   |  \n" + "-----------\n" + "   |   |  \n"
        + "Enter a move for O:\n" + " X |   |  \n" + "-----------\n" + "   | O |  \n"
        + "-----------\n" + "   |   |  \n" + "Enter a move for X:\n" + " X |   |  \n"
        + "-----------\n" + " X | O |  \n" + "-----------\n" + "   |   |  \n"
        + "Enter a move for O:\n" + " X |   |  \n" + "-----------\n" + " X | O |  \n"
        + "-----------\n" + " O |   |  \n" + "Enter a move for X:\n" + " X |   | X\n"
        + "-----------\n" + " X | O |  \n" + "-----------\n" + " O |   |  \n"
        + "Enter a move for O:\n" + " X | O | X\n" + "-----------\n" + " X | O |  \n"
        + "-----------\n" + " O |   |  \n" + "Enter a move for X:\n" + " X | O | X\n"
        + "-----------\n" + " X | O |  \n" + "-----------\n" + " O | X |  \n"
        + "Enter a move for O:\n" + " X | O | X\n" + "-----------\n" + " X | O | O\n"
        + "-----------\n" + " O | X |  \n" + "Enter a move for X:\n" + " X | O | X\n"
        + "-----------\n" + " X | O | O\n" + "-----------\n" + " O | X | X\n"
        + "Game is over! Tie game.";
    assertEquals(expectedOutput, gameLog.toString());
  }
  
  /**
   * X WINS.
   */
  @Test
  public void testXwin() {
    TicTacToe model = new TicTacToeModel();
    StringReader input = new StringReader("1 1 1 2 2 2 2 3 3 3");
    Appendable gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(model);
    String expectedOutput = "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "Enter a move for X:\n"
        + " X |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "Enter a move for O:\n"
        + " X | O |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "Enter a move for X:\n"
        + " X | O |  \n"
        + "-----------\n"
        + "   | X |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "Enter a move for O:\n"
        + " X | O |  \n"
        + "-----------\n"
        + "   | X | O\n"
        + "-----------\n"
        + "   |   |  \n"
        + "Enter a move for X:\n"
        + " X | O |  \n"
        + "-----------\n"
        + "   | X | O\n"
        + "-----------\n"
        + "   |   | X\n"
        + "Game is over! X wins.";
    assertEquals(expectedOutput, gameLog.toString());
  }
  
  /**
   * O WINS.
   */
  @Test
  public void testOwin() {
    TicTacToe model = new TicTacToeModel();
    StringReader input = new StringReader("1 1 1 3 2 1 2 3 3 2 3 3");
    Appendable gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(model);
    String expectedOutput = "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "Enter a move for X:\n"
        + " X |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "Enter a move for O:\n"
        + " X |   | O\n"
        + "-----------\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "Enter a move for X:\n"
        + " X |   | O\n"
        + "-----------\n"
        + " X |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "Enter a move for O:\n"
        + " X |   | O\n"
        + "-----------\n"
        + " X |   | O\n"
        + "-----------\n"
        + "   |   |  \n"
        + "Enter a move for X:\n"
        + " X |   | O\n"
        + "-----------\n"
        + " X |   | O\n"
        + "-----------\n"
        + "   | X |  \n"
        + "Enter a move for O:\n"
        + " X |   | O\n"
        + "-----------\n"
        + " X |   | O\n"
        + "-----------\n"
        + "   | X | O\n"
        + "Game is over! O wins.";
    assertEquals(expectedOutput, gameLog.toString());
  }
  
  /**
   * Tie Game.
   */
  @Test
  public void testTieGame() {
    TicTacToe model = new TicTacToeModel();
    StringReader input = new StringReader("3 1 3 2 3 3 2 2 1 2 2 3 2 1 1 1 1 3");
    Appendable gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(model);
    String expectedOutput = "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "Enter a move for X:\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "-----------\n"
        + " X |   |  \n"
        + "Enter a move for O:\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "-----------\n"
        + " X | O |  \n"
        + "Enter a move for X:\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "-----------\n"
        + " X | O | X\n"
        + "Enter a move for O:\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   | O |  \n"
        + "-----------\n"
        + " X | O | X\n"
        + "Enter a move for X:\n"
        + "   | X |  \n"
        + "-----------\n"
        + "   | O |  \n"
        + "-----------\n"
        + " X | O | X\n"
        + "Enter a move for O:\n"
        + "   | X |  \n"
        + "-----------\n"
        + "   | O | O\n"
        + "-----------\n"
        + " X | O | X\n"
        + "Enter a move for X:\n"
        + "   | X |  \n"
        + "-----------\n"
        + " X | O | O\n"
        + "-----------\n"
        + " X | O | X\n"
        + "Enter a move for O:\n"
        + " O | X |  \n"
        + "-----------\n"
        + " X | O | O\n"
        + "-----------\n"
        + " X | O | X\n"
        + "Enter a move for X:\n"
        + " O | X | X\n"
        + "-----------\n"
        + " X | O | O\n"
        + "-----------\n"
        + " X | O | X\n"
        + "Game is over! Tie game.";
    assertEquals(expectedOutput, gameLog.toString());
  }
  
  /**
   * Row out of Bounds.
   */
  @Test
  public void testRowOutOfBounds() {
    TicTacToe model = new TicTacToeModel();
    StringReader input = new StringReader("10 1 1 1 1 2 2 2 2 3 3 3");
    Appendable gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(model);
    String expectedOutput = "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "Enter a move for X:\n"
        + "Not a valid move: 10, 1\n"
        + " X |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "Enter a move for O:\n"
        + " X | O |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "Enter a move for X:\n"
        + " X | O |  \n"
        + "-----------\n"
        + "   | X |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "Enter a move for O:\n"
        + " X | O |  \n"
        + "-----------\n"
        + "   | X | O\n"
        + "-----------\n"
        + "   |   |  \n"
        + "Enter a move for X:\n"
        + " X | O |  \n"
        + "-----------\n"
        + "   | X | O\n"
        + "-----------\n"
        + "   |   | X\n"
        + "Game is over! X wins.";
    assertEquals(expectedOutput, gameLog.toString());
  }
  
  /**
   * Column out of Bounds.
   */
  @Test
  public void testColumnOutOfBounds() {
    TicTacToe model = new TicTacToeModel();
    StringReader input = new StringReader("1 10 1 1 1 2 2 2 2 3 3 3");
    Appendable gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(model);
    String expectedOutput = "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "Enter a move for X:\n"
        + "Not a valid move: 1, 10\n"
        + " X |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "Enter a move for O:\n"
        + " X | O |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "Enter a move for X:\n"
        + " X | O |  \n"
        + "-----------\n"
        + "   | X |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "Enter a move for O:\n"
        + " X | O |  \n"
        + "-----------\n"
        + "   | X | O\n"
        + "-----------\n"
        + "   |   |  \n"
        + "Enter a move for X:\n"
        + " X | O |  \n"
        + "-----------\n"
        + "   | X | O\n"
        + "-----------\n"
        + "   |   | X\n"
        + "Game is over! X wins.";
    assertEquals(expectedOutput, gameLog.toString());
  }
}
