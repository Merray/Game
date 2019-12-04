/*
 * Copyright (c) 2019 DGFiP - Tous droits réservés
 */
package entites.items.equipment;

import entites.items.equipment.arm.armlets.ArmletTypeEnum;
import entites.items.equipment.arm.gauntlets.GauntletTypeEnum;
import entites.items.equipment.body.heavyarmor.HeavyArmorTypeEnum;
import entites.items.equipment.body.lightarmor.LightArmorTypeEnum;
import entites.items.equipment.head.hats.HatTypeEnum;
import entites.items.equipment.head.helmets.HelmetTypeEnum;
import entites.items.equipment.weapons.WeaponTypeEnum;

/**
 * Class BasePlayerEquipment
 */
public class BasePlayerEquipment
{
    /** weapon. */
    private WeaponTypeEnum weaponType;

    /** hat type. */
    private HatTypeEnum hatType;

    /** helmet type. */
    private HelmetTypeEnum helmetType;

    /** light armor type. */
    private LightArmorTypeEnum lightArmorType;

    /** heavy armor type. */
    private HeavyArmorTypeEnum heavyArmorType;

    /** armlet type. */
    private ArmletTypeEnum armletType;

    /** gauntlet type. */
    private GauntletTypeEnum gauntletType;

    /*
     * Ajouter accessoire quand on aura reflechi comment l'implementer
     */

    /**
     * Instanciation de base player equipment.
     */
    public BasePlayerEquipment()
    {
        super();
    }

    /**
     * Gets the weapon.
     *
     * @return the weapon
     */
    public WeaponTypeEnum getWeaponType()
    {
        return weaponType;
    }

    /**
     * Sets the weapon.
     *
     * @param weaponType the new weapon
     */
    public void setWeaponType(WeaponTypeEnum weaponType)
    {
        this.weaponType = weaponType;
    }

    /**
     * Accesseur de l attribut hat type.
     *
     * @return hat type
     */
    public HatTypeEnum getHatType()
    {
        return hatType;
    }

    /**
     * Modificateur de l attribut hat type.
     *
     * @param hatType le nouveau hat type
     */
    public void setHatType(HatTypeEnum hatType)
    {
        this.hatType = hatType;
    }

    /**
     * Gets the helmet type.
     *
     * @return the helmet type
     */
    public HelmetTypeEnum getHelmetType()
    {
        return helmetType;
    }

    /**
     * Sets the helmet type.
     *
     * @param helmetType the new helmet type
     */
    public void setHelmetType(HelmetTypeEnum helmetType)
    {
        this.helmetType = helmetType;
    }

    /**
     * Accesseur de l attribut light armor type.
     *
     * @return light armor type
     */
    public LightArmorTypeEnum getLightArmorType()
    {
        return lightArmorType;
    }

    /**
     * Modificateur de l attribut light armor type.
     *
     * @param lightArmorType le nouveau light armor type
     */
    public void setLightArmorType(LightArmorTypeEnum lightArmorType)
    {
        this.lightArmorType = lightArmorType;
    }

    /**
     * Gets the heavy armor type.
     *
     * @return the heavy armor type
     */
    public HeavyArmorTypeEnum getHeavyArmorType()
    {
        return heavyArmorType;
    }

    /**
     * Sets the heavy armor type.
     *
     * @param heavyArmorType the new heavy armor type
     */
    public void setHeavyArmorType(HeavyArmorTypeEnum heavyArmorType)
    {
        this.heavyArmorType = heavyArmorType;
    }

    /**
     * Accesseur de l attribut armlet type.
     *
     * @return armlet type
     */
    public ArmletTypeEnum getArmletType()
    {
        return armletType;
    }

    /**
     * Modificateur de l attribut armlet type.
     *
     * @param armletType le nouveau armlet type
     */
    public void setArmletType(ArmletTypeEnum armletType)
    {
        this.armletType = armletType;
    }

    /**
     * Gets the gauntlet type.
     *
     * @return the gauntlet type
     */
    public GauntletTypeEnum getGauntletType()
    {
        return gauntletType;
    }

    /**
     * Sets the gauntlet type.
     *
     * @param gauntletType the new gauntlet type
     */
    public void setGauntletType(GauntletTypeEnum gauntletType)
    {
        this.gauntletType = gauntletType;
    }

}
