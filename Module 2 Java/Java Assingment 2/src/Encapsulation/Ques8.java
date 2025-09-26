package Encapsulation;

class Car {
    private String model;
    private int year;
    private double price;

    public void setModel(String model) {
        this.model = model;
    }
    public void setYear(int year){
        this.year = year;
    }
    public void setPrice(double price){
        this.price = price;
    }

    public String getModel(){
        return model;
    }
    public int getYear(){
        return year;
    }
    public double getPrice() {
        return price;
    }
}

public class Ques8 {
    public static void main(String[] args) {
        Car c1 = new Car();
        c1.setModel("Audi Q7");
        c1.setYear(2025);
        c1.setPrice(8000000.0);
        System.out.println("Model: " + c1.getModel() + "\nYear: " + c1.getYear() + "\nPrice: " + c1.getPrice());
    }
}
