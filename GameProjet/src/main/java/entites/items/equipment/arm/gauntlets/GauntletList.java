package entites.items.equipment.arm.gauntlets;

import java.util.List;

public class GauntletList
{

    private List<GauntletTemplate> gauntlets;

    public GauntletList()
    {
        super();
    }

    /**
     * Accesseur de gauntlets
     *
     * @return gauntlets
     */
    public List<GauntletTemplate> getGauntlets()
    {
        return gauntlets;
    }

    /**
     * Mutateur de gauntlets
     *
     * @param gauntlets gauntlets
     */
    public void setGauntlets(List<GauntletTemplate> gauntlets)
    {
        this.gauntlets = gauntlets;
    }

}
