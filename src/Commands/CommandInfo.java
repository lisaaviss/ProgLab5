package Commands;

import Elements.Movie;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Класс вывода информации по коллекции
 * @author Артём
 */
public class CommandInfo extends Command {
    public static void action(ArrayList<Movie> list, LocalDateTime time_create){
        System.out.println("Тип: " + list.getClass().getName());
        System.out.println("Время инициализации: " + time_create);
        System.out.println("Количество элементов: " + list.size());
    }
}
