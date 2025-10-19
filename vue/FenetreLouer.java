package vue;

import javax.swing.*;
import java.awt.*;
import Model.Parc;

import Contrôleurs.ContrôleurLouer;

public class FenetreLouer extends JFrame {
    private Parc parc;

    private JTextField nomField;
    private JTextField prenomField;
    private JTextField telField;
    private JCheckBox aPermis;
    private JTextField nbPermisField;
    private JPanel champsPermis;
    private JPanel permisPanel;
    private JButton validerBtn;

    public FenetreLouer(Parc parc) {
        this.parc = parc;
        setTitle("Louer un scooter");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel titre = new JLabel("Formulaire de location");
        titre.setHorizontalAlignment(JLabel.CENTER);

        JLabel nomLabel = new JLabel("Nom :");
        nomField = new JTextField();
        JLabel prenomLabel = new JLabel("Prénom :");
        prenomField = new JTextField();
        JLabel telLabel = new JLabel("Téléphone :");
        telField = new JTextField();
        aPermis = new JCheckBox("Je possède un permis");

        permisPanel = new JPanel(new BorderLayout());
        permisPanel.setVisible(false);

        JPanel ligneNbPermis = new JPanel(new GridLayout(1, 2, 5, 5));
        JLabel nbPermisLabel = new JLabel("Nombre de permis :");
        nbPermisField = new JTextField();
        ligneNbPermis.add(nbPermisLabel);
        ligneNbPermis.add(nbPermisField);

        champsPermis = new JPanel(new GridLayout(0, 2, 5, 5));
        permisPanel.add(ligneNbPermis, BorderLayout.NORTH);
        permisPanel.add(champsPermis, BorderLayout.CENTER);

        JPanel centre = new JPanel(new GridLayout(5, 2, 5, 5));
        centre.add(nomLabel); centre.add(nomField);
        centre.add(prenomLabel); centre.add(prenomField);
        centre.add(telLabel); centre.add(telField);
        centre.add(aPermis); centre.add(new JLabel());
        centre.add(new JLabel()); centre.add(new JLabel());

        JPanel centreEtPermis = new JPanel(new BorderLayout());
        centreEtPermis.add(centre, BorderLayout.NORTH);
        centreEtPermis.add(permisPanel, BorderLayout.CENTER);

        validerBtn = new JButton("Valider");
        JPanel bas = new JPanel();
        bas.add(validerBtn);

        JPanel principal = new JPanel(new BorderLayout());
        JPanel haut = new JPanel(); haut.add(titre);

        principal.add(haut, BorderLayout.NORTH);
        principal.add(centreEtPermis, BorderLayout.CENTER);
        principal.add(bas, BorderLayout.SOUTH);

        add(principal);
        setLocationRelativeTo(null);
        setVisible(true);

        new ContrôleurLouer(this, parc);
    }

    public JTextField getNomField() { return nomField; }
    public JTextField getPrenomField() { return prenomField; }
    public JTextField getTelField() { return telField; }
    public JCheckBox getAPermis() { return aPermis; }
    public JTextField getNbPermisField() { return nbPermisField; }
    public JPanel getChampsPermis() { return champsPermis; }
    public JPanel getPermisPanel() { return permisPanel; }
    public JButton getValiderBtn() { return validerBtn; }
}
