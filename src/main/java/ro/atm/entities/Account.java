package ro.atm.entities;

import lombok.Getter;
import lombok.Setter;
import ro.atm.utils.Utils;

@Setter
@Getter
public class Account {
    private int balance;
    private final AccountCurrency currency;
    private final String accountNumber;

    public Account(int balance, AccountCurrency currency, String accountNumber){
        this.balance = balance;
        this.currency = currency;
        this.accountNumber = accountNumber;
    }

    public void withdraw(int ammount){
        if(this.balance - ammount >= 0) {
            balance-=ammount;
        } else {
            System.out.println("You don't have enough coins, sorry !");
        }
    }

    public void deposit(int ammount){
        balance+=ammount;
    }

    public void showAccountDetails() {
        System.out.println("*******ACCOUNT DETAILS*******");
        System.out.println("Your account number: " + this.getAccountNumber());
        System.out.println("Your balance: " + this.getBalance() + " " + this.currency.name());
    }

    public void checkBalance() {
        System.out.println("Current Time: " + Utils.getTime());
        System.out.println("Your balance: " + this.getBalance() + " " + this.currency.name());
    }

    @Override
    public String toString() {
        return "\nbalance:" + balance +
                "\ncurrency:" + currency +
                "\naccountNumber:" + accountNumber;
    }
}
