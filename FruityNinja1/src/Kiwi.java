import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Kiwi {
	private int x, y;
	private Image img;
	private AffineTransform tx = AffineTransform.getTranslateInstance(x, y);
	private int acc = 1;
	private int vy, vx;
	boolean enabled = true;
	
	public Kiwi() {
		img = getImage("kiwi.png");
		x = (int)(Math.random()*(700-200+1)+200); //randomize x within the frame
		y = 600; //place kiwi outside
		vx = (int)(Math.random()*(3-2+1)+2);
		if((int)(Math.random()*2)==1) {
			vx *=-1;
		}
		vy = (int)(Math.random()*(-4+26+1)-26);
		
	}
	
	public void paint(Graphics g) {
		if(!enabled) {
			return;
		}
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, tx, null);
		tx.setToTranslation(x, y);
		tx.scale(0.3, 0.3);
		
		update();
		//g.drawRect(x+25-vx,y+25-vy,68,40);
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
	
	public boolean collide(int mX, int mY) {
		Rectangle a = new Rectangle(x+25-vx,y+25-vy,68+5,40+5);	
		if(a.contains(mX,mY)) {
			x=1000;
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
