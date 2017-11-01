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

    private Node<T> insert(Node<T> node, T elem)
    {
       if (node ==  null)
       {
    	   return new Node(elem);
       }
       int comparaison = elem.compareTo(node.val);
       if (comparaison < 0)
       {
    	   node.left = insert(node.left, elem);
    	   if (getHeight(node.left) - getHeight(node.right) == 2)
    	   {
    		   if (elem.compareTo(node.left.val) < 0)
    		   {
    			   node = balanceLeftLeft(node);
    		   }
    		   else 
    			   node = balanceLeftRight(node);
    	   }
       }
       else if (comparaison > 0)
       {
    	   node.right = insert(node.right, elem);
    	   if (getHeight(node.right) - getHeight(node.left) == 2)
    	   {
    		   if (elem.compareTo(node.right.val) > 0)
    		   {
    			   node = balanceRightRight(node);
    		   }
    		   else 
    			   node = balanceRightLeft(node) ; 
    	   }
       }
       else ;
       
       return node;
    }

    private Node<T> balanceRightRight(Node<T> node)
    {
       Node<T> temp = node.right;
       node.right = temp.left ;
       temp.left = node;
       return temp;
    }

    private Node<T> balanceRightLeft(Node<T> node)
    {
        node.right = balanceLeftLeft(node.right);
        return balanceRightRight(node);
    }

    private Node<T> balanceLeftLeft(Node<T> node)
    {
        Node<T> temp = node.left;
        node.left = temp.right;
        temp.right = node;
        return temp;
    }

    private Node<T> balanceLeftRight(Node<T> node)
    {
        node.left = balanceRightRight(node.left);
        return balanceLeftLeft(node);
    }
}