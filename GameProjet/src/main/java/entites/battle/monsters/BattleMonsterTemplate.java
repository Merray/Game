package entites.battle.monsters;

import entites.battle.BattleEntity;

public class BattleMonsterTemplate extends BattleEntity
{

    private MonsterTypeEnum monsterType;

    private Integer moneyDropped;

    private Integer xpDropped;

    public BattleMonsterTemplate()
    {
        super();
    }

    /**
     * Accesseur de monsterType
     *
     * @return monsterType
     */
    public MonsterTypeEnum getMonsterType()
    {
        return monsterType;
    }

    /**
     * Mutateur de monsterType
     *
     * @param monsterType monsterType
     */
    public void setMonsterType(MonsterTypeEnum monsterType)
    {
        this.monsterType = monsterType;
    }

    /**
     * Accesseur de moneyDropped
     *
     * @return moneyDropped
     */
    public Integer getMoneyDropped()
    {
        return moneyDropped;
    }

    /**
     * Mutateur de moneyDropped
     *
     * @param moneyDropped moneyDropped
     */
    public void setMoneyDropped(Integer moneyDropped)
    {
        this.moneyDropped = moneyDropped;
    }

    /**
     * Accesseur de xpDropped
     *
     * @return xpDropped
     */
    public Integer getXpDropped()
    {
        return xpDropped;
    }

    /**
     * Mutateur de xpDropped
     *
     * @param xpDropped xpDropped
     */
    public void setXpDropped(Integer xpDropped)
    {
        this.xpDropped = xpDropped;
    }

}
