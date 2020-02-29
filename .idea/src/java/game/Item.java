package game;

public class Item {
    /** item stat effects */
    public int selfEffect; //self esteem
    public int repEffect;  //reputation effect
    public int price;
    public int exp; //business exp

    private HashMap<String, Integer> clothing = new HashMap<>();
    
    public Item() {
        this.selfEffect = 0;
        this.repEffect = 0;
        this.price = 0;
        this.exp = 0;
    }

}
