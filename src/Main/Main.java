package Main;

import Commands.CommandsExecution;
import Elements.Movie;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.*;

/**
 * Главный класс
 * @author Артём
 */

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        boolean go = false;
        BufferedInputStream in = null;
        try {
            in = new BufferedInputStream(new FileInputStream("/home/s307470/oop.json"));
            go = true;
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
        if (go) {
            byte [] data = new byte[1024];
            int amountData = in.read(data, 0, 1024);
            SortedSet<Integer> all_id = new TreeSet<>();
            while (amountData == 1024) {
                sb.append(new String(data, StandardCharsets.UTF_8));
                amountData = in.read(data, 0, 1024);
            }
            if (amountData != -1){
                byte[] residue = new byte[amountData];
                System.arraycopy(data, 0, residue, 0, residue.length);
                sb.append(new String(residue, StandardCharsets.UTF_8));
            }
            Gson g = new GsonBuilder()
                    .setPrettyPrinting()
                    .registerTypeAdapter(ZonedDateTime.class, new TypeAdapter<ZonedDateTime>() {
                        @Override
                        public void write(JsonWriter out, ZonedDateTime value) throws IOException {
                            out.value(value.toString());
                        }

                        @Override
                        public ZonedDateTime read(JsonReader in) throws IOException {
                            return ZonedDateTime.parse(in.nextString());
                        }
                    })
                    .enableComplexMapKeySerialization()
                    .create();
            ArrayList<Movie> list = new ArrayList<>();
            LocalDateTime time_create = LocalDateTime.now();
            boolean unique = true;
            try {
                if (sb.length() != 0) {

                    for (Movie obj : g.fromJson(String.valueOf(sb), Movie[].class)) {
                        list.add(obj);
                        if (all_id.contains(obj.getId())) {
                            System.out.println("id объектов коллекции в файле не уникальны");
                            unique = false;
                            break;
                        } else {
                            all_id.add(obj.getId());
                        }
                    }
                }
                if (unique) {
                    System.out.println("Введите команду");
                    CommandsExecution.action(list, all_id, g, time_create);
                }
            } catch (com.google.gson.JsonSyntaxException ex){
                System.out.println("Проверьте ваш файл");
            }
        }
    }
}