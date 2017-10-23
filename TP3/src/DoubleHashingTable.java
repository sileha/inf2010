
public class DoubleHashingTable<AnyType>
{
    /**
     * Construct the hash table.
     */
    public DoubleHashingTable( )
    {
        this( DEFAULT_TABLE_SIZE );
    }

    /**
     * Construct the hash table.
     * @param size the approximate initial size.
     */
    public DoubleHashingTable( int size )
    {
        allocateArray( size );
        makeEmpty( );
    }

    /**
     * Insert into the hash table. If the item is
     * already present, do nothing.
     * @param x the item to insert.
     */
    public void insert(AnyType x)
    {
            // Insert x as active
        int currentPos = findPos(x);
        if( isActive( currentPos ) )
            return;

        array[ currentPos ] = new HashEntry<AnyType>(x, true );

            // Rehash; see Section 5.5
        if( ++currentSize > array.length / 2 )
            rehash( );
    }

    /**
     * Expand the hash table.
     */
    private void rehash( )
    {
        HashEntry<AnyType> [ ] oldArray = array;

            // Create a new double-sized, empty table
        allocateArray( nextPrime( 2 * oldArray.length ) );
        currentSize = 0;

            // Copy table over
        for( int i = 0; i < oldArray.length; i++ )
            if( oldArray[ i ] != null && oldArray[ i ].isActive )
                insert( oldArray[ i ].element );
    }

    /**
     * Method that performs quadratic probing resolution.
     * @param x the item to search for.
     * @return the position where the search terminates.
     */
    private int findPos(AnyType x)
    {
        int currentPos = Hash1( x );

        while( array[ currentPos ] != null && !array[ currentPos ].element.equals( x ))
        {
        	currentPos = Hash2(currentPos, x);
        	
            if( currentPos >= array.length )
                currentPos -= array.length;
        }
        
        return currentPos;
    }
    
    /** Nombre d'occurence */
    public int nbreOccurence(AnyType x)
    {
    	
    	int temp = 0;
    	int currentPos = Hash1(x);
    	
    	while(array[ currentPos ] != null)
    	{
    		if (array[currentPos].element.equals( x ))
    			{
    				temp++;
    			}
    		currentPos = Hash2(currentPos, x);
    	}
    	return temp;
    }
    
    /** Deuxieme fonction de hachage */
    
    public int Hash2(int currentPos, AnyType x)
    {
    	int R = 0; 
    	int temp = array.length;
    	int compteur = 0;
    	for (int i = temp -1 ; i >= 1 ; i-- )
    	{
    		for (int j = 2; j < i; j++)
    		{
    			if ((i%j) == 0)
    				compteur++;
    		}
    		if (compteur == 0)
    		{
    			if (i == 1)
    			{
    				R = 2;
    				break;
    			}
    			
    			R = i ;
				break;
    		}
    		compteur = 0;
    	}
		currentPos +=  R - (x.hashCode()%R);
		
		return currentPos;
    }

    /**
     * Remove from the hash table.
     * @param x the item to remove.
     */
    public void remove(AnyType x)
    {
        int currentPos = findPos( x );
        if( isActive( currentPos ) )
            array[ currentPos ].isActive = false;
    }

    /**
     * Find an item in the hash table.
     * @param x the item to search for.
     * @return the matching item.
     */
    public boolean contains(AnyType x)
    {
        int currentPos = findPos( x );
        return isActive( currentPos );
    }

    /**
     * Return true if currentPos exists and is active.
     * @param currentPos the result of a call to findPos.
     * @return true if currentPos is active.
     */
    private boolean isActive( int currentPos )
    {
        return array[ currentPos ] != null && array[ currentPos ].isActive;
    }

    /**
     * Make the hash table logically empty.
     */
    public void makeEmpty( )
    {
        currentSize = 0;
        for( int i = 0; i < array.length; i++ )
            array[ i ] = null;
    }

    private int Hash1(AnyType x)
    {
        int hashVal = x.hashCode() ;

        hashVal %= array.length;
        if( hashVal < 0 )
            hashVal += array.length;

        return hashVal;
    }
    
    public AnyType get(AnyType x)
    {
    	
    return array[findPos(x)].element ;
    }
    
    public int nbElement()
    {
    	return currentSize;
    }
    
    private static class HashEntry<AnyType>
    {
        public AnyType  element;   // the element
        public boolean isActive;  // false if marked deleted

        public HashEntry( AnyType e )
        {
            this( e, true );
        }

        public HashEntry( AnyType e, boolean i )
        {
            element  = e;
            isActive = i;
        }
    }

    private static final int DEFAULT_TABLE_SIZE = 11;

    private HashEntry<AnyType> [ ] array; // The array of elements
    private int currentSize;              // The number of occupied cells

    /**
     * Internal method to allocate array.
     * @param arraySize the size of the array.
     */
    private void allocateArray( int arraySize )
    {
        array = new HashEntry[ nextPrime( arraySize ) ];
    }

    /**
     * Internal method to find a prime number at least as large as n.
     * @param n the starting number (must be positive).
     * @return a prime number larger than or equal to n.
     */
    private static int nextPrime( int n )
    {
        if( n % 2 == 0 )
            n++;

        for( ; !isPrime( n ); n += 2 )
            ;

        return n;
    }

    /**
     * Internal method to test if a number is prime.
     * Not an efficient algorithm.
     * @param n the number to test.
     * @return the result of the test.
     */
    private static boolean isPrime( int n )
    {
        if( n == 2 || n == 3 )
            return true;

        if( n == 1 || n % 2 == 0 )
            return false;

        for( int i = 3; i * i <= n; i += 2 )
            if( n % i == 0 )
                return false;

        return true;
    }
}