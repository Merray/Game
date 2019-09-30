package entites.items.equipment.arm;

import entites.battle.player.BattlePlayer;

public enum Gauntlets implements Arm
{
	NONE("None", 0, 0, 0), BRONZE_GAUNTLET("Bronze gauntlet", 8, 2, 480);

	private String name;

	private Integer evasion;

	private Integer magicEvasion;

	private Integer cost;

	private Gauntlets(String name, Integer evasion, Integer magicEvasion, Integer cost)
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
