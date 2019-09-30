/*
 * Copyright (c) 2019 DGFiP - Tous droits réservés
 */
package entites.items.equipment;

import entites.battle.player.BattlePlayer;
import entites.items.equipment.accessory.Accessory;
import entites.items.equipment.arm.Arm;
import entites.items.equipment.body.Body;
import entites.items.equipment.head.Head;
import entites.items.equipment.weapon.Weapon;

/**
 * Class PlayerEquipment.
 */
public class PlayerEquipment
{

	/** weapon. */
	private Weapon weapon;

	/** head. */
	private Head head;

	/** body. */
	private Body body;

	/** arm. */
	private Arm arm;

	/** accessory. */
	private Accessory accessory;

	/**
	 * Instanciation de player equipment.
	 */
	public PlayerEquipment()
	{
		super();

	}

	/**
	 * Instanciation de player equipment.
	 *
	 * @param weapon
	 * @param head
	 * @param body
	 * @param arm
	 * @param accessory
	 */
	public PlayerEquipment(Weapon weapon, Head head, Body body, Arm arm, Accessory accessory)
	{
		super();
		this.weapon = weapon;
		this.head = head;
		this.body = body;
		this.arm = arm;
		this.accessory = accessory;
	}

	/**
	 * methode Apply stats : .
	 *
	 * @param perso
	 */
	public void applyStats(BattlePlayer perso)
	{
		perso.reInitStats(false);

		if (weapon != null)
		{
			weapon.applyStats(perso);
		}
		if (head != null)
		{
			head.applyStats(perso);
		}
		if (body != null)
		{
			body.applyStats(perso);
		}
		if (arm != null)
		{
			arm.applyStats(perso);
		}
		if (accessory != null)
		{
			accessory.applyStats(perso);
		}

	}

	/**
	 * Gets the weapon.
	 *
	 * @return the weapon
	 */
	public Weapon getWeapon()
	{
		return weapon;
	}

	/**
	 * Sets the weapon.
	 *
	 * @param weapon the new weapon
	 */
	public void setWeapon(Weapon weapon)
	{
		this.weapon = weapon;
	}

	/**
	 * Gets the head.
	 *
	 * @return the head
	 */
	public Head getHead()
	{
		return head;
	}

	/**
	 * Sets the head.
	 *
	 * @param head the new head
	 */
	public void setHead(Head head)
	{
		this.head = head;
	}

	/**
	 * Gets the body.
	 *
	 * @return the body
	 */
	public Body getBody()
	{
		return body;
	}

	/**
	 * Sets the body.
	 *
	 * @param body the new body
	 */
	public void setBody(Body body)
	{
		this.body = body;
	}

	/**
	 * Gets the arm.
	 *
	 * @return the arm
	 */
	public Arm getArm()
	{
		return arm;
	}

	/**
	 * Sets the arm.
	 *
	 * @param arm the new arm
	 */
	public void setArm(Arm arm)
	{
		this.arm = arm;
	}

	/**
	 * Gets the accessory.
	 *
	 * @return the accessory
	 */
	public Accessory getAccessory()
	{
		return accessory;
	}

	/**
	 * Sets the accessory.
	 *
	 * @param accessory the new accessory
	 */
	public void setAccessory(Accessory accessory)
	{
		this.accessory = accessory;
	}

	/**
	 * (methode de remplacement) {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "\n\nWeapon= " + weapon.getName() + "\nHead= " + head.getName() + "\nBody= " + body.getName() + "\nArm= "
				+ arm.getName() + "\nAccessory= " + accessory.getName() + "\n";
	}

}
