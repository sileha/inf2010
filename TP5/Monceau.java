
import java.util.ArrayList;


public class Monceau {
    ArrayList<Node> arbres;

    public Monceau() {
        arbres = new ArrayList<Node>();
    }

    public void fusion(Monceau autre) {
        // à compléter
        ArrayList<Node> retenue = new ArrayList<Node>();
        int ordreMax = (this.ordreMax() > autre.ordreMax() ? this.ordreMax(): autre.ordreMax());

        for(int j = 0; j < ordreMax; j++) {
            Node node1[] = arbreMemeOrdre(this.arbres, j);
            Node node2[] = arbreMemeOrdre(autre.arbres, j);
            Node node3[] = new Node[ordreMax];

            if(retenue.size() != 0)
                node3 = arbreMemeOrdre(retenue, j);

            remplirTableau(arbres, retenue, node1);
            remplirTableau(arbres, retenue, node2);
            remplirTableau(arbres, retenue, node3);
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
            if(foundNode != null)
                return true;
        }
        return false;
    }

    public void print() {
        // à compléter
        for(Node i: this.arbres)
            i.print(" ");
    }

    public Node[] arbreMemeOrdre(ArrayList<Node> a, int ordre) {
        Node array[] = new Node[];
        int counter = 0;
        for(Node i: a) {
            if(i.ordre == ordre)
                array[counter++] = i;
        }
        return array;
    }

    public void remplirTableau(ArrayList<Node> arbres, ArrayList<Node> arbresTmp, Node node[]) {
        if (node.length == 1) {
            arbres.add(node[0]);
        } else if (node.length == 2) {
            try {
                node[0].fusion(node[1]);
            } catch (DifferentOrderTrees e) {};
            arbresTmp.add(node[0]);
        } else if(node.length == 3) {
            try {
                node[0].fusion(node[1]);
            } catch (DifferentOrderTrees e) {};
            arbres.add(node[0]);
            arbresTmp.add(node[2]);
        }
    }

    public int ordreMax() {
        int max = 0;
        for(Node i: this.arbres) {
            if(i.getVal() > max)
                max = i.getVal();
        }
        return max;
    }
}