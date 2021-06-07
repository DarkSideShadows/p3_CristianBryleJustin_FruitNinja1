import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Melon {
	private int x, y;
	private Image img;
	private AffineTransform tx = AffineTransform.getTranslateInstance(x, y);
	private int acc = 1;
	private int vy, vx;
	boolean enabled = false;
	
	
	public Melon() {
		img = getImage("watermelon.png");
		x = (int)(Math.random()*(700-200+1)+200); //randomize x within the frame
		y = 600; //place watermelon outside
		vx = (int)(Math.random()*(3-2+1)+2);
		if((int)(Math.random()*2)==1) {
			vx *=-1;
		}
		vy = (int)(Math.random()*(-4+20+1)-20);
		
	}
	
	public void paint(Graphics g) {
		if(!enabled) {
			return;
		}
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, tx, null);
		tx.setToTranslation(x, y);
		tx.scale(1.6, 1.6);
		
		update();
	}
	public void update() {
		if(y<450) {
			vy+=acc;
		}
		if(y>=450) {
			vy-=acc;
		}
		if(y>600) {
			x = 99999;
		}
		y+=vy;
		x+=vx;
	}

	public void setEnabled(boolean pe) {
		enabled = pe;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void updateVel(int pvy) {
		vy = pvy;
	}
	public void setY(int py) {
		y = py;
	}
	public boolean collide(int mX, int mY) {
		Rectangle a = new Rectangle(x,y,100,100);
		Rectangle b = new Rectangle(x,y,100,100);
		
		if(a.contains(mX,mY)) {
			x=1000;
			
			//if collides 
			//add point
			//and replace the melon with cutwatermelon
			// also play sound
			return true;
		}
		return false;
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
