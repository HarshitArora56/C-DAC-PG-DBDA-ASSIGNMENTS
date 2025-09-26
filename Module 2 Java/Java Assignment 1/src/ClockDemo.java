//OOPs Question Assignment 4 & 5

import java.util.Scanner;

class Clock {
    private int hours;
    private int minutes;
    private int seconds;
    Clock(){
        hours = 12;
        minutes = 0;
        seconds = 0;
    }

    Clock(int hours, int minutes, int seconds){
        this.hours = hours % 24; // range 0-23
        this.minutes = minutes % 60; // range 0-59
        this.seconds = seconds % 60; // range 0-59
    }
    Clock(int totalSeconds){
        setClock(totalSeconds);
    }
    public void setClock(int totalSeconds){
        totalSeconds = ((totalSeconds % 86400) + 86400) % 86400; // total seconds in 24 hours is 86400 so wrap around condition
        this.hours = totalSeconds / 3600;
        totalSeconds %= 3600;
        this.minutes = totalSeconds / 60;
        this.seconds = totalSeconds % 60;
    }

    public int getHours(){
        return hours;
    }
    public int getMinutes(){
        return minutes;
    }
    public int getSeconds(){
        return seconds;
    }
    public void setHours(int hours){
        this.hours = ((hours % 24) + 24) % 24; // range 0-23
    }
    public void setMinutes(int minutes){
        this.minutes = ((minutes % 60) + 60) % 60; // range 0-59
    }
    public void setSeconds(int seconds){
        this.seconds = ((seconds % 60) + 60) % 60; // range 0-59
    }
    public int toSeconds(){
        return hours * 3600 + minutes * 60 + seconds;
    }
    public void tick(){
        setClock(toSeconds() + 1);
    }
    public void tickDown(){
        setClock(toSeconds() - 1);
    }
    public Clock addClock(Clock c){
        return new Clock(this.toSeconds() + c.toSeconds());
    }

    public Clock subtractClock(Clock c){
        return new Clock(this.toSeconds() - c.toSeconds());
    }

    public String toString(){
        return String.format("%02d:%02d:%02d", getHours(), getMinutes(), getSeconds());
    }
}

public class ClockDemo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Clock firstClock = new Clock(70000);
        System.out.println("First Clock Ticking...");
        for(int i = 0; i < 10; i++){
            firstClock.tick();
            System.out.println("Clock Ticking: " + firstClock);
        }
        System.out.print("Enter Hours: ");
        int h = in.nextInt();
        System.out.print("Enter Minutes: ");
        int m = in.nextInt();
        System.out.print("Enter Seconds: ");
        int s = in.nextInt();
        Clock secondClock = new Clock(h,m,s);
        System.out.println("Second Clock Ticking...");
        for(int i = 0; i < 10; i++){
            secondClock.tick();
            System.out.println("Clock Ticking: " + secondClock);
        }

        System.out.println("Adding second clock Time in first clock-> " + firstClock.addClock(secondClock));
        System.out.println("First Clock Time-> " + firstClock);
        System.out.println("Second Clock Time-> " + secondClock);

        Clock thirdClock = firstClock.subtractClock(secondClock);
        System.out.println("Difference of firstClock and secondClock");
        System.out.println(thirdClock);
    }
}
