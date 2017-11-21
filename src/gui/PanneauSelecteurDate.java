package gui;

import java.awt.Color; 
import java.awt.Dimension;

import java.util.Calendar;

//Les composants
import javax.swing.JPanel;

import clinique.Clinique;

import javax.swing.BoxLayout;
import javax.swing.JButton; 
import javax.swing.JComboBox;

//Les layouts
import java.awt.BorderLayout; 
import java.awt.GridLayout;

//Les �v�nements
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;

/**
 * Panneau qui permet de s�lectionner une date et de g�rer les 
 * rendez-vous de la clinique.
 * 
 * Pour cette partie, le panneau montre un calendrier mais
 * n'impl�mente pas les �v�nements.  Cela se fera dans la partie 2 du travail.  
 * 
 * Ce code est fourni aux �tudiants mais n'a pas � �tre consult� pour la partie 1.
 * 
 * Dans le cadre du cours inf111, travail pratique num�ro 3
 * (voir �nonc� INF111 A17 tp3 partie 1 fourni).
 * 
 * @author Pierre B�lisle
 * @version Copyright A2017
 *
 */
public class PanneauSelecteurDate extends JPanel{
	
	//�vite un warning mais est inutilis�
	private static final long serialVersionUID = 1L;
	
	/*
	 * Strat�gie : Un panneau priv� pour s�lectionner le mois et l'ann�e dans des
	 *                   composants le permettant (voir panneauComboMoisAnnee).
	 * 
	 *                   Un panneau priv� de boutons ajust� selon le nombre de jour 
	 *                   du mois et l'ann�e.  Lorsqu'un bouton est cliqu�, on le met
	 *                   rouge et on remet blanc l'ancien jour s�lectionn�.  Pour cela,
	 *                   on utilise un attribut global (boutonActif)
	 *                   
	 *                   On utilise la classe Calendar qui existe d�j� et qui nous
	 *                   permet d'obtenir facilement le jour associ� � une date.
	 *                   Cela pour afficher les boutons aux bons endroits dans la
	 *                   grille.
	 */
	
	//Dimension de la fen�tre
	private final int LARGEUR = 380;
	private final int HAUTEUR = 380;
	
	//Permet le choix du mois et de l'ann�e 
	PanneauComboMoisAnnee panneauComboMoisAnnee;

	//Panneau montrant les jour du mois
	PanneauJour panneauJour;		
	
	//obtenir la date du jour et maintenir le choix de l'utilisateur
	Calendar cTravail;
	
	//Sert a remettre l'ancien jour en blanc lorsqu'un nouveau jour est choisi
	JButton boutonActif;
	
	private Clinique clinique;
	
	/**
	 * Constructeur qui permet de s�lectionner une date et de l'obtenir dans un 
	 * objet de la classe Calendar.
	 * 
	 * @param Le titre de la fen�tre de dialogue
	 */
	public PanneauSelecteurDate(String titre, Clinique clinique){

		
		/*
		 *  On laisse tout dans le constructeur plut�t que cr�er une m�thode 
		 *  initComposants car un DateChooser est initialis�e une seule fois 
		 *  par utilisation.
		 */

		this.clinique = clinique;
	
		//Sert � obtenir la date de l'ordi
		cTravail = Calendar.getInstance();
		
		//Cr�ation du panneau permettant de s�lectionner le mois et l'ann�e
		panneauComboMoisAnnee = new PanneauComboMoisAnnee();
				
		//Cr�ation du panneau permettant de s�lectionner LE JOUR
		panneauJour = new PanneauJour();
						
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		//ajout des composants dans le panneau de contenu de la fen�tre
		add(panneauComboMoisAnnee, BorderLayout.PAGE_START);
		add(panneauJour);
		
		//Ajuste la dimension du panneau.
		UtilitaireSwing.setDimension(this, 
				new Dimension(LARGEUR,HAUTEUR));
		
	}
	
