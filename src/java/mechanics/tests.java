package mechanics;

import gameplay.BusinessActions;
import gameplay.Game;

import java.util.Scanner;

public class tests {
    public static void main(String[] args) {
        //name, income, money, age, reputation, self esteem
        Player woman = new Player("Woman", 10, 500);
        Business business = woman.getBusiness();

        Game game = new Game(woman);
        BusinessActions ba = new BusinessActions(woman);

   //     System.out.println(game.displayPlayerStats(woman));
 //       System.out.println(ba.displayBusinessStats(woman));
     //   System.out.println(ba.getFunding(woman));

        Employee joe = new Employee("Joe", "male", "nothing", 2);
        business.hireEmployee(joe);
        System.out.println(ba.fireEmployee(woman, joe));

    }
}
