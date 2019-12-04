package entites.battle.controler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import entites.battle.BattleEntity;
import entites.battle.battlefield.BattleFields;
import entites.battle.monsters.BattleMonster;
import entites.battle.players.BattlePlayer;
import utils.LesFormulesUtils;

public class Battle
{
	private static final Random RAND_NUMBER = new Random();

	private List<BattlePlayer> playerGroup;

	private List<BattleMonster> enemyGroup;

	private List<BattleEntity> attackOrder = new ArrayList<>();

	private BattleEntity activeEntity;

	private List<BattleEntity> activeTargets = new ArrayList<>();

	private Integer turnNumber = 1;

	private Integer playersAlive;

	private Integer monstersAlive;

	BattleFields battleField;

	public Battle(List<BattlePlayer> playerGroup, BattleFields battleField)
	{
		super();

		this.playerGroup = playerGroup;
		this.battleField = battleField;
		this.enemyGroup = battleField.getMonsterFormation();
		playersAlive = playerGroup.size();
		monstersAlive = enemyGroup.size();

		buildAttackOrder(playerGroup, enemyGroup);

		/*
		 * Le BattleEntity le plus rapide est le premier à agir
		 */
		activeEntity = attackOrder.get(0);

	}

	private void buildAttackOrder(List<BattlePlayer> playerGroup, List<BattleMonster> enemyGroup)
	{
		attackOrder.addAll(playerGroup);
		attackOrder.addAll(enemyGroup);

		/*
		 * Tri par Speed decroissant dans la classe BattleEntity
		 */
		Collections.sort(attackOrder);

	}

	/*
	 * Affiche l'ordre d'attaque et l'activeEntity
	 */
	private void displayAttackOrder()
	{
		System.out.println("\nAttack order: " + attackOrder);

		System.out.println("\nGroupe:" + playerGroup);

		System.out.println("\nEnnemis:" + enemyGroup);

		System.out.println("\nTour de: " + activeEntity);

	}

	/*
	 * Place l'activeEntity en fin de liste et sélectionne le nouveau activeEntity
	 */
	private void nextActiveEntity()
	{
		attackOrder.remove(activeEntity);
		attackOrder.add(activeEntity);

		activeEntity = attackOrder.get(0);
	}

	/*
	 * Lance le combat
	 */
	public void start()
	{

		List<BattleEntity> hurtTargets = new ArrayList<>();
		HashMap<BattleEntity, Integer> damageMap = new HashMap<>();

		System.out.println("\nLe groupe engage le combat contre: " + enemyGroup);

		/*
		 * Tant qu'il reste des joueurs ou des monstres en vie
		 */
		while (playersAlive > 0 && monstersAlive > 0)
		{

			/*
			 * Clear des données du tour précédent
			 */
			activeTargets.clear();
			damageMap.clear();

			System.out.println("\nTurn: " + turnNumber);
			displayAttackOrder();

			/*
			 * Choix de la cible, pour le moment tout est aleatoire
			 */
			targetChoice();

			/*
			 * Determine si l'attaque touche ou non
			 */
			hurtTargets = buildHurtTargets(activeTargets);

			/*
			 * Calcule des degats infligés
			 */
			damageMap = damageCalculation(hurtTargets);

			/*
			 * Application des degats sur chaque cible
			 */
			applyDamage(damageMap);

			/*
			 * Fin du tour, changement de personnage actif
			 */
			nextActiveEntity();

			turnNumber += 1;

			System.out.println("\n=========================");

		}

		/*
		 * Message de fin de combat, il faudra ajouter l'xp, les loots, la thune ici
		 */
		endOfBattle();

		/*
		 * Retourner à l'écran map ici
		 */

	}

	private void endOfBattle()
	{
		if (playersAlive <= 0)
		{
			System.out.println("\nLe groupe a été défait. Game Over.\n");
		} else if (monstersAlive <= 0)
		{
			System.out.println("\nLe groupe a vaincu les méchants.");

			System.out.println("\nLoot en cours...\n");
		}

	}

	/*
	 * Verifie si le/les persos meure(nt) après application des dégats et
	 * décrémente les compteurs en conséquence
	 */
	private void checkIfDead(BattleEntity target)
	{
		if (target.isDead())
		{

			if (target instanceof BattlePlayer)
			{
				playersAlive -= 1;
				playerGroup.remove(target);
			} else
			{
				monstersAlive -= 1;
				enemyGroup.remove(target);
			}
			attackOrder.remove(target);
			System.out.println(target + " est KO !");
		}
	}

	/*
	 * Applique les dégats
	 */
	private void applyDamage(HashMap<BattleEntity, Integer> damageMap)
	{
		int index;

		for (BattleEntity target : damageMap.keySet())
		{
			if (target instanceof BattlePlayer)
			{
				index = playerGroup.indexOf(target);

				playerGroup.get(index).setCurrentHP(playerGroup.get(index).getCurrentHP() - damageMap.get(target));

				System.out.println(playerGroup.get(index) + " subit " + damageMap.get(target) + " dégats !");

				checkIfDead(playerGroup.get(index));
			} else
			{
				index = enemyGroup.indexOf(target);

				enemyGroup.get(index).setCurrentHP(enemyGroup.get(index).getCurrentHP() - damageMap.get(target));

				System.out.println(enemyGroup.get(index) + " subit " + damageMap.get(target) + " dégats !");

				checkIfDead(enemyGroup.get(index));

			}
		}
	}