	/**
	 * Retourne 1 si l'ann�e est bissextile et 0 sinon.
	 * 
	 * @param annee l'ann�e actuelle
	 * @return 1 si l'ann�e est bissextile et 0 sinon
	 */
	private int estBissextile(int annee){
		
		//L'an��e est bissextile au 400 ans ou si 
		//c'est un multiple de 4 mais pas de 100 (Almanah du peuple)
		if((annee%400 == 0) || (annee % 4 == 0 && annee % 100 != 0))
			return 1;
		
		return 0;
	}
	
	/*
	 * Retourne la date s�lectionn�e en String
	 * @return  La date choisie en String
	 */
	public Calendar getCalendar(){
				
		return cTravail;
	}

	
	/**
	 * 
	 * CLASSE INTERNE ET PRIV�E
	 * 
	 * Permet de s�lection le mois et l'ann�e visa des JComboBox
	 * 
	 * @author pbelisle
	 *
	 */
	private class PanneauComboMoisAnnee extends JPanel{
		
		
		/**
		 *  Strat�gie : On met les noms de mois dans un tableau pour la 
		 *                    pr�sentation dans un JComboBox.
		 *                    
		 *                    Les ann�es aussi sont dans un JComboBox de String qu'on
		 *                    ajoute item par item dans une boucle.
		 *                    
		 *                    Tout est dans le constructeur car initialis� une seule fois.
		 *                      
		 */
		
		//�vite un warning mais est inutilis�
		private static final long serialVersionUID = 1L;

		//Le tableau avec les noms de mois
		private final String[] TAB_NOM_MOIS = new String[] 
				{"Janvier", "F�vrier", "Mars", "Avril", "Mai",
	            "Juin", "Juillet", "Ao�t", "Septembre", "Octobre",
	            "Novembre", "D�cembre"};
		
		//Valeur arbitrairement choisie.
		private final int MIN_ANNEE = 1963;
		private final int MAX_ANNEE = 2100;
		
		//Un JComboBox pour chaque
		private JComboBox<String> comboMois;
		private JComboBox<String> comboAnnee;
		 
		
		/**
		 * Constructeur
		 *   
		 */
		public PanneauComboMoisAnnee(){
			
			//Cr�ation du combo qui contient les mois et s�lection du mois
			//actuel
			comboMois = new JComboBox<String>(TAB_NOM_MOIS);
			comboMois.setSelectedIndex(cTravail.get(Calendar.MONTH));
			
			//L'�couteur ne retient que la valeur s�lectionn�e
			comboMois.addActionListener(new MonEcouteurComboMois());
						
			//Cr�ation de la liste des ann�es
			comboAnnee = new JComboBox<String>();
			
			//Ajout des ann�es une par une.  
			//Pour changer l'intervalle, il faut changer les constantes
			for(int i = MIN_ANNEE; i <= MAX_ANNEE; i++)
			   comboAnnee.addItem(new String(String.valueOf(i)));
			
			//s�lectionne l'ann�e en cours
			comboAnnee.setSelectedItem(
					String.valueOf(cTravail.get(Calendar.YEAR)));		
			
			//L'�couteur ne retient que la valeur s�lectionn�e
			comboAnnee.addActionListener(new MonEcouteurComboAnnee());
			
			add(comboMois);
			add(comboAnnee);
			
			UtilitaireSwing.setDimension(this, new Dimension(162, 45));
		}
		
		
		private class MonEcouteurComboMois implements ActionListener{

			public void actionPerformed(ActionEvent arg0) {
				
				cTravail.set(Calendar.MONTH, comboMois.getSelectedIndex());
				
				panneauJour.initComposants();
			}
			
		}
				
		private class MonEcouteurComboAnnee implements ActionListener{

			public void actionPerformed(ActionEvent arg0) {
				
				cTravail.set(Calendar.YEAR,
						Integer.valueOf((String)comboAnnee.getSelectedItem()));
				
				panneauJour.initComposants();
			}
			
		}
		
	}
	
