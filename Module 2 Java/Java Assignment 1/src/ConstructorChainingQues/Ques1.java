package ConstructorChainingQues;


//Ques 1
/*Create a class Car with multiple constructors that initialize different attributes using
constructor chaining.
Problem Statement:
● Create a class Car with attributes brand, model, and price. ● Implement constructor chaining within the same class:
○ One constructor should only take the brand. ○ Another constructor should take brand and model. ○ The final constructor should take brand, model, and price. ● Use the this() keyword to call other constructors.
● Display car details in each constructor.
Task: Create objects using different constructors and observe constructor chaining in
action.*/
class Car {
    String brand;
    String model;
    int price;

    Car(String brand){
        this.brand = brand;
        System.out.println("Ques1\nBrand: " + brand);
    }
    Car(String brand, String model){
        this(brand);
        this.brand = brand;
        this.model = model;
        System.out.println("Brand: " + brand + ", Model: " + model);
    }
    Car(String brand, String model, int price){
        this(brand, model);
        this.brand = brand;
        this.model = model;
        this.price = price;
        System.out.println("Brand: " + brand + ", Model: " + model + ", Price: " + price);
    }
}


public class Ques1 {
    public static void main(String[] args) {
        //Ques 1
        Car c1 = new Car("BMW", "320d", 4800000);

    }
}
