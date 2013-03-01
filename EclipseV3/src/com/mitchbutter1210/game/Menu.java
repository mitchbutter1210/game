package com.mitchbutter1210.game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

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
		g.drawString("Welcome to Tentacle Wizard!!!", 200, 200);
		g.drawString("Press enter to play!!!!!", 200, 230);
		g.drawString("Press q to quit :(", 200, 260);

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
