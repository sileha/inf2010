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
		
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++)
				imageData[i][j] = imageData[i][j].Negative();
		}
	}
	
	/**
	 * Convertit l'image vers une image en noir et blanc
	 */
	public void convertToBWImage()	
	{
		
		AbstractPixel buffer[][] = new AbstractPixel[height][width];
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++)
			buffer[i][j] = imageData[i][j].toBWPixel();
		}

		imageData = buffer;
		buffer = null;
	}
	
	/**
	 * Convertit l'image vers un format de tons de gris
	 */
	public void convertToGrayImage()	
	{
		
		AbstractPixel buffer[][] = new AbstractPixel[height][width];
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++)
				buffer[i][j] = imageData[i][j].toGrayPixel();
		}

		imageData = buffer;
		buffer = null;
	}
	
	/**
	 * Convertit l'image vers une image en couleurs
	 */
	public void convertToColorImage()	
	{
		
		AbstractPixel buffer[][] = new AbstractPixel[height][width];
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++)
				buffer[i][j] = imageData[i][j].toColorPixel();
		}
		imageData = buffer;
		buffer = null ;
	}
	
	public void convertToTransparentImage()
	{
		
		AbstractPixel buffer[][] = new AbstractPixel[height][width];
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++)
				buffer[i][j] = imageData[i][j].toTransparentPixel();
		}
		imageData = buffer;
		buffer = null;
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
		AbstractPixel[][] pm = CreerImage(height,width);
		double cos = Math.cos(angleRadian);
		double sin = Math.sin(angleRadian);
		
		
		for (int i = 0; i < width; i++)  
		{
			for (int j=0 ; j < height; j++)
			{
				
				int Y = (int) (-i*sin+j*cos+x*sin-y*cos+y);
				int X = (int) (i*cos +j*sin -x*cos-y*sin+x);
				if (Y>=0 && X>=0 && X<width && Y< height )
				{
					pm[j][i] = imageData[Y][X];
				}
			}
		}
		this.imageData = pm ;
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
		
		AbstractPixel[][] pm = new AbstractPixel[h][w];
		for (int i=0; i < h ; i++)
		{
			for (int j = 0; j< w ; j++)
			{
				pm[i][j] = imageData[(i*height)/h][(j*width)/w];
				
			}
			
		}
		imageData = pm ;
		height =h;
		width = w;
	}
	
	/**
	 * Insert pm dans l'image a la position row0 col0
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

			/* NOUVELLE FONCTION CREE POUR EVITER LA DIPLUCATION DU CODE */
	
	 public void RemplirTableau(int DebutLongueur,int DebutLargeur, int FinLongueur, int FinLargeur )
	 {
		 for (int i = DebutLargeur; i < FinLargeur; i++)
		 {
			 for (int j = DebutLongueur ; j < FinLongueur ; j++ )
			 {
				 imageData[j][i] = new ColorPixel();

			 }

		 }


	 }
	 
	 
	 /**
	 *   CREER UNE IMAGE BLANCHE
	 */
	 	public AbstractPixel[][] CreerImage(int height , int width)
	 	{
	 		
	 		AbstractPixel[][] pm = new AbstractPixel[height][width];
	 		for (int i = 0; i < width ; i++)
			 {
				 for (int j = 0 ; j < height ; j++ )
				 {
					 
					 pm[j][i] = new ColorPixel();
				 }
			 }
	 		return pm;
	 	}

	/**
	 * Decoupe l'image 
	 */
	public void crop(int h, int w)
	{
		

		if ( h> 0  && w > 0)
		{
			AbstractPixel[][] pm = CreerImage(h, w);
			
			for (int i=0; i< h ; i++)
			{
				for (int j = 0; j<w ; j++)
				{
					
					if (i>=height || j>= width)
					{
						pm[i][j] = new ColorPixel(); 
						
					}
					else { pm[i][j] = imageData[i][j];  }
					
				}
				
			}
					imageData = pm ;
					height = h;
					width = w ;

			 }
			    }
		

		
	
	/**
	 * Effectue une translation de l'image 
	 */
	public void translate(int rowOffset, int colOffset)
	{
		AbstractPixel[][] pm = CreerImage(height,width) ;	
		
		
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


			if (x < zoomwidth/2 )
			{
				x = zoomwidth/2;
			}
			
			else if   (x + zoomwidth/2 >= width)
			{
				x = width- zoomwidth/2 - 1 ;
				
			}
				
				
				
			 if (y < zoomhight/2 )
			{
				y= zoomhight/2;
			}
			 else if (y + zoomhight/2 >= height)
			 {
				 y = height - zoomhight/2 - 1;
				 
			 }
			 
			for (int i= y - zoomhight/2; i < y + zoomhight/2 ; i++, longueur++)
			{
				
				largeur=0;
				for (int j= x - zoomwidth/2 ; j< x+zoomwidth/2 ; j++, largeur++)
				{ 
					newimageData[longueur][largeur] = imageData[i][j];
				}
				
			}
			
			for (int i = 0 ; i < width || (i/zoomFactor < zoomwidth) ; i++)
			{
				for (int j = 0; j < height || (j/zoomFactor < zoomhight) ; j++)
				{
					imageData[j][i] = newimageData[(int) (j/zoomFactor)][(int)(i/zoomFactor)];
					
				}
				
			}
			
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
		
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				if(imageData[i][j].compareTo(min) == 1 || imageData[i][j].compareTo(max) == 1)
					imageData[i][j] = newPixel;
			}
		}
		
	}

	public void inverser() {
		
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
