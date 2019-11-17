package entites.battle.player;

import java.util.List;

import entites.items.DroppableItems;
import entites.items.StealableItems;

public class BattleMonster extends BattleEntity
{

	private Monsters monsterType;

	// A changer avec la bonne classe ou remplacer par IA
	private List<String> abilities;

	private StealableItems stealableItems;

	private DroppableItems droppedItems;

	// A changer avec la bonne classe
	private String elementalAffinities;

	private Integer moneyDropped;

	public BattleMonster()
	{
		super();
	}

	public BattleMonster(Monsters monsterType)
	{
		super();
		this.monsterType = monsterType;
		this.name = monsterType.getName();

		mapperStats(monsterType);
	}

	private void mapperStats(Monsters monsterType)
	{

		this.name = monsterType.getName();
		this.level = monsterType.getLevel();
		this.maxHP = monsterType.getMaxHP();
		this.currentHP = this.maxHP;
		this.maxMP = monsterType.getMaxMP();
		this.currentMP = this.maxMP;
		this.strength = monsterType.getStrength();
		this.magic = monsterType.getMagic();
		this.spirit = monsterType.getSpirit();
		this.speed = monsterType.getSpeed();
		this.attack = monsterType.getAttack();
		this.defense = monsterType.getDefense();
		this.evasion = monsterType.getEvasion();
		this.magicDefense = monsterType.getMagicDefense();
		this.magicEvasion = monsterType.getMagicEvasion();
		// Il faudra mapper le reste

	}

	/**
	 * Accesseur de monsterType
	 *
	 * @return monsterType
	 */
	public Monsters getMonsterType()
	{
		return monsterType;
	}

	/**
	 * Mutateur de monsterType
	 *
	 * @param monsterType monsterType
	 */
	public void setMonsterType(Monsters monsterType)
	{
		this.monsterType = monsterType;
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

	public String fullStats()
	{
		return "==== " + monsterType.getName() + "\nLevel= " + level + "\nHP= " + currentHP + "/" + maxHP + "\nMP= "
				+ currentMP + "/" + maxMP + "\nStrength= " + strength + "\nMagic= " + magic + "\nSpirit= " + spirit
				+ "\nSpeed= " + speed + "\nAttack= " + attack + "\nDefense= " + defense + "\nEvasion= " + evasion
				+ "\nMagicDefense= " + magicDefense + "\nMagicEvasion= " + magicEvasion + "\n";
	}

}
