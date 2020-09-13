package workoutApp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    public TextField inputName;
    @FXML
    public TextField inputKg;
    @FXML
    public TextField inputSet;
    @FXML
    public TextField inputRep;

    @FXML
    public TableView<Table> tableView;
    @FXML
    public TableColumn<Table,String> colEx;
    @FXML
    public TableColumn<Table,Integer> colRep;
    @FXML
    public TableColumn<Table,Integer>colSet;
    @FXML
    public TableColumn<Table,Double> colKg;
    
    //For calculating 1RM
    @FXML
    public TextField benchRepInpt;
    @FXML
    public TextField benchKgInpt;
    @FXML
    public TextField benchRMOut;
    @FXML
    public TextField squatRepInpt;
    @FXML
    public TextField squatKgInpt;
    @FXML
    public TextField squatRMOut;
    @FXML
    public TextField deadRepInpt;
    @FXML
    public TextField deadKgInpt;
    @FXML
    public TextField deadRMOut;

    List<List<String>> loadList = new ArrayList<>();
    // The save file...
    File file = new File("save.txt");
    ContentConstructor loadFile = new ContentConstructor();

    // Button for adding content to the table...
    public void addBtn(ActionEvent event) throws IOException{
        //if (inputName != null && inputRep != null && inputSet != null && inputKg != null)
        try {
            if (Integer.parseInt(inputRep.getText()) < 1 || Integer.parseInt(inputSet.getText()) < 1 || Double.parseDouble(inputKg.getText()) <= 0){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Invalid input!");
                alert.setHeaderText(null);
                alert.setContentText("Reps and sets cannot be below 1, and you cannot lift 0 or less kg's!");
                alert.showAndWait();
            } else {
                Table table = new Table(inputName.getText(), Integer.parseInt(inputRep.getText()), Integer.parseInt(inputSet.getText()), Double.parseDouble(inputKg.getText()));
                tableView.getItems().add(table);

                inputName.setText(null);
                inputRep.setText(null);
                inputSet.setText(null);
                inputKg.setText(null);
            }

        }catch (IllegalArgumentException e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Input is invalid, or you have not filled every field!");
            alert.showAndWait();

            System.out.println("Input is invalid, or you have not filled every field!");

        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colEx.setCellValueFactory(new PropertyValueFactory<>("TableName"));
        colRep.setCellValueFactory(new PropertyValueFactory<>("TableRep"));
        colSet.setCellValueFactory(new PropertyValueFactory<>("TableSet"));
        colKg.setCellValueFactory(new PropertyValueFactory<>("TableKg"));
        // Implementations for LOADING...
        try {
            loadFile.readFile(file,loadList);
            ObservableList<Table> observableList = FXCollections.observableArrayList();

            for (List<String> strings : loadList) {
                observableList.add(new Table(
                        strings.get(0),
                        Integer.parseInt(strings.get(1)),
                        Integer.parseInt(strings.get(2)),
                        Double.parseDouble(strings.get(3))));
            }
            tableView.setItems(observableList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // The method writes the values of the table to the console...
    public void saveBtn(ActionEvent actionEvent) throws IOException {

        // The initializer is redundant, but is implemented to show structure...
        Table table = new Table();

        //Implementing the write method from the ContentConstructor class...
        ContentConstructor write = new ContentConstructor();

        List<List<String>> arrList = new ArrayList<>();

        // Clear the whole file before saving new content...
        try{
            PrintWriter outFile = new PrintWriter(file);
            outFile.println("");
            outFile.close();
        }
        catch (FileNotFoundException e){
            System.err.println("Error: file 'save.txt' could not be opened for writing.");
            System.exit(1);
        }

        //Construct a new arrayList of "new" values, taken from the tableView...
        for (int i = 0; i < tableView.getItems().size(); i++) {
            table = tableView.getItems().get(i);
            arrList.add(new ArrayList<>());
            arrList.get(i).add(table.tableName.get());
            arrList.get(i).add("" + table.tableRep.get());
            arrList.get(i).add("" + table.tableSet.get());
            arrList.get(i).add("" + table.tableKg.get());

            System.out.println(arrList);
            write.writeFile(file, arrList);
            }

        //Write the arrayList to the console...
        for (int i = 0; i < arrList.size() ; i++) {
            System.out.println("Exercise " + (i + 1) + ": ");
            for (int j = 0; j < arrList.get(i).size() ; j++) {
                System.out.println(arrList.get(i).get(j));
            }
        }
    }
    // Buttons for removing fields from the table...
    public void removeBtn(ActionEvent actionEvent) {
        // No workie...
        //ObservableList<Table> allTable,singleTable;
        //allTable = tableView.getItems();
        //singleTable = tableView.getSelectionModel().getSelectedItems();
        //singleTable.forEach(allTable::remove);

        //Works
        ObservableList<Table> singleTable = tableView.getSelectionModel().getSelectedItems();
        ArrayList<Table> rows = new ArrayList<>(singleTable);
        rows.forEach(row -> tableView.getItems().remove(row));

    }
    public void removeAllBtn(ActionEvent actionEvent) {
        ObservableList<Table> allTable;
        allTable = tableView.getItems();
        allTable.removeAll(allTable);
    }
    // Buttons for calculating 1RM of different exercises...
    public void calcBtnBench(ActionEvent actionEvent) {
        calcBtnRM(benchKgInpt, benchRepInpt, benchRMOut);
    }

    public void calcBtnSquat(ActionEvent actionEvent) {
        calcBtnRM(squatKgInpt, squatRepInpt, squatRMOut);
    }

    public void calcBtnDead(ActionEvent actionEvent) {
        calcBtnRM(deadKgInpt, deadRepInpt, deadRMOut);
    }

    private void calcBtnRM(TextField kgInpt, TextField repInpt, TextField RMOut) {
        Calculate calculate = new Calculate(Double.parseDouble(kgInpt.getText()),Double.parseDouble(repInpt.getText()));

        double newOutOne = Double.parseDouble(kgInpt.getText());
        double newOutTwo = Double.parseDouble(repInpt.getText());

        if (newOutOne <= 0 || newOutTwo < 1){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Input is invalid! You cannot lift 0 or less kg's, and you must be able to do at least one rep!");
            alert.showAndWait();
        }else {
            String out = String.valueOf(calculate.oneRM(newOutOne,newOutTwo));
            double roundOneDigitOut = Math.round((Double.parseDouble(out)*10.0)/10.0);
            String finalOut = String.valueOf(roundOneDigitOut);

            RMOut.setText(finalOut);

            kgInpt.setText(null);
            repInpt.setText(null);
        }


    }
}
