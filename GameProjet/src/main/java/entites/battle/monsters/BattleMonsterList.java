package entites.battle.monsters;

import java.util.List;

public class BattleMonsterList
{
    private List<BattleMonsterTemplate> monsters;

    public BattleMonsterList()
    {
        super();
    }

    /**
     * Accesseur de monsters
     *
     * @return monsters
     */
    public List<BattleMonsterTemplate> getMonsters()
    {
        return monsters;
    }

    /**
     * Mutateur de monsters
     *
     * @param monsters monsters
     */
    public void setMonsters(List<BattleMonsterTemplate> monsters)
    {
        this.monsters = monsters;
    }

}
