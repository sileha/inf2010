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

	/**
	 * Retourne l'élément situé à la fin de la pile.
	 * @return back: L'élément à la fin de la pile.
	 */
	public AnyType peekBack()
    {
    	/** Si la pile est vide, retourne null */
    	if (empty()) {
    		return null;
    	}
       return back.getValue();
    }

	/**
	 * Retourne l'élément situé au début de la pile.
	 * @return front: L'élément au début de la pile.
	 */
    public AnyType peekFront()
    {
    	/** Si la pile est vide, retourne null */
    	if (empty()) {
    		return null;
    	}
       return front.getValue();
    }

	/**
	 * Retourne le noeud à l'index spécifié.
	 * @param index: L'index du noeud que l'on désire retourner.
	 * @return temp: Le noeud que l'on retourne.
	 */
	private Node<AnyType> getNodeAt(int index)
    {
    	Node<AnyType> temp = front;

       for (int i = 0 ; i < index ;i++) {
    	temp = temp.getNext();   
       }
       return temp;
    }

	/**
	 * Retourne la valeur stocké à l'intérieur du noeud à l'index spécifié.
	 * @param index: L'index du noeud voulu.
	 * @return La valeur du noeud à l'index.
	 * @throws IndexOutOfBoundsException
	 */
    public AnyType getAt(int index) throws IndexOutOfBoundsException 
    {
    	/** Lance une exception si l'index est négatif ou plus petit que la taille de la liste */
    	if (index < 0 || index > size) {
    		throw new IndexOutOfBoundsException();
    	}
        return getNodeAt(index).getValue();
    }

	/**
	 * Retire l'élément à la fin de la liste.
	 * @throws EmptyListException
	 */
	public void popBack() throws EmptyListException
    {
    	/** Si la liste est vide, lance l'exception */
    	if (empty()) {
    		throw new EmptyListException();
    	}
    	
        if (size >= 2)
        {
        	Node<AnyType> temp = back.getPrev();
        	temp.setNext(null);
        	back.setPrev(null);
        	back = temp;
        }
        if (size <= 1)
        {
     	   front = null;
     	   back = null ;  	   
        }
        
        size--;
    }

	/**
	 * Retire l'élément au début de la lsite.
	 * @throws EmptyListException
	 */
	public void popFront() throws EmptyListException
    {
    	/** Si la pile est vide, lance l'exception */
    	if (empty()) {
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

	/**
	 * Retire l'élément situé à l'index spécifié.
	 * @param index: L'index de l'élément à retirer.
	 * @throws IndexOutOfBoundsException
	 */
	public void removeAt(int index) throws IndexOutOfBoundsException
    {
    	/** Lance l'exception si l'index est négatif ou plus grand que la taille de la liste */
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

	/**
	 * Ajoute un élément à la fin de la liste.
	 * @param item: L'élément qui sera ajouté.
	 */
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

	/**
	 * Ajoute un élément au début de la liste.
	 * @param item: L'élément qui sera ajouté.
	 */
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

	/**
	 * Ajoute un élément à l'index spécifié.
	 * @param item: L'élément qui sera ajouté.
	 * @param index: L'index ou l'élément sera ajouté.
	 * @throws IndexOutOfBoundsException
	 */
    public void insertAt(AnyType item, int index) throws IndexOutOfBoundsException
    {
    	/** Lance l'exception si l'index est négatif ou plus grand que la taille de la liste */
    	if (index < 0 || index > size) {
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