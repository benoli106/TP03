/**
 * Sert essentiellement au d�bogage.  Il offre de montrer
 * la date et l'heure d'un objet de la classe Calendar car la m�thode toString n'est 
 * pas impl�ment�e pour cette classe abstraite java.util.Calendar.
 * 
 * @author Pierre B�lisle
 * @version Copyright A2017
 * 
 */
package utilitaire;

import java.util.Calendar;

public class UtilitaireDate {
	
	/**
	 * Retourne un string correspondant � la date et l'heure de
	 * la r�f�rence re�ue.
	 * 
	 *  (� utiliser sous l'onglet  "Expressions" du d�boggueur : 
	 *  					ecrire: UtilitaireDate.calendarToString(date))
	 * 
	 * @param date La date � consid�rer
	 * @return La version String de cet objet de la classe Calendar.
	 */
	public static String calendarToString(Calendar date){
		
		// Format utile au tp.
		return date.get(Calendar.DAY_OF_MONTH) + "/" + 
				date.get(Calendar.MONTH) + "/" +
				date.get(Calendar.YEAR) + "/" + "      " + 
				date.get(Calendar.HOUR_OF_DAY) + ":"  +
				date.get(Calendar.MINUTE);
	}

}
