package Inheritance;

class Person {
    String name;
    int age;
    Person(String name, int age){
        this.name = name;
        this.age = age;
    }
}

class Student extends Person {
    int rollNumber;
    int marks;
    Student(String name, int age, int rollNumber, int marks){
        super(name, age);
        this.rollNumber = rollNumber;
        this.marks = marks;
    }
    public String toString(){
        return "Student: " + name + "\nRollNo: " + rollNumber + "\nAge: " + age + "\nMarks: " + marks;
    }
}

public class Ques4 {
    public static void main(String[] args){
        Student s1 = new Student("Harshit", 22, 101, 96);
        System.out.println(s1);
    }
}
