package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * � vous de commenter
 *
 * @author
 * @version
 *
 */
public class MonMenuBar extends JMenuBar {

    CadreClinique cadreClinique;
    

    /**
     * � vous de commenter
     *
     */
    public MonMenuBar(CadreClinique cadreClinique) {
        this.cadreClinique = cadreClinique;
        init();
    }

    //On créer le menu déroulant et ses compostantes avec les actionlisteners      
    public void init() {
        JMenuItem docteurButton = new JMenuItem("Docteur");
        docteurButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cadreClinique.gererDocteur();
            }
        });

        JMenuItem infirmierButton = new JMenuItem("Infirmier");
        infirmierButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cadreClinique.gererInfirmier();
            }
        });

        JMenuItem patientButton = new JMenuItem("Patient");
        patientButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cadreClinique.gererPatient();
            }
        });

        JMenuItem quitterButton = new JMenuItem("Quitter");
        quitterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
