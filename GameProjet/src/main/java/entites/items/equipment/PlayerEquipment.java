/*
 * Copyright (c) 2019 DGFiP - Tous droits réservés
 */
package entites.items.equipment;

import entites.battle.players.BattlePlayer;
import entites.items.equipment.arm.Arm;
import entites.items.equipment.arm.armlets.ArmletFactory;
import entites.items.equipment.arm.armlets.ArmletTypeEnum;
import entites.items.equipment.arm.gauntlets.GauntletFactory;
import entites.items.equipment.body.Body;
import entites.items.equipment.body.heavyarmor.HeavyArmorFactory;
import entites.items.equipment.body.lightarmor.LightArmorFactory;
import entites.items.equipment.body.lightarmor.LightArmorTypeEnum;
import entites.items.equipment.head.Head;
import entites.items.equipment.head.hats.HatFactory;
import entites.items.equipment.head.hats.HatTypeEnum;
import entites.items.equipment.head.helmets.HelmetFactory;
import entites.items.equipment.weapons.Weapon;
import entites.items.equipment.weapons.WeaponFactory;
import entites.items.equipment.weapons.WeaponTypeEnum;

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

    /*
     * Ajouter accessoire quand on aura reflechi à comment l'implémenter
     */

    /**
     * Instanciation de player equipment.
     */
    public PlayerEquipment()
    {
        super();

    }

    public PlayerEquipment(BasePlayerEquipment basePlayerEquipment)
    {
        if (basePlayerEquipment.getWeaponType() != WeaponTypeEnum.NONE)
        {
            this.weapon = WeaponFactory.createWeapon(basePlayerEquipment.getWeaponType());
        }
        if (basePlayerEquipment.getHatType() != HatTypeEnum.NONE)
        {
            this.head = HatFactory.createHat(basePlayerEquipment.getHatType());
        }
        else
        {
            this.head = HelmetFactory.createHelmet(basePlayerEquipment.getHelmetType());
        }
        if (basePlayerEquipment.getLightArmorType() != LightArmorTypeEnum.NONE)
        {
            this.body = LightArmorFactory.createLightArmor(basePlayerEquipment.getLightArmorType());
        }
        else
        {
            this.body = HeavyArmorFactory.createHeavyArmor(basePlayerEquipment.getHeavyArmorType());
        }
        if (basePlayerEquipment.getArmletType() != ArmletTypeEnum.NONE)
        {
            this.arm = ArmletFactory.createArmlet(basePlayerEquipment.getArmletType());
        }
        else
        {
            this.arm = GauntletFactory.createGauntlet(basePlayerEquipment.getGauntletType());
        }

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
    public PlayerEquipment(Weapon weapon, Head head, Body body, Arm arm)
    {
        super();
        this.weapon = weapon;
        this.head = head;
        this.body = body;
        this.arm = arm;
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
     * (methode de remplacement) {@inheritDoc}
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "\n\nWeapon= " + weapon.getName() + "\nHead= " + head.getName() + "\nBody= " + body.getName() + "\nArm= " + arm.getName()
            + "\n";
    }

}
