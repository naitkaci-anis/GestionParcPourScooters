package vue;

import javax.swing.*;
import java.awt.*;
import Model.Parc;

public class FenetreIdentificationClient extends JFrame {
    private Parc parc;
    private JButton oui;
    private JButton non;

    public FenetreIdentificationClient(Parc parc) {
        this.parc = parc;

        setTitle("Vérification");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel titre = new JLabel("Êtes-vous client chez nous ?");
        titre.setHorizontalAlignment(JLabel.CENTER);

        oui = new JButton("oui");
        JPanel basoui = new JPanel();
        basoui.add(oui);

        non = new JButton("non");
        JPanel basnon = new JPanel();
        basnon.add(non);

        JPanel panelB = new JPanel(new GridLayout(1, 2, 10, 10));
        panelB.add(basoui);
        panelB.add(basnon);

        JPanel panel1 = new JPanel(new BorderLayout());
        panel1.add(titre, BorderLayout.NORTH);
        panel1.add(panelB, BorderLayout.CENTER);

        JPanel centrerVerticalement = new JPanel(new GridBagLayout());
        centrerVerticalement.add(panel1); 

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(centrerVerticalement, BorderLayout.CENTER);

        add(panel);
        setLocationRelativeTo(null);
        setVisible(true);


        new Contrôleurs.ContrôleurIdentificationClient(this, parc);
    }

    public JButton getOuiButton() {
        return oui;
    }

    public JButton getNonButton() {
        return non;
    }

}
