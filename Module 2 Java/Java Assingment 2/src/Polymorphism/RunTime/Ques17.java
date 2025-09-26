package Polymorphism.RunTime;

class Vehicle{
    public void run(){
        System.out.println("This is a Run method in Vehicle class");
    }
}

class Car extends Vehicle{
    @Override
    public void run(){
        System.out.println("This is a Run method in Car class");
    }
}
class Bike extends Vehicle{
    @Override
    public void run(){
        System.out.println("This is a Run method in Bike class");
    }
}
public class Ques17 {
    public static void main(String[] args) {
        Vehicle v = new Vehicle();
        v.run();
        Vehicle v1 = new Car();
        v1.run();
        Vehicle v2 = new Bike();
        v2.run();
    }
}
