package entites.battle.player;

import java.util.ArrayList;
import java.util.List;

import entites.battle.buff.Buff;
import entites.battle.buff.Debuff;
import utils.LesFormulesUtils;

public class Perso
{
    private String name;

    private Job job;

    private List<Debuff> debuffs;

    private List<Buff> buffs;

    private Integer level;

    private Integer maxHP;

    private Integer currentHP;

    private Integer maxMP;

    private Integer currentMP;

    private Integer strength;

    private Integer magic;

    private Integer spirit;

    private Integer speed;

    public Perso()
    {
        super();

    }

    public Perso(Integer level, Job job)
    {
        this.level = level;
        this.job = job;
        this.name = job.getName();

        calculDesStatsPrincipales();
        calculDesStatsSecondaires();
    }

    private void calculDesStatsPrincipales()
    {
        LesFormulesUtils.setNewStrength(this);
        LesFormulesUtils.setNewMagic(this);
        LesFormulesUtils.setNewSpirit(this);
        LesFormulesUtils.setNewSpeed(this);
        LesFormulesUtils.setNewMaxHPAndMaxMP(this);

    }

    private void calculDesStatsSecondaires()
    {
        // En chantier
    }

    /**
     * Mutateur de name
     *
     * @param name name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Accesseur de name
     *
     * @return name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Accesseur de job
     *
     * @return job
     */
    public Job getJob()
    {
        return job;
    }

    /**
     * Mutateur de job
     *
     * @param job job
     */
    public void setJob(Job job)
    {
        this.job = job;
    }

    /**
     * Accesseur de debuffs
     *
     * @return debuffs
     */
    public List<Debuff> getDebuffs()
    {
        if (debuffs == null)
        {
            debuffs = new ArrayList<Debuff>();
        }
        return debuffs;
    }

    /**
     * Mutateur de debuffs
     *
     * @param debuffs debuffs
     */
    public void setDebuffs(List<Debuff> debuffs)
    {
        this.debuffs = debuffs;
    }

    /**
     * Accesseur de buffs
     *
     * @return buffs
     */
    public List<Buff> getBuffs()
    {
        if (buffs == null)
        {
            buffs = new ArrayList<Buff>();
        }
        return buffs;
    }

    /**
     * Mutateur de buffs
     *
     * @param buffs buffs
     */
    public void setBuffs(List<Buff> buffs)
    {
        this.buffs = buffs;
    }

    /**
     * Accesseur de level
     *
     * @return level
     */
    public Integer getLevel()
    {
        return level;
    }

    /**
     * Mutateur de level
     *
     * @param level level
     */
    public void setLevel(Integer level)
    {
        this.level = level;
    }

    /**
     * Accesseur de maxHP
     *
     * @return maxHP
     */
    public Integer getMaxHP()
    {
        return maxHP;
    }

    /**
     * Mutateur de maxHP
     *
     * @param maxHP maxHP
     */
    public void setMaxHP(Integer maxHP)
    {
        this.maxHP = maxHP;
    }

    /**
     * Accesseur de currentHP
     *
     * @return currentHP
     */
    public Integer getCurrentHP()
    {
        return currentHP;
    }

    /**
     * Mutateur de currentHP
     *
     * @param currentHP currentHP
     */
    public void setCurrentHP(Integer currentHP)
    {
        this.currentHP = currentHP;
    }

    /**
     * Accesseur de strength
     *
     * @return strength
     */
    public Integer getStrength()
    {
        return strength;
    }

    /**
     * Mutateur de strength
     *
     * @param strength strength
     */
    public void setStrength(Integer strength)
    {
        this.strength = strength;
    }

    /**
     * Accesseur de magic
     *
     * @return magic
     */
    public Integer getMagic()
    {
        return magic;
    }

    /**
     * Mutateur de magic
     *
     * @param magic magic
     */
    public void setMagic(Integer magic)
    {
        this.magic = magic;
    }

    /**
     * Accesseur de spirit
     *
     * @return spirit
     */
    public Integer getSpirit()
    {
        return spirit;
    }

    /**
     * Mutateur de spirit
     *
     * @param spirit spirit
     */
    public void setSpirit(Integer spirit)
    {
        this.spirit = spirit;
    }

    /**
     * Accesseur de speed
     *
     * @return speed
     */
    public Integer getSpeed()
    {
        return speed;
    }

    /**
     * Mutateur de speed
     *
     * @param speed speed
     */
    public void setSpeed(Integer speed)
    {
        this.speed = speed;
    }

    /**
     * Accesseur de maxMP
     *
     * @return maxMP
     */
    public Integer getMaxMP()
    {
        return maxMP;
    }

    /**
     * Mutateur de maxMP
     *
     * @param maxMP maxMP
     */
    public void setMaxMP(Integer maxMP)
    {
        this.maxMP = maxMP;
    }

    /**
     * Accesseur de currentMP
     *
     * @return currentMP
     */
    public Integer getCurrentMP()
    {
        return currentMP;
    }

    /**
     * Mutateur de currentMP
     *
     * @param currentMP currentMP
     */
    public void setCurrentMP(Integer currentMP)
    {
        this.currentMP = currentMP;
    }

    /**
     * (methode de remplacement) {@inheritDoc}
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "===" + job.getName() + "=== \nname= " + name + "\nlevel= " + level + "\nHP= " + currentHP + "/" + maxHP
            + "\nMP= " + currentMP + "/" + maxMP + "\nstrength= " + strength + "\nmagic= " + magic
            + "\nspirit= "
            + spirit + "\nspeed= " + speed;
    }
}
