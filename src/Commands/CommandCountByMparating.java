package Commands;

import Elements.Movie;
import Elements.MpaaRating;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Класс подсчета количества фильмов с опрделенным ограничением по возрасту
 * @author Артём
 */
public class CommandCountByMparating extends Command{
    public static void count_by_mpaa_rating(ArrayList<Movie> lI){
        Scanner in = new Scanner(System.in);
        MpaaRating mpaaRating;
        while (true) {
            System.out.print("category (G, PG, R, NC_17): ");
            try {
                mpaaRating = MpaaRating.valueOf(in.nextLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Введите значение из списка.");
            }
        }
        Iterator value = lI.iterator();
        int i = 0;
        while (value.hasNext()) {
            if (((Movie) value.next()).getMpaaRating().equals(mpaaRating)){
                i++;
            }
        }
        System.out.println(i);
    }
    public static void action(ArrayList<Movie> list){

        count_by_mpaa_rating(list);
    }
}
