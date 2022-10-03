package ro.atm.repository;

import ro.atm.entities.Account;
import ro.atm.entities.AccountCurrency;
import ro.atm.entities.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static ro.atm.utils.Utils.getRandomNumber;

public class UserRepository {
    List<User> users = new ArrayList<>();

    public void createDatabase() {
        Account account1 = new Account(10000, AccountCurrency.RON,getRandomNumber(8));
        Account account2 = new Account(5000,AccountCurrency.RON,getRandomNumber(8));
        Account account3 = new Account(100,AccountCurrency.RON,getRandomNumber(8));
        Account account4 = new Account(500,AccountCurrency.USD,getRandomNumber(8));
        List<Account> list1 = Arrays.asList(account1, account2);
        List<Account> list2 = Arrays.asList(account3, account4);
        List<Account> list3 = Arrays.asList(account1, account3);
        users.add(new User("Nicu", "23.11.01", "1234", list1));
        users.add(new User("Gicu", "23.01.01", "8888", list2));
        users.add(new User("Bogdan", "23.01.01", "2204", list3));
    }

    public User findUserByUsernameAndPin(String name, String pin){
        for (User u: users) {
            if(u.getUsername().equalsIgnoreCase(name) && u.getPin().equals(pin)) {
                return u;
            }
        }
        return null;
    }

    public User findUserByUsername(String name){
        for (User u: users) {
            if(u.getUsername().equalsIgnoreCase(name)) {
                return u;
            }
        }
        return null;
    }

    public void addUserToDatabase(User user) {
        users.add(user);
    }
}
