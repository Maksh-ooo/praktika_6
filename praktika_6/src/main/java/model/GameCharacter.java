package model;

import java.util.*;

public abstract class GameCharacter implements Entity {

    protected String name;
    protected Map<String, Integer> stats = new HashMap<>();
    protected List<String> skills = new ArrayList<>();
    protected List<String> equipment = new LinkedList<>();

    protected int hitPoints;
    protected int armorClass;

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public Map<String,Integer> getStats(){
        return stats;
    }
}