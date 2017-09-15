import java.awt.PageAttributes.ColorType;

/**
 * Classe PixelMapPlus
 * Image de type noir et blanc, tons de gris ou couleurs
 * Peut lire et ecrire des fichiers PNM
 * Implemente les methodes de ImageOperations
 * @author : 
 * @date   : 
 */

public class PixelMapPlus extends PixelMap implements ImageOperations 
{
	/**
	 * Constructeur creant l'image a partir d'un fichier
	 * @param fileName : Nom du fichier image
	 */
	PixelMapPlus(String fileName)
	{
		super( fileName );
	}
	
	/**
	 * Constructeur copie
	 * @param type : type de l'image a creer (BW/Gray/Color)
	 * @param image : source
	 */
	PixelMapPlus(PixelMap image)
	{
		super(image); 
	}
	
	/**
	 * Constructeur copie (sert a changer de format)
	 * @param type : type de l'image a creer (BW/Gray/Color)
	 * @param image : source
	 */
	PixelMapPlus(ImageType type, PixelMap image)
	{
		super(type, image); 
	}
	
	/**
	 * Constructeur servant a allouer la memoire de l'image
	 * @param type : type d'image (BW/Gray/Color)
	 * @param h : hauteur (height) de l'image 
	 * @param w : largeur (width) de l'image
	 */
	PixelMapPlus(ImageType type, int h, int w)
	{
		super(type, h, w);
	}
	
