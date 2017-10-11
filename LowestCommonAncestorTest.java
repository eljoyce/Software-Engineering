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
	public void testPut(){
		LowestCommonAncestor<Integer> bst = new LowestCommonAncestor<Integer>();
		bst.put(null);
		assertEquals("Test that put() does nothing if the value is null","()",bst.printKeysInOrder());
		bst.put(4);
		bst.put(2);
		bst.put(1);
		bst.put(6);
		bst.put(5);
		bst.put(7);		
		bst.put(3);
		assertEquals("Check that put() inserts nodes correctly","(((()1())2(()3()))4((()5())6(()7())))",bst.printKeysInOrder());

	}
	@Test
	public void testSize() {
		LowestCommonAncestor<Integer> bst = new LowestCommonAncestor<Integer>();
		assertEquals("Check that size() returns 0 when the tree is empty",0,bst.size());
		bst.put(7);
		assertEquals("Check that size = 1", 1, bst.size());
		bst.put(6);
		bst.put(3);
		assertEquals("Check that size = 3", 3, bst.size());
		bst.put(3);
		assertEquals("Check that size = 3 because new element added already exists", 3, bst.size());
	}
	@Test 
	public void testContains(){
		LowestCommonAncestor<Integer> bst = new LowestCommonAncestor<Integer>();
		assertFalse("Checking contains() returns true when bst is empty",bst.contains(4));
		bst.put(7);
		assertFalse("Checking contains() returns false when bst isn't empty but doesn't contain the key",bst.contains(1));
		assertTrue("Checking contains() retuns true when bst isn't empty and conatins the key",bst.contains(7));
	}
	@Test
	public void testGet(){
		LowestCommonAncestor<Integer> bst = new LowestCommonAncestor<Integer>();
		assertEquals("Check that get() returns null when given an empty list", null, bst.get(9));
		bst.put(4);
		bst.put(2);
		bst.put(7);
		assertEquals("Check that get() returns 4 when given 4", 4, (int)bst.get(4));
		assertEquals("Check that get() returns 7 when given 7", 7, (int)bst.get(7));
		assertEquals("Check that get() returns 2 when given 2", 2, (int)bst.get(2));
		assertEquals("Check that get() returns null when the key does not exist", null, bst.get(9));

	}
	@Test 
	public void testIsEmpty(){
		LowestCommonAncestor<Integer> bst = new LowestCommonAncestor<Integer>();
		assertTrue("Checking isEmpty() returns true when bst is empty",bst.isEmpty());
		bst.put(7);
		assertFalse("Checking isEmpty() returns false when bst isn't empty",bst.isEmpty());
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
