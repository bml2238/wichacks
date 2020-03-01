package game;

import gameplay.Event;
import gameplay.Game;
import gameplay.Roadblock;
import gameplay.IntervalRoadBlock;
import mechanics.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**the main class to run the game*/
public class main {
    public static Scanner scan;

    public static void main(String[] args) {
        /** Mechanics */
        Item item = new Item();
        Player player = new Player();
        Store store = new Store();
        Game game = new Game(player);


        int time = 0;
        int death = 85 * 12;
        int year = 2000;
        int yearInc = 5;
        String month;
        scan = new Scanner(System.in);
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

        while (time != death) {
            /** Time counter */
            time = game.passTime();
            if (yearInc % 12 == 0) {
                month = "December";
            } else if (yearInc % 11 == 0) {
                month = "November";
            } else if (yearInc % 10 == 0) {
                month = "October";
            } else if (yearInc % 9 == 0) {
                month = "September";
            } else if (yearInc % 8 == 0) {
                month = "August";
            } else if (yearInc % 7 == 0) {
                month = "July";
            } else if (yearInc % 6 == 0) {
                month = "June";
            } else if (yearInc % 5 == 0) {
                month = "May";
            } else if (yearInc % 4 == 0) {
                month = "April";
            } else if (yearInc % 3 == 0) {
                month = "March";
            } else if (yearInc % 2 == 0) {
                month = "February";
            } else {
                month = "January";
            }
            System.out.println("Day: " + month + " " + year);
            yearInc += 1;
            if (month.equals("December")) {
                year += 1;
                yearInc = 1;
            }

            System.out.println("What do you want to do? (Shop, Business): ");
            String action = scan.nextLine();
            //checkAction(action)

            if (action.toLowerCase().equals("shop")) {
                store.goShopping();
            }




            /** if player has a condo or apartment, every month, they will charge a fee */
            if (player.getProperty() == "Condo" || player.getProperty() == "Apartment") {
                Random random = new Random();
                int rent = random.nextInt(1000);
                System.out.println("Player money: " +player.getMoney());
                System.out.println("Time to pay rent, you owe: " + rent);
                player.changeMoney(-rent);
                System.out.println("Player money: " + player.getMoney());
            }

            /** after a certain time has passed, then your status will chance */
            if (time == 228) {
            }
        }
        System.out.println("You lived a life, and then you died.");


    }

    public void checkAction(String action) throws FileNotFoundException {
        if (action.toLowerCase().equals("business")) {
            Business business = new Business(Business.Type.TECHNOLOGY);
            Employee employee = new Employee();
//            String employees = business.buildAllPossibleEmployees();
            System.out.println("View Business \n Work Month \n View Employees \n Hire Employees \nGo for Business Deal");
            if (scan.nextLine().toLowerCase().equals("View Business")) {
                business.viewBusiness();
            }
            if (scan.nextLine().toLowerCase().equals("Work Month")) {

            }
            if (scan.nextLine().toLowerCase().equals("View Employees")) {

            }
            if (scan.nextLine().toLowerCase().equals("Hire Employees")) {
                business.lookAtHires();
                System.out.println("Which employee would you like to hire? ");
                String name = scan.nextLine();

            }
            if (scan.nextLine().equals("Go for Business Deal")) {

            }
        }
    }
}