	/**
	 * Genere le negatif d'une image. Un tableau de pixel 'temporaire'
	 * est utilisé pour pouvoir parcourir et modifier tous les pixels
	 * de l'image originale.
	 * @param aucun
	 */
	public void negate()	/* Fonctionne */
	{
		// compl�ter
		AbstractPixel bufferImageImage[][] = new AbstractPixel[height][width];
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++)
				bufferImageImage[i][j] = imageData[i][j].Negative();
		}

		imageData = bufferImageImage;
		bufferImageImage = null; 
	}
	
	/**
	 * Convertit l'image vers une image en noir et blanc. Un tableau de
	 * pixel 'temporaire' est utilisé pour pouvoir parcourir et modifier
	 * tous les pixels de l'image originale.
	 * @param aucun
	 */
	public void convertToBWImage()	/* Fonctionne */
	{
		// compl�ter
		AbstractPixel bufferImage[][] = new AbstractPixel[height][width];
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++)
			bufferImage[i][j] = imageData[i][j].toBWPixel();
		}

		imageData = bufferImage;
		bufferImage = null;
	}
	
	/**
	 * Convertit l'image vers un format de tons de gris. Un tableau de
	 * pixel 'temporaire' est utilisé pour pouvoir parcourir et modifier
	 * tous les pixels de l'image originale.
	 * @param aucun
	 */
	public void convertToGrayImage()	/* Fonctionne */
	{
		// compl�ter
		AbstractPixel bufferImage[][] = new AbstractPixel[height][width];
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++)
				bufferImage[i][j] = imageData[i][j].toGrayPixel();
		}

		imageData = bufferImage;
		bufferImage = null;
	}
	
	/**
	 * Convertit l'image vers une image en couleurs. Un tableau de pixel
	 * 'temporaire' est utilisé pour pouvoir parcourir et modifier tous
	 * les pixels de l'image originale.
	 * @param aucun
	 */
	public void convertToColorImage()	/* Fonctionne */
	{
		// compl�ter
		AbstractPixel bufferImage[][] = new AbstractPixel[height][width];
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++)
				bufferImage[i][j] = imageData[i][j].toColorPixel();
		}
		imageData = bufferImage;
		bufferImage = null ;
	}

	/**
	 * Convertit l'image vers une image transparente. Un tableau de pixel
	 * 'temporaire' est utilisé pour pouvoir parcourir et modifier tous les
	 * pixels de l'image originale.
	 * @param aucun
	 */
	public void convertToTransparentImage()
	{
		// compl�ter
		AbstractPixel bufferImage[][] = new AbstractPixel[height][width];
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++)
				bufferImage[i][j] = imageData[i][j].toTransparentPixel();
		}
		imageData = bufferImage;
		bufferImage = null;
	}
	
	/**
	 * Fait pivoter l'image autour des pixels dont les coordonées
	 * correspondent à x et y selon un angle en radian (angleRadian).
	 * Un tableau de pixels 'temporaire' et remplis de pixels de couleurs
	 * est utilisé pour pouvoir effectuer la rotation. La matrice de rotation
	 * fournie dans l'énoncé est également utilisée pour parcourir l'image
	 * originale pour cibler les pixels à déplacer.
	 * @param x : la position en x du pixel autour duquel la translation sera
	 *            effectuée
	 * @param y : la position en y
	 * @param angleRadian : l'angle (en radian) de rotation
	 */
	public void rotate(int x, int y, double angleRadian)
	{
		AbstractPixel[][] pm = new  AbstractPixel[height][width];
		for (int i = 0; i<height ; i++)
		{
			for (int j = 0; j<width; j++)
			{
				pm[i][j] = new ColorPixel();
				
			}
		}
		
		
		for (int i = 0; i < width; i++)  
		{
			for (int j=0 ; j < height; j++)
			{
				
				int Y = (int) ((j + i*Math.tan(angleRadian))/(Math.sin(angleRadian)*(Math.tan(angleRadian))+Math.cos(angleRadian)));
				int X = (int) (i/Math.cos(angleRadian)-((j+i*Math.tan(angleRadian))*Math.tan(angleRadian))/(Math.tan(angleRadian)*Math.sin(angleRadian)+Math.cos(angleRadian)));
				if (Y < height && Y>0 && X>0 && X < width )
				{
					pm[Y][X] = imageData[j][i];
				}
			
			}
		}
		this.imageData = pm ;
	}
	
	/**
	 * Modifie la longueur et la largeur de l'image en changeant les
	 * attributs 'height' et 'width'.
	 * @param w : nouvelle largeur
	 * @param h : nouvelle hauteur
	 */
	public void resize(int w, int h) throws IllegalArgumentException
	{
		if(w < 0 || h < 0)
			throw new IllegalArgumentException();
		
		
		this.height = h;
		this.width = w;
	}
	
	/**
	 * Insert pm dans l'image a la position row0 col0. Parcours imageData
	 * pour insérer pm à la bonne position.
	 * @param pm : l'image à inserer dans l'image de départ (imageData)
	 * @param row0 : la rangée à partir de laquelle l'image sera insérée
	 * @param col0 : la colonne à partir de laquelle l'image sera insérée
	 */
	public void inset(PixelMap pm, int row0 , int col0 )
	{
		int longueur=0 , largeur = 0;
		pm = new PixelMap(this.getType(), pm);
		
	 for (int i= col0; i < width && largeur < pm.width ; i++,  largeur++)
	 	{
		
		 longueur = 0;
		 for (int j= row0; j < height  && pm.height > longueur; j++, longueur++) 
		 	{
			 	imageData[j][i] = pm.imageData[longueur][largeur];
			 	
		 	}
	 	}
	 }

	/**
	 * Méthode de plus. Remplis le tableau à partir des positions 'débutLongueur'
	 * et 'debutLargeur' jusqu'au positions 'FingLougueur' et 'FinLargeur'.
	 * @param DebutLongueur : la position initiale en y (selon la largeur)
	 * @param DebutLargeur : la position intiale en x (selon la longueur)
	 * @param FinLongueur : la position finale en y (selon la largeur)
	 * @param FinLargeur : la position finale en x (selon la longueur)
	 */
	 public void RemplirTableau(int DebutLongueur,int DebutLargeur, int FinLongueur, int FinLargeur )
	 {
		 for (int i = DebutLargeur; i < FinLargeur; i++)
		 {
			 for (int j = DebutLongueur ; j < FinLongueur ; j++ )
			 {
				 imageData[j][i] = this.getPixel(j,i).toColorPixel();

			 }

		 }


	 }


	/**
	 * Decoupe l'image selon la hauteur (h) et la largeur (h) spécifiée.
	 * Les pixels qui se trouvent à l'extérieur de la région de découpage
	 * sont perdus.
	 * @param h : la hauteur à laquelle le découpage sera fait
	 * @param w : la largeur à laquelle le découpage sera fait
	 */
	public void crop(int h, int w)
	{
		// complï¿½ter

		if ( h> 0  || w > 0)
		{
			if (h< height  || width > w)
			{
				this.resize(w , h);

			}

			else if (h > height || w < width)

			{
				int temp = height ;
				this.resize(w,h);
				this.RemplirTableau(temp, 0, h, width);
			}
			else if ( h<height || w>width)
			{
				int temp = width;
				this.resize(w,h);
				this.RemplirTableau(0, temp,height,width);
			}
				else if ( h > height || w > width)
				{
				int temp1 = height;
				int temp2 = width;
				this.resize(w,h);
				this.RemplirTableau(temp1, temp2, height , width);
			    }
		}
		
	}
	
	/**
	 * Effectue une translation de l'image. Pour effectuer cette translation,
	 * une image 'temporaire' est créer dans laquelle des pixels de couleurs
	 * seront déjà présents. On attribue par la suite les pixels correspondants
	 * de l'image originale à cette image 'temporaire' pour enfin attribuer
	 * celle-ci à imageData.
	 * @param rowOffset : Le décalage qui sera effectué sur les rangées du
	 *                    du tableau de pixel
	 * @param colOffset : Le décalage effectué sur les colonnes du tableau
	 *             		  de pixel
	 */
	public void translate(int rowOffset, int colOffset)
	{
		AbstractPixel[][] pm = new AbstractPixel[height][width] ;	
		
		for (int i =0; i < height; i++)
		{
			for (int j=0 ; j < width ; j++)
			{
				pm[i][j] = new ColorPixel();
				
			}
		}
		
		
		for (int i =0; i < height; i++)
		{
			for (int j=0 ; j < width ; j++)
			{
				if (i+rowOffset < height && j+colOffset < width)
				{
					pm[i+rowOffset][j+colOffset] = imageData[i][j];
				}
				
			}
			
		}
		this.imageData = pm;
	}
	
	/**
	 * Effectue un zoom autour du pixel (x,y) d'un facteur zoomFactor 
	 * @param x : colonne autour de laquelle le zoom sera effectue
	 * @param y : rangee autour de laquelle le zoom sera effectue  
	 * @param zoomFactor : facteur du zoom a effectuer. Doit etre superieur a 1
	 */
	public void zoomIn(int x, int y, double zoomFactor) throws IllegalArgumentException
	{
		if(zoomFactor < 1.0)
			throw new IllegalArgumentException();

			int zoomhight = (int) (height/zoomFactor) ;
			int zoomwidth = (int) (width/zoomFactor);
		AbstractPixel[][] newimageData = new AbstractPixel[zoomhight][zoomwidth];
			int largeur = 0, longueur = 0;

			if ( (x==0 && y==0 ) || ( x==0 && y==height) || (x==width && y==height) || (x==width && y==0))
			{
				x = width/2;
				y= height/2;
			}

			for (int i= y - zoomhight/2; i < y + zoomhight/2 ; i++, longueur++)
			{
				largeur=0;
				for (int j= x - zoomwidth/2 ; j< x+zoomwidth/2 ; j++, largeur++)
				{ 
					newimageData[longueur][largeur] = imageData[i][j];
				}
			}
			
			for (int i = 0 ; i < width && (i/zoomFactor < longueur) ; i++)
			{
				for (int j = 0; j < height && (j/zoomFactor < largeur) ; j++)
				{
					imageData[i][j] = newimageData[(int) (i/zoomFactor)][(int)(j/zoomFactor)];
				}
			}
	}

	/**
	 * Effectue un remplacement de tout les pixels dont la valeur est entre min et max 
	 * avec newPixel
	 * La méthode parcours l'image et compare to les pixels avec 'min' et 'max' avec
	 * l'aide de la méthode compareTo(..).
	 * @param min : La valeur miniale d'un pixel
	 * @param max : La valeur maximale d'un pixel  
	 * @param newPixel : Le pixel qui remplacera l'ancienne couleur 
	 * (sa valeur est entre min et max)
	 */
	public void replaceColor(AbstractPixel min, AbstractPixel max,
			AbstractPixel newPixel) {
		// complï¿½ter
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				if(imageData[i][j].compareTo(min) == 1 || imageData[i][j].compareTo(max) == 1)
					imageData[i][j] = newPixel;
			}
		}
		
	}

	/**
	 * La méthode inverse l'image en effectuant une translation des pixels de celle-ci
	 * du haut vers le bas. Pour effectuer cette translation, la méthode parcours
	 * l'image et copie les pixels correspondant dans une image 'temporaire' pour
	 * ensuite attribuer cette image 'temporaire' à imageData.
	 * @param aucun
	 */

	public void inverser() {
		// complï¿½ter
		AbstractPixel bufferImageImage[][] = new AbstractPixel[height][width];
		int finalHeightIndex = height - 1;

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				bufferImageImage[i][j] = imageData[finalHeightIndex - i][j];
			}
		}
		imageData = bufferImageImage;
		bufferImageImage = null;
	}
}
