package Polymorphism.RunTime;

class Browser {
    public void openWebsite(){
        System.out.println("Opening Website in Browser...");
    }
}

class Chrome extends Browser {
    public void openWebsite(){
        System.out.println("Opening Website in Chrome Browser...");
    }
}

class Firefox extends Browser {
    public void openWebsite(){
        System.out.println("Opening Website in Firefox Browser...");
    }
}
public class Ques20 {
    public static void main(String[] args) {
        Browser b = new Browser();
        Browser chrome = new Chrome();
        Browser firefox = new Firefox();

        b.openWebsite();
        chrome.openWebsite();
        firefox.openWebsite();
    }
}
