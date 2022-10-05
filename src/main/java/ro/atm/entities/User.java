package ro.atm.entities;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Setter
@Getter
public class User {
    private final String username;
    private final String dateOfBirth;
    private String pin;

    private boolean loggedIn = false;
    public List<Account> accounts;


    public User(String username, String dateOfBirth, String pin, List<Account> accounts) {
        this.username = username;
        this.dateOfBirth = dateOfBirth;
        this.pin = pin;
        this.accounts = accounts;
    }

    public void changePin(@NotNull String oldPin, String newPin) {
        if(oldPin.equals(getPin())) {
            this.pin = newPin;
        }
    }

    public void showInformationsForEachAccount(){
        System.out.println("\nList of your accounts");
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println("Account " + i + ") " + accounts.get(i) + "\n");
        }
    }

}
