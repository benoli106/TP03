/**
 * Classe pour les infirmiers.
 * 
 * Dans le cadre du cours inf111, travail pratique num�ro 3
 * 
 * @author Pierre B�lisle
 * @version Copyright A2017
 */
package clinique;



public class Infirmier extends Participant {

    private static final long serialVersionUID = 1L;

    private boolean           disponibilite;


    /**
     * Cr�e un infirmier avec l'identification et la disponibilite
     * fournies � l'appel.
     *
     * @param identification
     *        Doit �tre non null (aucune validation).
     * @param disponibilite
     */
    public Infirmier(Identification identification, boolean disponibilite) {

        super(identification);
        this.disponibilite = disponibilite;

    }


    /**
     * @return La disponibilit� de l'infirmier.
     */
    public boolean getDisponibilite() {
        return disponibilite;
    }


    /**
     * @param disponibilite
     *        La disponibilite de l'infirmier � utiliser.
     */
    public void setDisponibilitet(boolean disponibilite) {
        this.disponibilite = disponibilite;
    }


    @Override
    public boolean equals(Object obj) {

        // La partie identification laiss�e au parent.
        return super.equals(obj) && ((Infirmier) obj).disponibilite == disponibilite;
    }


    @Override
    public String toString() {

        // Java n'accepte pas cet op�rateur ternaire avec String dans le return.
        String disponibiliteStr = (disponibilite) ? "disponible" : "non disponible";

        // La partie identification laiss�e au parent.
        return super.toString() + "    " + "Disponibilit� :   " + disponibiliteStr;
    }


    @Override
    public String getCategorieParticipant() {
        return "infirmier";
    }
}
