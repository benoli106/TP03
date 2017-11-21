package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
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
        JMenu menuPrincipal = new JMenu("Gestion");
        
        JMenuItem docteurItem = new JMenuItem("Docteur");
        docteurItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cadreClinique.gererDocteur();
            }
        });
        menuPrincipal.add(docteurItem);
        
        JMenuItem infirmierItem = new JMenuItem("Infirmier");
        infirmierItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cadreClinique.gererInfirmier();
            }
        });
        menuPrincipal.add(infirmierItem);

        JMenuItem patientItem = new JMenuItem("Patient");
        patientItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cadreClinique.gererPatient();
            }
        });
        menuPrincipal.add(patientItem);

        JMenuItem quitterItem = new JMenuItem("Quitter");
        quitterItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menuPrincipal.add(quitterItem);
        this.add(menuPrincipal);
       
    }
}
