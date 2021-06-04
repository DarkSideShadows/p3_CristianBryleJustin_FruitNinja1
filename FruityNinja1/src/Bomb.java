import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Bomb {
	private int x,y;
	private Image img;
	private AffineTransform tx = AffineTransform.getTranslateInstance(x, y);
	private int acc = 1;
	private int vy, vx;
	
	
	public Bomb() {
		img = getImage("bomb.png");
		x = (int)(Math.random()*(700-200+1)+200); //randomize x within the frame
		y = 600; //randomize y within the frame
		vx = (int)(Math.random()*(3-2+1)+2);
		
		if((int)(Math.random()*2)==1) {
			vx *=-1;
		}
		vy=-4;
		
	}
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, tx, null);
		tx.setToTranslation(x, y);
		
		if(y<400) {
			vy+=acc;
		}
		if(y>=400) {
			vy-=acc;
		}
		
		y+=vy;
		x+=vx;
	}


	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Bomb.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}

}
