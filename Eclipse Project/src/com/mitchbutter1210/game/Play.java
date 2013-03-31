package com.mitchbutter1210.game;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState {
	
	Animation squid, movingLeft, movingRight, notMoving;
	int[] duration = {200, 200};
	Image background, player, enemy;
	float playerX = 0, playerY = 0;
	float shiftX = 200, shiftY = 200;
	boolean quit = false;

	public Play(int state) {
		
	}

	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		background = new Image("res/space.jpg");
		
		Image[] moveLeft = {new Image("res/movingLeft.png"), new Image("res/movingLeft.png")};
		Image[] moveRight = {new Image("res/movingRight.png"), new Image("res/movingRight.png")};
		Image[] noMove = {new Image("res/player.png"), new Image("res/player.png")};
		
		movingLeft = new Animation(moveLeft, duration, false);
		movingRight = new Animation(moveRight, duration, false);
		notMoving = new Animation(noMove, duration, false);
		squid = notMoving;

	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		background.draw(playerX, playerY);
		squid.draw(shiftX, shiftY);
		
		g.drawString("X: " + playerX, 50, 50);
		g.drawString("Y: " + playerY, 50, 65);
		g.drawString("Use WASD to move and Escape to pause", 50, 80);
		
		if(quit == true){
			g.drawString("Resume - R", 350, 250);
			g.drawString("Menu - M", 350, 265);
			g.drawString("Quit - Q", 350, 280);
			
			if(quit == false){
				g.clear();
			}
		}

	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		squid = notMoving;
		Input input = container.getInput();
		
		if(quit == false){
			if(input.isKeyDown(Input.KEY_W)){
				playerY += delta * .3f;
				if(playerY >= 210){
					playerY = 210;
				}
			}
			
			if(input.isKeyDown(Input.KEY_S)){
				playerY -= delta * .3f;
				if(playerY <= -320){
					playerY = -320;
				}
			}
			
			if(input.isKeyDown(Input.KEY_A)){
				squid = movingLeft;
				playerX += delta * .3f;
				if(playerX >= 230){
					playerX = 230;
				}
			}
			
			if(input.isKeyDown(Input.KEY_D)){
				squid = movingRight;
				playerX -= delta * .3f;
				if(playerX <= -527){
					playerX = -527;
				}
			}
			
			if(input.isKeyDown(Input.KEY_ESCAPE)){
				quit = true;
			}
		}
		
		if(quit == true){
			if(input.isKeyDown(Input.KEY_R)){
				quit = false;
			}
			
			if(input.isKeyDown(Input.KEY_M)){
				playerX = 0;
				playerY = 0;
				quit = false;
				game.enterState(0);
			}
			
			if(input.isKeyDown(Input.KEY_Q)){
				container.exit();
			}
		}

	}

	@Override
	public int getID() {
		return 1;
	}

}
