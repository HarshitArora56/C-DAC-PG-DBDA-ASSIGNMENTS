package Abstraction;

abstract class Vehicle {
    abstract void start();
}
class Car extends Vehicle {
    public void start(){
        System.out.println("Car is getting started...");
    }
}
class Bike extends Vehicle {
    public void start(){
        System.out.println("Bike is getting started...");
    }
}
public class Ques21 {
    public static void main(String[] args) {
        Vehicle car = new Car();
        car.start();
        Vehicle bike = new Bike();
        bike.start();
    }
}
