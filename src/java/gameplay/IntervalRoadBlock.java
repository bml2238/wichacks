package gameplay;

import java.util.ArrayList;

public class IntervalRoadBlock {

    private ArrayList<IntervalRoadBlock> intervalRoadBlock = new ArrayList<>();
    private String name;
    private int timeTriggered;
    private int timeInterval;
    private int penalty;
    //private Event event;
    private Type type;
    private Effect effect; //what you have that causes a trigger

    private enum Type {SELF_ESTEEM, RESPECT, MONEY}

    /** the what causes an effect */
    private enum Effect {
        USE, //decrease number of item
        PROPERTY //you have to pay for your rent
    }

    /** roadblock that will occur after a certain interval */
    public IntervalRoadBlock(String name, int timeInterval, Type type, Effect effect) {
        this.name = name;
        this.timeInterval = timeInterval;
        this.type = type;
    }

    /** creates array of intervaled roadblocks */
    public ArrayList<IntervalRoadBlock> createIntervalRoadBlock() {
        /** $$$$$$$$$$$$$$$$$ MENSTRUAL CYCLE $$$$$$$$$$$$$$$$$$$$$ */
        final IntervalRoadBlock MENSTRUAL_CYCLE = new IntervalRoadBlock("MENSTRUAL CYCLE",
                1, Type.SELF_ESTEEM, Effect.USE);
        intervalRoadBlock.add(MENSTRUAL_CYCLE);

        /** $$$$$$$$$$$$$$$$ PAY RENT $$$$$$$$$$$$$$$$$$$ */
        final IntervalRoadBlock PAY_RENT = new IntervalRoadBlock("PAY_RENT", 1,
                Type.MONEY, Effect.PROPERTY);
        intervalRoadBlock.add(PAY_RENT);

        return intervalRoadBlock;
    }
}
