package entites.items.equipment.head.helmets;

import entites.battle.players.BattlePlayer;
import entites.items.equipment.head.Head;

public class Helmet extends Head
{

    private HelmetTypeEnum helmetType;

    private Integer magicDefense;

    public Helmet(HelmetTemplate template)
    {
        super();
        this.name = template.getName();
        this.cost = template.getCost();
        this.helmetType = template.getHelmetType();
        this.magicDefense = template.getMagicDefense();

    }

    @Override
    public void applyStats(BattlePlayer target)
    {
        target.setMagicDefense(target.getMagicDefense() + magicDefense);
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

    /**
     * Accesseur de helmetType
     *
     * @return helmetType
     */
    public HelmetTypeEnum getHelmetType()
    {
        return helmetType;
    }

    /**
     * Mutateur de helmetType
     *
     * @param helmetType helmetType
     */
    public void setHelmetType(HelmetTypeEnum helmetType)
    {
        this.helmetType = helmetType;
    }

}
