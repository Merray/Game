package entites.battle.monsters.monstertitle;

import java.util.List;

public class MonsterTitleList
{

    List<MonsterTitle> monsterTitles;

    public MonsterTitleList()
    {
        super();
    }

    public MonsterTitleList(List<MonsterTitle> monsterTitles)
    {
        super();
        this.monsterTitles = monsterTitles;
    }

    /**
     * Accesseur de monsterTitles
     *
     * @return monsterTitles
     */
    public List<MonsterTitle> getMonsterTitles()
    {
        return monsterTitles;
    }

    /**
     * Mutateur de monsterTitles
     *
     * @param monsterTitles monsterTitles
     */
    public void setMonsterTitles(List<MonsterTitle> monsterTitles)
    {
        this.monsterTitles = monsterTitles;
    }

}
