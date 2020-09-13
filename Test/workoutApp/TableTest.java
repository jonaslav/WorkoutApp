package workoutApp;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import static org.junit.jupiter.api.Assertions.*;

class TableTest {

    private String name = "Benk";
    private int rep = 8;
    private int set = 4;
    private int kg = 50;
    private Table table;

    @BeforeEach
    public void setUp(){
        table = new Table(name, rep, set, kg);
    }

    @Test
    public void testConstructor(){
        assertEquals(name, table.getTableName());
        assertEquals(rep, table.getTableRep());
        assertEquals(set, table.getTableSet());
        assertEquals(kg, table.getTableKg());
    }

    @Test
    public void TestGetTableName() {
        assertEquals(name, table.getTableName());
    }

    @Test
    public void TestGetTableRep() {
        assertEquals(rep, table.getTableRep());
    }

    @Test
    public void TestGetTableSet() {
        assertEquals(set, table.getTableSet());
    }

    @Test
    public void TestGetTableKg() {
        assertEquals(kg, table.getTableKg());
    }

    @Test
    public void TestSetTableName() {
        table.setTableName("Squat");
        assertEquals("Squat", table.getTableName());
    }
    @Test
    public void TestSetTableRep(){
        table.setTableRep(13);
        assertEquals(13, table.getTableRep());
    }

    @Test
    public void TestSetTableSet() {
        table.setTableSet(4);
        assertEquals(4, table.getTableSet());

    }

    @Test
    public void TestSetTableKg() {
        table.setTableKg(70);
        assertEquals(70, table.getTableKg());
    }
}