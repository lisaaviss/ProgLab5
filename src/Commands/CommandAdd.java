package Commands;
/**
 * Класс для добавляения новых элементов коллекци
 * @author Артём
 */
import Elements.*;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.SortedSet;

public class CommandAdd extends Command {
    public static Movie make_element(int id) {

        ZonedDateTime creationDate = ZonedDateTime.now();
        Scanner in = new Scanner(System.in);

        String name;
        while (true) {
            System.out.print("name: ");
            name = in.nextLine();
            if (name.length() == 0) {
                System.out.println("Имя не может быть пустым.");
            } else {
                break;
            }
        }

        int x;
        while (true) {
            System.out.print("X: ");
            try {
                x = Integer.parseInt(in.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Введите целое число.");
            }
        }

        int y;
        while (true) {
            System.out.print("Y: ");
            try {
                y = Integer.parseInt(in.nextLine());
                if (y <= 92) {
                    break;
                } else {
                    System.out.println("Значение должно быть не больше 92.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Введите число.");
            }
        }

        int oscarsCount;
        while (true) {
            System.out.print("oscarsCount: ");
            try {
                oscarsCount = Integer.parseInt(in.nextLine());
                if (oscarsCount > 0) {
                    break;
                } else {
                    System.out.println("Число должно быть положительным.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Введите целое число.");
            }
        }

        Long totalBoxOffice;
        while (true) {
            System.out.print("totalBoxOffice: ");
            try {
                totalBoxOffice = Long.parseLong(in.nextLine());
                if (totalBoxOffice > 0) {
                    break;
                } else {
                    System.out.println("Значение должно положительным.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Введите число.");
            }
        }

        MovieGenre genre;
        String chek_null;
        while (true) {
            System.out.print("genre (WESTERN, DRAMA, THRILLER, HORROR, SCIENCE_FICTION, null - пустая строка): ");
            chek_null = in.nextLine();
            if (chek_null.length() == 0) {
                genre = null;
                break;
            } else {
                try {
                    genre = MovieGenre.valueOf(chek_null);
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("Введите значение из списка.");
                }
            }
        }

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
        System.out.print("Elements.Person name: ");
        String sname = in.nextLine();
        Person screenwriter = null;
        if (sname.length() > 0) {
            Integer height;
            while (true) {
                System.out.print("Elements.Person height: ");
                try {
                    chek_null = in.nextLine();
                    if (chek_null.length() == 0) {
                        height = null;
                    } else {
                        height = Integer.parseInt(chek_null);
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Введите целое число");
                }
            }

            Color eyeColor;
            while (true) {
                System.out.print("Elements.Person eyeColor (BLACK, BLUE, YELLOW, WHITE, BROWN): ");
                try {
                    chek_null = in.nextLine();
                    if (chek_null.length() == 0) {
                        eyeColor = null;
                    } else {
                        eyeColor = Color.valueOf(chek_null);
                    }
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("Введите значение из списка");
                }
            }
            Color hairColor;
            while (true) {
                System.out.print("Elements.Person hairColor (BLACK, BLUE, YELLOW, WHITE, BROWN): ");
                try {
                    hairColor = Color.valueOf(in.nextLine());
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("Введите значение из списка");
                }
            }
            Country nationality;
            while (true) {
                System.out.print("Elements.Person nationality (UNITED_KINGDOM, GERMANY, FRANCE, NORTH_KOREA): ");
                try {
                    nationality = Country.valueOf(in.nextLine());
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("Введите значение из списка");
                }
            }
            screenwriter = new Person(sname, height, eyeColor, hairColor, nationality);
        }
        return new Movie(id, name, new Coordinates(x, y), creationDate, oscarsCount, totalBoxOffice, genre, mpaaRating, screenwriter);
    }
    public static void action(ArrayList<Movie> list, SortedSet<Integer> all_id){
        if (list.size() != 0) {
            list.add(make_element(all_id.last() + 1));
            all_id.add(all_id.last() + 1);
        } else {
            list.add(make_element(1));
            all_id.add(1);
        }

    }
}
