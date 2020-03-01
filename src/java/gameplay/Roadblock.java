package gameplay;

import java.util.ArrayList;

/**
 * in the game progression, these are guaranteed events
 */
public class Roadblock {

    /** a roadblock is a timed event */
    String name;
    private int timeTriggered;
    private int timeInverval;
    private Event event;

    /** list of roadblocks */
    private ArrayList<Roadblock> roadblocks = new ArrayList<>();

    /** roadblock that will occur when reaching a certain time */
    private Roadblock(String name, int timeTriggered, Event e) {
        this.name = name;
        this.timeTriggered = timeTriggered;
        this.event = e;
    }

    private void intervalRoadBlock(String name, int interval, Event e) {
        
    }
 //   private intervalRoadblock(String name) {} delete


    public ArrayList<Roadblock> createRoadblocks() {
        /** $$$$$$$$$$$$$$$$$ TAXES $$$$$$$$$$$$$$$$$$$$$$*/


        return roadblocks;
    }

}
