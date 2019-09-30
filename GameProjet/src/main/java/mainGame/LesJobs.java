package mainGame;

import java.io.IOException;

import entites.battle.player.BattlePlayer;
import entites.battle.player.Job;

public class LesJobs
{

	public static void main(String[] args) throws IOException
	{

		BattlePlayer lePerso = new BattlePlayer(2, Job.DJIDANE);

		BattlePlayer lePerso2 = new BattlePlayer(5, Job.STEINER);

		System.out.println(lePerso);
		System.out.println(lePerso2);

	}

}
