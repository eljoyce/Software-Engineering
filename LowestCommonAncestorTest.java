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
	public void testLowestCommonAncestor(){
		LowestCommonAncestor<Integer> bst = new LowestCommonAncestor<Integer>();
		assertEquals("Function returns null as binary tree is empty", null, bst.lowestCommonAncestor(1,2));
		bst.put(7);   //        _7_
		bst.put(8);   //      /     \
		bst.put(3);   //    _3_      8
		bst.put(1);   //  /     \
		bst.put(2);   // 1       6
		bst.put(6);   //  \     /
		bst.put(4);   //   2   4
		bst.put(5);   //        \
					  //         5
		assertEquals("Function returns root as lca", (Integer)7, bst.lowestCommonAncestor(2, 8));
		assertEquals("Function returns null if one key isn't in a tree", null, bst.lowestCommonAncestor(2, 9));
		assertEquals("Function returns null if both keys aren't in the tree", null, bst.lowestCommonAncestor(12, 9));
		assertEquals("Function returns 3 as it is the parent to both keys", (Integer)3, bst.lowestCommonAncestor(1,6));
		assertEquals("Function returns 3 as it is the lowest common ancestor to both nodes", (Integer)3, bst.lowestCommonAncestor(5,2));
		assertEquals("Test function when one of the inputs is the lca", (Integer)6, bst.lowestCommonAncestor(4,6));

	}
	@Test
	public void testLCAForNonExistentNode() {
		LowestCommonAncestor<String> bst = new LowestCommonAncestor<String>();
		bst.put("Ellen");
		bst.put("Sarah");
		bst.put("Maeve");
		assertEquals("Testing tree when one node doesn't exist", null, bst.lowestCommonAncestor("Ellen", "Eimear"));
		assertEquals("Testing tree when both nodes don't exist", null, bst.lowestCommonAncestor("Eimear","Dots"));
		
		LowestCommonAncestor<Integer> bstInt = new LowestCommonAncestor<Integer>();
		bstInt.put(1);
		bstInt.put(3);
		bstInt.put(2);
		assertEquals("Testing tree when one node doesn't exist", null, bstInt.lowestCommonAncestor(5,1 ));
		assertEquals("Testing tree when both nodes don't exist", null, bstInt.lowestCommonAncestor(5,7));
		
	}
	@Test
	public void testLowestCommonAncestorString(){
		LowestCommonAncestor<String> bst = new LowestCommonAncestor<String>();
		assertEquals("Function returns null as binary tree is empty", null, bst.lowestCommonAncestor("Ellen","Maeve"));
		bst.put("Ellen");
		bst.put("Alan");
		bst.put("Sarah");
		bst.put("Maeve");
		bst.put("Tom");
		bst.put("Roisin");
		assertEquals("Function returns root as lca","Ellen", bst.lowestCommonAncestor("Alan", "Roisin"));
		assertEquals("Function returns null if one key isn't in a tree", null, bst.lowestCommonAncestor("Ava", "Roisin"));
		assertEquals("Function returns null if both keys aren't in the tree", null, bst.lowestCommonAncestor("Ava", "Eve"));
		assertEquals("Function returns Sarah as it is the parent to both keys", "Sarah", bst.lowestCommonAncestor("Maeve","Tom"));
		assertEquals("Function returns Sarah as it is the lowest common ancestor to both nodes", "Sarah", bst.lowestCommonAncestor("Roisin","Tom"));
	}

	@Test
	public void testPutForInteger(){
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
	public void testPutForShort(){
		LowestCommonAncestor<Short> bst = new LowestCommonAncestor<Short>();
		bst.put(null);
		assertEquals("Test that put() does nothing if the value is null","()",bst.printKeysInOrder());
		bst.put((short) 7);   //        _7_
		bst.put((short) 8);   //      /     \
		bst.put((short) 3);   //    _3_      8
		bst.put((short) 1);   //  /     \
		bst.put((short) 2);   // 1       6
		bst.put((short) 6);   //  \     /
		bst.put((short) 4);   //   2   4
		bst.put((short) 5);   //        \
							  //         5

		assertEquals("Checking order of constructed tree",
				"(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());
		bst.put((short) 32769);
		assertEquals("Checking order of constructed tree with element larger than short - element becomes -32767 dependent on its value and the fact it doesn't lie in range -32,768 -> 32,767 (inclusive)",
				"((((()-32767())1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());
		bst.put((short) -400000);
		assertEquals("Checking order of constructed tree with element larger than short - element becomes -6784 dependent on its value and the fact it doesn't lie in range -32,768 -> 32,767 (inclusive)",
				"((((()-32767(()-6784()))1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());
		bst.put((short) -400001);
		assertEquals("Checking order of constructed tree with element larger than short - element becomes -6785 dependent on its value and the fact it doesn't lie in range -32,768 -> 32,767 (inclusive)",
				"((((()-32767((()-6785())-6784()))1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());
		bst.put((short) -65535);
		assertEquals("Checking order of constructed tree with element larger than short - element becomes -65535 as a short is 1, which already exisits in the tree so it isn't included again",
				"((((()-32767((()-6785())-6784()))1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());
	}
	@Test
	public void testPutForByte(){
		LowestCommonAncestor<Byte> bst = new LowestCommonAncestor<Byte>();
		bst.put(null);
		assertEquals("Test that put() does nothing if the value is null","()",bst.printKeysInOrder());
		bst.put((byte) 7);   //        _7_
		bst.put((byte) 8);   //      /     \
		bst.put((byte) 3);   //    _3_      8
		bst.put((byte) 1);   //  /     \
		bst.put((byte) 2);   // 1       6
		bst.put((byte) 6);   //  \     /
		bst.put((byte) 4);   //   2   4
		bst.put((byte) 5);   //        \
							  //         5

		assertEquals("Checking order of constructed tree",
				"(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());
		bst.put((byte) 32769);
		assertEquals("Checking order of constructed tree with element larger than byte - "
				+ "nothing is put into the tree as if the element is larger than the range -128 -> 127(inclusive) so it takes the value 1, which already exists in the tree there for the tree remains the same",
				"(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());

	}
	@Test
	public void testPutForString(){
		LowestCommonAncestor<String> bst = new LowestCommonAncestor<String>();
		bst.put(null);
		assertEquals("Test that put() does nothing if the value is null","()",bst.printKeysInOrder());
		bst.put("Ellen");		//			_Ellen_
		bst.put("went");		//		   /		\
		bst.put("to");			//		_and_		_went_
		bst.put("training");	//				   /	  \
		bst.put("and");			//				 _to_		
		bst.put("got very");	//					 \
		bst.put("sweaty!");		//					  training
		assertEquals("Check that put() inserts nodes in alphatbetic order","(()Ellen(((()and(()got very(()sweaty!())))to(()training()))went()))",bst.printKeysInOrder());
	}
	@Test
	public void testPutForBoolean(){
		LowestCommonAncestor<Boolean> bst = new LowestCommonAncestor<Boolean>();
		bst.put(null);
		assertEquals("Test that put() does nothing if the value is null","()",bst.printKeysInOrder());
		bst.put(true);
		bst.put(true);
		bst.put(false);
		bst.put(false);
		bst.put(null);
		bst.put(true);		
		assertEquals("Check that put() inserts nodes correctly for boolean values, note: bst does no allow for repeat values so true & false c"
				+ "an only appear once and null will not appear","((()false())true())",bst.printKeysInOrder());
	}
	@Test
	public void testSizeInt() {
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
	public void testSizeChar() {
		LowestCommonAncestor<Character> bst = new LowestCommonAncestor<Character>();
		assertEquals("Check that size() returns 0 when the tree is empty",0,bst.size());
		bst.put('a');
		assertEquals("Check that size = 1", 1, bst.size());
		bst.put('z');
		bst.put('w');
		assertEquals("Check that size = 3", 3, bst.size());
		bst.put('w');
		assertEquals("Check that size = 3 because new element added already exists", 3, bst.size());
	}
	@Test 
	public void testContainsInt(){
		LowestCommonAncestor<Integer> bst = new LowestCommonAncestor<Integer>();
		assertFalse("Checking contains() returns true when bst is empty",bst.contains(4));
		bst.put(7);
		assertFalse("Checking contains() returns false when bst isn't empty but doesn't contain the key",bst.contains(1));
		assertTrue("Checking contains() retuns true when bst isn't empty and conatins the key",bst.contains(7));
	}
	@Test 
	public void testContainsDouble(){
		LowestCommonAncestor<Double> bst = new LowestCommonAncestor<Double>();
		assertFalse("Checking contains() returns true when bst is empty",bst.contains(4.3));
		bst.put(7.5);
		assertFalse("Checking contains() returns false when bst isn't empty but doesn't contain the key",bst.contains(1.0));
		assertTrue("Checking contains() retuns true when bst isn't empty and conatins the key",bst.contains(7.5));
	}
	@Test 
	public void testContainsString(){
		LowestCommonAncestor<String> bst = new LowestCommonAncestor<String>();
		assertFalse("Checking contains() returns true when bst is empty",bst.contains("Hi"));
		bst.put("Hello World");
		assertFalse("Checking contains() returns false when bst isn't empty but doesn't contain the key",bst.contains("Hello World!"));
		assertTrue("Checking contains() retuns true when bst isn't empty and conatins the key",bst.contains("Hello World"));
	}
	@Test
	public void testGetInt(){
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
	public void testGetByte(){
		LowestCommonAncestor<Byte> bst = new LowestCommonAncestor<Byte>();
		assertEquals("Check that get() returns null when given an empty list", null, bst.get((byte)9));
		bst.put((byte)4);
		bst.put((byte)2);
		bst.put((byte)-7);
		assertEquals("Check that get() returns 4 when given 4", 4, (int)bst.get((byte)4));
		assertEquals("Check that get() returns 7 when given 7", -7, (int)bst.get((byte)-7));
		assertEquals("Check that get() returns null when the key does not exist", null, bst.get((byte)9));

	}
	@Test 
	public void testIsEmptyInt(){
		LowestCommonAncestor<Integer> bst = new LowestCommonAncestor<Integer>();
		assertTrue("Checking isEmpty() returns true when bst is empty",bst.isEmpty());
		bst.put(7);
		assertFalse("Checking isEmpty() returns false when bst isn't empty",bst.isEmpty());
	}
	@Test 
	public void testIsEmptyChar(){
		LowestCommonAncestor<Character> bst = new LowestCommonAncestor<Character>();
		assertTrue("Checking isEmpty() returns true when bst is empty",bst.isEmpty());
		bst.put('t');
		assertFalse("Checking isEmpty() returns false when bst isn't empty",bst.isEmpty());
	}
	
	
	@Test
	public void testDeleteInt() {
		LowestCommonAncestor<Integer> bst = new LowestCommonAncestor<Integer>();
		bst.delete(1);
		assertEquals("Deleting from empty tree", "()", bst.printKeysInOrder());

		bst.put(7);   //        _7_
		bst.put(8);   //      /     \
		bst.put(3);   //    _3_      8
		bst.put(1);   //  /     \
		bst.put(2);   // 1       6
		bst.put(6);   //  \     /
		bst.put(4);   //   2   4
		bst.put(5);   //        \
		//         5

		assertEquals("Checking order of constructed tree",
				"(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());

		bst.delete(9);
		assertEquals("Deleting non-existent key",
				"(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());

		bst.delete(8);
		assertEquals("Deleting leaf", "(((()1(()2()))3((()4(()5()))6()))7())", bst.printKeysInOrder());

		bst.delete(6);
		assertEquals("Deleting node with single child",
				"(((()1(()2()))3(()4(()5())))7())", bst.printKeysInOrder());

		bst.delete(3);
		assertEquals("Deleting node with two children",
				"(((()1())2(()4(()5())))7())", bst.printKeysInOrder());
	}
	@Test
	public void testDeleteShort() {
		LowestCommonAncestor<Short> bst = new LowestCommonAncestor<Short>();
		bst.delete((short) 1);
		assertEquals("Deleting from empty tree", "()", bst.printKeysInOrder());

		bst.put((short) 7);   //        _7_
		bst.put((short) 8);   //      /     \
		bst.put((short) 3);   //    _3_      8
		bst.put((short) 1);   //  /     \
		bst.put((short) 2);   // 1       6
		bst.put((short) 6);   //  \     /
		bst.put((short) 4);   //   2   4
		bst.put((short) 5);   //        \
							  //         5

		assertEquals("Checking order of constructed tree",
				"(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());
		
		bst.delete((short) 9);
		assertEquals("Deleting non-existent key",
				"(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());

		bst.delete((short) 8);
		assertEquals("Deleting leaf", "(((()1(()2()))3((()4(()5()))6()))7())", bst.printKeysInOrder());

		bst.delete((short) 6);
		assertEquals("Deleting node with single child",
				"(((()1(()2()))3(()4(()5())))7())", bst.printKeysInOrder());

		bst.delete((short) 3);
		bst.delete((short) -32769 );
		assertEquals("Deleting node with two children",
				"(((()1())2(()4(()5())))7())", bst.printKeysInOrder());
	}
	

}