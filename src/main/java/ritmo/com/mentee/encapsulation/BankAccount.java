package ritmo.com.mentee.encapsulation;

public class BankAccount {
    private String accountNumber;
    private double balance;
    private String ownerName;

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", ownerName='" + ownerName + '\'' +
                '}';
    }
}
