package game;
import java.util.HashMap;

import java.util.HashMap;

public class Item {
    /** item stat effects */
    public int selfEffect; //self esteem
    public int resEffect;  //respect effect  
    public int price;
    public int exp; //business exp

    private HashMap<String, Object> clothing = new HashMap<String, Object>();
    private HashMap<String, Object> makeup = new HashMap<String, Object>();
    //private HashMap<String, Integer, Integer> medicine = new HashMap<>(); optional
    private HashMap<String, Object> menstrualProducts = new HashMap<String, Object>();
    private HashMap<String, Object> house = new HashMap<String, Object>();

    public Item() {
        this.selfEffect = 0;
        this.repEffect = 0;
        this.price = 0;
        this.exp = 0;
    }

    public Item(int selfEffect, int repEffect, int price) {
        this.selfEffect = selfEffect;
        this.repEffect = repEffect;
        this.price = price;
    }

    public void setClothingStats(HashMap<String, Integer> clothing){
    {

    }
    public void setClothingStats(HashMap<String, Integer> clothing) {

    }

    public void setMakeupStats(HashMap<String, Integer> makeup){

    }

    public void setClothingStats(HashMap<String, Object> clothing)
    {
        clothing.put("Dress", Item(0,0,0));
        clothing.put("Revealing Dress", 0, 0, 0))
        clothing.put("Skin Tight Pink Body Suit", Item(100, 100, 29.99)); //Ultimate respect and ultimate self confidence
        clothing.put("High Heels", Item(5, 5, 50));
        clothing.put("Gucci Belt", Item(0, 20, 650));
    }

    public void setMakeupStats(HashMap<String, Object> makeup)
    {
        makeup.put("Red Hot Lipstick", Item(10, 10, 5)); //makes guys fall in love with you
    }

    /*public void setMedicineStats(HashMap<String, Object> medicine)
    {
    }*/

    public void setMenstrualProductsStats(HashMap<String, Object> menstrualProducts)
    {
        menstrualProducts.put("Tampon", (0, 0, 10)); //will run out after 3 months of use
        menstrualProducts.put("Mentrual Pads", Item(-1, -1, 5)); //will run out after 3 months of use
    }

    public void setHouseStats(HashMap<String, Object> house)
    {
        house.put("Studio", Item(0, 0, Math.random() * 1000 + 600));
        house.put("Apartment", Items(0, 0, Math.random() * 1200 + 850));
        house.put("Condo", Items(0, 0, Math.random() * 250000 + 100000 ));
        house.put("House" Item(0, 0, Math.random() * 500000 + 200000));
        house.put("Mansion", Item(100, 100, Math.random() * 5000000 + 1000000));
    }
}
