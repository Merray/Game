package mainGame;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import entites.battle.Battle;
import entites.battle.battlefield.BattleFields;
import entites.battle.monsters.BattleMonsterFactory;
import entites.battle.monsters.MonsterTypeEnum;
import entites.battle.monsters.monstertitle.MonsterTitleList;
import entites.battle.players.BaseJobTypeEnum;
import entites.battle.players.BattlePlayer;
import entites.battle.players.BattlePlayerFactory;
import entites.items.equipment.arm.armlets.Armlet;
import entites.items.equipment.arm.armlets.ArmletFactory;
import entites.items.equipment.arm.armlets.ArmletTypeEnum;

public class LesJobs
{

	public static void main(String[] args) throws IOException
	{
		battle1();
	}

	public static void testCreateMonsterWIthTitle()
	{
		System.out.println(BattleMonsterFactory.createBattleMonster(MonsterTypeEnum.GOBLIN).fullStats());
		System.out.println(BattleMonsterFactory.createBattleMonsterWithTitle(MonsterTypeEnum.GOBLIN).fullStats());

	}

	public static void testCreateThings()
	{
		Armlet armlet = ArmletFactory.createArmlet(ArmletTypeEnum.JADE_ARMLET);
		System.out.println(armlet);
	}

	public static void testEmptyString()
	{
		String s = null;

		System.out.println(StringUtils.isEmpty(s));
	}

	public static void jacksonTest() throws JsonParseException, JsonMappingException, IOException
	{
		ObjectMapper objectMapper = new ObjectMapper();

		MonsterTitleList monsterTitleList = objectMapper.readValue(new File("src/main/resources/MonsterTitleList.json"),
				MonsterTitleList.class);

		System.out.println(monsterTitleList);

		System.out.println(monsterTitleList.getMonsterTitles());
	}

	public static void battle1()
	{

		List<BattlePlayer> pGroup = new ArrayList<>();

		BattlePlayer lePerso = BattlePlayerFactory.createBattlePlayer("Jim", 1, BaseJobTypeEnum.ROGUE);
		BattlePlayer lePerso2 = BattlePlayerFactory.createBattlePlayer("Yas", 2, BaseJobTypeEnum.ROGUE);

		System.out.println(lePerso.fullStats());
		System.out.println(lePerso2.fullStats());

		pGroup.add(lePerso);
		pGroup.add(lePerso2);

		Battle battle = new Battle(pGroup, new BattleFields("Caves01"));

		System.out.println(battle.getBattleField().getPossibleFormations());

		battle.start();

		System.out.println(lePerso.fullStats());
		System.out.println(lePerso2.fullStats());
	}

}
