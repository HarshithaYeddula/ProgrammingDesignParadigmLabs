package bst;

/**
 * EmptyBinarySearchTreeNode represents the empty node of the BST.
 */
public class BinarySearchTreeEmptyNode<T extends Comparable<T>> implements BinarySearchTreeNode<T> {

  
  @Override
  public BinarySearchTreeNode<T> add(T data) {
    return new BinarySearchTreeElementNode<>(data, new BinarySearchTreeEmptyNode<>(), this);
  }

  @Override
  public int size() {
    return 0;
  }

  @Override
  public boolean present(T data) {
    return false;
  }

  @Override
  public T minimum(T minimum) {
    return minimum;
  }

  @Override
  public T maximum(T maximum) {
    return maximum;
  }

  @Override
  public int height(int height) {
    return height;
  }

  @Override
  public String preOrder() {
    return "";
  }

  @Override
  public String inOrder() {
    return "";
  }

  @Override
  public String postOrder() {
    return "";
  }
}
