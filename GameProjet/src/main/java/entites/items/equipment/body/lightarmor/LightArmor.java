package entites.items.equipment.body.lightarmor;

import entites.battle.players.BattlePlayer;
import entites.items.equipment.body.Body;

public class LightArmor extends Body
{

    private LightArmorTypeEnum lightArmorType;

    private Integer defense;

    private Integer magicDefense;

    public LightArmor(LightArmorTemplate template)
    {
        super();
        this.name = template.getName();
        this.cost = template.getCost();
        this.lightArmorType = template.getLightArmorType();
        this.defense = template.getDefense();
        this.magicDefense = template.getMagicDefense();

    }

    @Override
    public void applyStats(BattlePlayer target)
    {
        target.setDefense(target.getDefense() + defense);
        target.setMagicDefense(target.getMagicDefense() + magicDefense);
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
