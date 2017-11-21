/**
 * Classe representant une clinique m�dicale.
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
import java.util.List;



public class Clinique implements Serializable {

    private static final long  serialVersionUID = 1L;

    // Constantes aux valeurs arbitraires.
    public static final String NOM_FIC          = "src/data/clinique.bin";

    // Num�ro possible qui repr�sente les d�partements
    public static final int    CHIRURGIE        = 0;
    public static final int    UROLOGIE         = 1;
    public static final int    URGENCE          = 2;

    // Ajout� pour faciliter la saisie.
    private static String[]    TAB_DEPT         = { "Chirurgie", "Urologie", "Urgence" };

    // Les Listes sont toutes des listes de participants maintenant.
    private List<Participant>  docteurs         = new ArrayList<>();
    private List<Participant>  patients         = new ArrayList<>();
    private List<Participant>  infirmiers       = new ArrayList<>();

    // Le calendrier des rendez-vous.
    private Calendrier         calendrier       = new Calendrier();


    /**
     * @return Le calendrier de la clinique.
     */
    public Calendrier getCalendrier() {
        return calendrier;
    }


    /**
     * Retourne la collection des Docteur.
     */
    public List<Participant> getDocteurs() {
        return docteurs;
    }


    /**
     * @return La collection des patients.
     */
    public List<Participant> getPatients() {
        return patients;
    }


    /**
     * @return La collection des infirmiers.
     */
    public List<Participant> getInfirmiers() {
        return infirmiers;
    }


    /**
     * @return Un tableau de cha�nes qui d�crivent les d�partements de la clinique.
     */
    public String[] getDepartements() {
        return TAB_DEPT;
    }


    /*
     * @return L'�quivalent en String du num�ro de d�partement.
     */
    public static String getNumDepartement2String(int numDepartement) {

        return TAB_DEPT[numDepartement];
    }
}
