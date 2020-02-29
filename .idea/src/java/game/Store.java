package game;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class Store {

    private int effect;
    // just random set to help determine effect on player
    private HashMap<String, Integer> clothing = new HashMap<>();
    private Random random;

    public void setClothing(HashSet<String> clothing) { // need to differentiate between which is which i guess
        for (String clothes : clothing){
            this.clothing.put(clothes, (int) Math.random());
        }
    }

}
