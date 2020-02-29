/**
 * Player class, with all stats and methods to edit stats
 */
public class Player {

    /** player variables */
    private String name;
    private int selfEsteem;
    private double income;
    private double age;
    private int repuation;
    private double money;

    /** categories */
/*    public enum Race {WHITE, BLACK, ASIAN, HISPANIC}
    public enum Orientation {STRAIGHT, GAY}
    public enum Class{LOWER, MIDDLE, UPPER}*/

    public Race race = null;
    private Orientation orien;
    private Class econ; // "economic status" cause class doesn't work

    public Player() {

    }

    public void setRace(Race race) {
        this.race = race;
        this.income = 0;
        this.orien = null;
    }
}
