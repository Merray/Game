package entites.battle.players;

import java.util.List;

public class BaseJobList
{
    private List<BaseJob> baseJobs;

    public BaseJobList()
    {
        super();
    }

    /**
     * Accesseur de baseJobs
     *
     * @return baseJobs
     */
    public List<BaseJob> getBaseJobs()
    {
        return baseJobs;
    }

    /**
     * Mutateur de baseJobs
     *
     * @param baseJobs baseJobs
     */
    public void setBaseJobs(List<BaseJob> baseJobs)
    {
        this.baseJobs = baseJobs;
    }

}
