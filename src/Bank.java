import java.util.concurrent.ThreadLocalRandom;
import java.util.HashMap;

public class Bank {
    public HashMap<Integer, BankAccount> accounts = new HashMap<>();
    private int generateAccountNumber() {
        return ThreadLocalRandom.current().nextInt(Integer.MAX_VALUE);
    }

    public BankAccount createAccount (double initialAmount) {
        int accountNumber = generateAccountNumber();
        BankAccount newAccount = new BankAccount(initialAmount, accountNumber);
        accounts.putIfAbsent(accountNumber, newAccount);
        return newAccount;
    }

    public BankAccount getAccountByNumber(int _accountNumber) {
        BankAccount targetAccount = accounts.get(_accountNumber);
        System.out.println("Printed value is");
        System.out.println(accounts.get(123));
        if (targetAccount != null) {
            return targetAccount;
        }
        System.out.println("No account found");
        return null;
    }

    public Transaction invokeTransaction(Transaction transaction) {
        BankAccount receiver = getAccountByNumber(transaction.receiver);
        BankAccount sender = getAccountByNumber(transaction.sender);

        if (sender.amount < transaction.amount) {
            System.out.println("Account #" + sender + " does not have enough funds to transfer $" + transaction.amount + ".");
        } else {
            sender.withdrawAmount(transaction.amount);
            receiver.advanceAmount(transaction.amount);
            transaction.setCompleted(true);
        }

        return transaction;
    }
}
