package entites.items.equipment.body.lightarmor;

import java.io.File;
import java.io.IOException;
import java.util.EnumMap;

import com.fasterxml.jackson.databind.ObjectMapper;

public class LightArmorFactory
{
    private static final EnumMap<LightArmorTypeEnum, LightArmorTemplate> LIGHT_ARMOR_MAP = chargeMap();

    private LightArmorFactory()
    {
    }

    private static EnumMap<LightArmorTypeEnum, LightArmorTemplate> chargeMap()
    {
        ObjectMapper objectMapper = new ObjectMapper();
        EnumMap<LightArmorTypeEnum, LightArmorTemplate> lightArmorMap = new EnumMap<>(LightArmorTypeEnum.class);

        try
        {
            LightArmorList lightArmorList =
                objectMapper.readValue(new File("src/main/resources/items/LightArmorList.json"), LightArmorList.class);

            for (LightArmorTemplate LightArmorTemplate : lightArmorList.getLightArmors())
            {

                lightArmorMap.put(LightArmorTemplate.getLightArmorType(), LightArmorTemplate);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return lightArmorMap;
    }

    public static LightArmor createLightArmor(LightArmorTypeEnum lightArmorType)
    {
        LightArmorTemplate template = LIGHT_ARMOR_MAP.get(lightArmorType);

        return new LightArmor(template);
    }
}
