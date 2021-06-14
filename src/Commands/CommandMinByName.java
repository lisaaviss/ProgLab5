package Commands;

import Elements.Movie;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Класс выводящий самое маленькое значения поля name
 * @author Артём
 */
public class CommandMinByName extends Command{
    public static Movie min_by_name(ArrayList<Movie> lI){
        Iterator value = lI.iterator();
        Movie mname = (Movie) value.next();
        while (value.hasNext()){
            if (((Movie) value.next()).getName().length() < mname.getName().length()){
                mname = (Movie) value.next();
            }
        }
        return mname;
    }
    public static void action(ArrayList<Movie> list){
        CommandsExecution.objpols(min_by_name(list));
    }
}
