package entities;

public class Account {
    private Integer accountNumber;
    private Double balance;

    public Account(){

    }
    public Account(Integer accountNumber, Double initialValue) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.balance += initialValue;
    }

    public Integer getAccountNumber() {
        return accountNumber;

    }

    public Double getBalance() {
        return balance;
    }


    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Número da conta: "+ getAccountNumber()+"\n");
        sb.append("Saldo da conta: R$"+getBalance());
        return sb.toString();
    }

    public void deposit( double depositValue){
        balance += depositValue;
    }

    public boolean withdraw(double withdrawValue){
        if(withdrawValue > balance){
            return false;

        }

        balance -= withdrawValue;
        return true;

    }


}
