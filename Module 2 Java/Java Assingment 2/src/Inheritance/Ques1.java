package Inheritance;

class Animal{
    public void makeSound(){
        System.out.println("Some Animal Sound!");
    }
}
class Dog extends Animal{
    public void makeSound(){
        System.out.println("Overriding makeSound function of Animal Class");
        System.out.println("Bark");
    }
}

public class Ques1 {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.makeSound();

        Animal dog = new Dog();
        dog.makeSound();
    }
}
