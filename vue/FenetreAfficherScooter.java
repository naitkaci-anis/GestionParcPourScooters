package vue;

import javax.swing.*;
import java.awt.*;
import Model.Parc;
import java.util.Vector;
import Model.Scooter;
import Model.Parc;

public class FenetreAfficherScooter extends JFrame {
      private Parc parc;
      private JButton validerBtn;
      private JList <Scooter> scooters;
      private Vector<Scooter> listScooters;

      public FenetreAfficherScooter (Parc parc){
        this.parc = parc;
        listScooters = parc.getListScooter();
        setTitle("Affichage des scooter");
        setSize(400,400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

      JLabel titre = new JLabel ("Nos scooters");
      titre.setHorizontalAlignment(JLabel.CENTER);

     scooters = new JList <>(listScooters);
     JScrollPane scroll = new JScrollPane(scooters);

     validerBtn = new JButton("Valider");
     JPanel bas = new JPanel();
     bas.add(validerBtn);

     JPanel panelPr = new JPanel (new BorderLayout ());
     panelPr.add(titre, BorderLayout.NORTH);
     panelPr.add(scroll, BorderLayout.CENTER);
     panelPr.add(bas, BorderLayout.SOUTH);

     add(panelPr);
    setLocationRelativeTo(null);
     setVisible(true);


new Contrôleurs.ContrôleurAfficherScooter(this);

      }
      public JButton getValiderBtn() {
    return validerBtn;
}

public JList<Scooter> getListScooters() {
    return scooters;
}

}