package entites.items.equipment.arm;

import entites.battle.player.BattlePlayer;

public enum Armlets implements Arm
{
	NONE("None", 0, 0, 0), JADE_ARMLET("Jade armlet", 0, 29, 3400);

	private String name;

	private Integer evasion;

	private Integer magicEvasion;

	private Integer cost;

	private Armlets(String name, Integer evasion, Integer magicEvasion, Integer cost)
	{
		this.name = name;
		this.evasion = evasion;
		this.magicEvasion = magicEvasion;
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
		target.setEvasion(target.getEvasion() + evasion);
		target.setMagicEvasion(target.getMagicEvasion() + magicEvasion);
	}

	@Override
	public Integer getCost()
	{
		return cost;
	}

}
