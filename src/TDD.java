public class TDD {
    /**
     * Spring 2020
     * CSE4283
     * Software Testing and QA
     * Assignment 2
     * Due: 11:59PM, 3/4/21
     */

    /**
     * @author Nathan Cheshire
     */

    /**
     * Requirements
     * Command Line Interface - Develop a command line app that prompts the user to select a
     * function to execute and allows the user to gracefully exit the app when desired. The menu
     * should be displayed after each function (although a GUI is not required, you are permitted to
     * create one) unless the user exits. For now, the app must have the following functionalities.
     *
     * 1. Body Mass Index - Input height in feet and inches. Input weight in pounds. Return
     * BMI value and category: Underweight = <18.5; Normal weight = 18.5–24.9;
     * Overweight = 25–29.9; Obese = BMI of 30 or greater (see formula linked in the Notes
     * & Resources section).
     *
     * 2. Retirement - Input user's current age, annual salary, percentage saved (employer
     * matches 35% of savings). Input desired retirement savings goal. Output what age
     * savings goal will be met. You can assume death at 100 years (therefore, indicate if the
     * savings goal is not met).
     */

    public static void main(String[] args) {
        System.out.println("Starting program at: " + System.currentTimeMillis());



        System.out.println("Ending program at:   " + System.currentTimeMillis());
    }

    public double BMI(int feet, double inches, double pounds) {
        double ret = 0;



        return ret;
    }

    public String getBMICategory(double BMI) {
        if (BMI < 18.5)
            return "underweight";

        else if (BMI >= 18.5 && BMI < 24.9)
            return "normal";

        else if (BMI > 25 && BMI <= 29.9)
            return "Obese";

        return "overweight";
    }
}
