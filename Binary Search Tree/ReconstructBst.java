import java.util.*;

class ReconstructBst {
  // This is an input class. Do not edit.
  static class BST {
    public int value;
    public BST left = null;
    public BST right = null;

    public BST(int value) {
      this.value = value;
    }
  }

  public BST reconstructBst(ArrayList<Integer> preOrderTraversalValues) {
		
		return reconstructBstTraverse(preOrderTraversalValues);
  }
	
	public BST reconstructBstTraverse(List<Integer> preOrderTraversalValues) {
		
		if (preOrderTraversalValues.size() == 0) return null;
    
		BST root = new BST(preOrderTraversalValues.get(0));
		
		int right = 1;
		for (int i = 1; i < preOrderTraversalValues.size(); i++) {
			if (preOrderTraversalValues.get(i) >= preOrderTraversalValues.get(0)) break;
			right++;
		}
		root.left = reconstructBstTraverse(preOrderTraversalValues.subList(1, right));
		root.right = reconstructBstTraverse(preOrderTraversalValues.subList(right, preOrderTraversalValues.size()));
		
    return root;
  }
}
