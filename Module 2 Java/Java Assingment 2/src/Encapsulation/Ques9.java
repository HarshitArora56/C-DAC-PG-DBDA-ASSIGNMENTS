package Encapsulation;

class Laptop {
    private String brand;
    private double price;

    public void setBrands(String brand){
        this.brand = brand;
    }

    public void setPrice(double price){
        if (price >= 0.0){
            this.price = price;
        } else {
            System.out.println("Invalid Price, Setting to 0.0 by default");
            this.price = 0.0;
        }
    }
    public String getBrands(){
        return brand;
    }
    public double getPrice(){
        return price;
    }

}
public class Ques9 {
    public static void main(String[] args){
        Laptop l1 = new Laptop();
        l1.setBrands("Lenovo");
        l1.setPrice(80000);
        System.out.println("Brand: " + l1.getBrands() + "\nPrice: " + l1.getPrice());
        Laptop l2 = new Laptop();
        l2.setBrands("Dell");
        l2.setPrice(-2);
        System.out.println("Brand: " + l2.getBrands() + "\nPrice: " + l2.getPrice());
    }
}
