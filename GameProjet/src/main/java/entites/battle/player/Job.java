/*
 * Copyright (c) 2019 DGFiP - Tous droits réservés
 */
package entites.battle.player;

import entites.items.equipment.PlayerEquipment;
import entites.items.equipment.accessory.Accessory;
import entites.items.equipment.accessory.Rings;
import entites.items.equipment.arm.Arm;
import entites.items.equipment.arm.Armlets;
import entites.items.equipment.arm.Gauntlets;
import entites.items.equipment.body.Body;
import entites.items.equipment.body.HeavyArmors;
import entites.items.equipment.body.LightArmors;
import entites.items.equipment.head.Hats;
import entites.items.equipment.head.Head;
import entites.items.equipment.head.Helmets;
import entites.items.equipment.weapon.Daggers;
import entites.items.equipment.weapon.Swords;
import entites.items.equipment.weapon.Weapon;

/**
 * Enum Job .
 */
public enum Job
{

	/** djidane. */
	DJIDANE("Djidane", 21, 18, 23, 23, Daggers.DAGGER, Hats.LEATHER_HAT, LightArmors.LEATHER_SHIRT, Armlets.JADE_ARMLET,
			Rings.NONE),

	/** steiner. */
	STEINER("Steiner", 24, 12, 21, 14, Swords.BROADSWORD, Helmets.RUBBER_HELM, HeavyArmors.BRONZE_ARMOR,
			Gauntlets.BRONZE_GAUNTLET, Rings.NONE);

	/** name. */
	private String name;

	/** base strength. */
	private Integer baseStrength;

	/** base magic. */
	private Integer baseMagic;

	/** base spirit. */
	private Integer baseSpirit;

	/** base speed. */
	private Integer baseSpeed;

	/** base equipment. */
	private PlayerEquipment baseEquipment;

	/**
	 * Instanciation de job.
	 *
	 * @param name
	 * @param baseStrength
	 * @param baseMagic
	 * @param baseSpirit
	 * @param baseSpeed
	 * @param weapon
	 * @param head
	 * @param body
	 * @param arm
	 * @param accessory
	 */
	private Job(String name, Integer baseStrength, Integer baseMagic, Integer baseSpirit, Integer baseSpeed,
			Weapon weapon, Head head, Body body, Arm arm, Accessory accessory)
	{
		this.name = name;
		this.baseStrength = baseStrength;
		this.baseMagic = baseMagic;
		this.baseSpirit = baseSpirit;
		this.baseSpeed = baseSpeed;

		baseEquipment = new PlayerEquipment();
		baseEquipment.setWeapon(weapon);
		baseEquipment.setHead(head);
		baseEquipment.setBody(body);
		baseEquipment.setArm(arm);
		baseEquipment.setAccessory(accessory);

	}

	/**
	 * Accesseur de l attribut name.
	 *
	 * @return name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Modificateur de l attribut name.
	 *
	 * @param name le nouveau name
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * Accesseur de l attribut base strength.
	 *
	 * @return base strength
	 */
	public Integer getBaseStrength()
	{
		return baseStrength;
	}

	/**
	 * Modificateur de l attribut base strength.
	 *
	 * @param baseStrength le nouveau base strength
	 */
	public void setBaseStrength(Integer baseStrength)
	{
		this.baseStrength = baseStrength;
	}

	/**
	 * Accesseur de l attribut base magic.
	 *
	 * @return base magic
	 */
	public Integer getBaseMagic()
	{
		return baseMagic;
	}

	/**
	 * Modificateur de l attribut base magic.
	 *
	 * @param baseMagic le nouveau base magic
	 */
	public void setBaseMagic(Integer baseMagic)
	{
		this.baseMagic = baseMagic;
	}

	/**
	 * Accesseur de l attribut base spirit.
	 *
	 * @return base spirit
	 */
	public Integer getBaseSpirit()
	{
		return baseSpirit;
	}

	/**
	 * Modificateur de l attribut base spirit.
	 *
	 * @param baseSpirit le nouveau base spirit
	 */
	public void setBaseSpirit(Integer baseSpirit)
	{
		this.baseSpirit = baseSpirit;
	}

	/**
	 * Accesseur de l attribut base speed.
	 *
	 * @return base speed
	 */
	public Integer getBaseSpeed()
	{
		return baseSpeed;
	}

	/**
	 * Modificateur de l attribut base speed.
	 *
	 * @param baseSpeed le nouveau base speed
	 */
	public void setBaseSpeed(Integer baseSpeed)
	{
		this.baseSpeed = baseSpeed;
	}

	/**
	 * Accesseur de l attribut base equipment.
	 *
	 * @return base equipment
	 */
	public PlayerEquipment getBaseEquipment()
	{
		return baseEquipment;
	}

	/**
	 * Modificateur de l attribut base equipment.
	 *
	 * @param baseEquipment le nouveau base equipment
	 */
	public void setBaseEquipment(PlayerEquipment baseEquipment)
	{
		this.baseEquipment = baseEquipment;
	}
}
