package workoutApp;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;

public class Table {

    protected SimpleStringProperty tableName;
    protected SimpleIntegerProperty tableRep;
    protected SimpleIntegerProperty tableSet;
    protected SimpleDoubleProperty tableKg;

    //Constructor

    public Table(String tableName, int tableRep, int tableSet, double tableKg) {
        this.tableName = new SimpleStringProperty(tableName);
        this.tableRep = new SimpleIntegerProperty(tableRep);
        this.tableSet = new SimpleIntegerProperty(tableSet);
        this.tableKg = new SimpleDoubleProperty(tableKg);
    }
    // Takes no parameter...
    public Table() {
    }

    public String getTableName() {
        return tableName.get();
    }

    public void setTableName(String tableName) {
        this.tableName = new SimpleStringProperty(tableName);
    }

    public int getTableRep() {
        return tableRep.get();
    }

    public void setTableRep(int tableRep) {
        this.tableRep = new SimpleIntegerProperty(tableRep);
    }

    public int getTableSet() {
        return tableSet.get();
    }

    public void setTableSet(int tableSet) {
        this.tableSet = new SimpleIntegerProperty(tableSet);
    }

    public double getTableKg() {
        return tableKg.get();
    }

    public void setTableKg(double tableKg) {
        this.tableKg = new SimpleDoubleProperty(tableKg);
    }
}
