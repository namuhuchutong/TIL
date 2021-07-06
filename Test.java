class Chopstick{
    boolean inUse;

    Chopstick(){
        this.inUse = false;
    }

    synchronized void acquire() throws InterruptedException{
        while(inUse)
            wait();
        inUse = true;
    }

    synchronized void release(){
        inUse = false;
        notify();
    }
}

class Person extends Thread{
    int id;
    Chopstick stick;

    Person(int id, Chopstick stick){
        this.id = id;
        this.stick = stick;
    }

    public void run(){
        try{
            while(true){
                stick.acquire();
                eating();
            
                stick.release();
                thinking();

            }
        }catch(InterruptedException e){}
    }

    void eating(){
        System.out.println("["+id+"] eating");
    }
    void thinking(){
        System.out.println("["+id+"] thinking");
    }

}

class Test{
    static final int num = 5;

    public static void main(String[] args) {
        Chopstick[] sticks = new Chopstick[num];
        Person[] people = new Person[num];

        for(int i =0; i<num; i++){
            sticks[i] = new Chopstick();
        }

        for(int i = 0; i < num; i++){
           people[i] = new Person(i, sticks[i]); 
        }

        for(int i = 0; i < num; i++){
            people[i].start();
        }
    }
}