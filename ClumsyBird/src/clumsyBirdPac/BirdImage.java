package clumsyBirdPac;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class BirdImage {
	
	private BufferedImage img = null;
	private static int birdDiameter = 36;
	
	//Coordinates for bird -- places bird initially middle of the screen
	public static int x = (GamePanel.WIDTH / 2) - birdDiameter/2; //x coordinate for bird -- places bird halfway across the screen
	public static int y = (GamePanel.HEIGHT/2); //y coordinate of bird -- places bird halfway up the screen 
	
	public static int speed =2;
	private int accel = 1;
	
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
	
	public void birdMovement() {
		if(y>=0 && y<=GamePanel.HEIGHT) { //case if bird is on screen
			speed += accel; 
			y+=speed; //changes the birds relative height
		}else { //sets back to initial values
	boolean option = GamePanel.popUpMessage();
			
			if (option == true) {
				try {
					Thread.sleep(500);
					
				}catch (Exception e){
					e.printStackTrace();
				}
				reset();
			}
			else {
				JFrame frame = MainBird.getWindow();
				frame.dispose();
				MainBird.timer.stop();
			}
		}
	}
	
	public void goUpwards() {
		speed = -17; //reasoning is that y in bird movement is dependent on the speed, so negative speed will cause bird to have higher y coordinate
		
	}

	public static void reset() { 
		speed = 2;
		y = GamePanel.HEIGHT/2;
		GamePanel.gameOver = true; //if bird hits top or bottom of screen, game ends
		GamePanel.score = 0; //reset score to 0 after hitting a wall or going out of bounds
	}
	
	public static Rectangle getBirdRect() {
		Rectangle birdRect = new Rectangle(x, y, birdDiameter, 35);
		return birdRect;
	}
	
}
