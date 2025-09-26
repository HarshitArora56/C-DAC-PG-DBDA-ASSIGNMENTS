package Polymorphism.CompileTime;

class Calculator {
    public int multiply(int a, int b){
        System.out.println("Multiply1: returns multiplication of two integers...");
        return a*b;
    }
    public double multiply(double a, double b){
        System.out.println("Multiply2: returns multiplication of two doubles...");
        return a*b;
    }
    public double multiply(int a, double b){
        System.out.println("Multiply3: returns multiplication of one integer and one double...");
        return a*b;
    }
}


public class Ques13 {
    public static void main(String[] args) {
        Calculator c1 = new Calculator();
        System.out.println(c1.multiply(6,5));
        System.out.println(c1.multiply(31.2,17.6));
        System.out.println(c1.multiply(48,5.58));

    }
}
