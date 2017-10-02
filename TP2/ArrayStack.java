import java.util.EmptyStackException;

public class ArrayStack<AnyType>
{
    private static final int INITIAL_SIZE = 10;
    private static final int DEFAULT_RESIZE_FACTOR = 2;
    private int size = 0; // Nombre d'éléments dans la pile.
    private AnyType[] table;

    /**
     * Construscteur. Initialise le tableau qui simule la pile.
     */
    public ArrayStack()
    {
       table = (AnyType[]) new Object[INITIAL_SIZE];
    }

    /**
     * Retire l'élément sur le dessus de la pile ou le dernier élément
     * a avoir été ajouté.
     */
    public AnyType pop() 
    {
    	if (empty()) {
    		throw new EmptyStackException();
    	}

    	AnyType temp =  table[size-1];
    	table[size-1] = null;
    	size--;
       return temp;
    }

    /**
     * Ajoute un élément sur le dessus de la pile.
     * @param element: L'élément qui sera ajouté sur le dessus de la
     *                 pile.
     */
    public void push(AnyType element)
    {
        /** Si la pile est pleine, on la redimensionne */
    	if (size == table.length ) {
    		resize(DEFAULT_RESIZE_FACTOR);
    	}
    	
        table[size++] = element;
    	
    }

    /**
     * Retourne l'élément du dessus de la pile.
     * @return table[ ] : l'élément du dessus de la pile qui sera
     *                    retourné.
     */
    public AnyType peek()
    {
        /** Si la pile est vide, retourne null */
    	if  (empty()) {
    	    return null;
    	}
       return table[size-1];
    }

    // Renvoie le nombre d'éléments dans la pile.
    public int size() { return size; }

    // Indique si la pile est vide.
    public boolean empty() { return size == 0; }

    /**
     * Retourne la même pile dont on a changé la taille.
     * @param resizeFactor: Le facteur d'agrangissement de la pile.
     */
    private void resize(int resizeFactor)
    {
    	AnyType[] temp =  (AnyType[]) new Object[resizeFactor*table.length];

        for (int i = 0; i < size; i++ ) {
        	temp[i] = table[i];
        }

        table = temp;
    }
}
