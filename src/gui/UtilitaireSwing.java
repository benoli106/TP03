
package gui;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 * Classe utilitaire pour regrouper des instructions sur les
 * composants Swing qui risquent de se r�p�ter.
 * 
 * @author Pierre B�lisle
 * @version Copyright A2017
 */
public class UtilitaireSwing {

    /**
     * Permet de regrouper le code qui dimensionne un <b>composant<\b>
     * de Swing.
     * 
     * @param composant
     *        Le composant Swing � dimensionner
     * @param dimension
     *        La nouvelle dimension du composant.
     * 
     */
    public static void setDimension(JComponent component, Dimension dimension) {

        // Dans nos applications, il est pr�f�rable de dimensionner
        // les trois de fa�on identique.
        component.setMinimumSize(dimension);
        component.setMaximumSize(dimension);
        component.setPreferredSize(dimension);

    }


    /**
     * Permet de regrouper le code qui dimensionne <b>un conteneur</b>
     * de Swing.
     * 
     * @param composant
     *        Le composant Swing � dimensionner
     * @param dimension
     *        La nouvelle dimension du composant.
     * 
     */
    public static void setDimension(Container component, Dimension dimension) {

        // Dans nos applications, il est pr�f�rable de dimensionner
        // les trois de fa�on identique.
        component.setMinimumSize(dimension);
        component.setMaximumSize(dimension);
        component.setPreferredSize(dimension);

    }


    /**
     * Permet d'obtenir un JTable de Swing remplit � partir d'un
     * tableau statique d'objets.
     * 
     * La m�thode toString() doit �tre impl�menter par les sous-classes
     * de la classe Object.
     * 
     * 
     * @param liste
     *        Un tableau qui contient les donn�es � pr�senter.
     */
    public static JTable obtenirListe_A_Afficher(Object[] liste) {

        /*
         * Inspir� du d�mo sur JTable
         * 
         * Ce code permet de disposer des donn�es dans une table � partir d'une
         * liste. Les �l�ments de la liste doivent impl�menter toString().
         * 
         * (https://docs.oracle.com/javase/tutorial/displayCode.html?code=
         * https://docs.oracle.com/javase/tutorial/uiswing/examples/components/
         * ListDemoProject/src/components/JTableDemo.java)
         */
        String[] columns = { " " };
        Object[][] data = new Object[liste.length][1];

        // On obtient le mod�le de la table.
        DefaultTableModel tableModel = new DefaultTableModel();
        JTable listeSwing = new JTable(tableModel);

        // On ajoute les donn�es et l'ent�te au mod�le de la table.
        tableModel.setDataVector(data, columns);

        listeSwing.setSelectionMode(
        		ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        // Ajoute liste[i].toString() � la table.
        for (int i = 0; i < liste.length; i++) {

            tableModel.setValueAt(liste[i], i, 0);

        }

        return listeSwing;
    }


    /*
     * Rafra�chit le composant.
     */
    public static void rafraichirCadre(JComponent component) {

        component.validate();
        component.repaint();
    }
}