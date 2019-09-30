package entites.battle.player;

import java.util.List;

import entites.battle.buff.Buff;
import entites.battle.buff.Debuff;
import entites.items.DroppableItems;
import entites.items.StealableItems;

public enum Monsters implements BattleEntity
{

	NONE, GOBELIN;

	private String name;

	private Integer level;

	// A changer avec la bonne classe
	private List<String> abilities;

	private StealableItems stealableItems;

	private DroppableItems droppedItems;

	// A changer avec la bonne classe
	private String elementalAffinities;

	private Integer moneyDropped;

	/** debuffs. */
	private List<Debuff> debuffs;

	/** buffs. */
	private List<Buff> buffs;

	/** max HP. */
	private Integer maxHP;

	/** current HP. */
	private Integer currentHP;

	/** max MP. */
	private Integer maxMP;

	/** current MP. */
	private Integer currentMP;

	/** strength. */
	private Integer strength;

	/** magic. */
	private Integer magic;

	/** spirit. */
	private Integer spirit;

	/** speed. */
	private Integer speed;

	// ============= Secondary stats =================

	/** attack. */
	private Integer attack;

	/** defense. */
	private Integer defense;

	/** evasion. */
	private Integer evasion;

	/** magic defense. */
	private Integer magicDefense;

	/** magic evasion. */
	private Integer magicEvasion;
}
