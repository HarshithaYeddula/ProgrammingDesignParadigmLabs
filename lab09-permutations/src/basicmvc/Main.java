package basicmvc;

import model.Model;
import model.ModelImpl;

/**
 * This program represents a basic MVC architecture.
 *
 * <p>The model maintains a single string that is input by the user using the GUI
 * and echoed on the GUI.
 *
 * <p>The view is the GUI.
 *
 * <p>The controller reacts whenever the user presses a button. It acts as a
 * communicator between model and view, and thus separates them.
 *
 * <p>Advantages of this design:
 *
 * <p>1. Changing the GUI but not the functionality (model) is possible and clean.
 * 
 * <p>2. Using a new implementation of the model without changing view and
 * controller is possible.
 *
 * <p>Limitations of this design:
 *
 * <p>Handling keyboard and mouse events is not covered yet. This must be done in a
 * scalable manner, because the key mappings (which keys do what) should be
 * easily changeable, and should be changeable by the controller and not mandate
 * a rewrite of the view.
 */
public class Main {
  
  /**
   * Starting point of the program.
   * 
   * @param args Not used
   */
  public static void main(String[] args) {
    // Create the model
    Model model = new ModelImpl();
    // Create the view
    View view = new FrameView("Echo a string");
    // Create the controller with the model and the view
    new Controller(model, view);
  }
}
