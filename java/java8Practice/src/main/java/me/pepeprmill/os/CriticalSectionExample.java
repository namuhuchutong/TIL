package me.pepeprmill.os;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.Semaphore;

public class CriticalSectionExample {

    public static void main(String[] args) throws InterruptedException {

        testSemaphore();
    }

    private static void testSemaphore() throws InterruptedException {

        final BankAccount bankAccount = new BankAccount(0, new Semaphore(1));
        final Parent parent = new Parent(bankAccount);
        final Child child = new Child(bankAccount);

        parent.start();
        child.start();
        parent.join();
        child.join();

        System.out.println("\nBank Balance : " + bankAccount.getBalance());
    }
}

@AllArgsConstructor
@Data
class BankAccount {

    private int balance;
    final private Semaphore sem;

    void deposit(int amount) {
        try {
            sem.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int temp = this.balance + amount;
        System.out.print("+");
        this.balance = temp;

        sem.release();
    }

    void withdraw(int amount) {
        try {
            sem.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int temp = this.balance - amount;
        System.out.print("-");
        this.balance = temp;

        sem.release();
    }
}

@AllArgsConstructor
@Data
class Parent extends Thread {

    final private BankAccount bank;

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            this.bank.deposit(100);
        }
    }
}

@AllArgsConstructor
@Data
class Child extends Thread {

    final private BankAccount bank;

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            this.bank.withdraw(100);
        }
    }
}