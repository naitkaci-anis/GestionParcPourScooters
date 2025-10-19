package Model;


import java.util.*;


public class Modele {

    private String idModele;
    Marque marque;
    Permis permis;
    private Vector<Scooter> listScooter = new Vector<Scooter>();

    public Modele(String idModele, Marque marque ,Permis permis) {
        this.idModele = idModele;
        this.marque = marque;
        this.permis =  permis;
    }
    public void addScooter(Scooter x){ listScooter.add(x);}

    public String getIdModele() { return idModele; }
    public void setIdModele(String idModele) { this.idModele = idModele; }
    public Marque getMarque() { return marque; }
    public void setMarque(Marque marque) { this.marque = marque; }

}