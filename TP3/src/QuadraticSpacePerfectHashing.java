import java.util.ArrayList;
import java.util.Random;

public class QuadraticSpacePerfectHashing<AnyType> 
{
	static int p = 46337;

	int a, b, m;
	AnyType[] items;

	/**
	 * Constructeur par défaut
	 */
	QuadraticSpacePerfectHashing()
	{
		a=b=0; items = null;
	}

	/**
	 * Constructeur par paramètre.
	 * @param array: Array qu'on lui passe pour construire l'objet.
	 */
	QuadraticSpacePerfectHashing(ArrayList<AnyType> array)
	{
		AllocateMemory(array);
	}

	public void SetArray(ArrayList<AnyType> array)
	{
		AllocateMemory(array);
	}

	/**
	 * Retourne la taille (nombre d'éléments) de la table de hashage.
	 * @return
	 */
	public int Size()
	{
		if( items == null ) return 0;

		return items.length;
	}

	/**
	 * Détermine si une clé est présente dans la table de hashage.
	 * @param key: La clé qu'on cherche à trouver.
	 * @return true/false: True si la clé y est, false sinon.
	 */
	public boolean containsKey(int key)
	{
		// A completer            voir est ce il ya un element a ce key 
		if (items[key] == null )
		{
			return false;
		}
		return true;
	}

	/**
	 * Détermine si un élément se trouve dans la table de hashage.
	 * @param x: L'élément qu'on cherche à trouver.
	 * @return true/false: True si l'élément y est, false sinon.
	 */
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

	/**
	 * Retire un élément de la table de hashage.
	 * @param x: L'élément qu'on cherche à retirer.
	 */
	public void remove (AnyType x) {
		// A completer
		items[getKey(x)] = null;

	}

	/**
	 * Retourne la clé calculée à partir de la valeur de hashcode de l'élément qu'on lui passe.
	 * @param x: L'élément dont la clé est calculée.
	 * @return
	 */
	public int getKey (AnyType x) {
		return ( ( a*(x).hashCode() + b ) % p ) % m;
	}

	@SuppressWarnings("unchecked")
	/**
	 * Alloue la mémoire nécessaire pour le array qu'on lui passe.
	 * @param array: Le array dont la mémoire sera allouée.
	 */
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

	/**
	 * Permet d'afficher les éléments de la table de hashage.
	 * @return result: Les éléments de la table transformés en string.
	 */
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

	/**
	 * Vide la table de hashage de ses éléments.
	 */
	public void makeEmpty () {
		   for (int i = 0; i<items.length; i++)
		   {
			   items[i] = null ;
		   }
   	}
}
