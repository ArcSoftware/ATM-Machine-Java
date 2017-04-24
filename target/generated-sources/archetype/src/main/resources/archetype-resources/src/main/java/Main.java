#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static Scanner inputScanner = new Scanner(System.in);
    public static Account currentUser;
    public static RootMenu root = new RootMenu();
    public static boolean end = false;
    public static HashMap<String, Account> accounts = new HashMap<>();
    public static boolean run = true;


    public static void main(String[] args) throws Exception {
        Gson gson = new Gson();

        // just making sure that we don't optimize out the usage of gson
        // because it has no references in the project
        // because maybe the compiler will do that.
        gson.toJson(new Object());

        while(run == true)
        {
            System.out.println("Welcome to Jake's ${artifactId}.");
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
                    System.out.println("An account has been created for you with ${symbol_dollar}100.00 to spend on us. /dance ${symbol_escape}n");
                }
                else {
                    System.out.println("Good.. we didn't want your money anyways. ${symbol_escape}n");
                    throw new Exception("Poor sport detected :( ");
                }
            }


            do {
                root.startRootMenu();
            } while (end == false);
            System.out.println("Thank you and please come again! ${symbol_escape}n ${symbol_escape}n");

        }
    }
}
