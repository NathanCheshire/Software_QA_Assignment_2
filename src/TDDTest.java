import org.junit.Test;

import static org.junit.Assert.*;

public class TDDTest {

    //not necessary but here for learning
    @org.junit.Before
    public void setUp() throws Exception {
        System.out.println("Setup (optional)");

    }

    //not necessary but here for learning
    @org.junit.After
    public void tearDown() throws Exception {
        System.out.println("Teardown (optional)");
    }

    @Test
    public void bmiCategoryTest() {
        //here we test each edge case +/- 0.1 and some random other values

        //less value
        assertEquals("underweight", TDD.getBMICategory(16.0));

        //18.5 edge case
        assertEquals("underweight", TDD.getBMICategory(18.4));
        assertEquals("normal", TDD.getBMICategory(18.5));
        assertEquals("normal", TDD.getBMICategory(18.6));

        //25 edge case
        assertEquals("normal", TDD.getBMICategory(24.9));
        assertEquals("overweight", TDD.getBMICategory(25.0));
        assertEquals("overweight", TDD.getBMICategory(25.1));

        //30 edge case
        assertEquals("overweight", TDD.getBMICategory(29.9));
        assertEquals("obese", TDD.getBMICategory(30.0));
        assertEquals("obese", TDD.getBMICategory(30.1));

        //greater value
        assertEquals("obese", TDD.getBMICategory(50.0));
    }

    @Test
    public void bmiCalculationTest() {
        //added a delta here instead of using number formatters to do our rounding for us

        //0 isn't allowed nor a negative value here so the test is rather straight forward
        assertEquals(21.323,TDD.BMI(5,9,141),0.001);
        assertEquals(31.026,TDD.BMI(4,11,150),0.001);
        assertEquals(25.639,TDD.BMI(6,2,195),0.001);
    }

    @Test
    public void ageCalculationTest() {
        //class examples
        assertEquals(196,TDD.retirementAge(25,65000,10,1500000),0);
        assertEquals(70,TDD.retirementAge(45,100000,15,500000),0);

        //my test cases
        assertEquals(54,TDD.retirementAge(10,100000,12,700000),0);

        //test for 0 for salary
        assertEquals(Double.MAX_VALUE,TDD.retirementAge(20,0,50,600000),0);

        //test with 0 for percent saved
        assertEquals(Double.MAX_VALUE,TDD.retirementAge(60,1,0,3000000),0);

        //test with 0 for desired savings
        assertEquals(80,TDD.retirementAge(80,100000,100,0),0);

        //unreasonable age test
        assertEquals(26091,TDD.retirementAge(100,50,57,1000000),0);
    }

    @Test
    public void savingsCalculationCategoryTest() {
        //low test
        assertEquals("will meet",TDD.retirementCategory(70.0));
        assertEquals("will meet",TDD.retirementCategory(99.0));

        //100 edge case
        assertEquals("will meet",TDD.retirementCategory(99.9));
        assertEquals("will not meet",TDD.retirementCategory(100.0));
        assertEquals("will not meet",TDD.retirementCategory(100.1));

        //high test
        assertEquals("will not meet",TDD.retirementCategory(150.0));
    }
}