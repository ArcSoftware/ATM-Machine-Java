package com.company;

import java.util.ArrayList;

/**
 * Created by Jake on 3/31/17.
 */
public class Account {
    String name;
    String pin;
    double balance;
    //double startCash = 100;



    public void getName() throws Exception {
        System.out.println("Please enter your account name.");
        name = Main.inputScanner.nextLine();


        if (name.equalsIgnoreCase("")) {
            throw new Exception("No Name Entered!");
        } else if (name.equals(" ")) {
            throw new Exception("A non-valid name was entered.");
        } //else {
           // \\System.out.println("Thank you for your account name, welcome " + name + "!");
        //}
    }
    public void getPin() throws Exception {
        System.out.println("Please enter your four-digit pin number to access your account.");
        pin = Main.inputScanner.nextLine();

        if (pin.length() != 4) {
            throw new Exception("Pin entered is not a valid pin number.");
        } else {
            System.out.println("Thank you. Welcome " + "!");
        }

    }
    public static double startCash = 100;








}
