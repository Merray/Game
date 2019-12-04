package entites.items.equipment.body.lightarmor;

import java.util.List;

public class LightArmorList
{

    private List<LightArmorTemplate> lightArmors;

    private LightArmorList()
    {
    }

    /**
     * Accesseur de lightArmors
     *
     * @return lightArmors
     */
    public List<LightArmorTemplate> getLightArmors()
    {
        return lightArmors;
    }

    /**
     * Mutateur de lightArmors
     *
     * @param lightArmors lightArmors
     */
    public void setLightArmors(List<LightArmorTemplate> lightArmors)
    {
        this.lightArmors = lightArmors;
    }

}
