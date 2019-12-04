package entites.battle.monsters;

import java.util.List;

import entites.battle.BattleEntity;
import entites.battle.monsters.monstertitle.MonsterTitle;
import entites.items.DroppableItems;
import entites.items.StealableItems;

public class BattleMonster extends BattleEntity
{
    private MonsterTypeEnum monsterType;

    private MonsterTitle monsterTitle;

    // A changer avec la bonne classe ou remplacer par IA
    private List<String> abilities;

    private StealableItems stealableItems;

    private DroppableItems droppedItems;

    // A changer avec la bonne classe
    private String elementalAffinities;

    private Integer moneyDropped;

    private Integer xpDropped;

    public BattleMonster(BattleMonsterTemplate template)
    {
        mapWithTemplate(template);
    }

    private void mapWithTemplate(BattleMonsterTemplate template)
    {
        this.name = template.getName();
        this.monsterType = template.getMonsterType();
        this.level = template.getLevel();
        this.moneyDropped = template.getMoneyDropped();
        this.xpDropped = template.getXpDropped();
        this.maxHP = template.getMaxHP();
        this.currentHP = template.getCurrentHP();
        this.maxMP = template.getMaxMP();
        this.currentMP = template.getCurrentMP();
        this.strength = template.getStrength();
        this.magic = template.getMagic();
        this.spirit = template.getSpirit();
        this.speed = template.getSpeed();
        this.attack = template.getAttack();
        this.defense = template.getDefense();
        this.evasion = template.getEvasion();
        this.magicDefense = template.getMagicDefense();
        this.magicEvasion = template.getMagicEvasion();
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
     * Accesseur de monsterTitle
     *
     * @return monsterTitle
     */
    public MonsterTitle getMonsterTitle()
    {
        return monsterTitle;
    }

    /**
     * Mutateur de monsterTitle
     *
     * @param monsterTitle monsterTitle
     */
    public void setMonsterTitle(MonsterTitle monsterTitle)
    {
        this.monsterTitle = monsterTitle;
    }

    /**
     * Accesseur de abilities
     *
     * @return abilities
     */
    public List<String> getAbilities()
    {
        return abilities;
    }

    /**
     * Mutateur de abilities
     *
     * @param abilities abilities
     */
    public void setAbilities(List<String> abilities)
    {
        this.abilities = abilities;
    }

    /**
     * Accesseur de stealableItems
     *
     * @return stealableItems
     */
    public StealableItems getStealableItems()
    {
        return stealableItems;
    }

    /**
     * Mutateur de stealableItems
     *
     * @param stealableItems stealableItems
     */
    public void setStealableItems(StealableItems stealableItems)
    {
        this.stealableItems = stealableItems;
    }

    /**
     * Accesseur de droppedItems
     *
     * @return droppedItems
     */
    public DroppableItems getDroppedItems()
    {
        return droppedItems;
    }

    /**
     * Mutateur de droppedItems
     *
     * @param droppedItems droppedItems
     */
    public void setDroppedItems(DroppableItems droppedItems)
    {
        this.droppedItems = droppedItems;
    }

    /**
     * Accesseur de elementalAffinities
     *
     * @return elementalAffinities
     */
    public String getElementalAffinities()
    {
        return elementalAffinities;
    }

    /**
     * Mutateur de elementalAffinities
     *
     * @param elementalAffinities elementalAffinities
     */
    public void setElementalAffinities(String elementalAffinities)
    {
        this.elementalAffinities = elementalAffinities;
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

    public String fullStats()
    {
        return "==== " + name + "\nLevel= " + level + "\nHP= "
            + currentHP + "/" + maxHP + "\nMP= " + currentMP + "/" + maxMP + "\nStrength= " + strength + "\nMagic= " + magic
            + "\nSpirit= "
            + spirit + "\nSpeed= " + speed + "\nAttack= " + attack + "\nDefense= " + defense + "\nEvasion= " + evasion + "\nMagicDefense= "
            + magicDefense + "\nMagicEvasion= " + magicEvasion + "\n";
    }

}
