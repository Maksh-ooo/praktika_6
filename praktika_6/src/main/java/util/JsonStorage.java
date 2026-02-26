package util;

import com.google.gson.*;
import java.io.*;

public class JsonStorage<T> {

    private final Gson gson =
            new GsonBuilder().setPrettyPrinting().create();

    public void save(T obj,String file)throws IOException{
        try(FileWriter w=new FileWriter(file)){
            gson.toJson(obj,w);
        }
    }

    public T load(String file,Class<T> type)throws IOException{
        try(FileReader r=new FileReader(file)){
            return gson.fromJson(r,type);
        }
    }
}
