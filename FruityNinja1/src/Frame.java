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
	

	boolean hi=false;

	CutWatermelon[] cm = new CutWatermelon[100];
	CutPineapple[] cp = new CutPineapple[100];
	CutPumpkin[] cpu = new CutPumpkin[100];
	CutBanana[] cba = new CutBanana[100];
	CutKiwi[] ck = new CutKiwi[100];

	
	int c1,c2,c3,c4,c5,c6;
	int q,w,e,r,t,y = 0;
	
	int p1Score = 0;

	Font verdana = new Font("Verdana", Font.BOLD,40);
	Font lose = new Font("Verdana", Font.BOLD,100);

	Font verdana = new Font("Verdana", Font.BOLD,45);


	Music bang = new Music("bababooey.wav",false);
	Music point = new Music("androidsound.wav",false);
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		foreground.paint(g);
		g.setFont(verdana);
		g.setColor(Color.WHITE);
		
		int hi = 1;
		if((int)(Math.random()*2)==1) {
			hi = -1;
		}
		c1++;
		c2++;
		c3++;
		c4++;
		c5++;
		c6++;
		if(c1==200) {
			b[q].setEnabled(true);
			int hello = (int)(Math.random()*(-4+26+1)-26);
			int bye = (int)(Math.random()*(3-2+1)+2);
			if(b[q].isEnabled()) {
				b[q].updateVelY(hello);
				b[q].updateVelX(hi*bye);
			}
			q++;
			c1=0;
		}
		if(c2==50) {
			m[w].setEnabled(true);
			cm[w].setEnabled(true);
			int hello = (int)(Math.random()*(-4+26+1)-26);
			int bye = (int)(Math.random()*(3-2+1)+2);
			if(m[w].isEnabled()) {
				m[w].updateVelY(hello);
				m[w].updateVelX(hi*bye);
				
				cm[w].updateVelY(hello);
				cm[w].updateVelX(hi*bye);
				cm[w].setX(m[w].getX());
			}
			w++;
			c2=0;
		}
		if(c3==100) {
			p[e].setEnabled(true);
			cp[e].setEnabled(true);
			int hello = (int)(Math.random()*(-4+26+1)-26);
			int bye = (int)(Math.random()*(3-2+1)+2);
			if(p[e].isEnabled()) {
				p[e].updateVelY(hello);
				p[e].updateVelX(hi*bye);
				
				cp[e].updateVelY(hello);
				cp[e].updateVelX(hi*bye);
				cp[e].setX(p[e].getX());
			}
			e++;
			c3=0;
		}
		if(c4==160) {
			pu[r].setEnabled(true);
			cpu[r].setEnabled(true);
			int hello = (int)(Math.random()*(-4+26+1)-26);
			int bye = (int)(Math.random()*(3-2+1)+2);
			if(pu[r].isEnabled()) {
				pu[r].updateVelY(hello);
				pu[r].updateVelX(hi*bye);
				
				cpu[r].updateVelY(hello);
				cpu[r].updateVelX(hi*bye);
				cpu[r].setX(pu[r].getX());
			}
			r++;
			c4=0;
		}
		if(c5==140) {
			ba[t].setEnabled(true);
			cba[t].setEnabled(true);
			int hello = (int)(Math.random()*(-4+26+1)-26);
			int bye = (int)(Math.random()*(3-2+1)+2);
			if(ba[t].isEnabled()) {
				ba[t].updateVelY(hello);
				ba[t].updateVelX(hi*bye);
				
				cba[t].updateVelY(hello);
				cba[t].updateVelX(hi*bye);
				cba[t].setX(ba[t].getX());
			}
			t++;
			c5=0;
		}
		if(c6==300) {
			k[y].setEnabled(true);
			ck[y].setEnabled(true);
			int hello = (int)(Math.random()*(-4+26+1)-26);
			int bye = (int)(Math.random()*(3-2+1)+2);
			if(k[y].isEnabled()) {
				k[y].updateVelY(hello);
				k[y].updateVelX(hi*bye);
				
				ck[y].updateVelY(hello);
				ck[y].updateVelX(hi*bye);
				ck[y].setX(k[y].getX());
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
			
			cm[i].paint(g);
			cp[i].paint(g);
			cpu[i].paint(g);
			cba[i].paint(g);
			ck[i].paint(g);
			
			//score

			
			//while(hi==false) {
				g.setFont(verdana);//set the font
			   //drawing text on the screen + using variables
			   g.drawString(""+p1Score, 150,100);	
			//}
			 if(hi==true) {
				 g.setFont(lose);//set the font
				 g.drawString("Game Over", 150,250);	
			 }

			g.setFont(verdana);//set the font
			//drawing text on the screen + using variables
			g.drawString(""+p1Score, 30,50);		   
			 	

			   
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
	
		for(int i = 0; i<100;i++) {
			b[i] = new Bomb();
			m[i] = new Melon();
			p[i] = new Pineapple();
			pu[i] = new Pumpkin();
			ba[i] = new Banana();
			k[i] = new Kiwi();
			
			cm[i] = new CutWatermelon();
			cp[i] = new CutPineapple();
			cpu[i] = new CutPumpkin();
			cba[i] = new CutBanana();
			ck[i] = new CutKiwi();
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

			if(b[i].collide(mX, mY)) {
				//point.play();
			hi=true;
		}

//			if(b[i].collide(mX, mY)) {
//				//point.play();
				//p1Score+=100;
//			}

			if(m[i].collide(mX, mY)) {
				//point.play();
				cm[i].setAppear(true);
				p1Score+=10;
			}
			if(p[i].collide(mX, mY)) {
				//point.play();
				cp[i].setAppear(true);
				p1Score+=20;
			}
			if(pu[i].collide(mX, mY)) {
				//point.play();
				cpu[i].setAppear(true);
				p1Score+=5;
			}
			if(ba[i].collide(mX, mY)) {
				//point.play();
				cba[i].setAppear(true);
				p1Score+=5;
			}
			if(k[i].collide(mX, mY)) {
				//point.play();
				ck[i].setAppear(true);
				p1Score+=50;
			}

			if(m[i].collide(mX, mY)) {
				
			}

		}
		
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}

