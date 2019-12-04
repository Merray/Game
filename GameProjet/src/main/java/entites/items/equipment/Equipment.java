package entites.items.equipment;

import entites.battle.players.BattlePlayer;
import entites.items.Item;

public abstract class Equipment extends Item
{

    public Equipment()
    {
        super();

    }

    public Equipment(String name, Integer cost)
    {
        super(name, cost);

    }

    public abstract void applyStats(BattlePlayer target);

}
