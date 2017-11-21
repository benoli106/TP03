/**
 * Classe pour les patients.
 * 
 * Dans le cadre du cours inf111, travail pratique num�ro 3
 * (voir �nonc� INF111 A17 tp3 partie 1 fourni).
 * 
 * @author Pierre B�lisle
 * @version Copyright A2017
 */
package clinique;



public class Patient extends Participant {

    private static final long serialVersionUID = 1L;

    private String            nas;


    /**
     * Cr�e un patient avec l'identification et le num�ro d'assurance social
     * fournis � l'appel.
     * 
     * @param identificationParticipant
     * @param nas
     */
    public Patient(Identification identification, String nas) {

        super(identification);
        this.nas = nas;

    }


    /**
     * @return Le num�ro d'assurance social.
     */
    public String getNas() {
        return nas;
    }

    
    /**
     * @param nas
     *        Le num�ro d'assurance social � utiliser.
     */
    public void setNas(String nas) {
        this.nas = nas;
    }


    @Override
    public boolean equals(Object obj) {

        // La partie identification laiss�e au parent.
        return super.equals(obj) && ((Patient) obj).nas.equals(nas);
    }


    @Override
    public String toString() {

        // La partie identification laiss�e au parent.
        return super.toString() + "   " + "NAS : " + nas;
    }


    @Override
    public String getCategorieParticipant() {
        return "patient";
    }

}
