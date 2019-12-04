package entites.items.equipment.weapons;

import entites.battle.buff.Debuff;
import entites.battle.players.BattlePlayer;
import entites.items.equipment.Equipment;

public class Weapon extends Equipment
{

	private WeaponTypeEnum weaponType;

	private Integer attack;

	private String element;

	private Debuff status;

	public Weapon(WeaponTemplate template)
	{
		super();
		this.name = template.getName();
		this.cost = template.getCost();
		this.weaponType = template.getWeaponType();
		this.attack = template.getAttack();
		this.element = template.getElement();
		this.status = template.getStatus();
	}

	public void applyElement(BattlePlayer target)
	{

	}

	public void applyDebuff(BattlePlayer target)
	{

	}

	@Override
	public void applyStats(BattlePlayer target)
	{
		target.setAttack(target.getAttack() + attack);
	}

	/**
	 * Accesseur de weaponType
	 *
	 * @return weaponType
	 */

	public WeaponTypeEnum getWeaponType()
	{
		return weaponType;
	}

	/**
	 * Mutateur de weaponType
	 *
	 * @param weaponType weaponType
	 */
	public void setWeaponType(WeaponTypeEnum weaponType)
	{
		this.weaponType = weaponType;
	}

	/**
	 * Accesseur de attack
	 *
	 * @return attack
	 */
	public Integer getAttack()
	{
		return attack;
	}

	/**
	 * Mutateur de attack
	 *
	 * @param attack attack
	 */
	public void setAttack(Integer attack)
	{
		this.attack = attack;
	}

	/**
	 * Accesseur de element
	 *
	 * @return element
	 */
	public String getElement()
	{
		return element;
	}

	/**
	 * Mutateur de element
	 *
	 * @param element element
	 */
	public void setElement(String element)
	{
		this.element = element;
	}

	/**
	 * Accesseur de status
	 *
	 * @return status
	 */
	public Debuff getStatus()
	{
		return status;
	}

	/**
	 * Mutateur de status
	 *
	 * @param status status
	 */
	public void setStatus(Debuff status)
	{
		this.status = status;
	}

}
