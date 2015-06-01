import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;


public class ReadImage {

	public BufferedImage readimage(String name) {
	    String image_file = name;
	    URL url = getClass().getResource(image_file);
	    BufferedImage img = null;
	    try {
	      img = ImageIO.read(url);
	    } catch (Exception e) {
	    }
	    return img;
	}
	
	
}
