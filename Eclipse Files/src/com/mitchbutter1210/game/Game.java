package com.mitchbutter1210.game;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Game extends StateBasedGame {
	
	public static final String gameName = "Game";
	public static final int menu = 0, play = 1;

	public Game() {
		super(gameName);
		this.addState(new Menu(menu));
		this.addState(new Play(play));
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		this.getState(menu).init(container, this);
		this.getState(play).init(container, this);
		this.enterState(0);

	}
	
	public static void main(String[] args) {
		AppGameContainer app;
		
		try{
			app = new AppGameContainer(new Game());
			app.setDisplayMode(800, 600, false);
			app.setTargetFrameRate(60);
			app.start();
		}catch(SlickException e){
			e.printStackTrace();
			System.exit(1);
		}

	}

}
