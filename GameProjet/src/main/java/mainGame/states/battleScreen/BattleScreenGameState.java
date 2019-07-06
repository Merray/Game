package mainGame.states.battleScreen;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.HorizontalSplitTransition;
import org.newdawn.slick.state.transition.Transition;
import org.newdawn.slick.util.ResourceLoader;

import mainGame.MainGame;
import mainGame.states.mainScreen.MainScreenGameState;

public class BattleScreenGameState extends BasicGameState
{

	public static final int ID = 2;
	private StateBasedGame game;
	private GameContainer container;

	// Images/Sprites
	private Image backgroundImage;
	private Image enemy;
	private Image perso;

	// Sons/Musiques
	private Music backgroundMusic;

	// Transitions
	private Transition transition;

	// Fonts
	private TrueTypeFont font1;
	private TrueTypeFont font2;

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException
	{
		this.container = container;
		this.game = game;
		this.enemy = new Image("sprites/gobelin.png").getScaledCopy(2.5f);
		this.perso = new Image("sprites/perso.png").getScaledCopy(2.5f);
		this.backgroundImage = new Image("backgroundImages/battleScreenBackground.jpg");
		this.backgroundMusic = new Music("music/FFIX_Battle.ogg");

		try
		{
			InputStream inputStream = ResourceLoader.getResourceAsStream("fonts/SuperMario256.ttf");
			Font laFont;
			laFont = Font.createFont(Font.TRUETYPE_FONT, inputStream);
			Font laGrosseFont = laFont.deriveFont(50f); // set font size
			laFont = laFont.deriveFont(24f); // set font size
			font1 = new TrueTypeFont(laGrosseFont, false);
			font2 = new TrueTypeFont(laFont, false);
		} catch (FontFormatException e)
		{

			e.printStackTrace();
		} catch (IOException e)
		{

			e.printStackTrace();
		}

	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException
	{
		this.backgroundImage.draw(0, 0, container.getWidth(), container.getHeight());
		this.enemy.drawCentered(container.getWidth() * 3 / 4, container.getHeight() / 2);
		this.perso.drawCentered(container.getWidth() * 1 / 4, container.getHeight() / 2);

		g.setColor(Color.white);
		g.setFont(font2);
		g.drawString("Press ESC to go back to main menu", (MainGame.GAME_WIDTH * 2 / 10) - 15,
				MainGame.GAME_HEIGH * 3 / 4);
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException
	{

	}

	@Override
	public void enter(GameContainer container, StateBasedGame game) throws SlickException
	{
		backgroundMusic.loop(1f, 0.2f);
		transition = new HorizontalSplitTransition();
	}

	@Override
	public void leave(GameContainer container, StateBasedGame game) throws SlickException
	{
		backgroundMusic.stop();

	}

	public void keyReleased(int key, char c)
	{
		switch (key)
		{
		case Input.KEY_ESCAPE:
			game.enterState(MainScreenGameState.ID, null, transition);
			break;
		}
	}

	@Override
	public int getID()
	{
		return ID;
	}

}
