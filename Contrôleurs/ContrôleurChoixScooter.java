package Contrôleurs;

import vue.FenetreChoixScooter;
import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import Model.*;

public class ContrôleurChoixScooter implements ActionListener {
    private Parc parc;

    private FenetreChoixScooter vue;
    private JButton validerBtn;
    private JList<Scooter> listScooters;

    public ContrôleurChoixScooter(FenetreChoixScooter vue, Parc parc) {
        this.parc = parc;
        this.vue = vue;
        this.validerBtn = vue.getValiderBtn();
        this.listScooters = vue.getListScooters();

        validerBtn.addActionListener(this); 
    }

    public void actionPerformed(ActionEvent e) {
        Scooter choisi = listScooters.getSelectedValue();

        if (choisi == null) {
            JOptionPane.showMessageDialog(vue, "Veuillez sélectionner un scooter.");
            return;
        }

        Client client = parc.getClientById(vue.getIdClient());
        LocalDate debut = vue.getDateDebut();
        LocalDate fin = vue.getDateFin();

        boolean ok = parc.louerScooter(client, choisi, debut, fin);

        if (ok) {
            JOptionPane.showMessageDialog(vue, "Scooter loué avec succès !");
            vue.dispose();
            new vue.FenetrePrincipale(parc);
        } else {
            JOptionPane.showMessageDialog(vue, "Échec de la location.");
        }
    }
}
