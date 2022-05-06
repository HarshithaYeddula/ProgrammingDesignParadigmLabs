import bst.BinarySearchTree;
import bst.BinarySearchTreeImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Testing BST implementation.
 */
public class BinarySearchTreeTest {
  
  private BinarySearchTree<Integer> tree;

  /**
   * Creating a BST Object before every test.
   */
  @Before
  public void setUp() {
    tree = new BinarySearchTreeImpl<>();   
    tree.add(4);
    tree.add(8);
    tree.add(5);
    tree.add(2);
    tree.add(7);
    tree.add(11);
    tree.add(15);
    tree.add(14);
    tree.add(9);
  }
  
  @Test
  public void testDefaultConstructor() {
    tree = new BinarySearchTreeImpl<>();
    Assert.assertEquals("[]", tree.toString());
  }

  @Test
  public void testAddWhenTreeIsNotEmpty() {
    Assert.assertEquals("[2 4 5 7 8 9 11 14 15]", tree.toString());
    tree.add(16);
    Assert.assertEquals("[2 4 5 7 8 9 11 14 15 16]", tree.toString());
  }

  @Test
  public void testAddWithElement() {
    Assert.assertEquals("[2 4 5 7 8 9 11 14 15]", tree.toString());
    tree.add(2);
    Assert.assertEquals("[2 4 5 7 8 9 11 14 15]", tree.toString());
  }

  @Test
  public void testSizeOfEmptyTree() {
    tree = new BinarySearchTreeImpl<>();
    Assert.assertEquals("[]", tree.toString());
    Assert.assertEquals(0, tree.size());
  }

  @Test
  public void testSizeOfNonEmptyTree() {
    Assert.assertEquals("[2 4 5 7 8 9 11 14 15]", tree.toString());
    Assert.assertEquals(9, tree.size());
  }

  @Test
  public void testPresentElementIfElementPresentInTree() {
    Assert.assertEquals("[2 4 5 7 8 9 11 14 15]", tree.toString());
    Assert.assertTrue(tree.present(14));
  }

  @Test
  public void testPresentElementIfElementNotPresentInTree() {
    Assert.assertEquals("[2 4 5 7 8 9 11 14 15]", tree.toString());
    Assert.assertFalse(tree.present(16));
  }

  @Test
  public void testMinimumWhenEmptyTree() {
    tree = new BinarySearchTreeImpl<>();
    Assert.assertEquals("[]", tree.toString());
    Assert.assertNull(tree.minimum());
  }

  @Test
  public void testMinimumWhenNonEmptyTree() {
    Assert.assertEquals("[2 4 5 7 8 9 11 14 15]", tree.toString());
    Assert.assertEquals("2", tree.minimum().toString());
  }

  @Test
  public void testMaximumWhenEmptyTree() {
    tree = new BinarySearchTreeImpl<>();
    Assert.assertEquals("[]", tree.toString());
    Assert.assertNull(tree.maximum());
  }

  @Test
  public void testMaximumWhenNonEmptyTree() {
    Assert.assertEquals("[2 4 5 7 8 9 11 14 15]", tree.toString());
    Assert.assertEquals("15", tree.maximum().toString());
  }

  @Test
  public void testPreOrderWhenEmptyTree() {
    tree = new BinarySearchTreeImpl<>();
    Assert.assertEquals("[]", tree.toString());
    Assert.assertEquals("[]", tree.preOrder());
  }

  @Test
  public void testPreOrderWhenNonEmptyTree() {
    Assert.assertEquals("[2 4 5 7 8 9 11 14 15]", tree.toString());
    Assert.assertEquals("[4 2 8 5 7 11 9 15 14]", tree.preOrder());
  }

  @Test
  public void testInOrderWhenEmptyTree() {
    tree = new BinarySearchTreeImpl<>();
    Assert.assertEquals("[]", tree.toString());
    Assert.assertEquals("[]", tree.inOrder());
  }

  @Test
  public void testInOrderWhenNonEmptyTree() {
    Assert.assertEquals("[2 4 5 7 8 9 11 14 15]", tree.toString());
    Assert.assertEquals("[2 4 5 7 8 9 11 14 15]", tree.inOrder());
  }

  @Test
  public void testPostOrderWhenEmptyTree() {
    tree = new BinarySearchTreeImpl<>();
    Assert.assertEquals("[]", tree.toString());
    Assert.assertEquals("[]", tree.postOrder());
  }

  @Test
  public void testPostOrderWhenNonEmptyTree() {
    Assert.assertEquals("[2 4 5 7 8 9 11 14 15]", tree.toString());
    Assert.assertEquals("[2 7 5 9 14 15 11 8 4]", tree.postOrder());
  }

  @Test
  public void testHeightWhenEmptyTree() {
    tree = new BinarySearchTreeImpl<>();
    Assert.assertEquals("[]", tree.toString());
    Assert.assertEquals(0, tree.height());
  }

  @Test
  public void testHeightWhenNonEmptyTree() {
    Assert.assertEquals("[2 4 5 7 8 9 11 14 15]", tree.toString());
    Assert.assertEquals(5, tree.height());
  }

  @Test
  public void testDifferentHeights() {
    tree = new BinarySearchTreeImpl<>();
    tree.add(5);
    tree.add(4);
    tree.add(3);
    tree.add(2);
    tree.add(6);
    Assert.assertEquals("[2 3 4 5 6]", tree.toString());
    Assert.assertEquals("[2 3 4 5 6]", tree.inOrder());
    Assert.assertEquals("[5 4 3 2 6]", tree.preOrder());
    Assert.assertEquals("[2 3 4 6 5]", tree.postOrder());
    Assert.assertEquals(4, tree.height());
  }

}
