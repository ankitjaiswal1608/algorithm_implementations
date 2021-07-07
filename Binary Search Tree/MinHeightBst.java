import java.util.*;

class MinHeightBst {
  public static BST minHeightBst(List<Integer> array) {
    if (array.size() == 0) return null;
		
		BST root = new BST(array.get((array.size() - 1)/2));
		root.left = minHeightBst(array.subList(0, (array.size()-1)/2));
		root.right = minHeightBst(array.subList(((array.size()-1)/2)+1, array.size()));
    return root;
  }

  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
      left = null;
      right = null;
    }

    public void insert(int value) {
      if (value < this.value) {
        if (left == null) {
          left = new BST(value);
        } else {
          left.insert(value);
        }
      } else {
        if (right == null) {
          right = new BST(value);
        } else {
          right.insert(value);
        }
      }
    }
  }
}
