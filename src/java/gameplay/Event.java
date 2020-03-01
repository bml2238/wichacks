package gameplay;

import mechanics.Player;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Event {

    /** event stats */
    private double chance; //chance of event triggering
    private int penalty; //what you will lose
    boolean repeat; //if the event can be triggered multiple times
    private Type type;
    private Trigger trigger;

    /** list of events */
    private static ArrayList<Event> events = new ArrayList<>();

    /** what you will lose it from */
    private enum Type {SELF_ESTEEM, RESPECT, MONEY}

    /** what triggered the event */
    private enum Trigger {BUYING,  //after purchasing an item, either clothing or otherwise
                          HIRING,  //after hiring a new employee. event can be new employee or reactions of others
                          FIRING,  //after firing an employee
                          EMPLOYEE //can be triggered anytime by an employee
                    }

    /** event constructor */
    private Event(double chance, int penalty, boolean repeat, Type type, Trigger trigger) {
        this.chance = chance;
        this.penalty = penalty;
        this.repeat = repeat;
        this.type = type;
        this.trigger = trigger;
    }

    /**
     * check if the event is triggered, called when event criteria have been met
     * @param e the event that may be triggered
     * @return whether or not it triggered
     */
    public boolean isTriggered(Event e) {
        double prob = Math.random();
        if(!e.repeat)
            events.remove(e); //an event cannot be triggered twice
        return(e.chance > prob);
    }

<<<<<<< HEAD
=======
    /**
     * the event triggered, now have it affect the player
     * @param player the player effected
     */
    public void affected(Player player) {
        if(this.type == Type.RESPECT)
            player.changeRespect(this.penalty);
        else if(this.type == Type.SELF_ESTEEM)
            player.changeRespect(this.penalty);
        else
            player.changeMoney(this.penalty);
    }

    public static ArrayList<Event> createEvents() {
        /*$$$$$$$$$$$$$$$$$ BUYING EVENTS $$$$$$$$$$$$$$$$$*/
        final Event NOT_PRETTY_ENOUGH = new Event(.05, -15, true, Type.SELF_ESTEEM, Trigger.BUYING);
        events.add(NOT_PRETTY_ENOUGH);
        final Event SLUT_SHAMING = new Event(.25, -10, true, Type.RESPECT, Trigger.BUYING);
        events.add(SLUT_SHAMING);

        /*$$$$$$$$$$$$$$$$$ HIRING EVENTS $$$$$$$$$$$$$$$$$**/
        final Event TOO_MANY_GIRLS = new Event(.3, -10, true, Type.RESPECT, Trigger.HIRING);
        events.add(TOO_MANY_GIRLS);

        /*$$$$$$$$$$$$$$$$$ EMPLOYEE EVENTS $$$$$$$$$$$$$$$$$*/


        /*$$$$$$$$$$$$$$$$$ FIRING EVENTS $$$$$$$$$$$$$$$$$*/
        final Event RUMORED_AFFAIR = new Event(.05, -20, false, Type.RESPECT, Trigger.FIRING);
        events.add(RUMORED_AFFAIR);


        return events;
    }

    // ridicule from males for certain items you're wearing
    // making a bad business decision (like investment in a shady co.) that could result in losing employees and money
    /** increased difficulty of game? making it harder to get respect and employees making you
    work harder, in turn making you more successful */
    // lack of effort from employees ... resulting in ?
    // upgrading business or house if respect & business level is high enough
>>>>>>> ced97a8b270267af990dd87db2557c479d90deb0


}
