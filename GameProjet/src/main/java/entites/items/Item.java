package entites.items;

public abstract class Item
{

    protected String name;

    protected Integer cost;

    public Item()
    {
        super();
    }

    public Item(String name, Integer cost)
    {
        super();
        this.name = name;
        this.cost = cost;
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

}
