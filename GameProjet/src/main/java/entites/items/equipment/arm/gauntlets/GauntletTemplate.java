package entites.items.equipment.arm.gauntlets;

public class GauntletTemplate
{
    private String name;

    private Integer cost;

    private GauntletTypeEnum gauntletType;

    private Integer evasion;

    private Integer magicEvasion;

    public GauntletTemplate()
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
     * Accesseur de gauntletType
     *
     * @return gauntletType
     */
    public GauntletTypeEnum getGauntletType()
    {
        return gauntletType;
    }

    /**
     * Mutateur de gauntletType
     *
     * @param gauntletType gauntletType
     */
    public void setGauntletType(GauntletTypeEnum gauntletType)
    {
        this.gauntletType = gauntletType;
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
