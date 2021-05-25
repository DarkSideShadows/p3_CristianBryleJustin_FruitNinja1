import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class CutWatermelon {
	private int x=9999, y=9999;
	private Image img;
	private AffineTransform tx = AffineTransform.getTranslateInstance(x, y);
	
	public CutWatermelon() {
		img = getImage("cutwatermelon.png");
		//init(x , y);
		
	}
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, tx, null);
	}


	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = CutWatermelon.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}

}
