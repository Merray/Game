package entites.battle.player;

import java.util.List;

import entites.battle.buff.Buff;
import entites.battle.buff.Debuff;
import entites.items.DroppableItems;
import entites.items.StealableItems;

public enum Monsters
{

	NONE("No monster", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
	GOBLIN_A("Goblin A", 5, 33, 172, 8, 8, 10, 19, 8, 10, 2, 10, 3),
	GOBLIN_B("Goblin B", 5, 33, 172, 8, 8, 10, 18, 8, 10, 2, 10, 3),
	CAVE_SPIDER_A("Cave spider A", 3, 123, 199, 8, 8, 11, 19, 10, 10, 2, 10, 3),
	CAVE_SPIDER_B("Cave spider B", 3, 123, 199, 8, 8, 11, 19, 10, 10, 2, 10, 3);

	private String name;

	private Integer level;

	// A changer avec la bonne classe
	private List<String> abilities;

	private StealableItems stealableItems;

	private DroppableItems droppedItems;

	// A changer avec la bonne classe
	private String elementalAffinities;

	private Integer moneyDropped;

	private Integer xpDropped;

	/** debuffs. */
	private List<Debuff> debuffs;

	/** buffs. */
	private List<Buff> buffs;

	/** max HP. */
	private Integer maxHP;

	/** current HP. */
	private Integer currentHP;

	/** max MP. */
	private Integer maxMP;

	/** current MP. */
	private Integer currentMP;

	/** strength. */
	private Integer strength;

	/** magic. */
	private Integer magic;

	/** spirit. */
	private Integer spirit;

	/** speed. */
	private Integer speed;

	// ============= Secondary stats =================

	/** attack. */
	private Integer attack;

	/** defense. */
	private Integer defense;

	/** evasion. */
	private Integer evasion;

	/** magic defense. */
	private Integer magicDefense;

	/** magic evasion. */
	private Integer magicEvasion;

	private Monsters(String name, Integer level, Integer maxHP, Integer maxMP, Integer strength, Integer magic,
			Integer spirit, Integer speed, Integer attack, Integer defense, Integer evasion, Integer magicDefense,
			Integer magicEvasion)
	{
		this.name = name;
		this.level = level;
		this.maxHP = maxHP;
		this.maxMP = maxMP;
		this.strength = strength;
		this.magic = magic;
		this.spirit = spirit;
		this.speed = speed;
		this.attack = attack;
		this.defense = defense;
		this.evasion = evasion;
		this.magicDefense = magicDefense;
		this.magicEvasion = magicEvasion;
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
	 * Accesseur de level
	 *
	 * @return level
	 */
	public Integer getLevel()
	{
		return level;
	}

	/**
	 * Mutateur de level
	 *
	 * @param level level
	 */
	public void setLevel(Integer level)
	{
		this.level = level;
	}

	/**
	 * Accesseur de abilities
	 *
	 * @return abilities
	 */
	public List<String> getAbilities()
	{
		return abilities;
	}

	/**
	 * Mutateur de abilities
	 *
	 * @param abilities abilities
	 */
	public void setAbilities(List<String> abilities)
	{
		this.abilities = abilities;
	}

	/**
	 * Accesseur de stealableItems
	 *
	 * @return stealableItems
	 */
	public StealableItems getStealableItems()
	{
		return stealableItems;
	}

	/**
	 * Mutateur de stealableItems
	 *
	 * @param stealableItems stealableItems
	 */
	public void setStealableItems(StealableItems stealableItems)
	{
		this.stealableItems = stealableItems;
	}

	/**
	 * Accesseur de droppedItems
	 *
	 * @return droppedItems
	 */
	public DroppableItems getDroppedItems()
	{
		return droppedItems;
	}

	/**
	 * Mutateur de droppedItems
	 *
	 * @param droppedItems droppedItems
	 */
	public void setDroppedItems(DroppableItems droppedItems)
	{
		this.droppedItems = droppedItems;
	}

	/**
	 * Accesseur de elementalAffinities
	 *
	 * @return elementalAffinities
	 */
	public String getElementalAffinities()
	{
		return elementalAffinities;
	}

	/**
	 * Mutateur de elementalAffinities
	 *
	 * @param elementalAffinities elementalAffinities
	 */
	public void setElementalAffinities(String elementalAffinities)
	{
		this.elementalAffinities = elementalAffinities;
	}

	/**
	 * Accesseur de moneyDropped
	 *
	 * @return moneyDropped
	 */
	public Integer getMoneyDropped()
	{
		return moneyDropped;
	}

	/**
	 * Mutateur de moneyDropped
	 *
	 * @param moneyDropped moneyDropped
	 */
	public void setMoneyDropped(Integer moneyDropped)
	{
		this.moneyDropped = moneyDropped;
	}

	/**
	 * Accesseur de xpDropped
	 *
	 * @return xpDropped
	 */
	public Integer getXpDropped()
	{
		return xpDropped;
	}

	/**
	 * Mutateur de xpDropped
	 *
	 * @param xpDropped xpDropped
	 */
	public void setXpDropped(Integer xpDropped)
	{
		this.xpDropped = xpDropped;
	}

	/**
	 * Accesseur de debuffs
	 *
	 * @return debuffs
	 */
	public List<Debuff> getDebuffs()
	{
		return debuffs;
	}

	/**
	 * Mutateur de debuffs
	 *
	 * @param debuffs debuffs
	 */
	public void setDebuffs(List<Debuff> debuffs)
	{
		this.debuffs = debuffs;
	}

	/**
	 * Accesseur de buffs
	 *
	 * @return buffs
	 */
	public List<Buff> getBuffs()
	{
		return buffs;
	}

	/**
	 * Mutateur de buffs
	 *
	 * @param buffs buffs
	 */
	public void setBuffs(List<Buff> buffs)
	{
		this.buffs = buffs;
	}

	/**
	 * Accesseur de maxHP
	 *
	 * @return maxHP
	 */
	public Integer getMaxHP()
	{
		return maxHP;
	}

	/**
	 * Mutateur de maxHP
	 *
	 * @param maxHP maxHP
	 */
	public void setMaxHP(Integer maxHP)
	{
		this.maxHP = maxHP;
	}

	/**
	 * Accesseur de currentHP
	 *
	 * @return currentHP
	 */
	public Integer getCurrentHP()
	{
		return currentHP;
	}

	/**
	 * Mutateur de currentHP
	 *
	 * @param currentHP currentHP
	 */
	public void setCurrentHP(Integer currentHP)
	{
		this.currentHP = currentHP;
	}

	/**
	 * Accesseur de maxMP
	 *
	 * @return maxMP
	 */
	public Integer getMaxMP()
	{
		return maxMP;
	}

	/**
	 * Mutateur de maxMP
	 *
	 * @param maxMP maxMP
	 */
	public void setMaxMP(Integer maxMP)
	{
		this.maxMP = maxMP;
	}

	/**
	 * Accesseur de currentMP
	 *
	 * @return currentMP
	 */
	public Integer getCurrentMP()
	{
		return currentMP;
	}

	/**
	 * Mutateur de currentMP
	 *
	 * @param currentMP currentMP
	 */
	public void setCurrentMP(Integer currentMP)
	{
		this.currentMP = currentMP;
	}

	/**
	 * Accesseur de strength
	 *
	 * @return strength
	 */
	public Integer getStrength()
	{
		return strength;
	}

	/**
	 * Mutateur de strength
	 *
	 * @param strength strength
	 */
	public void setStrength(Integer strength)
	{
		this.strength = strength;
	}

	/**
	 * Accesseur de magic
	 *
	 * @return magic
	 */
	public Integer getMagic()
	{
		return magic;
	}

	/**
	 * Mutateur de magic
	 *
	 * @param magic magic
	 */
	public void setMagic(Integer magic)
	{
		this.magic = magic;
	}

	/**
	 * Accesseur de spirit
	 *
	 * @return spirit
	 */
	public Integer getSpirit()
	{
		return spirit;
	}

	/**
	 * Mutateur de spirit
	 *
	 * @param spirit spirit
	 */
	public void setSpirit(Integer spirit)
	{
		this.spirit = spirit;
	}

	/**
	 * Accesseur de speed
	 *
	 * @return speed
	 */
	public Integer getSpeed()
	{
		return speed;
	}

	/**
	 * Mutateur de speed
	 *
	 * @param speed speed
	 */
	public void setSpeed(Integer speed)
	{
		this.speed = speed;
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
	 * Accesseur de defense
	 *
	 * @return defense
	 */
	public Integer getDefense()
	{
		return defense;
	}

	/**
	 * Mutateur de defense
	 *
	 * @param defense defense
	 */
	public void setDefense(Integer defense)
	{
		this.defense = defense;
	}

	/**
	 * Accesseur de evasion
	 *
	 * @return evasion
	 */
	public Integer getEvasion()
	{
		return evasion;
	}

	/**
	 * Mutateur de evasion
	 *
	 * @param evasion evasion
	 */
	public void setEvasion(Integer evasion)
	{
		this.evasion = evasion;
	}

	/**
	 * Accesseur de magicDefense
	 *
	 * @return magicDefense
	 */
	public Integer getMagicDefense()
	{
		return magicDefense;
	}

	/**
	 * Mutateur de magicDefense
	 *
	 * @param magicDefense magicDefense
	 */
	public void setMagicDefense(Integer magicDefense)
	{
		this.magicDefense = magicDefense;
	}

	/**
	 * Accesseur de magicEvasion
	 *
	 * @return magicEvasion
	 */
	public Integer getMagicEvasion()
	{
		return magicEvasion;
	}

	/**
	 * Mutateur de magicEvasion
	 *
	 * @param magicEvasion magicEvasion
	 */
	public void setMagicEvasion(Integer magicEvasion)
	{
		this.magicEvasion = magicEvasion;
	}

}
