import java.awt.*;

/**
 * Classe de pixel transparent
 * @author :
 * @date : 
 */

public class TransparentPixel extends AbstractPixel
{
	public int[] rgba; // donnees de l'image
	
	/**
	 * Constructeur par defaut (pixel blanc)
	 */
	TransparentPixel()
	{
		rgba = new int[4];
		rgba[0] = 255;
		rgba[1] = 255;
		rgba[2] = 255;
		rgba[3] = 255;
	}
	
	/**
	 * Assigne une valeur au pixel
	 * @param rgb: valeurs a assigner 
	 */
	TransparentPixel(int[] rgba)
	{
		// compléter
		this.rgba[0] = rgba[0];
        this.rgba[1] = rgba[1];
        this.rgba[2] = rgba[2];
        this.rgba[3] = rgba[3];
	}
	
	/**
	 * Renvoie un pixel copie de type noir et blanc
	 */
	public BWPixel toBWPixel()
	{
		// compléter
        boolean pix = true;
        int pixelMoyenne = (this.rgba[0] + this.rgba[1] + this.rgba[2] + this.rgba[3]) / 4;
        if(pixelMoyenne <= 127)
            pix = false;
        BWPixel bw = new BWPixel(pix);
        return bw;
	}
	
	/**
	 * Renvoie un pixel copie de type tons de gris
	 */
	public GrayPixel toGrayPixel()
	{
		// compléter
        int pixelMoyenne = (this.rgba[0] + this.rgba[1] + this.rgba[2] + this.rgba[3]) / 4;
        GrayPixel gp = new GrayPixel(pixelMoyenne);
        return gp;
	}
	
	/**
	 * Renvoie un pixel copie de type couleurs
	 */
	public ColorPixel toColorPixel()
	{
		// compléter
        int rgba[] = new int[3];
        rgba[0] = this.rgba[0];
        rgba[1] = this.rgba[1];
        rgba[2] = this.rgba[2];
        ColorPixel cp = new ColorPixel(rgba);
        return cp;
    }
	
	/**
	 * Renvoie le negatif du pixel (255-pixel)
	 */
	public TransparentPixel Negative()
	{
		// compléter
        int rgba[] = new int[4];
        rgba[0] = 255 - this.rgba[0];
        rgba[1] = 255 - this.rgba[1];
        rgba[2] = 255 - this.rgba[2];
        rgba[3] = this.rgba[3];
        TransparentPixel tp = new TransparentPixel(rgba);
        return tp;
    }
	
	public TransparentPixel toTransparentPixel()
	{
		// compléter
        return new TransparentPixel(this.rgba);
	}
	
	public void setAlpha(int alpha)
	{
		rgba[3] = alpha;
	}
	
	/**
	 * Convertit le pixel en String (sert a ecrire dans un fichier 
	 * (avec un espace supplémentaire en fin)s
	 */
	public String toString()
	{
		return  ((Integer)rgba[0]).toString() + " " + 
				((Integer)rgba[1]).toString() + " " +
				((Integer)rgba[2]).toString() + " " +
				((Integer)rgba[3]).toString() + " ";
	}
	
	public int compareTo(AbstractPixel p) {
		if (rgba[0] < ((TransparentPixel) p).rgba[0]
				&& rgba[1] < ((TransparentPixel) p).rgba[1]
				&& rgba[2] < ((TransparentPixel) p).rgba[2]
				&& rgba[3] < ((TransparentPixel) p).rgba[3]) {
			return -1;
		} else {
			if (rgba[0] == ((TransparentPixel) p).rgba[0]
					&& rgba[1] == ((TransparentPixel) p).rgba[1]
					&& rgba[2] == ((TransparentPixel) p).rgba[2]
					&& rgba[3] == ((TransparentPixel) p).rgba[3]) {
				return 0;
			} else {
				return 1;
			}
		}
	}
	
}
