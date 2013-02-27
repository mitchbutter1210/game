package com.mitchbutter1210.game;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.tiled.TiledMap;

public class Main extends BasicGame {
	
	public static final String gameName = "Haven't really thought of a title --- Indev";
	TiledMap map;
	int playerX = 200, playerY = 200;
	Image player;

	public Main() {
		super(gameName);
		
	}

	@Override
	public void render(GameContainer container, Graphics g)
			throws SlickException {

		map.render(0, 0);
		g.drawImage(player, playerX, playerY);
		g.drawString("X: " + playerX, 50, 50);
		g.drawString("Y: " + playerY, 50, 65);
	}

	@Override
	public void init(GameContainer container) throws SlickException {

		map = new TiledMap("res/Map.tmx", "res");
		player = new Image("res/cursor.png");
	}

	@Override
	public void update(GameContainer container, int delta)
			throws SlickException {

		Input input = container.getInput();
		
		if(input.isKeyDown(Input.KEY_LEFT)){
			playerX -= 3;
			if(playerX <= 32){
				playerX = 32;
			}
		}
		
		if(input.isKeyDown(Input.KEY_RIGHT)){
			playerX += 3;
			if(playerX >= 588){
				playerX = 588;
			}
		}
		
		if(input.isKeyDown(Input.KEY_UP)){
			playerY -= 3;
			if(playerY <= 160){
				playerY = 160;
			}
		}
		
		if(input.isKeyDown(Input.KEY_DOWN)){
			playerY += 3;
			if(playerY >= 397){
				playerY = 397;
			}
		}
	}
	
	public static void main(String[] args) {
		AppGameContainer app;
		
		try{
			app = new AppGameContainer(new Main());
			app.setDisplayMode(640, 640, false);
			app.setTargetFrameRate(60);
			app.start();
		}catch(SlickException e){
			e.printStackTrace();
			System.exit(1);
		}

	}

}
