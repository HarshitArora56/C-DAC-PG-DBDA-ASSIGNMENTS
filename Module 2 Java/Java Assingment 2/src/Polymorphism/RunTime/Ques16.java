package Polymorphism.RunTime;

class Animal{
    public void speak(){
        System.out.println("Sound of an Animal..");
    }
}
class Dog extends Animal{
    @Override
    public void speak(){
        System.out.println("Bark..");
    }
}
class Cat extends Animal{
    @Override
    public void speak(){
        System.out.println("Meow..");
    }
}

public class Ques16 {
    public static void main(String[] args) {
        Animal a = new Animal();
        a.speak();
        Animal d1 = new Dog();
        d1.speak();
        Animal c1 = new Cat();
        c1.speak();
    }
}
