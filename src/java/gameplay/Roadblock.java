package gameplay;

import java.util.ArrayList;

/**
 * in the game progression, these are guaranteed events
 */
public class Roadblock {

    /** a roadblock is a timed event */
    private int String name;
    private int timeTriggered;
    private int timeInverval;
    private int penalty;
    //private Event event;
    private Type type;
    private Effect effect; //what you have that causes a trigger

    /** the value that going to be modified */
    private enum Type {SELF_ESTEEM, RESPECT, MONEY};

    /** the what causes an effect */
    private enum Effect {
        USE //decrease number of item
        PROPERTY //you have to pay for your rent
    }

    /** list of roadblocks */
    private ArrayList<Roadblock> roadblocks = new ArrayList<>();
    private ArrayList<IntervalRoadBlock> intervalRoadblock = new ArrayList();

    /** roadblock that will occur when reaching a certain time */
    private Roadblock(String name, int timeTriggered, int pentalty, Type type) {
        this.name = name;
        this.timeTriggered = timeTriggered;
        //this.event = e;
        this.type = type;
    }

    /** roadblock that will occur after a certain interval */
    private IntervalRoadblock(String name, int timeInterval, Type type, Effect effect ) {
        this.name = name;
        this.timeInterval = timeInterval;
        this.type = type;
    }

    /** creates array of roadblocks */
    public ArrayList<Roadblock> createRoadblocks() {
        /** $$$$$$$$$$$$$$$$$ NO_CHILDREN $$$$$$$$$$$$$$$$$$$$$$*/
        final Roadblock NO_CHILDREN = new Roadblock("NO_CHILDREN", 228, -20, TYPE.RESPECT);
        roadblocks.add(NO_CHILDREN);

        /** $$$$$$$$$$$$$$$$$$$$ BEAUTY STANDARDS $$$$$$$$$$$$$$ */
        final Roadblock BEAUTY_STANDARDS = new Roadblock("BEAUTY_STANDARDS", 228, -30, TYPE.ESTEEM);
        roadblocks.add(BEAUTY_STANDARDS);

        return roadblocks;
    }

    /** creates array of intervaled roadblocks */
    public ArrayList<IntervalRoadblock> intervalRoadblock = new ArrayList() {
        /** $$$$$$$$$$$$$$$$$ MENSTRUAL CYCLE $$$$$$$$$$$$$$$$$$$$$ */
        final IntervalRoadblock MENSTRUAL_CYCLE = new IntervalRoadblock("MENSTRUAL CYCLE", 1, TYPE.EFFECT.USE);
        intervalRoadblock.add(MENSTRUAL_CYCLE);

        /** $$$$$$$$$$$$$$$$ PAY RENT $$$$$$$$$$$$$$$$$$$ */
        final IntervalRoadblock PAY_RENT = new IntervalRoadblock("PAY_RENT", 1, TYPE.MONEY, EFFECT.PROPERTY);
        intervalRoadblock.add(PAY_RENT);

        return intervalRoadblock;
    }

}
