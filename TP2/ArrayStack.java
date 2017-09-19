import java.util.EmptyStackException;

public class ArrayStack<AnyType>
{
    private static final int INITIAL_SIZE = 10;
    private static final int DEFAULT_RESIZE_FACTOR = 2;
	private static final AnyType[][] Anytype = null;
	private static final AnyType[][] Objet = null;

    private int size = 0; // Nombre d'éléments dans la pile.
    private AnyType[] table;

    // Initialisation de la pile.
    public ArrayStack()
    {
       table = (AnyType[]) new Object[INITIAL_SIZE];
    }

    // Enlève l'élément au sommet de la pile et le renvoie.
    // Complexité asymptotique: O(1)
    public AnyType pop() throws EmptyStackException
    {
    	AnyType temp =  table[0];
    	table[0] = null;
    	size--;
       return temp;
    }

    // Ajoute un élément au sommet de la pile.
    // Augmente la taille de la pile si nécessaire (utiliser la fonction resize définie plus bas).
    // Complexité asymptotique: O(1) (O(N) lorsqu'un redimensionnement est nécessaire)
    public void push(AnyType element)
    {
    	if (size == table.length )
    	{
    		resize(DEFAULT_RESIZE_FACTOR);
    	}
    	
        table[0] = element;
    	
    }

    // Renvoie l'élément au sommet de la pile sans l'enlever.
    // Retourne null si la pile est vide.
    // Complexité asymptotique: O(1)
    public AnyType peek()
    {
       return table[0];
    }

    // Renvoie le nombre d'éléments dans la pile.
    public int size() { return size; }

    // Indique si la pile est vide.
    public boolean empty() { return size == 0; }

    // Redimensionne la pile. La capacité est multipliée par un facteur de resizeFactor.
    // Complexité asymptotique: O(N)
    @SuppressWarnings("unchecked")
    private void resize(int resizeFactor)
    {
    	AnyType[] temp =  (AnyType[]) new Objet[resizeFactor*size];
        for (int i = 0; i< resizeFactor*size; i++ )
        {
        	temp[i] = table[i];
        }
        table = temp;
    }
}
