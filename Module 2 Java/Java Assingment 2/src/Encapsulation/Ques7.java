package Encapsulation;

class Student {
    private String name;
    private double marks;


    public void setName(String name) {
        this.name = name;
    }
    public void setMarks(double marks) {
        this.marks = marks;
    }

    public String getName() {
        return name;
    }
    public double getMarks(){
        return marks;
    }
}
public class Ques7 {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setName("Harshit");
        s1.setMarks(90);
        System.out.println("Name: " + s1.getName() + "\nMarks: " + s1.getMarks());
    }
}
