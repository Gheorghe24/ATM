package ro.atm;

import ro.atm.entities.Account;
import ro.atm.entities.User;
import ro.atm.repository.UserRepository;
import ro.atm.service.LoginService;
import ro.atm.service.MenuService;
import ro.atm.service.RegisterService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        userRepository.createDatabase();
        LoginService loginService = new LoginService(userRepository);
        RegisterService registerService = new RegisterService(userRepository);
        MenuService menuService = new MenuService(userRepository);
        menuService.showBeforeLogInMenu();
        Scanner scanner = new Scanner(System.in);
        String userOption = menuService.readUserInput(scanner);
        User user;

        while (true) {
            if (userOption.equals("1")) {
                user = menuService.loginClientAndReturnUser(loginService, scanner);
                break;
            } else if (userOption.equals("2")) {
                user = menuService.registerClientAndReturnUser(registerService, scanner);
                break;
            }
            userOption = menuService.readUserInput(scanner);
        }

        if (user == null && !user.isLoggedIn()) {
            System.out.println("Sorry, user not found or not logged in");
            return;
        }

        user.showInformationsForEachAccount();
        System.out.print("Choose one of the accounts above:");
        userOption = menuService.readUserInput(scanner);
        int userOptionDigit = Integer.parseInt(userOption);

        menuService.showOptionsAfterLogin();

        Account chosenAccount = user.getAccounts().get(userOptionDigit);

        System.out.print("Choose one of the options above:");
        userOption = menuService.readUserInput(scanner);
        int userAmmount;

        while (true) {
            switch (userOption) {
                case "1":
                    chosenAccount.showAccountDetails();
                    break;
                case "2":
                    chosenAccount.checkBalance();
                    break;
                case "3":
                    System.out.println("-------Deposit------");
                    System.out.print("Enter your ammount money:");
                    userAmmount = Integer.parseInt(menuService.readUserInput(scanner));
                    chosenAccount.deposit(userAmmount);
                    break;
                case "4":
                    System.out.println("-------Withdraw------");
                    System.out.print("Enter your ammount money:");
                    userAmmount = Integer.parseInt(menuService.readUserInput(scanner));
                    chosenAccount.withdraw(userAmmount);
                    break;
                case "5":
                    System.out.print("Enter your old pin:");
                    String oldPin = menuService.readUserInput(scanner);
                    if (oldPin.equals(user.getPin())) {
                        System.out.print("Enter your new pin:");
                        String newPin = menuService.readUserInput(scanner);
                        user.changePin(user.getPin(), newPin);
                    } else {
                        System.out.println("Sorry, you entered a wrong password");
                    }
                    break;
                case "6":
                    user.setLoggedIn(false);
                    break;
            }
            if(userOption.equals("6")) {
                break;
            }
            System.out.print("Choose one of the options above:");
            userOption = menuService.readUserInput(scanner);
            chosenAccount = user.getAccounts().get(userOptionDigit);
        }

        System.out.println("Thanks for choosing us!");


    }


}