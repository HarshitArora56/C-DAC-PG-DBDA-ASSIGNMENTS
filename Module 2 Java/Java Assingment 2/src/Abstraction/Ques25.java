package Abstraction;

abstract class Appliances{
    abstract void turnOn();
    abstract void turnOff();
}

class Fan extends Appliances {
    public void turnOn(){
        System.out.println("Fan turned On!");
    }
    public void turnOff(){
        System.out.println("Fan turned Off!");
    }
}
class Light extends Appliances {
    public void turnOn(){
        System.out.println("Light turned On!");
    }
    public void turnOff(){
        System.out.println("Light turned Off!");
    }
}
public class Ques25 {
    public static void main(String[] args){
        Appliances fan = new Fan();
        fan.turnOn();
        fan.turnOff();
        Appliances light = new Light();
        light.turnOn();
        light.turnOff();
    }
}
