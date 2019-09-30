package entites.items;

import java.util.Random;

public class DroppableItems
{
    // 37.5 96/256
    // 12.5 32/256
    // 1/256

    private Item centPourcent;

    private Item trenteSeptPourcent;

    private Item douzePourcent;

    private Item zeroPourcent;

    public DroppableItems(Item centPourcent, Item trenteSeptPourcent, Item douzePourcent, Item zeroPourcent)
    {
        super();
        this.centPourcent = centPourcent;
        this.trenteSeptPourcent = trenteSeptPourcent;
        this.douzePourcent = douzePourcent;
        this.zeroPourcent = zeroPourcent;
    }

    public Item tryToDrop()
    {
        Item droppedItem = null;
        Random randomNumber = new Random();
        Integer number = null;

        // Rare
        if (zeroPourcent != null)
        {
            number = randomNumber.nextInt(256) + 1;
            if (number <= 1)
            {
                droppedItem = zeroPourcent;
            }
        }
        // Semi-rare
        if (douzePourcent != null && droppedItem == null)
        {
            number = randomNumber.nextInt(256) + 1;
            if (number <= 32)
            {
                droppedItem = douzePourcent;
            }
        }
        // Uncommon
        if (trenteSeptPourcent != null && droppedItem == null)
        {
            number = randomNumber.nextInt(256) + 1;
            if (number <= 96)
            {
                droppedItem = trenteSeptPourcent;
            }
        }
        // Common
        if (centPourcent != null && droppedItem == null)
        {
            droppedItem = centPourcent;
        }

        return droppedItem;

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
     * Accesseur de trenteSeptPourcent
     *
     * @return trenteSeptPourcent
     */
    public Item getTrenteSeptPourcent()
    {
        return trenteSeptPourcent;
    }

    /**
     * Mutateur de trenteSeptPourcent
     *
     * @param trenteSeptPourcent trenteSeptPourcent
     */
    public void setTrenteSeptPourcent(Item trenteSeptPourcent)
    {
        this.trenteSeptPourcent = trenteSeptPourcent;
    }

    /**
     * Accesseur de douzePourcent
     *
     * @return douzePourcent
     */
    public Item getDouzePourcent()
    {
        return douzePourcent;
    }

    /**
     * Mutateur de douzePourcent
     *
     * @param douzePourcent douzePourcent
     */
    public void setDouzePourcent(Item douzePourcent)
    {
        this.douzePourcent = douzePourcent;
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
