package Contrôleurs;

import vue.FenetreChoixDate;
import vue.FenetreChoixScooter;

import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Vector;

import Model.Client;
import Model.Scooter;
import Model.Parc;

public class ContrôleurChoixDate implements ActionListener {
    private Parc parc;

    private FenetreChoixDate vue;

    public ContrôleurChoixDate(FenetreChoixDate vue, Parc parc) {
        this.vue = vue;
        this.parc = parc;
        
        this.vue.getValiderBtn().addActionListener(this); 
    }

    public void actionPerformed(ActionEvent e) {
        String dateDebutTxt = vue.getDateDebutField().getText().trim();
        String dateFinTxt = vue.getDateFinField().getText().trim();

        if (dateDebutTxt.isEmpty() || dateFinTxt.isEmpty()) {
            JOptionPane.showMessageDialog(vue, "Veuillez remplir les deux dates.");
            return;
        }

        try {
            LocalDate dateDebut = LocalDate.parse(dateDebutTxt);
            LocalDate dateFin = LocalDate.parse(dateFinTxt);

            if (dateDebut.isAfter(dateFin)) {
                JOptionPane.showMessageDialog(vue, "La date de début doit être avant la date de fin.");
                return;
            }

            LocalDate aujourdHui = LocalDate.now();
            if (dateDebut.isBefore(aujourdHui)) {
                JOptionPane.showMessageDialog(vue, "La date de début est passée !");
                return;
            }

            Vector<Client> clients = parc.getListClient();
            if (clients.isEmpty()) {
                JOptionPane.showMessageDialog(vue, "Aucun client trouvé.");
                return;
            }

            Client dernierClient = clients.lastElement();
            Vector<Scooter> disponibles = parc.getScootersDisponibles(dateDebut, dateFin, dernierClient);

            if (disponibles.isEmpty()) {
                JOptionPane.showMessageDialog(vue, "Aucun scooter disponible pour ces dates.");
            } else {
                new FenetreChoixScooter(disponibles, dernierClient.getIdClient(), dateDebut, dateFin, parc);
                vue.dispose();
            }

        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(vue, "Format de date invalide. Utilisez aaaa-mm-jj.");
        }
    }
}
