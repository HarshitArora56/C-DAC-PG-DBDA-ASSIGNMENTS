package ConstructorChainingQues;
/*Multi-Level Constructor Chaining (Grandparent → Parent → Child) Demonstrate constructor chaining in a multi-level inheritance scenario. Problem Statement:
● Create a Vehicle class with an attribute type.
● Create a subclass FourWheeler with an additional attribute brand. ● Create another subclass Car with attributes model and price.
● Use multi-level constructor chaining:
● Vehicle initializes type.
● FourWheeler calls super(type) and initializes brand.
● Car calls super(type, brand), initializes model, and price.
● Display details at each level.
Task: Create a Car object and verify that constructors are executed from parent → child  → grandchild.
*/

class Vehicle {
    String type;
    Vehicle(String type){
        this.type = type;
        System.out.println("Type: " + type);
    }
}

class FourWheeler extends Vehicle{
    String brand;
    FourWheeler(String type,String brand){
        super(type);
        this.brand = brand;
        System.out.println("Type: " + type + ", Brand: " + brand);
    }
}
class Car1 extends FourWheeler{
    String model;
    int price;
    Car1(String type, String brand, String model, int price){
        super(type,brand);
        this.model = model;
        this.price = price;
        System.out.println("Type: " + type + ", Brand: " + brand + ", Model: " + model + ", Price: " + price);
    }
}

public class Ques3 {
    public static void main(String[] args) {
        Car1 c2 = new Car1("Land Vehicle", "Audi", "R8S", 10000000);
    }
}
