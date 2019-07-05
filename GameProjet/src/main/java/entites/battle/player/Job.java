package entites.battle.player;

public enum Job
{

	DJIDANE("Djidane", 21, 18, 23, 23), STEINER("Steiner", 24, 12, 21, 14);

	private String name;

	private Integer baseStrength;

	private Integer baseMagic;

	private Integer baseSpirit;

	private Integer baseSpeed;

	private Job(String name, Integer baseStrength, Integer baseMagic, Integer baseSpirit, Integer baseSpeed)
	{
		this.name = name;
		this.baseStrength = baseStrength;
		this.baseMagic = baseMagic;
		this.baseSpirit = baseSpirit;
		this.baseSpeed = baseSpeed;
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
	 * Accesseur de baseStrength
	 *
	 * @return baseStrength
	 */
	public Integer getBaseStrength()
	{
		return baseStrength;
	}

	/**
	 * Mutateur de baseStrength
	 *
	 * @param baseStrength baseStrength
	 */
	public void setBaseStrength(Integer baseStrength)
	{
		this.baseStrength = baseStrength;
	}

	/**
	 * Accesseur de baseMagic
	 *
	 * @return baseMagic
	 */
	public Integer getBaseMagic()
	{
		return baseMagic;
	}

	/**
	 * Mutateur de baseMagic
	 *
	 * @param baseMagic baseMagic
	 */
	public void setBaseMagic(Integer baseMagic)
	{
		this.baseMagic = baseMagic;
	}

	/**
	 * Accesseur de baseSpirit
	 *
	 * @return baseSpirit
	 */
	public Integer getBaseSpirit()
	{
		return baseSpirit;
	}

	/**
	 * Mutateur de baseSpirit
	 *
	 * @param baseSpirit baseSpirit
	 */
	public void setBaseSpirit(Integer baseSpirit)
	{
		this.baseSpirit = baseSpirit;
	}

	/**
	 * Accesseur de baseSpeed
	 *
	 * @return baseSpeed
	 */
	public Integer getBaseSpeed()
	{
		return baseSpeed;
	}

	/**
	 * Mutateur de baseSpeed
	 *
	 * @param baseSpeed baseSpeed
	 */
	public void setBaseSpeed(Integer baseSpeed)
	{
		this.baseSpeed = baseSpeed;
	}
}
