package wm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.Timer;

public class WalkingFrame extends JFrame implements ActionListener
{
	private Man man;
	private ArrayList<Ball> ballArray; 
	
	
	public WalkingFrame()
	{
		setBounds(100,100,600,400);
		setLayout(null);
		man = new Man(0,0);
		add(man);
		ballArray = new ArrayList<>();
		
		Timer timer = new Timer(10, this);
		timer.start();
		addKeyListener(new KeyListener()
				{

					@Override
					public void keyPressed(KeyEvent e) 
					{
						if(e.getKeyCode()== e.VK_W)
						{
							man.setDY(-2);
						}
						if(e.getKeyCode()== e.VK_S)
						{
							man.setDY(2);
						}
						if(e.getKeyCode()== e.VK_A)
						{
							man.setDX(-2);
						}
						if(e.getKeyCode()== e.VK_D)
						{
							man.setDX(2);
						}
						if(e.getKeyCode()== e.VK_SPACE)
						{
							Ball balltemp = new Ball(man.getX(),man.getY());
							ballArray.add(balltemp);
							add(balltemp);
							
						}
						
					}

					@Override
					public void keyReleased(KeyEvent e) 
					{
						if(e.getKeyCode()== e.VK_W)
						{
							man.setDY(0);
						}
						if(e.getKeyCode()== e.VK_S)
						{
							man.setDY(0);
						}
						if(e.getKeyCode()== e.VK_A)
						{
							man.setDX(0);
						}
						if(e.getKeyCode()== e.VK_D)
						{
							man.setDX(0);
						}
						
					}

					@Override
					public void keyTyped(KeyEvent e) 
					{
						
						
					}
					
				});
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args)
	{
		new WalkingFrame();
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		man.update();
		if(ballArray.size() != 0)
		{
			for(int i = ballArray.size()-1; i>=0; i--)
			{
				ballArray.get(i).update();
				if(ballArray.get(i).getX() > getWidth())
				{
					remove(ballArray.get(i));
					ballArray.remove(ballArray.get(i));
				}
			}
		}
		repaint();
		
	}
}
