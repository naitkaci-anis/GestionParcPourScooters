package Model;


import java.util.*;


public class Permis {

    private String idPermis;
    private String typePermis;
    private Vector<Modele> listModele = new Vector<Modele>();
    Client client;

    public Permis(String idPermis, String typePermis,Client client) {
        this.idPermis = idPermis;
        this.typePermis = typePermis;
        this.client = client;
    }

    public void addModele(Modele x){ listModele.add(x);}


    public String getIdPermis() { return idPermis; }
    public void setIdPermis(String idPermis) { this.idPermis = idPermis; }
    public String getTypePermis() { return typePermis; }
    public void setTypePermis(String typePermis) { this.typePermis = typePermis; }

 }