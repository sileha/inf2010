import java.util.Random;
import java.util.ArrayList;

public class LinearSpacePerfectHashing<AnyType>
{
	static int p = 46337;

	QuadraticSpacePerfectHashing<AnyType>[] data;
	int a, b , m;

	/**
	 *  Constructeur par défaut
	 */
	LinearSpacePerfectHashing()
	{
		a=b=0; data = null;
	}

	/**
	 * Constructeur par paramètre.
	 * @param array: Le array avec lequel l'objet sera construit.
	 */
	LinearSpacePerfectHashing(ArrayList<AnyType> array)
	{
		AllocateMemory(array);
	}

	public void SetArray(ArrayList<AnyType> array)
	{
		AllocateMemory(array);
	}

	@SuppressWarnings("unchecked")
	/**
	 * Alloue la mémoire nécessaire pour le array qu'on lui passe.
	 * @param array: Le array dont la mémoire sera allouée
	 */
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
			m = array.size();
			ArrayList<AnyType> tableau = new ArrayList<AnyType>(m);
			data  = new QuadraticSpacePerfectHashing[m];
			
			for (int i=0; i < m ; i++)
			{
				for (int j = 0; j < array.size() ; j++)
				{
					key1 = getKey(array.get(j));
					if (key1 == i)
					{
						tableau.add(array.get(j));
					}
				}
				data[i] =  new QuadraticSpacePerfectHashing<AnyType>(tableau);
				
			}
			
		}
		
		
	}

	/**
	 * Retourne la taille (nombre d'élements) à l'intérieur de la table de hashage linéaire.
	 * @return size: La taille qui sera retournée.
	 */
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

	/**
	 * Détermine si une clé est déjà présente dans la table.
	 * @param key: La clé qu'on cherche.
	 * @return
	 */
	public boolean containsKey(int key)
	{
		return data[key].containsKey(key);

	}

	/**
	 * Retourne une clé calculé à partir de la valeur de hashcode de l'élément passé en param.
	 * @param x: L'élément dont la clé sera calculée.
	 * @return
	 */
	public int getKey (AnyType x) {
		
		// x.hashCode() suppose donner une valeur < p!
		return ((a*x.hashCode() + b)%p) % m;
		
	}

	/**
	 * Détermine si un élément se trouve à l'intérieur de la table de hashage.
	 * @param x: L'élément qu'on cherche à trouver.
	 * @return
	 */
	public boolean containsValue (AnyType x) {
		int key = getKey(x);
		return data[key].containsValue(x);

	}

	/**
	 * Retire un élément de la table de hashage.
	 * @param x: L'élément qu'on cherche à retirer de la table.
	 */
	public void remove (AnyType x) {
		int key = getKey(x);
		data[key].remove(x);
		
	}

	/**
	 * Permet d'afficher la table de hashage en entier.
	 * @return result: Les éléments de la table transformés en string.
	 */
	public String toString () {
		String result = "";
		
		for (int i=0; i < data.length; i++)
		{
			result.concat("["+ "cl�_"+ i +"]" + " -> " + data[i].toString());
			
		}
		return result; 
	}

	/**
	 * Vide la table de hashage de ses éléments.
	 */
	public void makeEmpty () {
		for (int i=0 ; i<m; i++)
		{
			data[i].makeEmpty();
		}

   	}
	
}
