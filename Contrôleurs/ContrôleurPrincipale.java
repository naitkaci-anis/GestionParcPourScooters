package Contrôleurs;

import vue.FenetrePrincipale;
import vue.FenetreRetour;
import vue.FenetreAfficherScooter;
import vue.FenetreIdentificationClient;
import vue.FenetreEtatParc;

import Model.Parc;
import Model.Scooter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ContrôleurPrincipale implements ActionListener {

    private FenetrePrincipale vue;
    private Parc parc;

    public ContrôleurPrincipale(FenetrePrincipale vue, Parc parc) {
        this.parc = parc;
        this.vue = vue;

        vue.getLouerBtn().addActionListener(this);
        vue.getRetourBtn().addActionListener(this);
        vue.getEtatBtn().addActionListener(this);
        vue.getQuitterBtn().addActionListener(this);
        vue.getParcBtn().addActionListener(this);
        vue.getSaisieBtn().addActionListener(this);
    
    }

    
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == vue.getLouerBtn()) {
            new FenetreIdentificationClient(parc);
        } else if (source == vue.getRetourBtn()) {
            new FenetreRetour(parc);
        } else if (source == vue.getEtatBtn()){
            new FenetreAfficherScooter(parc);
        }else if (source == vue.getSaisieBtn()) {
            int total = parc.getListScooter().size();
            int disponibles = 0;
            int enLocation = 0;
            double totalKm = 0;
            double kmMoy = 0;

            for (Scooter s : parc.getListScooter()) {
                if (!s.estEnLocation()) {
                    disponibles++;
                }else {
                    enLocation++;
                }
                totalKm += s.getKilometrage();
            }
                kmMoy = totalKm / total;


            String message = "     Informations sur notre parc :\n\n" +
                    "Nom : " + parc.getNomParc() + "\n" +
                    "Adresse : " + parc.getAddress() + "\n" +
                    "Nombre total de scooters : " + total + "\n" +
                    "Scooters disponibles : " + disponibles + "\n" +
                    "Scooters en location : " + enLocation + "\n" +
                    "Kilométrage moyen : " + String.format("%.2f", kmMoy) + " km\n" +
                    " ";

            JOptionPane.showMessageDialog(vue, message, "État du parc", JOptionPane.INFORMATION_MESSAGE);
        }else if (source == vue.getParcBtn()){
            new FenetreEtatParc(parc);
        }else if (source == vue.getQuitterBtn()){
            System.exit(0);
        }
        
        
    }
}
