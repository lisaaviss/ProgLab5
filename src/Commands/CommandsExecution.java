package Commands;

import Elements.Movie;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.SortedSet;

/**
 * Класс управляющий коммандами
 * @author Артём
 */

public class CommandsExecution extends Command {
    public static void objpols(Movie o) {
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
    public static void action(ArrayList<Movie> list, SortedSet<Integer> all_id, Gson g, LocalDateTime time_create) throws IOException {
        Scanner in = new Scanner(System.in);
        boolean script = false;
        Scanner ex_scan = null;
        String[] comand;
        Movie obj = null;
        boolean work = true;
        while (work) {
            if (script) {
                if (ex_scan.hasNextLine()) {
                    comand = ex_scan.nextLine().split("\\s");
                } else {
                    script = false;
                    comand = in.nextLine().split("\\s");
                }
            } else {
                comand = in.nextLine().split("\\s");
            }
            switch (comand[0]) {
                case ("exit"):
                    work = false;
                    in.close();
                    break;
                case ("help"):
                    CommandHistory.save("help");
                    CommandHelp.action();
                    break;
                case ("info"):
                    CommandHistory.save("info");
                    CommandInfo.action(list, time_create);
                    break;
                case ("show"):
                    CommandHistory.save("show");
                    CommandShow.action(list);
                    break;
                case ("add"):
                    CommandHistory.save("add");
                    CommandAdd.action(list, all_id);
                    break;
                case ("remove_by_id"):
                    CommandHistory.save("remove_by_id");
                    CommandRemoveById.action(comand, list, obj, all_id);
                    break;
                case ("update_id"):
                    CommandHistory.save("update_id");
                    CommandUpdate.action(comand,list, obj);
                    break;
                case ("clear"):
                    CommandHistory.save("clear");
                    CommandClear.action(list);
                    break;
                case ("save"):
                    CommandHistory.save("save");
                    CommandSave.action(list, g);
                    break;
                case ("count_by_mpaa_rating"):
                    CommandCountByMparating.action(list);
                    break;
                case ("group_counting_by_genre"):
                    CommandHistory.save("group_counting_by_genre");
                    CommandGroupByGenre.action(list);
                    break;
                case ("remove_lower"):
                    CommandHistory.save("remove_lower");
                    CommandRemoveLowerElement.action(list, obj, all_id);
                    break;
                case("history"):
                    CommandHistory.save("history");
                    CommandHistory.action();
                    break;
                case("min_by_name"):
                    CommandHistory.save("min_by_name");
                    CommandMinByName.action(list);


                case ("execute_script"):
                    CommandHistory.save("execute_script");
                    if (!script) {
                        if (comand.length == 2) {
                            try {
                                ex_scan = new Scanner(new File(comand[1]));
                                script = true;
                            } catch (FileNotFoundException e) {
                                System.out.println("Не удается найти указанный файл.");
                            }
                        } else {
                            System.out.println("В качестве аргумента введите путь до файла.");
                        }
                    } else {
                        System.out.println("Из файла не может быть вызван другой файл");
                        script = false;
                    }
                    break;

                default:
                    System.out.println("Неизвестная команда, для получения списка команд используйте help.");
                    break;
            }
        }
    }
}

