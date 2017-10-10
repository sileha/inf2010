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
		int key =  getKey(x);
		if (items[key] != null && items[key].equals(x))
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
			
			boolean tableauRemplieSansCollision = true;
			
			while (tableauRemplieSansCollision)
				{
				a = generator.nextInt(p);
				b = generator.nextInt(p);
				
					for (int i=0; i<array.size() ;i++)
						{
						int key = getKey(array.get(i));
							if (!containsKey(key))
								{
									items[key] = array.get(i);
									if (i == array.size()-1)
									{
										tableauRemplieSansCollision = false;
									}
					
								}
							else if (!containsValue(array.get(i)))
								{
									makeEmpty();
									break;
								}
							
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
