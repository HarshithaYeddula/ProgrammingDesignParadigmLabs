package mvcwithfeatures;

import model.Model;
import model.ModelImpl;

/**
 * This example shows how to specify the (Key,Runnable) keyboard map using
 * shorter syntax using the ability of Java 11 to support lambda expressions.
 */
public class Main {
  /**
   * Starting point for this example.
   * 
   * @param args not used
   */
  public static void main(String[] args) {
    // Create the model
    Model model = new ModelImpl();
    // Create the controller with the model
    Controller controller = new Controller(model);
    // Create the view
    View view = new FrameView("Echo a string");
    // Set the view in the controller
    controller.setView(view);
  }
}
