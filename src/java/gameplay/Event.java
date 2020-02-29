package gameplay;

public class Event {

    /** event stats */
    private double chance; //chance of event triggering
    private int penalty; //what you will lose

    /** what you will lose it from */
    private enum Type { SELF_ESTEEM, RESPECT, MONEY}

    /** what triggered the event */
    private enum Trigger {BUYING, HIRING, FIRING, EMPLOYEE}

    /** event constructor */
    private Event(double chance, int penalty, Type type, Trigger trigger) {
        this.chance = chance;

    }

}
