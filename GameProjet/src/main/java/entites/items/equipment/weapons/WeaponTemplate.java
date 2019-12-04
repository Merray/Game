package entites.items.equipment.weapons;

import entites.battle.buff.Debuff;

public class WeaponTemplate
{
	private String name;

	private WeaponTypeEnum weaponType;

	private Integer attack;

	private String element;

	private Debuff status;

	private Integer cost;

	public WeaponTemplate()
	{
		super();
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

	/**
	 * Accesseur de name
	 *
	 * @return name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Mutateur de name
	 *
	 * @param name name
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * Accesseur de cost
	 *
	 * @return cost
	 */
	public Integer getCost()
	{
		return cost;
	}

	/**
	 * Mutateur de cost
	 *
	 * @param cost cost
	 */
	public void setCost(Integer cost)
	{
		this.cost = cost;
	}

}
