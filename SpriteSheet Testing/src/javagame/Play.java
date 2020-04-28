package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState {
	
	private Animation a;
	
	public Animation getAnimation (Image i, int spriteX, int spriteY, int spriteWidth,
									int spriteHeight, int frames, int duration ){
		
		Animation a = new Animation(false);
		
		for(int y = 0 ; y < spriteY; y++) {
			for(int x = 0 ; y < spriteX; x++) {

			a.addFrame( i.getSubImage(x*spriteWidth, y*spriteHeight, spriteWidth, spriteHeight), duration);
		
			}
		}
		
		return a;
	}
	
	public Play(int state) {
		
	}

	public void init(GameContainer container, StateBasedGame sbg) throws SlickException {
		Image i = new Image("res/sprites/walkingdown.png");
		a = getAnimation(i, 4, 1, 16, 24, 4, 100);
		
	}
	
	public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException {
		a.update(delta);
		
	}

	public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException {
		a.draw(10, 10);
				
	}
	

	public int getID() {
		return 1;
	}

}
