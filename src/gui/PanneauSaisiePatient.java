package gui;

import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Le panneau pour la saisie des informations du client et hérite de la classe
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
     * Constructeur qui permet d'instancier le panneau et
     * le textfield & label et de l'ajouter a celui ci
     * 
     */
    public PanneauSaisiePatient() {
        super();
        panelNAS = new JPanel();
        

    }

}
