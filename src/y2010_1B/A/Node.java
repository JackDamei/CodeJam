package y2010_1B.A;

import java.util.ArrayList;

public class Node {

	public final String name;
	private ArrayList<Node> sons;
	
	public Node (String name) {
		this.name = name;
		this.sons = new ArrayList<Node>();
	}
	
	public int contains (String s) {
		for (int i=0; i<sons.size(); i++)
			if (sons.get(i).name.equals(s))
				return i;
		return -1;
	}
	
	public Node addSon (String s) {
		Node n = new Node(s);
		sons.add(n);
		return n;
	}
	
	public ArrayList<Node> getSons () {
		return sons;
	}
	
}
