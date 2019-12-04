package entites.items.equipment.body.heavyarmor;

public class HeavyArmorTemplate
{
    private String name;

    private Integer cost;

    private HeavyArmorTypeEnum heavyArmorType;

    private Integer defense;

    private Integer magicDefense;

    public HeavyArmorTemplate()
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
     * Accesseur de heavyArmorType
     *
     * @return heavyArmorType
     */
    public HeavyArmorTypeEnum getHeavyArmorType()
    {
        return heavyArmorType;
    }

    /**
     * Mutateur de heavyArmorType
     *
     * @param heavyArmorType heavyArmorType
     */
    public void setHeavyArmorType(HeavyArmorTypeEnum heavyArmorType)
    {
        this.heavyArmorType = heavyArmorType;
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
