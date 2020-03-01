package mechanics;
import java.util.ArrayList;

/**
 * Player class, with all stats and methods to edit stats
 */
public class Player{

    /** player variables */
    private String name;
    private int selfEsteem; //0-100
    private double income;
    private double age;
    private int respect; //0-100
    private double money;
    private Business business;
    private ArrayList<String> inventory;

    /** categories */
/*    public enum Race {WHITE, BLACK, ASIAN, HISPANIC}
    public enum Orientation {STRAIGHT, GAY}
    public enum Class{LOWER, MIDDLE, UPPER}*/

//    public Race race = null;
//    private Orientation orien;
//    private Class econ; // "economic status" cause class doesn't work

    public Player() {
        this.name = "Woman";
        this.income = 0;
        this.money = 10000;
        this.age = 21;
        this.respect = 50;
        this.selfEsteem = 50;
        this.inventory = null;
    }

    public Player(String n, double income, double money) {
        this.name = n;
        this.income = income;
        this.money = money;
        this.age = 21;
        this.respect = 50;
        this.selfEsteem = 50;
        this.inventory = null;
        this.business = new Business();
    }

    /** getters */
    public int getSelfEsteem() { return this.selfEsteem; }
    public int getRespect() { return this.respect; }
    public double getIncome() { return this.income; }
    public double getMoney() { return this.money; }
    public double getAge() { return this.age; }
    public String getName() { return this.name; }
    public ArrayList<String> getInventory() { return this.inventory; }
    public Business getBusiness() { return this.business; }

    public void age() { this.age++; }

    /** changes self esteem +/- amount */
    public void changeSelfEsteem(int amount) { this.selfEsteem += amount; }

    /** changes reputation +/- amount */
    public void changeRespect(int amount) { this.respect += amount; }

    public void changeMoney(double amount) {
        this.money += amount;
    }

    private void changeReputation(int amount) { this.respect += amount; }

    /** raises/lowers player income by percent */
    public void raise(double percent) { this.income *= percent; }

    public void purchaseClothing(Item item) {
        if(this.isConfidentEnough(item.resEffect))
            this.respect += item.resEffect;
        else
            this.respect -= item.resEffect;
        this.selfEsteem += item.selfEffect;
        this.money -= item.price;
    }

    public boolean isConfidentEnough(int level) {
        return respect > level;
    }

    /** adds Item to the player's inventory */
    public void addItem(String item) {
        inventory.add(item);
    }
}
