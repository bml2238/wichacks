package gameplay;

import java.util.ArrayList;

/**
 * in the game progression, these are guaranteed events
 */
public class Roadblock {

    /** a roadblock is a timed event */
    private String name;
    private int timeTriggered;
    private int timeInterval;
    private int penalty;
    //private Event event;
    private Type type;
    private Effect effect; //what you have that causes a trigger

    /** the value that going to be modified */
    private enum Type {SELF_ESTEEM, RESPECT, MONEY}

    /** the what causes an effect */
    private enum Effect {
        USE, //decrease number of item
        PROPERTY //you have to pay for your rent
    }

    /** list of roadblocks */
    private ArrayList<Roadblock> roadblocks = new ArrayList<>();
    private ArrayList<Roadblock> intervalRoadBlock = new ArrayList<>();

    /** roadblock that will occur when reaching a certain time */
    public Roadblock(String name, int timeTriggered, int penalty, Type type) {
        this.name = name;
        this.timeTriggered = timeTriggered;
        //this.event = e;
        this.type = type;
    }

    /** creates array of roadblocks */
    public ArrayList<Roadblock> createRoadblocks() {
        /** $$$$$$$$$$$$$$$$$ NO_CHILDREN $$$$$$$$$$$$$$$$$$$$$$*/
        final Roadblock NO_CHILDREN = new Roadblock("NO_CHILDREN", 228, -20, Type.RESPECT);
        roadblocks.add(NO_CHILDREN);

        /** $$$$$$$$$$$$$$$$$$$$ BEAUTY STANDARDS $$$$$$$$$$$$$$ */
        final Roadblock BEAUTY_STANDARDS = new Roadblock("BEAUTY_STANDARDS", 228, -30, Type.SELF_ESTEEM);
        roadblocks.add(BEAUTY_STANDARDS);

        return roadblocks;
    }
}
