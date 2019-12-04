package entites.items.equipment.head.hats;

import java.util.List;

public class HatList
{

    private List<HatTemplate> hats;

    public HatList()
    {
        super();
    }

    public HatList(List<HatTemplate> hats)
    {
        super();
        this.hats = hats;
    }

    /**
     * Accesseur de hats
     *
     * @return hats
     */
    public List<HatTemplate> getHats()
    {
        return hats;
    }

    /**
     * Mutateur de hats
     *
     * @param hats hats
     */
    public void setHats(List<HatTemplate> hats)
    {
        this.hats = hats;
    }

}
