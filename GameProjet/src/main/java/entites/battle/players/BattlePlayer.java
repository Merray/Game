/*
 * Copyright (c) 2019 DGFiP - Tous droits réservés
 */
package entites.battle.players;

import entites.battle.BattleEntity;
import entites.items.equipment.Equipment;
import entites.items.equipment.PlayerEquipment;
import entites.items.equipment.arm.Arm;
import entites.items.equipment.arm.armlets.ArmletFactory;
import entites.items.equipment.arm.armlets.ArmletTypeEnum;
import entites.items.equipment.body.Body;
import entites.items.equipment.body.lightarmor.LightArmorFactory;
import entites.items.equipment.body.lightarmor.LightArmorTypeEnum;
import entites.items.equipment.head.Head;
import entites.items.equipment.head.hats.HatFactory;
import entites.items.equipment.head.hats.HatTypeEnum;
import entites.items.equipment.weapons.Weapon;
import entites.items.equipment.weapons.WeaponFactory;
import entites.items.equipment.weapons.WeaponTypeEnum;
import utils.LesFormulesUtils;

/**
 * Class Perso.
 */
public class BattlePlayer extends BattleEntity
{

    BaseJob baseJob;

    private String jobName;

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

    public BattlePlayer(String name, Integer level, BaseJob baseJob)
    {
        this.level = level;
        this.name = name;
        this.baseJob = baseJob;
        this.jobName = baseJob.getName();

        this.playerEquipment = new PlayerEquipment(baseJob.getBaseEquipment());

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
        }
        else if (equipment instanceof Head)
        {
            this.getPlayerEquipment().setHead((Head) equipment);
        }
        else if (equipment instanceof Body)
        {
            this.getPlayerEquipment().setBody((Body) equipment);
        }
        else if (equipment instanceof Arm)
        {
            this.getPlayerEquipment().setArm((Arm) equipment);
        }
        // else
        // {
        // this.getPlayerEquipment().setAccessory((Accessory) equipment);
        // }

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
            this.getPlayerEquipment().setWeapon(WeaponFactory.createWeapon(WeaponTypeEnum.NONE));
        }
        else if (equipment instanceof Head)
        {
            this.getPlayerEquipment().setHead(HatFactory.createHat(HatTypeEnum.NONE));
        }
        else if (equipment instanceof Body)
        {
            this.getPlayerEquipment().setBody(LightArmorFactory.createLightArmor(LightArmorTypeEnum.NONE));
        }
        else if (equipment instanceof Arm)
        {
            this.getPlayerEquipment().setArm(ArmletFactory.createArmlet(ArmletTypeEnum.NONE));
        }
        // else
        // {
        // this.getPlayerEquipment().setAccessory(Rings.NONE);
        // }

        // Application des stats de la pièce
        this.getPlayerEquipment().applyStats(this);

        System.out.println(name + " a retiré " + equipment.getName() + "\n");
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
        return "==== " + name + "\nbaseJob= " + baseJob.getName() + "\nLevel= " + level + "\nHP= "
            + currentHP + "/" + maxHP + "\nMP= " + currentMP + "/" + maxMP + "\nStrength= " + strength + "\nMagic= " + magic
            + "\nSpirit= "
            + spirit + "\nSpeed= " + speed + "\nAttack= " + attack + "\nDefense= " + defense + "\nEvasion= " + evasion + "\nMagicDefense= "
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
        result = prime * result + ((baseJob == null) ? 0 : baseJob.hashCode());
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
        if (baseJob != other.baseJob)
            return false;
        if (level == null)
        {
            if (other.level != null)
                return false;
        }
        else if (!level.equals(other.level))
            return false;
        return true;
    }

    /**
     * Accesseur de baseJob
     *
     * @return baseJob
     */
    public BaseJob getBaseJob()
    {
        return baseJob;
    }

    /**
     * Mutateur de baseJob
     *
     * @param baseJob baseJob
     */
    public void setBaseJob(BaseJob baseJob)
    {
        this.baseJob = baseJob;
    }

    /**
     * Accesseur de jobName
     *
     * @return jobName
     */
    public String getJobName()
    {
        return jobName;
    }

    /**
     * Mutateur de jobName
     *
     * @param jobName jobName
     */
    public void setJobName(String jobName)
    {
        this.jobName = jobName;
    }

}
