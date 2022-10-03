package ro.atm;

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

        menuService.showOptionsAfterLogin();
        if (user!=null) {
            user.showInformationsForEachAccount();
        }


//        while (true) {
//            switch (userOption) {
//                case "1":
//
//
//            }
//            userOption = menuService.readUserInput(scanner);
//        }


    }


}