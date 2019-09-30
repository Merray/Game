package entites.items.equipment.body;

import entites.battle.player.BattlePlayer;

public enum LightArmors implements Body
{
	NONE("None", 0, 0, 0), LEATHER_SHIRT("Leather shirt", 6, 0, 270);

	private String name;

	private Integer defense;

	private Integer magicDefense;

	private Integer cost;

	private LightArmors(String name, Integer defense, Integer magicDefense, Integer cost)
	{
		this.name = name;
		this.defense = defense;
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
		target.setDefense(target.getDefense() + defense);
		target.setMagicDefense(target.getMagicDefense() + magicDefense);
	}

	@Override
	public Integer getCost()
	{
		return cost;
	}

}
