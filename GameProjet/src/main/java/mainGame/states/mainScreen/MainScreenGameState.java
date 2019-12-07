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
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.state.transition.Transition;
import org.newdawn.slick.util.ResourceLoader;

import mainGame.states.battleScreen.BattleScreenGameState;

public class MainScreenGameState extends BasicGameState
{

	public static final int ID = 1;
	private StateBasedGame game;
	private GameContainer container;

	// Images/Sprites
	private Image backgroundImage;
	private Image HUDImage;

	// Sons/Musiques
	private Music backgroundMusic;
	private boolean musicOn = true;
	private Sound selectionSound;
	private Sound validationSound;

	// Transitions
	private Transition fadeOutTransition;
	private Transition fadeInTransition;

	// Fonts
	private TrueTypeFont normalTrueTypeFont;
	private TrueTypeFont titleTrueTypeFont;

	// Liste des éléments
	private ListeMenu liste;

	public void init(GameContainer container, StateBasedGame game) throws SlickException
	{
		this.container = container;
		this.game = game;
		this.backgroundImage = new Image("backgroundImages/mainScreenBackground2.png");
		this.HUDImage = new Image("backgroundImages/Titre_HUD_105%.png");
		this.backgroundMusic = new Music("music/Strike the Earth.ogg");
		this.selectionSound = new Sound("sounds/selection_sound_2.ogg");
		this.validationSound = new Sound("sounds/Metal_Slug_Okay.ogg");

		/*
		 * La font
		 */
		try
		{
			InputStream inputStream = ResourceLoader.getResourceAsStream("fonts/SuperMario256.ttf");
			Font laFont = Font.createFont(Font.TRUETYPE_FONT, inputStream).deriveFont(24f);
			Font laGrosseFont = laFont.deriveFont(50f);

			this.normalTrueTypeFont = new TrueTypeFont(laGrosseFont, false);
			this.titleTrueTypeFont = new TrueTypeFont(laFont, false);

		} catch (FontFormatException e)
		{

			e.printStackTrace();
		} catch (IOException e)
		{

			e.printStackTrace();
		}

		/*
		 * Création de la liste du menu
		 */
		liste = new ListeMenu();
		liste.ajouter(new ElementADessiner("New Game", 300, 450, true));
		liste.ajouter(new ElementADessiner(" Options  ", 300, 500, false));
		liste.ajouter(new ElementADessiner("Leave Game", 300, 550, false));

	}

	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException
	{
		/*
		 * Dessin de l'image de fond
		 */
		this.backgroundImage.draw(0, 0, container.getWidth(), container.getHeight());
		HUDImage.draw(110, 165, HUDImage.getWidth(), HUDImage.getHeight());

		/*
		 * Titre du jeu
		 */
		g.setFont(normalTrueTypeFont);
		g.setColor(Color.blue);
		g.drawString("LE JEU : The Game", 125, 175);

		/*
		 * Le reste
		 */
		g.setFont(titleTrueTypeFont);
		g.setColor(Color.black);
		g.drawString("Press P to pause or resume music", 150, 300);
		g.drawString("Arrow keys to navigate", 220, 335);
		g.drawString("Enter to confirm choice", 220, 370);

		/*
		 * Dessin ON/OFF en fonction de la musique
		 */
		if (musicOn)
		{
			g.drawString("Music : ON", container.getHeight() - 10, 15);
		} else
		{
			g.drawString("Music : OFF", container.getHeight() - 10, 15);
		}

		/*
		 * On dessine la liste à la fin
		 */
		liste.draw(g);

	}

	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException
	{

	}

	@Override
	public void enter(GameContainer container, StateBasedGame game) throws SlickException
	{
		backgroundMusic.loop(1f, 0.2f);
		fadeOutTransition = new FadeOutTransition();
		fadeInTransition = new FadeInTransition();
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
			container.exit();
			break;
		case Input.KEY_ENTER:
			validationSound.play(1f, 0.3f);
			if (liste.getListe().get(2).isSelected())
			{
				container.exit();
			} else if (liste.getListe().get(0).isSelected())
			{
				game.enterState(BattleScreenGameState.ID, fadeOutTransition, fadeInTransition);
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
			selectionSound.play(1f, 0.4f);
			liste.next();
			break;
		case Input.KEY_UP:
			selectionSound.play(1f, 0.4f);
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
