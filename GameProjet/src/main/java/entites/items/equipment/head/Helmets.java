package entites.items.equipment.head;

import entites.battle.player.BattlePlayer;

public enum Helmets implements Head
{
	NONE("None", 0, 0), RUBBER_HELM("Rubber helm", 5, 250);

	private String name;

	private Integer magicDefense;

	private Integer cost;

	private Helmets(String name, Integer magicDefense, Integer cost)
	{
		this.name = name;
		this.magicDefense = magicDefense;
		this.cost = cost;
	}

	@Override
	public String getName()
	{
		return name;
	}

	@Override
	public void applyStats(BattlePlayer target)
	{
		target.setMagicDefense(target.getMagicDefense() + magicDefense);
	}

	@Override
	public Integer getCost()
	{
		return cost;
	}

}
