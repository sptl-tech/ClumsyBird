package clumsyBirdPac;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MenuPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BufferedImage img = null; 
	
	public MenuPanel() {
		LoadImage();
		//handle a mouse click event
	}

	private void LoadImage() { //takes in the image of the created menu panel and throws error otherwise
		
		try {
			img = ImageIO.read(new File("/Users/sahil/Projects/clumsyBird/ClumsyBird/images/menu.png"));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void paint (Graphics g) { //need override method so that toolkit can use the method 
		super.paint(g);
		
		g.drawImage(img, 0, 0, GamePanel.WIDTH, GamePanel.HEIGHT, null);
	}
}
