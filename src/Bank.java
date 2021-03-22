import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;

public class Bank {
    public ArrayList<BankAccount> accounts = new ArrayList<>();
    private int generateAccountNumber() {
        return ThreadLocalRandom.current().nextInt(Integer.MAX_VALUE);
    }

    public BankAccount createAccount (double initialAmount) {
        int accountNumber = generateAccountNumber();
        BankAccount newAccount = new BankAccount(initialAmount, accountNumber);
        accounts.add(newAccount);
        return newAccount;
    }

    public BankAccount getAccountByNumber(int _accountNumber) {
        int i = 0;
        while(i < accounts.size()) {
            BankAccount currentItem = accounts.get(i);
            if (currentItem.accountNumber == _accountNumber) {
                return currentItem;
            }
            i++;
        }
        System.out.println("No account found");
        return null;
    }

    public Transaction envokeTransaction(Transaction transaction) {
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
