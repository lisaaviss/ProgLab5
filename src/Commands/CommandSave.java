package Commands;

import Elements.Movie;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Класс сохранения коллекции в файл
 * @author Артём
 */
public class CommandSave extends  Command{
    public static void action(ArrayList<Movie> list, Gson g){
        try {
            FileWriter fw = new FileWriter("/home/s307470/oop.json");
            fw.write(g.toJson(list));
            fw.close();
        } catch (IOException e) {
            System.out.println("Файл не найден");
        }
    }
}
