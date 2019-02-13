package BankAcctApp;

public class BankAcctApp {

    public static void main(String[] args) {
        BankAccount acct1 = new BankAccount("123456978", 1000);
        BankAccount acct2 = new BankAccount("258965412", 2000);
        BankAccount acct3 = new BankAccount("963547812", 2500);

        acct1.setName("Jenny");
        System.out.println(acct1.getName());
        acct1.makeDeposit(500);
        acct1.makeDeposit(600);
        acct1.payBill(1000);
        acct1.accrue();
        System.out.println(acct1.toString());
    }
}

class BankAccount implements Interest {

    private static int id = 1000; //make this variable static so it belongs to this class
    private String accountNumber;
    private static final String routingNumber = "314075269";
    private String name;
    private String SSN;
    private double balance;


    //constructor
    public BankAccount(String SSN, double initDeposit) {
        balance = initDeposit;
        this.SSN = SSN;
        id++;
        setAccountNumber();
    }

    //method
    private void setAccountNumber() {
        int random = (int) (Math.random() * 100);
        accountNumber = id + random + SSN.substring(0, 2);
        System.out.println("Your account number : " + accountNumber);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void payBill(double amount){
        balance = balance - amount;
        System.out.println("You paid $" + balance);
        showBalance();
    }

    public void makeDeposit(double amount){
        balance = balance + amount;
        System.out.println("You deposited $" + balance);
        showBalance();
    }

    public void showBalance(){
        System.out.println("Account balance: " + balance);
    }

    public void accrueInterest(){

    }

    @Override
    public void accrue() {
        balance = balance*(1+rate/100);
        showBalance();
    }

    @Override
    public String toString(){
        return "Name: " + name + " | Account Number: " + accountNumber + " | Routing Number: " + routingNumber + " | Balance: " + balance;
    }
}
