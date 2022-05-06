package keyboardmaps;

import model.Model;
import model.ModelImpl;

/**
 * Simple example using keyboard maps.
 */
public class Main {
  /**
   * Starting point for this example.
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
