package combat;

import util.Dice;

public class BattleSimulator {

    private int heroDamageTotal = 0;
    private int monsterDamageTotal = 0;

    public void fight(
            HeroCombatant hero,
            MonsterCombatant monster,
            CombatLog<?> log) throws Exception {

        int round = 1;

        while (hero.isAlive()
                && monster.isAlive()
                && round <= 50) {

            log.log("=== Раунд " + round + " ===");

            attack(hero, monster, log, true);

            if (monster.isAlive())
                attack(monster, hero, log, false);

            log.log("---");
            round++;
        }

        printResult(hero, monster, round - 1, log);
    }

    private void attack(
            Combatant attacker,
            Combatant defender,
            CombatLog<?> log,
            boolean heroTurn) {

        int attackRoll = Dice.roll(20);
        int ac = defender.getArmorClass();

        String result;

        if (attackRoll == 1) {
            result = "ПРОМАХ";
        }
        else if (attackRoll >= ac) {
            result = "ПОПАДАНИЕ";

            int damage = attacker.rollDamage();

            if (attackRoll == 20) {
                damage += attacker.rollDamage();
            }

            if (defender instanceof HeroCombatant h)
                h.damage(damage);

            if (defender instanceof MonsterCombatant m)
                m.damage(damage);

            if (heroTurn)
                heroDamageTotal += damage;
            else
                monsterDamageTotal += damage;

            log.log("[" + attacker.getName() + "] наносит "
                    + damage + " урона. HP противника: "
                    + Math.max(0, defender.getCurrentHp()));
        }
        else {
            result = "ПРОМАХ";
        }

        log.log("[" + attacker.getName()
                + "] бросает атаку: "
                + attackRoll
                + " | AC противника: "
                + ac
                + " → "
                + result);
    }

    private void printResult(
            Combatant hero,
            Combatant monster,
            int rounds,
            CombatLog<?> log) {

        String winner =
                hero.isAlive()
                        ? hero.getName()
                        : monster.getName();

        log.log("""

         ИТОГ СРАЖЕНИЯ
Победитель    : %s
Раундов       : %d
Урон (герой)  : %d
Урон (монстр) : %d

"""
                .formatted(
                        winner,
                        rounds,
                        heroDamageTotal,
                        monsterDamageTotal));
    }
}