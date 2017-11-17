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
	Monceau monceau1 = new Monceau();
	Monceau monceau2 = new Monceau();
	monceau1.insert(2);
	monceau1.insert(0);
	monceau1.insert(1);
	monceau1.insert(4);
	monceau1.insert(6);
	monceau1.insert(8);
	monceau1.insert(10);
	monceau1.insert(12);
	monceau1.insert(14);
	monceau1.insert(16);
	monceau1.insert(18);
	monceau1.insert(20);
	monceau1.insert(22);
	monceau2.insert(3);
	monceau2.insert(5);
	monceau2.insert(7);
	monceau2.insert(9);
	monceau2.insert(11);
	monceau2.insert(13);
	monceau2.insert(15);
	monceau2.insert(17);
	monceau2.insert(19);
	monceau2.insert(21);
	monceau2.insert(23);
	monceau2.insert(25);
	monceau2.insert(24);
	monceau2.insert(26);
	monceau2.insert(27);
	monceau2.fusion(monceau1);
	monceau2.delete(24);
	monceau2.print();
	return ;
}

}