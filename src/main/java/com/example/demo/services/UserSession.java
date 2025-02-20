package com.example.demo.services;
import com.example.demo.model.Users;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//component when I need spring dependencies to use my class
//spring will detect and manage this instead of being static as injection does not work with that
// / this converts this class into a spring dependency thus to inport this in a diff class must use @autowire
public  class UserSession {
    @Autowired
    IUserService iUserService;
     Scanner scanner = new Scanner(System.in);
     Users user;

    public  boolean signUp() {
        Users newUser = new Users();
        String signUpEmail;
        String signUpPassword;
        String signUpNickname;
        while (true) {
            System.out.println("***Sign Up***");
            signUpEmail = askforEmail();
            if (iUserService.findByUserEmail(signUpEmail) != null) {
                System.out.println("""
                    There is a registered account with that email
                    would you like to Log In?
                    1- Log In
                    2 -Sign up
                    """);
                if(scanner.nextLine().equals("1")){
                    return logIn(signUpEmail);
                }

            }else {

                System.out.println("Create user nickname :");
                signUpNickname = scanner.nextLine();
                signUpPassword = createPassword();

                newUser.setUserEmail(signUpEmail);
                newUser.setUserPassword(signUpPassword);
                newUser.setUserNickname(signUpNickname);

                iUserService.saveData(newUser);
                break;
            }
        }
        return true;
    }


    public  boolean logIn() {
        String logInEmail = askforEmail();
        return logIn(logInEmail);
    }

    public  boolean logIn(String logInEmail) {
        String logInPassword;
        System.out.println("***Log in***");
        System.out.println("User's Password: ");
        logInPassword = scanner.nextLine();
        while (true){
         user = iUserService.findByUserEmail(logInEmail);
            if (user != null) {
                //user exists
                if (user.getUserPassword().equals(logInPassword)) {
                    System.out.println("Welcome " + user.getUserNickname());
                    return true;
                } else {
                    System.out.println("Incorrect password");
                    System.out.println("User's Password: ");
                    logInPassword = scanner.nextLine();
                }
        } else {
                System.out.println("there is no account under that Email:");
                System.out.println("""
                        1- enter new email
                        2 exit
                        """);
                if(scanner.nextLine().equals("1")){
                    logInEmail = askforEmail();
                    System.out.println("User's Password: ");
                    logInPassword = scanner.nextLine();
                }else {
                    break;
                }
            }
        }
        return false;
    }

    public String askforEmail(){
        String emailReceived;
        while (true){
            System.out.println("Enter Email");
            emailReceived =scanner.nextLine();
            if(emailReceived.contains("@") && emailReceived.contains(".")){
                return emailReceived;
            }
                System.out.println("Invalid Email format");
        }
    }

    private String createPassword() {
        String newPassword;
        while (true){
            System.out.println("Create Password : ");
            newPassword = scanner.nextLine();
            if (newPassword.length() < 8 ||
                    !newPassword.matches("^(?=.*[0-9])(?=.*[!@#$%^&*()_+={};':|,.<>/?])(?=.*[a-zA-Z]).{8,}$")) {
                System.out.println("""
                Invalid password. It must:
                - Contain at least one number
                - Contain at least one special character
                - Contain at least one letter
                - Be at least 8 characters long
                """);
                continue;
            }

            System.out.println("Confirm Password : ");
            if(newPassword.equals(scanner.nextLine())){
                System.out.println("Password created");
                break;
            }
            System.out.println("Password don't match. Try Again :");
        }
        return newPassword;
    }

}
