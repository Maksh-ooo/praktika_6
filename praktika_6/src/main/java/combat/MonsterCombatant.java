package combat;

import model.Monster;
import util.Dice;

public class MonsterCombatant implements Combatant {

    private Monster monster;
    private int hp;

    public MonsterCombatant(Monster m){
        monster=m;
        hp=m.hitPoints;
    }

    public String getName(){return monster.getName();}
    public int getCurrentHp(){return hp;}
    public int getArmorClass(){return monster.armorClass;}
    public boolean isAlive(){return hp>0;}

    public int rollAttack(){
        return Dice.roll(20);
    }

    public int rollDamage(){

        String[] p=monster.damageDice.split("d");
        int count=Integer.parseInt(p[0]);
        int sides=Integer.parseInt(p[1]);

        int sum=0;
        for(int i=0;i<count;i++)
            sum+=Dice.roll(sides);

        return sum;
    }

    public void damage(int dmg){
        hp -= dmg;
    }
}
