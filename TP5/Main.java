import java.util.ArrayList;


public class Main
{
	
public static void main(String[] args)
{
	testNode();
	testMonceau();
	
}

public static void testNode()
{
	
	Node node1 = new Node(1);
	Node node2 = new Node(7);
	Node node3 = new Node(2);
	Node node4 = new Node(5);
	Node node5 = new Node(6);
	Node node6 = new Node(3);
	Node node7 = new Node(8);
	try
	{
		node1.fusion(node3);
		node2.fusion(node4);
		node1.fusion(node4);
		node5.fusion(new Node(11));
		node6.fusion(new Node(12));
		node7.fusion(new Node(9));
		node7.fusion(node6);
		node1.fusion(node6);
		node1.fusion(node5);
		
	}
	catch(DifferentOrderTrees e) {System.out.println("une fusion d'arbre d'ordre different, test verifie!");}
	System.out.println(node1.findValue(8));
	
	// test pour getElementsSorted()
	ArrayList<Integer> arrayInteger= node1.getElementsSorted();
	for (int i=0; i < arrayInteger.size(); i++ )
		System.out.println(arrayInteger.get(i));
	
	// test pour delete()
	ArrayList<Node> array = node7.delete();
		for (int i=0; i < array.size(); i++ )
		  System.out.println(array.get(i).getVal());
		
}

public static void testMonceau()
{
	
	return ;
}

}