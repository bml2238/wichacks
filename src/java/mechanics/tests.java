package mechanics;

import gameplay.Game;

import java.util.Scanner;

public class tests {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Game game = new Game();

        //name, income, money, age, reputation, self esteem
        Player woman = new Player("Woman", 10, 500);
        System.out.println(game.displayPlayerStats(woman));
        System.out.println(game.displayBusinessStats(woman));


    }
}
