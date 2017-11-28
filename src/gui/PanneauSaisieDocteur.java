package gui;

import clinique.Docteur;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

/**
 * Classe qui gère le panneau afficher pour la saisie d'un docteur. Répond à la
 * demande d'ajout lorsqu'on va cliquer sur le bouton afficher du
 * cadreGestionParticipant avec la liste de docteur.
 *
 * @author Pierre B�lisle
 * @version Copyright A2017
 */
public class PanneauSaisieDocteur extends PanneauSaisieParticipant {

    private static final long serialVersionUID = 1L;

    //Attributs
    //Liste Déroulante JScrollPane
    private JScrollPane listeDeroulanteDocteur;

    //Liste pour l'Affichage
    private JList liste;

    //Tableau des départements
    private String[] TAB_DEPT;

    //Créer un PanneauSaisieDocteur. Insère dans la liste en attribut
    //les valeurs du tableau de departement recu
    //On créer ensuite le JScrollPane qu'on ajoute à l'instance d'objet 
    //PanneauSaisieDocteur, donc this.
    public PanneauSaisieDocteur(String[] tableauDepartement) {
        super();
        this.TAB_DEPT = tableauDepartement;

        DefaultListModel<String> listModel = new DefaultListModel<String>();

        for (int i = 0; i < this.TAB_DEPT.length; i++) {
            listModel.addElement(this.TAB_DEPT[i]);
        }

        liste = new JList<String>(listModel);
        liste.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        listeDeroulanteDocteur = new JScrollPane();
        listeDeroulanteDocteur.add(liste);

        this.add(listeDeroulanteDocteur);
    }

    //Retourne le numérot de l'index sélectionner, donc le num de département
    public int getNumDepartement() {
        if (liste.isSelectionEmpty()) {
            return -1;
        }
        return this.liste.getSelectedIndex();
    }

    //Retourne un docteur en utilisant l'identification de la classe mere
    //et le département du panneau
    @Override
    public Docteur getParticipant() {
        return new Docteur(super.getIdentification(), this.getNumDepartement());
    }

    //Efface le nom/prenom du docteur et efface la sélection de la liste
    @Override
    public void reset() {
        super.reset();
        this.liste.clearSelection();
    }

    //Vérifie l'identification du docteur et le département, si un des champs
    //est invalide return true, sinon return false
    @Override
    public boolean aviserDuneErreur() {

        if (!super.aviserDuneErreur()) {

            if (this.getNumDepartement() < 0) {
                JOptionPane.showMessageDialog(this, "Le département est invalide");
                return true;
            }

        }
        return false;

    }
}
