package gameplay;

import mechanics.Business;
import mechanics.Employee;
import mechanics.Player;

import java.util.ArrayList;
import java.util.Objects;

public class BusinessActions {

    private String message = "";
    private double profit = 0;
    Player player;

    public BusinessActions(Player player) { this.player = player; }

    ArrayList<Event> events = Event.createEvents(this.player);

    /**
     * generates a string of the player's business's stats
     * @param p the player who's business is to be evaluated
     * @return the stats
     */
    public String displayBusinessStats(Player p) {
        message = "";
        ArrayList<String> stats = p.getBusiness().viewBusiness();
        for(String stat : stats)
            System.out.println(stat);

        return message;
    }

    /** searches through events and returns the requested event */
    private Event getEvent(String name) {
        for(Event e : events) {
            if(e.getName().equals(name))
                return e;
        }
        return null;
    }

    //TODO: test
    /**
     * the monthly tasks for the business ran automatically
     * @param p player
     * @return the monthly business statement
     */
    public String runBusiness(Player p) {
        message = "";
        Business business = p.getBusiness();
        double proceeds = business.workEmployees(p);
        double payroll = business.payEmployee();
        profit = proceeds - payroll;
        if(profit > 0)
            message += "You made $" + profit + " this month.\n";
        else
            message += "You lost $" + profit + " this month.\n";
        message += "You made $" + proceeds + " in gross profit and paid your employees $" + payroll + " in total.\n";

        return message;
    }

    /**
     * ask for funding from investors, check for triggered events, return amount
     * @param p the player
     * @return the message for funding
     */
    public String getFunding(Player p) {
        message = "You ask investors for funding.\n";
        Business business = p.getBusiness();
        double amount = business.attemptFunding(p);
        if(amount < 1) {
            message += "They refuse.\n";
            return message;
        }

        //possible triggered event "rejected funding"
        if(p.getSelfEsteem() > 80 && Event.isTriggered(Objects.requireNonNull(getEvent("REJECTED_FUNDING")))) {
            message += "They see you as arrogant and overconfident. They refuse.\n" +
                    "You were just sure of yourself, not overconfident or arrogant.\n" +
                    "Doubt enters your mind. Maybe you are too confident. Too demanding.\n" +
                    "Your self-esteem takes a hit.\n";
            Objects.requireNonNull(getEvent("REJECTED_FUNDING")).affected(p);
            return message;
        }

        //possible triggered event "reduced funding"
        else if(Event.isTriggered(Objects.requireNonNull(getEvent("REDUCED_FUNDING")))) {
            message += "The investors don't seem very fond of you--or women in general.\n" +
                    "They offer half as much as usual.\n";
            amount = amount/2;
        }

        else {
            message += "They agree.\n";
        }

        //remove excess decimals
        int trunc = (int)(amount * 100);
        amount = (double)(trunc)/100;

        message += "You receive $" + amount;

        business.changeBusinessFunds((int)amount);

        return message;
    }

    /**
     * firing an employee and the events that may occur
     * @param p the player
     * @param employee the fired employee
     * @return the message
     */
    public String fireEmployee(Player p, Employee employee) {
        message = "";
        p.getBusiness().fireEmployee(employee);
        message += "You fire " + employee.getName() + ".\n";
        if(employee.getGender().equals("male")) {

            //possible lost their cool event
            Event e = getEvent("LOST_THEIR_COOL");
            if(Event.isTriggered(e)) {
                message += "He screams at you and calls you a dumb whore.\n";
                if(p.getSelfEsteem() > 65)
                    message += "You are not effected. You know he is just upset and lashing out.\n";
                else
                    message += "You are not confident enough to brush off his words. Your self esteem takes a hit.\n";
                e.affected(p);
            }

            //possible rumored affair event
            Event e2 = getEvent("RUMORED_AFFAIR");
            if(Math.abs(p.getAge() - employee.getAge()) < 6) {
                if(Event.isTriggered(e2)) {
                    message += "As he leaves, he tells the other employees it's because you both had an affair" +
                               "that ended bad.\n";
                    if(p.getSelfEsteem() > 60) { //if you are confident enough to try say he's a liar
                        message += "You attempt to dispel the rumors ";
                        if(p.getRespect() > 50)
                            message += "and your employees believe you.\n";
                        else {
                            message += "but your employees don't believe you. They begin to think you're a whore.\n";
                            e2.affected(p);
                        }
                    }//close confident
                    else {
                        message += "You are too scared to say anything ";
                        if (p.getRespect() > 50) {
                            message += "but your employees trust you. They don't believe him.\n";
                        }
                        else {
                            message += "and your employees take this as confirmation. They begin to think you're a slut." +
                                    "\n";
                            e2.affected(p);
                        }
                    }
                }
            }

        }



        return message;
    }

}
