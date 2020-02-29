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

    public void setClothingStats(HashMap<String, Object> clothing)
    {
        clothing.push("Dress", Item);
    }

    public void setMakeupStats(HashMap<String, Object> makeup)
    {

    }

    public void setMedicineStats(HashMap<String, Object> medicine)
    {

    }

    public void setMenstrualProductsStats(HashMap<String, Object> menstrualProducts)
    {

    }

    public void setHouseStats(HashMap<String, Object> house)
    {

    }
}
