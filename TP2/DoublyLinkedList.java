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
       for (int i = 0 ; i < index ;i++)
       {
    	temp = temp.getNext();   
       }
       return temp;
    }

    // Retourne l'élément à l'indice donné.
    // Complexité asymptotique: O(n)
    public AnyType getAt(int index) throws IndexOutOfBoundsException 
    {
    	if (index < 0 || index > size)
    	{
    		throw new IndexOutOfBoundsException();
    	}
        return getNodeAt(index).getValue();
    }

    // Retire l'élément à la fin de la liste.
    // Complexité asymptotique: O(1)
    public void popBack() throws EmptyListException 
    {
    	if (empty())
    	{
    		throw new EmptyListException();
    	}
    	
        if (size >= 2)
        {
        	Node<AnyType> temp = back.getPrev();
        	temp.setNext(null);
        	back.setPrev(null);
        	back = temp;                    // a voir
        }
        if (size <= 1)
        {
     	   front = null;
     	   back = null ;  	   
        }
        
        size--;
    }

    // Retire l'élément au début de la liste.
    // Complexité asymptotique: O(1)
    public void popFront() throws EmptyListException
    {
    	if (empty())
    	{
    		throw new EmptyListException();
    		
    	}
       if (size >= 2)
       {
    	   Node<AnyType> temp = front.getNext();
    	   temp.setPrev(null);
    	   front.setNext(null);
    	   front = temp;
    	   
       }
       if (size == 1)
       {
    	   front = null;
    	   back = null ;
       }
       
       size--;
    }

    // Retire l'élément à l'indice donné.
    // Complexité asymptotique: O(n)
    public void removeAt(int index) throws IndexOutOfBoundsException
    {
    
    	if (index < 0 || index > size )
    	{
    		
    		throw new IndexOutOfBoundsException();
    	}
    	Node<AnyType> objet = getNodeAt(index);
    	if (index == 0)
    	{
    		front = front.getNext();
    		objet.setNext(null);
    		front.setPrev(null);
    	}
    	else if (index == size)
    	{
    		back = back.getPrev();
    		objet.setPrev(null);
    		back.setNext(null);	
    	}
    	else 
    	{
    		objet.getPrev().setNext(objet.getNext());
    		objet.getNext().setPrev(objet.getPrev());
    	}
    	
    	size--;
    }

    // Ajoute un élément à la fin de la liste.
    // Complexité asymptotique: O(1)
    public void pushBack(AnyType item)
    {
		Node<AnyType> nouveauNode =  new Node (item, null ,null) ;
		if (size >= 1)
		{
		nouveauNode.setPrev(back);
		back.setNext(nouveauNode);
		back = nouveauNode;
		if (size == 1)
			{
				front.setNext(back);
			}
		}
		else 
		{ 
			back = nouveauNode;
			front = nouveauNode;
		}
		size++;
    }

    // Ajoute un élément au début de la liste.
    // Complexité asymptotique: O(1)
    public void pushFront(AnyType item)
    {
    	Node<AnyType> nouveauNode =  new Node (item, null ,null) ;
    	
    	if (size >= 1)
    	{
    	front.setPrev(nouveauNode);
    	nouveauNode.setNext(front);
    	front = nouveauNode;
    	if (size == 1)
    		{
    			back.setPrev(front);
    		}
    	
    	}
    	else
    	{
    		front = nouveauNode;
    		back = nouveauNode;
    	}
    	
    	size++;
    }

    // Ajoute un élément à l'indice donné.
    // Complexité asymtotique: O(n)
    public void insertAt(AnyType item, int index) throws IndexOutOfBoundsException
    {
    	if (index < 0 || index > size)
    	{
    		throw new IndexOutOfBoundsException();
    	}
    	Node<AnyType> temp = getNodeAt(index);
    	Node<AnyType> nouveauNode =  new Node (item, temp.getPrev() ,temp);
    	temp.setPrev(nouveauNode);
    	if (index > 0)
    	{
    		nouveauNode.getPrev().setNext(nouveauNode);
    	}
    	if (index ==  0)
    	{
    		front = nouveauNode;
    	}
    	
    	size++;
    }
}