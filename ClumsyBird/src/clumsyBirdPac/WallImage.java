package clumsyBirdPac;

import java.awt.Graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import java.awt.Rectangle;
public class WallImage {
	private Random r = new Random();
	//coordinates for the walls
	public int x; 
	public int y = r.nextInt(GamePanel.HEIGHT-400) + 200; //generates random numbers between 0 - 600 so that there are differing height of walls
	
	private int widthWall = 45; //set width of wall
	private int height = GamePanel.HEIGHT-y; //uses random y coordinate given restrictions 
	private int gap = 200; //gap between the walls
	
	public static int speed = -6;
	
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
	private void wallReset() {
		y = r.nextInt(GamePanel.HEIGHT-400) + 200;
		height = GamePanel.HEIGHT-y;
		GamePanel.gameOver = true;
		
	}
	
	public void wallMovement() {
		//will continuously decrease x coordinate to move the walls
		x+=speed; //only worried about x coordinate, bc wall moves parallel to x axis
		
		//need to reset wall position once it is out of screen 
		if (x <=-widthWall) {
			x = GamePanel.WIDTH;
			y = r.nextInt(GamePanel.HEIGHT-400) + 200;
			height = GamePanel.HEIGHT-y; 
		}
		
		//takes in arguments for each of the wall obstacles (their coordinates, width, and height)
		Rectangle lowerRect = new Rectangle(x, y, widthWall, height); 
		Rectangle upperRect = new Rectangle(x, 0, widthWall, GamePanel.HEIGHT-(height + gap)); //top wall height is 0 (on top); Gets entire height and subtracts that from the height of lower wall + gap between walls
		
		if (lowerRect.intersects(BirdImage.getBirdRect()) || upperRect.intersects(BirdImage.getBirdRect())) { //if the bird hits a wall, we run the helper methods to reset bird and wall
			boolean option = GamePanel.popUpMessage();
			
			if (option == true) {
				try {
					Thread.sleep(500);
					
				}catch (Exception e){
					e.printStackTrace();
				}
				BirdImage.reset();
				wallReset();
			}
			else { //uses method from main bird to retrieve the window, dispose of it, and restart the timer 
				JFrame frame = MainBird.getWindow();
				frame.dispose();
				MainBird.timer.stop();
				
			}
			
		}
		
		
	}

	
	
}
