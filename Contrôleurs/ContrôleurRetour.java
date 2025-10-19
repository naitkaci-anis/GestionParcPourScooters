package Contrôleurs;

import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import Model.Parc;


public class ContrôleurRetour implements ActionListener {

    private JTextField idClientField;
    private JTextField idScooterField;
    private JTextField dateDebutField;
    private JTextField dateFinField;
    private JTextField kmField;
    private JFrame fenetre;
    private Parc parc;

    public ContrôleurRetour(
        JTextField idClientField,
        JTextField idScooterField,
        JTextField dateDebutField,
        JTextField dateFinField,
        JTextField kmField,
        JFrame fenetre,
        Parc parc
    ) {
        this.idClientField = idClientField;
        this.idScooterField = idScooterField;
        this.dateDebutField = dateDebutField;
        this.dateFinField = dateFinField;
        this.kmField = kmField;
        this.fenetre = fenetre;
        this.parc = parc;
    }

    public void actionPerformed(ActionEvent e) {
        String idClient = idClientField.getText().trim();
        String idScooter = idScooterField.getText().trim();
        String dateDebutTxt = dateDebutField.getText().trim();
        String dateFinTxt = dateFinField.getText().trim();
        String kmTxt = kmField.getText().trim();

        if (idClient.isEmpty() || idScooter.isEmpty() || dateDebutTxt.isEmpty() || dateFinTxt.isEmpty() || kmTxt.isEmpty()) {
            JOptionPane.showMessageDialog(fenetre, "Veuillez remplir tous les champs.");
            return;
        }

        try {
            LocalDate dateFin = LocalDate.parse(dateFinTxt);
            LocalDate dateDebut = LocalDate.parse(dateDebutTxt);   
            double km = Double.parseDouble(kmTxt);

            boolean ok = parc.retourScooter(idClient, idScooter, dateDebut, dateFin, km);

            if (ok) {
                JOptionPane.showMessageDialog(fenetre, "Retour effectué avec succès !");
                fenetre.dispose();
            } else {
                JOptionPane.showMessageDialog(fenetre, "Échec du retour. Vérifiez les informations.");
            }
        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(fenetre, "Format de date invalide. Utilisez aaaa-mm-jj.");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(fenetre, "Kilométrage invalide.");
        }
    }
}
