import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Ground {
	private int x = 0,y = 0;
	private Image img; // image of the frog
	private AffineTransform tx = AffineTransform.getTranslateInstance(x, y);
	boolean en = false;

	public Ground() {
		//the filename to the file is referenced here for the bg image
		img = getImage("back.jpg");
		init(x, y);//initializes the location of the image on th e screen
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, tx, null);
		
	}
	public boolean getEn() {
		return en;
	}
	public void setEn(boolean pen) {
		en = pen;
	}
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(.46666,.52);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Ground.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
}
