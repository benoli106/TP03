package gui;

import clinique.Clinique;
import clinique.Participant;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * Cadre de Gestion principal où on va y trouver une liste de participants.
 * Affiche une liste dans l'interface de participants, déterminer par l'objet du
 * menu qui sera cliquer dans le cadreClinique.
 *
 * @Long Tran & Benjamin Fontaine
 * @version
 *
 */
public class CadreGestionParticipant extends JDialog {

    //Attributs
    private static final long serialVersionUID = 1L;
    private Clinique clinique;
    private InterfacePanSaisieParticipant interfaceSaisie;
    private List<Participant> listeParticipant;
    private JPanel panneauPrincipal;
    private Dimension dimension;
    private Point position;

    /**
     * Recoie un objet clinique, interface de saisie, une liste de participant
     * une position et une dimension. Initialise ses attributs avec ce qu'il
     * recoit en parametre puis fait appel à la méthode qui initialise 
     * les composantes.
     *
     * Interdit de modifier l'ent�te formel.
     */
    public CadreGestionParticipant(Clinique clinique,
            InterfacePanSaisieParticipant panneauSaisie,
            List<Participant> listeParticipant,
            Point position,
            Dimension dimCadre) {

        //On initialise les attributs avec les valeurs recues
        //dans le constructeur
        this.clinique = clinique;
        this.interfaceSaisie = panneauSaisie;
        this.listeParticipant = listeParticipant;
        this.position = position;
        this.dimension = dimCadre;

        //On set l'operation de fermeture par défaut à hide
        this.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);

        //On initialise les composantes;
        this.init();
    }

    public void init() {

        //Création du tableau et de la liste à partir de la liste recue
        //En parametre
        JTable tableAfficher = UtilitaireSwing.obtenirListe_A_Afficher(this.listeParticipant.toArray());

        JScrollPane listeDeroulante = new JScrollPane();

        listeDeroulante.add(tableAfficher);

        //Création du panneau du bas avec les boutons
        JPanel panneauBas = new JPanel();

        //Création du panneau de Gestion
        JPanel panneauGestion = new JPanel();

        //Création des boutons avec les actiosnlisteners
        JButton ajouter = new JButton("Ajouter");
         ajouter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                passerModeAjout();
            }
        });
         
        JButton supprimer = new JButton("Supprimer");
        supprimer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                supprimerSelections();
            }
        });
        //On ajoute les boutons au panneau de gestion
        panneauGestion.add(ajouter);
        panneauGestion.add(supprimer);

        //On ajouter le panneau de gestion au panneau du bas et on y met un layout
        //de type cardLayout
        panneauBas.add(panneauGestion);
        panneauBas.setLayout(new CardLayout());

        //On initialise le panneauPrincipal;
        this.panneauPrincipal = (JPanel) this.getContentPane();

        //On ajoute les composants finaux au JPanel principal et on le met visible,
        // et on set la positio et dimension
        this.panneauPrincipal.add(listeDeroulante);
        this.panneauPrincipal.add(panneauBas, BorderLayout.PAGE_END);
        this.panneauPrincipal.setBounds(this.position.x, this.position.y,
                this.dimension.width, this.dimension.height);

        this.panneauPrincipal.setVisible(true);

    }

    public void passerModeAjout(){
        
    }
    public void supprimerSelections(){
        
    }
}

