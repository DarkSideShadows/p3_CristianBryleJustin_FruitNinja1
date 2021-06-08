import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Frame extends JPanel implements ActionListener, MouseListener, MouseMotionListener {
	
	Ground foreground = new Ground();
	CutWatermelon cutwatermelon = new CutWatermelon();
	
	Bomb[] b = new Bomb[100];
	Melon[] m = new Melon[100];
	Pineapple[] p = new Pineapple[100];
	Pumpkin[] pu = new Pumpkin[100];
	Banana[] ba = new Banana[100];
	Kiwi[] k = new Kiwi[100];
	
	int c1,c2,c3,c4,c5,c6;
	int q,w,e,r,t,y = 0;

	Music bang = new Music("bababooey.wav",false);
	Music point = new Music("androidsound.wav",false);
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		foreground.paint(g);
		//cutwatermelon.paint(g);
		c1++;
		c2++;
		c3++;
		c4++;
		c5++;
		//c6++;
		if(c1==200) {
			q++;
			c1=0;
		}
		if(c2==70) {
			w++;
			c2=0;
		}
		if(c3==100) {
			e++;
			c3=0;
		}
		if(c4==150) {
			r++;
			c4=0;
		}
		if(c5==150) {
			t++;
			c5=0;
		}
		if(c6==300) {
			y++;
			c6=0;
		}
		b[q].paint(g);
		m[w].paint(g);
		//p[e].paint(g);
		//pu[r].paint(g);
		//ba[t].paint(g);
		//k[y].paint(g);
	}
	
	public static void main(String[] arg) {
		Frame f = new Frame();
		
	}
	
	public Frame() {
		JFrame f = new JFrame("Fruity Ninja");
		f.setSize(new Dimension(900, 600));
		f.add(this);
		f.addMouseListener(this);
		f.addMouseMotionListener(this);
		f.setResizable(false);
	
		for(int i = 0; i<b.length;i++) {
			b[i] = new Bomb();
		}
		for(int i = 0; i<m.length;i++) {
			m[i] = new Melon();
		}
		for(int i = 0; i<p.length;i++) {
			p[i] = new Pineapple();
		}
		for(int i = 0; i<pu.length;i++) {
			pu[i] = new Pumpkin();
		}
		for(int i = 0; i<ba.length;i++) {
			ba[i] = new Banana();
		}
		for(int i = 0; i<k.length;i++) {
			k[i] = new Kiwi();
		}
		
		Timer t = new Timer(16, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		bang.play();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}
	
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		int mX =arg0.getX();
		int mY =arg0.getY();
		
		if(m[w].collide(mX, mY)) {
			//point.play();
		}
		if(p[e].collide(mX, mY)) {
			//point.play();
		}
		if(pu[r].collide(mX, mY)) {
			//point.play();
		}
		if(ba[t].collide(mX, mY)) {
			//point.play();
		}
		if(k[y].collide(mX, mY)) {
			//point.play();
		}
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}

