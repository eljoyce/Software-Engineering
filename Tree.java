package dag;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Tree <Node extends Comparable<Node>> {
	private List<Node> listParent;
	
	public List<Node> children;
	class Node {
		public Node() {
			listParent = new ArrayList<Node>();
			children = new ArrayList<Node>();
		}

	}
	private Node root;
	
	

	public void addChild(final Node child){
		children.add(child);
		if(!child.getListParent().contains(this)){
			child.addParent(this);
		}
	}

	public void addParent(final Node parent){
		listParent.add(parent);
		if(!parent.getChildren().contains(this)){
			parent.addChild(this);
		}
	}
	
	public List<Node> getListParent() {
		return Collections.unmodifiableList(listParent);
	}

	public List<Node> getChildren() {
		return Collections.unmodifiableList(children);
	}
	
	public Set<Node> getDescendent(){
		Set<Node> descendent = new HashSet<Node>();
		descendent.addAll(children);
		for (Node node : children) {
			descendent.addAll(node.getDescendent());
		}
		return descendent;
	}
	public List<Node> lca(Node node1, Node node2){
		return null;
	}
}
