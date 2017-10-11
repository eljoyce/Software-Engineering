import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


// Note: 
public class LowestCommonAncestor<Key extends Comparable<Key>>
{
	private Node root;
	
	class Node {
		private Node left;             
		private Node right;
		private Key data;
		private int N;             // number of nodes in subtree

		public Node(Key value, int N) {
			this.data = value;         // associated data
			left = right = null;	  // left and right subtrees
			this.N = N;
		}
	}
	
	// is the tree empty?
	public boolean isEmpty() { return size() == 0; }
	
	// return number of nodes in the tree
	public int size() { return size(root); }
	
	// return number of key-value pairs in BST rooted at x
		private int size(Node x) {
			if (x == null) return 0;
			else return x.N;
		}
	
	private List<Key> nodePath1 = new ArrayList<>();
	private List<Key> nodePath2 = new ArrayList<>();
	//will use lists as a method to track the nodes tha

	Key lowestCommonAncestor(Key node1, Key node2) {
		nodePath1.clear();
		nodePath2.clear();
		return findLowestCommonAncestor(root, node1, node2);
	}

	private Key findLowestCommonAncestor(Node root, Key n1, Key n2) {

		if (!findPath(root, n1, nodePath1) || !findPath(root, n2, nodePath2)) {
			System.out.println((nodePath1.size() > 0) ? "n1 is present" : "n1 is missing");
			System.out.println((nodePath2.size() > 0) ? "n2 is present" : "n2 is missing");
			return -1;
		}

		int i;
		for (i = 0; i < nodePath1.size() && i < nodePath2.size(); i++) {
			//  System.out.println(path1.get(i) + " " + path2.get(i));
			if (!nodePath1.get(i).equals(nodePath2.get(i)))
				break;
		}

		return nodePath1.get(i-1);
	}

	private boolean findPath(Node root, int n, List<Integer> path)
	{
		if (root == null) {
			return false;
		}

		path.add(root.data);

		if (root.data == n) {
			return true;
		}

		if (root.left != null && findPath(root.left, n, path)) {
			return true;
		}

		if (root.right != null && findPath(root.right, n, path)) {
			return true;
		}

		path.remove(path.size()-1);

		return false;
	}

	

