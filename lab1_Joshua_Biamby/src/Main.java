import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        String name;
        int monthly_salary;
        double yearly_salary; double loan_principal; double loan_interest; double new_principal;
        int age;
        boolean eligible_ForRelief; boolean loan_PaidOff;

        //Header
        System.out.println("[Budgeting System]");

        //Input from user
        Scanner myScan= new Scanner(System.in);
        System.out.print("Enter Your Name: ");
        name = myScan.nextLine();
        System.out.print("Hello " +name +". ");
        System.out.print("Please enter your monthly salary: ");
        monthly_salary = myScan.nextInt();
        yearly_salary = monthly_salary * 12;
        System.out.println();

        System.out.print("What is the total amount of your loan? ");
        loan_principal = myScan.nextDouble();
        System.out.print("What is the interest rate of your loan? ");
        loan_interest = myScan.nextDouble();
        loan_interest = loan_interest/100;
        double interest_calc = (1 + (loan_interest/12));
        new_principal = (loan_principal * Math.pow(interest_calc,12));
        System.out.println();

        System.out.println("Your yearly salary is: $" +yearly_salary);
        System.out.println("In 12 months, your loan's principal will be: $" +new_principal);
        System.out.println();

        System.out.println("At the end of the year, you wil have paid off your debt: ");
        System.out.println(yearly_salary >= new_principal);
        System.out.println("At the end of the year, your will still have some debt left: ");
        System.out.println(yearly_salary < new_principal);
        System.out.println("At the end of the year, you will have $" +(yearly_salary - new_principal) +" of your salary left.");
        System.out.println();

        System.out.println("The government is offering loan relief for persons 25 and under, and for those 65 and over.");
        System.out.print("What is your age? ");
        age = myScan.nextInt();
        eligible_ForRelief = age <= 25 || age >= 65;
        System.out.println("The relief is $10000. You are eligible for the relief: " +eligible_ForRelief);
        loan_PaidOff = (yearly_salary >= new_principal) || (eligible_ForRelief && (yearly_salary + 10000 >= new_principal));
        System.out.println("With or without relief, you will be able to pay your loan in full: " +loan_PaidOff);
    }
}