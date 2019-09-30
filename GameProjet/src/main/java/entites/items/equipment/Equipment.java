package entites.items.equipment;

import entites.battle.player.BattlePlayer;
import entites.items.Item;

public interface Equipment extends Item
{

	public String getName();

	public void applyStats(BattlePlayer target);

	// public void loosenStats(Perso target);

	public Integer getCost();

}
