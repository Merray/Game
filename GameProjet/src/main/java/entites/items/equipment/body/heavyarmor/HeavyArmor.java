package entites.items.equipment.body.heavyarmor;

import entites.battle.players.BattlePlayer;
import entites.items.equipment.body.Body;

public class HeavyArmor extends Body
{

    private HeavyArmorTypeEnum heavyArmorType;

    private Integer defense;

    private Integer magicDefense;

    public HeavyArmor(HeavyArmorTemplate template)
    {
        super();
        this.name = template.getName();
        this.cost = template.getCost();
        this.heavyArmorType = template.getHeavyArmorType();
        this.defense = template.getDefense();
        this.magicDefense = template.getMagicDefense();

    }

    public HeavyArmor(String name, Integer cost, HeavyArmorTypeEnum heavyArmorType, Integer defense, Integer magicDefense)
    {
        super(name, cost);
        this.heavyArmorType = heavyArmorType;
        this.defense = defense;
        this.magicDefense = magicDefense;
    }

    @Override
    public void applyStats(BattlePlayer target)
    {
        target.setDefense(target.getDefense() + defense);
        target.setMagicDefense(target.getMagicDefense() + magicDefense);
    }

    /**
     * Accesseur de heavyArmorType
     *
     * @return heavyArmorType
     */
    public HeavyArmorTypeEnum getHeavyArmorType()
    {
        return heavyArmorType;
    }

    /**
     * Mutateur de heavyArmorType
     *
     * @param heavyArmorType heavyArmorType
     */
    public void setHeavyArmorType(HeavyArmorTypeEnum heavyArmorType)
    {
        this.heavyArmorType = heavyArmorType;
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
