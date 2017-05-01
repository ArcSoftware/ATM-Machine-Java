package com.company;

import com.google.gson.Gson;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main extends Application {

    public static Scanner inputScanner = new Scanner(System.in);
    public static Account currentUser;
    public static RootMenu root = new RootMenu();
    public static boolean end = false;
    public static HashMap<String, Account> accounts = new HashMap<>();
    public static boolean run = true;


    @Override //run when the app starts
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    public static void main(String[] args) throws Exception {
        Gson gson = new Gson();


        gson.toJson(new Object());

        while(run == true)
        {
            System.out.println("Welcome to Jake's ATM.");
            Account user = new Account();
            user.getName();
            currentUser = null;

            if (accounts.containsKey(user.name)) {
                currentUser = accounts.get(user.name);
            } else {
                System.out.println("No account found under that name, would you like to create one?");
                String createAccount = Main.inputScanner.nextLine();
                if (createAccount.contains("y") || createAccount.contains("Y")||createAccount.equalsIgnoreCase("create") || createAccount.contains("new")) {

                    accounts.put(user.name, user);
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
