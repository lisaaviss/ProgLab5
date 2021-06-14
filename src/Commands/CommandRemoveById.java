package Commands;

import Elements.Movie;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.SortedSet;

/**
 * Класс enum с удалением элемента из коллекции по его id
 * @author Артём
 */
public class CommandRemoveById extends Command {
    public static Movie remove_by_id(ArrayList<Movie> lI, int id) {
        Iterator value = lI.iterator();
        Movie a = null;
        while (value.hasNext()) {
            Movie chek = (Movie) value.next();
            if (chek.getId() == id) {
                a = chek;
                break;
            }
        }
        return a;
    }
    public static void action(String[] comand, ArrayList<Movie> list, Movie obj, SortedSet<Integer> all_id){
        if (comand.length == 2) {
            try {
                if (Integer.parseInt(comand[1]) > 0) {
                    obj = remove_by_id(list, Integer.parseInt(comand[1]));
                    if (obj != null) {
                        list.remove(obj);
                        all_id.remove(Integer.parseInt(comand[1]));
                    } else {
                        System.out.println("Элемента с таким id не найдено.");
                    }
                } else {
                    System.out.println("Число должно быть положительным.");
                }
            } catch (NumberFormatException e) {
                System.out.println("В качестве аргумента введите целое положительное число.");
            }
        } else {
            System.out.println("В качестве аргумента введите целое положительное число.");
        }

    }
}
