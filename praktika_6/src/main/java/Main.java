import generator.HeroGenerator;
import model.Hero;
import combat.*;
import util.JsonStorage;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        HeroGenerator gen=new HeroGenerator();
        Hero hero=gen.generate();

        System.out.println(hero);

        new JsonStorage<Hero>()
                .save(hero,"hero.json");

        Scanner sc=new Scanner(System.in);
        System.out.println("Start battle? y/n");

        if(!sc.nextLine().equalsIgnoreCase("y"))
            return;

        HeroCombatant hc=
                new HeroCombatant(hero);

        // тестовый монстр
        model.Monster m=new model.Monster();
        m.setName("Goblin");
        m.setHitPoints(30);
        m.setArmorClass(12);
        m.setDamageDice("2d6");

        MonsterCombatant mc=
                new MonsterCombatant(m);

        CombatLog<Combatant> log=
                new CombatLog<>();

        new BattleSimulator()
                .fight(hc,mc,log);

        log.saveToFile("battle_log.txt");
    }
}
