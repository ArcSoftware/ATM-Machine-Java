package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
	System.out.println("Welcome to Jake's ATM.");
	System.out.println("Please enter your account name.");

	Scanner inputScanner = new Scanner(System.in);
	String name = inputScanner.nextLine();
        Money a = new Money();
        a.bankMoney = 100;
	if(name.equalsIgnoreCase("")) {
	    throw new Exception("No Name Entered!");
    }
    else if (name.equals(" ")) {
        throw new Exception("A non-valid name was entered.");
        }
    else {
        System.out.println("Thank you for your account name, welcome " + name + "!");
    }
    System.out.println("Please enter your four-digit pin number to access your account.");
	String pin = inputScanner.nextLine();

	if(pin.length()!=4) {
	    throw new Exception("Pin entered is not a valid pin number.");
    }
    else {
	    System.out.println("Thank you. Welcome " + name + "!");
    }
    boolean end = false;
        do {
        System.out.println("What would you like to do?");
        System.out.println("Main Menu: \n 1. Check Balance \n 2. Withdraw Funds \n 3. Cancel");
        String rootEntry = inputScanner.nextLine();


        if (rootEntry.contains("1") || rootEntry.equalsIgnoreCase("Check") || rootEntry.equalsIgnoreCase("Balance") || rootEntry.equalsIgnoreCase("Check Balance")) {
            System.out.println("You have " + a.bankMoney + " in your checking account.");
            System.out.println("Would you like to continue?");
            String c = inputScanner.nextLine();
            if (c.contains("n") || c.contains("N")) {
                end = true;
            }

        }
        else if (rootEntry.contains("2") || rootEntry.equalsIgnoreCase("Withdraw") || rootEntry.equalsIgnoreCase("Withdraw Funds")) {
            System.out.println("How much money would you like to withdraw?");
            String withdrawAmount = inputScanner.nextLine();
            double withdrawn = Double.parseDouble(withdrawAmount);
            if ((a.bankMoney - withdrawn < 0)) {
                throw new Exception("Not enough funds!");
                }

            System.out.format("Here is your $%.2f in pennies. \nYou have $%.2f left in your account.", withdrawn, (a.bankMoney-withdrawn));
            a.bankMoney = (a.bankMoney - withdrawn);

            System.out.println("Would you like to continue?");
            String c = inputScanner.nextLine();
            {
                if (c.contains("n") || c.contains("N"))
                    end = true;
            }
        }

        else if (rootEntry.contains("3") || rootEntry.equalsIgnoreCase("Cancel")) {
            end = true;
            }

        else {
            throw new Exception("Invalid input!");
            }

        } while(end == false);

    System.out.println("Thank you and please come again!");

    }
}
