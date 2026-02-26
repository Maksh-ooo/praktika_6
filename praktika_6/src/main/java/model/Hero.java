package model;

public class Hero extends GameCharacter {

    private int level;
    private String raceName;
    private String className;

    public Hero(String name,String race,String clazz,
                int hp,int ac,
                java.util.Map<String,Integer> stats,
                java.util.List<String> skills,
                java.util.List<String> equipment){

        this.name=name;
        this.raceName=race;
        this.className=clazz;
        this.hitPoints=hp;
        this.armorClass=ac;
        this.stats=stats;
        this.skills=skills;
        this.equipment=equipment;
        this.level=1;
    }

    @Override
    public String getIndex() {
        return name;
    }

    @Override
    public String toString() {
        return """
        ===== HERO =====
        Name: %s
        Race: %s
        Class: %s
        HP: %d
        AC: %d
        Stats: %s
        Skills: %s
        Equipment: %s
        """.formatted(
                name,raceName,className,
                hitPoints,armorClass,
                stats,skills,equipment);
    }
}