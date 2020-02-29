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
    }
}
