import static org.junit.Assert.*;
import java.util.NoSuchElementException;
import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class LowestCommonAncestorTest {

	@Test
	public void testSize() {
		LowestCommonAncestor<Integer> bst = new LowestCommonAncestor<Integer>();
		assertEquals("isEmpty to return true if binary search tree is empty", true, bst.isEmpty());
		
		//assertEquals("Lowest common ancestor of empty tree", -1, binaryTreeEmpty.lowestCommonAncestor(0, 0));
	}
//	public static void main(String[] args)
//	{
//		LowestCommonAncestor tree = new LowestCommonAncestor();
//		tree.root = new Node(1);
//		tree.root.left = new Node(2);
//		tree.root.right = new Node(3);
//		tree.root.left.left = new Node(4);
//		tree.root.left.right = new Node(5);
//		tree.root.right.left = new Node(6);
//		tree.root.right.right = new Node(7);
//
//		System.out.println("LCA(4, 5): " + tree.LowestCommonAncestor(4,5));
//		System.out.println("LCA(4, 6): " + tree.LowestCommonAncestor(4,6));
//		System.out.println("LCA(3, 4): " + tree.LowestCommonAncestor(3,4));
//		System.out.println("LCA(2, 4): " + tree.LowestCommonAncestor(2,4));
//		/* System.out.println("LCA(4, 7): " + tree.findLCA(4,7));
//        System.out.println("LCA(4, 8): " + tree.findLCA(4,8));
//        System.out.println("LCA(1, 1): " + tree.findLCA(1,1)); */
//	}
//}

}
