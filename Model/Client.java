package Model;

import java.util.*;


public class Client {
    private String idClient;
    private String telephone;
    private String nom;
    private String prenom;
    Parc parc;
    private Vector<Location> listLocation = new Vector<Location>();
    private Vector<Permis> listPermis = new Vector<Permis>();

    public Client(String idClient, String telephone, String nom, String prenom,Parc p) {
        this.idClient = idClient;
        this.telephone = telephone;
        this.nom = nom;
        this.prenom = prenom;
        parc=p;
    }
    public void addPermis(Permis x){ listPermis.add(x);}
    public void addLocation(Location x){ listLocation.add(x);}

    public String getIdClient() { return idClient; }
    public void setIdClient(String idClient) { this.idClient = idClient; }
    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public Vector<Permis> getlistPermis () {
    return listPermis;
    }
    public Vector<Location> getListLocation() {
    return listLocation;  
    }


 public boolean possedePermisDeType(String typePermis) {
    for (Permis p : listPermis) {
        if (p.getTypePermis().equalsIgnoreCase(typePermis)) {
            return true;
        }
    }
    return false;
}

}
