//package entites.battle.controler;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//import java.util.Scanner;
//
//import org.apache.commons.collections4.CollectionUtils;
//
//import entites.battle.buff.Buff;
//import entites.battle.buff.Debuff;
//import entites.battle.buff.ModifierType;
//import entites.battle.player.Perso;
//
//public class BattleControler
//{
//	private Perso player;
//
//	private Perso enemy;
//
//	private boolean dead = false;
//
//	private int round;
//
//	public BattleControler(Perso player, Perso enemy)
//	{
//		super();
//		this.player = player;
//		this.enemy = enemy;
//		this.round = 0;
//		this.dead = false;
//	}
//
//	public void start() throws IOException
//	{
//
//		/*
//		 * Debut
//		 */
//
//		Scanner commandControler = new Scanner(System.in);
//		List<Attaque> playerMoveSet = player.getMoveSet();
//		List<Attaque> enemyMoveSet = enemy.getMoveSet();
//
//		while (!dead)
//			
//		{
//
//			round++;
//
//			/*
//			 * Affichage des stats
//			 */
//			afficherStats();
//
//			/*
//			 * =========================== Tour player ================================
//			 */
//			System.out.println("\n[Tour de " + player.getName() + "]\n");
//
//			/*
//			 * Resolution des buffs/debuffs
//			 */
//			resoudreBuffDebuff(player);
//
//			/*
//			 * Si perso mort suite à un debuff
//			 */
//			if (dead)
//			{
//				break;
//			}
//
//			/*
//			 * Choix du move
//			 */
//			int selectedMove = selectMove(commandControler, playerMoveSet);
//
//			Attaque move = playerMoveSet.get(selectedMove);
//
//			/*
//			 * Resolution des dégats
//			 */
//			resoudreDegats(player, enemy, move);
//
//			/*
//			 * Appliquer debuffs
//			 */
//			appliquerDebuff(enemy, move.getDebuff());
//
//			/*
//			 * Appliquer buffs
//			 */
//			appliquerBuff(player, move.getBuff());
//
//			/*
//			 * Verification de mort
//			 */
//			dead = checkIfDead(enemy);
//
//			/*
//			 * Si perso mort suite à un debuff
//			 */
//			if (dead)
//			{
//				break;
//			}
//
//			/*
//			 * =========================== Tour ennemy ================================
//			 */
//			System.out.println("\n[Tour de " + enemy.getName() + "]\n");
//
//			/*
//			 * Resolution des buffs/debuffs
//			 */
//			resoudreBuffDebuff(enemy);
//
//			/*
//			 * Si perso mort suite à un dégat reçu
//			 */
//			if (dead)
//			{
//				break;
//			}
//
//			/*
//			 * Recupération du move de l'enemy
//			 */
//			Attaque enemyMove = enemyMove(enemyMoveSet);
//
//			/*
//			 * Resolution des dégats
//			 */
//			resoudreDegats(enemy, player, enemyMove);
//
//			/*
//			 * Appliquer debuffs
//			 */
//			appliquerDebuff(player, enemyMove.getDebuff());
//
//			/*
//			 * Appliquer buffs
//			 */
//			appliquerBuff(player, enemyMove.getBuff());
//
//			/*
//			 * Verification de mort
//			 */
//			dead = checkIfDead(player);
//
//		}
//
//		System.out.println("\nFin du combat");
//
//	}
//
//	private Attaque enemyMove(List<Attaque> enemyMoveSet)
//	{
//
//		Random random = new Random();
//
//		return enemyMoveSet.get(random.nextInt(enemyMoveSet.size()));
//
//	}
//
//	private void resoudreBuffDebuff(Perso target) throws IOException
//	{
//
//		List<Debuff> debuffs = target.getDebuffs();
//		List<Buff> buffs = target.getBuffs();
//
//		/*
//		 * Resolution debuffs
//		 */
//		if (!CollectionUtils.isEmpty(debuffs))
//		{
//
//			List<Debuff> debuffARetirer = new ArrayList<Debuff>();
//
//			for (Debuff debuff : debuffs)
//			{
//				int dureeDebuff = debuff.getDuree();
//				int degats = debuff.getDegats();
//
//				/*
//				 * Reduction des pv
//				 */
//				target.setPv(target.getPv() - degats);
//				System.out.println(target.getName() + debuff.getPhraseTrigger() + " et subit " + degats + " dégats");
//
//				/*
//				 * Gestion de la durée restante du debuff
//				 */
//				debuff.setDuree(dureeDebuff - 1);
//
//				if (dureeDebuff < 1)
//				{
//					System.out.println("\n" + target.getName() + debuff.getPhraseFin());
//					debuffARetirer.add(debuff);
//				}
//
//				/*
//				 * Verification si le perso est mort suite aux dégats du debuff
//				 */
//				dead = checkIfDead(target);
//
//			}
//
//			/*
//			 * Suppression des debuffs dont le CD est arrivé à terme
//			 */
//			if (!CollectionUtils.isEmpty(debuffARetirer))
//			{
//				for (Debuff debuff : debuffARetirer)
//				{
//					debuffs.remove(debuff);
//				}
//			}
//		}
//
//		/*
//		 * Resolution buffs
//		 */
//		if (!CollectionUtils.isEmpty(buffs))
//		{
//			for (Buff buff : buffs)
//			{
//				int dureeBuff = buff.getDuree();
//
//				/*
//				 * Gestion de la durée restante du debuff
//				 */
//				buff.setDuree(dureeBuff - 1);
//
//				if (dureeBuff < 1)
//				{
//					System.out.println("\n" + target.getName() + buff.getPhraseFin());
//					waitForEnter();
//					buffs.remove(buff);
//				}
//			}
//		}
//	}
//
//	private boolean checkIfDead(Perso target) throws IOException
//	{
//		boolean dead = false;
//
//		if (target.getPv() < 1)
//		{
//			System.out.println("\n" + target.getName() + " died.. RIP");
//			waitForEnter();
//			dead = true;
//		}
//
//		return dead;
//	}
//
//	private void appliquerBuff(Perso cible, Buff buff)
//	{
//
//	}
//
//	private void appliquerDebuff(Perso cible, Debuff debuff) throws IOException
//	{
//		/*
//		 * Les debuffs ne se stack pas pour le moment
//		 */
//		if (!cible.getDebuffs().contains(debuff) && debuff != Debuff.AUCUN)
//		{
//			cible.getDebuffs().add(debuff);
//			System.out.println("\n" + cible.getName() + debuff.getPhraseDebut());
//		}
//		waitForEnter();
//
//	}
//
//	private void resoudreDegats(Perso attacker, Perso target, Attaque move) throws IOException
//	{
//
//		/*
//		 * Calcul des dégats infligés
//		 */
//		float floatDamage = 0f;
//
//		if (move.getModifierType() == ModifierType.STR)
//		{
//			floatDamage = (attacker.getStr() * move.getModifier()) * (100 / (100 + target.getDef()));
//		} else if (move.getModifierType() == ModifierType.MAG)
//		{
//			floatDamage = (attacker.getMag() * move.getModifier()) * (100 / (100 + target.getCon()));
//		} else if (move.getModifierType() == ModifierType.CON)
//		{
//			floatDamage = (attacker.getCon() * move.getModifier()) * (100 / (100 + target.getCon()));
//		}
//
//		int roundedDamage = Math.round(floatDamage);
//
//		/*
//		 * En cas de dégats négatifs (ça arrive)
//		 */
//		if (roundedDamage < 1)
//		{
//			roundedDamage = 0;
//		}
//
//		/*
//		 * Reduction des pv
//		 */
//		target.setPv(target.getPv() - roundedDamage);
//		System.out.println(attacker.getName() + " utilise " + move.getName() + " et inflige " + roundedDamage
//				+ " dégats à " + target.getName());
//
//	}
//
//	private int selectMove(Scanner commandControler, List<Attaque> playerMoveSet)
//	{
//		int index = 0;
//		System.out.println("\nSelect a move");
//
//		for (Attaque attaque : playerMoveSet)
//		{
//			System.out.println(index + ": " + attaque.getName());
//			index++;
//		}
//
//		int commande = commandControler.nextInt();
//
//		while (commande > playerMoveSet.size() - 1)
//		{
//			System.out.println("\nSelect a real move...");
//			commande = commandControler.nextInt();
//		}
//
//		return commande;
//
//	}
//
//	private void waitForEnter() throws IOException
//	{
//		System.out.println("\n-->");
//		System.in.read();
//
//	}
//
//	private void afficherStats()
//	{
//
//		String proportions = "%-30.30s  %-30.30s%n";
//
//		System.out.println("\n\n============= Tour: " + round + " ===================");
//		System.out.printf(proportions, player.getName(), enemy.getName());
//		System.out.printf(proportions, "Job: " + player.getJob().getName(), "Job: " + enemy.getJob().getName());
//		System.out.printf(proportions, "PvMax: " + player.getMaxPv(), "PvMax: " + enemy.getMaxPv());
//		System.out.printf(proportions, "Pv: " + player.getPv(), "Pv: " + enemy.getPv());
//		System.out.printf(proportions, "Str: " + player.getStr(), "Str: " + enemy.getStr());
//		System.out.printf(proportions, "Mag: " + player.getMag(), "Mag: " + enemy.getMag());
//		System.out.printf(proportions, "Def: " + player.getDef(), "Def: " + enemy.getDef());
//		System.out.printf(proportions, "Con: " + player.getCon(), "Con: " + enemy.getCon());
//		System.out.println("=========================================");
//
//	}
//
//	/**
//	 * Accesseur de player
//	 *
//	 * @return player
//	 */
//	public Perso getPlayer()
//	{
//		return player;
//	}
//
//	/**
//	 * Mutateur de player
//	 *
//	 * @param player player
//	 */
//	public void setPlayer(Perso player)
//	{
//		this.player = player;
//	}
//
//	/**
//	 * Accesseur de round
//	 *
//	 * @return round
//	 */
//	public int getRound()
//	{
//		return round;
//	}
//
//	/**
//	 * Mutateur de round
//	 *
//	 * @param round round
//	 */
//	public void setRound(int round)
//	{
//		this.round = round;
//	}
//
//	/**
//	 * Accesseur de enemy
//	 *
//	 * @return enemy
//	 */
//	public Perso getEnemy()
//	{
//		return enemy;
//	}
//
//	/**
//	 * Mutateur de enemy
//	 *
//	 * @param enemy enemy
//	 */
//	public void setEnemy(Perso enemy)
//	{
//		this.enemy = enemy;
//	}
//
//	/**
//	 * Accesseur de dead
//	 *
//	 * @return dead
//	 */
//	public boolean isDead()
//	{
//		return dead;
//	}
//
//	/**
//	 * Mutateur de dead
//	 *
//	 * @param dead dead
//	 */
//	public void setDead(boolean dead)
//	{
//		this.dead = dead;
//	}
//
//}
