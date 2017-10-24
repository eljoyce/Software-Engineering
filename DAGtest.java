import static org.junit.Assert.*;
import org.junit.Test;

public class DAGtest {


	@Test
	public void testAddChild(){
		Node football = new Node();
		Node competition = new Node();
		football.addChild(competition);
		assertEquals(competition, football.getChildren().get(0));
	}

	@Test
	public void testAddParent(){
		Node football = new Node();
		Node competition = new Node();
		competition.addParent(football);
		assertEquals(football, competition.getListParent().get(0));
	}
	@Test
	public void testAddParentCheckChildrenConsistent(){
		Node football = new Node();
		Node competition = new Node();
		competition.addParent(football);
		assertEquals(football, competition.getListParent().get(0));
		assertEquals(competition, football.getChildren().get(0));
	}

	@Test
	public void testReturnNodesChildren(){
		Node football = new Node();
		Node competition = new Node();
		Node player = new Node();
		football.addChild(competition);
		football.addChild(player);
		assertEquals(2, football.getChildren().size());
		assertTrue(football.getChildren().contains(competition));
		assertTrue(football.getChildren().contains(player));
	}

	@Test
	public void testReturnListOfDescendents(){
		Node football = new Node();
		Node competition = new Node();
		Node player = new Node();

		Node premiership = new Node();
		Node championsLeague= new Node();
		Node manCity = new Node();
		Node manUtd = new Node();

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
		Node football = new Node();
		Node competition = new Node();
		Node player = new Node();
		
		football.addChild(competition);
		football.addChild(player);
		
		Node premiership = new Node();
		Node championsLeague= new Node();
		
		Node manCity = new Node();
		Node manUtd = new Node();
		Node liverpool = new Node();

		
		competition.addChild(premiership);
		competition.addChild(championsLeague);

		premiership.addChild(manCity);
		premiership.addChild(manUtd);

		championsLeague.addChild(liverpool);
		
		assertEquals(competition, football.lca(manUtd, liverpool));

	}

}

