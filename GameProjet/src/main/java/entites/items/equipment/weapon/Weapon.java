package entites.items.equipment.weapon;

import entites.battle.player.BattlePlayer;
import entites.items.equipment.Equipment;

public interface Weapon extends Equipment
{

	public void applyElement(BattlePlayer target);

	public void applyDebuff(BattlePlayer target);

}
