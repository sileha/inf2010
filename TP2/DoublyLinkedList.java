public class DoublyLinkedList<AnyType>
{
    // Un noeud de la liste.
    @SuppressWarnings("hiding")
    private class Node<AnyType>
    {
        private AnyType value;
        private Node prev;
        private Node next;

        public Node(AnyType value, Node prev, Node next)
        {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }

        public void setPrev(Node prev) { this.prev = prev; }

        public Node<AnyType> getPrev() { return this.prev; }

        public void setNext(Node next)
        {
            this.next = next;
        }

        public Node<AnyType> getNext()
        {
            return next;
        }

        public AnyType getValue()
        {
            return value;
        }

		public void remove() {
			// TODO Auto-generated method stub
			
		}
    }

    private int size = 0;		 // Nombre d'éléments dans la liste.
    private Node<AnyType> front; // Premier élément de la liste.
    private Node<AnyType> back;  // Dernier élément de la liste.

    // Indique si la liste est vide.
    public boolean empty()
    {
        return size == 0;
    }

    // Retourne la taille de la liste.
    public int size()
    {
        return size;
    }

    // Retourne l'élément à la fin de la liste.
    // Retourne null si la liste est vide.
    // Complexité asymptotique: O(1)
    public AnyType peekBack()
    {
    	if (empty())
    	{
    		return null;
    	}
       return back.getValue();
    }

    // Retourne l'élément au début de la liste.
    // Retourne null si la liste est vide.
    // Complexité asymptotique: O(1)
    public AnyType peekFront()
    {
    	if (empty())
    	{
    		return null;
    	}
       return front.getValue();
    }

    // Retourne le noeud à l'indice donné.
    // Complexité asymptotique: O(n)
    private Node<AnyType> getNodeAt(int index)
    {
    	Node<AnyType> temp = front;
       for (int i = 1; i<index ;i++)
       {
    	temp = temp.getNext();   
       }
       return temp;
    }

    // Retourne l'élément à l'indice donné.
    // Complexité asymptotique: O(n)
    public AnyType getAt(int index) throws IndexOutOfBoundsException // Question : est ce que on doit borner l'exception
    {
        return getNodeAt(index).getValue();
    }

    // Retire l'élément à la fin de la liste.
    // Complexité asymptotique: O(1)
    public void popBack() throws EmptyListException
    {
        if (size >= 2)
        {
        	back = back.getPrev();
        	back.setNext(null);
        	size--;
        }
        if (size == 1)
        {
     	   front = null;
     	   back = null ;
     	   size--;
        }
    }

    // Retire l'élément au début de la liste.
    // Complexité asymptotique: O(1)
    public void popFront() throws EmptyListException
    {
       if (size >= 2)
       {
    	   front = front.getNext();
    	   front.setPrev(null);
    	   size--;
       }
       if (size == 1)
       {
    	   front = null;
    	   back = null ;
    	   size--;
       }
       
    }

    // Retire l'élément à l'indice donné.
    // Complexité asymptotique: O(n)
    public void removeAt(int index) throws IndexOutOfBoundsException
    {
    
    	Node<AnyType> objet = getNodeAt(index);
    	objet.getPrev().setNext(objet.getNext());
    	objet.getNext().setPrev(objet.getPrev());
    }

    // Ajoute un élément à la fin de la liste.
    // Complexité asymptotique: O(1)
    public void pushBack(AnyType item)
    {
		Node<AnyType> nouveauNode =  new Node (item, back,null) ;
		back = nouveauNode;
		back.getPrev().setNext(back);
		size++;
    }

    // Ajoute un élément au début de la liste.
    // Complexité asymptotique: O(1)
    public void pushFront(AnyType item)
    {
    	Node<AnyType> nouveauNode =  new Node (item, null ,front) ;
    	front = nouveauNode ;
    	front.getNext().setPrev(front);
    	size++;
    }

    // Ajoute un élément à l'indice donné.
    // Complexité asymtotique: O(n)
    public void insertAt(AnyType item, int index) throws IndexOutOfBoundsException
    {
    	Node<AnyType> temp = getNodeAt(index);
    	Node<AnyType> nouveauNode =  new Node (item, temp.getPrev() ,temp);
    	temp.setPrev(nouveauNode);
    	size++;
    }
}