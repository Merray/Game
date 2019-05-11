package mainGame.states;

import java.awt.Font;
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
import org.newdawn.slick.util.ResourceLoader;

public class MainScreenGameState extends BasicGameState
{

	public static final int ID = 1;
	private Image backgroundImage;
	private Music backgroundMusic;
	private boolean musicOn = true;
	private StateBasedGame game;
	private GameContainer container;

	public void init(GameContainer container, StateBasedGame game) throws SlickException
	{
		this.container = container;
		this.game = game;
		this.backgroundImage = new Image("backgroundImages/mainMenuBackground.png");
		this.backgroundMusic = new Music("music/megalovania.ogg");
		backgroundMusic.loop(1f, 0.1f);
	}

	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException
	{
		this.backgroundImage.draw(0, 0, container.getWidth(), container.getHeight());

		try
		{
			InputStream inputStream = ResourceLoader.getResourceAsStream("fonts/SuperMario256.ttf");

			Font laFont = Font.createFont(Font.TRUETYPE_FONT, inputStream);
			Font laGrosseFont = laFont.deriveFont(50f); // set font size
			laFont = laFont.deriveFont(24f); // set font size
			TrueTypeFont font1 = new TrueTypeFont(laGrosseFont, false);
			TrueTypeFont font2 = new TrueTypeFont(laFont, false);
			g.setFont(font1);
			g.setColor(Color.red);
			g.drawString("LE JEU : The Game", 125, 175);
			g.setFont(font2);
			g.setColor(Color.white);
			g.drawString("Press P to pause music", 200, 325);
			g.drawString("Press Enter to resume music", 160, 350);

			if (musicOn)
			{
				g.drawString("Music : ON", container.getHeight() - 10, 15);
			} else
			{
				g.drawString("Music : OFF", container.getHeight() - 10, 15);
			}

		} catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException
	{

	}

	public void keyReleased(int key, char c)
	{
		switch (key)
		{
		case Input.KEY_ESCAPE:
			container.exit();
			break;
		case Input.KEY_ENTER:
			musicOn = true;
			backgroundMusic.resume();
			break;
		case Input.KEY_P:
			musicOn = false;
			backgroundMusic.pause();
			break;

		default:
			break;
		}
	}

	@Override
	public int getID()
	{
		return ID;
	}

}
