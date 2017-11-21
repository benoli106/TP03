/**
 * Classe pour les docteurs. 
 * 
 * Ls d�partement peuvent �tre : 	Clinique.CHIRURGIE, 
 * Clinique.UROLOGIE ou Clinique.URGENCE
 * 
 * Dans le cadre du cours inf111, travail pratique num�ro 3
 * (voir �nonc� INF111 A17 tp3 partie 1 fourni).
 * 
 * @author Pierre B�lisle
 * @version Copyright A2017
 */
package clinique;



public class Docteur extends Participant {

    private static final long serialVersionUID = 1L;

    private int               numDepartement;


    /**
     * Cr�e un docteur avec l'identification et le num�ro de
     * d�partement fournis � l'appel.
     * 
     * @param identification
     *        Doit �tre non null (aucune validation).
     * @param numDepartement
     *        Le num�ro qui peut �tre Clinique.UROLOGIE...
     * 
     */
    public Docteur(Identification identification, int numDepartement) {

        super(identification);
        this.numDepartement = numDepartement;

    }


    /**
     * @return Le num�ro de departement.
     */
    public int getNumDepartement() {
        return numDepartement;
    }


    /**
     * @param numDepartement
     *        Le num�ro de departement � utiliser.
     */
    public void setNumDepartement(int numDepartement) {
        this.numDepartement = numDepartement;
    }


    @Override
    public boolean equals(Object obj) {

        // La partie identification laiss�e au parent.
        return super.equals(obj) && ((Docteur) obj).numDepartement == numDepartement;
    }


    @Override
    public String toString() {

        // La partie identification laiss�e au parent.
        return super.toString() + "   " + "Departement   :   " + Clinique.getNumDepartement2String(numDepartement);
    }


    @Override
    public String getCategorieParticipant() {
        return "docteur";
    }
}
