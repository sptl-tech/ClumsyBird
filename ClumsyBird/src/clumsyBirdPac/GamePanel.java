package clumsyBirdPac;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 600;
	public static final int HEIGHT = 900;
	
	private int xCoor = 0; //inital x coordinate value which will change as game goes on
	private BufferedImage img;
	
	BirdImage bi = new BirdImage();
	WallImage wi = new WallImage(GamePanel.WIDTH);
	WallImage wi2 = new WallImage(GamePanel.WIDTH + (GamePanel.WIDTH/2));
	
	public GamePanel() {
		LoadImage(); 
		this.addMouseListener(new MouseAdapter() { //method to ensure that bird goes upward on click of the mouse
			public void mousePressed (MouseEvent e) {
				super.mousePressed(e); //mouse pressed -- as soon as you press button, action gets fired
				bi.goUpwards(); //sets speed to negative value to move bird up
			}
		});
		
	}

	private void LoadImage() {
		
		try {
			img = ImageIO.read(new File("/Users/sahil/Projects/clumsyBird/ClumsyBird/images/background.png"));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	 
	public void paint (Graphics g) { //need override method so that toolkit can use the method 
		super.paint(g);
		
		g.drawImage(img, xCoor, 0, null); //draws the initial game panel
		bi.drawBird(g); //draws a bird on the game panel
		wi.drawWall(g); //draws first wall on game panel
		wi2.drawWall(g); //draws second wall and loops through
	} 
	
	public void Move() {
		bi.birdMovement();
	}
}
