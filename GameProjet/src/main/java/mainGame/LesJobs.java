package mainGame;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entites.battle.battlefield.BattleFields;
import entites.battle.controler.Battle;
import entites.battle.player.BattlePlayer;
import entites.battle.player.Job;

public class LesJobs
{

	public static void main(String[] args) throws IOException
	{

		BattlePlayer lePerso = new BattlePlayer(1, Job.DJIDANE);

		BattlePlayer lePerso2 = new BattlePlayer(1, Job.STEINER);

		List<BattlePlayer> groupe = new ArrayList<BattlePlayer>();

		groupe.add(lePerso);

		Battle leBattle = new Battle(groupe, new BattleFields("Caves01"));

		leBattle.start();

	}

}
