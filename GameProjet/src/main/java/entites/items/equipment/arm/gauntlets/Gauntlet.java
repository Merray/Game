package entites.items.equipment.arm.gauntlets;

import entites.battle.players.BattlePlayer;
import entites.items.equipment.arm.Arm;

public class Gauntlet extends Arm
{
    private GauntletTypeEnum gauntletType;

    private Integer evasion;

    private Integer magicEvasion;

    public Gauntlet(GauntletTemplate template)
    {
        super();
        this.name = template.getName();
        this.cost = template.getCost();
        this.gauntletType = template.getGauntletType();
        this.evasion = template.getEvasion();
        this.magicEvasion = template.getMagicEvasion();
    }

    @Override
    public void applyStats(BattlePlayer target)
    {
        target.setEvasion(target.getEvasion() + evasion);
        target.setMagicEvasion(target.getMagicEvasion() + magicEvasion);
    }

    /**
     * Accesseur de gauntletType
     *
     * @return gauntletType
     */
    public GauntletTypeEnum getGauntletType()
    {
        return gauntletType;
    }

    /**
     * Mutateur de gauntletType
     *
     * @param gauntletType gauntletType
     */
    public void setGauntletType(GauntletTypeEnum gauntletType)
    {
        this.gauntletType = gauntletType;
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
     * Accesseur de magicEvasion
     *
     * @return magicEvasion
     */
    public Integer getMagicEvasion()
    {
        return magicEvasion;
    }

    /**
     * Mutateur de magicEvasion
     *
     * @param magicEvasion magicEvasion
     */
    public void setMagicEvasion(Integer magicEvasion)
    {
        this.magicEvasion = magicEvasion;
    }

}
