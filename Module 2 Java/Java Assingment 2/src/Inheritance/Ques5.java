package Inheritance;

class Shape{

    public double area(){
        System.out.println("This method Calculates the area of the Shape.");
        return 0.0;
    }
}

class Circle extends Shape {
    double radius;
    Circle(double radius){
        this.radius = radius;
    }
    @Override
    public double area(){
        System.out.print("Area of Circle: ");
        return Math.PI * Math.pow(radius,2);
    }
}

class Rectangle extends Shape {
    double length;
    double breadth;
    Rectangle(double length, double breadth){
        this.length = length;
        this.breadth = breadth;
    }
    @Override
    public double area(){
        System.out.print("Area of Rectangle: ");
        return length * breadth;
    }
}

public class Ques5 {
    public static void main(String[] args) {

        Shape s1 = new Shape();
        s1.area();
        Circle c1 = new Circle(5.0);
        System.out.println(c1.area());
        Rectangle r1 = new Rectangle(6.0,8.0);
        System.out.println(r1.area());
    }
}
