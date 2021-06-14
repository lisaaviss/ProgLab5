package Commands;

import Elements.Movie;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Класс, который выводит коллекцию
 * @author Артём
 */
public class CommandShow extends Command{
    private static void objpols(Movie o) {
        System.out.println("id: " + o.getId().toString());
        System.out.println("name: " + o.getName());
        System.out.println("coordinates: X: " + o.getCoordinates().getX() + " Y: " + o.getCoordinates().getY());
        System.out.println("creationDate: " + o.getCreationDate().toString());
        System.out.println("OscarsCount: " + o.getOscarsCount());
        System.out.println("totalBoxOffice: " + o.getTotalBoxOffice());
        System.out.println("genre: " + o.getGenre());
        System.out.println("mpaarating: " + o.getMpaaRating());
        System.out.println("Screenwriter's name: " + o.getScreenwriter().getName() + ", Screenwriter's height: " + o.getScreenwriter().getHeight() + ", Screenwriter's eyecolor: " + o.getScreenwriter().getEyeColor() + ", Screenwriter's haircolor: " + o.getScreenwriter().getHairColor() + ", Screenwriter's nationality: " + o.getScreenwriter().getNationality());

    }
    public static void show(ArrayList<Movie> lI) {
        Iterator value = lI.iterator();
        if (lI.size() != 0) {
            while (value.hasNext()) {
                objpols((Movie) value.next());
            }
        } else {
            System.out.println("Колекция пуста.");
        }
    }
public static void action(ArrayList<Movie> list){
    CommandShow.show(list);
}
}
