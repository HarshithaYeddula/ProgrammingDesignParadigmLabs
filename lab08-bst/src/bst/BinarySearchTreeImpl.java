package bst;

/**
 * BinarySearchTreeImpl represents the creation of BST with the root node.
 * 
 * @param <T> the type of data that nodes have in the BST.
 */
public class BinarySearchTreeImpl<T extends Comparable<T>> implements BinarySearchTree<T> {

  private BinarySearchTreeNode<T> rootNode;

  /**
   * Constructs BST Object with initial node as Empty node.
   */
  public BinarySearchTreeImpl() {
    this.rootNode = new BinarySearchTreeEmptyNode<>();
  }

  @Override
  public void add(T data) {
    validateData(data);
    rootNode = rootNode.add(data);
  }

  @Override
  public int size() {
    int size = rootNode.size();
    return size;
  }

  @Override
  public int height() {
    int height = rootNode.height(0);
    return height;
  }

  @Override
  public boolean present(T data) {
    validateData(data);
    boolean isPresent = rootNode.present(data);
    return isPresent;
  }

  @Override
  public T minimum() {
    T minData = rootNode.minimum(null);
    return minData;
  }

  @Override
  public T maximum() {
    T maxData = rootNode.maximum(null);
    return maxData;
  }

  private String trailingCharacter(String nodes) {
    StringBuilder builder = new StringBuilder();
    builder.append("[");
    builder.append(((nodes == null || nodes.length() == 0) ? nodes
        : (nodes.substring(0, nodes.length() - 1))));
    builder.append("]");
    return builder.toString();
  }

  @Override
  public String toString() {
    String str = inOrder();
    return str;
  }

  @Override
  public String preOrder() {
    String str = trailingCharacter(rootNode.preOrder());
    return str;
  }

  @Override
  public String inOrder() {
    String str = trailingCharacter(rootNode.inOrder());
    return str;
  }

  @Override
  public String postOrder() {
    String str = trailingCharacter(rootNode.postOrder());
    return str;
  }

  private void validateData(T data) {
    if (data == null) {
      throw new IllegalArgumentException("Data Cannot be Null!");
    }
  }
}
