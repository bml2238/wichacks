package game;

public class Item {
    /** item stat effects */
    public int selfEffect; //self esteem
    public int repEffect;  //reputation effect
    public int price;
    public int exp; //business exp

    private HashMap<String, Integer, Integer> clothing = new HashMap<>();
    private HashMap<String, Integer, Integer> makeup = new HashMap<>();
    //private HashMap<String, Integer, Integer> medicine = new HashMap<>(); optional
    private HashMap<String, Integer, Integer> menstrualProducts = new HashMap<>();
    private HashMap<String, Integer, Integer> house = new HashMap<>();

    public Item() {
        this.selfEffect = 0;
        this.repEffect = 0;
        this.price = 0;
        this.exp = 0;
    }

    public void setClothingStats(HashMap<String, Integer, Integer> clothing)
    {
        
    }

    public void setMakeupStats(HashMap<String, Integer, Integer> makeup)
    {

    }

    public void setMedicineStats(HashMap<String, Integer, Integer> medicine)
    {

    }

    public void setMenstrualProductsStats(HashMap<String, Integer, Integer> menstrualProducts)
    {

    }

    public void setHouseStats(HashMap<String, Integer, Integer> house)
    {

    }
}
