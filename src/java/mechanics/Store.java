package mechanics;

<<<<<<< HEAD
=======

>>>>>>> 20540d4b8a9692bb8e2cfe259a78e64648314a3c
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Random;

public class Store {
    private Player player;
    private Business business;
    private Item item;
    private HashMap<String, Item> storeItems = new HashMap<String, Item>();

    public void displayItems(){
        // display items in store
        for (Item item : storeItems.values()){
            System.out.println(item);
        }
    }

    @Override
    public String toString(){
        return "Price" + item.price + "Self Effect: " + item.selfEffect + "Respect Effect: " + item.resEffect
                + "Business Experience" + item.exp;
    }

    public HashSet<Item> void addToShoppingCart(int itemsWanted, String item){
        // amount of items they're buying
        HashSet<Item> shoppingCart = new HashSet<>();
        while (shoppingCart.size() < itemsWanted){
            shoppingCart.add(storeItems.get(item);
        }
        while (shoppingCart.size() > 0) {
//            Item itemsInCart = shoppingCart.remove(item);
//            purchasePersonalItem(itemsInCart);
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
