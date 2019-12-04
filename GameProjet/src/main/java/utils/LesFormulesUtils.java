/*
 * Copyright (c) 2019 DGFiP - Tous droits réservés
 */
package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import entites.battle.BattleEntity;
import entites.battle.monsters.BattleMonsterTemplate;
import entites.battle.players.BaseJob;
import entites.battle.players.BattlePlayer;

/**
 * Class LesFormulesUtils .
 */
public class LesFormulesUtils
{

    /** Constant : HP_MP_MAP. */
    private static final Map<Integer, PaireHPMP> HP_MP_MAP = chargeMap();

    private static final Random RAND_NUMBER = new Random();

    /**
     * Instanciation de les formules utils.
     */
    private LesFormulesUtils()
    {
        // Constructeur vide
        super();

    }

    /**
     * methode Charge map : .
     *
     * @return map
     */
    private static Map<Integer, PaireHPMP> chargeMap()
    {
        Map<Integer, PaireHPMP> retour = new HashMap<Integer, PaireHPMP>();
        String csvFile = "src/main/resources/StatGrowth.csv";
        String line = "";
        String splitCaracter = ";";

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile)))
        {

            while ((line = reader.readLine()) != null)
            {
                String[] levelLine = line.split(splitCaracter);

                PaireHPMP paireHPMP = new PaireHPMP(Integer.decode(levelLine[1]), Integer.decode(levelLine[2]));

                retour.put(Integer.decode(levelLine[0]), paireHPMP);

            }

        }
        catch (IOException e)
        {
            /*
             * A logger plus tard
             */
            e.printStackTrace();
        }

        return Collections.unmodifiableMap(retour);

    }

    /**
     * Partie Attaque physique
     */

    public static Integer normalAttack(BattleEntity attacker, BattleEntity target)
    {
        Integer base = 0;
        Integer bonus = 0;

        // Base la même pour tous
        base = attacker.getAttack() - target.getDefense();

        /*
         * Si plus de défense que d'attaque
         */
        if (base < 0)
        {
            base = 0;
        }

        if (base != 0)
        {
            /*
             * Monstre qui attaque
             */
            if (attacker instanceof BattleMonsterTemplate)
            {
                bonus = attacker.getStrength()
                    + valeurAleatoire((attacker.getLevel() + attacker.getStrength()) / 4 + 2);
            }
            /*
             * Si le joueur attaque
             */
            else
            {
                bonus = attacker.getStrength()
                    + valeurAleatoire((attacker.getLevel() + attacker.getStrength()) / 8 + 2);
            }
        }

        return base * bonus;
    }

    public static boolean isCriticalHit(BattleEntity attacker)
    {

        Integer critChance;
        boolean isCrit = false;

        /*
         * Evaluation des chances de crit
         */

        critChance = attacker.getSpirit() / 4;

        /*
         * Test de crit
         */
        if ((RAND_NUMBER.nextInt(100) + 1) <= critChance)
        {
            isCrit = true;
        }

        return isCrit;

    }

    /*
     * Retourne true si l'attaque ne touche pas: 1% de chance de rater
     */
    public static boolean isNotHitting()
    {

        return (RAND_NUMBER.nextInt(100) + 1) == 100;
    }

    /*
     * Retourne true si la cible esquive : basé sur l'évasion
     */
    public static boolean isEvading(BattleEntity target)
    {
        return (RAND_NUMBER.nextInt(100) + 1) <= target.getEvasion();
    }

    /*
     * Retourne true si la cible contre attaque : basé sur l'esprit
     */
    public static boolean isCounterAttacking(BattleEntity target)
    {
        /*
         * les monstres ne contrent pas pour le moment
         */
        if (target instanceof BattleMonsterTemplate)
        {
            return false;
        }
        else
        {
            return (RAND_NUMBER.nextInt(100) + 1) <= ((BattlePlayer) target).getSpirit();
        }
    }

    /*
     * Partie caractéristiques de base
     */

    /**
     * Modificateur de l attribut new strength.
     *
     * @param perso le nouveau new strength
     */
    public static void setNewStrength(BattlePlayer perso)
    {
        BaseJob baseJob = perso.getBaseJob();

        Integer newStrength = baseJob.getBaseStrength() + (perso.getLevel() * 3 / 10);

        perso.setStrength(newStrength);
    }

    /**
     * Modificateur de l attribut new magic.
     *
     * @param perso le nouveau new magic
     */
    public static void setNewMagic(BattlePlayer perso)
    {
        BaseJob baseJob = perso.getBaseJob();

        Integer newMagic = baseJob.getBaseMagic() + (perso.getLevel() * 3 / 10);

        perso.setMagic(newMagic);
    }

    /**
     * Modificateur de l attribut new spirit.
     *
     * @param perso le nouveau new spirit
     */
    public static void setNewSpirit(BattlePlayer perso)
    {
        BaseJob baseJob = perso.getBaseJob();

        Integer newSpirit = baseJob.getBaseSpirit() + (perso.getLevel() * 3 / 20);

        perso.setSpirit(newSpirit);
    }

    /**
     * Modificateur de l attribut new speed.
     *
     * @param perso le nouveau new speed
     */
    public static void setNewSpeed(BattlePlayer perso)
    {
        BaseJob baseJob = perso.getBaseJob();

        Integer newSpeed = baseJob.getBaseSpeed() + (perso.getLevel() * 1 / 10);

        perso.setSpeed(newSpeed);
    }

    /**
     * methode Calcul max HP et MP.
     *
     * @param perso
     * @param refillHPMP
     */
    public static void setNewMaxHPAndMaxMP(BattlePlayer perso, boolean refillHPMP)
    {
        PaireHPMP paireHPMP = HP_MP_MAP.get(perso.getLevel());

        // HP
        Integer newMaxHP = perso.getStrength() * paireHPMP.getHp() / 50;
        perso.setMaxHP(newMaxHP);

        // MP
        Integer newMaxMP = perso.getMagic() * paireHPMP.getMp() / 100;
        perso.setMaxMP(newMaxMP);

        // Refill les HP et MP
        if (refillHPMP)
        {
            perso.setCurrentHP(newMaxHP);
            perso.setCurrentMP(newMaxMP);
        }
    }

    /*
     * Fait gagner un/des niveau(x) au joueur
     */
    public static void levelUp(BattlePlayer target, Integer nbLevels)
    {
        target.setLevel(target.getLevel() + nbLevels);

        /*
         * Recalcul des stats en fonction du nouveau niveau
         */
        target.calculDesStatsPrincipales(true);
    }

    /*
     * Retourne une valeur aléatoire entre 0 et la valeur inclue
     */
    private static Integer valeurAleatoire(Integer valeur)
    {

        Random rand = new Random();

        return rand.nextInt(valeur + 1);

    }
}
