import java.util.*;

//Ques 1 & 2
class Student{
    String name;
    int roll_no;
    String address;
    long phone;

    Student(String name, int roll_no, String address, long phone){
        this.name = name;
        this.roll_no = roll_no;
        this.address = address;
        this.phone =  phone;
    }

    void display(){
        System.out.println("Name: " + name + ", Roll no: " + roll_no + ", Address: " + address + ", Phone: " + phone);
    }
}

//Ques 3 & 4
class Triangle{

    int side1;
    int side2;
    int side3;

    //Write a program to print the area and perimeter of a triangle having sides of 3, 4 and 5 units by
    //creating a class named 'Triangle' without any parameter in its constructor.

    Triangle(){}
    //Ques 4 Write a program to print the area and perimeter of a triangle having sides of 3, 4 and 5 units by
    //creating a class named 'Triangle' with the constructor having the three sides as its parameters.
    Triangle(int side1, int side2, int side3){
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    double calPerimeter3(int side1, int side2, int side3){
        return side1 + side2 + side3;
    }

    double calArea3(int side1, int side2, int side3){
        double sP = calPerimeter3(side1, side2, side3)/2;
        return Math.sqrt(sP*(sP - side1) * (sP - side2) * (sP-side3));
    }

    double calPerimeter4(){
        return side1 + side2 + side3;
    }

    double calArea4(){
        double sP = calPerimeter3(side1, side2, side3)/2;
        return Math.sqrt(sP*(sP - side1) * (sP - side2) * (sP-side3));
    }
}



//Ques 5
class Rectangle {
    int length;
    int breadth;

    Rectangle(int length, int breadth){
        this.length = length;
        this.breadth = breadth;
    }

    String area(){
        double area = length * breadth;
        return "Length: " + length + ", Breadth: " + breadth + ", Area1: " + area;
    }
}

//Ques 6
class Area1 {
    int length;
    int breadth;

    void setDim(int length, int breadth){
        this.length = length;
        this.breadth = breadth;
    }
    String getArea(){
        double area = length * breadth;
        return "Length: " + length + ", Breadth: " + breadth + ", Area1: " + area;
    }
}

//Ques 7
class Area2{
    int length;
    int breadth;

    Area2 (int length, int breadth){
        this.length = length;
        this.breadth = breadth;
    }
    String returnArea(){
        double area = length * breadth;
        return "Length: " + length + ", Breadth: " + breadth + ", Area1: " + area;
    }
}

//Ques 8
class Average {
    double calAverage(int num1, int num2, int num3){
        return (num1 + num2 + num3)/3.0;
    }
}

//Ques 9
class Complex{
    int real1;
    int real2;
    int imag1;
    int imag2;
    Complex(int real1, int imag1, int real2, int imag2){
        this.real1 = real1;
        this.real2 = real2;
        this.imag1 = imag1;
        this.imag2 = imag2;
    }
    public String add(){
        int addReal = real1 + real2;
        int addComplex = imag1 + imag2;
        return "Added Complex Number: " + addReal + "+" + addComplex + "i";
    }
    public String sub(){
        int addReal = real1 - real2;
        int addComplex = imag1 - imag2;
        return "Subtract Complex Number: " + addReal + (addComplex >= 0 ? "+" : "-") + Math.abs(addComplex) + "i";
    }
    public String mul(){
        int mulReal = real1 * real2;
        int mulImag = imag1 * imag2;
        int finalReal = mulReal - mulImag;
        int mulRealImag = (real1 * imag2) + (real2 * imag1);
        return "Multiply Complex Number: " + finalReal + "+" + mulRealImag + "i";
    }
}

//Ques 10
class Employee {
    String name;
    int yearOfJoining;
    int salary;
    String address;
    Employee(String name, int yearOfJoining, int salary, String address){
        this.name = name;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
        this.address = address;
    }
    public String toString(){
        return name + " \t\t " + yearOfJoining + " \t\t\t " + salary + " \t\t " + address;
    }
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("John", 2, "A2",9876543210L);
        Student s2 = new Student("Sam", 3, "B2",1234567890L);
        System.out.println("Ques 1 & 2");
        s1.display();
        s2.display();

        //Ques 3 without passing parameters in constructor
        Triangle t1 = new Triangle();
        System.out.println("Ques3\nPerimeter: " + t1.calPerimeter3(3,4,5));
        System.out.println("Area1: " + t1.calArea3(3,4,5));

        //Ques 4 with passing values in the constructor
        Triangle t2 = new Triangle(3,4,5);
        System.out.println("Ques4\nPerimeter: " + t2.calPerimeter4());
        System.out.println("Area1: " + t2.calArea4());

        //Ques 5
        Rectangle r1 = new Rectangle(4,5);
        Rectangle r2 = new Rectangle(5,8);

        System.out.println("Ques 5");
        System.out.println(r1.area());
        System.out.println(r2.area());

        //Ques 6
        System.out.println("Ques 6");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter length of rectangle: ");
        int l = sc.nextInt();
        System.out.print("Enter breadth of rectangle: ");
        int b = sc.nextInt();

        Area1 a1 = new Area1();
        a1.setDim(l,b);
        System.out.println(a1.getArea());


        //Ques 7
        System.out.println("Ques 7");
        System.out.print("Enter length of rectangle: ");
        int l1 = sc.nextInt();
        System.out.print("Enter breadth of rectangle: ");
        int b1 = sc.nextInt();
        Area2 a2 = new Area2(l1,b1);
        System.out.println(a2.returnArea());

        //Ques 8
        System.out.println("Ques 8");
        System.out.print("Enter num1: ");
        int n1 = sc.nextInt();
        System.out.print("Enter num2: ");
        int n2 = sc.nextInt();
        System.out.print("Enter num3: ");
        int n3 = sc.nextInt();
        Average avg1 = new Average();
        System.out.println("Average: " + avg1.calAverage(n1,n2,n3));

        //Ques 9
        Complex c1 = new Complex(8,2,9,5);
        System.out.println(c1.add());
        System.out.println(c1.sub());
        System.out.println(c1.mul());
        //Ques 10
        Employee e1 = new Employee("Robert", 1994, 500000, "64C-WallsStreet");
        Employee e2 = new Employee("Sam", 2000, 600000, "68D-WallsStreet");
        Employee e3 = new Employee("John", 1999, 700000, "26B-WallsStreet");
        System.out.println("Ques 10");
        System.out.println("Name \t Year of Joining \t Salary \t\t Address");
        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e3);
    }
}
