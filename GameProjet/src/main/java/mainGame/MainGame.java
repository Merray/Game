package mainGame;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import mainGame.states.MainScreenGameState;

public class MainGame extends StateBasedGame
{
	public static int GAME_WIDTH = 800;
	public static int GAME_HEIGH = 600;

	public static void main(String[] args) throws SlickException
	{
		new AppGameContainer(new MainGame(), GAME_WIDTH, GAME_HEIGH, false).start();
	}

	public MainGame()
	{
		super("Notre super jeu");
	}

	/*
	 * Ajouter ici toutes les boucles de jeu
	 */
	@Override
	public void initStatesList(GameContainer gameContainer) throws SlickException
	{

		addState(new MainScreenGameState());
	}

}
