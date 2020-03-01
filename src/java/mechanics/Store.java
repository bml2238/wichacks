package mechanics;

import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;

public class Store {
    private Player player;
    private Business business;
    private Item item;

    public enum typeOfItem {
        CLOTHING,
        MAKEUP,
        MENSTRUALPRODUCT,
        HOUSE;
    }

    private HashMap<String, Item> storeItems = new HashMap<String, Item>();

    public void displayItems(){
        // display items in store based on what they're looking for
        HashSet<Item> storeItem = new HashSet<>();
        for (String s : storeItems.keySet()){
//            storeItem.add(storeItems.get(s));
            System.out.println(s);
        }
    }

    public void getItem(){
        // store items in shopping cart for when they go to purchase it
        // calling purchase item in the end
    }


    public void purchasePersonalItem(Item item){
        if (player.isConfidentEnough(item.selfEffect)){
            player.changeSelfEsteem(item.selfEffect);
        }
        else {
            player.changeSelfEsteem(-item.selfEffect);
            player.changeRespect(-item.repEffect);
        }
        player.changeMoney(-item.price);
    }

    public void purchaseItemForBusiness (Item item){
        if (player.getRespect() > item.repEffect){
            player.changeRespect(item.repEffect);
        }
        else {
            player.changeRespect(-item.repEffect);
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
