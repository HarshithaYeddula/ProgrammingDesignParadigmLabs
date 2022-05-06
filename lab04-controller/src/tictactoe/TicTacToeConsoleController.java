package tictactoe;

import java.io.IOException;
import java.util.Scanner;

/**
 * This starter files is for students to implement a console controller for the
 * TicTacToe MVC assignment.
 */
public class TicTacToeConsoleController implements TicTacToeController {

  private final Appendable out;
  private final Scanner scan;

  /**
   * Constructor for the controller.
   * 
   * @param in  the source to read from
   * @param out the target to print to
   */
  public TicTacToeConsoleController(Readable in, Appendable out) {
    if (in == null || out == null) {
      throw new IllegalArgumentException("Readable and Appendable can't be null");
    }
    this.out = out;
    scan = new Scanner(in);
  }

  @Override
  public void playGame(TicTacToe m) {
    if (m == null) {
      throw new IllegalArgumentException("Model cannot be null");
    }
    try {
      boolean valid = true;
      out.append(String.format("%s\n", m.toString()));
      while (!m.isGameOver()) {

        if (valid) {
          out.append(String.format("Enter a move for %s:\n", m.getTurn()));
        }
        valid = false;
        int e1 = -2;

        String input1 = scan.next();
        int flag = 0;

        while (e1 == -2) {
          if ("q".equalsIgnoreCase(input1)) {
            out.append("Game quit! Ending game state:\n" + m.toString() + "\n");
            flag = 1;
            break;
          }

          try {
            e1 = Integer.parseInt(input1) - 1;
          } catch (NumberFormatException nfe) {
            out.append(String.format("Not a valid number: %s\n", input1));
            input1 = scan.next();
          }
        }

        if (flag == 1) {
          break;
        }

        int e2 = -2;
        String input2 = scan.next();
        while (e2 == -2) {
          if ("q".equalsIgnoreCase(input2)) {
            out.append("Game quit! Ending game state:\n" + m.toString() + "\n");
            flag = 1;
            break;
          }

          try {
            e2 = Integer.parseInt(input2) - 1;
          } catch (NumberFormatException nfe) {
            out.append(String.format("Not a valid number: %s\n", input2));
            input2 = scan.next();
          }
        }

        if (flag == 1) {
          break;
        }

        valid = true;
        try {
          m.move(e1, e2);
          out.append(String.format("%s\n", m.toString()));
        } catch (IllegalArgumentException illegalArgumentException) {
          out.append(String.format("Not a valid move: %s, %s\n", e1 + 1, e2 + 1));
          valid = false;
        }

        if (checkGameResult(m)) {
          break;
        }

      }
    } catch (IOException e) {
      throw new IllegalStateException("Append failed", e);
    }

  }

  private boolean checkGameResult(TicTacToe m) throws IOException {
    if (m.isGameOver()) {
      if (m.getWinner() != null) {
        out.append("Game is over! " + m.getWinner() + " wins.");
      } else {
        out.append("Game is over! Tie game.");
      }
      return true;
    } else {
      return false;
    }

  }

}
