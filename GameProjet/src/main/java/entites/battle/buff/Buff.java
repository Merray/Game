package entites.battle.buff;

public enum Buff
{
	AUCUN(null, null, null, 0);

	private String phraseDebut;

	private String phraseFin;

	private ModifierType modifierType;

	private int duree;

	private Buff(String phraseDebut, String phraseFin, ModifierType modifierType, int duree)
	{
		this.phraseDebut = phraseDebut;
		this.phraseFin = phraseFin;
		this.modifierType = modifierType;
		this.duree = duree;
	}

	/**
	 * Accesseur de modifierType
	 *
	 * @return modifierType
	 */
	public ModifierType getModifierType()
	{
		return modifierType;
	}

	/**
	 * Mutateur de modifierType
	 *
	 * @param modifierType modifierType
	 */
	public void setModifierType(ModifierType modifierType)
	{
		this.modifierType = modifierType;
	}

	/**
	 * Accesseur de phraseDebut
	 *
	 * @return phraseDebut
	 */
	public String getPhraseDebut()
	{
		return phraseDebut;
	}

	/**
	 * Mutateur de phraseDebut
	 *
	 * @param phraseDebut phraseDebut
	 */
	public void setPhraseDebut(String phraseDebut)
	{
		this.phraseDebut = phraseDebut;
	}

	/**
	 * Accesseur de phraseFin
	 *
	 * @return phraseFin
	 */
	public String getPhraseFin()
	{
		return phraseFin;
	}

	/**
	 * Mutateur de phraseFin
	 *
	 * @param phraseFin phraseFin
	 */
	public void setPhraseFin(String phraseFin)
	{
		this.phraseFin = phraseFin;
	}

	/**
	 * Accesseur de duree
	 *
	 * @return duree
	 */
	public int getDuree()
	{
		return duree;
	}

	/**
	 * Mutateur de duree
	 *
	 * @param duree duree
	 */
	public void setDuree(int duree)
	{
		this.duree = duree;
	}
}
