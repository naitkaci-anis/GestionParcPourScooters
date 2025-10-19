package Model;



import java.util.*;
import java.time.LocalDate;


public class Scooter {

    private String idScooter;
    private double kilometrage;
    Modele modele;
    Parc parc;
    private Vector<Location> listLocation = new Vector<Location>();

    public Scooter(String idScooter, Modele modele,Parc parc) {
        this.idScooter = idScooter;
        this.modele = modele;
        this.parc = parc;
    }

    public void addLocation(Location x){ listLocation.add(x);}

    public String getIdScooter() { return idScooter; }
    public double getKilometrage() { return kilometrage; }
    public void setKilometrage(double kilometrage) { this.kilometrage = kilometrage; }
    public void setIdScooter(String idScooter) { this.idScooter = idScooter; }
    public Modele getModele() { return modele; }
    public Vector<Location> getlistLocation() { return listLocation; }

    public boolean estEnLocation() {//vérifie si le scooter est en location en ce momment 
    if (listLocation.isEmpty()) return false;

    Location loc = listLocation.lastElement();
    if (loc.getRetour() != null) return false;

    LocalDate aujourdHui = LocalDate.now();
    return !aujourdHui.isBefore(loc.getDateDebut()) && !aujourdHui.isAfter(loc.getDateFin());
}

    public void ajouterKilometrage(double km) {
    this.kilometrage += km;
}


    public boolean estDisponibleEntre(LocalDate debut, LocalDate fin) {//vérifie si le scooter est disponible entre deux dates
    for (Location loc : listLocation) {
        if (loc.getRetour() == null && loc.chevauche(debut, fin)) {
            return false;
        }
    }
    return true;
}


public String toString() {
    return idScooter + " - " + modele.getIdModele() + " - " + modele.getMarque().getIdMark();
}
    
}
