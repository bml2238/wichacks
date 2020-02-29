package game;

import java.util.HashMap;

public class Item {
    /** item stat effects */
    public int selfEffect; //self esteem
    public int repEffect;  //reputation effect
    public int price;
    public int exp; //business exp

    private HashMap<String, Integer> clothing = new HashMap<>();
    private HashMap<String, Integer> makeup = new HashMap<>();
    //private HashMap<String, Integer, Integer> medicine = new HashMap<>(); optional
    private HashMap<String, Integer> menstrualProducts = new HashMap<>();
    private HashMap<String, Integer> house = new HashMap<>();

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

    public void setClothingStats(HashMap<String\> clothing)
    {

    }

    public void setMakeupStats(HashMap<String> makeup)
    {

    }

    public void setMedicineStats(HashMap<String> medicine)
    {

    }

    public void setMenstrualProductsStats(HashMap<String> menstrualProducts)
    {

    }

    public void setHouseStats(HashMap<String> house)
    {

    }
}
