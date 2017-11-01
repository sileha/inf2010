import java.lang.Comparable;

public class AvlTree<T extends Comparable<T>> extends BST<T>
{
    public boolean isBalanced() { return isBalanced(root); }

    private boolean isBalanced(Node<T> node)
    {
        if (node == null) {
            return true;
        }

        boolean childsBalanced = isBalanced(node.left)
                              && isBalanced(node.right);

        int heightDiff = Math.abs(getHeight(node.left) - getHeight(node.right));

        return childsBalanced && heightDiff <= 1;
    }

    public void insert(T elem) { root = insert(root, elem); }

    /**
     * Méthode qui nous permet d'ajouter un élément à l'arbre AVL en s'assurant que
     * ce dernier soit balancé après chaque ajout.
     * @param node: Le sommet (node) à partir duquel on cherche à ajouter le nouvel
     *            élément et sur lequel on effectue la récursion.
     * @param elem: L'élément qu'on cherche à ajouter dans l'arbre.
     * @return Le nouveau sommet créé à partir de l'élément décrit ci-haut.
     */
   private Node<T> insert(Node<T> node, T elem)
    {
        // À compléter
        if(node == null)
            return new Node(elem);
        if(elem.compareTo(node.val) < 0) {
            node.left = insert(node.left, elem);
            if(Math.abs(getHeight(node.left) - getHeight(node.right)) == 2){
                if(elem.compareTo(node.left.val) < 0)
                    node = balanceLeftLeft(node);
                else
                    node = balanceLeftRight(node);
            }
        }
        if(elem.compareTo(node.val) > 0) {
            node.right = insert(node.right, elem);
            if(Math.abs(getHeight(node.left) - getHeight(node.right)) == 2) {
                if(elem.compareTo(node.right.val) > 0)
                    node = balanceRightRight(node);
                else
                    node = balanceRightLeft(node);
            }
        }
        return node;
    }

    /**
     * Méthode qui nous permet de balancer l'arbre en faisant une rotation simple
     * vers la droite.
     * @param node: Le sommet (node) déséquilibré.
     * @return Le sommet (node) rééquilibré.
     */
    private Node<T> balanceRightRight(Node<T> node)
    {
        // À compléter
        Node<T> nNode = node.right;
        node.right = nNode.left;
        nNode.left = node;

        return nNode;
    }

    /**
     * Méthode qui nous permet de balancer l'arbre en faisant une rotation double
     * droite-gauche.
     * @param node: Le sommet (node) déséquilibré.
     * @return Le sommet (node) rééquilibré.
     */
    private Node<T> balanceRightLeft(Node<T> node)
    {
        // À compléter
        node.right = balanceLeftLeft(node.right);
        return balanceRightRight(node);
    }

    /**
     * Méthode qui nous permet de balancer l'arbre en faisant une rotation simple
     * vers la droite.
     * @param node: Le sommet (node) déséquilibré.
     * @return Le sommet (node) rééquilibré.
     */
    private Node<T> balanceLeftLeft(Node<T> node)
    {
        // À compléter
        Node<T> nNode = node.left;
        node.left = nNode.right;
        nNode.right = node;

        return nNode;
    }

    /**
     * Méthode qui nous permet de balancer l'arbre en faisant une rotation double
     * gauche-droite.
     * @param node: Le sommet (node) déséquilibré.
     * @return Le sommet (node) rééquilibré.
     */
    private Node<T> balanceLeftRight(Node<T> node)
    {
        // À compléter
        node.left = balanceRightRight(node.left);
        return balanceLeftLeft(node);
    }
}