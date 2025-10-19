package Contrôleurs;

import javax.swing.*;
import java.awt.event.*;
import vue.FenetreIdClient;
import vue.FenetreLouer;
import vue.FenetreIdentificationClient;
import Model.Parc;

public class ContrôleurIdentificationClient implements ActionListener {
     private Parc parc;
     FenetreIdentificationClient f;
     public ContrôleurIdentificationClient(FenetreIdentificationClient f, Parc parc){
      this.parc = parc;
      this.f = f;
      f.getOuiButton().addActionListener(this);
      f.getNonButton().addActionListener(this);


     }
     public void actionPerformed(ActionEvent e){

     JButton boutonClique = (JButton) e.getSource();
     String source = boutonClique.getText();

     if (source.equals("oui")){
          f.dispose();
          new FenetreIdClient(parc);
     }else {
          f.dispose();
          new FenetreLouer(parc);
     }
}
}