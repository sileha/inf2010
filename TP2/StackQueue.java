import java.util.Stack;

public class StackQueue<AnyType> implements Queue<AnyType>
{
	private int size = 0; // Nombre d'éléments dans la file.
	private Stack<AnyType> inStack =  new Stack<AnyType>();
	private Stack<AnyType> outStack =  new Stack<AnyType>();
   
	@SuppressWarnings("unchecked")
	public StackQueue()
	{
       
	}
	
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
	
	// Retourne l'élément en tête de file.
	// Retourne null si la file est vide.
	// Complexité asymptotique: O(1) (ammorti)
	public AnyType peek()
    {
        if (empty())
        {
        	return null;
        }
        
        else 
        {
        	outStack.push(inStack.firstElement()) ;
        	return outStack.peek();
        }
	}
	
	// Retire l'élément en tête de file.
	// Complexité asymptotique: O(1) (ammorti)
	public void pop() throws EmptyQueueException
	{
		if (empty())
		{
			throw new EmptyQueueException()	;
		}
		inStack.remove(0);
		size--;
	}
	
	// Ajoute un élément a la fin de la file.
	// Complexité asymptotique: O(1)
	public void push(AnyType item)
	{
       inStack.push(item);
       size++;
	}
}

