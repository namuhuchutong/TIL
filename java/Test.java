class Test{
    public static void main(String[] args) throws InterruptedException{
        Storage s = new Storage();

        // 두 개의 스레드가 공유 자원 사용
        One one = new One(s);
        Two two = new Two(s);
        
        one.start();
        two.start();
        one.join();
        two.join();

        s.getStuff();

    }
}

class Storage{
    int stuff;
    void add(int amount){
        this.stuff += amount;
    }

    void sub(int amount){
        this.stuff -= amount;
    }

    void getStuff(){
        System.out.println("\n"+this.stuff);
    }
}

class One extends Thread {
    Storage s;
    One(Storage s){
        this.s = s;
    }

    public void run(){
        for(int i = 0; i <100; i++){
            s.add(10);
        }
    }
}

class Two extends Thread {
    Storage s;
    Two(Storage s){
        this.s = s;
    }

    public void run(){
        for(int i = 0; i <100; i++){
            s.sub(10);
        }
    }
}