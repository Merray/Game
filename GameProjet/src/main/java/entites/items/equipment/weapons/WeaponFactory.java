package entites.items.equipment.weapons;

import java.io.File;
import java.io.IOException;
import java.util.EnumMap;

import com.fasterxml.jackson.databind.ObjectMapper;

public class WeaponFactory
{

    private static final EnumMap<WeaponTypeEnum, WeaponTemplate> WEAPON_MAP = chargeMap();

    private WeaponFactory()
    {
    }

    private static EnumMap<WeaponTypeEnum, WeaponTemplate> chargeMap()
    {
        ObjectMapper objectMapper = new ObjectMapper();
        EnumMap<WeaponTypeEnum, WeaponTemplate> weaponMap = new EnumMap<>(WeaponTypeEnum.class);

        try
        {
            WeaponList weaponList =
                objectMapper.readValue(new File("src/main/resources/items/WeaponList.json"), WeaponList.class);

            for (WeaponTemplate weapon : weaponList.getWeapons())
            {

                weaponMap.put(weapon.getWeaponType(), weapon);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return weaponMap;
    }

    public static Weapon createWeapon(WeaponTypeEnum weaponType)
    {
        WeaponTemplate template = WEAPON_MAP.get(weaponType);

        return new Weapon(template);
    }
}
