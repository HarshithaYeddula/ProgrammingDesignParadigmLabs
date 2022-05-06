package keyboardmapswithlambdas;

import model.Model;
import model.ModelImpl;

/**
 * This example shows how to specify the (Key,Runnable) keyboard map using
 * shorter syntax using the ability of java 8 to support lambda expressions.
 */
public class Main {
  /**
   * The starting point for this example.
   * 
   * @param args Not used
   */
  public static void main(String[] args) {
    // Create the model
    Model model = new ModelImpl();
    // Create the controller with the model
    Controller controller = new Controller(model);
    // Create the view
    View view = new FrameView("Echo a string", controller);
    // Set the view in the controller
    controller.setView(view);
  }
}
