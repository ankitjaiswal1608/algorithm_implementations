import java.util.*;

class FindKthLargestValue {
  // This is an input class. Do not edit.
  static class BST {
    public int value;
    public BST left = null;
    public BST right = null;

    public BST(int value) {
      this.value = value;
    }
  }
	
	public int result = -1;
	public int index = 0;

  public int findKthLargestValueInBst(BST tree, int k) {
    
		if (tree != null) {
			traverse(tree, k);
		}
    return result;
  }
	
	public void traverse(BST node, int k) {
		
		if (result == -1 && node.right != null) {
			traverse(node.right, k);
		}
		if (result == -1) {
			index++;
			if (index == k) result = node.value;
		}
		if (result == -1 && node.left != null) {
			traverse(node.left, k);
		}
	}
}
