/**
 * Represente un calendrier compos� de plage horaire. 
 * Chaque plage horaire contient des rendez-vous m�dicaux 
*  � une date et une heure pr�cise.
 * 
 * Dans le cadre du cours inf111, travail pratique num�ro 3
 * (voir �nonc� INF111 A17 tp3 partie 1 fourni).
 * 
 * @author Mathieu Nayrolles
 * @Adaptation tp3 : Pierre B�lisle
 * @version Copyright A2017
 */
package clinique;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;



public class Calendrier implements Serializable {

    private static final long  serialVersionUID = 1L;

    // On conserve seulement les plages horaire qui ont des rendez-vous.
    private List<PlageHoraire> liste;


    /**
     * Cr�e un calendrier n'ayant aucune plage horaire encore.
     * 
     */
    public Calendrier() {
        liste = new ArrayList<PlageHoraire>();
    }


    /**
     * Ajoute une plage horaire au calendrier.
     * 
     * La plage horaire ne doit pas d�j� exister. Aucune validation ici.
     * 
     * @param plage
     */
    public void creerPlageHoraire(Calendar date) {

        liste.add(new PlageHoraire(date));
    }


    /**
     * Ajoute un rendez-vous en s'assurant qu'il n'existe pas d�j� (�vite les
     * doublons).
     * 
     * La plage horaire doit exister.
     * 
     * La fonction retourne false si l'ajout ne s'est pas effectu�.
     * 
     * @param ph
     */
    public boolean ajouterRdv(Calendar date, RendezVous rdv) {


        /*
         * Strat�gie : On trouve la plage horaire en it�rant sur la collection et
         * ensuite
         * on v�rifie le rendez-vous. s'il n'existe pas, on l'ajoute, sinon, on ne
         * fait rien.
         */

        boolean ajoute = false;

        PlageHoraire ph = getPlageHoraire(date);

        if (ph != null) {

            // Si le rendez-vous n'existe pas, on l'ajoute.
            if (!ph.rendezVousExiste(rdv)) {

                ph.ajouterRdv(rdv);

                ajoute = true;
            }
        }

        return ajoute;
    }


    /**
     * Annule un rdv existant. Rien ne se produit s'il n'existe pas.
     * 
     * Si la plage horaire ne contenait qu'un seul rdv, on la supprime aussi.
     * 
     * @param d
     * @param i
     * @param p
     * @param date
     * @return
     */
    public boolean annulerRdv(RendezVous rdv) {

        /**
         * Strat�gie: On it�re sur les plage horaires et sur les rdvs. Si on trouve le
         * rdv, alors on note son index pour le supprimer.
         */

        boolean supprime = false;

        for (PlageHoraire ph : liste) {

            if (ph.rendezVousExiste(rdv)) {

                ph.supprimerRdv(rdv);

                if (ph.getNbRendezVous() == 0) {

                    liste.remove(ph);

                    supprime = true;
                }
            }
        }


        return supprime;
    }


    /**
     * Obtient une plage horaire en fonction d'une date
     * 
     * Si la plage horaire n'existe pas, on retourne null.
     * 
     * @param date
     * @return une plage horaire
     */
    public PlageHoraire getPlageHoraire(Calendar date) {

        /**
         * Strat�gie: On it�re sur les plage horaires existantes pour trouver la plage
         * horaire correspondante quon retourne d�s que trouv�e.
         */

        PlageHoraire ph = new PlageHoraire(date);

        for (PlageHoraire plage : liste) {

            // D�s qu'on trouve, on arr�te et on retourne.
            if (plage.equals(ph)) {
                return plage;
            }
        }

        return null;

    }


    @Override
    public String toString() {

        String str = "";

        for (PlageHoraire plage : liste) {

            str += plage;
        }

        str += '\n';

        return str;
    }
}
