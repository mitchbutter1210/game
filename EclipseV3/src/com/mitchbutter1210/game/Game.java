package com.mitchbutter1210.game;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends StateBasedGame {
	
	public static final String title = "Tentacle Wizard --- Version 3.0";
	public static final int menu = 0, play = 1;

	public Game() {
		super(title);
		this.addState(new Menu(menu));
		this.addState(new Play(play));
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(menu).init(gc, this);
		this.getState(play).init(gc, this);
		this.enterState(0);

	}
	
	public static void main(String[] args) {
		AppGameContainer app;
		
		try{
			app = new AppGameContainer(new Game());
			app.setDisplayMode(640, 640, false);
			app.setTargetFrameRate(60);
			app.start();
		}catch(SlickException e){
			e.printStackTrace();
			System.exit(1);
		}

	}

}
