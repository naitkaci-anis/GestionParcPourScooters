
package Model;


import java.time.LocalDate;



public class Location {

    private LocalDate dateDebut;
    private LocalDate dateFin;    
    Scooter scooter;
    Client client;
    Retour retour;

public Location(LocalDate dateDebut, LocalDate dateFin, Scooter scooter, Client client) {
    this.dateDebut = dateDebut;
    this.dateFin = dateFin;
    this.scooter = scooter;
    this.client = client;
    this.retour = null;
}

    public LocalDate getDateDebut() { return dateDebut; } 
    public void setDateDebut(LocalDate dateDebut) { this.dateDebut = dateDebut; }
    public LocalDate getDateFin() { return dateFin; }
    public void setDateFin(LocalDate dateFin) { this.dateFin = dateFin; }
    public Retour getRetour(){return retour;}
    public void setRetour(Retour retour){this.retour = retour;}
    public Scooter getScooter() { return scooter; }
    public void setScooter(Scooter scooter) { this.scooter = scooter; }
    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }

    public boolean chevauche(LocalDate debut, LocalDate fin) {//verifie si y a un chevauchement entre deux dates
    return !(dateFin.isBefore(debut) || dateDebut.isAfter(fin));
}

    
}
