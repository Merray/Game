package entites.items.equipment.arm.armlets;

import entites.battle.players.BattlePlayer;
import entites.items.equipment.arm.Arm;

public class Armlet extends Arm
{

    private ArmletTypeEnum armletType;

    private Integer evasion;

    private Integer magicEvasion;

    public Armlet(ArmletTemplate template)
    {
        super();
        this.name = template.getName();
        this.cost = template.getCost();
        this.armletType = template.getArmletType();
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
     * Accesseur de armletType
     *
     * @return armletType
     */
    public ArmletTypeEnum getArmletType()
    {
        return armletType;
    }

    /**
     * Mutateur de armletType
     *
     * @param armletType armletType
     */
    public void setArmletType(ArmletTypeEnum armletType)
    {
        this.armletType = armletType;
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
