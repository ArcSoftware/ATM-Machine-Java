#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

/**
 * Created by Jake on 3/31/17.
 */
public class RootMenu {

    public void startRootMenu() throws Exception {
        System.out.println("What would you like to do?");
        System.out.println("Main Menu: ${symbol_escape}n 1. Check Balance ${symbol_escape}n 2. Withdraw Funds ${symbol_escape}n 3. Deposit Funds ${symbol_escape}n 4. Logout of Account ${symbol_escape}n 5. Modify Accounts ");
        String rootEntry = Main.inputScanner.nextLine();
        double currentBalance = Main.currentUser.checking;
        double savingsBalance = Main.currentUser.savings;


        if (rootEntry.contains("1") || rootEntry.equalsIgnoreCase("Check") || rootEntry.equalsIgnoreCase("Balance") || rootEntry.equalsIgnoreCase("Check Balance")) {
            System.out.println("You have ${symbol_dollar}" + currentBalance + " in your checking and ${symbol_dollar}" + savingsBalance + " in your savings account.");
            System.out.println("Would you like to continue?");
            String b = Main.inputScanner.nextLine();
            if (b.contains("n") || b.contains("N")) {
                Main.end = true;
            }

        }
        else if (rootEntry.contains("2") || rootEntry.equalsIgnoreCase("Withdraw") || rootEntry.equalsIgnoreCase("Withdraw Funds")) {
            System.out.println("Which account would you like to withdraw funds from? ${symbol_escape}n 1. Savings ${symbol_escape}n 2. Checking");
            String selectAccount = Main.inputScanner.nextLine();
            if (selectAccount.contains("1") || selectAccount.equalsIgnoreCase("savings")) {
                System.out.println("How much money would you like to withdraw from your Savings account?");
                String withdrawAmount = Main.inputScanner.nextLine();
                double withdrawn = Double.parseDouble(withdrawAmount);
                if (savingsBalance < withdrawn) {
                    throw new Exception("Not enough funds!");
                }
                Main.currentUser.savings  -= withdrawn;
                System.out.format("Here is your ${symbol_dollar}%.2f in pennies. ${symbol_escape}nYou have ${symbol_dollar}%.2f left in your savings account.${symbol_escape}n", withdrawn, Main.currentUser.savings);


                System.out.println("Would you like to continue?");
                String c = Main.inputScanner.nextLine();

                if (c.contains("n") || c.contains("N")) {
                    Main.end = true;
                }


            } else if (selectAccount.contains("2") || selectAccount.equalsIgnoreCase("checking")) {
                System.out.println("How much money would you like to withdraw from your checking account?");
                String withdrawAmount = Main.inputScanner.nextLine();
                double withdrawn = Double.parseDouble(withdrawAmount);
                if (currentBalance < withdrawn) {
                    throw new Exception("Not enough funds!");
                }
                Main.currentUser.checking  -= withdrawn;
                System.out.format("Here is your ${symbol_dollar}%.2f in pennies. ${symbol_escape}nYou have ${symbol_dollar}%.2f left in your checking account.${symbol_escape}n", withdrawn, Main.currentUser.checking);


                System.out.println("Would you like to continue?");
                String c = Main.inputScanner.nextLine();

                if (c.contains("n") || c.contains("N")) {
                    Main.end = true;
                }

            }


        }
        else if (rootEntry.contains("3") || rootEntry.equalsIgnoreCase("deposit")) {
            System.out.println("Which account would you like to deposit funds to? ${symbol_escape}n 1. Savings ${symbol_escape}n 2. Checking");
            String selectAccount = Main.inputScanner.nextLine();
            if (selectAccount.contains("1") || selectAccount.equalsIgnoreCase("savings")) {
                System.out.println("How much money would you like to Deposit into savings?");
                String depositAmount = Main.inputScanner.nextLine();
                double deposit = Double.parseDouble(depositAmount);

                savingsBalance = (savingsBalance + deposit);
                Main.currentUser.savings += deposit;
                System.out.format("Thank you for your deposit. ${symbol_escape}nYou have ${symbol_dollar}%.2f left in your savings account.${symbol_escape}n", savingsBalance);


                System.out.println("Would you like to continue?");
                String d = Main.inputScanner.nextLine();

                if (d.contains("n") || d.contains("N")) {
                    Main.end = true;
                }

            }
            else if (selectAccount.contains("2") || selectAccount.equalsIgnoreCase("checking")) {
                System.out.println("How much money would you like to Deposit into your checking account?");
                String depositAmount = Main.inputScanner.nextLine();
                double deposit = Double.parseDouble(depositAmount);

                currentBalance = (currentBalance + deposit);
                Main.currentUser.checking += deposit;
                System.out.format("Thank you for your deposit. ${symbol_escape}nYou have ${symbol_dollar}%.2f left in your checking account.${symbol_escape}n", currentBalance);


                System.out.println("Would you like to continue?");
                String d = Main.inputScanner.nextLine();

                if (d.contains("n") || d.contains("N")) {
                    Main.end = true;
                }

            }


        }
        else if (rootEntry.contains("4") || rootEntry.equalsIgnoreCase("log") || rootEntry.equalsIgnoreCase("out")) {
            Main.end = true;
        }
        else if (rootEntry.contains("5") || rootEntry.equalsIgnoreCase("Modify") || rootEntry.equalsIgnoreCase("accounts")) {
            System.out.println("You are now in the account menu. "  + "${symbol_escape}n What you like to do?");
            System.out.println(" 1. Add account ${symbol_escape}n 2. Remove account ${symbol_escape}n 3. Account Transfer");
            String modifyEntry = Main.inputScanner.nextLine();
            if (modifyEntry.equalsIgnoreCase("1") || modifyEntry.equalsIgnoreCase("add") || modifyEntry.equalsIgnoreCase("add accounts")) {
                System.out.println("Please enter new account name. ${symbol_escape}n note- Ben personally gives all new accounts ${symbol_dollar}500 in savings and ${symbol_dollar}100 in checking.");
                String newUser = Main.inputScanner.nextLine();
                if (Main.accounts.containsKey(newUser)) {
                    System.out.println("I'm sorry, but there is already an account under that name. ${symbol_escape}n Returning to main menu... ${symbol_escape}n");
                } else {
                    Account add = new Account();
                    Main.accounts.put(newUser, add);
                        System.out.println("An account has been created for " + newUser +  " with ${symbol_dollar}600.00 to spend on us. /dance ${symbol_escape}n");
                    }

                }
            else if (modifyEntry.equalsIgnoreCase("2") || modifyEntry.equalsIgnoreCase("Remove") || modifyEntry.equalsIgnoreCase("remove accounts")) {
                System.out.println("Please enter the name of the account you wish to delete.");
                String removeUser = Main.inputScanner.nextLine();
                if (Main.accounts.containsKey(removeUser)) {
                    System.out.println("Are you sure you want to delete " + removeUser + "'s account?");
                    String confirmDelete = Main.inputScanner.nextLine();
                    if (confirmDelete.contains("Y") || confirmDelete.contains("y") || confirmDelete.equalsIgnoreCase("confirm")) {
                        Main.accounts.remove(removeUser);
                    } else {
                        System.out.println("Returning to main menu.");
                    }

                } else {
                    System.out.println("I'm sorry, there is no account under that name to delete.${symbol_escape}n Returning to main menu.. ${symbol_escape}n");
                }
            } else if (modifyEntry.equalsIgnoreCase("3") || modifyEntry.equalsIgnoreCase("transfer") || modifyEntry.equalsIgnoreCase("account transfer")) {
                System.out.println("Please enter the name of the account you transfer funds to.");
                String transfer = Main.inputScanner.nextLine();
                if (Main.accounts.containsKey(transfer)) {
                    System.out.println("How much of your money would you like to transfer to " + transfer + "'s account?");
                    String transferAmount = Main.inputScanner.nextLine();
                    Double.valueOf(transferAmount);
                    //Main.accounts.get(transfer).savings = Main.accounts.get(transfer).savings - transferAmount;
                    // Get the account money is coming from
                   // Main.currentUser;

                    // Get the account money is going to
                    //Main.accounts.get(transfer);

                    // If there's enough in the source account, transfer

                    //Main.accounts.replace("transfer", currentBalance + transferAmount);
                }

            }

        }


    }


}
