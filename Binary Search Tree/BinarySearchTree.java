import java.util.*;
public class BinarySearchTree {

	public static void main(String[] args) {

		TreeNode root = null;
		Scanner sc = new Scanner(System.in);
		boolean condition = true;

		do {
			System.out.println("Please select below option:\n1. Insert node\n2. Delete node\n3. Search node\n4. Exit");

			switch(sc.nextInt()) {

				case 1: {

					System.out.print("Enter number to insert:");
					int element = sc.nextInt();
					if (root == null) root = new TreeNode(element);
					else insertElement(root, element);
				}
				break;

				case 2: {

					System.out.print("Enter number to delete:");
					int element = sc.nextInt();
					if (root == null) System.out.println("****Tree already empty****");
					else {
						if (deleteElement(root, element)) root = null;
					}
				}
				break;

				case 3: {

					System.out.print("Enter number to search:");
					int element = sc.nextInt();
					if (root == null) System.out.println("****Tree already empty****");
					else searchElement(root, element);
				}
				break;

				case 4: condition = false;
				break;

				default: System.out.println("****Please select correct number****");
			} 

			print(root);
		}
		while (condition);
	}

	public static void insertElement(TreeNode node, int element) {

		if (element < node.data) {

			if (node.left == null) node.left = new TreeNode(element);
			else insertElement(node.left, element);
		}
		else {

			if (node.right == null) node.right = new TreeNode(element);
			else insertElement(node.right, element);
		}
	}

	public static boolean deleteElement(TreeNode node, int element) {

		if (element == node.data) {

			if (node.left == null && node.right == null) return true;
			else if (node.left == null) {
				node.data = node.right.data;
				node.right = null;
			}
			else if (node.right == null) {
				node.data = node.left.data;
				 node.left = null;
			}
			else {

				if (exchangeWithPredecessor(node.left, node)) node.left = null;
			}
		}
		else if (element < node.data && node.left != null) {

			if (deleteElement(node.left, element)) node.left = null;
		}
		else if (element > node.data && node.right != null) {

			if (deleteElement(node.right, element)) node.right = null;
		}
		else System.out.println("****Element not found to delete****");

		return false;
	}

	public static void searchElement(TreeNode node, int element) {

		if (element == node.data) System.out.println("****Element found****");
		else if (element < node.data && node.left != null) {

			searchElement(node.left, element);
		}
		else if (element > node.data && node.right != null) {

			searchElement(node.right, element);
		}
		else System.out.println("****Element not found****");
	}

	public static boolean exchangeWithPredecessor(TreeNode node, TreeNode nodeToDelete) {

		if (node.right != null) {
			if (exchangeWithPredecessor(node.right, nodeToDelete)) node.right = null;
			return false;
		}
		else {
			nodeToDelete.data = node.data;
			return true;
		}
	}

	public static void print(TreeNode root) {
		
        List<List<String>> lines = new ArrayList<List<String>>();

        List<TreeNode> level = new ArrayList<TreeNode>();
        List<TreeNode> next = new ArrayList<TreeNode>();

        level.add(root);
        int nn = 1;

        int widest = 0;

        while (nn != 0) {
            List<String> line = new ArrayList<String>();

            nn = 0;

            for (TreeNode n : level) {
                if (n == null) {
                    line.add(null);

                    next.add(null);
                    next.add(null);
                } else {
                    String aa = n.data + "";
                    line.add(aa);
                    if (aa.length() > widest) widest = aa.length();

                    next.add(n.left);
                    next.add(n.right);

                    if (n.left != null) nn++;
                    if (n.right != null) nn++;
                }
            }

            if (widest % 2 == 1) widest++;

            lines.add(line);

            List<TreeNode> tmp = level;
            level = next;
            next = tmp;
            next.clear();
        }

        int perpiece = lines.get(lines.size() - 1).size() * (widest + 4);
        for (int i = 0; i < lines.size(); i++) {
            List<String> line = lines.get(i);
            int hpw = (int) Math.floor(perpiece / 2f) - 1;

            if (i > 0) {
                for (int j = 0; j < line.size(); j++) {

                    // split node
                    char c = ' ';
                    if (j % 2 == 1) {
                        if (line.get(j - 1) != null) {
                            c = (line.get(j) != null) ? '┴' : '┘';
                        } else {
                            if (j < line.size() && line.get(j) != null) c = '└';
                        }
                    }
                    System.out.print(c);

                    // lines and spaces
                    if (line.get(j) == null) {
                        for (int k = 0; k < perpiece - 1; k++) {
                            System.out.print(" ");
                        }
                    } else {

                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? " " : "─");
                        }
                        System.out.print(j % 2 == 0 ? "┌" : "┐");
                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? "─" : " ");
                        }
                    }
                }
                System.out.println();
            }

            // print line of numbers
            for (int j = 0; j < line.size(); j++) {

                String f = line.get(j);
                if (f == null) f = "";
                int gap1 = (int) Math.ceil(perpiece / 2f - f.length() / 2f);
                int gap2 = (int) Math.floor(perpiece / 2f - f.length() / 2f);

                // a number
                for (int k = 0; k < gap1; k++) {
                    System.out.print(" ");
                }
                System.out.print(f);
                for (int k = 0; k < gap2; k++) {
                    System.out.print(" ");
                }
            }
            System.out.println();

            perpiece /= 2;
        }
    }
}

class TreeNode {

	public int data;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int data) {

		this.data = data;
	}
}