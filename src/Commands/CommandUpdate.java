package Commands;

import Elements.Movie;

import java.util.ArrayList;

/**
 * Класс обновления значения id элемента коллекции
 * @author Артём
 */

public class CommandUpdate extends Command{
    public static void action(String[] comand, ArrayList<Movie> list, Movie obj){
        if (comand.length == 2) {
            try {
                if (Integer.parseInt(comand[1]) > 0) {
                    obj = CommandRemoveById.remove_by_id(list, Integer.parseInt(comand[1]));
                    if (obj != null) {
                        list.remove(obj);
                        list.add(CommandAdd.make_element(Integer.parseInt(comand[1])));
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
