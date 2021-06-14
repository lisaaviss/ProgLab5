package Commands;
/**
 * Класс с командой help
 * @author Артём
 */
public class CommandHelp extends Command {
    public static void action(){
        System.out.println("\nhelp : вывести справку по доступным командам");
        System.out.println("info : вывести в стандартный поток вывода информацию о коллекции");
        System.out.println("show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        System.out.println("add {element} : добавить новый элемент в коллекцию");
        System.out.println("update_id {element} : обновить значение id элемента коллекции");
        System.out.println("remove_by_id id : удалить элемент из коллекции по его id");
        System.out.println("clear : очистить коллекцию");
        System.out.println("save : сохранить коллекцию в файл");
        System.out.println("execute_script file_name : считать и исполнить скрипт из указанного файла");
        System.out.println("exit : завершить программу (без сохранения в файл)");
        System.out.println("remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный");
        System.out.println("history : вывести последние 12 команд (без их аргументов)");
        System.out.println("min_by_name : вывести любой объект из коллекции, значение поля name которого является минимальным");
        System.out.println("group_counting_by_genre : сгруппировать элементы коллекции по значению поля genre, вывести количество элементов в каждой группе");
        System.out.println("count_by_mpaa_rating mpaaRating : вывести количество элементов, значение поля mpaaRating которых равно заданному\n");
    }
}
