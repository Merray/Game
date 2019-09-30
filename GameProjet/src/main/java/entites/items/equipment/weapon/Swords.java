package entites.items.equipment.weapon;

import entites.battle.buff.Debuff;
import entites.battle.player.BattlePlayer;

public enum Swords implements Weapon
{
	NONE("None", 0, null, null, null), BROADSWORD("Broadsword", 12, null, null, 330);

	private String name;

	private Integer attack;

	private String element;

	private Debuff status;

	private Integer cost;

	private Swords(String name, Integer attack, String element, Debuff status, Integer cost)
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
