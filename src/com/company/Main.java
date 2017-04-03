package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static Scanner inputScanner = new Scanner(System.in);
    public static Account currentUser;
    public static RootMenu root = new RootMenu();
    public static boolean end = false;
    public static ArrayList<Account> accounts = new ArrayList<>();
    public static boolean run = true;


    public static void main(String[] args) throws Exception {
        while(run == true)
        {
            System.out.println("Welcome to Jake's ATM.");
            Account user = new Account();
            user.getName();
            currentUser = null;
            for (int i = 0; i < accounts.size(); i++) {
                Account a = accounts.get(i);
                if (user.name.equals(a.name)) {
                    currentUser = a;
                }
            }

            if (currentUser == null) {
                System.out.println("No account found under that name, would you like to create one?");
                String createAccount = Main.inputScanner.nextLine();
                if (createAccount.contains("y") || createAccount.contains("Y")||createAccount.equalsIgnoreCase("create") || createAccount.contains("new")) {
                    accounts.add(user);
                    currentUser = user;
                    System.out.println("An account has been created for you with $100.00 to spend on us. /dance \n");
                }
                else {
                    System.out.println("Good.. we didn't want your money anyways. \n");
                    throw new Exception("Poor sport detected :( ");
                }
            }


            do {
                root.startRootMenu();
            } while (end == false);
            System.out.println("Thank you and please come again! \n \n");

        }
    }
}
