/*
 * Copyright (c) 2019 DGFiP - Tous droits réservés
 */
package utils;

/**
 * Class PaireHPMP .
 */
public class PaireHPMP
{

    /** hp. */
    private Integer hp;

    /** mp. */
    private Integer mp;

    /**
     * Instanciation de paire HPMP.
     *
     * @param hp
     * @param mp
     */
    public PaireHPMP(Integer hp, Integer mp)
    {
        super();
        this.hp = hp;
        this.mp = mp;
    }

    /**
     * Accesseur de l attribut hp.
     *
     * @return hp
     */
    public Integer getHp()
    {
        return hp;
    }

    /**
     * Modificateur de l attribut hp.
     *
     * @param hp le nouveau hp
     */
    public void setHp(Integer hp)
    {
        this.hp = hp;
    }

    /**
     * Accesseur de l attribut mp.
     *
     * @return mp
     */
    public Integer getMp()
    {
        return mp;
    }

    /**
     * Modificateur de l attribut mp.
     *
     * @param mp le nouveau mp
     */
    public void setMp(Integer mp)
    {
        this.mp = mp;
    }

}
