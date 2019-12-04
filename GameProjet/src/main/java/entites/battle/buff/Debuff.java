package entites.battle.buff;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Debuff
{
	@JsonProperty("aucun")
	AUCUN(null, null, null, 0, 0), FEU(" prend feu !", " n'est plus en feu !", " souffre de brûlure", 1, 4),
	POISON(" sent un poison couler dans ses veines !", " sent le poison s'estomper", " souffre du poison", 2, 2),
	LETHAL_POISON(" sent un poison létal couler dans ses veines !", " sent le poison létal s'estomper",
			" souffre du poison létal", 2, 4),
	SAIGNEMENT(" commence à saigner !", " a arrêté l'hémoragie !", " perd beaucoup de sang", 1, 6);

	private String phraseDebut;

	private String phraseFin;

	private String phraseTrigger;

	private int degats;

	private int duree;

	private Debuff(String phraseDebut, String phraseFin, String phraseTrigger, int degats, int duree)
	{
		this.phraseDebut = phraseDebut;
		this.phraseFin = phraseFin;
		this.phraseTrigger = phraseTrigger;
		this.degats = degats;
		this.duree = duree;
	}

	/**
	 * Accesseur de degats
	 *
	 * @return degats
	 */
	public int getDegats()
	{
		return degats;
	}

	/**
	 * Mutateur de degats
	 *
	 * @param degats degats
	 */
	public void setDegats(int degats)
	{
		this.degats = degats;
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
	 * Accesseur de phraseTrigger
	 *
	 * @return phraseTrigger
	 */
	public String getPhraseTrigger()
	{
		return phraseTrigger;
	}

	/**
	 * Mutateur de phraseTrigger
	 *
	 * @param phraseTrigger phraseTrigger
	 */
	public void setPhraseTrigger(String phraseTrigger)
	{
		this.phraseTrigger = phraseTrigger;
	}

}
