package probleme1;

import java.util.ArrayList;
import java.util.Random;

public class QuadraticSpacePerfectHashing<AnyType> 
{
	static int p = 46337;

	int a, b, m;
	AnyType[] items;

	QuadraticSpacePerfectHashing()
	{
		a=b=0; items = null;
	}

	QuadraticSpacePerfectHashing(ArrayList<AnyType> array)
	{
		AllocateMemory(array);
	}

	public void SetArray(ArrayList<AnyType> array)
	{
		AllocateMemory(array);
	}

	public int Size()
	{
		if( items == null ) return 0;

		return items.length;
	}

	public boolean containsKey(int key)
	{
		// A completer            voir est ce il ya un element a ce key 
		if (items[key] == null )
		{
			return false;
		}
		return true;
	}

	public boolean containsValue(AnyType x )
	{
		// A completer
		
		if (items[getKey(x)].equals(x))
		{
			return true;
		}
		return false;
		// on doit verifier que la valeur est la meme celle de x et la valeur dans le tableau en key x

	}

	public void remove (AnyType x) {
		// A completer
		items[getKey(x)] = null;

	}

	public int getKey (AnyType x) {
		
		
		return ( ( a*(x).hashCode() + b ) % p ) % m;
	}

	@SuppressWarnings("unchecked")
	private void AllocateMemory(ArrayList<AnyType> array)
	{
		Random generator = new Random( System.nanoTime() );
		m = (int) Math.pow(array.size(), 2);
		items = (AnyType[]) new Object[m];
		
		
		if(array == null || array.size() == 0)
		{
			
			return;
		}
		if(array.size() == 1)
		{
			a = b = 0;

			items[getKey(array.get(0))]	= array.get(0);
			return;
		}
		
		if (array.size() > 1)
		{
			a = generator.nextInt(p);
			b = generator.nextInt(p);
			boolean tableauRemplieSansCollision = true;
			
			while (tableauRemplieSansCollision)
				{
				
					for (int i=0; i<array.size() ;i++)
						{
				
							if (!containsKey(getKey(array.get(i))))
								{
									items[getKey(array.get(i))] = array.get(i);
					
								}
							else if (!containsValue(array.get(i)))
								{
									tableauRemplieSansCollision = false;
									makeEmpty();
									break;
								}
							//else {remove(array.get(i));}
						}
				}
		}
	}

	
	
	public String toString () {
		String result = "";
		for (int i=0; i<items.length; i++)
		{
			if (!items[i].equals(null))
			{
				result.concat( ", (" + getKey(items[i]) + ","+ items[i] + ")");
			}
			
		}
		return result; 
	}

	public void makeEmpty () {
		   for (int i = 0; i<items.length; i++)
		   {
			   items[i] = null ;
		   }
   	}
}
