package wm;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;
public class Ball extends JComponent
{
	private int dx = 4, dy= 0;
		
	public Ball(int x, int y)
	{
		setLocation(x,y);
		setSize(10,10);
		
	}
		
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		Ellipse2D.Double ball = new Ellipse2D.Double(0, 0,10,10);
		g2.fill(ball);
			
	}
	public void update()
	{
		setLocation(getX() + dx, getY() + dy);
	}
}

