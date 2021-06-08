import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Bomb {
	private int x,y;
	private Image img;
	private AffineTransform tx = AffineTransform.getTranslateInstance(x, y);
	private int acc = 1;
	private int vy, vx = 0;
	boolean enabled = false;
	
	public Bomb() {
		img = getImage("bomb.png");
		x = (int)(Math.random()*(650-100+1)+100); //randomize x within the frame
		y = 600; //randomize y within the frame
	}
	
	public void paint(Graphics g) {
		if(!enabled) {
			return;
		}
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, tx, null);
		tx.setToTranslation(x, y);
		tx.scale(0.9, 0.9);
		
		update();
		//g.drawRect(x+30-vx,y+10-vy,91,83);
	}
	
	public void update() {
		if(y<450) {
			vy+=acc;
		}
		if(y>=450) {
			vy-=acc;
		}
		if(y>600) {
			y=999999999;
		}
		y+=vy;
		x+=vx;
	}
	
	public void setEnabled(boolean hi) {
		enabled = hi;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void updateVelY(int pvy) {
		vy = pvy;
	}
	public void updateVelX(int pvx) {
		vx = pvx;
	}
	
	public boolean collide(int mX, int mY) {
		Rectangle a = new Rectangle(x+30-vx,y+10-vy,91,83);
		if(a.contains(mX,mY)) {
			x=1000;
			return true;
		}
		return false;
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
