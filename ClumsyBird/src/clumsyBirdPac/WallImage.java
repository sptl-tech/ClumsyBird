package clumsyBirdPac;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

import javax.imageio.ImageIO;

public class WallImage {
	private Random r = new Random();
	//coordinates for the walls
	public int x; 
	public int y = r.nextInt(GamePanel.HEIGHT-400) + 200; //generates random numbers between 0 - 600 so that there are differing height of walls
	
	private int widthWall = 45; //set width of wall
	private int height = GamePanel.HEIGHT-y; //uses random y coordinate given restrictions 
	private int gap = 200; //gap between the walls
	
	private BufferedImage img = null;
	
	public WallImage (int x) {
		this.x = x;
		
		LoadImage();
	}

	private void LoadImage() {
		try {
			img = ImageIO.read(new File ("/Users/sahil/Projects/clumsyBird/ClumsyBird/images/Wall.png"));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void drawWall(Graphics g) {
		g.drawImage(img, x, y, null); //bottom wall 
		g.drawImage(img, x, (-GamePanel.HEIGHT) + (y-gap), null); //upper wall --  starts from top of game panel and with random values, will generate walls on the top part of game panel
	}
	
}
