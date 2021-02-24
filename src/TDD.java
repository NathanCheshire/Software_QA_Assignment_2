import java.io.InputStreamReader;
import java.util.Scanner;

/**
 Spring 2020
 CSE4283
 Software Testing and QA
 Assignment 2
 Due: 11:59PM, 3/4/21

 * @author  Nathan Cheshire
 * @version 1.1
 * @since  03-04-2021
 */
public class TDD {
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

    //JUnit walkthrough I looked at: https://www.jetbrains.com/help/idea/tdd-with-intellij-idea.html

    public static void main(String[] args) {
        new TDD();
    }

    private TDD() {
        long start = System.currentTimeMillis();

        Scanner s = new Scanner(new InputStreamReader(System.in));

        while (true) {
            System.out.print("Enter your choice:\n(1)Body Mass Index Calculator\n(2)Retirement Calculator\n(3)exit\n>> ");

            String input = s.next();

            while (!input.equals("1") && !input.equals("2") && !input.equals("3")) {
                System.out.println("Invalid option, must enter 1,2, or 3");
                System.out.print("Enter your choice:\n(1)Body Mass Index Calculator\n(2)Retirement Calculator\n(3)exit\n>> ");
            }

            if (Integer.parseInt(input) == 1) {
                double feet;
                double inches;
                double pounds;

                System.out.print("Enter your height in feet (inches are next)\n>> ");

                while (true) {
                    input = s.next();

                    try {
                        feet = Double.parseDouble(input);

                        if (feet > 0)
                            break;
                        else
                            throw new Exception("not positive so skip to catch");

                    } catch (Exception e) {
                        System.out.println("Your feet value must be a positive number");
                        System.out.print("Enter your height in feet (inches are next)\n>> ");
                    }
                }

                System.out.print("Enter your inches measurement (should be less than 12)\n>> ");

                while (true) {
                    input = s.next();

                    try {
                        inches = Double.parseDouble(input);

                        if (inches > 0)
                            break;
                        else
                            throw new Exception("not positive so skip to catch");

                    } catch (Exception e) {
                        System.out.println("Your inches value must be a positive number");
                        System.out.print("Enter your inches measurement (should be less than 12)\n>> ");
                    }
                }

                while (inches > 12.0) {
                    inches -= 12.0;
                    feet++;
                }

                System.out.print("Enter your weight in pounds\n>> ");

                while (true) {
                    input = s.next();

                    try {
                        pounds = Double.parseDouble(input);

                        if (pounds > 0)
                            break;
                        else
                            throw new Exception("not positive so skip to catch");

                    } catch (Exception e) {
                        System.out.println("Your pounds value must be a positive number");
                        System.out.print("Enter your weight in pounds\n>> ");
                    }
                }

                double bmi = BMI(feet,inches,pounds);
                System.out.println("Your BMI is: " + String.format("%,.3f", bmi) + " (" + getBMICategory(bmi) + ")\n");

            } else if (Integer.parseInt(input) == 2) {
                double age;
                double analSalary;
                double percentSaved; //add 35% to this (percent should be between 0-100)
                double desiredSavings;

                System.out.print("Enter your age in years\n>> ");

                while (true) {
                    input = s.next();

                    try {
                        age = Double.parseDouble(input);

                        if (age > 0)
                            break;
                        else
                            throw new Exception("not positive so skip to catch");

                    } catch (Exception e) {
                        System.out.println("Your age value must be a positive number");
                        System.out.print("Enter your age in years\n>> ");
                    }
                }

                System.out.print("Enter your anual salary in dollars\n>> ");

                while (true) {
                    input = s.next();

                    try {
                        analSalary = Double.parseDouble(input);

                        if (analSalary >= 0)
                            break;
                        else
                            throw new Exception("not positive so skip to catch");

                    } catch (Exception e) {
                        System.out.println("Your salary value must be a positive number (exclude any non-number characters)");
                        System.out.print("Enter your anual salary in dollars\n>> ");
                    }
                }

                System.out.print("Enter the percent of your anual salary that you save (0-100)\n>> ");

                while (true) {
                    input = s.next();

                    try {
                        percentSaved = Double.parseDouble(input);

                        if (percentSaved >= 0 && percentSaved <= 100)
                            break;
                        else
                            throw new Exception("not positive so skip to catch");

                    } catch (Exception e) {
                        System.out.println("Your percent saved value must be a positive number between 0 and 100");
                        System.out.print("Enter the percent of your anual salary that you save (0-100)\n>> ");
                    }
                }

                System.out.print("Enter your desired savings when you retire\n>> ");

                while (true) {
                    input = s.next();

                    try {
                        desiredSavings = Double.parseDouble(input);

                        if (desiredSavings >= 0)
                            break;
                        else
                            throw new Exception("not positive so skip to catch");

                    } catch (Exception e) {
                        System.out.println("Your retirement savings must be a positive number");
                        System.out.print("Enter your desired savings when you retire\n>> ");
                    }
                }

                System.out.println("Given the following inputs: ");
                System.out.println("Age: " + age);
                System.out.println("Anual salary: " + analSalary);
                System.out.println("Percent of anual salary saved (employer matches 35% of this)");
                System.out.println("\tBefore: " + percentSaved);
                System.out.println("Desired retirement savings: " + desiredSavings);
                double retAge = retirementAge(age,analSalary,percentSaved,desiredSavings);
                System.out.println("Given all this, you will be the age of " + retAge
                                   + " by the time you meet your desired savings goal (" + desiredSavings + ")\n" +
                                   "This means you " + retirementCategory(retAge) + " your desired savings goal.\n");

            } else if (Integer.parseInt(input) == 3)
                break;

        }

        long end = System.currentTimeMillis();
        System.out.println("TDD obj operated for:   " + (end - start) + "ms (" + (end - start) / 1000.0 + "s)");
    }

    static double BMI(double feet, double inches, double pounds) {
        pounds *= 0.45; //now weight is in kg

        inches += feet * 12; //now we can work with just inches
        inches *= 0.025; //now inches is in metric also
        inches *= inches; //squared

        return pounds/inches;
    }

    static String getBMICategory(double BMI) {
        if (BMI < 18.5)
            return "underweight";

        else if (BMI >= 18.5 && BMI < 25.0)
            return "normal";

        else if (BMI >= 25.0 && BMI <= 29.9)
            return "overweight";

        //should only be 30+ here
        return "obese";
    }

    //employer matches 35% of total savings apparently
    static double retirementAge(double age, double analSalary, double percentSaved, double desiredSavings) {
        double analSavings = analSalary * (percentSaved / 100.0) * 1.35;
        double totalSavings = 0;

        while (totalSavings < desiredSavings) {
            totalSavings += analSavings;
            age++;
        }

        return age;
    }

    static String retirementCategory(double retirementAge) {
        return (retirementAge >= 100.0 ? "will not meet" : "will meet");
    }
}
