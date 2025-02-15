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
        Users newUser = new Users();
        while (true) {
            System.out.println("***Sign Up***");
            inputEmail = askforEmail();
            if (iUserService.findByUserEmail(inputEmail) != null) {
                System.out.println("""
                    There is a registered account with that email
                    would you like to Log In?
                    1- Log In
                    2 -Sign up
                    """);
                if(scanner.nextInt()==1){
                    logIn(inputEmail);
                    break;
                }

            } else {
                System.out.println("Create user nickname :");
                inputNickname = scanner.nextLine();
                while (true){
                    System.out.println("Create Password : ");
                    inputPassword = scanner.nextLine();
                    System.out.println("Confirm Password : ");
                    if(inputPassword.equals(scanner.nextLine())){
                        break;
                    }
                    System.out.println("Password don't match. Try Again :");
                }
                newUser.setUserEmail(inputEmail);
                newUser.setUserPassword(inputPassword);
                newUser.setUserNickname(inputNickname);
                iUserService.savedUser(newUser);
                break;
            }
        }
    }

    public  boolean logIn() {
        inputEmail = askforEmail();
        return logIn(inputEmail);
    }

    public  boolean logIn(String inputEmail) {
        System.out.println("***Log in***");
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
                    System.out.println("Incorrect password");
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
                    inputEmail = askforEmail();
                    System.out.println("User's Password: ");
                    inputPassword = scanner.nextLine();
                }else {
                    break;
                }
            }
        }
        return false;
    }

    public String askforEmail(){
        while (true){
            System.out.println("Enter Email");
            inputEmail =scanner.nextLine();
            if(inputEmail.contains("@") && !inputEmail.contains(".")){
                return inputEmail;
            }
                System.out.println("Invalid Email format");
        }
    }
}
