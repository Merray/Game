/*
 * Copyright (c) 2019 DGFiP - Tous droits réservés
 */
package entites.battle.player;

import java.util.ArrayList;
import java.util.List;

import entites.battle.buff.Buff;
import entites.battle.buff.Debuff;
import entites.items.equipment.Equipment;
import entites.items.equipment.PlayerEquipment;
import entites.items.equipment.accessory.Accessory;
import entites.items.equipment.accessory.Rings;
import entites.items.equipment.arm.Arm;
import entites.items.equipment.arm.Armlets;
import entites.items.equipment.body.Body;
import entites.items.equipment.body.LightArmors;
import entites.items.equipment.head.Hats;
import entites.items.equipment.head.Head;
import entites.items.equipment.weapon.Daggers;
import entites.items.equipment.weapon.Weapon;
import utils.LesFormulesUtils;

/**
 * Class Perso.
 */
public class BattlePlayer implements BattleEntity
{

	/** name. */
	private String name;

	/** level. */
	private Integer level;

	/** job. */
	private Job job;

	// ================== Buffs/Debufss ========================

	/** debuffs. */
	private List<Debuff> debuffs;

	/** buffs. */
	private List<Buff> buffs;

	// ================= Primary stats ======================

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

	// ================= Gear ========================

	/** player equipment. */
	private PlayerEquipment playerEquipment;

	/**
	 * Instanciation de perso.
	 */
	public BattlePlayer()
	{
		super();

	}

	/**
	 * Instanciation de perso.
	 *
	 * @param level
	 * @param job
	 */
	public BattlePlayer(Integer level, Job job)
	{
		this.level = level;
		this.job = job;
		this.name = job.getName();

		this.playerEquipment = job.getBaseEquipment();

		reInitStats(true);
		calculDesStatsSecondaires();
	}

	/**
	 * methode Calcul des stats principales :.
	 *
	 * @param setCurrentHP
	 */
	private void calculDesStatsPrincipales(boolean setCurrentHP)
	{
		LesFormulesUtils.setNewStrength(this);
		LesFormulesUtils.setNewMagic(this);
		LesFormulesUtils.setNewSpirit(this);
		LesFormulesUtils.setNewSpeed(this);
		LesFormulesUtils.setNewMaxHPAndMaxMP(this, setCurrentHP);

	}

	/**
	 * methode Re init stats : .
	 *
	 * @param setCurrentHP
	 */
	public void reInitStats(boolean setCurrentHP)
	{
		calculDesStatsPrincipales(setCurrentHP);
		setAttack(0);
		setDefense(0);
		setEvasion(0);
		setMagicDefense(0);
		setMagicEvasion(0);
	}

	/**
	 * methode Calcul des stats secondaires : .
	 */
	private void calculDesStatsSecondaires()
	{
		this.getPlayerEquipment().applyStats(this);
	}

	/**
	 * methode Equip : .
	 *
	 * @param equipment
	 */
	public void equip(Equipment equipment)
	{
		// Equipement de la piece selectionnée
		if (equipment instanceof Weapon)
		{
			this.getPlayerEquipment().setWeapon((Weapon) equipment);
		} else if (equipment instanceof Head)
		{
			this.getPlayerEquipment().setHead((Head) equipment);
		} else if (equipment instanceof Body)
		{
			this.getPlayerEquipment().setBody((Body) equipment);
		} else if (equipment instanceof Arm)
		{
			this.getPlayerEquipment().setArm((Arm) equipment);
		} else
		{
			this.getPlayerEquipment().setAccessory((Accessory) equipment);
		}

		// Application des stats de la pièce
		this.getPlayerEquipment().applyStats(this);

		System.out.println(name + " a équipé " + equipment.getName() + "\n");

	}

