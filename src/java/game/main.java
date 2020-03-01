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
        int time = 0;
        Scanner scan = new Scanner(System.in);

        /** Mechanics */
        Item item = new Item();
        Player player = new Player();
        Store store = new Store();
        Game game = new Game(player);

        ArrayList<Event> events = Event.createEvents(player); //remember to check events.txt for when they trigger!

        time = game.passTime();
        if (player.getProperty() == "Condo" || player.getProperty() == "Apartment") {

        }





    }
}
