package mainGame.states.mainScreen;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Graphics;

public class ListeMenu
{
	private List<ElementADessiner> liste;

	private int selectedItem = 0;

	public ListeMenu()
	{
		super();
		liste = new ArrayList<ElementADessiner>();
	}

	public ListeMenu(List<ElementADessiner> liste)
	{
		super();
		liste.get(0).setSelected(true);
		this.liste = liste;

	}

	public void draw(Graphics g)
	{

		for (ElementADessiner element : liste)
		{
			element.draw(g);
		}

	}

	public void next()
	{

		liste.get(selectedItem).setSelected(false);
		if (selectedItem == liste.size() - 1)
		{
			selectedItem = 0;
		} else
		{
			selectedItem += 1;
		}
		liste.get(selectedItem).setSelected(true);
	}

	public void previous()
	{
		liste.get(selectedItem).setSelected(false);
		if (selectedItem == 0)
		{
			selectedItem = liste.size() - 1;
		} else
		{
			selectedItem -= 1;
		}
		liste.get(selectedItem).setSelected(true);
	}

	public List<ElementADessiner> getListe()
	{

		return liste;
	}

	public void setListe(List<ElementADessiner> liste)
	{
		this.liste = liste;
	}

	public void ajouter(ElementADessiner element)
	{
		if (liste.isEmpty())
		{
			element.setSelected(true);
		}

		liste.add(element);
	}

}
