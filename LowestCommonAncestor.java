import java.util.ArrayList;
import java.util.List;
 
class Node<T> {
    T data;
    Node left;
    Node right;
 
    Node(T value) {
        data = value;
        left = right = null;
    }
}
 
// Note: 
public class LowestCommonAncestor<T>
{
 
    Node root;
    private List<T> nodePath1 = new ArrayList<>();
    private List<T> nodePath2 = new ArrayList<>();
    //will use lists as a method to track the nodes tha
    
    T LowestCommonAncestor(T node1, T node2) {
    	nodePath1.clear();
    	nodePath2.clear();
        return findLowestCommonAncestor(root, node1, node2);
    }
 
    private T findLowestCommonAncestor(Node root, T n1, T n2) {
 
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
 
    public static void main(String[] args)
    {
    	LowestCommonAncestor tree = new LowestCommonAncestor();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
 
        System.out.println("LCA(4, 5): " + tree.LowestCommonAncestor(4,5));
        System.out.println("LCA(4, 6): " + tree.LowestCommonAncestor(4,6));
        System.out.println("LCA(3, 4): " + tree.LowestCommonAncestor(3,4));
        System.out.println("LCA(2, 4): " + tree.LowestCommonAncestor(2,4));
       /* System.out.println("LCA(4, 7): " + tree.findLCA(4,7));
        System.out.println("LCA(4, 8): " + tree.findLCA(4,8));
        System.out.println("LCA(1, 1): " + tree.findLCA(1,1)); */
    }
}

