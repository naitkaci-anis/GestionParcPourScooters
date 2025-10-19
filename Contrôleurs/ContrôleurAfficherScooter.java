package Contrôleurs;

import vue.FenetreAfficherScooter;
import Model.Scooter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContrôleurAfficherScooter implements ActionListener {

    private FenetreAfficherScooter fenetre;

    public ContrôleurAfficherScooter(FenetreAfficherScooter fenetre) {
        this.fenetre = fenetre;
        this.fenetre.getValiderBtn().addActionListener(this); // lie le bouton
    }

    public void actionPerformed(ActionEvent e) {
        JList<Scooter> liste = fenetre.getListScooters();
        Scooter selection = liste.getSelectedValue();

        if (selection == null) {
            JOptionPane.showMessageDialog(fenetre, "Veuillez sélectionner un scooter.");
            return;
        }

        String infos = "ID : " + selection.getIdScooter() +
                       "\nModèle : " + selection.getModele().getIdModele() +
                       "\nMarque : " + selection.getModele().getMarque().getIdMark() +
                       "\nKilométrage : " + selection.getKilometrage() + " km" +
                       "\nÉtat : " + (selection.estEnLocation() ? "En location" : "Disponible");

        JOptionPane.showMessageDialog(fenetre, infos);

        
    }
}
