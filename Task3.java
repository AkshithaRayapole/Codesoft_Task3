import java.util.Scanner;

class UserAccount {
    private double money;

    UserAccount(double startMoney) {
        money = startMoney;
    }

    double seeMoney() {
        return money;
    }

    void addMoney(double amt) {
        if(amt > 0) money += amt;
    }

    boolean takeMoney(double amt) {
        if(amt > 0 && amt <= money) {
            money -= amt;
            return true;
        }
        return false;
    }
}

public class Task3 {
    private UserAccount acc;
    private Scanner sc;

    public Task3(UserAccount account) {
        acc = account;
        sc = new Scanner(System.in);
    }

    void displayOptions() {
        System.out.println("\n1. See Balance");
        System.out.println("2. Put Money");
        System.out.println("3. Get Money");
        System.out.println("4. Quit");
    }

    public void start() {
        System.out.println("Welcome to Simple ATM");

        while(true) {
            displayOptions();
            System.out.print("Pick: ");
            int pick = sc.nextInt();

            switch(pick) {
                case 1:
                    showBalance();
                    break;
                case 2:
                    doDeposit();
                    break;
                case 3:
                    doWithdraw();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Wrong choice!");
            }
        }
    }

    void showBalance() {
        System.out.printf("Balance: $%.2f\n", acc.seeMoney());
    }

    void doDeposit() {
        System.out.print("Amount to put: $");
        double amt = sc.nextDouble();
        if(amt <= 0) {
            System.out.println("Can't put that!");
            return;
        }
        acc.addMoney(amt);
        System.out.printf("Put $%.2f in\n", amt);
    }

    void doWithdraw() {
        System.out.print("Amount to get: $");
        double amt = sc.nextDouble();
        if(acc.takeMoney(amt)) {
            System.out.printf("Got $%.2f\n", amt);
        } else {
            System.out.println("Can't get that much!");
        }
    }

    public static void main(String[] args) {
        UserAccount myAcc = new UserAccount(500.00);
        Task3 atm = new Task3(myAcc);
        atm.start();
    }
}