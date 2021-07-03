class BankAccount{
    int balance;

    synchronized void deposit(int amt){
        int temp = balance + amt;
        System.out.print("+");
        balance = temp;
        notify();
    }

    synchronized void withdraw(int amt){
        while(balance <= 0)
            try {
                wait();
            } catch (InterruptedException e) {} 
        int temp = balance - amt;
        System.out.print("-");
        balance = temp;
    }

    int getBalance(){
        return balance;
    }
}

class Parent extends Thread{
    BankAccount b;

    Parent (BankAccount b){
        this.b = b;
    }

    public void run(){
        for(int i = 0; i<100; i++){
            b.deposit(1000);
        }
    }
}

class Child extends Thread{
    BankAccount b;
    Child(BankAccount b){
        this.b = b;
    }
    public void run(){
        for(int i = 0; i<100; i++){
            b.withdraw(1000);
        }
    }
}

class Test{
    public static void main(String[] args) throws InterruptedException{
        BankAccount b = new BankAccount();
        Parent p = new Parent(b);
        Child c = new Child(b);

        p.start();
        c.start();
        p.join();
        c.join();
        System.out.println("\nbalance = "+b.getBalance());
    }
}