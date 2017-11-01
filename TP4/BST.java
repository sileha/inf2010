import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.lang.Comparable;
import java.lang.Math;

public class BST<T extends Comparable<T>>
{
    protected class Node<T>
    {
        T val; // Valeur du noeud
        Node<T> right; // fils droite
        Node<T> left; // fils gauche

        public Node(T val)
        {
            this.val = val;
        }
    }

    protected Node<T> root = null; // Racine de l'arbre

    public boolean isValid() { return isValid(root); }

    private boolean isValid(Node<T> node)
    {
        if (node == null) {
            return true;
        }
        boolean isLeftValid = node.left == null || node.left.val.compareTo(node.val) < 0 && isValid(node.left);
        boolean isRightValid = node.right == null || node.right.val.compareTo(node.val) > 0 && isValid(node.right);
        return isLeftValid && isRightValid;
    }

    public int getHeight() { return root == null ? 0 : getHeight(root); }

    /**
     * Méthode qui nous permet d'obtenir la hauteur de l'arbre en entier par récursion.
     * @param node: Le somment courrant ou actif sur lequel on effectue la récursion.
     * @return la hauteur
     */
    protected int getHeight(Node<T> node)
    {
        if (node == null)
        {
            return -1;
        }
        else
        {
            return 1 + Math.max(getHeight(node.left), getHeight(node.right));
        }
    }

    public void insert(T elem) { root = insert(root, elem); }

    /**
     * Méthode qui nous permet d'insérer un élément dans l'arbre par récursion.
     * @param node: Le sommet courrant ou actif sur lequel on effectue la récursion.
     * @param elem: L'élément avec lequel le nouveau somment (node) sera créée.
     * @return Le node ajouté.
     */
    private Node<T> insert(Node<T> node, T elem)
    {
        if (node == null)
        {
            return new Node(elem);
        }


        if (elem.compareTo(node.val) < 0)
        {
            node.left = insert(node.left, elem);
        }
        else if (elem.compareTo(node.val) > 0)
        {
            node.right = insert(node.right, elem);
        }

        else ;

        return node;

    }

    public boolean contains(T elem) { return contains(root, elem); }

    /**
     * Méthode qui nous permet de déterminer de déterminer si un élément se trouve
     * parmi les sommets (nodes).
     * @param node: Le sommet (node) courant sur lequel on effectue la récursion.
     * @param elem: L'élément qu'on cherche à déteerminer la présence dans l'arbre.
     * @return true, si l'élément se trouve dans l'arbre, false sinon
     */
    private boolean contains(Node<T> node, T elem)
    {
        if (node == null)
        {
            return false;
        }

        if (elem.compareTo(node.val) < 0)
        {
            return contains(node.left, elem);
        }
        else if(elem.compareTo(node.val) > 0)
        {
            return contains(node.right, elem);
        }
        else  { return true ;}


    }

    public ArrayList<T> traversePreOrder()
    {
        ArrayList<T> list = new ArrayList<T>();
        traversePreOrder(root, list);
        return list;
    }

    /**
     * Méthode qui effectue le parcours préordre de l'arbre.
     * @param node: Le sommet (node) à partir duquel on débute le parcours et
     *            sur lequel on effectue la récursion par la suite.
     * @param list: La liste à laquelle on ajoute la valeur de chaque sommet
     *            pour pouvoir afficher le parcours préordre de l'arbre.
     */
    private void traversePreOrder(Node<T> node, ArrayList<T> list)
    {
        // À compléter
        if(node != null) {
            list.add(node.val);

            if (node.left != null)
                traversePreOrder(node.left, list);

            if (node.right != null)
                traversePreOrder(node.right, list);
        }
    }

    public ArrayList<T> traversePostOrder()
    {
        ArrayList<T> list = new ArrayList<T>();
        traversePostOrder(root, list);
        return list;
    }

    /**
     * Méthode qui effectue le parcours postordre de l'arbre.
     * @param node: Le sommet (node) à partir duquel on débute le parcours et
     *            sur lequel on effectue la récursion par la suite.
     * @param list: La liste à laquelle on ajoute la valeur de chaque sommet
     *            pour pouvoir afficher le parcours postordre de l'arbre.
     */
    private void traversePostOrder(Node<T> node, ArrayList<T> list) {
        // À compléter
        if(node != null) {
            if (node.left != null)
                traversePostOrder(node.left, list);

            if (node.right != null)
                traversePostOrder(node.right, list);

            list.add(node.val);
        }
    }
    public ArrayList<T> traverseInOrder()
    {
        ArrayList<T> list = new ArrayList<T>();
        traverseInOrder(root, list);
        return list;
    }

    /**
     * Méthode qui effectue le parcours en ordre de l'arbre.
     * @param node: Le sommet (node) à partir duquel on débute le parcours et
     *            sur lequel on effectue la récursion par la suite.
     * @param list: La liste à laquelle on ajoute la valeur de chaque sommet
     *            pour pouvoir afficher le parcours en ordre de l'arbre.
     */
    private void traverseInOrder(Node<T> node, ArrayList<T> list)
    {
        // À compléter
        if(node != null) {
            if (node.left != null)
                traverseInOrder(node.left, list);

            list.add(node.val);

            if (node.right != null)
                traverseInOrder(node.right, list);
        }
    }

    public ArrayList<T> traverseReverseOrder()
    {
        ArrayList<T> list = new ArrayList<T>();
        traverseReverseOrder(root, list);
        return list;
    }

    /**
     * Methode qui effectue le parcours en ordre inverse de l'arbre.
     * @param node: Le sommet (node) à partir duquel on début le parcours et
     *            sur lequel on effectue la récursion par la suite.
     * @param list: La liste à laquelle on ajoute la valeur de chaque sommet
     *            pour pouvoir afficher le parcours en ordre inverse de l'arbre.
     */
    private void traverseReverseOrder(Node<T> node, ArrayList<T> list)
    {
        // À compléter
        if(node != null) {
            if (node.right != null)
                traverseReverseOrder(node.right, list);

            list.add(node.val);

            if (node.left != null)
                traverseReverseOrder(node.left, list);
        }
    }

    /**
     * Methode qui effectue le parcours par niveau de l'arbre.
     * @return la liste contenant le parcours par niveau de l'arbre.
     */
    public ArrayList<T> traverseLevelOrder()
    {
        ArrayList<T> list = new ArrayList<T>();
        Queue<Node<T>> queue = new LinkedList<Node<T>>();
        Node<T> rNode = root;
        queue.add(rNode);

        while (!queue.isEmpty()) {

            Node<T> tNode = queue.remove();
            if (tNode != null) {
                list.add(tNode.val);

                if (tNode.left != null)
                    queue.add(tNode.left);
                if (tNode.right != null)
                    queue.add(tNode.right);
            }
        }

        return list;

    }
}

