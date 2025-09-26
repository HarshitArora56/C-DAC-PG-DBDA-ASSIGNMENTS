package Polymorphism.CompileTime;

class MathOperations {
    public int add(int a, int b){
        System.out.println("Add1, adding two integers...");
        return a + b;
    }
    public int add(int a, int b, int c){
        System.out.println("Add2, adding three integers...");
        return a + b + c;
    }
    public double add(double a, double b){
        System.out.println("Add3, adding two doubles...");
        return a + b;
    }
}
public class Ques11 {
    public static void main(String[] args) {
        MathOperations mo1 = new MathOperations();
        System.out.println(mo1.add(56,44));
        System.out.println(mo1.add(45,32,80));
        System.out.println(mo1.add(87.2, 54.89));

    }
}
