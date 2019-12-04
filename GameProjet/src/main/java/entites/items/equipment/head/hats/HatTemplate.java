package entites.items.equipment.head.hats;

public class HatTemplate
{

    private String name;

    private Integer cost;

    private HatTypeEnum hatType;

    private Integer defense;

    private Integer evasion;

    private Integer magicDefense;

    public HatTemplate()
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
     * Accesseur de coast
     *
     * @return coast
     */
    public Integer getCost()
    {
        return cost;
    }

    /**
     * Mutateur de coast
     *
     * @param coast coast
     */
    public void setCost(Integer coast)
    {
        this.cost = coast;
    }

    /**
     * Accesseur de hatType
     *
     * @return hatType
     */
    public HatTypeEnum getHatType()
    {
        return hatType;
    }

    /**
     * Mutateur de hatType
     *
     * @param hatType hatType
     */
    public void setHatType(HatTypeEnum hatType)
    {
        this.hatType = hatType;
    }

    /**
     * Accesseur de defense
     *
     * @return defense
     */
    public Integer getDefense()
    {
        return defense;
    }

    /**
     * Mutateur de defense
     *
     * @param defense defense
     */
    public void setDefense(Integer defense)
    {
        this.defense = defense;
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
     * Accesseur de magicDefense
     *
     * @return magicDefense
     */
    public Integer getMagicDefense()
    {
        return magicDefense;
    }

    /**
     * Mutateur de magicDefense
     *
     * @param magicDefense magicDefense
     */
    public void setMagicDefense(Integer magicDefense)
    {
        this.magicDefense = magicDefense;
    }

}
