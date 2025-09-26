package Abstraction;

abstract class Employee{

    abstract double calculateSalary(int workingDays);
}

class FullTimeEmployee extends Employee {
    double baseSalary;
    FullTimeEmployee(double baseSalary){
        this.baseSalary = baseSalary;
    }
    public double calculateSalary(int workingDays){
        System.out.println("Calculating Salary of Full time Employee: ");
        return baseSalary * workingDays;
    }
}
class PartTimeEmployee extends Employee {
    double baseSalary;
    PartTimeEmployee(double baseSalary){
        this.baseSalary = baseSalary;
    }
    public double calculateSalary(int workingDays){
        System.out.println("Calculating Salary of Part time Employee: ");
        return baseSalary * workingDays;
    }
}

public class Ques24 {
    public static void main(String[] args) {
        Employee fte = new FullTimeEmployee(500);
        System.out.println(fte.calculateSalary(28));
        Employee pte = new PartTimeEmployee(200);
        System.out.println(pte.calculateSalary(20));
    }
}
