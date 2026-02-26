package combat;

public interface Combatant {

    String getName();
    int getCurrentHp();
    int getArmorClass();

    int rollAttack();
    int rollDamage();

    boolean isAlive();
}