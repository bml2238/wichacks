package mechanics;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.lang.reflect.Array;
import java.util.*;

public class Store {
    private Player player;
    private Business business;
    private Item item;
    private ArrayList<Item> storeItems = new ArrayList<>();

    public ArrayList<Item> addItems(){
        ArrayList<Item> items = new ArrayList<>();
        for (Item item : storeItems){
            items.add(item);
        }
        return items;
    }

    public void displayItems(){
        for (Item item: storeItems){
            System.out.println(item);
        }
    }

    public void goShopping(){
        ArrayList<Item> shoppingCart = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        displayItems();
        System.out.println("Going to the store ... ");
        System.out.println("What items would you like to buy?");
        String item = sc.nextLine();
        while (true) {
  //          shoppingCart.add(storeItems.get(item)); //FOR TESTING ONLY
            System.out.println("Would you like to buy another item? (y/n)");
            String input = sc.nextLine();
            if (input.toLowerCase().equals("n")){
                break;
            }
        }
        for (Item value : shoppingCart) {
            purchasePersonalItem(value);
        }
        System.out.println("Purchase done! Have a good day\n");
    }

    /** a copy of goShopping() where the desired items are finite */
    public void goFiniteShopping(ArrayList<Item> items){
        for (Item item : items){
            purchasePersonalItem(item);
        }
    }

    public void purchasePersonalItem(Item item){
        if (player.isConfidentEnough(item.selfEffect)){
            player.changeSelfEsteem(item.selfEffect);
        }
        else {
            player.changeSelfEsteem(-item.selfEffect);
            player.changeRespect(-item.resEffect);
        }
        player.changeMoney(-item.price);
    }

    public void purchaseItemForBusiness (Item item){
        if (player.getRespect() > item.resEffect){
            player.changeRespect(item.resEffect);
        }
        else {
            player.changeRespect(-item.resEffect);
        }
        business.changeBusinessFunds(-item.price);
    }

    /** whether or not you can upgrade the house */
    public boolean upgradeHouse(String property){
        if (business.getLevel() >= 25 && business.getLevel() < 75){
            player.changeProperty(property);
            return true;
        }
        else {
            return false;
        }
    }

}
