package vue;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import Model.Parc;

public class FenetreRetour extends JFrame {

    private java.time.LocalDate dateDebutRet ; 
    private java.time.LocalDate dateFinRet;
    private String idClientRet;
    private String idScooterRet;

    private JButton validerBtn;
    private JTextField recupDateD;
    private JTextField recupDateF;
    private JTextField recupIdC;
    private JTextField recupIdS;
    private JTextField recupKmEff;
    private Parc parc;

    public FenetreRetour (Parc parc){
        this.parc = parc;

        setTitle("Retourner un scooter");
        setSize(400,400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    
        JLabel titre = new JLabel ("Remplir les information pour le retour");
        titre.setHorizontalAlignment(JLabel.CENTER);

         JLabel idC = new JLabel ("Entrez votre ID : ");
         recupIdC = new JTextField();

         JLabel idS = new JLabel("<html>Entrez l'ID du scooter<br>(voir sur le guidon) :</html>");

         recupIdS = new JTextField();

         JLabel dateD = new JLabel ("Entrez la date début de location : ");
         recupDateD = new JTextField();

         JLabel dateF = new JLabel ("Entrez la date fin de location : ");
         recupDateF = new JTextField();

         JLabel kmEff = new JLabel ("Entrez le KM effectué : ");
         recupKmEff = new JTextField();

        JPanel infoPanel = new JPanel(new GridLayout(5,2,10,10));
        infoPanel.add(idC); infoPanel.add(recupIdC);
        infoPanel.add(idS); infoPanel.add(recupIdS);
        infoPanel.add(dateD); infoPanel.add(recupDateD);
        infoPanel.add(dateF); infoPanel.add(recupDateF);
        infoPanel.add(kmEff); infoPanel.add(recupKmEff);

        validerBtn = new JButton("Valider");
        JPanel bas = new JPanel();
        bas.add(validerBtn);

        JPanel panelP = new JPanel (new BorderLayout());
        panelP.add(titre,BorderLayout.NORTH);
        panelP.add(infoPanel, BorderLayout.CENTER);
        panelP.add(bas, BorderLayout.SOUTH);

        add(panelP);
        setLocationRelativeTo(null);
        setVisible(true);

        validerBtn.addActionListener(new Contrôleurs.ContrôleurRetour(
        recupIdC,
        recupIdS,
        recupDateD,
        recupDateF,
        recupKmEff,     
        this,
        parc
));

     }

    public JTextField getIdC (){
        return recupIdC;
    }

    public JTextField getIdS (){
        return recupIdS;
    }

    public JTextField getDateD (){
        return recupDateD;
    }

    public JTextField getDateF (){
        return recupDateF;
    }

    public JTextField getKmEff (){
        return recupKmEff;
    }

    public JButton getValideB (){
        return validerBtn;
    }
}