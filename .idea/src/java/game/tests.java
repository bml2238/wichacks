package game;

import java.util.Scanner;

public class tests {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a name");

        String name = scan.next();

        //name, income, money, age, reputation, self esteem
        Player woman = new Player(name, 10, 500);

        System.out.println("Your name is " + woman.getName());
        System.out.println("Your self-esteem is " + woman.getSelfEsteem());

        Item shirt = new Item(20, 20, 50);

        System.out.println("There is a shirt that costs $" + shirt.price + ".");
        System.out.println("You must have at least 40 self-esteem to wear it comfortably");
        System.out.println("Will you buy it? true/false");

        boolean purchase = scan.nextBoolean();

    }
}
