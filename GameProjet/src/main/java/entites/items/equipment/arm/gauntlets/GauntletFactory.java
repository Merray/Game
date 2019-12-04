package entites.items.equipment.arm.gauntlets;

import java.io.File;
import java.io.IOException;
import java.util.EnumMap;

import com.fasterxml.jackson.databind.ObjectMapper;

public class GauntletFactory
{

    private static final EnumMap<GauntletTypeEnum, GauntletTemplate> GAUNTLET_MAP = chargeMap();

    private GauntletFactory()
    {
    }

    private static EnumMap<GauntletTypeEnum, GauntletTemplate> chargeMap()
    {
        ObjectMapper objectMapper = new ObjectMapper();
        EnumMap<GauntletTypeEnum, GauntletTemplate> weaponMap = new EnumMap<>(GauntletTypeEnum.class);

        try
        {
            GauntletList gauntletList =
                objectMapper.readValue(new File("src/main/resources/items/GauntletList.json"), GauntletList.class);

            for (GauntletTemplate GauntletTemplate : gauntletList.getGauntlets())
            {

                weaponMap.put(GauntletTemplate.getGauntletType(), GauntletTemplate);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return weaponMap;
    }

    public static Gauntlet createGauntlet(GauntletTypeEnum gauntletType)
    {
        GauntletTemplate template = GAUNTLET_MAP.get(gauntletType);

        return new Gauntlet(template);
    }
}
