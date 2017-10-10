package probleme1;

import java.util.Random;
import java.util.ArrayList;

public class LinearSpacePerfectHashing<AnyType>
{
	static int p = 46337;

	QuadraticSpacePerfectHashing<AnyType>[] data;
	int a, b , m;

	LinearSpacePerfectHashing()
	{
		a=b=0; data = null;
	}

	LinearSpacePerfectHashing(ArrayList<AnyType> array)
	{
		AllocateMemory(array);
	}

	public void SetArray(ArrayList<AnyType> array)
	{
		AllocateMemory(array);
	}

	@SuppressWarnings("unchecked")
	private void AllocateMemory(ArrayList<AnyType> array)
	{
		Random generator = new Random( System.nanoTime() );

		if(array == null || array.size() == 0)
		{
	
			return;
		}
		if(array.size() == 1)
		{
			a = b = 0;
			int key1 = getKey(array.get(0));
			int key2 = data[key1].getKey(array.get(0));
			data[key1].items[key2] = array.get(0);
			return;
		}
		
		if (array.size() > 1)
		{
			a = generator.nextInt(p);
			b = generator.nextInt(p);
			int key1;
			int key2;
			
			m = array.size();
			data  = new QuadraticSpacePerfectHashing[m];
			
			for (int i=0; i < m ; i++)
			{
				key1 = getKey(array.get(i));
			    key2 = data[key1].getKey(array.get(i));
				data[key1].items[key2] = array.get(i);
			}
			
		}
		
		
	}

	public int Size()
	{
		if( data == null ) return 0;

		int size = 0;
		for(int i=0; i<data.length; ++i)
		{
			size += (data[i] == null ? 1 : data[i].Size());
		}
		return size;
	}

	public boolean containsKey(int key)
	{
		return data[key].containsKey(key);

	}
	
	public int getKey (AnyType x) {
		
		// x.hashCode() suppose donner une valeur < p!
		return ((a*x.hashCode() + b)%p) % m;
		
	}
	
	public boolean containsValue (AnyType x) {
		int key = getKey(x);
		return data[key].containsValue(x);

	}
	
	public void remove (AnyType x) {
		int key = getKey(x);
		data[key].remove(x);
		
	}

	public String toString () {
		String result = "";
		
		for (int i=0; i < data.length; i++)
		{
			result.concat("["+ "clé_"+ i +"]" + " -> " + data[i].toString());
			
		}
		
		
		
		return result; 
	}

	public void makeEmpty () {
		for (int i=0 ; i<m; i++)
		{
			data[i].makeEmpty();
		}

   	}
	
}
