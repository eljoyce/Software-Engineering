import java.util.ArrayList;
import java.util.List;

import BST.Node;



// Note: 
public class LowestCommonAncestor<Key extends Comparable<Key>>
{
	class Node {
		private Node left;             
		private Node right;
		private Key data;


		public Node(Key value) {
			this.data = value;         // associated data
			left = right = null;	  // left and right subtrees
		}
	}
	Node root;
	
	private List<Key> nodePath1 = new ArrayList<>();
	private List<Key> nodePath2 = new ArrayList<>();
	//will use lists as a method to track the nodes tha

	Key lowestCommonAncestor(Key node1, Key node2) {
		nodePath1.clear();
		nodePath2.clear();
		return findLowestCommonAncestor(root, node1, node2);
	}
	
	/**
	 *  Search BST for given key.
	 *  Does there exist a key-value pair with given key?
	 *
	 *  @param key the search key
	 *  @return true if key is found and false otherwise
	 */
	public boolean contains(Key key) {
		return get(key) != null;
	}
	/**
	 *  Search BST for given key.
	 *  What is the value associated with given key?
	 *
	 *  @param key the search key
	 *  @return value associated with the given key if found, or null if no such key exists.
	 */
	public Value get(Key key) { return get(root, key); }

	private Value get(Node x, Key key) {
		if (x == null) return null;
		int cmp = key.compareTo(x.key);
		if      (cmp < 0) return get(x.left, key);
		else if (cmp > 0) return get(x.right, key);
		else              return x.val;
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

	

