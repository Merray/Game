package entites.items.equipment.head.hats;

import java.io.File;
import java.io.IOException;
import java.util.EnumMap;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HatFactory
{
    private static final EnumMap<HatTypeEnum, HatTemplate> HAT_MAP = chargeMap();

    private HatFactory()
    {
    }

    private static EnumMap<HatTypeEnum, HatTemplate> chargeMap()
    {
        ObjectMapper objectMapper = new ObjectMapper();
        EnumMap<HatTypeEnum, HatTemplate> hatMap = new EnumMap<>(HatTypeEnum.class);

        try
        {
            HatList hatList =
                objectMapper.readValue(new File("src/main/resources/items/HatList.json"), HatList.class);

            for (HatTemplate HatTemplate : hatList.getHats())
            {

                hatMap.put(HatTemplate.getHatType(), HatTemplate);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return hatMap;
    }

    public static Hat createHat(HatTypeEnum hatType)
    {
        HatTemplate template = HAT_MAP.get(hatType);

        return new Hat(template);
    }
}
