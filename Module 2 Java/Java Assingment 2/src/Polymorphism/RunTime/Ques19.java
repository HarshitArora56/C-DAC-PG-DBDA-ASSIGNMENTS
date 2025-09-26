package Polymorphism.RunTime;

class Phone{
    public void call(){
        System.out.println("Phone Call");
    }
}
class SmartPhone extends Phone {
    @Override
    public void call(){
        System.out.println("This is a call from smartphone");
    }
}
class Landline extends Phone {
    @Override
    public void call(){
        System.out.println("This is a call from Landline");
    }
}

public class Ques19 {
    public static void main(String[] args) {
        Phone p = new Phone();
        Phone sp = new SmartPhone();
        Phone ll = new Landline();

        p.call();
        sp.call();
        ll.call();
    }
}
