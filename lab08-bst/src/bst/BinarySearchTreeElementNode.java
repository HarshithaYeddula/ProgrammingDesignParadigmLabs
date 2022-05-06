package bst;

/**
 * Implements the element nodes of the BST.
 * 
 * @param <T> the type of data that the node has in the BST.
 */
public class BinarySearchTreeElementNode<T extends Comparable<T>>
    implements BinarySearchTreeNode<T> {

  private final T node;
  private BinarySearchTreeNode<T> lchild;
  private BinarySearchTreeNode<T> rchild;

  /**
   * Constructing the BST object with left child and right child.
   * 
   * @param data       the value of the given node.
   * @param lchild  node left child.
   * @param rchild node right child.
   */
  public BinarySearchTreeElementNode(T data, BinarySearchTreeNode<T> lchild,
      BinarySearchTreeNode<T> rchild) {
    validateData(data);
    this.node = data;

    validateChild(lchild);
    this.lchild = lchild;

    validateChild(rchild);
    this.rchild = rchild;
  }

  @Override
  public BinarySearchTreeNode<T> add(T data) {
    validateData(data);
    if (node.compareTo(data) < 0) {
      rchild = rchild.add(data);
    } else if (node.compareTo(data) > 0) {
      lchild = lchild.add(data);
    }
    return this;
  }

  @Override
  public int size() {
    final int leftChildrenSize = lchild.size();
    final int rightChildrenSize = rchild.size();
    final int totalSize = 1 + leftChildrenSize + rightChildrenSize;
    return totalSize;
  }

  @Override
  public boolean present(T data) {
    validateData(data);
    if (node.compareTo(data) == 0) {
      return true;
    } else if (node.compareTo(data) < 0) {
      return rchild.present(data);
    } else {
      return lchild.present(data);
    }
  }

  @Override
  public T minimum(T minimum) {
    return lchild.minimum(node);
  }

  @Override
  public T maximum(T maximum) {
    return rchild.maximum(node);
  }

  @Override
  public int height(int height) {
    int leftChildrenHeight = lchild.height(1 + height);
    int rightChildrenHeight = rchild.height(1 + height);
    return Math.max(leftChildrenHeight, rightChildrenHeight);
  }
  
  @Override
  public String preOrder() {
    StringBuilder builder = new StringBuilder();
    builder.append(node);
    builder.append(" ");
    builder.append(lchild.preOrder());
    builder.append(rchild.preOrder());
    return builder.toString();
  }

  @Override
  public String inOrder() {
    StringBuilder builder = new StringBuilder();
    builder.append(lchild.inOrder());
    builder.append(node);
    builder.append(" ");
    builder.append(rchild.inOrder());
    return builder.toString();
  }

  @Override
  public String postOrder() {
    StringBuilder builder = new StringBuilder();
    builder.append(lchild.postOrder());
    builder.append(rchild.postOrder());
    builder.append(node);
    builder.append(" ");
    return builder.toString();
  }

  private void validateChild(BinarySearchTreeNode<T> child) {
    if (child == null) {
      throw new IllegalArgumentException("Child cannot be Null!");
    }

  }

  private void validateData(T data) {
    if (data == null) {
      throw new IllegalArgumentException("Data cannot be Null!");
    }
  }


}
