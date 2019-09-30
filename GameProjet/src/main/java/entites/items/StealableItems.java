package entites.items;

import java.util.Random;

public class StealableItems
{

    private Item centPourcent;

    private Item vingtCinqPourcent;

    private Item sixPourcent;

    private Item zeroPourcent;

    public StealableItems(Item centPourcent, Item vingtCinqPourcent, Item sixPourcent, Item zeroPourcent)
    {
        super();
        this.centPourcent = centPourcent;
        this.vingtCinqPourcent = vingtCinqPourcent;
        this.sixPourcent = sixPourcent;
        this.zeroPourcent = zeroPourcent;
    }

    public Item tryToSteal()
    {

        Item stolenItem = null;
        Random randomNumber = new Random();
        Integer number = null;

        // Rare
        if (zeroPourcent != null)
        {
            number = randomNumber.nextInt(256) + 1;
            if (number <= 1)
            {
                stolenItem = zeroPourcent;
            }
        }
        // Semi-rare
        if (sixPourcent != null && stolenItem == null)
        {
            number = randomNumber.nextInt(256) + 1;
            if (number <= 16)
            {
                stolenItem = sixPourcent;
            }
        }
        // Uncommon
        if (vingtCinqPourcent != null && stolenItem == null)
        {
            number = randomNumber.nextInt(256) + 1;
            if (number <= 64)
            {
                stolenItem = vingtCinqPourcent;
            }
        }
        // Common
        if (centPourcent != null && stolenItem == null)
        {
            stolenItem = centPourcent;
        }

        return stolenItem;

    }

    /**
     * Accesseur de centPourcent
     *
     * @return centPourcent
     */
    public Item getCentPourcent()
    {
        return centPourcent;
    }

    /**
     * Mutateur de centPourcent
     *
     * @param centPourcent centPourcent
     */
    public void setCentPourcent(Item centPourcent)
    {
        this.centPourcent = centPourcent;
    }

    /**
     * Accesseur de vingtCinqPourcent
     *
     * @return vingtCinqPourcent
     */
    public Item getVingtCinqPourcent()
    {
        return vingtCinqPourcent;
    }

    /**
     * Mutateur de vingtCinqPourcent
     *
     * @param vingtCinqPourcent vingtCinqPourcent
     */
    public void setVingtCinqPourcent(Item vingtCinqPourcent)
    {
        this.vingtCinqPourcent = vingtCinqPourcent;
    }

    /**
     * Accesseur de sixPourcent
     *
     * @return sixPourcent
     */
    public Item getSixPourcent()
    {
        return sixPourcent;
    }

    /**
     * Mutateur de sixPourcent
     *
     * @param sixPourcent sixPourcent
     */
    public void setSixPourcent(Item sixPourcent)
    {
        this.sixPourcent = sixPourcent;
    }

    /**
     * Accesseur de zeroPourcent
     *
     * @return zeroPourcent
     */
    public Item getZeroPourcent()
    {
        return zeroPourcent;
    }

    /**
     * Mutateur de zeroPourcent
     *
     * @param zeroPourcent zeroPourcent
     */
    public void setZeroPourcent(Item zeroPourcent)
    {
        this.zeroPourcent = zeroPourcent;
    }

}
