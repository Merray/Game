package entites.items.equipment.body.heavyarmor;

import java.util.List;

public class HeavyArmorList
{
    private List<HeavyArmorTemplate> heavyArmors;

    public HeavyArmorList()
    {
        super();

    }

    /**
     * Accesseur de heavyArmors
     *
     * @return heavyArmors
     */
    public List<HeavyArmorTemplate> getHeavyArmors()
    {
        return heavyArmors;
    }

    /**
     * Mutateur de heavyArmors
     *
     * @param heavyArmors heavyArmors
     */
    public void setHeavyArmors(List<HeavyArmorTemplate> heavyArmors)
    {
        this.heavyArmors = heavyArmors;
    }

}
