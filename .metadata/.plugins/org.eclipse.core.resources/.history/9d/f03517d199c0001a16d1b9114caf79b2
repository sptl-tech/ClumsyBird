package clumsyBirdPac;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

import javax.imageio.ImageIO;

public class WallImage {
	private Random r = new Random();
	public int x; 
	public int y = r.nextInt(GamePanel.HEIGHT-400) + 200;
	private int widthWall = 45;
	private int height = GamePanel.HEIGHT-y;
	private int gap = 200;
	
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
		g.drawImage(img, x, y, null);
		g.drawImage(img, x, (-GamePanel.HEIGHT) + (y-gap), null);
	}
	
}
