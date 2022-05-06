 package tictactoe;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Represents a single game of Tic Tac Toe. Three in a row
 * down/across/diagonally to win; X goes first.
 */
public class TicTacToeModel implements TicTacToe {
  private final Player[][] board;
  private Player turn;

  /**
   * Default constructor.
   */
  public TicTacToeModel() {
    board = new Player[3][3];
    turn = Player.X;
  }

  @Override
  public void move(int row, int column) {
    if (isGameOver()) {
      throw new IllegalStateException("Game is over");
    }
    validate(row, column);
    if (board[row][column] != null) {
      throw new IllegalArgumentException("Position already occupiued");
    }
    board[row][column] = turn;
    turn = turn == Player.X ? Player.O : Player.X;
  }

  @Override
  public Player getTurn() {
    return turn;
  }

  @Override
  public boolean isGameOver() {
    boolean boardFull = true;
    for (Player[] row : board) {
      if (Arrays.stream(row).anyMatch(Objects::isNull)) {
        boardFull = false;
        break;
      }
    }
    return boardFull || getWinner() != null;
  }

  /**
   * Check if any player has won the game.
   * 
   * @return player who won the game or return null if no one has won yet
   */
  @Override
  public Player getWinner() {
    for (Player p : Player.values()) {
      for (Player[] row : board) {
        if (Arrays.stream(row).allMatch(m -> m == p)) {
          return p;
        }
      }

      for (int i = 0; i < board[0].length; i++) {
        if (board[0][i] == p && board[1][i] == p && board[2][i] == p) {
          return p;
        }
      }

      if (board[0][0] == p && board[1][1] == p && board[2][2] == p) {
        return p;
      }
      if (board[0][2] == p && board[1][1] == p && board[2][0] == p) {
        return p;
      }
    }
    return null;
  }

  @Override
  public Player[][] getBoard() {
    Player[][] player = new Player[3][3];
    for (int r = 0; r < board.length; r++) {
      player[r] = Arrays.copyOf(board[r], board[r].length);
    }
    return player;
  }

  @Override
  public Player getMarkAt(int row, int column) {
    validate(row, column);
    return board[row][column];
  }

  @Override
  public String toString() {
    return Arrays
        .stream(getBoard()).map(row -> " " + Arrays.stream(row)
            .map(p -> p == null ? " " : p.toString()).collect(Collectors.joining(" | ")))
        .collect(Collectors.joining("\n-----------\n"));
  }

  /**
   * Check if (row,column) is valid.
   * 
   * @param row    Integer value of the row
   * @param column Integer value of the column
   * @throws IllegalArgumentException if any one value is negative/greater than
   *                                  two
   */
  private void validate(int row, int column) {
    if (row < 0 || row > 2 || column < 0 || column > 2) {
      throw new IllegalArgumentException(
          String.format("Invalid board position: (%d,%d)", row, column));
    }
  }
}
