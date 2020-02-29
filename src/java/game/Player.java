package game;

/**
 * Player class, with all stats and methods to edit stats
 */
public class Player{

    /** player variables */
    private String name;
    private int selfEsteem; //0-100
    private double income;
    private double age;
    private int reputation; //0-100
    private double money;
    private Business business;

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
        this.reputation = 50;
        this.selfEsteem = 50;
    }

    public Player(String n, double income, double money) {
        this.name = n;
        this.income = income;
        this.money = money;
        this.age = 21;
        this.reputation = 50;
        this.selfEsteem = 50;
    }

    /** getters */
    public int getSelfEsteem() { return this.selfEsteem; }
    public int getReputation () { return this.reputation; }
    public double getIncome() { return this.income; }
    public double getMoney() { return this.money; }
    public double getAge() { return this.age; }
    public String getName() { return this.name; }

    /** changes self esteem +/- amount */
    public void changeSelfEsteem(int amount) { this.selfEsteem += amount; }

    /** changes reputation +/- amount */
    public void changeReputation(int amount) { this.reputation += amount; }

    public void changeMoney(int amount) {
        this.money += amount;
    }

    /** raises/lowers player income by percent */
    public void raise(double percent) { this.income *= percent; }

    public boolean isConfidentEnough(int level) {
        return reputation > level;
    }

}
