package workoutApp;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class ContentConstructor implements FileManager {

    @Override
    public void readFile(File file, List<List<String>> loadList) throws IOException {
        Scanner in;

        ArrayList<String> temp = new ArrayList<>();

        try {
            in = new Scanner(new FileReader(file));
            while (in.hasNext()) {
              temp.add(in.nextLine());
            }
            System.out.println(temp);
            int n = 4;
            for (int i = 0; i < temp.size(); i += 4) {
                loadList.add(temp.subList(i,n));
                n += 4;
            }
            System.out.println(loadList);

        }catch (FileNotFoundException e){
            System.err.println("Error: file 'save.txt' could not be opened. Does it exist?");
            System.exit(1);
        }
    }

    @Override
    public void writeFile(File file, List<List<String>> arrList) throws IOException {
        try{
            PrintWriter outFile = new PrintWriter(file);
            for (List<String> strings : arrList) {
                for (String string : strings) {
                    outFile.println(string);
                }
            }
            outFile.close();
        }
        catch (FileNotFoundException e){
            System.err.println("Error: file 'save.txt' could not be opened for writing.");
            System.exit(1);
        }
    }

    //....TEST....
    public static void main(String[] args) throws IOException {
        ContentConstructor jaja = new ContentConstructor();
        List<List<String>> test = new ArrayList<>();

        jaja.readFile(new File("save.txt"),test );
    }
}
