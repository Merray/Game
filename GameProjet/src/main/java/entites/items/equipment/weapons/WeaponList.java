package entites.items.equipment.weapons;

import java.util.List;

public class WeaponList
{
    List<WeaponTemplate> weapons;

    public WeaponList()
    {
        super();
    }

    public WeaponList(List<WeaponTemplate> weapons)
    {
        super();
        this.weapons = weapons;
    }

    /**
     * Accesseur de weapons
     *
     * @return weapons
     */
    public List<WeaponTemplate> getWeapons()
    {
        return weapons;
    }

    /**
     * Mutateur de weapons
     *
     * @param weapons weapons
     */
    public void setWeapons(List<WeaponTemplate> weapons)
    {
        this.weapons = weapons;
    }

}
