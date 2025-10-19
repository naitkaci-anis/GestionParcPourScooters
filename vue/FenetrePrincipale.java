package vue;

import vue.FenetreLouer;
import javax.swing.*;
import java.awt.*;

import Model.Parc;

public class FenetrePrincipale extends JFrame {
        private Parc parc;
        private JButton louerBtn;
        private JButton retourBtn;
        private JButton etatBtn;
        private JButton parcBtn;
        private JButton saisieBtn;
        private JButton quitterBtn;

    public FenetrePrincipale(Parc parc) {
        this.parc = parc;

        setTitle("LOUSCOOT");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel titre = new JLabel("Menu principal");
        titre.setHorizontalAlignment(JLabel.CENTER);

         louerBtn = new JButton("Louer un scooter");
         retourBtn = new JButton("Retourner un scooter");
         etatBtn = new JButton("Afficher un scooter");
         parcBtn = new JButton("Afficher l’état du parc");
         saisieBtn = new JButton("Saisie du parc");
         quitterBtn = new JButton("Quitter");

        JPanel panel = new JPanel(new GridLayout(7,1));

        panel.add(titre);
        panel.add(louerBtn);
        panel.add(retourBtn);
        panel.add(etatBtn);
        panel.add(parcBtn);
        panel.add(saisieBtn);
        panel.add(quitterBtn);

        getContentPane().add(panel);

        setLocationRelativeTo(null);
        setVisible(true);

    
     new Contrôleurs.ContrôleurPrincipale(this, parc);

    } 

    public JButton getLouerBtn(){
        return louerBtn;
    }
    public JButton getRetourBtn(){
        return retourBtn;
    }
    public JButton getEtatBtn(){
        return etatBtn;
    }
    public JButton getParcBtn(){
        return parcBtn;
    }
    public JButton getSaisieBtn(){
        return saisieBtn;
    }
    public JButton getQuitterBtn(){
        return quitterBtn;
    }
}
