package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Menu bar qui sera utiliser par le cadre clinique pour sélectionner un menu
 * de gestion a afficher. Utilise des menu item pour se remplir et génère un
 * evenement quand un d'eux est cliquer.
 *
 * @Long Tran & Benjamin Fontaine
 * @version
 *
 */
public class MonMenuBar extends JMenuBar {

    //Garde un objet cadreClinique en mémoire pour pouvoir faire appel aux 
    //évènements
    CadreClinique cadreClinique;
    
    //Initialise le cadre clinique et appel la méthode d'initialisation.
    public MonMenuBar(CadreClinique cadreClinique) {
        this.cadreClinique = cadreClinique;
        init();
    }

    //On créer le menu déroulant et ses compostantes avec les actionlisteners      
    public void init() {
        JMenu menuPrincipal = new JMenu("Gestion");
        
        //On créer un JMenuItem pour chaque options et on y ajoute
        //un actionListener vers la méthode qui gère l'évenement. Puis on ajoute
        //le menu item au menu principal
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
        
        //on termine en ajoutant le menu principal au parent, le menuBar
        this.add(menuPrincipal);
        
       
    }
}
