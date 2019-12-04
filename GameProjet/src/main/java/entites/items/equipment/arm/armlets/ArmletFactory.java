package entites.items.equipment.arm.armlets;

import java.io.File;
import java.io.IOException;
import java.util.EnumMap;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ArmletFactory
{
    private static final EnumMap<ArmletTypeEnum, ArmletTemplate> ARMLET_MAP = chargeMap();

    private ArmletFactory()
    {
    }

    private static EnumMap<ArmletTypeEnum, ArmletTemplate> chargeMap()
    {
        ObjectMapper objectMapper = new ObjectMapper();
        EnumMap<ArmletTypeEnum, ArmletTemplate> armletMap = new EnumMap<>(ArmletTypeEnum.class);

        try
        {
            ArmletList weaponList =
                objectMapper.readValue(new File("src/main/resources/items/ArmletList.json"), ArmletList.class);

            for (ArmletTemplate ArmletTemplate : weaponList.getArmlets())
            {

                armletMap.put(ArmletTemplate.getArmletType(), ArmletTemplate);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return armletMap;
    }

    public static Armlet createArmlet(ArmletTypeEnum armletType)
    {
        ArmletTemplate template = ARMLET_MAP.get(armletType);

        return new Armlet(template);
    }
}
