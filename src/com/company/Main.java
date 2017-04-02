package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static Scanner inputScanner = new Scanner(System.in);
    public static Account currentUser = new Account();
    public static RootMenu root = new RootMenu();
    public static boolean end = false;
    public static ArrayList<Account> accounts = new ArrayList<>();



    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to Jake's ATM.");
        Account user = new Account();
        user.getName();
        // Try to find the user in the users list.
        for(int i=0;i<accounts.size();i++) {
            Account a = accounts.get(i);
            if (user.name.equals(a.name)) {
                currentUser = a;
            }
        }
        if (currentUser == null) {
            accounts.add(user);
            currentUser = user;
        }

        do {
            root.startRootMenu();
        } while(end == false);

        System.out.println("Thank you and please come again!");

    }
}
