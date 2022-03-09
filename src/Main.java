import entities.Bank;
import entities.Account;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite o nome do banco: ");
        String bankName = input.nextLine();
        Bank banco01 = new Bank(bankName);

        System.out.print("Quantas contas você deseja criar? ");
        int accountQuantity = input.nextInt();

        for (int i = 0; i < accountQuantity; i++) {
            System.out.print("Entre com o número da conta #" + (i + 1) + ": ");
            int accountNumber = input.nextInt();
            System.out.print("Entre com o valor inicial da conta: R$ ");
            double initialValue = input.nextDouble();

            Account account = new Account(accountNumber, initialValue);
            boolean accountVerify = banco01.addAccount(account);
            if(!accountVerify){
                System.out.println("Nome repetido, está conta não será registrada.");
            }
        }
        System.out.println("");
        System.out.println(banco01.getName());
        System.out.print("Digite o número da conta que você quer entrar: ");
        int accountNumber = input.nextInt();

        Account account = banco01.getAccount(accountNumber);

        if (account == null) {
            throw new RuntimeException("Número da conta inexistente.");
        }
        int numberToWithdrawOrDeposit;

        do {
            System.out.println("O que você deseja fazer? digite: \n" +
                    "1 - sacar  \n" +
                    "2 - depositar \n" +
                    "3 - sair");
            numberToWithdrawOrDeposit = input.nextInt();

            if (numberToWithdrawOrDeposit == 1) {
                System.out.print("Digite o valor que você quer sacar: R$ ");
                double valueToWithdraw = input.nextInt();

                boolean withdrawResult = account.withdraw(valueToWithdraw);
                if (!withdrawResult) {
                    System.out.println("Saldo insuficiente.");
                } else {
                    System.out.println("Saque feito com sucesso, seu saldo agora é de: R$ " + account.getBalance());
                }

            } else if (numberToWithdrawOrDeposit == 2) {
                System.out.print("Digite o valor que você quer depositar: R$ ");
                double valueToDeposit = input.nextDouble();

                account.deposit(valueToDeposit);
                System.out.println("Deposito feito com sucesso, seu saldo agora é de: R$ " + account.getBalance());

            } else if (numberToWithdrawOrDeposit == 3) {

            } else {
                System.out.println("Número inválido!!!");
            }
            System.out.println("");
        } while (numberToWithdrawOrDeposit != 3);
        System.out.println(banco01.getName());
        System.out.println(account);


    }
}
