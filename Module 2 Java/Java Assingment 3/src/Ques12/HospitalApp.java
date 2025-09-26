package Ques12;
import java.util.*;
//Patient Management System

interface PatientManager{
    void addPatient(Patient p);
    void removePatient(int patientID);
    void getPatientsByDiagnosis(String diagnosis);
    void getPatientsByStayDuration(int daysAdmitted);
}

class Patient {
    private final int patientId;
    private final String name;
    private final String diagnosis;
    private final int daysAdmitted;

    Patient(int patientId, String name, String diagnosis, int daysAdmitted){
        this.patientId = patientId;
        this.name = name;
        this.diagnosis = diagnosis;
        this.daysAdmitted = daysAdmitted;
    }

    public int getPatientId() {
        return patientId;
    }
    public String getName() {
        return name;
    }
    public String getDiagnosis() {
        return diagnosis;
    }
    public int getDaysAdmitted() {
        return daysAdmitted;
    }

    public String toString(){
        return String.format("Patient ID: %-10d Name: %-15s Diagnosis: %-15s Days Admitted: %-10d", patientId, name, diagnosis, daysAdmitted);
    }
}

class PatientDatabase implements PatientManager{
    List<Patient> patients = new ArrayList<>();

    @Override
    public void addPatient(Patient p){
        patients.add(p);
        System.out.println("Patient Added!");
    }
    @Override
    public void removePatient(int patientId){
        boolean isRemoved = false;
        for(int i = 0; i < patients.size(); i++){
            Patient p = patients.get(i);
            if (p.getPatientId() == patientId){
                patients.remove(i);
                System.out.println("Patient with PID: " + p.getPatientId() + " is successfully removed.");
                isRemoved = true;
                break;
            }
        }
        if(!isRemoved){
            System.out.println("No Patient exist for this PID in Database.");
        }
    }
    @Override
    public void getPatientsByDiagnosis(String diagnosis){
        boolean found = false;
        System.out.println("Patients with Diagnosis: " + diagnosis);
        for(Patient p : patients){
            if(p.getDiagnosis().equalsIgnoreCase(diagnosis)){
                System.out.println(p);
                found = true;
            }
        }
        if(!found) {
            System.out.println("No Patient found for the diagnosis.");
        }
    }
    @Override
    public void getPatientsByStayDuration(int daysAdmitted){
        boolean found = false;
        System.out.println("Patients Staying longer than: " + daysAdmitted + " days.");
        for(Patient p : patients){
            if(p.getDaysAdmitted() > daysAdmitted){
                System.out.println(p);
                found = true;
            }
        }
        if(!found) {
            System.out.println("No Patient is Admitted for this duration");
        }
    }
}

public class HospitalApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PatientManager patient = new PatientDatabase();
        boolean running = true;

        while(running){
            System.out.println("\n--- Patient Database ---");
            System.out.println("1.) Add Patient\n2.) Remove Patient\n3.) Filter Patients By Diagnosis\n4.) Filter Patients By Stay Duration\n5.) Exit");
            System.out.println("Choose: ");
            int choice = sc.nextInt(); sc.nextLine();
            switch(choice){
                case 1:
                    System.out.print("Enter Patient Id: "); int pid = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Name: "); String name = sc.nextLine();
                    System.out.print("Enter Diagnosis: "); String diagnosis = sc.nextLine();
                    System.out.print("Enter Stay Duration (in Days): "); int daysAdmitted = sc.nextInt(); sc.nextLine();
                    patient.addPatient(new Patient(pid, name, diagnosis, daysAdmitted));
                    break;
                case 2:
                    System.out.print("Enter Patient Id: "); pid = sc.nextInt(); sc.nextLine();
                    patient.removePatient(pid);
                    break;
                case 3:
                    System.out.print("Enter Diagnosis: "); diagnosis = sc.nextLine();
                    patient.getPatientsByDiagnosis(diagnosis);
                    break;
                case 4:
                    System.out.print("Input the number of days to identify patients admitted beyond that period: "); daysAdmitted = sc.nextInt(); sc.nextLine();
                    patient.getPatientsByStayDuration(daysAdmitted);
                    break;
                case 5:
                    running = false;
                    System.out.println("Exited!");
                    break;
                default:
                    System.out.println("Invalid Input!");
            }
        }
        sc.close();
    }
}
