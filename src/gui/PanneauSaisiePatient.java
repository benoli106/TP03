package gui;

import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Le panneau pour la saisie des informations du patient et hérite de la classe
 * PanneauSaisieParticipant va contenir le saisi du NAS de plus
 *
 * @Long Tran & Benjamin Fontaine
 * @version
 *
 */
public class PanneauSaisiePatient extends PanneauSaisieParticipant {

    private static final long serialVersionUID = 1L;

    // Attributs
    // Le panneau pour le NAS
    private JPanel panelNAS;

    // Le textfield pour le NAS
    private JTextField textFieldNAS;

    /**
     * Constructeur qui permet d'instancier le panneau et le textfield & label
     * et de l'ajouter a celui ci
     *
     */
    public PanneauSaisiePatient() {
        super();
        // Instaciation pour le JPanel du NAS
        panelNAS = new JPanel();

        // Instanciation du JTextField pour le NAS
        textFieldNAS = new JTextField();
        textFieldNAS.setPreferredSize(new Dimension(200, 50));
       

        // Déclaration & instaciation du NAS
        JLabel labelNAS = new JLabel("NAS : ");

        // On choisit le type de layout
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        // Ajouter le label & textfield dans le panel précèdément créé
        panelNAS.add(labelNAS);
        panelNAS.add(textFieldNAS);

        //Ajouter le panel dans cette classe
        this.add(panelNAS);

    }

    // Message erreur et retourne true lorsqur les textfields de nom et prénom
    // sont vides ou le nas est vide
    // elle retourne false s'il n'y a pas d'erreur
    @Override
    public boolean aviserDuneErreur() {
        if (super.aviserDuneErreur() == false) {
            
            // Si le textfield du NAS est vide
            if (textFieldNAS.getText().isEmpty()) {
                // Le message
                JOptionPane.showMessageDialog(this, "le NAS est vide");
                return true;

            }

        }

        return false;

    }
    

}
