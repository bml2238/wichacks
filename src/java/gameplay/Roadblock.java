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
    private enum Type {SELF_ESTEEM, RESPECT, MONEY};

    /** the what causes an effect */
    private enum Effect {
        USE, //decrease number of item
        PROPERTY //you have to pay for your rent
    }

    /** list of roadblocks */
    private ArrayList<Roadblock> roadblocks = new ArrayList<>();
    private ArrayList<Roadblock> intervalRoadblock = new ArrayList();

    /** roadblock that will occur when reaching a certain time */
    private Roadblock(String name, int timeTriggered, int penalty, Type type) {
        this.name = name;
        this.timeTriggered = timeTriggered;
        //this.event = e;
        this.type = type;
    }

    /** roadblock that will occur after a certain interval */
    private void intervalRoadBlock(String name, int timeInterval, Type type, Effect effect) {
        this.name = name;
        this.timeInterval = timeInterval;
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

    /** creates array of intervaled roadblocks */
    public ArrayList<intervalRoadBlock> intervalRoadBlock{
        /** $$$$$$$$$$$$$$$$$ MENSTRUAL CYCLE $$$$$$$$$$$$$$$$$$$$$ */
        final intervalRoadBlock MENSTRUAL_CYCLE = new intervalRoadBlock("MENSTRUAL CYCLE", 1, Type.SELF_ESTEEM);
        intervalRoadblock.add(MENSTRUAL_CYCLE);

        /** $$$$$$$$$$$$$$$$ PAY RENT $$$$$$$$$$$$$$$$$$$ */
        final intervalRoadBlock PAY_RENT = new intervalRoadBlock("PAY_RENT", 1, Type.MONEY, Effect.PROPERTY);
        intervalRoadblock.add(PAY_RENT);

        return intervalRoadblock;
    }

}