	/**
	 * methode Un equip : .
	 *
	 * @param equipment
	 */
	public void unEquip(Equipment equipment)
	{
		// On retire la piece selectionnée
		if (equipment instanceof Weapon)
		{
			this.getPlayerEquipment().setWeapon(Daggers.NONE);
		} else if (equipment instanceof Head)
		{
			this.getPlayerEquipment().setHead(Hats.NONE);
		} else if (equipment instanceof Body)
		{
			this.getPlayerEquipment().setBody(LightArmors.NONE);
		} else if (equipment instanceof Arm)
		{
			this.getPlayerEquipment().setArm(Armlets.NONE);
		} else
		{
			this.getPlayerEquipment().setAccessory(Rings.NONE);
		}

		// Application des stats de la pièce
		this.getPlayerEquipment().applyStats(this);

		System.out.println(name + " a retiré " + equipment.getName() + "\n");
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Gets the job.
	 *
	 * @return the job
	 */
	public Job getJob()
	{
		return job;
	}

	/**
	 * Sets the job.
	 *
	 * @param job the new job
	 */
	public void setJob(Job job)
	{
		this.job = job;
	}

	/**
	 * Gets the debuffs.
	 *
	 * @return the debuffs
	 */
	public List<Debuff> getDebuffs()
	{
		if (debuffs == null)
		{
			debuffs = new ArrayList<Debuff>();
		}
		return debuffs;
	}

	/**
	 * Sets the debuffs.
	 *
	 * @param debuffs the new debuffs
	 */
	public void setDebuffs(List<Debuff> debuffs)
	{
		this.debuffs = debuffs;
	}

	/**
	 * Gets the buffs.
	 *
	 * @return the buffs
	 */
	public List<Buff> getBuffs()
	{
		if (buffs == null)
		{
			buffs = new ArrayList<Buff>();
		}
		return buffs;
	}

	/**
	 * Sets the buffs.
	 *
	 * @param buffs the new buffs
	 */
	public void setBuffs(List<Buff> buffs)
	{
		this.buffs = buffs;
	}

	/**
	 * Gets the level.
	 *
	 * @return the level
	 */
	public Integer getLevel()
	{
		return level;
	}

	/**
	 * Sets the level.
	 *
	 * @param level the new level
	 */
	public void setLevel(Integer level)
	{
		this.level = level;
	}

	/**
	 * Gets the max HP.
	 *
	 * @return the max HP
	 */
	public Integer getMaxHP()
	{
		return maxHP;
	}

	/**
	 * Sets the max HP.
	 *
	 * @param maxHP the new max HP
	 */
	public void setMaxHP(Integer maxHP)
	{
		this.maxHP = maxHP;
	}

	/**
	 * Gets the current HP.
	 *
	 * @return the current HP
	 */
	public Integer getCurrentHP()
	{
		return currentHP;
	}

	/**
	 * Sets the current HP.
	 *
	 * @param currentHP the new current HP
	 */
	public void setCurrentHP(Integer currentHP)
	{
		this.currentHP = currentHP;
	}

	/**
	 * Gets the strength.
	 *
	 * @return the strength
	 */
	public Integer getStrength()
	{
		return strength;
	}

	/**
	 * Sets the strength.
	 *
	 * @param strength the new strength
	 */
	public void setStrength(Integer strength)
	{
		this.strength = strength;
	}

	/**
	 * Gets the magic.
	 *
	 * @return the magic
	 */
	public Integer getMagic()
	{
		return magic;
	}

	/**
	 * Sets the magic.
	 *
	 * @param magic the new magic
	 */
	public void setMagic(Integer magic)
	{
		this.magic = magic;
	}

	/**
	 * Gets the spirit.
	 *
	 * @return the spirit
	 */
	public Integer getSpirit()
	{
		return spirit;
	}

	/**
	 * Sets the spirit.
	 *
	 * @param spirit the new spirit
	 */
	public void setSpirit(Integer spirit)
	{
		this.spirit = spirit;
	}

	/**
	 * Gets the speed.
	 *
	 * @return the speed
	 */
	public Integer getSpeed()
	{
		return speed;
	}

	/**
	 * Sets the speed.
	 *
	 * @param speed the new speed
	 */
	public void setSpeed(Integer speed)
	{
		this.speed = speed;
	}

	/**
	 * Gets the max MP.
	 *
	 * @return the max MP
	 */
	public Integer getMaxMP()
	{
		return maxMP;
	}

	/**
	 * Sets the max MP.
	 *
	 * @param maxMP the new max MP
	 */
	public void setMaxMP(Integer maxMP)
	{
		this.maxMP = maxMP;
	}

	/**
	 * Gets the current MP.
	 *
	 * @return the current MP
	 */
	public Integer getCurrentMP()
	{
		return currentMP;
	}

	/**
	 * Sets the current MP.
	 *
	 * @param currentMP the new current MP
	 */
	public void setCurrentMP(Integer currentMP)
	{
		this.currentMP = currentMP;
	}

	/**
	 * Gets the attack.
	 *
	 * @return the attack
	 */
	public Integer getAttack()
	{
		return attack;
	}

	/**
	 * Sets the attack.
	 *
	 * @param attack the new attack
	 */
	public void setAttack(Integer attack)
	{
		this.attack = attack;
	}

	/**
	 * Gets the defense.
	 *
	 * @return the defense
	 */
	public Integer getDefense()
	{
		return defense;
	}

	/**
	 * Sets the defense.
	 *
	 * @param defense the new defense
	 */
	public void setDefense(Integer defense)
	{
		this.defense = defense;
	}

	/**
	 * Gets the evasion.
	 *
	 * @return the evasion
	 */
	public Integer getEvasion()
	{
		return evasion;
	}

	/**
	 * Sets the evasion.
	 *
	 * @param evasion the new evasion
	 */
	public void setEvasion(Integer evasion)
	{
		this.evasion = evasion;
	}

	/**
	 * Gets the magic defense.
	 *
	 * @return the magic defense
	 */
	public Integer getMagicDefense()
	{
		return magicDefense;
	}

	/**
	 * Sets the magic defense.
	 *
	 * @param magicDefense the new magic defense
	 */
	public void setMagicDefense(Integer magicDefense)
	{
		this.magicDefense = magicDefense;
	}

	/**
	 * Gets the magic evasion.
	 *
	 * @return the magic evasion
	 */
	public Integer getMagicEvasion()
	{
		return magicEvasion;
	}

	/**
	 * Sets the magic evasion.
	 *
	 * @param magicEvasion the new magic evasion
	 */
	public void setMagicEvasion(Integer magicEvasion)
	{
		this.magicEvasion = magicEvasion;
	}

	/**
	 * Accesseur de l attribut player equipment.
	 *
	 * @return player equipment
	 */
	public PlayerEquipment getPlayerEquipment()
	{
		return playerEquipment;
	}

	/**
	 * Modificateur de l attribut player equipment.
	 *
	 * @param playerEquipment le nouveau player equipment
	 */
	public void setPlayerEquipment(PlayerEquipment playerEquipment)
	{
		this.playerEquipment = playerEquipment;
	}

	/**
	 * (methode de remplacement) {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "==== " + job.getName() + "\nLevel= " + level + "\nHP= " + currentHP + "/" + maxHP + "\nMP= " + currentMP
				+ "/" + maxMP + "\nStrength= " + strength + "\nMagic= " + magic + "\nSpirit= " + spirit + "\nSpeed= "
				+ speed + "\nAttack= " + attack + "\nDefense= " + defense + "\nEvasion= " + evasion + "\nMagicDefense= "
				+ magicDefense + "\nMagicEvasion= " + magicEvasion + playerEquipment + "\n";
	}

}
