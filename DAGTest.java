package dag;

import static org.junit.Assert.*;
import org.junit.Test;



public class DAGTest {


	@Test
	public void testAddChild(){
		Tree.Node football = new Tree.Node();
		Tree.Node competition = new Tree.Node();
		football.addChild(competition);
		assertEquals(competition, football.getChildren().get(0));
	}

	@Test
	public void testAddParent(){
		Tree.Node football = new Tree.Node();
		Tree.Node competition = new Tree.Node();
		competition.addParent(football);
		assertEquals(football, competition.getListParent().get(0));
	}
	@Test
	public void testAddParentCheckChildrenConsistent(){
		Tree.Node football = new Tree.Node();
		Tree.Node competition = new Tree.Node();
		competition.addParent(football);
		assertEquals(football, competition.getListParent().get(0));
		assertEquals(competition, football.getChildren().get(0));
	}

	@Test
	public void testReturnNodesChildren(){
		Tree.Node football = new Tree.Node();
		Tree.Node competition = new Tree.Node();
		Tree.Node player = new Tree.Node();
		football.addChild(competition);
		football.addChild(player);
		assertEquals(2, football.getChildren().size());
		assertTrue(football.getChildren().contains(competition));
		assertTrue(football.getChildren().contains(player));
	}

	@Test
	public void testReturnListOfDescendents(){
		Tree.Node football = new Tree.Node();
		Tree.Node competition = new Tree.Node();
		Tree.Node player = new Tree.Node();

		Tree.Node premiership = new Tree.Node();
		Tree.Node championsLeague= new Tree.Node();
		Tree.Node manCity = new Tree.Node();
		Tree.Node manUtd = new Tree.Node();

		football.addChild(competition);
		football.addChild(player);
		
		competition.addChild(premiership);
		competition.addChild(championsLeague);

		premiership.addChild(manCity);
		premiership.addChild(manUtd);

		championsLeague.addChild(manUtd);

		assertEquals(6, football.getDescendent().size());
	}
	@Test
	public void testLCA(){
		Tree<Short> bst = new Tree<Short>();
		Tree.Node football = new Tree.Node();
		assertEquals("If graph is empty, returns null", null, football.lca(, ));
		Tree.Node competition = new Tree.Node();
		Tree.Node player = new Tree.Node();
		football.addChild(competition);
		football.addChild(player);
		
		Tree.Node premiership = new Tree.Node();
		Tree.Node championsLeague= new Tree.Node();
		
		Tree.Node manCity = new Tree.Node();
		Tree.Node manUtd = new Tree.Node();
		Tree.Node liverpool = new Tree.Node();

		
		competition.addChild(premiership);
		competition.addChild(championsLeague);

		premiership.addChild(manCity);
		premiership.addChild(manUtd);

		championsLeague.addChild(liverpool);

		assertEquals("For normal graph returns competition",competition, football.lca(manUtd, liverpool));

	}

}

