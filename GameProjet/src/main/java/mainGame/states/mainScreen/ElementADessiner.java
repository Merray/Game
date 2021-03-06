package mainGame.states.mainScreen;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class ElementADessiner
{

	private String texte;

	private int posX;

	private int posY;

	private boolean selected;

	public ElementADessiner()
	{
		super();
	}

	public ElementADessiner(String texte, int posX, int posY, boolean selected)
	{
		super();
		this.texte = texte;
		this.posX = posX;
		this.posY = posY;
		this.selected = selected;
	}

	public void draw(Graphics g)
	{
		if (selected)
		{
			g.setColor(Color.yellow);
			g.drawRect(posX - 10, posY - 10, 182, 40);
			g.drawString(texte, posX, posY);
		} else
		{
			g.setColor(Color.white);
			g.drawString(texte, posX, posY);
		}

		g.setColor(Color.white);
	}

	public String getTexte()
	{
		return texte;
	}

	public void setTexte(String texte)
	{
		this.texte = texte;
	}

	public int getPosX()
	{
		return posX;
	}

	public void setPosX(int posX)
	{
		this.posX = posX;
	}

	public int getPosY()
	{
		return posY;
	}

	public void setPosY(int posY)
	{
		this.posY = posY;
	}

	public boolean isSelected()
	{
		return selected;
	}

	public void setSelected(boolean selected)
	{
		this.selected = selected;
	}

}
