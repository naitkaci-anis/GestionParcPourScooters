package vue;

import javax.swing.*;
import java.awt.*;
import Contrôleurs.ContrôleurChoixDate;
import Model.Parc;

public class FenetreChoixDate extends JFrame {
    private Parc parc;
    private JTextField dateDebutField;
    private JTextField dateFinField;
    private JButton validerBtn;

    public FenetreChoixDate(Parc parc) {
        this.parc = parc;

        setTitle("Louer un scooter");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel ecriture = new JLabel("Entrer les dates :");
        ecriture.setHorizontalAlignment(JLabel.CENTER);

        JLabel labelDebut = new JLabel("Date de début : ");
        dateDebutField = new JTextField("aaaa-mm-jj");
        labelDebut.setPreferredSize(new Dimension(50,25));

        JLabel labelFin = new JLabel("Date de fin : ");
        dateFinField = new JTextField("aaaa-mm-jj");
        labelFin.setPreferredSize(new Dimension(50,25));


        Dimension labelSize = new Dimension(120, 25); 

        labelDebut.setPreferredSize(labelSize);
        labelFin.setPreferredSize(labelSize);

        JPanel ligne1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 15));
        ligne1.add(labelDebut);
        dateDebutField.setColumns(15);  
        ligne1.add(dateDebutField);

        JPanel ligne2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 15));
        ligne2.add(labelFin);
        dateFinField.setColumns(15);
        ligne2.add(dateFinField);


        JPanel panelDate = new JPanel();
        panelDate.setLayout(new BoxLayout(panelDate, BoxLayout.Y_AXIS));
        panelDate.add(ligne1);
        panelDate.add(ligne2);


        validerBtn = new JButton("Valider");
        JPanel bas = new JPanel();
        bas.add(validerBtn);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.add(ecriture, BorderLayout.NORTH);
        panel.add(panelDate, BorderLayout.CENTER);
        panel.add(bas, BorderLayout.SOUTH);

        add(panel);
        setLocationRelativeTo(null); 
        setVisible(true);

        new ContrôleurChoixDate(this, parc);
    }

    public JTextField getDateDebutField() {
        return dateDebutField;
    }

    public JTextField getDateFinField() {
        return dateFinField;
    }

    public JButton getValiderBtn() {
        return validerBtn;
    }

    public String getDateDebutText() {
    return dateDebutField.getText().trim();
}

    public String getDateFinText() {
    return dateFinField.getText().trim();
}

}
