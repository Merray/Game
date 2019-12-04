package entites.battle.monsters;

import java.io.File;
import java.io.IOException;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.fasterxml.jackson.databind.ObjectMapper;

import entites.battle.monsters.monstertitle.MonsterTitle;
import entites.battle.monsters.monstertitle.MonsterTitleList;

public class BattleMonsterFactory
{
    private static final EnumMap<MonsterTypeEnum, BattleMonsterTemplate> MONSTER_TEMPLATE_MAP = chargeMonsterMap();

    private static final Map<Integer, MonsterTitle> MONSTER_TITLE_MAP = chargeTitlemap();

    private BattleMonsterFactory()
    {
    }

    private static EnumMap<MonsterTypeEnum, BattleMonsterTemplate> chargeMonsterMap()
    {
        ObjectMapper objectMapper = new ObjectMapper();
        EnumMap<MonsterTypeEnum, BattleMonsterTemplate> monsterMap = new EnumMap<>(MonsterTypeEnum.class);

        try
        {
            BattleMonsterList monsterList =
                objectMapper.readValue(new File("src/main/resources/battle/MonsterList.json"), BattleMonsterList.class);

            for (BattleMonsterTemplate monster : monsterList.getMonsters())
            {

                monsterMap.put(monster.getMonsterType(), monster);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return monsterMap;
    }

    private static Map<Integer, MonsterTitle> chargeTitlemap()
    {
        ObjectMapper objectMapper = new ObjectMapper();
        HashMap<Integer, MonsterTitle> monsterTitleMap = new HashMap<>();

        try
        {
            MonsterTitleList monsterTitleList =
                objectMapper.readValue(new File("src/main/resources/battle/MonsterTitleList.json"), MonsterTitleList.class);

            int randValue = 0;

            for (MonsterTitle monsterTitle : monsterTitleList.getMonsterTitles())
            {
                monsterTitleMap.put(randValue, monsterTitle);
                randValue += 1;
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return monsterTitleMap;
    }

    public static void applyTitle(BattleMonster monster)
    {

        Random randGenerator = new Random();

        Integer randNumber = randGenerator.nextInt(MONSTER_TITLE_MAP.size());

        MonsterTitle title = MONSTER_TITLE_MAP.get(randNumber);

        monster.setMonsterTitle(title);

        title.applyModifiers(monster);
    }

    public static BattleMonster createBattleMonster(MonsterTypeEnum monsterType)
    {

        BattleMonsterTemplate template = MONSTER_TEMPLATE_MAP.get(monsterType);

        return new BattleMonster(template);

    }

    public static BattleMonster createBattleMonsterWithTitle(MonsterTypeEnum monsterType)
    {
        BattleMonsterTemplate template = MONSTER_TEMPLATE_MAP.get(monsterType);

        BattleMonster monster = new BattleMonster(template);

        applyTitle(monster);

        monster.fullLife();

        return monster;
    }
}
