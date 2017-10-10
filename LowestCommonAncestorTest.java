import static org.junit.Assert.*;

import org.junit.Test;

public class LowestCommonAncestorTest {

	@Test
	public void testSizeEmpty() {
		LowestCommonAncestor<Integer> binaryTreeEmpty = new LowestCommonAncestor<Integer>();
		assertEquals("Lowest common ancestor of empty tree", -1, binaryTreeEmpty.LowestCommonAncestor(0, 0));
	}
	

}
