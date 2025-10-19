package Contrôleurs;

import javax.swing.*;
import java.awt.event.*;
import vue.FenetreIdClient;
import Model.Client;
import vue.FenetreChoixDate;
import Model.Parc;

public class ContrôleurIdClient implements ActionListener {
    private Parc parc;
    FenetreIdClient f; 

    public ContrôleurIdClient(FenetreIdClient f, Parc parc) {
        this.parc = parc;
        this.f = f;
        f.getValide().addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        JButton boutonClique = (JButton) e.getSource();
        String source = boutonClique.getText();

        if (source.equals("valider")) {  
            String id = f.getIdField().getText().trim();
            boolean trouvé = false;

            for (Client c : parc.getListClient()) {
                if (c.getIdClient().equals(id)) {
                    f.dispose();
                    new FenetreChoixDate(parc);
                    trouvé = true;
                    break;
                }
            }

            if (!trouvé) {
                JOptionPane.showMessageDialog(f, "OUPS, ID client inexistant !");
            }
        }
    }
}
