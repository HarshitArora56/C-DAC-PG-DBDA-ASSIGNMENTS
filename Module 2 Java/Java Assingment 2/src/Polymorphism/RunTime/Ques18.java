package Polymorphism.RunTime;

class Bank {
    public double getInterestRate(){
        System.out.println("Bank: Providing base interest rate.");
        return 0.0;
    }
}
class SBI extends Bank {
    @Override
    public double getInterestRate(){
        System.out.println("SBI: Offering competitive interest rate for savings.");
        return 6.5;
    }
}
class HDFC extends Bank {
    @Override
    public double getInterestRate(){
        System.out.println("HDFC: Premium banking experience with higher returns.");
        return 7.0;
    }
}
class ICICI extends Bank {
    @Override
    public double getInterestRate(){
        System.out.println("ICICI: Balanced interest rate for modern banking.");
        return 6.75;
    }
}
public class Ques18 {
    public static void main(String[] args) {
        Bank b = new Bank();
        Bank sbi = new SBI();
        Bank hdfc = new HDFC();
        Bank icici = new ICICI();

        System.out.println("Bank Base Interest Rate: " + b.getInterestRate() + "%\n");
        System.out.println("SBI Interest Rate: " + sbi.getInterestRate() + "%\n");
        System.out.println("HDFC Interest Rate: " + hdfc.getInterestRate() + "%\n");
        System.out.println("ICICI Interest Rate: " + icici.getInterestRate() + "%\n");


    }
}
