package clumsyBirdPac;

import javax.swing.JFrame;
public class MainBird {

	//Window: 1st panel is the intro screen -> if clicked, game starts and goes to 2nd panel w/ game
	private JFrame window;
	
	public MainBird() {
		window = new JFrame();
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //allows to terminate window
		window.setSize(GamePanel.WIDTH, GamePanel.HEIGHT); //window dimensions (width, height)
		window.setLocationRelativeTo(null); //pops up in middle of screen 
		window.setTitle("Clumsy Bird"); 
		window.setResizable(false); 
		window.setVisible(true);
	}
	
	private void rendering() {
		MenuPanel mp = new MenuPanel();
		window.add(mp); //adds menu panel to our window 
		window.setVisible(true);
	}
	
	public static void main(String[] args) {
		MainBird mb = new MainBird();
		mb.rendering();
		
	}

}
