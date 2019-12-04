package entites.items.equipment.head.helmets;

public class HelmetTemplate
{

    private String name;

    private HelmetTypeEnum helmetType;

    private Integer magicDefense;

    private Integer cost;

    public HelmetTemplate()
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
     * Accesseur de helmetType
     *
     * @return helmetType
     */
    public HelmetTypeEnum getHelmetType()
    {
        return helmetType;
    }

    /**
     * Mutateur de helmetType
     *
     * @param helmetType helmetType
     */
    public void setHelmetType(HelmetTypeEnum helmetType)
    {
        this.helmetType = helmetType;
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

}
