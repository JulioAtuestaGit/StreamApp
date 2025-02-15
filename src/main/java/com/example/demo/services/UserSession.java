package com.example.demo.services;
import com.example.demo.model.Users;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public  class UserSession {
    @Autowired
     IUserService iUserService;
     Scanner scanner = new Scanner(System.in);
     String inputEmail;
     String inputPassword;
     String inputNickname;
     Users user;

    public  void signUp() {
        System.out.println("""
                ***Sign Up***
                Enter your Email:
                """);
        inputEmail = scanner.nextLine();
        Users newUser = new Users();
        if (iUserService.findByUserEmail(inputEmail) != null) {
            System.out.println("There is a registered account with that email");
        } else {
            System.out.println("create Password : ");
            inputPassword = scanner.nextLine();
            System.out.println("create user nickname :");
            inputNickname = scanner.nextLine();

            newUser.setUserEmail(inputEmail);
            newUser.setUserPassword(inputPassword);
            newUser.setUserNickname(inputNickname);

            iUserService.savedUser(newUser);
        }
    }

    public  boolean logIn() {
        System.out.println("""
                ***Log in***
                User's Email:
                """);
        inputEmail = scanner.nextLine();
        System.out.println("User's Password: ");
        inputPassword = scanner.nextLine();
        while (true){
         user = iUserService.findByUserEmail(inputEmail);
            if (user != null) {
                //user exists
                if (user.getUserPassword().equals(inputPassword)) {
                    System.out.println("Welcome " + user.getUserNickname());
                    return true;
                } else {
                    System.out.println("Inconrrect password");
                    System.out.println("User's Password: ");
                    inputPassword = scanner.nextLine();
                }
        } else {
                System.out.println("there is no account under that Email:");
                System.out.println("""
                        1- enter new email
                        2 exit
                        """);
                int userInput = scanner.nextInt();
                scanner.nextLine();
                if(userInput == 1){
                    System.out.println("User's Email: ");
                    inputEmail = scanner.nextLine();
                    System.out.println("User's Password: ");
                    inputPassword = scanner.nextLine();
                }else {
                    break;
                }
            }
        }
        return false;
    }
}
