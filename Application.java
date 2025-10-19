import vue.FenetrePrincipale;

import Model.Parc;
import Model.Marque;
import Model.Client;
import Model.Permis;
import Model.Scooter;
import Model.Modele;


public class Application {
    public static void main(String[] args) {
        // Parc
        Parc parc = new Parc("Parc des fenecs", 10, "9 boulevard d'Algérie, 75019");

        // Un echentillon pour lui associé les permis des modeles
        Client client1 = new Client("C0", "0000000000", "Echantillon", "Echantillon", parc);
        parc.addClient(client1);

        // Permis
        Permis permis1 = new Permis("P001", "A", client1);
        client1.addPermis(permis1);
        Permis permis2 = new Permis("P0010", "B", client1);
        client1.addPermis(permis2);
        Permis permis3 = new Permis("P002", "A1", client1);
        client1.addPermis(permis3);

        // Marques
        Marque marque1 = new Marque("Yamaha", parc);
        parc.addMarque(marque1);
        Marque marque2 = new Marque("Honda", parc);
        parc.addMarque(marque2);
        Marque marque3 = new Marque("BMW Motorrad", parc);
        parc.addMarque(marque3);
        Marque marque4 = new Marque("Peugeot", parc);
        parc.addMarque(marque4);
        Marque marque5 = new Marque("Piaggio", parc);
        parc.addMarque(marque5);

        // Modèles
        Modele modele1 = new Modele("MOD001", marque1, permis1);
        marque1.addModele(modele1);
        permis1.addModele(modele1);

        Modele modele2 = new Modele("MOD002", marque2, null);
        marque2.addModele(modele2);

        Modele modele3 = new Modele("ZIP50", marque4, null);
        marque4.addModele(modele3);

        Modele modele4 = new Modele("XMAX", marque1, permis3);
        marque1.addModele(modele4);
        permis3.addModele(modele4);

        Modele modele5 = new Modele("TMAX", marque1, permis2);
        marque1.addModele(modele5);

        // Scooters
        parc.addScooter(new Scooter("S001", modele1, parc));
        parc.addScooter(new Scooter("S002", modele2, parc));
        parc.addScooter(new Scooter("S003", modele4, parc));
        parc.addScooter(new Scooter("S004", modele3, parc));
        parc.addScooter(new Scooter("S005", modele2, parc));
        parc.addScooter(new Scooter("S006", modele5, parc));
        parc.addScooter(new Scooter("S007", modele5, parc));
        parc.addScooter(new Scooter("S008", modele2, parc));
        parc.addScooter(new Scooter("S009", modele1, parc));
        parc.addScooter(new Scooter("S0010", modele4, parc));
        
        new FenetrePrincipale(parc); 
    }
}
