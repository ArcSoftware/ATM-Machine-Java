package com.company;

/**
 * Created by Jake on 3/31/17.
 */
public class RootMenu {

    public void startRootMenu() throws Exception {
        System.out.println("What would you like to do?");
        System.out.println("Main Menu: \n 1. Check Balance \n 2. Withdraw Funds \n 3. Cancel");
        String rootEntry = Main.inputScanner.nextLine();


        if (rootEntry.contains("1") || rootEntry.equalsIgnoreCase("Check") || rootEntry.equalsIgnoreCase("Balance") || rootEntry.equalsIgnoreCase("Check Balance")) {
            System.out.println("You have $" + Account.startCash + " in your checking account.");
            System.out.println("Would you like to continue?");
            String c = Main.inputScanner.nextLine();
            if (c.contains("n") || c.contains("N")) {
                Main.end = true;
            }

        }
        else if (rootEntry.contains("2") || rootEntry.equalsIgnoreCase("Withdraw") || rootEntry.equalsIgnoreCase("Withdraw Funds")) {
            System.out.println("How much money would you like to withdraw?");
            String withdrawAmount = Main.inputScanner.nextLine();
            double withdrawn = Double.parseDouble(withdrawAmount);
            if ((Account.startCash - withdrawn < 0)) {
                throw new Exception("Not enough funds!");
            }
            Account.startCash = (Account.startCash - withdrawn);
            System.out.format("Here is your $%.2f in pennies. \nYou have $%.2f left in your account.\n", withdrawn, Account.startCash);


            System.out.println("Would you like to continue?");
            String c = Main.inputScanner.nextLine();

            if (c.contains("n") || c.contains("N")) {
                Main.end = true;
            }

        }

        else if (rootEntry.contains("3") || rootEntry.equalsIgnoreCase("Cancel")) {
            Main.end = true;
        }

        else {
            throw new Exception("Invalid input!");
        }


    }


}
