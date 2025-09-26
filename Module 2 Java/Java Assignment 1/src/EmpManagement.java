import java.util.Scanner;

class Employee1{
    private int salary;
    private int hoursPerDay;

    public void getInfo(int salary ,int hoursPerDay){
        this.salary = salary;
        this.hoursPerDay = hoursPerDay;
    }

    public int addSal(){
        if (salary < 500){
            salary += 10;
        }
        System.out.println("Salary increased by 10 if Salary is less than 500...");
        return salary;
    }

    public int addWork(){
        if (hoursPerDay > 6){
            salary += 5;
        }
        System.out.println("Salary increased by 5 if Working hours per day is more than 6...");
        return salary;
    }
    public String showFinalSalary(){
        return "Final Salary: " + salary;
    }
}

public class EmpManagement {
    public static void main(String[] args) {
        Employee1 emp1 = new Employee1();
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Your Salary: ");
        int s = in.nextInt();
        System.out.print("Enter Your Working Hours: ");
        int h = in.nextInt();
        emp1.getInfo(s,h);
        System.out.println(emp1.addSal());
        System.out.println(emp1.addWork());
        System.out.println(emp1.showFinalSalary());

    }
}
