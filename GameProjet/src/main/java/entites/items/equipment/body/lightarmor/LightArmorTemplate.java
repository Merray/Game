package entites.items.equipment.body.lightarmor;

public class LightArmorTemplate
{
    private String name;

    private Integer cost;

    private LightArmorTypeEnum lightArmorType;

    private Integer defense;

    private Integer magicDefense;

    public LightArmorTemplate()
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
     * Accesseur de lightArmorType
     *
     * @return lightArmorType
     */
    public LightArmorTypeEnum getLightArmorType()
    {
        return lightArmorType;
    }

    /**
     * Mutateur de lightArmorType
     *
     * @param lightArmorType lightArmorType
     */
    public void setLightArmorType(LightArmorTypeEnum lightArmorType)
    {
        this.lightArmorType = lightArmorType;
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
