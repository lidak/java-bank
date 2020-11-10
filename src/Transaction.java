import java.util.concurrent.ThreadLocalRandom;

public class Transaction {
    public int sender;
    public int receiver;
    public double amount;
    private boolean completed = false;
    public int number = ThreadLocalRandom.current().nextInt(Integer.MAX_VALUE);

    public void setCompleted(boolean completed) {
        if (completed == false && this.completed == true) {
            System.out.println("Transaction can not be switched from completed to uncompleted.");
            return;
        }
        this.completed = completed;
        System.out.println("Transaction #" + number + " successfully completed. ");
    }
}
