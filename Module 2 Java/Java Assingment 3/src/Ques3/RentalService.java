package Ques3;
import java.util.*;

class Vehicle{
    private String make;
    private String model;
    private int year;

    Vehicle(String make, String model, int year){
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public void setMake(String make){
        this.make = make;
    }
    public void setModel(String model){
        this.model = model;
    }
    public void setYear(int year){
        this.year = year;
    }
    public String getMake(){
        return make;
    }
    public String getModel(){
        return model;
    }
    public int getYear(){
        return year;
    }
}
class Car extends Vehicle {
    private int numOfDoors;

    Car(String make, String model, int year, int numOfDoors){
        super(make, model, year);
        if(numOfDoors < 2 || numOfDoors > 6) throw new IllegalArgumentException("Number of Doors can be between 2 and 6");
        this.numOfDoors = numOfDoors;
    }
    Car(String make, String model){
        super(make, model, 2024);
        this.numOfDoors = 4;
    }

    public void setNumOfDoors(int numOfDoors){
        if(numOfDoors < 2 || numOfDoors > 6) throw new IllegalArgumentException("Number of Doors can be between 2 and 6");
        this.numOfDoors = numOfDoors;
    }
    public int getNumOfDoors(){
        return numOfDoors;
    }
}


public class RentalService {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Company: ");
        String company = sc.nextLine();
        System.out.print("Enter Model: ");
        String model = sc.nextLine();
        System.out.print("Enter Year: ");
        int year = sc.nextInt();
        System.out.print("Enter Number of Doors: ");
        int doors = sc.nextInt();
        Car car1 = new Car(company, model, year, doors);
        System.out.println("Car 1: " + car1.getMake() + " " + car1.getModel() + " (" + car1.getYear() + "), Doors: " + car1.getNumOfDoors());
        car1.setMake("Toyota");
        car1.setModel("Hilux");
        car1.setYear(2025);
        car1.setNumOfDoors(5);
        System.out.println("Car 1: " + car1.getMake() + " " + car1.getModel() + " (" + car1.getYear() + "), Doors: " + car1.getNumOfDoors());
    }
}
