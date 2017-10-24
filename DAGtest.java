import org.junit.Assert;
import org.junit.Test;

public class DAGtest {

    
	@Test
    public void testAddChild(){
		Node football = new Node();
		Node competition = new Node();
		football.addChild(competition);
		Assert.assertEquals(competition, football.getChildren().get(0));
    }

	@Test
    public void testAddParent(){
		Node football = new Node();
		Node competition = new Node();
		competition.addParent(football);
		Assert.assertEquals(football, competition.getListParent().get(0));
    }
	
}