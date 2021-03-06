package clumsyBirdPac;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
	public boolean startingPoint = false; //if we are still on menu screen or game started
	
	public MenuPanel() {
		LoadImage();
		
		this.addMouseListener(new MouseAdapter() { //method to handle changing from start screen to game when clicked using mouse
			public void mouseClicked (MouseEvent e) {
				super.mouseClicked(e);
				startingPoint = true; //once clicked, boolean value becomes true allowing game to progress
			}
		});
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
