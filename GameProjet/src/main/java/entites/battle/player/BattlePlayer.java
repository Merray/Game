/*
 * Copyright (c) 2019 DGFiP - Tous droits réservés
 */
package entites.battle.player;

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
public class BattlePlayer extends BattleEntity
{

	/** job. */
	private Job job;

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
	 * @param refillHPMP
	 */
	public void calculDesStatsPrincipales(boolean refillHPMP)
	{
		LesFormulesUtils.setNewStrength(this);
		LesFormulesUtils.setNewMagic(this);
		LesFormulesUtils.setNewSpirit(this);
		LesFormulesUtils.setNewSpeed(this);
		LesFormulesUtils.setNewMaxHPAndMaxMP(this, refillHPMP);

	}

	/**
	 * methode Re init stats : .
	 *
	 * @param refillHPMP
	 */
	public void reInitStats(boolean refillHPMP)
	{
		calculDesStatsPrincipales(refillHPMP);
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
	 * Accesseur de job
	 *
	 * @return job
	 */
	public Job getJob()
	{
		return job;
	}

	/**
	 * Mutateur de job
	 *
	 * @param job job
	 */
	public void setJob(Job job)
	{
		this.job = job;
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

	public String fullStats()
	{
		return "==== " + job.getName() + "\nLevel= " + level + "\nHP= " + currentHP + "/" + maxHP + "\nMP= " + currentMP
				+ "/" + maxMP + "\nStrength= " + strength + "\nMagic= " + magic + "\nSpirit= " + spirit + "\nSpeed= "
				+ speed + "\nAttack= " + attack + "\nDefense= " + defense + "\nEvasion= " + evasion + "\nMagicDefense= "
				+ magicDefense + "\nMagicEvasion= " + magicEvasion + playerEquipment + "\n";
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
		result = prime * result + ((job == null) ? 0 : job.hashCode());
		result = prime * result + ((level == null) ? 0 : level.hashCode());
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
		BattlePlayer other = (BattlePlayer) obj;
		if (job != other.job)
			return false;
		if (level == null)
		{
			if (other.level != null)
				return false;
		} else if (!level.equals(other.level))
			return false;
		return true;
	}

}
