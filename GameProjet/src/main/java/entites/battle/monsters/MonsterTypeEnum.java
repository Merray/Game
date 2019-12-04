package entites.battle.monsters;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum MonsterTypeEnum
{

    @JsonProperty("NONE")
    NONE, @JsonProperty("GOBLIN")
    GOBLIN, @JsonProperty("ARAIGNEE")
    ARAIGNEE;

}
