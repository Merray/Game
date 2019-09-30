package entites.items.equipment.weapon;

import entites.battle.buff.Debuff;
import entites.battle.player.BattlePlayer;

public enum Daggers implements Weapon
{
	NONE("None", 0, null, null, null), DAGGER("Dagger", 12, null, null, 320);

	private String name;

	private Integer attack;

	private String element;

	private Debuff status;

	private Integer cost;

	private Daggers(String name, Integer attack, String element, Debuff status, Integer cost)
	{
		this.name = name;
		this.attack = attack;
		this.element = element;
		this.status = status;
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
		target.setAttack(target.getAttack() + attack);
	}

	@Override
	public void applyElement(BattlePlayer target)
	{
		// TODO Raccord de méthode auto-généré
	}

	@Override
	public void applyDebuff(BattlePlayer target)
	{
		// TODO Raccord de méthode auto-généré
	}

	@Override
	public Integer getCost()
	{
		return cost;
	}

}
