
import javafx.util.Pair;
import java.util.ArrayList;

//holds static global values on the server
public class Main {
    static ArrayList<Pair<String, String>> names = new ArrayList<>();//pairs (company,name)

    static public void init() {
        Main.names.add(new Pair<>("100", "Abrahaam"));
        Main.names.add(new Pair<>("100", "Jon"));
        Main.names.add(new Pair<>("100", "Max"));
        Main.names.add(new Pair<>("200", "Izergil"));
        Main.names.add(new Pair<>("200", "Alex"));
        Main.names.add(new Pair<>("300", "Josh"));
        //etс
    }
}