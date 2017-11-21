/**
 * Classe utilitaire pour la r�cup�ration et la sauvegarde de la bd
 * dans le travail sur le calendrier de clinique m�dicale. 
 * (voir �nonc� tp2 A17 INF111).
 * 
 * @author Pierre B�lisle
 * @version (Copyright 2017)
 * 
 */
package utilitaire;

import clinique.Clinique;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.swing.JOptionPane;

public class UtilitaireFichier {

	/**
	 * Tente d'ouvrir le fichier contenu dans le stream re�u.  S'il n'existe pas,
	 * ou qu'il y a un probl�me, une exception est lev�e.
	 */
	public static Clinique obtenirClinique(FileInputStream fic){

		/*
		 * Strat�gie : On utilise  un FileInputStream qui permet de lire
		 * la bd d'un coup, (comme elle a �t� sauvegard�e).
		 */
		Clinique clinique = null;

		try {
			
			// Ouverture du tampon logique.
			ObjectInputStream tampon = null;			
			tampon = new ObjectInputStream(fic);

			clinique =  (Clinique)tampon.readObject();

			tampon.close();

		}


		// Le fichier n'existe pas.
		catch(FileNotFoundException e){
			e.printStackTrace();
		}

		// Probl�me de format lors de la lecture.  
		catch (ClassNotFoundException e) {			
			JOptionPane.showMessageDialog(null, "Format de fichier invalide");
			e.printStackTrace();
		}
		

		// Autres cas non distingu�s.
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Probl�me avec le fichier");
			e.printStackTrace();
		}

		return clinique;
	}

	/**
	 * Sauvegarde la bd dans le fichier nomm� par NOM_FICHIER_BD.
	 *
	 */
	public static void sauvegarderClinique(Clinique clinique, String nomFic){

		/*
		 * Strat�gie : On utilise  un FileOutputStream qui permet de lire
		 * la bd d'un coup.
		 */
		FileOutputStream fic;
		ObjectOutputStream tampon = null;

		try {

			//Cr�e le fichier 
			fic = new FileOutputStream(nomFic);

			//Ouverture du tampon d'�criture
			tampon = new ObjectOutputStream(fic);
			tampon.writeObject(clinique);
			tampon.close();		

		} catch (FileNotFoundException e1) {

			e1.printStackTrace();

			// Une erreur d'�criture, on d�truit le fichier.
		} catch (IOException e) {

			// On obtient le chemin du fichier pour le d�truire.
			Path path = 
					FileSystems.getDefault().getPath(nomFic);

			try {

				tampon.close();
				Files.delete(path);

			} catch (IOException e1) {

				e1.printStackTrace();
			}

			e.printStackTrace();
		}

	}
}