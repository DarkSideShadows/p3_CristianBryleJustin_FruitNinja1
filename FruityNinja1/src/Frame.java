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
	Melon[] m = new Melon[100];
	Bomb[] b = new Bomb[100];
	int count1, count2;
	int i,h = 0;

	Music bang = new Music("bababooey.wav",false);
	Music point = new Music("androidsound.wav",false);
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		count1++;
		count2++;

		foreground.paint(g);
		//cutwatermelon.paint(g);
		
		if(count1==210) {
			i++;
			count1=0;
		}
		if(count2==70) {
			h++;
			count2=0;
		}
		b[i].paint(g);
		m[h].paint(g);
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
		int x =arg0.getX();
		int y =	arg0.getY();
		m[h].collide(x, y);
		if(m[h].collide(x, y)) {
			point.play();
		}
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}

