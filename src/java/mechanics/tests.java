package mechanics;

import gameplay.Game;

import java.util.Scanner;

public class tests {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //name, income, money, age, reputation, self esteem
        Player woman = new Player("Woman", 10, 500);

        Game game = new Game(woman);



    }
}
