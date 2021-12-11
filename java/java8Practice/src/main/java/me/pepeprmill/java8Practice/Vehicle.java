package me.pepeprmill.java8Practice;

@FunctionalInterface
public interface Vehicle {

    void printName(String name);

    default int getHorsePower(int RPM, int torque) {
        return (RPM * torque) / 5252;
    }

    default void hi() {
        System.out.println("hi");
    }

    static String hello(String str) {
        return str + " hello";
    }

}
