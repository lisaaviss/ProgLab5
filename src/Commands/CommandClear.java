    package Commands;
    /**
     * Класс отчистки коллекции
     * @author Артём
     */
    import Elements.Movie;

    import java.util.ArrayList;

    public class CommandClear extends Command {
        public static void action(ArrayList<Movie> list){
            list.clear();
        }
    }
