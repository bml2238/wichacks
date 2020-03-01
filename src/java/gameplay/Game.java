package gameplay;

import mechanics.Business;
import mechanics.Player;

import java.io.BufferedWriter;
import java.util.ArrayList;

/** this is for repeated actions in the game */
public class Game {
    private String message = "";
    private double profit = 0;

    ArrayList<Event> events = Event.createEvents();

    public Game() {}

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

    public String displayBusinessStats(Player p) {
        message = "";
        ArrayList<String> stats = p.getBusiness().viewBusiness();
        for(String stat : stats)
            System.out.println(stat);

        return message;
    }

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

    public String getFunding(Player p) {
        message = "You ask investors for funding.\n";
        Business business = p.getBusiness();
        double amount = business.attemptFunding(p);
        if(amount > 0) {
            message += "They refuse.\n";
            return message;
        }
        if(p.getSelfEsteem() > 80 && Event.isTriggered(events.get(REJECTED_FUNDING))


        return message;
    }
}
