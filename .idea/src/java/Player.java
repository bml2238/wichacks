/**
 * Player class, with all stats and methods to edit stats
 */
public class Player {

    /** player variables */
    private String name;
    private int selfEsteem; //0-100
    private double income;
    private double age;
    private int reputation; //0-100
    private double money;

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

    /** changes self esteem +/- amount */
    private void changeSelfEsteem(int amount) { this.selfEsteem += amount; }

    /** changes reputation +/- amount */
    private void changeReputation(int amount) { this.reputation += amount; }

    /** raises/lowers player income by percent */
    public void raise(double percent) { this.income *= percent; }

    public void purchase(Item item) {
        this.reputation += item.repEffect;
    }

    public boolean isConfidentEnough(int level) {
        return false;
    }


}
