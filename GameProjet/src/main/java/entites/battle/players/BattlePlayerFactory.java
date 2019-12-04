package entites.battle.players;

import java.io.File;
import java.io.IOException;
import java.util.EnumMap;

import com.fasterxml.jackson.databind.ObjectMapper;

public class BattlePlayerFactory
{
    private static final EnumMap<BaseJobTypeEnum, BaseJob> BASEJOB_MAP = chargeMap();

    private BattlePlayerFactory()
    {
    }

    private static EnumMap<BaseJobTypeEnum, BaseJob> chargeMap()
    {
        ObjectMapper objectMapper = new ObjectMapper();
        EnumMap<BaseJobTypeEnum, BaseJob> baseJobMap = new EnumMap<>(BaseJobTypeEnum.class);

        try
        {
            BaseJobList baseJobList =
                objectMapper.readValue(new File("src/main/resources/battle/BaseJobList.json"), BaseJobList.class);

            for (BaseJob baseJob : baseJobList.getBaseJobs())
            {

                baseJobMap.put(baseJob.getBaseJobType(), baseJob);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return baseJobMap;
    }

    public static BattlePlayer createBattlePlayer(String name, Integer level, BaseJobTypeEnum baseJobType)
    {
        BaseJob baseJob = BASEJOB_MAP.get(baseJobType);

        return new BattlePlayer(name, level, baseJob);

    }

}
