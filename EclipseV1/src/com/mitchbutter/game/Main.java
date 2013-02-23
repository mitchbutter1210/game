package com.mitchbutter.game;

import org.newdawn.slick.Animation;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Main extends BasicGame {
	
	Animation bucky, movingUp, movingDown, movingLeft, movingRight;
	int[] duration = {200, 200};
	Image world;
	public static final String gameName = "Untitled Game --- Version 1.0";
	public static float buckyX = 0, buckyY = 0;
	public static float shiftX = buckyX + 400;
	public static float shiftY = buckyY + 300;
	public static boolean quit = false;

	public Main(String title) {
		super(gameName);
			}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		g.drawImage(world, buckyX, buckyY);
		bucky.draw(shiftX, shiftY);
		g.drawString("X: " + buckyX, 50, 50);
		g.drawString("Y: " + buckyY, 50, 65);
		g.drawString("Press Esc to pause", 50, 80);
		g.drawString("Use the arrow keys to move", 50, 95);
		
		if(quit == true){
			g.drawString("Resume - R", 400, 300);
			g.drawString("Quit - Q", 400, 315);
			if(quit == false){
				g.clear();
			}
		}
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		world = new Image("res/world.png");
		
		Image[] walkUp = {new Image("res/buckysBack.png"), new Image("res/buckysBack.png")};
		Image[] walkDown = {new Image("res/buckysFront.png"), new Image("res/buckysFront.png")};
		Image[] walkLeft = {new Image("res/buckysLeft.png"), new Image("res/buckysLeft.png")};
		Image[] walkRight = {new Image("res/buckysRight.png"), new Image("res/buckysRight.png")};
		
		movingUp = new Animation(walkUp, duration, false);
		movingDown = new Animation(walkDown, duration, false);
		movingLeft = new Animation(walkLeft, duration, false);
		movingRight = new Animation(walkRight, duration, false);
		bucky = movingDown;
	}

	@Override
	public void update(GameContainer gc, int delta)
			throws SlickException {
		Input input = gc.getInput();
		
		if(input.isKeyDown(Input.KEY_LEFT)){
			bucky = movingLeft;
			buckyX += delta * .1f;
			if(buckyX > 400){
				buckyX -= delta * .1f;
			}
		}
		
		if(input.isKeyDown(Input.KEY_RIGHT)){
			bucky = movingRight;
			buckyX -= delta * .1f;
			if(buckyX < -760){
	            buckyX += delta * .1f;
	         }
		}
		
		if(input.isKeyDown(Input.KEY_UP)){
			bucky = movingUp;
			buckyY += delta * .1f;
			if(buckyY > 300){
				buckyY -= delta * .1f;
			}
		}
		
		if(input.isKeyDown(Input.KEY_DOWN)){
			bucky = movingDown;
			buckyY -= delta * .1f;
			if(buckyY < -460){
				buckyY += delta * .1f;
			}
		}
		
		if(input.isKeyDown(Input.KEY_ESCAPE)){
			quit = true;
			gc.pause();
		}
		
		if(quit == true){
			if(input.isKeyDown(Input.KEY_R)){
				quit = false;
				gc.resume();
			}
			if(input.isKeyDown(Input.KEY_Q)){
				System.exit(0);
			}
		}
	}

	public static void main(String[] args) {
		AppGameContainer app;
		try{
			app = new AppGameContainer(new Main(gameName));
			app.setDisplayMode(800, 600, false);
			app.start();
		}catch(SlickException e){
			e.printStackTrace();
			System.exit(1);
		}
	}

}
