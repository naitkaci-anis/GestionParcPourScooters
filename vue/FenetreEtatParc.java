package vue;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;
import Model.Scooter;
import Model.Modele;
import Model.Parc;;

public class FenetreEtatParc extends JFrame {
    private Parc parc;
    

    public FenetreEtatParc(Parc parc) {
        this.parc = parc;
        setTitle("État du parc");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel titre = new JLabel("État du parc de scooters");
        titre.setHorizontalAlignment(JLabel.CENTER);

        
        String[] colonnes = {"ID", "Modèle", "Marque", "Kilométrage", "État"};

        
        Vector<Scooter> scooters = parc.getListScooter();
        String[][] donnees = new String[scooters.size()][5];

        for (int i = 0; i < scooters.size(); i++) {
            Scooter s = scooters.get(i);
            donnees[i][0] = s.getIdScooter();
            donnees[i][1] = s.getModele().getIdModele();
            donnees[i][2] = s.getModele().getMarque().getIdMark(); 
            donnees[i][3] = s.getKilometrage() + " km";
            donnees[i][4] = s.estEnLocation() ? "En location" : "Disponible";
        }

        JTable table = new JTable(donnees, colonnes);
        JScrollPane scrollPane = new JScrollPane(table);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(titre, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        add(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
