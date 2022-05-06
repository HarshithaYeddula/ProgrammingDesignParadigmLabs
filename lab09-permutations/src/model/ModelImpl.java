package model;

/**
 * A simple model.
 */
public class ModelImpl implements Model {
  private String input;

  /** Default constructor. */
  public ModelImpl() {
    input = "";
  }

  @Override
  public void setString(String i) {
    input = i;
  }

  @Override
  public String getString() {
    return input;
  }
}