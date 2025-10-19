package vue;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;
import Model.Scooter;
import Model.Parc;
import Contrôleurs.ContrôleurChoixScooter;

public class FenetreChoixScooter extends JFrame {

    private JList<Scooter> listScooters;
    private JButton validerBtn;
    private Parc parc;

    private Vector<Scooter> disponibles;
    private String idClient;
    private java.time.LocalDate dateDebut;
    private java.time.LocalDate dateFin;

    public FenetreChoixScooter(Vector<Scooter> disponibles, String idClient, java.time.LocalDate dateDebut, java.time.LocalDate dateFin, Parc parc) {
        this.parc = parc;
        this.disponibles = disponibles;
        this.idClient = idClient;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;

        setTitle("Choix du scooter");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        listScooters = new JList<>(disponibles);
        JScrollPane scrollPane = new JScrollPane(listScooters);

        validerBtn = new JButton("Valider");
        JPanel bas = new JPanel();
        bas.add(validerBtn);

        add(scrollPane, BorderLayout.CENTER);
        add(bas, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);

        new ContrôleurChoixScooter(this, parc);
    }

    public JList<Scooter> getListScooters() {
        return listScooters;
    }

    public JButton getValiderBtn() {
        return validerBtn;
    }

    public String getIdClient() {
        return idClient;
    }

    public java.time.LocalDate getDateDebut() {
        return dateDebut;
    }

    public java.time.LocalDate getDateFin() {
        return dateFin;
    }
}
