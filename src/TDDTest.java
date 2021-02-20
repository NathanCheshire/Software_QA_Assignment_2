import org.junit.Test;

import static org.junit.Assert.*;

public class TDDTest {

    private TDD TDD;

    @org.junit.Before
    public void setUp() throws Exception {
        System.out.println("Setup (optional)");
        TDD = new TDD();

    }

    @org.junit.After
    public void tearDown() throws Exception {
        System.out.println("Teardown (optional)");
    }

    @Test
    public void bmiCategoryTest() {
        assertEquals("underweight", TDD.getBMICategory(18.4));
        assertEquals("normal", TDD.getBMICategory(18.5));
        assertEquals("normal", TDD.getBMICategory(18.6));
        assertEquals("normal", TDD.getBMICategory(24.9));
        assertEquals("overweight", TDD.getBMICategory(25.0));
        assertEquals("overweight", TDD.getBMICategory(25.1));
        assertEquals("overweight", TDD.getBMICategory(29.9));
        assertEquals("obese", TDD.getBMICategory(30.0));
        assertEquals("obese", TDD.getBMICategory(30.1));
    }

    @Test
    public void bmiCalculationTest() {
        //added a delta here instead of using number formatters to do our rounding for us
        assertEquals(21.323,TDD.BMI(5,9,141),0.001);
    }

    @Test
    public void ageCalculationTest() {

    }

    @Test
    public void savingsCalculationCategoryTest() {

    }
}