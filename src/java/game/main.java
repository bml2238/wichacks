package game;

import gameplay.Event;
import gameplay.Game;
import mechanics.Store;

import java.util.ArrayList;
import java.util.Scanner;

/**the main class to run the game*/
public class main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        ArrayList<Event> events = Event.createEvents(); //remember to check events.txt for when they trigger!
        Game game = new Game();
        int monthsPassed;

        Store store = new Store();



    }
}
