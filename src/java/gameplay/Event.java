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

    // ridicule from males for certain items you're wearing
    // making a bad business decision (like investment in a shady co.) that could result in losing employees and money
    /** increased difficulty of game? making it harder to get respect and employees making you
    work harder, in turn making you more successful */
    // lack of effort from employees ... resulting in ?


}
