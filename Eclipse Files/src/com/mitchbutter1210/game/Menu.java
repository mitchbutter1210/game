package com.mitchbutter1210.game;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Menu extends BasicGameState {

	public Menu(int state) {
		
	}

	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		

	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		g.drawString("Developed by Mitchell Butterfield", 50, 50);
		g.drawString("Made with the Slick 2d library", 50, 65);
		g.drawString("Press Enter to play", 275, 275);
		g.drawString("Press q to quit", 275, 290);

	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		Input input = container.getInput();
		
		if(input.isKeyDown(Input.KEY_ENTER)){
			game.enterState(1);
		}
		
		if(input.isKeyDown(Input.KEY_Q)){
			container.exit();
		}

	}

	@Override
	public int getID() {
		return 0;
	}

}
