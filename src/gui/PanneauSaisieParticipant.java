package gui;

import clinique.Identification;
import clinique.Participant;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Le panneau où que tous les autres classes héritent de pour éviter la
 * répétition du code. Panneau pour faire la saisi des informations du
 * participant (le nom et le prénom )
 *
 * @Long Tran & Benjamin Fontaine
 * @version
 *
 */
public class PanneauSaisieParticipant extends JPanel
        implements InterfacePanSaisieParticipant {

    private static final long serialVersionUID = 1L;

    // Attributs
    //Panneau pour le nom
    private JPanel panelNom;
    private JTextField textFieldNom;
    // Panneau pour le prénom
    private JPanel panelPrenom;
    private JTextField textFieldPrenom;

    /**
     * Constructeur par défaut qui initialise le panneau pour la saisie de
     * participant (le prénom et le nom) un jlabel & jtextfield pour chaque
     * champs
     *
     */
    public PanneauSaisieParticipant() {
        // Appel du constructeur du parent
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        // Les saisies du nom
        JLabel labelNom = new JLabel("Entrer le nom");
        textFieldNom = new JTextField();

        // Les saisies du prénom
        JLabel labelPrenom = new JLabel("Entrer le prénom");
        textFieldPrenom = new JTextField();

        // Ajouter le label & textfield du nom dans un panneau 
        // Le panneau pour le nom
        panelNom = new JPanel();
        panelNom.add(labelNom);
        panelNom.add(textFieldNom);

        // Ajouter le label & textfield du prénom dans un panneau 
        // Le panneau pour le prénom
        panelPrenom = new JPanel();
        panelPrenom.add(labelPrenom);
        panelPrenom.add(textFieldPrenom);

        // Ajouter les 2 panneaux du nom & prénom dans le panneau principal
        this.add(panelNom);
        this.add(panelPrenom);

    }

    // Retourne un nouvel objet d'identification contenant le nom et prénom
    // dans les textfields
    public Identification getdentification() {

        // Va chercher la valeur du textfield dans le textfield du nom
        String nom = textFieldNom.getText();

        // Va chercher la valeur du textfield dans le textfield du prénom
        String prenom = textFieldPrenom.getText();

        return (new Identification(nom, prenom));
    }

    @Override
    // Retourne un nouvel objet de participant contenant une identification
    public Participant getParticipant() {
        return (new Participant(this.getdentification()));
    }

    // Message erreur et retourne true lorsqu'une des 2 boites est vide sinon
    // elle retourne false 
    @Override
    public boolean aviserDuneErreur() {
        if (textFieldNom.getText() == "" || textFieldPrenom.getText() == "") {
            JOptionPane.showMessageDialog(this, "Un des champs est vide");
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void reset() {
        // Enlever les textes dans les boites
        textFieldNom.setText("");
        textFieldPrenom.setText("");

    }
}
