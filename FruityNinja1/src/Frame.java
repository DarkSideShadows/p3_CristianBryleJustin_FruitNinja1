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
	
	//Objects that need to be drawn on the JFrame in the paint method.
	//write the code to create a ground object as one of ur instance variables
	Timer t;
	Ground foreground = new Ground();
	Melon watermelon = new Melon();
	CutWatermelon cutwatermelon = new CutWatermelon();
	Bomb bomb = new Bomb();
	long count = 0;


	Music bang = new Music("bababooey.wav",false);
Music point = new Music("androidsound.wav",false);

	
	public void paint(Graphics g) {
	super.paintComponent(g);	
		count+=16;

		foreground.paint(g);
		
		//for this one you should do a count that
		//if it's greater than ___, it'll paint a new watermelon
		//from the array of watermelon
		//if(count >= 1000) {
			
		//}
		watermelon.paint(g);
		
		
		
		cutwatermelon.paint(g);
		bomb.paint(g);
		
	//Fruit Ninja startup 
	}
	//hi
	public static void main(String[] arg) {
		Frame f = new Frame();
		
	}
	
	public Frame() {

		JFrame f = new JFrame("Fruity Ninja");
		f.setSize(new Dimension(900, 600));

		//f.setBackground(Color.blue);
		f.add(this);
		f.addMouseListener(this);
		f.addMouseMotionListener(this);
		f.setResizable(false);
		
		Timer t = new Timer(16, this);
		t.start();
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		//config code 
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

		
		
	//send mouse x and y to duck object 
	

	
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
		watermelon.collide(x, y);
		if(watermelon.collide(x, y)) {
			point.play();
		}
		System.out.println(x);
		System.out.println(y);
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}

