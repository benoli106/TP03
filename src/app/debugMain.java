/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app;

import clinique.Clinique;
import static com.sun.javafx.print.Units.POINT;
import gui.CadreClinique;
import gui.CadreGestionParticipant;
import gui.PanneauSaisieDocteur;
import gui.PanneauSaisieParticipant;
import java.io.File;
import java.io.FileInputStream;
import javax.swing.JFrame;
import javax.swing.JPanel;
import utilitaire.UtilitaireFichier;

/**
 *
 * @author AP02990
 */
public class debugMain {
    
        public static void main(String[] args) {

    	//Thread t = new Thread(new CadreClinique());
    	//t.start();
        
        CadreClinique clinique = new CadreClinique();
        Clinique clinique2 = new Clinique();

        JFrame jf = new JFrame();
        JPanel s = new JPanel();
        jf.setContentPane(s);

        // Dimension plein �cran du  CadreClinique (this).
        jf.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // On ferme sur X.
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // On ajoute le panneau pour les date.



        
        // La grille qui pr�sente le calendrier (dateChooser).
        

        //On montre la fen�tre
        jf.setVisible(true);
    
    }
        
        
    
}
