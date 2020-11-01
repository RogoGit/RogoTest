package com.example.SoftwareTestingLab3.web_helpers;

import java.io.InputStream;
import java.util.Scanner;

public class UserCredentials {

    public static String username;
    public static String password;

    static {
        InputStream inputStream = UserCredentials.class.getClassLoader().getResourceAsStream("user_credentials");
        Scanner scanner = new Scanner(inputStream).useDelimiter("\n");

        username = scanner.next();
        password = scanner.next();
    }

}
