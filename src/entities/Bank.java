package entities;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Account> accountList = new ArrayList<>();

    public Bank() {

    }

    public Bank(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Account getAccount(int numeroDaConta){
        Account accountToReturn = new Account();

        for (Account x: accountList) {
            if(x.getAccountNumber() == numeroDaConta){
                accountToReturn = x;
                break;
            }
        }

        return accountToReturn;
    }

    public boolean addAccount(Account account) {
        for (Account x : accountList) {
            int accountNumber = account.getAccountNumber();
            int anotherNumber = x.getAccountNumber();
            if (anotherNumber == accountNumber) {
                return false;

            }
        }
        accountList.add(account);
        return true;
    }



}
