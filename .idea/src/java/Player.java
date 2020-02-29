public class Player {

    /** player variables */
    private String name;
    private int selfEsteem;
    private double income;
    private double age;
    private int repuation;
    private double money;
    public Race race;
    public Orientation orien;
    public Class econ; // "economic status" cause class doesn't work

    /** categories */
    public enum Race {WHITE, BLACK, ASIAN, HISPANIC}
    public enum Orientation {STRAIGHT, GAY}
    public enum Class{LOWER, MIDDLE, UPPER}

    /** initialize player */
    public Player() {
        race = Race.WHITE;

    }


}