	/*
	 * Calcule les dégats et renvoit une map avec le perso et les dégats associés
	 */
	private HashMap<BattleEntity, Integer> damageCalculation(List<BattleEntity> targets)
	{

		HashMap<BattleEntity, Integer> damageMap = new HashMap<>();
		Integer damageDone;

		for (BattleEntity target : targets)
		{
			/*
			 * Dégats
			 */
			damageDone = LesFormulesUtils.normalAttack(activeEntity, target);

			/*
			 * Crit
			 */
			if (LesFormulesUtils.isCriticalHit(activeEntity))
			{
				damageDone *= 2;

				System.out.println(activeEntity + " réalise un coup critique sur " + target + " !");
			}

			damageMap.put(target, damageDone);
		}

		return damageMap;

	}

	/*
	 * Construit la liste des persos touchés. Gère le hit et le evade
	 */
	private List<BattleEntity> buildHurtTargets(List<BattleEntity> targets)
	{
		List<BattleEntity> hurtTargets = new ArrayList<>();
		hurtTargets.addAll(targets);

		for (BattleEntity target : activeTargets)
		{

			boolean noHit = LesFormulesUtils.isNotHitting();

			if (noHit)
			{
				System.out.println(activeEntity + " rate son attaque");
				hurtTargets.remove(target);

			}
			if (!noHit && LesFormulesUtils.isEvading(target))
			{
				System.out.println(target + " a évité l'attaque de " + activeEntity);
				hurtTargets.remove(target);
			}
		}
		return hurtTargets;

	}

	/*
	 * Choix de la cible
	 */
	private void targetChoice()
	{

		if (activeEntity instanceof BattleMonster)
		{
			// Temporaire en attendant l'IA
			if (RAND_NUMBER.nextInt(3) == 3)
			{
				activeTargets.addAll(playerGroup);
			} else
			{

				activeTargets.add(playerGroup.get(RAND_NUMBER.nextInt(playerGroup.size())));
			}

		} else
		{
			activeTargets.add(enemyGroup.get(RAND_NUMBER.nextInt(enemyGroup.size())));
		}

		if (activeTargets.size() > 1)
		{
			System.out.println("\n" + activeEntity + " cible " + activeTargets);
		} else
		{
			System.out.println("\n" + activeEntity + " cible " + activeTargets.get(0));

		}
	}

	/**
	 * Accesseur de playerGroup
	 *
	 * @return playerGroup
	 */
	public List<BattlePlayer> getPlayerGroup()
	{
		return playerGroup;
	}

	/**
	 * Mutateur de playerGroup
	 *
	 * @param playerGroup playerGroup
	 */
	public void setPlayerGroup(List<BattlePlayer> playerGroup)
	{
		this.playerGroup = playerGroup;
	}

	/**
	 * Accesseur de enemyGroup
	 *
	 * @return enemyGroup
	 */
	public List<BattleMonster> getEnemyGroup()
	{
		return enemyGroup;
	}

	/**
	 * Mutateur de enemyGroup
	 *
	 * @param enemyGroup enemyGroup
	 */
	public void setEnemyGroup(List<BattleMonster> enemyGroup)
	{
		this.enemyGroup = enemyGroup;
	}

	/**
	 * Accesseur de attackOrder
	 *
	 * @return attackOrder
	 */
	public List<BattleEntity> getAttackOrder()
	{
		return attackOrder;
	}

	/**
	 * Mutateur de attackOrder
	 *
	 * @param attackOrder attackOrder
	 */
	public void setAttackOrder(List<BattleEntity> attackOrder)
	{
		this.attackOrder = attackOrder;
	}

	/**
	 * Accesseur de activeEntity
	 *
	 * @return activeEntity
	 */
	public BattleEntity getActiveEntity()
	{
		return activeEntity;
	}

	/**
	 * Mutateur de activeEntity
	 *
	 * @param activeEntity activeEntity
	 */
	public void setActiveEntity(BattleEntity activeEntity)
	{
		this.activeEntity = activeEntity;
	}

	/**
	 * Accesseur de activeTargets
	 *
	 * @return activeTargets
	 */
	public List<BattleEntity> getActiveTargets()
	{
		return activeTargets;
	}

	/**
	 * Mutateur de activeTargets
	 *
	 * @param activeTargets activeTargets
	 */
	public void setActiveTargets(List<BattleEntity> activeTargets)
	{
		this.activeTargets = activeTargets;
	}

	/**
	 * Accesseur de turnNumber
	 *
	 * @return turnNumber
	 */
	public Integer getTurnNumber()
	{
		return turnNumber;
	}

	/**
	 * Mutateur de turnNumber
	 *
	 * @param turnNumber turnNumber
	 */
	public void setTurnNumber(Integer turnNumber)
	{
		this.turnNumber = turnNumber;
	}

	/**
	 * Accesseur de playersAlive
	 *
	 * @return playersAlive
	 */
	public Integer getPlayersAlive()
	{
		return playersAlive;
	}

	/**
	 * Mutateur de playersAlive
	 *
	 * @param playersAlive playersAlive
	 */
	public void setPlayersAlive(Integer playersAlive)
	{
		this.playersAlive = playersAlive;
	}

	/**
	 * Accesseur de monstersAlive
	 *
	 * @return monstersAlive
	 */
	public Integer getMonstersAlive()
	{
		return monstersAlive;
	}

	/**
	 * Mutateur de monstersAlive
	 *
	 * @param monstersAlive monstersAlive
	 */
	public void setMonstersAlive(Integer monstersAlive)
	{
		this.monstersAlive = monstersAlive;
	}

	/**
	 * Accesseur de battleField
	 *
	 * @return battleField
	 */
	public BattleFields getBattleField()
	{
		return battleField;
	}

	/**
	 * Mutateur de battleField
	 *
	 * @param battleField battleField
	 */
	public void setBattleField(BattleFields battleField)
	{
		this.battleField = battleField;
	}

}
