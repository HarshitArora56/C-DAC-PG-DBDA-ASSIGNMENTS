package ConstructorChainingQues;
//Ques2
/*Constructor Chaining Using super Keyword (Parent-Child Relationship)
Create a class hierarchy where the child class calls the parent class constructor using
super(). Problem Statement:
● Create a Person class with attributes name and age. ● Create a Student class that extends Person and has an additional attribute course. ● Use constructor chaining:
● Person class should have a constructor initializing name and age. ○ Student class should use super(name, age) to call the Person constructor
and then initialize course.
● Display details in both constructors.

Task: Create a Student object and verify that both constructors (parent and child) are
executed in sequence.*/

class Person{
    String name;
    int age;
    Person(String name, int age){
        this.name = name;
        this.age = age;
        System.out.println("Name: " + name + ", Age: " + age);
    }
}
class Student extends Person {
    String course;
    Student(String name, int age, String course){
        super(name, age);
        this.course = course;
        System.out.println("Name: " + name + ", Age: " + age + ", Course: " + course);
    }
}


public class Ques2 {
    public static void main(String[] args) {
        Student std1 = new Student("Harshit Arora", 22, "CDAC");
    }
}
