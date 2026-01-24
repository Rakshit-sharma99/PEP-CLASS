package Day3.Banking System;

public class Main {
    public static void main(String[] args) {
        Account account = new Account(12345, 1000.0);
        account.deposit(500.0);
        account.withdraw(200.0);
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Balance: " + account.getBalance());
    }
}   