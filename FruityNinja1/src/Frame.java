import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
	
	int p1Score = 0;
	Font verdana = new Font("Verdana", Font.BOLD,40);

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
		c6++;
		if(c1==200) {
			int hi = 1;
			if((int)(Math.random()*2)==1) {
				hi = -1;
			}
			b[q].setEnabled(true);
			if(b[q].isEnabled()) {
				b[q].updateVelY((int)(Math.random()*(-4+26+1)-26));
				b[q].updateVelX(hi*(int)(Math.random()*(3-2+1)+2));
			}
			q++;
			c1=0;
		}
		if(c2==50) {
			int hi = 1;
			if((int)(Math.random()*2)==1) {
				hi = -1;
			}
			m[w].setEnabled(true);
			if(m[w].isEnabled()) {
				m[w].updateVelY((int)(Math.random()*(-4+26+1)-26));
				m[w].updateVelX(hi*(int)(Math.random()*(3-2+1)+2));
			}
			w++;
			c2=0;
		}
		if(c3==100) {
			int hi = 1;
			if((int)(Math.random()*2)==1) {
				hi = -1;
			}
			p[e].setEnabled(true);
			if(p[e].isEnabled()) {
				p[e].updateVelY((int)(Math.random()*(-4+26+1)-26));
				p[e].updateVelX(hi*(int)(Math.random()*(3-2+1)+2));
			}
			e++;
			c3=0;
		}
		if(c4==160) {
			int hi = 1;
			if((int)(Math.random()*2)==1) {
				hi = -1;
			}
			pu[r].setEnabled(true);
			if(pu[r].isEnabled()) {
				pu[r].updateVelY((int)(Math.random()*(-4+26+1)-26));
				pu[r].updateVelX(hi*(int)(Math.random()*(3-2+1)+2));
			}
			r++;
			c4=0;
		}
		if(c5==140) {
			int hi = 1;
			if((int)(Math.random()*2)==1) {
				hi = -1;
			}
			ba[t].setEnabled(true);
			if(ba[t].isEnabled()) {
				ba[t].updateVelY((int)(Math.random()*(-4+26+1)-26));
				ba[t].updateVelX(hi*(int)(Math.random()*(3-2+1)+2));
			}
			t++;
			c5=0;
		}
		if(c6==300) {
			int hi = 1;
			if((int)(Math.random()*2)==1) {
				hi = -1;
			}
			k[y].setEnabled(true);
			if(k[y].isEnabled()) {
				k[y].updateVelY((int)(Math.random()*(-4+26+1)-26));
				k[y].updateVelX(hi*(int)(Math.random()*(3-2+1)+2));
			}
			y++;
			c6=0;
		}
		for(int i = 0; i<100;i++) {
			b[i].paint(g);
			m[i].paint(g);
			p[i].paint(g);
			pu[i].paint(g);
			ba[i].paint(g);
			k[i].paint(g);
			
			//score
			g.setFont(verdana);//set the font
			   //drawing text on the screen + using variables
			   g.drawString(""+p1Score, 150,100);		   
			 	
			   
		}
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
		for(int i = 0; i<100;i++) {
//			if(b[i].collide(mX, mY)) {
//				//point.play();
			//p1Score+=100;
//			}
			if(m[i].collide(mX, mY)) {
				//point.play();
				p1Score+=10;
			}
			if(p[i].collide(mX, mY)) {
				//point.play();
				p1Score+=20;
			}
			if(pu[i].collide(mX, mY)) {
				//point.play();
				p1Score+=5;
			}
			if(ba[i].collide(mX, mY)) {
				//point.play();
				p1Score+=5;
			}
			if(k[i].collide(mX, mY)) {
				//point.play();
				p1Score+=50;
			}
			if(m[i].collide(mX, mY)) {
				//bomp play or something
			}
		}
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}

