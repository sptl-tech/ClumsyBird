package clumsyBirdPac;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class BirdImage {
	
	private BufferedImage img = null;
	private static int birdDiameter = 40;
	
	//Coordinates for bird -- places bird initially middle of the screen
	public static int x = (GamePanel.WIDTH / 2) - birdDiameter/2; //x coordinate for bird -- places bird halfway across the screen
	public static int y = (GamePanel.HEIGHT/2); //y coordinate of bird -- places bird halfway up the screen 
	
	public BirdImage() {
		
		LoadImage();
	}

	private void LoadImage() { //method to load in bird image
		try {
			img = ImageIO.read(new File("/Users/sahil/Projects/clumsyBird/ClumsyBird/images/bird.png"));
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void drawBird(Graphics g) { //method to draw bird on screen
		g.drawImage(img, x, y, null);
	}
	
}