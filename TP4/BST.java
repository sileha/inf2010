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

	private void traversePreOrder(Node<T> node, ArrayList<T> list)
	{
		if ( node != null)
		{
        list.add(node.val);
        traversePreOrder(node.left, list);
        traversePreOrder(node.right, list);
		}
	}

    public ArrayList<T> traversePostOrder()
	{
		ArrayList<T> list = new ArrayList<T>();
		traversePostOrder(root, list);
		return list;
	}

	private void traversePostOrder(Node<T> node, ArrayList<T> list)
	{
		if ( node != null)
		{
			traversePostOrder(node.left, list);		
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

    private void traverseInOrder(Node<T> node, ArrayList<T> list)
    {
    	if (node != null)
    	{
    	traverseInOrder(node.left, list);
    	list.add(node.val);
    	traverseInOrder(node.right, list);
    	}
    }

    public ArrayList<T> traverseReverseOrder()
    {
        ArrayList<T> list = new ArrayList<T>();
        traverseReverseOrder(root, list);
        return list;
    }

    private void traverseReverseOrder(Node<T> node, ArrayList<T> list)
    {
    	if (node != null)
    	{
    	traverseReverseOrder(node.right, list);
    	list.add(node.val);
    	traverseReverseOrder(node.left, list);
    	}
    	
    }

    public ArrayList<T> traverseLevelOrder()
	{
		ArrayList<T> list = new ArrayList<T>();
        Queue<Node<T>> queue = new LinkedList<Node<T>>();
        Node<T> node = root;
        queue.add(node);
        while (!queue.isEmpty()) 
        {
        	
        	list.add(queue.poll().val);    
        	queue.add(node.left);
        	queue.add(node.right);
       
        }
        
		return list;
	}
}

