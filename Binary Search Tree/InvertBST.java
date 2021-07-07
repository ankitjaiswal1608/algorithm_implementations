import java.util.*;

class InvertBST {
  public static void invertBinaryTree(BinaryTree tree) {
    if (tree != null) {
			BinaryTree t = tree.left;
			tree.left = tree.right;
			tree.right = t;
			
			invertBinaryTree(tree.left);
			invertBinaryTree(tree.right);
		}
  }

  static class BinaryTree {
    public int value;
    public BinaryTree left;
    public BinaryTree right;

    public BinaryTree(int value) {
      this.value = value;
    }
  }
}
