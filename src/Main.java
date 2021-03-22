public class Main {
    public static void main(String[] args) {
        Bank myBank = new Bank();
        BankAccount myFirstAccount = myBank.createAccount(1000);
        BankAccount mySecondAccount = myBank.createAccount(200);

        Transaction transaction = new Transaction();
        transaction.receiver = myFirstAccount.accountNumber;
        transaction.sender = mySecondAccount.accountNumber;
        transaction.amount = 11.30;

        myBank.invokeTransaction(transaction);
    }
}