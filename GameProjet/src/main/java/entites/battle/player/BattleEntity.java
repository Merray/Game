package entites.battle.player;

import java.util.List;

import entites.battle.buff.Buff;
import entites.battle.buff.Debuff;

public abstract class BattleEntity implements Comparable<BattleEntity>
{

	protected Integer id;

	/** name. */
	protected String name;

	/** level. */
	protected Integer level;

	// ================== Buffs/Debufss ========================

	/** debuffs. */
	protected List<Debuff> debuffs;

	/** buffs. */
	protected List<Buff> buffs;

	// ================= Primary stats ======================

	/** max HP. */
	protected Integer maxHP;

	/** current HP. */
	protected Integer currentHP;

	/** max MP. */
	protected Integer maxMP;

	/** current MP. */
	protected Integer currentMP;

	/** strength. */
	protected Integer strength;

	/** magic. */
	protected Integer magic;

	/** spirit. */
	protected Integer spirit;

	/** speed. */
	protected Integer speed;

	// ============= Secondary stats =================

	/** attack. */
	protected Integer attack;

	/** defense. */
	protected Integer defense;

	/** evasion. */
	protected Integer evasion;

	/** magic defense. */
	protected Integer magicDefense;

	/** magic evasion. */
	protected Integer magicEvasion;

	public BattleEntity()
	{
		super();
	}

	/*
	 * Verifie si le personnage est mort
	 */
	public boolean isDead()
	{

		return this.getCurrentHP() <= 0 ? true : false;
	}

	/**
	 * Accesseur de id
	 *
	 * @return id
	 */
	public Integer getId()
	{
		return id;
	}

	/**
	 * Mutateur de id
	 *
	 * @param id id
	 */
	public void setId(Integer id)
	{
		this.id = id;
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

	/**
	 * (methode de remplacement) {@inheritDoc}
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((level == null) ? 0 : level.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/**
	 * (methode de remplacement) {@inheritDoc}
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BattleEntity other = (BattleEntity) obj;
		if (id == null)
		{
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (level == null)
		{
			if (other.level != null)
				return false;
		} else if (!level.equals(other.level))
			return false;
		if (name == null)
		{
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int compareTo(BattleEntity o)
	{
		if (this.getSpeed() > (o.getSpeed()))
		{
			return -1;
		} else if (this.getSpeed() < (o.getSpeed()))
		{
			return 1;
		} else
		{
			return 0;
		}

	}

	/**
	 * (methode de remplacement) {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return name;
	}

}
