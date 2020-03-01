package gameplay;

import mechanics.Business;
import mechanics.Player;

import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.Objects;

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
                         "You have $" + p.getMoney() + " in the bank.\n";

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


    /** searches through events and returns the requested event */
    private Event getEvent(String name) {
        for(Event e : events) {
            if(e.getName().equals(name))
                return e;
        }
        return null;
    }

}
