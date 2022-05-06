package keyboardevents;

import model.Model;
import model.ModelImpl;

/**
 * Simple MVC example with keyboard events.
 */
public class Main {
  /**
   * The starting point of this example.
   * 
   * @param args Not used
   */
  public static void main(String[] args) {
    // Create the model
    Model model = new ModelImpl();
    // Create the view
    View view = new FrameView("Echo a string");
    // Create the controller with the model and view
    new Controller(model, view);
  }
}
