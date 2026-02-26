package combat;

import java.nio.file.*;
import java.io.*;
import java.util.*;

public class CombatLog<T extends Combatant>{

    private final List<String> entries=new ArrayList<>();

    public void log(String m){
        entries.add(m);
        System.out.println(m);
    }

    public void saveToFile(String file)throws IOException{
        Files.write(Path.of(file),entries);
    }
}
