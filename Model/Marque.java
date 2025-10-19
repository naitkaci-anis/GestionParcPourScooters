
package Model;

import java.util.*;


public class Marque {

 
    private String idMark;
    Parc parc;
    private Vector<Modele> listModele = new Vector<Modele>();

    public Marque(String idMark,Parc parc) {
        this.idMark = idMark;
        this.parc = parc;
    }
    public void addModele(Modele x){ listModele.add(x);}

    public String getIdMark() { return idMark; }
    public void setIdMark(String idMark) { this.idMark = idMark; }
    public Vector<Modele> getListModele() {
    return listModele;
}

}
