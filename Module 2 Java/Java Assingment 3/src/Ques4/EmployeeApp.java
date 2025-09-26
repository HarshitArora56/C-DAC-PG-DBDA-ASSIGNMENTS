package Ques4;

import java.util.*;


interface EmployeeManager{
    void addNewEmployee(Employee emp);
    void updateDepartment(int empId);
    void removeEmployee(int empId);
    void displayAllEmployee();
}


class Employee{
    private String name;
    private int empId;
    private String department;

    Employee(int empId, String name, String department){
        this.name = name;
        this.empId = empId;
        this.department = department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    public String getName(){
        return name;
    }
    public int getEmpId(){
        return empId;
    }
    public String getDepartment(){
        return department;
    }
    @Override
    public String toString(){
        return String.format("EmpId: %-15d Name: %-25s Department: %s", empId, name,department);
    }

}

class EmployeeDatabase implements EmployeeManager{
    List<Employee> employees = new ArrayList<>();

    @Override
    public void addNewEmployee(Employee emp){
        employees.add(emp);
        System.out.println("Employee Added!");
    }

    @Override
    public void updateDepartment(int empId){
        Scanner sc = new Scanner(System.in);
        boolean found = false;
        for(Employee e : employees){
            if(e.getEmpId() == empId){
                System.out.print("Enter new Department for " + e.getName() + ": ");
                String newDept = sc.nextLine();
                System.out.println("Previous Department: " + e.getDepartment());
                e.setDepartment(newDept);
                System.out.println("New Department: " + newDept);
                System.out.println("Department Updated Successfully for EmpId: " + e.getEmpId() + "!");
                found = true;
                break;
            }
        }
        if (!found){
            System.out.println("Employee with EmpId: " + empId + " not found.");
        }
    }

    @Override
    public void removeEmployee(int empId){
        boolean isRemoved = false;
        for (int i = 0; i < employees.size(); i++) {
            Employee e = employees.get(i);
            if (e.getEmpId() == empId){
                employees.remove(i);
                isRemoved = true;
                System.out.println("Employee with EmpId: " + e.getEmpId() + " is successfully removed.");
                break;
            }
        }
        if(!isRemoved){
            System.out.println("Employee with EmpId: " + empId + " doesn't exists.");
        }
    }
    @Override
    public void displayAllEmployee(){
        if(employees.isEmpty()){
            System.out.println("There are no Employees in Database.");
        }else{
            for(Employee e : employees){
                System.out.println(e);
            }
        }
    }
}

class RemoteEmployee extends EmployeeDatabase{
    @Override
    public void addNewEmployee(Employee emp) {
        super.addNewEmployee(emp); // reuse base logic
        System.out.println("Remote sync: Employee added to cloud database.");
    }

    @Override
    public void updateDepartment(int empId) {
        super.updateDepartment(empId); // reuse base logic
        System.out.println("Remote sync: Department updated in cloud.");
    }

    @Override
    public void removeEmployee(int empId) {
        super.removeEmployee(empId); // reuse base logic
        System.out.println("Remote sync: Employee removed from cloud.");
    }

    @Override
    public void displayAllEmployee() {
        System.out.println("Fetching employee data from remote server...");
        super.displayAllEmployee(); // reuse base logic
    }

}

public class EmployeeApp {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        EmployeeManager employee = new EmployeeDatabase();
        EmployeeManager remoteEmployee = new RemoteEmployee();

        boolean running = true;

        while(running){
            System.out.println("\n--- Employee Database Management ---");
            System.out.println("1.) Add New Employee\n2.) Update Department\n3.) Remove Employee\n4.) Display All Employees\n5.) Exit");
            System.out.println("Choose: ");
            int choice = sc.nextInt(); sc.nextLine();
            switch(choice){
                case 1:
                    System.out.print("Employee ID (int): "); int empId = sc.nextInt(); sc.nextLine();
                    System.out.print("Employee Name: "); String name = sc.nextLine();
                    System.out.print("Employee Department: "); String dept = sc.nextLine();
                    employee.addNewEmployee(new Employee(empId, name, dept));
                    break;
                case 2:
                    System.out.print("Employee Id to Update Department: "); empId = sc.nextInt(); sc.nextLine();
                    employee.updateDepartment(empId);
                    break;
                case 3:
                    System.out.print("Employee Id to remove: "); empId = sc.nextInt(); sc.nextLine();
                    employee.removeEmployee(empId);
                    break;
                case 4:
                    employee.displayAllEmployee();
                    break;
                case 5:
                    running = false;
                    System.out.println("Exited!");
                    break;
                default:
                    System.out.println("Invalid Input!");
            }
        }
        sc.close();
    }
}
