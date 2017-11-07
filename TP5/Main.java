public class Main
{
	
public static void main(String[] args)
{
	testNode();
	testMonceau();
	
}

public static void testNode()
{
	Integer[] array1 = new Integer[] {2, 4, 5, 13, 23, 12, 15, 11, 14, 17, 22};
	Integer[] array2 = new Integer[] {16, 18, 3, 21, 22, 6, 7, 8, 9, 10, 13 };
	Node node1 = new Node(1);
	Node node2 = new Node(7);
	for (int val: array1)
	{
		node1.addEnfant(new Node(val));
	}
	for (int val : array2)
	{
		node2.addEnfant(new Node(val));
	}
	
	node1.findValue(22);
	try
	{node1.fusion(node2);}
			catch(DifferentOrderTrees e) {System.out.println("une fusion d'arbre d'ordre different");}
	node1.getElementsSorted();
	node1.delete();
	
	
}

public static void testMonceau()
{
	
	
}

}