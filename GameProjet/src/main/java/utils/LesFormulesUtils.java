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

import entites.battle.player.BattlePlayer;
import entites.battle.player.Job;

/**
 * Class LesFormulesUtils .
 */
public class LesFormulesUtils
{

	/** Constant : HP_MP_MAP. */
	private static final Map<Integer, PaireHPMP> HP_MP_MAP = chargeMap();

	/**
	 * Instanciation de les formules utils.
	 */
	private LesFormulesUtils()
	{
		// Constructeur vide
		super();

	}

	/**
	 * methode Creates the map.
	 *
	 * @return map
	 */
	private static Map<Integer, PaireHPMP> createMap()
	{
		Map<Integer, PaireHPMP> retour = new HashMap<Integer, PaireHPMP>();

		retour.put(1, new PaireHPMP(250, 200));
		retour.put(2, new PaireHPMP(314, 206));
		retour.put(3, new PaireHPMP(382, 212));
		retour.put(4, new PaireHPMP(454, 219));
		retour.put(5, new PaireHPMP(530, 226));

		return Collections.unmodifiableMap(retour);

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

		} catch (IOException e)
		{
			e.printStackTrace();
		}

		return Collections.unmodifiableMap(retour);

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
		Job job = perso.getJob();

		Integer newStrength = job.getBaseStrength() + (perso.getLevel() * 3 / 10);

		perso.setStrength(newStrength);
	}

	/**
	 * Modificateur de l attribut new magic.
	 *
	 * @param perso le nouveau new magic
	 */
	public static void setNewMagic(BattlePlayer perso)
	{
		Job job = perso.getJob();

		Integer newMagic = job.getBaseMagic() + (perso.getLevel() * 3 / 10);

		perso.setMagic(newMagic);
	}

	/**
	 * Modificateur de l attribut new spirit.
	 *
	 * @param perso le nouveau new spirit
	 */
	public static void setNewSpirit(BattlePlayer perso)
	{
		Job job = perso.getJob();

		Integer newSpirit = job.getBaseSpirit() + (perso.getLevel() * 3 / 20);

		perso.setSpirit(newSpirit);
	}

	/**
	 * Modificateur de l attribut new speed.
	 *
	 * @param perso le nouveau new speed
	 */
	public static void setNewSpeed(BattlePlayer perso)
	{
		Job job = perso.getJob();

		Integer newSpeed = job.getBaseSpeed() + (perso.getLevel() * 1 / 10);

		perso.setSpeed(newSpeed);
	}

	/**
	 * methode Calcul max HP.
	 *
	 * @param perso
	 * @param setCurrentHP
	 * @return integer
	 */
	public static void setNewMaxHPAndMaxMP(BattlePlayer perso, boolean setCurrentHP)
	{
		PaireHPMP paireHPMP = HP_MP_MAP.get(perso.getLevel());

		// HP
		Integer newMaxHP = perso.getStrength() * paireHPMP.getHp() / 50;
		perso.setMaxHP(newMaxHP);

		if (setCurrentHP)
		{
			perso.setCurrentHP(newMaxHP);
		}

		// MP
		Integer newMaxMP = perso.getMagic() * paireHPMP.getMp() / 100;
		perso.setMaxMP(newMaxMP);

		if (setCurrentHP)
		{
			perso.setCurrentMP(newMaxMP);
		}
	}
}
