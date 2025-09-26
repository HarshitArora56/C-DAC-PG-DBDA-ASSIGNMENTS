package Inheritance;


class Vehicle{
    String brand;
    double speed;
    Vehicle(String brand, double speed){
        this.brand = brand;
        this.speed = speed;
    }

}

class Car extends Vehicle{
    String fuelType;
    Car(String brand, double speed, String fuelType){
        super(brand, speed);
        this.fuelType = fuelType;
    }

    public void displayCarDetails(){
        System.out.println("Brand: " + brand + "\nFuel type: " + fuelType + "\nSpeed: " + speed + " Km/h");
    }
}
public class Ques2 {
    public static void main(String[] args){
        Car c = new Car("BMW", 100, "Diesel");
        c.displayCarDetails();
    }
}
