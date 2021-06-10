import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class CutKiwi {
	private int x, y;
	private Image img;
	private AffineTransform tx = AffineTransform.getTranslateInstance(x, y);
	private int vy, vx = 0;
	private int acc = 1;
	boolean enabled, appear = false;
	
	public CutKiwi() {
		img = getImage("cutkiwi.png");
		x = (int)(Math.random()*(650-100+1)+100); //randomize x within the frame
		y = 600; //place cut fruit outside
	}
	
	public void paint(Graphics g) {
		if(!enabled) {
			return;
		}
		tx.setToTranslation(x, y);
		tx.scale(0.20, 0.20);
		update();
		if(!appear) {
			return;
		}
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, tx, null);
	}
	
	public void update() {
		if(y<450) {
			vy+=acc;
		}
		if(y>=450) {
			vy-=acc;
		}
		if(y>600) {
			y=600;
			x = (int)(Math.random()*(650-100+1)+100);
			enabled=false;
			appear=false;
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
	public int getVX() {
		return vx;
	}
	public int getVY() {
		return vy;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setY(int py) {
		y = py;
	}
	public void setX(int px) {
		x = px;
	}
	public void setAppear(boolean hello) {
		appear = hello;
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
