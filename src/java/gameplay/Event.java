package gameplay;

import java.util.ArrayList;

public class Event {

    /** event stats */
    private double chance; //chance of event triggering
    private int penalty; //what you will lose
    private Type type;
    private Trigger trigger;

    public ArrayList<Event> events;

    /** what you will lose it from */
    private enum Type {SELF_ESTEEM, RESPECT, MONEY}

    /** what triggered the event */
    private enum Trigger {BUYING,  //after purchasing an item, either clothing or otherwise
                          HIRING,  //after hiring a new employee. event can be new employee or reactions of others
                          FIRING,  //after firing an employee
                          EMPLOYEE //can be triggered anytime by an employee
                    }

    /** event constructor */
    private Event(double chance, int penalty, Type type, Trigger trigger) {
        this.chance = chance;
        this.penalty = penalty;
        this.type = type;
        this.trigger = trigger;
    }

    public boolean isTriggered(Event e) {
        double prob = Math.random();
        return(e.chance > prob);
    }

    // ridicule from males for certain items you're wearing
    // making a bad business decision (like investment in a shady co.) that could result in losing employees and money
    /** increased difficulty of game? making it harder to get respect and employees making you
    work harder, in turn making you more successful */
    // lack of effort from employees ... resulting in ?
    // upgrading business or house if respect & business level is high enough


}
