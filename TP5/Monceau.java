
import java.util.ArrayList;


public class Monceau {
    ArrayList<Node> arbres;

    public Monceau() {
        arbres = new ArrayList<Node>();
    }

    public void fusion(Monceau autre) {
        // à compléter
        ArrayList<Node> retenue = new ArrayList<Node>();
        int oMax = (this.ordreMax() > autre.ordreMax() ? this.ordreMax(): autre.ordreMax());

        for(int j = 0; j <= oMax || retenue.size() != 0; j++) {
        	ArrayList<Node> tmp = new ArrayList<Node>();
                arbreMemeOrdre(this.arbres, tmp, j);
                arbreMemeOrdre(autre.arbres, tmp, j);
                arbreMemeOrdre(retenue, tmp, j);
                remplirTableau(this.arbres, retenue, tmp);
            }
        }

    public void insert(int val) {
        // à compléter
        Node newNode = new Node(val);
        Monceau newMonceau = new Monceau();
        newMonceau.arbres.add(newNode);
        this.fusion(newMonceau);
    }

    public boolean delete (int val) {
        // à compléter
        for(Node i: this.arbres) {
            Node foundNode = i.findValue(val);
            if(foundNode != null) {
                i.delete();
                return true;
            }
        }
        return false;
    }

    public void print() {
        
        int count = 1;
        for(Node i: this.arbres) {
            System.out.println("Arbres: " + count++);
            i.print(" ");
        }
    }

    public void arbreMemeOrdre(ArrayList<Node> a, ArrayList<Node> tmp, int ordre) {
        if(a.size() != 0) {
        	ArrayList array = new ArrayList();
            for (Node i : a) {
                if (i.ordre == ordre)
                {
                    tmp.add(i);
                array.add(i);
                }
            }
            a.removeAll(array);
        }
    }

    public void remplirTableau(ArrayList<Node> arbresFinal, ArrayList<Node> retenue, ArrayList<Node> tmp) {
        if(tmp.size() == 1) {
            Node node1 = tmp.get(0);
            arbresFinal.add(node1);
        }
        if(tmp.size() == 2) {
            Node node1 = tmp.get(0);
            Node node2 = tmp.get(1);
            try {
            	if (node1.getVal() < node2.getVal())
            	{
                node1.fusion(node2);
            	retenue.add(node1);
            	}
            	else
            	{
            		node2.fusion(node1);
            		retenue.add(node2);
            	}
            	
            } catch (DifferentOrderTrees e) {};
            
        }
        if(tmp.size() == 3) {
            Node node1 = tmp.get(0);
            Node node2 = tmp.get(1);
            try {
            	if (node1.getVal() < node2.getVal())
            	{
                    node1.fusion(node2);
                    retenue.add(node1);
            	}
                	else
                	{
                		node2.fusion(node1);
                		node2.fusion(node2);
                	}
            } catch (DifferentOrderTrees e) {};
            arbresFinal.add(tmp.get(2));
        }
    }

    public int ordreMax() {
        int max = 0;
        for(Node i: this.arbres) {
            //System.out.println(i.ordre);
            if(i.ordre > max)
                max = i.ordre;
        }
        return max;
    }
}