package vue;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import Model.Parc;

public class FenetreIdClient extends JFrame {
    private Parc parc;
    private JButton valider;
    private JTextField idfield; 


    public FenetreIdClient (Parc parc) {
        this.parc = parc;

        setTitle("Vérification");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel titreId = new JLabel("Entrez votre ID client");
        titreId.setHorizontalAlignment(JLabel.CENTER);

        JLabel idlabel = new JLabel("ID :");
        idfield = new JTextField("C");
        idfield.setPreferredSize(new Dimension(150, 25));  

        valider = new JButton("valider");

        JPanel panelB = new JPanel(new GridLayout(1, 2, 15, 15));
        panelB.add(idlabel);
        panelB.add(idfield);
        panelB.setBorder(new EmptyBorder(10, 30, 10, 30));  

        JPanel Bvalider = new JPanel();
        Bvalider.add(valider);

        JPanel panel1 = new JPanel(new BorderLayout(10, 10));
        panel1.add(titreId, BorderLayout.NORTH);
        panel1.add(panelB, BorderLayout.CENTER);
        panel1.add(Bvalider, BorderLayout.SOUTH);

        JPanel centrerVerticalement = new JPanel(new GridBagLayout());
        centrerVerticalement.add(panel1); 

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(centrerVerticalement, BorderLayout.CENTER);

        add(panel);
        setLocationRelativeTo(null);
        setVisible(true);
          new Contrôleurs.ContrôleurIdClient(this, parc);
    }

    public JButton getValide (){
        return valider;
    }

    public JTextField getIdField (){
        return idfield;
    }
}