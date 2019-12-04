package entites.battle.monsters.monstertitle;

import org.apache.commons.lang3.StringUtils;

import entites.battle.monsters.BattleMonster;

public class MonsterTitle
{
    private String prefix;

    private String suffix;

    private String weaponSkin;

    private Integer levelModifier;

    private Integer maxHpModifier;

    private Integer strengthModifier;

    private Integer magicModifier;

    private Integer spiritModifier;

    private Integer speedModifier;

    public MonsterTitle()
    {
        super();
    }

    public MonsterTitle(String prefix, String suffix, String weaponSkin, Integer levelModifier, Integer maxHpModifier,
        Integer strengthModifier, Integer magicModifier, Integer spiritModifier, Integer speedModifier)
    {
        super();
        this.prefix = prefix;
        this.suffix = suffix;
        this.weaponSkin = weaponSkin;
        this.levelModifier = levelModifier;
        this.maxHpModifier = maxHpModifier;
        this.strengthModifier = strengthModifier;
        this.magicModifier = magicModifier;
        this.spiritModifier = spiritModifier;
        this.speedModifier = speedModifier;
    }

    /*
     * applique les modificateurs au monstre
     */
    public void applyModifiers(BattleMonster target)
    {
        if (!StringUtils.isEmpty(prefix))
        {
            target.setName(prefix + " " + target.getName());
        }
        if (!StringUtils.isEmpty(suffix))
        {
            target.setName(target.getName() + " " + suffix);
        }
        /*
         * A partir d'ici, les valeurs sont obligatoirement renseignées. Pas de controle d'existence. Mis à part le
         * niveau, le reste est une modification en %
         */
        target.setLevel(target.getLevel() + levelModifier);
        target.setMaxHP(target.getMaxHP() + (target.getMaxHP() * maxHpModifier / 100));
        target.setStrength(target.getStrength() + (target.getStrength() * strengthModifier / 100));
        target.setMagic(target.getMagic() + (target.getMagic() * magicModifier / 100));
        target.setSpirit(target.getSpirit() + (target.getSpirit() * spiritModifier / 100));
        target.setSpeed(target.getSpeed() + (target.getSpeed() * speedModifier / 100));
    }

    /**
     * Accesseur de prefix
     *
     * @return prefix
     */
    public String getPrefix()
    {
        return prefix;
    }

    /**
     * Mutateur de prefix
     *
     * @param prefix prefix
     */
    public void setPrefix(String prefix)
    {
        this.prefix = prefix;
    }

    /**
     * Accesseur de suffix
     *
     * @return suffix
     */
    public String getSuffix()
    {
        return suffix;
    }

    /**
     * Mutateur de suffix
     *
     * @param suffix suffix
     */
    public void setSuffix(String suffix)
    {
        this.suffix = suffix;
    }

    /**
     * Accesseur de weaponSkin
     *
     * @return weaponSkin
     */
    public String getWeaponSkin()
    {
        return weaponSkin;
    }

    /**
     * Mutateur de weaponSkin
     *
     * @param weaponSkin weaponSkin
     */
    public void setWeaponSkin(String weaponSkin)
    {
        this.weaponSkin = weaponSkin;
    }

    /**
     * Accesseur de levelModifier
     *
     * @return levelModifier
     */
    public Integer getLevelModifier()
    {
        return levelModifier;
    }

    /**
     * Mutateur de levelModifier
     *
     * @param levelModifier levelModifier
     */
    public void setLevelModifier(Integer levelModifier)
    {
        this.levelModifier = levelModifier;
    }

    /**
     * Accesseur de maxHpModifier
     *
     * @return maxHpModifier
     */
    public Integer getMaxHpModifier()
    {
        return maxHpModifier;
    }

    /**
     * Mutateur de maxHpModifier
     *
     * @param maxHpModifier maxHpModifier
     */
    public void setMaxHpModifier(Integer maxHpModifier)
    {
        this.maxHpModifier = maxHpModifier;
    }

    /**
     * Accesseur de strengthModifier
     *
     * @return strengthModifier
     */
    public Integer getStrengthModifier()
    {
        return strengthModifier;
    }

    /**
     * Mutateur de strengthModifier
     *
     * @param strengthModifier strengthModifier
     */
    public void setStrengthModifier(Integer strengthModifier)
    {
        this.strengthModifier = strengthModifier;
    }

    /**
     * Accesseur de magicModifier
     *
     * @return magicModifier
     */
    public Integer getMagicModifier()
    {
        return magicModifier;
    }

    /**
     * Mutateur de magicModifier
     *
     * @param magicModifier magicModifier
     */
    public void setMagicModifier(Integer magicModifier)
    {
        this.magicModifier = magicModifier;
    }

    /**
     * Accesseur de spiritModifier
     *
     * @return spiritModifier
     */
    public Integer getSpiritModifier()
    {
        return spiritModifier;
    }

    /**
     * Mutateur de spiritModifier
     *
     * @param spiritModifier spiritModifier
     */
    public void setSpiritModifier(Integer spiritModifier)
    {
        this.spiritModifier = spiritModifier;
    }

    /**
     * Accesseur de speedModifier
     *
     * @return speedModifier
     */
    public Integer getSpeedModifier()
    {
        return speedModifier;
    }

    /**
     * Mutateur de speedModifier
     *
     * @param speedModifier speedModifier
     */
    public void setSpeedModifier(Integer speedModifier)
    {
        this.speedModifier = speedModifier;
    }

    /**
     * (methode de remplacement) {@inheritDoc}
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "===" + getClass().getName() + "=== \nprefix= " + prefix + "\nsuffix= " + suffix + "\nweaponSkin= " + weaponSkin
            + "\nlevelModifier= " + levelModifier + "\nmaxHpModifier= " + maxHpModifier + "\nstrengthModifier= " + strengthModifier
            + "\nmagicModifier= " + magicModifier + "\nspiritModifier= " + spiritModifier + "\nspeedModifier= " + speedModifier + "\n";
    }

}
