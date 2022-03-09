package entities;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Account> accountList = new ArrayList<>();

    public Bank() {

    }

    public Bank(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Account getAccount(int accountNumber) {

        for (Account account : accountList) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }

        return null;
    }

    public boolean addAccount(Account account) {
        for (Account accountAnother : accountList) {
            int accountNumber = account.getAccountNumber();
            int anotherNumber = accountAnother.getAccountNumber();
            if (anotherNumber == accountNumber) {
                return false;

            }
        }
        accountList.add(account);
        return true;
    }


}
