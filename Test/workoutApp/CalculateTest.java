package workoutApp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculateTest {
    private Calculate calculate;


    @BeforeEach
    public void setUp() throws Exception {
        calculate = new Calculate(80, 8);
    }

    @Test
    public void TestOneRM() {
        assertEquals(101.312, calculate.oneRM(80,8));

    }
    @Test
    public void TestOneRM_ThrowsException(){
        calculate = new Calculate(-2, -3);
        assertThrows(IllegalArgumentException.class, () -> calculate.oneRM(-2, -3));
    }
}
