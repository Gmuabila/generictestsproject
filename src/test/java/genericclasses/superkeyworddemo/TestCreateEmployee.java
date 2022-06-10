package genericclasses.superkeyworddemo;

import lombok.Builder;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestCreateEmployee {
    private static final double DELTA = 0.0001;

    @Test
    public void createEmployeeTest() {
        Employee emp1 = new Employee(454, "Jane", 455.60f);
        Employee emp2 = new Employee();
        emp2.id = 145;
        emp2.name = "Catherine";
        emp2.setSalary(450000.55f);  //Using setter method to assign value

        assertEquals(454, emp1.getId());
        assertEquals("Jane", emp1.getName());
        assertEquals(455.60f, emp1.getSalary(), DELTA);

        assertEquals(145, emp2.getId());
        assertEquals("Catherine", emp2.getName());
        assertEquals(450000.55f, emp2.getSalary(), DELTA);
    }
}
