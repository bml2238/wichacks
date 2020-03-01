package gameplay;

import mechanics.Player;

import java.util.ArrayList;

/** this is for repeated actions in the game */
public class Game {
    private String singleMessage = "";
    private ArrayList<String> longMessage = new ArrayList<>();

    public Game() {}

    public String displayPlayerStats(Player p) {
        singleMessage = "";
        singleMessage += "Your name is " + p.getName() + " and you are " + p.getAge() + " years old.\n" +
                         "You make $" + p.getIncome() + " a month and have $" + p.getMoney() + " in the bank.\n";

        //RESPECT MESSAGE
        if(p.getRespect() < 25)
            singleMessage += "You are not well respected. You will not be treated well.\n";
        else if(25 <= p.getRespect() && p.getRespect() < 75)
            singleMessage += "People are neutral with you, not really respecting or disrespecting you.\n";
        else
            singleMessage += "You are very well respected. You will be treated well because of this\n";

        //SELF ESTEEM MESSAGE
        if(p.getSelfEsteem() < 25)
            singleMessage += "You are very insecure. People will notice and may take advantage of you.\n";
        else if(25 <= p.getSelfEsteem() && p.getSelfEsteem() < 75)
            singleMessage += "You feel fine about yourself.\n";
        else
            singleMessage += "You are very confident. This may get you places, or it may intimidate others.\n";

        return singleMessage;
    }

    public String displayBusinessStats(Player p) {
        singleMessage = "";
        ArrayList<String> stats = p.getBusiness().viewBusiness();
        for(String stat : stats)
            System.out.println(stat);

        return singleMessage;
    }
}
