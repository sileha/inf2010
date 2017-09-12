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
	 * Genere le negatif d'une image
	 */
	public void negate()
	{
		// compl�ter
	}
	
	/**
	 * Convertit l'image vers une image en noir et blanc
	 */
	public void convertToBWImage()
	{
		// compl�ter
		
	}
	
	/**
	 * Convertit l'image vers un format de tons de gris
	 */
	public void convertToGrayImage()
	{
		// compl�ter
		
	}
	
	/**
	 * Convertit l'image vers une image en couleurs
	 */
	public void convertToColorImage()
	{
		// compl�ter
		
	}
	
	public void convertToTransparentImage()
	{
		// compl�ter
		
	}
	
	/**
	 * Fait pivoter l'image de 10 degres autour du pixel (row,col)=(0, 0)
	 * dans le sens des aiguilles d'une montre (clockWise == true)
	 * ou dans le sens inverse des aiguilles d'une montre (clockWise == false).
	 * Les pixels vides sont blancs.
	 * @param clockWise : Direction de la rotation 
	 */
	public void rotate(int x, int y, double angleRadian)
	{
		// compl�ter
		for (int i = 0; i < width; i++)
		{
			for (int j=0 ; j < height; j++)
			imageData[(int) ((j + i*Math.tan(angleRadian))/(Math.sin(angleRadian)*(Math.tan(angleRadian))+Math.cos(angleRadian)))][(int) (i/Math.cos(angleRadian)-((j+i*Math.tan(angleRadian))*Math.tan(angleRadian))/(Math.tan(angleRadian)*Math.sin(angleRadian)+Math.cos(angleRadian)))] = imageData[j][i];
		}
	}
	
	/**
	 * Modifie la longueur et la largeur de l'image 
	 * @param w : nouvelle largeur
	 * @param h : nouvelle hauteur
	 */
	public void resize(int w, int h) throws IllegalArgumentException
	{
		if(w < 0 || h < 0)
			throw new IllegalArgumentException();
		
		// compl�ter
		this.height = h;
		this.width = w;
	}
	
	/**
	 * Insert pm dans l'image a la position row0 col0
	 */
	public void inset(PixelMap pm, int row0, int col0)
	{
		// compl�ter
	 for (int i= row0; i < width ; i++)
	 {
		 for (int j= col0; j < height; j++) // il ne sort pas de l'image de destination /
		 {
		 imageData[j][i] = pm.imageData[j - col0][i - row0];
		 }
	 }
	 }


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
	 * Decoupe l'image 
	 */
	public void crop(int h, int w)
	{
		// compl�ter

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
	 * Effectue une translation de l'image 
	 */
	public void translate(int rowOffset, int colOffset)
	{
		// compl�ter		
		
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
		
		// compl�ter

			int zoomhight = (int) (width/zoomFactor) ;
			int zoomwidth = (int) (height/zoomFactor);
		AbstractPixel[][] newimageData = new AbstractPixel[zoomhight][zoomwidth];
			int largeur = 0, longueur = 0;


			if ( (x==0 && y==0 ) || ( x==0 && y==height) || (x==width && y==height) || (x==width && y==0))
			{
				x = width/2;
				y= height/2;

			}

			for (int i= y - zoomhight/2; i < y + zoomhight/2 ; i++)
			{
				longueur++;
				largeur=0;
				for (int j= x - zoomwidth/2 ; j< x+zoomwidth/2 ; j++)
				{
					largeur++;
					newimageData[longueur][largeur] = imageData[i][j];

				}
			}

			this.imageData = newimageData ;
	}

	/**
	 * Effectue un remplacement de tout les pixels dont la valeur est entre min et max 
	 * avec newPixel
	 * @param min : La valeur miniale d'un pixel
	 * @param max : La valeur maximale d'un pixel  
	 * @param newPixel : Le pixel qui remplacera l'ancienne couleur 
	 * (sa valeur est entre min et max)
	 */
	public void replaceColor(AbstractPixel min, AbstractPixel max,
			AbstractPixel newPixel) {
		// compl�ter
		
	}

	public void inverser() {
		// compl�ter
				
	}
}
