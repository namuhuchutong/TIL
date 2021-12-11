package me.pepeprmill.java8Practice;

public class Car {

    public static void main(String[] args) {
        int num = 10;
        Vehicle car = name -> System.out.println(name);

        Vehicle car2 = new Vehicle() {
//            num++;
//            not allowed

            int num2 = 10; // 람다로 변환은 안됨.
            @Override
            public void printName(String name) {
//                num++;
//                not allowed

//                num2++;
//                allowed
                System.out.println(name);
            }
        };

        car.printName("hi?");
        System.out.println(car.getHorsePower(100000, 10));

        car2.printName("this is Car2");
    }
}
