import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Melon {
	private int x, y;
	private Image img;
	private AffineTransform tx = AffineTransform.getTranslateInstance(x, y);
	private int acc = 1;
	private int vy, vx = 0;
	int count;
	
	public Melon() {
		img = getImage("watermelon.png");
		x = (int)(Math.random()*(900-0+1)+0); //randomize x within the frame
		y = 300;
		vx = (int)(Math.random()*(11)+4);
		if((int)(Math.random()*2)==1) {
			vx *=-1;
		}
		
	}
	
	public void paint(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, tx, null);
		tx.setToTranslation(x, y);
		tx.scale(1.6,1.6);
		
		vy+=acc;
		y+=vy;
		x+=vx;
		
	}
	
	public void updateVel(int pvy) {
		vy = pvy;
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Melon.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
	
}