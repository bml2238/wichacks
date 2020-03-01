package mechanics;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.*;

public class Store {
    private Player player;
    private Business business;
    private Item item;
    private HashMap<String, Item> storeItems = new HashMap<String, Item>();

    public ArrayList<Item> displayItems(){
        ArrayList<Item> items = new ArrayList<>();
        for (Item item : storeItems.values()){
            items.add(item);
        }
        return items;
    }

    public void goShopping(){
        HashMap<String, Item> shoppingCart = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        displayItems();
        System.out.println("What items would you like to buy?");
        String item = sc.nextLine();
        while (true){
            shoppingCart.put(item, storeItems.get(item));
            System.out.println("Would you like to buy another item? (y/n)");
            String input = sc.nextLine();
            if (input.toLowerCase().equals("n")){
                break;
            }
        }
        for (Item items : shoppingCart.values()){
            purchasePersonalItem(shoppingCart.get(items));
        }
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
