package entites.items.equipment.arm.armlets;

public class ArmletTemplate
{
    private String name;

    private Integer cost;

    private ArmletTypeEnum armletType;

    private Integer evasion;

    private Integer magicEvasion;

    public ArmletTemplate()
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
     * Accesseur de cost
     *
     * @return cost
     */
    public Integer getCost()
    {
        return cost;
    }

    /**
     * Mutateur de cost
     *
     * @param cost cost
     */
    public void setCost(Integer cost)
    {
        this.cost = cost;
    }

    /**
     * Accesseur de armletType
     *
     * @return armletType
     */
    public ArmletTypeEnum getArmletType()
    {
        return armletType;
    }

    /**
     * Mutateur de armletType
     *
     * @param armletType armletType
     */
    public void setArmletType(ArmletTypeEnum armletType)
    {
        this.armletType = armletType;
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

}
