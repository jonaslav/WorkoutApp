package workoutApp;

import javafx.scene.control.TableView;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ContentConstructorTest{

    private ContentConstructor loadFile = new ContentConstructor();
    private List<List<String>> loadList = new ArrayList<>();
    private File file = new File("testing.txt");
    private String name = "Benk";
    private String rep = "8";
    private String set = "4";
    private String kg = "20";

    @Test
    public void readFile() {
        try {
            loadFile.readFile(file, loadList);
        } catch (IOException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void writeFile() {
        List<List<String>> arrList = new ArrayList<>();
        ContentConstructor write = new ContentConstructor();
        arrList.add(new ArrayList<>());
        arrList.get(0).add(name);
        arrList.get(0).add(rep);
        arrList.get(0).add(set);
        arrList.get(0).add(kg);
        System.out.println(arrList);
        try {
            write.writeFile(file, arrList);
        } catch (IOException e) {
            fail(e.getMessage());
        }
    }
}