	/**
	 * CLASSE INTERNE ET PRIV�E
	 * 
	 * 
	 * Panneau qui contiendra les jours possibles selon le mois re�u
	 * @author pbelisle
	 *
	 */
	private class PanneauJour extends JPanel{
		

        /**
		 * Strat�gie : On utilise un tableau de String pour les noms de jour et le 
		 *                   nombre de jours maximum permis par mois.
		 *                   
		 *                   Pour le cas f�vrier, on utilise la m�thode locale priv�e 
		 *                   estBissextile pour d�terminer si on ajoute 1 au nombre 
		 *                   de jour ou non.  
		 *                   
		 *                   Le panneau des jours se remet � jour aussit�t que 
		 *                   le mois ou l'ann�e change et que le panneau est redessin�.
		 *                   Cela parce qu'on a mis le code dans paintComponent.
		 *                   
		 *                   
		 */
		//�vite un warning mais est inutilis�
		private static final long serialVersionUID = 1L;

		//M�me strat�gie que pour les mois du panneauComboMoisAnnee
		private final String[] TAB_JOUR_SEMAINE = new String[] 
				{"D","L","Ma","Me","J","V","S"};
        
		//Nombre de jours permis par mois
		private final int[] TAB_NB_JOUR_MAX_PAR_JOUR = new int[] 
				{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		//Allure du calendrier (GridLayout)
		private int NB_LIGNE = 7; 
		private int NB_COLONNE = 7; 
				
		
		public PanneauJour(){
			
			//On veut une grille pour mettre les jours
			setLayout(new GridLayout(NB_LIGNE,NB_COLONNE));		
			
			initComposants();
		}
		
		
		/**
		 * �vite de devoir appeler initComposants() directement dans les 
		 * contr�leurs du panneau pour la s�ection du mois et de l'ann�e.
		 */
		public void initComposants(){
			
			//�vite pls appels aux accesseurs
			int mois = cTravail.get(Calendar.MONTH);
			int annee = cTravail.get(Calendar.YEAR); 			
			/*
			 * Strat�gie : On recr�e le panneau de boutons � chaque r�affichage.
			 *                   On le vide d'abord et on utilise des m�thodes priv�es
			 *                   pour le remplir � nouveau.
			 *        
			 */
			//Conseill�			
			removeAll();
			
			//Pour ajouter 1  jour en f�vrier des ann�es bissextiles
			int bissex = 0;
			
			//On appelle la fonction seulement en f�vrier
			if(mois== Calendar.FEBRUARY)
				bissex = estBissextile(annee);
			
			//On cr�er et ajoute les boutons
			ajouterBouton(TAB_NB_JOUR_MAX_PAR_JOUR[mois] + bissex);
			
			validate();
			
		
		}
		
		/*
		 * Ajouter les boutons d'ent�te contenant les jours de la semaine
		 */
		private void ajouterBoutonEntete(){
			
			/*
			 * Strat�gie : On cr�e un bouton avec chaque valeur du tableau
			 *                   qui contient les noms de jour et on les ajoute au panneau.
			 */
			JButton b;
			
			for(int i = 0; i < TAB_JOUR_SEMAINE.length; i++){
				
				b = new JButton(TAB_JOUR_SEMAINE[i]);
				
				b.setBackground(Color.LIGHT_GRAY);
				
				add(b);
			}		
		}
		
		
		/*
		 * Ajoute nb boutons vides de couleur de fond blanc dans le panneau
		 */
		private void ajouterBoutonVide(int nb){
			
			JButton b;
			
			for(int i = 0; i <nb;i++){
				b = new JButton();
				
				b.setBackground(Color.WHITE);
				
			    add(b);
			}			    
		}
		
		/*
		 * Ajoute les boutons de 1 au nombre de jour max pour le mois fourni.
		 * 
		 * 
		 */		
		private void ajouterBoutonJour(int nbJour, int jourActuel){
			
			/*
			 * Strat�gie : Dans une boucle pour toutes les valeurs possibles de
			 *                  jour ( 1 � nbJour) on cr�e un bouton avec la valeur.
			 *                  
			 *                   Lorsque le jour  repr�sente le jourActuel re�u, il est mis 
			 *                   rouge, retient pour traitement futur dans boutonActif.
			 */
			MonEcouteurBouton ecouteBouton = new MonEcouteurBouton();
			
			//Bouton � cr�er et � mettre dans le panneau
			JButton b;
			
			//Les jours
			for(int i = 1; i <= nbJour;i++){
				
				b = new JButton(String.valueOf(i));
				
				//On retient le jour qui est mis rouge pour pouvoir
				//le remettre blanc lors du clique d'un autre bouton
				//(voir MonEcouteurBouton).
				
				if(i == jourActuel){
					
				   boutonActif = b;
				   b.setBackground(Color.RED);
				}
				else					
				   b.setBackground(Color.WHITE);
				
				b.addActionListener(ecouteBouton);
				
				add(b);			
			}						
		}
				
		/**
		 * Proc�dure qui utilise les sous programmes d'ajout 
		 * de boutons pour cr�er le calendrier
		 *  
		 * @param nbJour  Le nombre de jout du mois actuel
		 */
		private void ajouterBouton(int nbJour){
			
			/*
			 * Strat�gie : On se cr�e une copie de l'objet Calendar pour le mettre
			 *                   au premier jour du mois et obtenir le jour de la semaine
			 *                   que le mois commence.  On cr�e les boutons � partir 
			 *                   de cette valeur.
			 *                   
			 *                   La cr�ation des boutons est r�alis�e par les m�thodes 
			 *                   priv�es locales pr�vues.
			 */
			Calendar cTmp = Calendar.getInstance(); 
				
			//L'Ent�te avec les jours de la semaine
			ajouterBoutonEntete();
			
			//Pour trouver le premier jour de la semaine, on set le calendrier
			//au premier jour du mois et on r�cup�re quel jour de la semaine c'est.
			cTmp.set(cTravail.get(Calendar.YEAR), cTravail.get(Calendar.MONTH), 1);
			
			int premierJour = cTmp.get(Calendar.DAY_OF_WEEK);
			
			//Ajouter les boutons vides avant le premier du mois
			ajouterBoutonVide(premierJour-1);
			
			//Ajoute les jours
			ajouterBoutonJour(nbJour, cTravail.get(Calendar.DAY_OF_MONTH));
			
			//Ajoute des boutons � la fin pour garder la taille de la grille
			ajouterBoutonVide(NB_LIGNE * NB_COLONNE -
					(nbJour+TAB_JOUR_SEMAINE.length+premierJour-1));
		}
		
		/**
		 * � faire pour chaque bouton, on change la couleur selon
		 * le bouton cliqu� et on remet l'ancien � blanc.
		 * 
		 * On appelle aussi la proc�dure qui affiche les plages horaires.
		 * 
		 * @author pbelisle
		 */
		private class MonEcouteurBouton implements ActionListener{
			
			public void actionPerformed(ActionEvent arg0) {
				
				JButton b = (JButton) arg0.getSource();
				
				//Si on touche � un bouton, on veut retenir le  jour actuel
				//et changer la couleur de celui qui est choisi en 
				//changeant celui qui �tait choisi avant. � moins
				//que ne soit un double clique.
				cTravail.set(Calendar.DAY_OF_MONTH, Integer.valueOf(b.getText()));
								
				b.setBackground(Color.RED);
				
				//�vite de remettre blanc lors d'un double clique.  En d'autres mots,
				//on ne permet pas de n'avoir aucun jour de s�lectionn�e.
				if(boutonActif != b)
				    boutonActif.setBackground(Color.WHITE);
				
				boutonActif = b;
				
				/*
				 * Strat�gie : On d�marrera la JDialog qui montre une plage horaire et 
				 * permet a gestion de tous les rendez-vous.  Partie 2 tp3.
				 */

			}			
		}				
	}	
}