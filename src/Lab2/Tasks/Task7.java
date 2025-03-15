package Lab2.Tasks;

interface BankAccountOperations {
    void createAccount(String accountNumber, double initialBalance);
    void deposit(double amount);
    void withdrawal(double amount);
    double getBalance();
}

class BankAccount implements BankAccountOperations {
    private String accountNumber;
    private double balance;

    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public void createAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        System.out.println("Счет создан: " + accountNumber + ", начальный баланс: " + initialBalance);
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Внесено: " + amount + ", текущий баланс: " + balance);
        } else {
            System.out.println("Ошибка: сумма для внесения должна быть положительной.");
        }
    }

    @Override
    public void withdrawal(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Снято: " + amount + ", текущий баланс: " + balance);
        } else {
            System.out.println("Ошибка: недостаточно средств или неверная сумма для снятия.");
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }
}

public class Task7 {

    public static void main(String[] args) {
        BankAccount account1 = new BankAccount();
        BankAccount account2 = new BankAccount();

        account1.createAccount("123456789", 1000.0);
        account2.createAccount("987654321", 500.0);

        account1.deposit(200.0);
        account1.withdrawal(150.0);
        System.out.println("Текущий баланс счета 1: " + account1.getBalance());

        account2.deposit(300.0);
        account2.withdrawal(1000.0);
        System.out.println("Текущий баланс счета 2: " + account2.getBalance());
    }
}