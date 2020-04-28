package javagame;



import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.geom.*;

public class Player 
{
	private int x;
	private int y;
	private int screenX;
	private int screenY;
	public Animation playerAnim, movingUp, movingDown, movingLeft, movingRight;
	public int[] duration = {200, 200, 200, 200};
	
	public Player()
	{
		// Start player in middle of first screen
		x = Game.WIDTH / 2;
		y = Game.HEIGHT / 2;
		screenX = Game.WIDTH / 2;
		screenY = Game.HEIGHT / 2;
	}
	private Animation a;
	
		public Animation getAnimation (Image i, int spriteX, int spriteY, int spriteWidth, int spriteHeight, int frames, int duration ){
			
			Animation a = new Animation(false);
		
			for(int y = 0 ; y < spriteY; y++) {
				for(int x = 0 ; x < spriteX; x++) {

					a.addFrame( i.getSubImage(x*spriteWidth, y*spriteHeight, spriteWidth, spriteHeight), duration);
		
				}
			}
		
			return a;
		}
	public void init() throws SlickException
	{
		// Call get animation method to 
		
		Image walkUp = new Image("res/sprites/walkingup.png");
		a = getAnimation(walkUp, 4, 1, 16, 24, 4, 100);
		
		Image walkDown = new Image("res/sprites/walkingdown.png");
		a = getAnimation(walkDown, 4, 1, 16, 24, 4, 100);
		
		Image walkLeft = new Image("res/sprites/walkingleft.png");
		a = getAnimation(walkLeft, 4, 1, 16, 24, 4, 100);
		
		Image walkRight = new Image("res/sprites/walkingright.png");
		a = getAnimation(walkRight, 4, 1, 16, 24, 4, 100);
		
		/*
		// Creates the animation
		Image[] walkUp = 
			{
				new Image("res/character_walking/up_1.png"),
				new Image("res/character_walking/up_2.png"),
				new Image("res/character_walking/up_3.png"),
				new Image("res/character_walking/up_4.png")
			};
		
		Image[] walkDown = 
			{
				new Image("res/character_walking/down_1.png"),
				new Image("res/character_walking/down_2.png"),
				new Image("res/character_walking/down_3.png"),
				new Image("res/character_walking/down_4.png")
			};
		
		Image[] walkLeft = 
			{
				new Image("res/character_walking/left_1.png"),
				new Image("res/character_walking/left_2.png"),
				new Image("res/character_walking/left_3.png"),
				new Image("res/character_walking/left_4.png")
			};
		
		Image[] walkRight = 
			{
				new Image("res/character_walking/right_1.png"),
				new Image("res/character_walking/right_2.png"),
				new Image("res/character_walking/right_3.png"),
				new Image("res/character_walking/right_4.png")
			};
		
		movingUp = new Animation(walkUp, duration, true);
		movingUp.setLooping(true);
		
		movingDown = new Animation(walkDown, duration, true);
		movingDown.setLooping(true);
		
		movingLeft = new Animation(walkLeft, duration, true);
		movingLeft.setLooping(true);
		
		movingRight = new Animation(walkRight, duration, true);
		movingRight.setLooping(true);
		
		// Points to which 
		playerAnim = movingDown;
		
		*/
	}
	
	public void update(int delta, GameContainer container) throws SlickException
	{
		
		// Links Player animation with keyboard input
		if(Controls.moveUp(container))
		{
			// Sets which Animation to play
			playerAnim = movingUp;
			// Moves the character
			y -= (delta * .2f);
			// Starts the Animation
			playerAnim.start();
		}
		if(Controls.moveDown(container))
		{
			playerAnim = movingDown;
			y += (delta * .2f);
			playerAnim.start();
		}
		if(Controls.moveLeft(container))
		{
			playerAnim = movingLeft;
			x -= (delta * .2f);
			playerAnim.start();
		}
		if(Controls.moveRight(container))
		{
			playerAnim = movingRight;
			x += (delta * .2f);
			playerAnim.start();
		}
		if (Controls.noMovement(container))
		{
			playerAnim.stop();
		}
		
	}
	
	public int getX()
	{
		return this.x;
	}
	
	public int getY()
	{
		return this.y;
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	public int getScreenX()
	{
		return this.screenX;
	}
	
	public int getScreenY()
	{
		return this.screenY;
	}
	
	public void setScreenX(int x)
	{
		this.screenX = x;
	}
	
	public void setScreenY(int y)
	{
		this.screenY = y;
	}
}
