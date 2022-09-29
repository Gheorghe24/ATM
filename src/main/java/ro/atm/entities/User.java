package ro.atm.entities;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class User {
    private final String username;
    private final String id;
    private final String dateOfBirth;
    private String pin;

    private boolean loggedIn = false;
    public List<Account> accounts = new ArrayList<>();


    public User(String username, String dateOfBirth, String pin, String id) {
        this.username = username;
        this.dateOfBirth = dateOfBirth;
        this.pin = pin;
        this.id = id;
    }

    public User(String username, String dateOfBirth, String pin, List<Account> accounts, String id) {
        this.username = username;
        this.dateOfBirth = dateOfBirth;
        this.pin = pin;
        this.accounts = accounts;
        this.id = id;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void changePin(@NotNull String oldPin, String newPin) {
        if(oldPin.equals(getPin()))
        this.pin = newPin;
    }

}
