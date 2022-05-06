package bst;

/**
 * BinarySearchTreeNode represents each node in the BST.
 * 
 * @param <T> type of the BST Node data.
 */
public interface BinarySearchTreeNode<T extends Comparable<T>> {

  /**
   * Add data to the Binary Search Tree.
   * 
   * @param data that needs to be added to the BST.
   * @return updated BST Node after insertion.
   */
  BinarySearchTreeNode<T> add(T data);

  /**
   * Number of nodes in the BST excluding the empty nodes.
   * 
   * @return number of nodes in the BST.
   */
  int size();

  /**
   * Check if this data is present in the current BST.
   *
   * @param data  data that needs to be searched in the tree
   * @return true if the data is present, otherwise false
   */
  boolean present(T data);

  /**
   * Determine and return the minimum data in the tree as defined by its ordering.
   * 
   * @param minimum value of the current BST.
   * @return the minimum data if it exists, null otherwise
   */
  T minimum(T minimum);

  /**
   * Determine and return the maximum data in the tree as defined by its ordering.
   * 
   * @param maximum value of the current BST.
   * @return the maximum data if it exists, null otherwise
   */
  T maximum(T maximum);

  /**
   * Current height of the BinarySearchTree.
   * 
   * @param height height of the subtree root node.
   * @return height of the tree.
   */
  int height(int height);

  /**
   * Returns a string that present all the data in the tree, sorted in ascending
   * order. The string is formatted as [d1 d2 ... dn]
   *
   * @return a string containing the preorder traveral
   */
  String preOrder();

  /**
   * Returns a string that present all the data in the tree in pre-order. sorted
   * in ascending order. The string is formatted as [d1 d2 ... dn]
   *
   * @return a string containing the inorder traversal
   */
  String inOrder();

  /**
   * Returns a string that present all the data in the tree, sorted in ascending
   * order. The string is formatted as [d1 d2 ... dn]
   *
   * @return a string containing the postorder traversal
   */
  String postOrder();
}
