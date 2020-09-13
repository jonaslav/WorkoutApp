package workoutApp;

import java.io.IOException;
import java.io.File;
import java.util.List;

public interface FileManager {
    void readFile(File file, List<List<String>> loadList) throws IOException;
    void writeFile(File file, List<List<String>> arrList ) throws IOException;
}
