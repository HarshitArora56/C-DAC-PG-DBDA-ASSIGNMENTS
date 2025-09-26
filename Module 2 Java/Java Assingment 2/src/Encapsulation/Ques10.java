package Encapsulation;

class Patient {
    final private int id;
    private String name;
    private String disease;

    Patient(int id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setDisease(String disease){
        this.disease = disease;
    }

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getDisease(){
        return disease;
    }
}
public class Ques10 {
    public static void main(String[] args) {
        Patient p1 = new Patient(101);
        p1.setName("Suresh");
        p1.setDisease("Viral Fever");
        System.out.println("Id: " + p1.getId() + "\nName: " + p1.getName() + "\nDisease: " + p1.getDisease());

    }
}
