/**
 * Fichier principal pour l'exercice
 * @author : 
 * @date : 
 */

import java.util.Scanner;
import java.util.Random;

public class FormValidator
{
	static final double RADIAN_10DEGREE = 0.174532925;
	static final double RADIAN_15DEGREE = 0.261799388;
	static final double RADIAN_20DEGREE = 0.34906585;

	/**
	 * Fonction principale
	 * @param args (non utilise)
	 */
	public static void main(String[] args) 
	{
		// Longueur du code
		final int codeLength = 5;
		
		// Generation du code
		String code = generateCode( codeLength );
		if( code == null ) return;
		
		// Generation des transformations a appliquer
		int[] transform = generateTransform( codeLength );
		if( transform == null ) return;
		
		// Lecture des images correspondant aux codes et tranformations 
		PixelMapPlus[] pm =  new PixelMapPlus[ codeLength ];
		for(int i=0; i<codeLength; i++)
		{
			String letter = code.substring(i, i+1);
			String fileName = "./src/alphabet/" + letter + ".ppm";
			pm[ i ] = new PixelMapPlus( fileName ); 
			
			switch( transform[i] )
			{
				case 1: 
					pm[i].rotate( pm[i].width/2, pm[i].height/2, RADIAN_10DEGREE); 
					break;
				case 2: 
					pm[i].rotate( pm[i].width/2, pm[i].height/2, -RADIAN_10DEGREE); 
					break;
				case 3: 
					pm[i].negate(); 
					break;
				case 4: 
					pm[i].rotate( pm[i].width/4, pm[i].height/2, RADIAN_15DEGREE); 
					pm[i].negate(); 
					break;
				case 5: 
					pm[i].rotate( pm[i].width/2, pm[i].height/4, -RADIAN_15DEGREE); 
					pm[i].negate(); 
					break;
				case 6:
					int oldh = pm[i].height, oldw = pm[i].width; 
					pm[i].resize(pm[i].width/2, pm[i].height/2);
					pm[i].crop(oldh, oldw);
					pm[i].translate(oldw/4, oldh/4);
					pm[i].rotate( pm[i].width/2, 0, RADIAN_20DEGREE);
					break;
				case 7:
					oldh = pm[i].height; oldw = pm[i].width; 
					pm[i].resize(pm[i].width/2, pm[i].height/2);
					pm[i].crop(oldh, oldw);
					pm[i].translate(oldw/4, oldh/4);
					pm[i].rotate( pm[i].width/2, 0, RADIAN_15DEGREE);
					break;
				case 8:
					oldh = pm[i].height; oldw = pm[i].width; 
					pm[i].resize(pm[i].width/2, pm[i].height/2);
					pm[i].crop(oldh, oldw);
					pm[i].translate(oldw/4, oldh/4);
					pm[i].rotate( 0, pm[i].height/4, RADIAN_10DEGREE);
					pm[i].negate();
					break;
				case 9:
					oldh = pm[i].height; oldw = pm[i].width; 
					pm[i].resize(pm[i].width/2, pm[i].height/2);
					pm[i].crop(oldh, oldw);
					pm[i].translate(oldw/4, oldh/4);
					pm[i].rotate( pm[i].width/2, pm[i].height/4, -RADIAN_10DEGREE);
					pm[i].negate();
					break;
				default: ; // 0
			}
		}
		
		// Creation de l'image cible a afficher
		PixelMapPlus codedImage = new PixelMapPlus(PixelMap.ImageType.Color, 
				pm[0].height, codeLength*pm[0].width);
		
		// Insertion des images du code
		for(int i=0; i<codeLength; i++)
			codedImage.inset(pm[ i ], 0, i*pm[i].width);
		
		// Demander le code a l'usager
		String wName = "Code a entrer";
		DisplayImageWindow di = new DisplayImageWindow(wName, codedImage, true);
		
		System.out.print("Entrer code:");
		Scanner in = new Scanner(System.in);
		String response = in.nextLine();
		
		// Validation
		if( response.equals( code ) )
			System.out.println("Acces accorde");
		else
			System.out.println("Acces refuse");
			
		in.close();
		di.dispose();
	}
	
	/**
	 * Genere et retourne un string de longueur length avec des caracteres aleatoires
	 * choisis entre A et Z. Le choix est effectué avec l'aide d'un switch case et
	 * du nombre aléaltoire généré.
	 * @param length : longueur de la chaine de caractere a generer (inferieur ou egal a 10)
	 */
	private static String generateCode(int length) {
		if (length > 10) return null;

		char[] charKey = new char[length];

		Random generator = new Random(System.nanoTime());

		int nbAleatoire = generator.nextInt(27);
		int temp = 0;

		while (temp < length) {
			switch (nbAleatoire) {
			
				case 1:
					charKey[temp] = 'A';
					break;
				case 2:
					charKey[temp] = 'B';
					break;
				case 3:
					charKey[temp] = 'C';
					break;
				case 4:
					charKey[temp] = 'C';
					break;
				case 5:
					charKey[temp] = 'D';
					break;
				case 6:
					charKey[temp] = 'E';
					break;
				case 7:
					charKey[temp] = 'F';
					break;
				case 8:
					charKey[temp] = 'G';
					break;
				case 9:
					charKey[temp] = 'H';
					break;
				case 10:
					charKey[temp] = 'I';
					break;
				case 11:
					charKey[temp] = 'J';
					break;
				case 12:
					charKey[temp] = 'K';
					break;
				case 13:
					charKey[temp] = 'L';
					break;
				case 14:
					charKey[temp] = 'M';
					break;
				case 15:
					charKey[temp] = 'N';
					break;
				case 16:
					charKey[temp] = 'O';
					break;
				case 17:
					charKey[temp] = 'P';
					break;
				case 18:
					charKey[temp] = 'R';
					break;
				case 19:
					charKey[temp] = 'S';
					break;
				case 20:
					charKey[temp] = 'T';
					break;
				case 21:
					charKey[temp] = 'V';
					break;
				case 23:
					charKey[temp] = 'W';
					break;
				case 24:
					charKey[temp] = 'X';
					break;
				case 25:
					charKey[temp] = 'Y';
					break;
				case 26:
					charKey[temp] = 'Z';
					break;

			}
			temp++;
		}
		
		return new  String(charKey);
			
	}
	/**
	 * Genere et retourne plusieurs nombres aleatoires entre 0 et 9 (inclus) 
	 * @param nb : longueur de la chaine de caractere a generer (inferieur ou egal a 10)
	 */
	private static int[] generateTransform(int nb)
	{
		if (nb > 10) return null;
		
		int[] charTransform = new int[ nb ];
		
		Random generator = new Random( System.nanoTime() );
		for (int i=0; i< nb ; i++)
		{
			int newnbre = generator.nextInt(11);
			charTransform[i] = newnbre;
		}

		return charTransform ;
		
	}

}
