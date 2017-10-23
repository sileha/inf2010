import java.util.ArrayList;
import java.util.Random;

public class HashFunctions 
{
   static int p = 46337;
   
   public static void main(String[] args) 
   {
      // Donnees brutes
	  Integer[] array = { 103,  75,  64,  25,  36, 101,  110,  92,
	                     200, 175, 164, 125, 136, 201, 111, 192,
	                     300, 275, 264, 225, 236, 301, 311, 292};
      
      // Les donnees sont inserees dans un ArrayList
      ArrayList<Integer> al = new ArrayList<Integer>(array.length);
      
      for(Integer item : array) al.add( item );
      
      /**
       * Exercice 1
       */
      // On cree un QuadraticSpacePerfectHashing et insere les donnees
      System.out.println( "QuadraticSpacePerfectHashing:");
      System.out.println();
      
      QuadraticSpacePerfectHashing<Integer> e = new QuadraticSpacePerfectHashing<Integer>( al ); 
      
      // Verifie les proprietes d'occupation d'espace
      System.out.println( "Number of elements: " + al.size() );
      System.out.println( "Size: " + e.Size() );
      System.out.println();
      
      // Verifie qu'il fonctionne comme prevu
      System.out.println( 100 + " est present: " + e.containsValue(100) );
      System.out.println(  99 + " est present: " + e.containsValue( 99) );
      System.out.println( 200 + " est present: " + e.containsValue(200) );
      System.out.println( 199 + " est present: " + e.containsValue(199) );
      System.out.println( 300 + " est present: " + e.containsValue(300) );
      System.out.println( 299 + " est present: " + e.containsValue(299) );
      System.out.println();

      /**
       * Exercice 2
       */

      // On cree un LinearSpacePerfectHashing et insere les memes donnees
      System.out.println( "LinearSpacePerfectHashing:");
      System.out.println();
      
      LinearSpacePerfectHashing<Integer> pfhash = new LinearSpacePerfectHashing<Integer>( al );
      
      // Verifie les proprietes d'occupation d'espace
      System.out.println( "Number of elements: " + al.size() );
      System.out.println( "Size: " + pfhash.Size() );
      System.out.println();
      
      // Verifie qu'il fonctionne comme prevu
      System.out.println( 100 + " est present: " + pfhash.containsValue(100) );
      System.out.println(  99 + " est present: " + pfhash.containsValue( 99) );
      System.out.println( 200 + " est present: " + pfhash.containsValue(200) );
      System.out.println( 199 + " est present: " + pfhash.containsValue(199) );
      System.out.println( 300 + " est present: " + pfhash.containsValue(300) );
      System.out.println( 299 + " est present: " + pfhash.containsValue(299) );
      System.out.println();
      /**
       * Question 1 (confirmation des resultats de Exercice 2) 
       */
      // Effectues quelques tests aleatoires pour verifier les proprietes de taille
      pfhash = new LinearSpacePerfectHashing<Integer>();
      System.out.println("Tests aleatoires");
      
      for(int i=0, nbElements = 10; i<40; ++i, nbElements += 10)
      {
         pfhash.SetArray( randomIntegers( nbElements ) );			
         System.out.println( nbElements + "\t" + pfhash.Size() );
      }
   }
   
   /**
    * Question 1
    */
   public static ArrayList<Integer> randomIntegers(int length)
   {
	   Random generator = new Random(System.nanoTime());
	      ArrayList<Integer> array = new ArrayList(length + 1);

	      /**Remplir le tableau en premier */
	      for (int i = 0; i < length; i++) {
	         int toAdd = generator.nextInt(p);
	         array.add(toAdd);
	      }

	      /** Verifier si il y a doublons */
	      verifierDoublons(array);

	      return array;
   }

/**
 * Méthode globale qui vérifie la présence de doublons dans un array générer de façon aléatoire.
 * @param al: ArrayList qu'on passe à la fonction et qui sera remplie de chiffres aléatoires.
*/
public static void verifierDoublons(ArrayList<Integer> al) {
    Random generator = new Random(System.nanoTime());
    for (int i = 0; i < al.size(); i++) {
       for (int j = i + 1; j < al.size() - i; j++) {
          if (al.get(i).equals(al.get(j)))
             al.add(i, generator.nextInt(p));}
       }
    }
 }


