package com.auth;

import java.util.Scanner;


public abstract class Auth {
    public static String correctUserName = "user@email.com";
    public static String correctPassword = "user123";
    public static String enteredUserName, enteredPassword;

    public static Scanner sc = new Scanner(System.in);
    static void inputUserName() {
        System.out.print("Enter your username: ");
        enteredUserName = sc.next();
        System.out.println();
    }

    static void inputPassword() {
        System.out.print("Enter your password: ");
        enteredPassword = sc.next();
        System.out.println();
    }

    public static boolean authenticate() {
        if (enteredUserName.equals(correctUserName) && enteredPassword.equals(correctPassword)) {
            return true;
        }
        else {
            return false;
        }
    }
}
