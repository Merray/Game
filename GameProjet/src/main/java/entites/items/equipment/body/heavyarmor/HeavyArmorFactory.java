package entites.items.equipment.body.heavyarmor;

import java.io.File;
import java.io.IOException;
import java.util.EnumMap;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HeavyArmorFactory
{
    private static final EnumMap<HeavyArmorTypeEnum, HeavyArmorTemplate> HEAVY_ARMOR_MAP = chargeMap();

    private HeavyArmorFactory()
    {
    }

    private static EnumMap<HeavyArmorTypeEnum, HeavyArmorTemplate> chargeMap()
    {
        ObjectMapper objectMapper = new ObjectMapper();
        EnumMap<HeavyArmorTypeEnum, HeavyArmorTemplate> heavyArmorMap = new EnumMap<>(HeavyArmorTypeEnum.class);

        try
        {
            HeavyArmorList heavyArmorList =
                objectMapper.readValue(new File("src/main/resources/items/HeavyArmorList.json"), HeavyArmorList.class);

            for (HeavyArmorTemplate HeavyArmorTemplate : heavyArmorList.getHeavyArmors())
            {

                heavyArmorMap.put(HeavyArmorTemplate.getHeavyArmorType(), HeavyArmorTemplate);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return heavyArmorMap;
    }

    public static HeavyArmor createHeavyArmor(HeavyArmorTypeEnum heavyArmorType)
    {
        HeavyArmorTemplate template = HEAVY_ARMOR_MAP.get(heavyArmorType);

        return new HeavyArmor(template);
    }
}
