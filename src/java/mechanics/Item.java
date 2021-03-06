package mechanics;
import java.util.HashMap;

public class Item {
    /** item stat effects */
    public int selfEffect; //self esteem
    public int resEffect;  //respect effect  
    public int price;
    public int exp; //business exp

    private HashMap<String, Object> clothing = new HashMap<>();
    private HashMap<String, Object> makeup = new HashMap<>();
    //private HashMap<String, Integer, Integer> medicine = new HashMap<>(); //optional
    private HashMap<String, Object> menstrualProducts = new HashMap<>();
    private HashMap<String, Object> house = new HashMap<>();

    public Item() {
        this.selfEffect = 0;
        this.resEffect = 0;
        this.price = 0;
        this.exp = 0;
    }

    @Override
    public String toString(){
        return "Price: " + this.price + "Self Effect: " + this.selfEffect + "Respect Effect: " + this.resEffect
                + "Business Experience: " + this.exp;
    }

    public Item(int selfEffect, int repEffect, int price) {
        this.selfEffect = selfEffect;
        this.resEffect = repEffect;
        this.price = price;
    }

    public void setClothingStats(HashMap<String, Object> clothing) {
        clothing.put("Dress", new Item(10, 10, 100));
        clothing.put("Revealing Dress", new Item(20, 0, 200));
        clothing.put("Skin Tight Pink Body Suit", new Item(100, 100, 30)); //Ultimate respect and ultimate self confidence
        clothing.put("Casual Formal Attire", new Item(10, 20, 100));
        clothing.put("Gucci Belt", new Item(0, 50, 650));
    }

    public void setMakeupStats(HashMap<String, Object> makeup)
    {
        makeup.put("Red Hot Lipstick", new Item(10, 10, 5)); //makes guys fall in love with you
    }

    /*public void setMedicineStats(HashMap<String, Object> medicine)
    {
    }*/

    public void setMenstrualProductsStats(HashMap<String, Object> menstrualProducts)
    {
        menstrualProducts.put("Menstrual Products", new Item(0, 0, 10)); //will run out after 3 months of use
    }

    public void setHouseStats(HashMap<String, Object> house)
    {
        house.put("Studio", new Item(0, 0, (int) (Math.random() * 1000) + 600));
        house.put("Apartment", new Item(0, 0, (int) (Math.random() * 1200) + 850));
        house.put("Condo", new Item(0, 0, (int) (Math.random() * 250000) + 100000 ));
        house.put("House", new Item(0, 0, (int) (Math.random() * 500000) + 200000));
        house.put("Mansion", new Item(100, 100, (int) (Math.random() * 5000000) + 1000000));
    }
}
