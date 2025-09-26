package Polymorphism.CompileTime;

class Shape {
    public void draw(){
        System.out.println("Draws a Shape");
    }
    public void draw(double radius){
        System.out.println("Draws a Circle with radius: " + radius);
        double p = 2*Math.PI*radius;
        System.out.println("Perimeter: " + p);
    }
    public void draw(int length, int breadth){
        System.out.println("Draws a Rectangle with length: " + length + ", Breadth: " + breadth);
        int p = 2*length*breadth;
        System.out.println("Perimeter: " + p);
    }
    public void draw(int side1, int side2, int side3){
        System.out.println("Draws a Triangle with side1: " + side1 + ", side2: " + side2 + ", side3: " + side3);
        int p = side1 + side2 + side3;
        System.out.println("Perimeter: " + p);
    }
}

public class Ques14 {
    public static void main(String[] args) {
        Shape s1 = new Shape();
        s1.draw();
        s1.draw(5);
        s1.draw(8,6);
        s1.draw(3,4,5);

    }
}
