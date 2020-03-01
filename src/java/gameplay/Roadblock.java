package gameplay;

import java.util.ArrayList;

/**
 * in the game progression, these are guaranteed events
 */
public class Roadblock {

    /** a roadblock is a timed event */
    private int timeTriggered;
    private Event event;

    /** list of roadblocks */
    private ArrayList<Roadblock> roadblocks = new ArrayList<>();

    private Roadblock(int timeTriggered, Event e) {
        this.timeTriggered = timeTriggered;
        this.event = e;
    }

    public ArrayList<Roadblock> createRoadblocks() {
        /** */

        return roadblocks;
    }

}
