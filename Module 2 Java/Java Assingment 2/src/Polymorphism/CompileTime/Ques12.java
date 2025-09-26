package Polymorphism.CompileTime;

class Printer{
    public String print(String str){
        System.out.println("Print1: returns entered string...");
        return str;
    }
    public int print(int a){
        System.out.println("Print2: returns entered integer value...");
        return a;
    }

    public double print(double d){
        System.out.println("Print3: returns entered double value...");
        return d;
    }
}

public class Ques12 {
    public static void main(String[] args) {
        Printer p1 = new Printer();
        System.out.println(p1.print("Harshit"));
        System.out.println(p1.print(22));
        System.out.println(p1.print(80.78));
    }
}
