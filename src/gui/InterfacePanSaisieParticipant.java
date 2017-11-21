/**
 * Interface qui annonce les m�thodes utilis�es par le cadre de gestion.
 * Cette interface est destin�e � des classes de la famille des javax.swing.JPanel.
 * Le panneau doit afficher les informations de saisie d'un des participants
 * � la clinique.
 *          
 * Elle est utilis�e par la classe CadreGestion qui en demande une instance 
 * dans son constructeur.
 * 
 *   ex: public CadreGestion(Clinique clinique, 
 *                                           InterfacePanneauGestion panneauSaisie,...)

 * reset() : Permet au cadre de r�initialiser les champs de saisie � vide.
 * 
 * aviserSiErreur() : Cette m�thode est appel�e pour laisser au panneau
 *                              la validation des attributs vides. La fonction retourne s'il y
 *                              a eu avis ou non.   
 *  
 * getParticipant() : Retourne le Participant avec les infos saisies dans le panneau.
 *  
 * Dans le cadre du cours inf111, travail pratique num�ro 3
 * 
 * Vous n'avez pas � modifier ce code mais vous devez l'utiliser.
 * 
 * @author Pierre B�lisle
 * @version Copyright A2017
 */
package gui;

import clinique.Participant;

public interface InterfacePanSaisieParticipant {


    /**
     * Return un participant cr�� avec les infos du panneau.
     * 
     * @return Le participant que saisie dans le panneau.
     */
    public Participant getParticipant();


    /**
     * Le panneau doit aviser s'il y a des composants laiss�s vides
     * ou non s�lectionn�s.
     * 
     * @return Si l'utilisateur a re�u un avis d'erreur ou non.
     */
    public boolean aviserDuneErreur();


    /**
     * Remet le panneau de saisie dans son �tat initial.
     */
    public void reset();


}
