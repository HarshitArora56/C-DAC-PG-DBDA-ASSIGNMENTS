package Abstraction;

abstract class Shape{
    abstract double calculateArea();
}

class Circle extends Shape {
    double radius;

    Circle(double radius){
        this.radius = radius;
    }
    public double calculateArea(){

        System.out.println("Calculating area of circle with radius: " + radius);
        return Math.PI * Math.pow(radius,2);
    }
}
class Rectangle extends Shape{
    double length;
    double breadth;

    Rectangle(double length, double breadth){
        this.length = length;
        this.breadth = breadth;
    }
    public double calculateArea(){
        System.out.println("Calculating the area of Rectangle with length: " + length + ", breadth: " + breadth);
        return length * breadth;
    }
}
public class Ques22 {
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        System.out.println("Area = " + circle.calculateArea());
        Shape rectangle = new Rectangle(9.2,5.4);
        System.out.println("Area = " + rectangle.calculateArea());
    }
}
