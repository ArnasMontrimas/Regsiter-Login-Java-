package Practice;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserBase {
    //Store Users Here
    private ArrayList<User> users;
    //End

    //Constructor
    public UserBase() {
        users = new ArrayList<>();
    }
    //End

    //Registration Method
    public void register() {
        Scanner scan = new Scanner(System.in);
        String username, password = null;
        boolean tryAgain;
        int exit = 0, age = -1;

        System.out.println("Registration\nEnter '-10' to terminate");
        do {
            System.out.println("Enter Username Please");
            username = scan.next();
            if(username.equalsIgnoreCase(String.valueOf(-10))) {
                exit = -10;
                break;
            }
            tryAgain = false;
            for(User u: users) {
                if(u.getUsername().equalsIgnoreCase(username)) {
                    tryAgain = true;
                    System.out.println("Username Already Exists\n");
                    break;
                }
            }
        } while(tryAgain);

        if(exit != -10) {
            System.out.println("Enter Password Please");
            password = scan.next();
            if(password.equalsIgnoreCase(String.valueOf(-10))) exit = -10;
        }

        if(exit != -10) {
            do {
                try {
                    System.out.println("Enter Your Age\nShould be Greater than 0\nOtherwise the program will terminate itself");
                    tryAgain = false;
                    age = scan.nextInt();
                    if(age == -10) break;
                }
                catch(InputMismatchException ex) {
                    System.out.println("Age Should be NUMERIC ONLY\n");
                    scan.next();
                    tryAgain = true;
                }
            } while (tryAgain);
        }

        try {
            User newUser = new User(username,password,age);
            users.add(newUser);
            System.out.println("Registration Successful");
        }
        catch(IllegalArgumentException ex) {
            System.out.println("Registration Unsuccessful");
        }
    }
    //End

    //Login Method
    public boolean login() {
        Scanner scan = new Scanner(System.in);
        String username = null, password = null;
        int exit = 0;
        boolean tryAgain = true;

        System.out.println("Login\nEnter '-10' to terminate");
        do {
            System.out.println("Enter username");
            username = scan.next();
            if(username.equalsIgnoreCase(String.valueOf(-10))) break;
            System.out.println("Enter password");
            password = scan.next();
            if(password.equalsIgnoreCase(String.valueOf(-10))) break;
            for(User u: users) {
                if(u.getUsername().equalsIgnoreCase(username) && u.getPassword().equals(password)) {
                    System.out.println("Login Successful");
                    System.out.println(u.toString());
                    tryAgain = false;
                    break;
                }
                System.out.println("User Not Found Try again");
            }
        } while(tryAgain);
        if(tryAgain) System.out.println("Login Unsuccessful");
        return !tryAgain;
    }
    //End
}
