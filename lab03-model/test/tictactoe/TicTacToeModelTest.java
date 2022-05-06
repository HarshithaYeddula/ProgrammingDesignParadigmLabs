package tictactoe;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.stream.Collectors;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for TicTacToeModel Implementation.
 * @author mail2
 *
 */
public class TicTacToeModelTest {

  private Player[][] board;
  private TicTacToe model;

  @Before
  public void setUp() {
    board = new Player[3][3];
    model = new TicTacToeModel();
  }

  /**
   * Testing move to an invalid location.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGetMoveWithImproperColumns() {
    model.move(1, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetMoveWithNegativeColumns() {
    model.move(1, -1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetMoveWithImproperRows() {
    model.move(3, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetMoveWithNegativeRows() {
    model.move(-1, 1);
  }

  /**
   * test move to a location which is already occupied.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGetMoveWhenPositionOccupied() {
    model.move(1, 1);
    model.move(1, 1);
  }

  /**
   * Check move method and check no other location was changed.
   */
  @Test
  public void testGetMove() {
    model.move(1, 1);
    assertEquals(null, model.getMarkAt(0, 0));
    assertEquals(null, model.getMarkAt(0, 1));
    assertEquals(null, model.getMarkAt(0, 2));
    assertEquals(null, model.getMarkAt(1, 0));
    assertEquals(null, model.getMarkAt(1, 2));
    assertEquals(null, model.getMarkAt(2, 0));
    assertEquals(null, model.getMarkAt(2, 1));
    assertEquals(null, model.getMarkAt(2, 2));
  }

  /**
   * Check move method after the game is over.
   */
  @Test(expected = IllegalStateException.class)
  public void testGetMoveAfterTheGameIsOver() {
    model.move(0, 0);
    model.move(0, 2);
    model.move(1, 0);
    model.move(1, 2);
    model.move(2, 0);
    model.move(2, 2);
  }

  /**
   * Check game is over.
   */
  @Test
  public void testIsGameover() {
    model.move(0, 0);
    model.move(0, 2);
    model.move(1, 0);
    model.move(1, 2);
    model.move(2, 0);
    assertEquals(true, model.isGameOver());
  }

  /**
   * Check game is not over.
   */
  @Test
  public void testIsGameNotover() {
    model.move(0, 0);
    model.move(0, 2);
    model.move(1, 0);
    model.move(1, 2);
    assertEquals(false, model.isGameOver());
  }

  /**
   * Check who addressed a specified position.
   */
  @Test
  public void getMarkAt() {
    model.move(0, 0);
    model.move(0, 2);
    model.move(1, 0);
    model.move(1, 2);
    assertEquals(Player.O, model.getMarkAt(0, 2));
  }

  /**
   * Testing getMark to an invalid location.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testgetMarkAtWithImproperColumns() {
    model.getMarkAt(1, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testgetMarkAtWithNegativeColumns() {
    model.getMarkAt(1, -1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testgetMarkAtWithImproperRows() {
    model.getMarkAt(3, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testgetMarkAtWithNegativeRows() {
    model.getMarkAt(-1, 1);
  }

  /**
   * Check whose turn it is after a move.
   */
  @Test
  public void testGetTurnAfteraMove() {
    model.move(1, 1);
    assertEquals(Player.O, model.getTurn());

  }

  /**
   * Check if game starts with X.
   */
  @Test
  public void testGetTurn() {
    model.getTurn();
    assertEquals(Player.X, model.getTurn());
  }

  /**
   * Check vertical Win.
   */
  @Test
  public void testVerticalWinner() {
    model.move(0, 0);
    model.move(0, 2);
    model.move(1, 0);
    model.move(1, 2);
    model.move(2, 0);
    assertEquals(Player.X, model.getWinner());
  }

  /**
   * Check Horizontal Win.
   */
  @Test
  public void testHorizontalWinner() {
    model.move(0, 0);
    model.move(2, 0);
    model.move(0, 1);
    model.move(2, 1);
    model.move(0, 2);
    assertEquals(Player.X, model.getWinner());
  }

  /**
   * Check Diaganol Win.
   */
  @Test
  public void testDiaganolWinner() {
    model.move(0, 0);
    model.move(2, 0);
    model.move(1, 1);
    model.move(2, 1);
    model.move(2, 2);
    assertEquals(Player.X, model.getWinner());
  }

  /**
   * Check Game Tie.
   */
  @Test(expected = IllegalStateException.class)
  public void testGameTie() {
    model.move(0, 0);
    model.move(2, 2);
    model.move(2, 0);
    model.move(1, 0);
    model.move(0, 2);
    model.move(0, 1);
    model.move(1, 2);
    model.move(1, 1);
    model.move(2, 1);
    assertEquals(null, model.getWinner());
    assertEquals(true, model.isGameOver());
    model.move(2, 2);
  }

  /**
   * Check Game Board.
   */
  @Test
  public void testgetBoard() {
    model.move(0, 0);
    model.move(2, 0);
    model.move(1, 1);
    model.move(2, 1);
    model.move(2, 2);
    model.getBoard();
    Player[][] dummyBoard = new Player[3][3];
    dummyBoard[0][0] = Player.X;
    dummyBoard[2][0] = Player.O;
    dummyBoard[1][1] = Player.X;
    dummyBoard[2][1] = Player.O;
    dummyBoard[2][2] = Player.X;
    assertEquals(
        Arrays.stream(dummyBoard)
            .map(row -> " " + Arrays.stream(row).map(p -> p == null ? " " : p.toString())
                .collect(Collectors.joining(" | ")))
            .collect(Collectors.joining("\n-----------\n")),
        Arrays.stream(model.getBoard())
            .map(row -> " " + Arrays.stream(row).map(p -> p == null ? " " : p.toString())
                .collect(Collectors.joining(" | ")))
            .collect(Collectors.joining("\n-----------\n")));
  }

}
