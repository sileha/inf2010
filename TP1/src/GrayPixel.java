/**
 * Classe de pixel en tons de gris
 * @author :
 * @date : 
 */

public class GrayPixel  extends AbstractPixel 
{
	int pixel; // donnee du pixel
	
	/**
	 * Constructeur par defaut (pixel blanc)
	 */
	GrayPixel()
	{
		this.pixel = 255;
	}
	
	/**
	 * Constructeur par parametre
	 * @param pixel : valeur du pixel
	 */
	GrayPixel(int pixel)
	{
		// compléter
		this.pixel = pixel;
	}
	
	/**
	 * Renvoie la valeur du pixel
	 */
	public int getPixel()
	{
		return pixel;
	}
	
	/**
	 * Assigne une valeur au pixel
	 * @param pixel: valeur a assigner 
	 */
	public void setPixel(int pixel)
	{
		this.pixel = pixel;
	}
	
	/**
	 * Renvoie un pixel copie de type noir et blanc
	 */
	public BWPixel toBWPixel()
	{
		// compléter
		boolean pixel = (this.pixel > 127 ? true : false);
		return new BWPixel(pixel);
	}
	
	/**
	 * Renvoie un pixel copie de type tons de gris
	 */
	public GrayPixel toGrayPixel()
	{
		// compléter
		return new GrayPixel(this.pixel);
	}
	
	/**
	 * Renvoie un pixel copie de type couleurs
	 * @return cp : le pixel transformé
	 */
	public ColorPixel toColorPixel()
	{
		// compléter
		int[] rgb = new int[3];
		rgb[0] = rgb[1] = rgb[2] = pixel;
		ColorPixel cp = new ColorPixel( rgb );
		return cp;
	}

	/**
	 * Renvoie un pixel copie de type transparent
	 * @return cp : le pixel transformé
	 */
	public TransparentPixel toTransparentPixel()
	{
		// compléter

		int[] rgba = new int[4];
		rgba[0] = rgba[1] = rgba[2] = pixel;
		rgba[3] = 255;
		TransparentPixel cp = new TransparentPixel( rgba );
		return cp;
		
	}
	
	/**
	 * Renvoie le negatif du pixel (255-pixel)
	 */
	public AbstractPixel Negative()
	{
		// compléter
		return new GrayPixel(255 - this.pixel);
	}
	
	public void setAlpha(int alpha)
	{
		//ne fait rien
	}
	
	/**
	 * Convertit le pixel en String (sert a ecrire dans un fichier 
	 * (avec un espace supplémentaire en fin)s
	 */
	public String toString()
	{
		return ((Integer)(pixel)).toString() + " ";
	}
	
	public int compareTo(AbstractPixel p) {
		if (this.pixel < ((GrayPixel) p).pixel) {
			return -1;
		} else {
			if (this.pixel == ((GrayPixel) p).pixel) {
				return 0;
			} else {
				return 1;
			}
		}
		
	}
}
