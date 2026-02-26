package combat;

import model.Hero;
import util.Dice;

public class HeroCombatant implements Combatant {

    private Hero hero;
    private int hp;

    public HeroCombatant(Hero hero){
        this.hero=hero;
        this.hp=hero.getHitPoints();
    }

    public String getName(){return hero.getName();}
    public int getCurrentHp(){return hp;}
    public int getArmorClass(){return hero.getArmorClass();}
    public boolean isAlive(){return hp>0;}

    public int rollAttack(){
        return Dice.roll(20);
    }

    public int rollDamage(){
        return Dice.roll(8);
    }

    public void damage(int dmg){
        hp -= dmg;
    }
}