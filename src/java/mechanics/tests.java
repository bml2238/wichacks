package mechanics;

import gameplay.Game;

import java.util.Scanner;

public class tests {
    public static void main(String[] args) {
        //name, income, money, age, reputation, self esteem
        Player woman = new Player("Woman", 10, 500);

        Game game = new Game(woman);

        System.out.println(game.displayPlayerStats(woman));
        System.out.println(game.displayBusinessStats(woman));
        System.out.println(game.getFunding(woman));


    }
}
