package Inheritance;

class Employee{
    String name;
    double salary;
    Employee(String name, double salary){
        this.name = name;
        this.salary = salary;
    }
}

class Manager extends Employee {
    double bonus;
    Manager(String name, double salary, double bonus){
        super(name, salary);
        this.bonus = bonus;
    }
    public double calSal(){
        System.out.print("Total Salary for Employee " + name + " is: ₹");
        return salary + bonus;
    }
}

public class Ques3 {
    public static void main (String[] args){
        Manager m = new Manager("Harshit", 50000.0, 3000.0);
        System.out.println(m.calSal());
    }
}
