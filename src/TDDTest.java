import org.junit.Test;

import static org.junit.Assert.*;

public class TDDTest {

    @org.junit.Before
    public void setUp() throws Exception {
        System.out.println("Setup (optional)");

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
        //todo find values here
        assertEquals(0,TDD.retirementAge(10,100000,12,700000));
        assertEquals(0,TDD.retirementAge(20,0,50,600000));
        assertEquals(0,TDD.retirementAge(60,1,0,3000000));
        assertEquals(0,TDD.retirementAge(80,100000,100,0));
        assertEquals(0,TDD.retirementAge(100,50,57,900000000));
    }

    @Test
    public void savingsCalculationCategoryTest() {
        assertEquals("will meet",TDD.retirementCategory(70.0));
        assertEquals("will meet",TDD.retirementCategory(99.0));
        assertEquals("will meet",TDD.retirementCategory(99.9));
        assertEquals("will not meet",TDD.retirementCategory(100.0));
        assertEquals("will not meet",TDD.retirementCategory(100.1));
        assertEquals("will not meet",TDD.retirementCategory(150.0));
    }
}