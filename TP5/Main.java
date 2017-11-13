import java.util.ArrayList;

public class Main
{
	
public static void main(String[] args)
{
	testNode();
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

	System.out.println("********Test fusion impossible********");
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

	} catch(DifferentOrderTrees e) {System.out.println("Une fusion d'arbre d'ordre different: Test verifie!");}

	System.out.println("********Structure de l'arbre cree********");
	node1.print(" ");

	System.out.println("********Test recherche de la valeur 3 (present dans l'arbre)********");
	int integerExpected = 3;
	String comparedFound = (node1.findValue(3).getVal() == integerExpected ? "TROUVER": "PAS TROUVER");
	System.out.println(comparedFound);

	System.out.println("********Test recherche du node 23 (pas present dans l'arbre)******");
	String comparedNotFound = (node1.findValue(23) != null ? "TROUVER": "PAS TROUVER");
	System.out.println(comparedNotFound);

	// test pour getElementsSorted()
	System.out.println("********Test tris des elements********");
	ArrayList<Integer> arrayInteger= node1.getElementsSorted();
	int arrayToCreate[] = {1, 2, 3, 5, 7, 8, 9, 12};
	ArrayList<Integer> sortedArrayExpected = createArrayListInteger(arrayToCreate);
	String comparedArraySorted = (compareArrayInteger(sortedArrayExpected, arrayInteger) == true ? "SUCCES DU TRIS": "NON SUCCES DU TRIE");
	System.out.println(comparedArraySorted);

	/*for (int i=0; i < arrayInteger.size(); i++ )
		System.out.print(arrayInteger.get(i));
	System.out.println();*/
	// test pour delete()

	System.out.println("********Test delete du node7********");
	ArrayList<Node> array = node7.delete();
	ArrayList<Node> deletionArrayExpected = new ArrayList<Node>();
	deletionArrayExpected.add(new Node(8));
	deletionArrayExpected.add(new Node(5));
	deletionArrayExpected.add(new Node(3));
	String comparedArrayDeletion = (compareArrayNode(array, deletionArrayExpected) == true ? "DELETE REUSSI": "DELETE NON REUSSI");
	System.out.println(comparedArrayDeletion);

	/*for (int i=0; i < array.size(); i++ )
		  System.out.println(array.get(i).getVal());*/
}

public static void testMonceau()
{
	
	return ;
}

public static ArrayList<Integer> createArrayListInteger(int[] array) {
	ArrayList<Integer> arrayCreated = new ArrayList<Integer>();
	for(int i: array){
		arrayCreated.add(i);
	}
	return arrayCreated;
}

public static boolean compareArrayInteger(ArrayList<Integer> firstArray, ArrayList<Integer> secondArray) {
	if(firstArray.size() != secondArray.size())
		return false;
	else {
		for(int i = 0; i < firstArray.size(); i++) {
			if(firstArray.get(i) != secondArray.get(i))
				return false;
		}
	}
	return true;
}

public static boolean compareArrayNode(ArrayList<Node> firstArray, ArrayList<Node> secondArray){
	if(firstArray.size() != secondArray.size())
		return false;
	else {
		for(int i = 0; i < firstArray.size(); i++) {
			if(firstArray.get(i).getVal() != secondArray.get(i).getVal())
				return false;
		}
	}
	return true;
}

}