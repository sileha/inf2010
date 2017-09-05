/**
 * Classe de pixel en couleurs 
 * @author :
 * @date : 
 */

public class ColorPixel extends AbstractPixel
{
	public int[] rgb; // donnees de l'image
	
	/**
	 * Constructeur par defaut (pixel blanc)
	 */
	ColorPixel()
	{
		rgb = new int[3];
		rgb[0] = 255;
		rgb[1] = 255;
		rgb[2] = 255;
	}
	
	/**
	 * Assigne une valeur au pixel
	 * @param rgb: valeurs a assigner 
	 */
	ColorPixel(int[] rgb)
	{
		// compléter
		this.rgb = new int[3];		/* Pq a completer? */
		this.rgb[0] = rgb[0];
		this.rgb[1] = rgb[1];
		this.rgb[2] = rgb[2];
	
	}
	
	/**
	 * Renvoie un pixel copie de type noir et blanc
	 */
	public BWPixel toBWPixel()
	{
	    boolean pix = true;
		int pixelMoyenne = (this.rgb[0] + this.rgb[1] + this.rgb[2]) / 3; /* Trouver comment faire avec '?' */
		if(pixelMoyenne <= 127)
		    pix = false;
		// boolean pix = (pixelMoyenne <= 127 ? true : false); *pour tester*

		BWPixel bw = new BWPixel(pix);
		return bw;
	}
	
	/**
	 * Renvoie un pixel copie de type tons de gris
	 */
	public GrayPixel toGrayPixel()
	{
	    int pixelMoyenne = (this.rgb[0] + this.rgb[1] + this.rgb[2]) / 3;
	    GrayPixel gp = new GrayPixel(pixelMoyenne);
	    return gp;
	}
	
	/**
	 * Renvoie un pixel copie de type couleurs
	 */
	public ColorPixel toColorPixel()
	{
		return new ColorPixel(this.rgb);
	}
	
	public TransparentPixel toTransparentPixel()
	{
		int rgba[] = new int[4];
		rgba[0] = this.rgb[0];
		rgba[1] = this.rgb[1];
		rgba[2] = this.rgb[3];
		rgba[3] = 255;
		TransparentPixel tp = new TransparentPixel(rgba);
		return tp;
	}
	
	/**
	 * Renvoie le negatif du pixel (255-pixel)
	 */
	public AbstractPixel Negative()
	{
		int rgba[] = new int[3];
		rgba[0] = 255 - this.rgb[0];
		rgba[1] = 255 - this.rgb[1];
        rgba[2] = 255 - this.rgb[2];
        return new ColorPixel(rgba);
	}
	
	public void setAlpha(int alpha)
	{
		//ne fait riens
	}
	
	/**
	 * Convertit le pixel en String (sert a ecrire dans un fichier 
	 * (avec un espace supplémentaire en fin)s
	 */
	public String toString()
	{
		return  ((Integer)rgb[0]).toString() + " " + 
				((Integer)rgb[1]).toString() + " " +
				((Integer)rgb[2]).toString() + " ";
	}
	
	public int compareTo(AbstractPixel p) {
		if (rgb[0] < ((ColorPixel) p).rgb[0]
				&& rgb[1] < ((ColorPixel) p).rgb[1]
				&& rgb[2] < ((ColorPixel) p).rgb[2]) {
			return -1;
		} else {
			if (rgb[0] == ((ColorPixel) p).rgb[0]
					&& rgb[1] == ((ColorPixel) p).rgb[1]
					&& rgb[2] == ((ColorPixel) p).rgb[2]) {
				return 0;
			} else {
				return 1;
			}
		}
	}

}