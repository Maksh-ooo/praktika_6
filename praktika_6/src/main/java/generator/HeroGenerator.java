package generator;

import model.Hero;
import util.Dice;

import java.util.*;

public class HeroGenerator {

    private static final String[] NAMES={
            "Aldric","Luna","Kael","Rin","Doran",
            "Sylvia","Ragnar","Mira","Theron","Nyx",
            "Arin","Vex","Liora","Zane","Kira",
            "Orin","Talia","Drake","Elwin","Nero"
    };

    private int mod(int v){
        return (v-10)/2;
    }

    public Hero generate(){

        Map<String,Integer> stats=new HashMap<>();

        String[] keys={"STR","DEX","CON","INT","WIS","CHA"};

        for(String k:keys)
            stats.put(k, Dice.rollDropLowest(4,6));

        int hp=10+mod(stats.get("CON"));
        int ac=10+mod(stats.get("DEX"));

        return new Hero(
                Dice.pickRandom(Arrays.asList(NAMES)),
                "Human",
                "Fighter",
                hp,
                ac,
                stats,
                new ArrayList<>(List.of("Athletics","Survival","Perception")),
                new LinkedList<>(List.of("Sword","Shield"))
        );
    }
}
