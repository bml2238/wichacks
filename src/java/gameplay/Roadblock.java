package gameplay;

import java.util.ArrayList;

/**
 * in the game progression, these are guaranteed events
 */
public class Roadblock {

    /** a roadblock is a timed event */
    private int timeTriggered;
    private int timeInverval;
    private Event event;

    /** list of roadblocks */
    private ArrayList<Roadblock> roadblocks = new ArrayList<>();

    /** roadblock that will occur when reaching a certain time */
    private Roadblock(String name, int timeTriggered, Event e) {
        this.name = name
        this.timeTriggered = timeTriggered;
        this.event = e;
    }

    private intervalRoadBlock(String name, int interval, Event e)
    {
        
    }
    privae IntervalRoadblock(String name)
    public ArrayList<Roadblock> createRoadblocks() {
        /** $$$$$$$$$$$$$$$$$ TAXES $$$$$$$$$$$$$$$$$$$$$$*/


        return roadblocks;
    }

}
