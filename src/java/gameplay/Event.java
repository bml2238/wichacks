package gameplay;

import mechanics.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class Event {

    /** event stats */
    private String name;
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
    private enum Trigger {BUYING,   //after purchasing an item, either clothing or otherwise
                          HIRING,   //after hiring a new employee. event can be new employee or reactions of others
                          FIRING,   //after firing an employee
                          EMPLOYEE, //can be triggered anytime by an employee
                          JOB       //triggered while doing work
                    }

    /** event constructor */
    private Event(String name, double chance, int penalty, boolean repeat, Type type, Trigger trigger) {
        this.name = name;
        this.chance = chance;
        this.penalty = penalty;
        this.repeat = repeat;
        this.type = type;
        this.trigger = trigger;
    }

    /** get event name */
    public String getName() { return this.name; }

    /**
     * check if the event is triggered, called when event criteria have been met
     * @param e the event that may be triggered
     * @return whether or not it triggered
     */
    public static boolean isTriggered(Event e) {
        double prob = Math.random();
        if(!e.repeat)
            events.remove(e); //an event cannot be triggered twice
        return(e.chance > prob);
    }

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

    /** generates all events into an arraylist */
    public static ArrayList<Event> createEvents(Player player) {
        /*$$$$$$$$$$$$$$$$$ BUYING EVENTS $$$$$$$$$$$$$$$$$*/
        final Event NOT_PRETTY_ENOUGH = new Event("NOT_PRETTY_ENOUGH", .05, -15, true,
                                                   Type.SELF_ESTEEM, Trigger.BUYING);
        events.add(NOT_PRETTY_ENOUGH);

        final Event SLUT_SHAMING = new Event("SLUT_SHAMING", .25, -10, true,
                                              Type.RESPECT, Trigger.BUYING);
        events.add(SLUT_SHAMING);

        /*$$$$$$$$$$$$$$$$$ HIRING EVENTS $$$$$$$$$$$$$$$$$**/
        final Event TOO_MANY_GIRLS = new Event("TOO_MANY_GIRLS", .3, -10, true,
                                                Type.RESPECT, Trigger.HIRING);
        events.add(TOO_MANY_GIRLS);

        /*$$$$$$$$$$$$$$$$$ EMPLOYEE EVENTS $$$$$$$$$$$$$$$$$*/
        final Event EMPLOYEE_QUITS = new Event("EMPLOYEE_QUITS", .4, -10,
                true, Type.RESPECT, Trigger.EMPLOYEE);
        events.add(EMPLOYEE_QUITS);

        /*$$$$$$$$$$$$$$$$$ JOB EVENTS $$$$$$$$$$$$$$$$$*/
        final Event REDUCED_FUNDING = new Event("REDUCED_FUNDING", .1, -10, true,
                                                 Type.SELF_ESTEEM, Trigger.JOB);
        events.add(REDUCED_FUNDING);
        final Event REJECTED_FUNDING = new Event("REJECTED_FUNDING", .25, -20, true,
                                                  Type.SELF_ESTEEM, Trigger.JOB);
        events.add(REJECTED_FUNDING);

        final Event BAD_INVESTMENT_DECISION = new Event("BAD_INVESTMENT", .2, -500,
                true, Type.MONEY, Trigger.JOB);

        events.add(BAD_INVESTMENT_DECISION);

        /*$$$$$$$$$$$$$$$$$ FIRING EVENTS $$$$$$$$$$$$$$$$$*/
        final Event LOST_THEIR_COOL = new Event("LOST_THEIR_COOL", .5, -5, true,
                                                Type.SELF_ESTEEM, Trigger.FIRING);
        events.add(LOST_THEIR_COOL);
        final Event RUMORED_AFFAIR = new Event("RUMORED_AFFAIR", .05, -20, false,
                                                Type.RESPECT, Trigger.FIRING);
        events.add(RUMORED_AFFAIR);

        return events;
    }

    public void getEvent(String name){
        events.get(Integer.parseInt(name));
    }
}
