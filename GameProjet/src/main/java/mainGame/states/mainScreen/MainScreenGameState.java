package mainGame.states.mainScreen;

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
import org.newdawn.slick.Sound;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.ResourceLoader;

public class MainScreenGameState extends BasicGameState
{

	public static final int ID = 1;
	private StateBasedGame game;
	private GameContainer container;

	// Images/Sprites
	private Image backgroundImage;

	// Sons/Musiques
	private Music backgroundMusic;
	private boolean musicOn = true;
	private Sound selectionSound;
	private Sound validationSound;

	// Fonts
	private TrueTypeFont font1;
	private TrueTypeFont font2;

	// Liste des éléments
	private ListeMenu liste;

	public void init(GameContainer container, StateBasedGame game) throws SlickException
	{
		this.container = container;
		this.game = game;
		this.backgroundImage = new Image("backgroundImages/mainMenuBackground.png");
		this.backgroundMusic = new Music("music/ArcadeGameMusic.ogg");
		this.selectionSound = new Sound("sounds/selection_sound.ogg");
		this.validationSound = new Sound("sounds/validation_sound.ogg");
		backgroundMusic.loop(1f, 0.1f);

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

		liste = new ListeMenu();
		liste.ajouter(new ElementADessiner("New Game", 300, 450, true));
		liste.ajouter(new ElementADessiner("Options", 325, 500, false));
		liste.ajouter(new ElementADessiner("Leave Game", 300, 550, false));

	}

	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException
	{
		this.backgroundImage.draw(0, 0, container.getWidth(), container.getHeight());

		g.setFont(font1);
		g.setColor(Color.red);
		g.drawString("LE JEU : The Game", 125, 175);
		g.setFont(font2);
		g.setColor(Color.white);
		g.drawString("Press P to pause or resume music", 150, 325);

		liste.draw(g);

		if (musicOn)
		{
			g.drawString("Music : ON", container.getHeight() - 10, 15);
		} else
		{
			g.drawString("Music : OFF", container.getHeight() - 10, 15);
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
			validationSound.play(2f, 0.1f);
			if (liste.getListe().get(2).isSelected())
			{
				container.exit();
			}

			break;
		case Input.KEY_P:
			if (musicOn)
			{
				musicOn = false;
				backgroundMusic.pause();
			} else
			{
				musicOn = true;
				backgroundMusic.resume();
			}

			break;
		case Input.KEY_DOWN:
			selectionSound.play(2f, 0.1f);
			liste.next();
			break;
		case Input.KEY_UP:
			selectionSound.play(2f, 0.1f);
			liste.previous();
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
