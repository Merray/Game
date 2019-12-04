package entites.items.equipment.head.helmets;

import java.util.List;

public class HelmetList
{
    private List<HelmetTemplate> helmets;

    public HelmetList()
    {
        super();
    }

    /**
     * Accesseur de helmets
     *
     * @return helmets
     */
    public List<HelmetTemplate> getHelmets()
    {
        return helmets;
    }

    /**
     * Mutateur de helmets
     *
     * @param helmets helmets
     */
    public void setHelmets(List<HelmetTemplate> helmets)
    {
        this.helmets = helmets;
    }

}
