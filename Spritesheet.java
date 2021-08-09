package zeldaminiclone;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Spritesheet {
	
	public static BufferedImage spritesheet;
	public static BufferedImage[] player_front;
	public static BufferedImage player_back;
	public static BufferedImage player_left;
	public static BufferedImage player_right;
	public static BufferedImage muro_lateral;
	public static BufferedImage []inimigo_right;
	public static BufferedImage []inimigo_left;
	
	public Spritesheet() {
		try {
		 spritesheet = ImageIO.read(getClass().getResource("/spritesheet.png"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		player_front = new BufferedImage[2];
		inimigo_right = new BufferedImage[2];
		inimigo_left= new BufferedImage[2];
		
		player_front[0] = Spritesheet.getSprite(36, 10,16,16);
		player_front[1] = Spritesheet.getSprite(36, 28, 16,16);
		inimigo_right[0]= Spritesheet.getSprite(86, 10, 33, 33);
		inimigo_right[1]= Spritesheet.getSprite(143, 10, 33, 33);
		inimigo_left[0]= Spritesheet.getSprite(18, 46, 16, 16);
		inimigo_left[1]= Spritesheet.getSprite(18, 62, 16, 16);
		player_back= Spritesheet.getSprite(50, 10, 16, 16);
		player_left= Spritesheet.getSprite(21, 10, 16, 16);
		player_right= Spritesheet.getSprite(0, 10, 16, 16);
		muro_lateral= Spritesheet.getSprite(69,11, 16, 16);
	}
	
	public static BufferedImage getSprite(int x, int y, int width, int height) {
		return spritesheet.getSubimage(x, y, width, height);
	}
}
