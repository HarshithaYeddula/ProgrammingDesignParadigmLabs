package baddesignbutfunctional;

import model.Model;
import model.ModelImpl;

/**
 * This is a complete program featuring a simple GUI. This program merely
 * illustrates how it works. It is designed rather badly. Read the comments in
 * the view to see why.
 */
public class Main {
  /**
   * The starting point of this example.
   * 
   * @param args Not used
   */
  public static void main(String[] args) {
    // create the model
    Model model = new ModelImpl();
    // create the view, and give it the model
    new FrameView("Echo a string", model);
  }
}
