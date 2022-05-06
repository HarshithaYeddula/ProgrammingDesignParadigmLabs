package basicmvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Model;

/**
 * Implementation of the controller for the basic MVC.
 */
public class Controller implements ActionListener {
  private Model model;
  private View view;

  /**
   * Constructor.
   * 
   * @param m the model to use
   * @param v the view to use
   */
  public Controller(Model m, View v) {
    model = m;
    view = v;
    view.setListener(this);
    view.display();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    switch (e.getActionCommand()) { // read from the input text field

      case "Echo Button":
        String text = view.getInputString();
        // send text to the model
        model.setString(text);

        // clear input text field
        view.clearInputString();
        // finally echo the string in view
        text = model.getString();
        view.setEchoOutput(text);

        break;

      case "Exit Button":
        System.exit(0);
        break;

      default:
        throw new IllegalStateException("Error: unknown button");
    }
  }
}
