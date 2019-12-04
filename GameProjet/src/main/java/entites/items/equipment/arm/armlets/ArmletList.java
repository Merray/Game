package entites.items.equipment.arm.armlets;

import java.util.List;

public class ArmletList
{

    private List<ArmletTemplate> armlets;

    public ArmletList()
    {
        super();
    }

    /**
     * Accesseur de armlets
     *
     * @return armlets
     */
    public List<ArmletTemplate> getArmlets()
    {
        return armlets;
    }

    /**
     * Mutateur de armlets
     *
     * @param armlets armlets
     */
    public void setArmlets(List<ArmletTemplate> armlets)
    {
        this.armlets = armlets;
    }

}
