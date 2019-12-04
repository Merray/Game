package entites.items.equipment.weapons;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum WeaponTypeEnum
{
    @JsonProperty("NONE")
    NONE, @JsonProperty("DAGGER")
    DAGGER, @JsonProperty("BROADSWORD")
    BROADSWORD;
}
