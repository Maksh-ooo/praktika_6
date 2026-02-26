package model;

import java.util.Map;

public class Monster implements Entity {

    private String name;
    private String index;
    public double challengeRating;
    public int hitPoints;
    public int armorClass;
    public Map<String,Integer> stats;
    public String damageDice;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getIndex() {
        return index;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHitPoints(int hp) {
        this.hitPoints = hp;
    }

    public void setArmorClass(int ac) {
        this.armorClass = ac;
    }

    public void setDamageDice(String dice) {
        this.damageDice = dice;
    }
}