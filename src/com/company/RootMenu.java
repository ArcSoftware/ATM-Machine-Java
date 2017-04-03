package com.company;

/**
 * Created by Jake on 3/31/17.
 */
public class RootMenu {

    public void startRootMenu() throws Exception {
        System.out.println("What would you like to do?");
        System.out.println("Main Menu: \n 1. Check Balance \n 2. Withdraw Funds \n 3. Deposit Funds \n 4. Logout of Account");
        String rootEntry = Main.inputScanner.nextLine();
        double currentBalance = Main.currentUser.balance;


        if (rootEntry.contains("1") || rootEntry.equalsIgnoreCase("Check") || rootEntry.equalsIgnoreCase("Balance") || rootEntry.equalsIgnoreCase("Check Balance")) {
            System.out.println("You have $" + currentBalance+ " in your checking account.");
            System.out.println("Would you like to continue?");
            String b = Main.inputScanner.nextLine();
            if (b.contains("n") || b.contains("N")) {
                Main.end = true;
            }

        }
        else if (rootEntry.contains("2") || rootEntry.equalsIgnoreCase("Withdraw") || rootEntry.equalsIgnoreCase("Withdraw Funds")) {
            System.out.println("How much money would you like to withdraw?");
            String withdrawAmount = Main.inputScanner.nextLine();
            double withdrawn = Double.parseDouble(withdrawAmount);
            if (currentBalance < withdrawn) {
                throw new Exception("Not enough funds!");
            }
            Main.currentUser.balance  -= withdrawn;
            System.out.format("Here is your $%.2f in pennies. \nYou have $%.2f left in your account.\n", withdrawn, Main.currentUser.balance);


            System.out.println("Would you like to continue?");
            String c = Main.inputScanner.nextLine();

            if (c.contains("n") || c.contains("N")) {
                Main.end = true;
            }

        }
        else if (rootEntry.contains("3") || rootEntry.equalsIgnoreCase("Withdraw")) {
            System.out.println("How much money would you like to Deposit?");
            String depositAmount = Main.inputScanner.nextLine();
            double deposit = Double.parseDouble(depositAmount);

            currentBalance = (currentBalance + deposit);
            Main.currentUser.balance += deposit;
            System.out.format("Thank you for your deposit. \nYou have $%.2f left in your account.\n", currentBalance);


            System.out.println("Would you like to continue?");
            String d = Main.inputScanner.nextLine();

            if (d.contains("n") || d.contains("N")) {
                Main.end = true;
            }


        }
        else if (rootEntry.contains("4") || rootEntry.equalsIgnoreCase("log") || rootEntry.equalsIgnoreCase("out")) {
            Main.end = true;
        }

        else {
            throw new Exception("Invalid input!");
        }


    }


}
