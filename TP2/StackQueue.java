import java.util.Stack;

public class StackQueue<AnyType> implements Queue<AnyType>
{
	private int size = 0; // Nombre d'éléments dans la file.
	private Stack<AnyType> inStack =  new Stack<AnyType>();
	private Stack<AnyType> outStack =  new Stack<AnyType>();
   
	@SuppressWarnings("unchecked")
	public StackQueue() {}
	
	// Indique si la file est vide.
	public boolean empty() 
	{ 
		return size == 0; 
	}
	
	// Retourne la taille de la file.
	public int size() 
	{ 
		return size; 
	}

	/**
	 * Retourne l'élément du dessus de la file.
	 * @return L'élément contenu dans la seconde pile qui est sensé
	 * 		   être le premier élément de la file.
	 */
	public AnyType peek()
    {
    	/** Si la file est vide, retourne null */
        if (empty()) {
        	return null;
        }

        else {
        	outStack.push(inStack.firstElement()) ;
        	return outStack.peek();
        }
	}

	/**
	 * Retire le premier élément de la file.
	 * @throws EmptyQueueException
	 */
	public void pop() throws EmptyQueueException
	{
		/** Lance l'exception si la file est vide */
		if (empty()) {
			throw new EmptyQueueException()	;
		}
		inStack.remove(0);
		size--;
	}

	/**
	 * Ajoute un élément à l'intérieur de la file.
	 * @param item: L'élément qui sera ajouté.
	 */
	public void push(AnyType item)
	{
       inStack.push(item);
       size++;
	}
}

