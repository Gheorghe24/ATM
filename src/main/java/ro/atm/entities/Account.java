package ro.atm.entities;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Account {
    private int balance; //sold
    private final AccountCurrency currency;
    private final String accountNumber;

    public Account(int balance, AccountCurrency currency, String accountNumber) {
        this.balance = balance;
        this.currency = currency;
        this.accountNumber = accountNumber;
    }


}
