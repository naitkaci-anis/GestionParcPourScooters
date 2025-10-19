package Contrôleurs;

import Model.Client;
import Model.Permis;
import Model.Parc;
import vue.FenetreLouer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ContrôleurLouer implements ActionListener, ItemListener {
    private Parc parc;
    private FenetreLouer vue;

    public ContrôleurLouer(FenetreLouer vue, Parc parc) {
        this.parc = parc;
        this.vue = vue;

        // Ajout des listeners
        vue.getValiderBtn().addActionListener(this); // Pour le bouton Valider
        vue.getAPermis().addItemListener(this);      // Pour la case à cocher
        vue.getNbPermisField().addActionListener(this); // Pour générer les champs
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        // Si c'est le bouton Valider
        if (source == vue.getValiderBtn()) {
            String nom = vue.getNomField().getText().trim();
            String prenom = vue.getPrenomField().getText().trim();
            String tel = vue.getTelField().getText().trim();

        if (nom.isEmpty() || prenom.isEmpty() || tel.isEmpty()) {
        JOptionPane.showMessageDialog(vue, "Veuillez remplir tous les champs obligatoires.");
        return;
        }
            int i = parc.getListClient().size();
            String idClient = "C" + i;
            Client client = new Client(idClient, tel, nom, prenom, parc);

            if (vue.getAPermis().isSelected()) {
                try {
                    int nb = Integer.parseInt(vue.getNbPermisField().getText().trim());
                    Component[] composants = vue.getChampsPermis().getComponents();

                    for (int j = 0; j < nb * 4; j += 4) {
                        JTextField idField = (JTextField) composants[j + 1];
                        JTextField typeField = (JTextField) composants[j + 3];
                        String idPermis = idField.getText().trim();
                        String typePermis = typeField.getText().trim();
                        Permis p = new Permis(idPermis, typePermis, client);
                        client.addPermis(p);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(vue, "Nombre de permis invalide !");
                    return;
                }
            }

            parc.addClient(client);
            JOptionPane.showMessageDialog(vue, "Client ajouté avec succès ! ID = " + idClient);
            vue.dispose();
            new vue.FenetreChoixDate(parc);
        }

        // Si c'est le champ nombre de permis
        else if (source == vue.getNbPermisField()) {
            JPanel champsPermis = vue.getChampsPermis();
            champsPermis.removeAll();
            try {
                int nb = Integer.parseInt(vue.getNbPermisField().getText().trim());
                for (int i = 1; i <= nb; i++) {
                    champsPermis.add(new JLabel("ID Permis " + i + " :"));
                    champsPermis.add(new JTextField());
                    champsPermis.add(new JLabel("Type Permis " + i + " :"));
                    champsPermis.add(new JTextField());
                }
            } catch (NumberFormatException ex) {
                champsPermis.add(new JLabel("Entrez un nombre valide !"));
            }
            vue.revalidate();
            vue.repaint();
        }
    }

    public void itemStateChanged(ItemEvent e) {
        // Case à cocher : afficher ou cacher les champs permis
        vue.getPermisPanel().setVisible(vue.getAPermis().isSelected());
        vue.revalidate();
        vue.repaint();
    }
}
