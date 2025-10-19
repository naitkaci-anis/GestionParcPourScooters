package Model;


import java.time.LocalDate;
import java.util.*;

public class Parc {

    private String nomParc;
    private int nbrScooter;
    private String address;
    private Vector<Scooter> listScooter = new Vector<>();
    private Vector<Marque> listMarque = new Vector<>();
    private Vector<Client> listClient = new Vector<>();

    public Parc(String nomParc, int nbrScooter, String address) {
        this.nomParc = nomParc;
        this.nbrScooter = nbrScooter;
        this.address = address;
    }

    public void addScooter(Scooter x) { listScooter.add(x); }
    public void addMarque(Marque x) { listMarque.add(x); }
    public void addClient(Client x) { listClient.add(x); }

    public String getNomParc() { return nomParc; }
    public void setNomParc(String nomParc) { this.nomParc = nomParc; }
    public int getNbrScooter() { return nbrScooter; }
    public void setNbrScooter(int nbrScooter) { this.nbrScooter = nbrScooter; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public Vector<Client> getListClient() { return listClient; }
    public Vector<Scooter> getListScooter() { return listScooter; }

    public Modele trouverModeleById(String idModele) {//trouver un scooter avec son ID
        for (Marque marque : listMarque) {
            for (Modele modele : marque.getListModele()) {
                if (modele.getIdModele().equals(idModele)) {
                    return modele;
                }
            }
        }
        return null;
    }

    public Client getClientById(String idClient) {//trouver un client avec son ID
        for (Client c : listClient) {
            if (c.getIdClient().equals(idClient)) {
                return c;
            }
        }
        return null;
    }

    public Scooter getScooterById(String id) {//trouver un scooter avec son ID
        for (Scooter s : listScooter) {
            if (s.getIdScooter().equals(id)) {
                return s;
            }
        }
        return null;
    }

    
   public Vector<Scooter> getScootersDisponibles(LocalDate datdebut, LocalDate datfin, Client client) {//filtrer les scooter qui correspend aux dates données et aux permis des clients
    Vector<Scooter> affichageScoot = new Vector<>();
    for (Scooter s : listScooter) {
        Modele m = s.getModele();
        if (s.estDisponibleEntre(datdebut, datfin)) {
            if (m.permis == null || client.possedePermisDeType(m.permis.getTypePermis())) {
                affichageScoot.add(s);
            }
        }
    }
    return affichageScoot;
}


    public boolean louerScooter(Client client, Scooter scooter, LocalDate debut, LocalDate fin) {//retourne vrai si toutes les conditions de location sont satisfaites
        if (!scooter.estDisponibleEntre(debut, fin)) return false;
        if (scooter.getModele().permis != null && !client.possedePermisDeType(scooter.getModele().permis.getTypePermis())) {
            return false;
        }
        Location location = new Location(debut, fin, scooter, client);//si tout est bien vérifier on ajoute la location pour le scooter et le client 
        scooter.addLocation(location);
        client.addLocation(location);
        return true;
    }

   public boolean retourScooter(String idClient, String idScooter, LocalDate dateDebut, LocalDate dateFin, double km) {//retourne vrai si tous se passe bien pour le retour
    if (km < 0){ return false; }
    Client client = getClientById(idClient);
    if (client == null) return false;

    for (Location loc : client.getListLocation()) {
        if (loc.getRetour() == null
            && loc.getDateDebut().equals(dateDebut)
            && loc.getDateFin().equals(dateFin)
            && loc.getScooter().getIdScooter().equals(idScooter)) {

            Scooter scooter = loc.getScooter();
            scooter.ajouterKilometrage(km);

            Retour retour = new Retour(km, loc);
            loc.setRetour(retour);
            return true;
        }
    }

    return false;
}

}
