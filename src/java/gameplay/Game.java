package gameplay;

import mechanics.Business;
import mechanics.Player;

import java.io.BufferedWriter;
import java.util.ArrayList;

/** this is for repeated actions in the game */
public class Game {
    private String message = "";
    private double profit = 0;
    Player player;

    public Game(Player player) { this.player = player; }

    ArrayList<Event> events = Event.createEvents(this.player);

    /**
     * generates a string of the player's stats
     * @param p the player
     * @return the stats
     */
    public String displayPlayerStats(Player p) {
        message = "";
        message += "Your name is " + p.getName() + " and you are " + p.getAge() + " years old.\n" +
                         "You make $" + profit + " a month and have $" + p.getMoney() + " in the bank.\n";

        //RESPECT MESSAGE
        if(p.getRespect() < 25)
            message += "You are not well respected. You will not be treated well.\n";
        else if(25 <= p.getRespect() && p.getRespect() < 75)
            message += "People are neutral with you, not really respecting or disrespecting you.\n";
        else
            message += "You are very well respected. You will be treated well because of this\n";

        //SELF ESTEEM MESSAGE
        if(p.getSelfEsteem() < 25)
            message += "You are very insecure. People will notice and may take advantage of you.\n";
        else if(25 <= p.getSelfEsteem() && p.getSelfEsteem() < 75)
            message += "You feel fine about yourself.\n";
        else
            message += "You are very confident. This may get you places, or it may intimidate others.\n";

        return message;
    }

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
        return null; //it /shouldn't/ reach this, but whatever
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
        if(p.getSelfEsteem() > 80 && Event.isTriggered(getEvent("REJECTED_FUNDING"))) {
            message += "They see you as arrogant and overconfident. They refuse.\n" +
                        "You were just sure of yourself, not overconfident or arrogant.\n" +
                        "Doubt enters your mind. Maybe you are too confident. Too demanding.\n" +
                        "Your self-esteem takes a hit.\n";
            getEvent("REJECTED_FUNDING").affected(p);
            return message;
        }

        //possible triggered event "reduced funding"
        else if(Event.isTriggered(getEvent("REDUCED_FUNDING"))) {
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
}
