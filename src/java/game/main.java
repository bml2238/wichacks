package game;

import gameplay.Event;
import gameplay.Game;
import gameplay.Roadblock;
import gameplay.IntervalRoadBlock;
import mechanics.Item;
import mechanics.Player;
import mechanics.Store;

import java.util.ArrayList;
import java.util.Scanner;

/**the main class to run the game*/
public class main {
    public static void main(String[] args) {
        /** Mechanics */
        Item item = new Item();
        Player player = new Player();
        Store store = new Store();
        Game game = new Game(player);

        int time = 0;
        Scanner scan = new Scanner(System.in);
        System.out.print("What is your name? ");
        String name = scan.nextLine();

        System.out.println("----------------------------------------------------" + "\n" +
                          "| Rochester Institute of Technology                 |" + "\n" +
                          "|                                                   |" + "\n" +
                          "| by authority of the Board of Trustees and on the  |" + "\n" +
                          "| recommendation of the Faculty hereby confers upon |" + "\n" +
                          "| RIT GRADUATE                                      |" + "\n" +
                          "| A degree                                          |" + "\n" +
                          "|                                                   |" + "\n" +
                          "| Congratulations,                                  |" + "\n" +
                          "| " + name + "\n" +
                          "-----------------------------------------------------");
        ArrayList<Event> events = Event.createEvents(player); //remember to check events.txt for when they trigger!

        time = game.passTime();

        /** if player has a condo or apartment, every month, they will charge a fee */
        if (player.getProperty() == "Condo" || player.getProperty() == "Apartment") {
        }

        /** after a certain time has passed, then your status will chance */
        if (time == 228) {
        }






    }
}
