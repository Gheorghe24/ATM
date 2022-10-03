package ro.atm.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class User {
    private final String username;
    private final String dateOfBirth;
    private String pin;

    private boolean loggedIn = false;
    public List<Account> accounts = new ArrayList<>();


    public User(String username, String dateOfBirth, String pin) {
        this.username = username;
        this.dateOfBirth = dateOfBirth;
        this.pin = pin;
    }

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
        for (Account account: accounts) {
            System.out.println(account);
        }
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println("Account " + i + " " + accounts.get(i));
        }
    }

}
