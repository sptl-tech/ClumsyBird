package clumsyBirdPac;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import javax.swing.JFrame;
public class MainBird {

	//Window: 1st panel is the intro screen -> if clicked, game starts and goes to 2nd panel w/ game
	private static JFrame window;
	public static Timer timer;
	
	public MainBird() {
		window = new JFrame();
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //allows to terminate window
		window.setSize(GamePanel.WIDTH, GamePanel.HEIGHT); //window dimensions (width, height)
		window.setLocationRelativeTo(null); //pops up in middle of screen 
		window.setTitle("Clumsy Bird"); 
		window.setResizable(true); 
		window.setVisible(true);
	}
	
	private void rendering() {
		MenuPanel mp = new MenuPanel();
		GamePanel gp = new GamePanel();
		
		timer = new Timer(20, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) { //every 20 miliseconds, we call the repaint and move method to keep game functioning
				gp.repaint();
				gp.Move();
				
			}
		});
		
		window.add(mp); //adds menu panel to our window 
		window.setVisible(true);
		
		while (mp.startingPoint == false) { //while loop which loops infinite time unless you click on the screen and can proceed w/ game
			try {
				Thread.sleep(10);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		//once screen is clicked, remove the menu panel and set the game panel
		window.remove(mp);
		window.add(gp);
		gp.setVisible(true);
		window.revalidate();
		
		timer.start();
		
	}
	
	//method to retrieve entire window so it can be terminated if user does not want to continue playing
	public static JFrame getWindow() {
		return window;
	}
	
	public static void main(String[] args) {
		MainBird mb = new MainBird();
		mb.rendering();
		
	}
	
}
