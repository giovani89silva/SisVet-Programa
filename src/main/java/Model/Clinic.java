package Model;

import java.util.ArrayList;

public class Clinic {

    private int Id;
    private String Name;

    private ArrayList<Vet> Vets
            = new ArrayList<Vet>();

    private ArrayList<Animal> Animals
            = new ArrayList<Animal>();

    private ArrayList<Attendance> Attendances
            = new ArrayList<Attendance>();

    public Clinic() {
    }

    public Clinic(int Id, String Name) {
        this.Id = Id;
        this.Name = Name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public ArrayList<Vet> getVets() {
        return Vets;
    }

    public void setVets(ArrayList<Vet> Vets) {
        this.Vets = Vets;
    }

    public ArrayList<Animal> getAnimals() {
        return Animals;
    }

    public void setAnimals(ArrayList<Animal> Animals) {
        this.Animals = Animals;
    }

    public ArrayList<Attendance> getAttendances() {
        return Attendances;
    }

    public void setAttendances(ArrayList<Attendance> Attendances) {
        this.Attendances = Attendances;
    }

}
