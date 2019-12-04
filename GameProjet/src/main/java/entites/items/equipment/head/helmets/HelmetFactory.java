package entites.items.equipment.head.helmets;

import java.io.File;
import java.io.IOException;
import java.util.EnumMap;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HelmetFactory
{
    private static final EnumMap<HelmetTypeEnum, HelmetTemplate> HELMET_MAP = chargeMap();

    private HelmetFactory()
    {
    }

    private static EnumMap<HelmetTypeEnum, HelmetTemplate> chargeMap()
    {
        ObjectMapper objectMapper = new ObjectMapper();
        EnumMap<HelmetTypeEnum, HelmetTemplate> helmetMap = new EnumMap<>(HelmetTypeEnum.class);

        try
        {
            HelmetList helmetList =
                objectMapper.readValue(new File("src/main/resources/items/HelmetList.json"), HelmetList.class);

            for (HelmetTemplate HelmetTemplate : helmetList.getHelmets())
            {

                helmetMap.put(HelmetTemplate.getHelmetType(), HelmetTemplate);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return helmetMap;
    }

    public static Helmet createHelmet(HelmetTypeEnum helmetType)
    {
        HelmetTemplate template = HELMET_MAP.get(helmetType);

        return new Helmet(template);

    }
}
