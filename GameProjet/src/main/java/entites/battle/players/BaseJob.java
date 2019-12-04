package entites.battle.players;

import entites.items.equipment.BasePlayerEquipment;

public class BaseJob
{

    /** name. */
    private String name;

    private BaseJobTypeEnum baseJobType;

    /** base strength. */
    private Integer baseStrength;

    /** base magic. */
    private Integer baseMagic;

    /** base spirit. */
    private Integer baseSpirit;

    /** base speed. */
    private Integer baseSpeed;

    /** base equipment. */
    private BasePlayerEquipment baseEquipment;

    public BaseJob()
    {
        super();
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
     * Accesseur de baseJobType
     *
     * @return baseJobType
     */
    public BaseJobTypeEnum getBaseJobType()
    {
        return baseJobType;
    }

    /**
     * Mutateur de baseJobType
     *
     * @param baseJobType baseJobType
     */
    public void setBaseJobType(BaseJobTypeEnum baseJobType)
    {
        this.baseJobType = baseJobType;
    }

    /**
     * Accesseur de baseStrength
     *
     * @return baseStrength
     */
    public Integer getBaseStrength()
    {
        return baseStrength;
    }

    /**
     * Mutateur de baseStrength
     *
     * @param baseStrength baseStrength
     */
    public void setBaseStrength(Integer baseStrength)
    {
        this.baseStrength = baseStrength;
    }

    /**
     * Accesseur de baseMagic
     *
     * @return baseMagic
     */
    public Integer getBaseMagic()
    {
        return baseMagic;
    }

    /**
     * Mutateur de baseMagic
     *
     * @param baseMagic baseMagic
     */
    public void setBaseMagic(Integer baseMagic)
    {
        this.baseMagic = baseMagic;
    }

    /**
     * Accesseur de baseSpirit
     *
     * @return baseSpirit
     */
    public Integer getBaseSpirit()
    {
        return baseSpirit;
    }

    /**
     * Mutateur de baseSpirit
     *
     * @param baseSpirit baseSpirit
     */
    public void setBaseSpirit(Integer baseSpirit)
    {
        this.baseSpirit = baseSpirit;
    }

    /**
     * Accesseur de baseSpeed
     *
     * @return baseSpeed
     */
    public Integer getBaseSpeed()
    {
        return baseSpeed;
    }

    /**
     * Mutateur de baseSpeed
     *
     * @param baseSpeed baseSpeed
     */
    public void setBaseSpeed(Integer baseSpeed)
    {
        this.baseSpeed = baseSpeed;
    }

    /**
     * Accesseur de baseEquipment
     *
     * @return baseEquipment
     */
    public BasePlayerEquipment getBaseEquipment()
    {
        return baseEquipment;
    }

    /**
     * Mutateur de baseEquipment
     *
     * @param baseEquipment baseEquipment
     */
    public void setBaseEquipment(BasePlayerEquipment baseEquipment)
    {
        this.baseEquipment = baseEquipment;
    }

}
