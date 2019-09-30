package entites.items.equipment.accessory;

import entites.battle.player.BattlePlayer;

public enum Rings implements Accessory
{
	NONE("None");

	String name;

	private Rings(String name)
	{
		this.name = name;
	}

	@Override
	public String getName()
	{
		return name;
	}

	@Override
	public void applyStats(BattlePlayer target)
	{
		// TODO Raccord de méthode auto-généré
	}

	@Override
	public Integer getCost()
	{
		return null; // TODO Raccord de méthode auto-généré
	}

}
