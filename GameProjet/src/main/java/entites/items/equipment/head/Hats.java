package entites.items.equipment.head;

import entites.battle.player.BattlePlayer;

public enum Hats implements Head
{
	NONE("None", 0, 0, 0, 0), LEATHER_HAT("Leather Hat", 0, 0, 6, 150);

	private String name;

	private Integer defense;

	private Integer evasion;

	private Integer magicDefense;

	private Integer cost;

	private Hats(String name, Integer defense, Integer evasion, Integer magicDefense, Integer cost)
	{
		this.name = name;
		this.defense = defense;
		this.evasion = evasion;
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
		target.setEvasion(target.getEvasion() + evasion);
		target.setMagicDefense(target.getMagicDefense() + magicDefense);
	}

	@Override
	public Integer getCost()
	{
		return cost;
	}

}
