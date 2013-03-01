package com.mitchbutter1210.game;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

public class Play extends BasicGameState {
	
	Animation squid, movingLeft, movingRight, notMoving;
	int[] duration = {200, 200};
	TiledMap map;
	int playerX = 0, playerY = 0, shiftX = 300, shiftY = 340;
	Image player;
	Sound music;
	boolean quit = false;

	public Play(int state) {
	}

	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		
		Image[] walkLeft = {new Image("res/movingLeft.png"), new Image("res/movingLeft.png")};
		Image[] walkRight = {new Image("res/movingRight.png"), new Image("res/movingRight.png")};
		Image[] noWalk = {new Image("res/player.png"), new Image("res/player.png")};
		
		movingLeft = new Animation(walkLeft, duration, false);
		movingRight = new Animation(walkRight, duration, false);
		notMoving = new Animation(noWalk, duration, false);
		squid = notMoving;
		
		map = new TiledMap("res/Map.tmx", "res");
		player = new Image("res/player.png");
		music = new Sound("res/177087__questiion__lost-moon-s-a-variables-variable.ogg");
		music.loop();

	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		map.render(playerX, playerY);
		squid.draw(shiftX, shiftY);
		g.drawString("X: " + playerX, 50, 50);
		g.drawString("Y: " + playerY, 50, 65);
		g.drawString("Press escape to pause!", 50, 80);

		if(quit == true){
			g.drawString("Resume - R", 200, 200);
			g.drawString("Menu - M", 200, 230);
			if(quit == false){
				g.clear();
			}
		}
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		Input input = container.getInput();
		squid = notMoving;
		
		if(input.isKeyDown(Input.KEY_LEFT)){
			squid = movingLeft;
			playerX += delta * .2f;
			if(playerX >= 296){
				playerX = 296;
			}
		}
		
		if(input.isKeyDown(Input.KEY_RIGHT)){
			squid = movingRight;
			playerX -= delta * .2f;
			if(playerX <= -235){
				playerX = -235;
			}
		}
		
		if(input.isKeyDown(Input.KEY_ESCAPE)){
			quit = true;
			container.pause();
		}
		
		if(quit == true){
			if(input.isKeyDown(Input.KEY_R)){
				quit = false;
				container.resume();
			}
			
			if(input.isKeyDown(Input.KEY_M)){
				game.enterState(0);
			}
		}

	}

	@Override
	public int getID() {
		return 1;
	}

}
