package entites.items.equipment.head.hats;

import entites.battle.players.BattlePlayer;
import entites.items.equipment.head.Head;

public class Hat extends Head
{

    private HatTypeEnum hatType;

    private Integer defense;

    private Integer evasion;

    private Integer magicDefense;

    public Hat(HatTemplate template)
    {
        super();
        this.name = template.getName();
        this.cost = template.getCost();
        this.hatType = template.getHatType();
        this.defense = template.getDefense();
        this.evasion = template.getEvasion();
        this.magicDefense = template.getMagicDefense();
    }

    public Hat(String name, Integer cost, HatTypeEnum hatType, Integer defense, Integer evasion, Integer magicDefense)
    {
        super(name, cost);
        this.hatType = hatType;
        this.defense = defense;
        this.evasion = evasion;
        this.magicDefense = magicDefense;
    }

    @Override
    public void applyStats(BattlePlayer target)
    {
        target.setDefense(target.getDefense() + defense);
        target.setEvasion(target.getEvasion() + evasion);
        target.setMagicDefense(target.getMagicDefense() + magicDefense);
    }

    /**
     * Accesseur de hatType
     *
     * @return hatType
     */
    public HatTypeEnum getHatType()
    {
        return hatType;
    }

    /**
     * Mutateur de hatType
     *
     * @param hatType hatType
     */
    public void setHatType(HatTypeEnum hatType)
    {
        this.hatType = hatType;
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
     * Accesseur de evasion
     *
     * @return evasion
     */
    public Integer getEvasion()
    {
        return evasion;
    }

    /**
     * Mutateur de evasion
     *
     * @param evasion evasion
     */
    public void setEvasion(Integer evasion)
    {
        this.evasion = evasion;
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
