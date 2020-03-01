package mechanics;


import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;

public class Store {
    private Player player;
    private Business business;
    private Item item;
    private HashMap<String, Item> storeItems = new HashMap<String, Item>();
    private ArrayList<Item> storeItem = new ArrayList<Item>();

    public enum typeOfItem {
        CLOTHING,
        MAKEUP,
        MENSTRUALPRODUCT,
        HOUSE;
    }

    public void displayItems(){
        // display items in store based on what they're looking for
        for (String s : storeItems.keySet()){
            System.out.println(s);
        }
    }

    @Override
    public String toString(){
        return "Price" + item.price + "Self Effect: " + item.selfEffect + "Respect Effect: " + item.resEffect
                + "Business Experience" + item.exp;
    }

    public void getItem(){
        // store items in shopping cart for when they go to purchase it
        // calling purchase item in the end
        for (String s: storeItems.keySet()){
            storeItem.add(storeItems.get(s));
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

//    public void upgradeHouse(){
//        Item house = null;
//        int selfEsteem = player.changeSelfEsteem(house.selfEffect);
//        if (player.getRespect() % business.getLevel() == 0){
//            house.setHouseStats("house", player.changeSelfEsteem(house.selfEffect * 5),
//                    player.changeRespect(house.repEffect * 2));
//
//        }
//
//    }

}
