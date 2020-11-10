public class BankAccount {
    public int accountNumber;
    public static double amount;

    public BankAccount(double initialAmount, int i) {
        amount = initialAmount;
        accountNumber = i;
    }

    public void withdrawAmount (double withdrawalAmount) {
        if (withdrawalAmount > amount) {
            System.out.println("Account " + accountNumber + "does not have enough funds to withdraw $" + withdrawalAmount + ".");
            return;
        }
        amount -= withdrawalAmount;
        System.out.println("Acc#" + accountNumber + ". $" + withdrawalAmount + " withdrawal successfully handled.");
        System.out.println("New available amount is $" + amount);

    }

    // Advancement is the opposite of withdrawal;
    public void advanceAmount(double advancementAmount) {
        amount += advancementAmount;
        System.out.println("Acc#" + accountNumber + ". $" + advancementAmount + " advancement successfully handled.");
        System.out.println("New available amount is $" + amount);
    }
}

