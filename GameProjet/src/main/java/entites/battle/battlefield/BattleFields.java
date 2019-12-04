package entites.battle.battlefield;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import entites.battle.monsters.BattleMonster;
import entites.battle.monsters.BattleMonsterFactory;
import entites.battle.monsters.MonsterTypeEnum;

public class BattleFields
{
	private String name;

	private List<BattleMonster> monsterFormation = new ArrayList<>();

	private HashMap<String, List<BattleMonster>> possibleFormations = new HashMap<>();

	// private Meteo meteo;

	private Integer statMultiplicator;

	private Integer xpMultiplicator;

	public BattleFields(String name)
	{
		super();
		this.name = name;

		/*
		 * Recupération des formations possibles dans le csv
		 */
		buildPossibleFormations();

		/*
		 * Selection de la formation qui va combattre
		 */
		randMonsterFormation();

	}

	public void randMonsterFormation()
	{
		Random random = new Random();
		String splitCaracter = "-";

		int randomNumber = random.nextInt(100) + 1;

		for (String encounterChance : possibleFormations.keySet())
		{

			String[] limits = encounterChance.split(splitCaracter);

			Integer lowerLimit = Integer.decode(limits[0]);
			Integer upperLimit = Integer.decode(limits[1]);

			if (randomNumber >= lowerLimit && randomNumber <= upperLimit)
			{
				monsterFormation = possibleFormations.get(encounterChance);
				break;
			}

		}
		/*
		 * Attribution d'un titre
		 */
		for (BattleMonster monster : monsterFormation)
		{
			BattleMonsterFactory.applyTitle(monster);
		}

	}

	private void buildPossibleFormations()
	{
		String csvFile = "src/main/resources/MonsterFormations.csv";
		String line = "";
		String splitCaracter = ";";
		String formationSplitCaracter = ",";

		try (BufferedReader reader = new BufferedReader(new FileReader(csvFile)))
		{

			while ((line = reader.readLine()) != null)
			{

				if (line.matches("^" + name + "[-_;,.a-zA-Z0-9]*"))
				{

					String[] levelLine = line.split(splitCaracter);

					String[] formation = levelLine[1].split(formationSplitCaracter);

					List<BattleMonster> monsterList = buildMonsterList(formation);

					String formationChance = levelLine[2];

					possibleFormations.put(formationChance, monsterList);
				}

			}

		} catch (IOException e)
		{
			/*
			 * A logger plus tard
			 */
			e.printStackTrace();
		}
	}

	private List<BattleMonster> buildMonsterList(String[] stringFormation)
	{
		List<BattleMonster> retour = new ArrayList<>();

		for (String stringMonster : stringFormation)
		{
			MonsterTypeEnum enumMonster = MonsterTypeEnum.valueOf(stringMonster);

			BattleMonster battleMonster = BattleMonsterFactory.createBattleMonster(enumMonster);

			retour.add(battleMonster);
		}

		return retour;
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
	 * Mutateur de name
	 *
	 * @param name name
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * Accesseur de monsterFormation
	 *
	 * @return monsterFormation
	 */
	public List<BattleMonster> getMonsterFormation()
	{
		return monsterFormation;
	}

	/**
	 * Mutateur de monsterFormation
	 *
	 * @param monsterFormation monsterFormation
	 */
	public void setMonsterFormation(List<BattleMonster> monsterFormation)
	{
		this.monsterFormation = monsterFormation;
	}

	/**
	 * Accesseur de statMultiplicator
	 *
	 * @return statMultiplicator
	 */
	public Integer getStatMultiplicator()
	{
		return statMultiplicator;
	}

	/**
	 * Mutateur de statMultiplicator
	 *
	 * @param statMultiplicator statMultiplicator
	 */
	public void setStatMultiplicator(Integer statMultiplicator)
	{
		this.statMultiplicator = statMultiplicator;
	}

	/**
	 * Accesseur de xpMultiplicator
	 *
	 * @return xpMultiplicator
	 */
	public Integer getXpMultiplicator()
	{
		return xpMultiplicator;
	}

	/**
	 * Mutateur de xpMultiplicator
	 *
	 * @param xpMultiplicator xpMultiplicator
	 */
	public void setXpMultiplicator(Integer xpMultiplicator)
	{
		this.xpMultiplicator = xpMultiplicator;
	}

	/**
	 * Accesseur de possibleFormations
	 *
	 * @return possibleFormations
	 */
	public Map<String, List<BattleMonster>> getPossibleFormations()
	{
		return possibleFormations;
	}

	/**
	 * Mutateur de possibleFormations
	 *
	 * @param possibleFormations possibleFormations
	 */
	public void setPossibleFormations(Map<String, List<BattleMonster>> possibleFormations)
	{
		this.possibleFormations = (HashMap<String, List<BattleMonster>>) possibleFormations;
	}

}
