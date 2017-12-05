package gui;

import clinique.Clinique;
import clinique.Participant;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Cadre de Gestion principal où on va y trouver une liste de participants.
 * Affiche une liste dans l'interface de participants, déterminer par l'objet
 * du menu qui sera cliquer dans le cadreClinique.
 *
 * @Long Tran & Benjamin Fontaine
 * @version
 *
 */
public class CadreGestionParticipant extends JDialog {

    private class boutonsDeSaisie extends JPanel {

        JButton boutonOk;
        JButton boutonAnnule;

        public boutonsDeSaisie() {
            super();

            this.setLayout(new FlowLayout());
            boutonOk = new JButton("Ok");
            boutonOk.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ajouterSiValide();
                }
            });

            boutonAnnule = new JButton("Annule");
            boutonAnnule.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    passerModeNormal();
                }
            });

            this.add(boutonOk);
            this.add(boutonAnnule);

        }

    }

    //Attributs
    private static final long serialVersionUID = 1L;
    private Clinique clinique;
    private PanneauSaisieParticipant interfaceSaisie;
    private List<Participant> listeParticipant;
    private JPanel panneauPrincipal;
    private Dimension dimension;
    private Point position;
    private JPanel cardsAjouter;
    private JPanel cardsNormal;
    private JPanel cardsSupprimer;
    private JPanel cards;
    private JTable tableAfficher;
    private JScrollPane listeDeroulante;

    /**
     * Recoie un objet clinique, interface de saisie, une liste de participant
     * une position et une dimension. Initialise ses attributs avec ce qu'il
     * recoit en parametre puis fait appel à la méthode qui initialise les
     * composantes.
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
        this.interfaceSaisie = (PanneauSaisieParticipant) panneauSaisie;
        this.listeParticipant = listeParticipant;
        this.position = position;
        this.dimension = dimCadre;

        //On set l'operation de fermeture par défaut à hide
        this.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);

        //On initialise les composantes;
        this.initComponents();
    }

    public void initComponents() {

        //Création du tableau et de la liste à partir de la liste recue
        //En parametre
        tableAfficher = UtilitaireSwing.obtenirListe_A_Afficher(this.listeParticipant.toArray());

        listeDeroulante = new JScrollPane();

        listeDeroulante.add(tableAfficher);

        listeDeroulante.setViewportView(tableAfficher);
        
        //Création du panneau de Gestion
        cardsNormal = new JPanel(new CardLayout());

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
        //On ajoute les boutons dans un JPanel puis dans le CardLayout
        JPanel panneauBoutonsGestion = new JPanel();
        panneauBoutonsGestion.add(ajouter);
        panneauBoutonsGestion.add(supprimer);

        cardsNormal.add(panneauBoutonsGestion);

        //On cr?e le panneau de cards pour la menu ajouter avec la sous classe
        //priver boutonsDeSaisie
        cardsAjouter = (JPanel) new boutonsDeSaisie();

        //On cr?e le panneau de cards poue le menu supprimer
        cardsSupprimer = new JPanel();

        //On ajouter le panneau de gestion au panneau du bas et on y met un layout
        //de type cardLayout
        cards = new JPanel(new CardLayout());
        cards.add(cardsNormal, "cardsNormal");
        cards.add(cardsAjouter, "cardsAjouter");

        //On initialise le panneauPrincipal;
        this.panneauPrincipal = new JPanel();
        this.setContentPane(panneauPrincipal);

        this.panneauPrincipal.add(this.interfaceSaisie);

        //On ajoute les composants finaux au JPanel principal et on le met visible,
        // et on set la positio et dimension
        this.panneauPrincipal.add(listeDeroulante);

        if (listeParticipant.isEmpty()) {

            passerModeAjout();

        } else {

            passerModeNormal();

        }

        // ENLEVER ? LA FIN
        passerModeNormal();

        //on ajoute le panneau de cards en bas du panneau principal
        panneauPrincipal.add(cards);

        this.panneauPrincipal.setVisible(true);

        UtilitaireSwing.setDimension(this, dimension);
        this.setLocation(this.position.x, this.position.y);
        this.setVisible(true);
    }

    // Proc?dure qui permet de rendre invisible le panneau de la
    // liste d?roulante des participants et rendre visible le panneau des 
    // entr?es de saisies.
    public void passerModeAjout() {

        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, "cardsAjouter");

        UtilitaireSwing.rafraichirCadre(panneauPrincipal);

    }

    // Proc?dure qui permet de rendre visible le panneau de la
    // liste d?roulante des participants et rendre invisible le panneau des 
    // entr?es de saisies.
    public void passerModeNormal() {

        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, "cardsNormal");

        UtilitaireSwing.rafraichirCadre(panneauPrincipal);

    }

// Proc?dure qui r?cup?re tous les indices de s?lections, boucle et 
    // supprime les participants du Jtable et des donn?es aussi.
    public void supprimerSelections() {

        // Le nombre de participants s?lectionn?s
        int nbSelections = tableAfficher.getSelectedRowCount();

        for (int i = 0; i < nbSelections; i++) {

            // on enl?ve la ligne (le participant) du JTable 
            ((DefaultTableModel) tableAfficher.getModel()).removeRow(i);
            // on enl?ve les donn?es (le participant) du JTable
            ((DefaultTableModel) tableAfficher.getModel()).getDataVector().remove(i);

        }

        // Si on a tout supprimer les participants, on passe au mode ajout
        if (tableAfficher.getRowCount() == 0) {

            passerModeAjout();

        } else {

            UtilitaireSwing.rafraichirCadre(panneauPrincipal);

        }

    }

    // Permet d'ajouter un participant si les donn?es de saisies sont valides
    public void ajouterSiValide() {

        // Si les donn?es de saisie sont valides.
        if (!interfaceSaisie.aviserDuneErreur()) {

            // Si le participant existe d?j? , envoyer un message d'erreur
            if (listeParticipant.contains(interfaceSaisie.getParticipant())) {

                JOptionPane.showMessageDialog(this, "Le participant existe "
                        + "d?j?");

            } else {

                listeParticipant.add(interfaceSaisie.getParticipant());
                // On enleve la table du JScrollPane
                this.listeDeroulante.remove(tableAfficher);

        //On fait une nouvelle table ? partir de la nouvelle liste
                //et on l'affiche
                this.tableAfficher = UtilitaireSwing.obtenirListe_A_Afficher(
                        listeParticipant.toArray());

                this.listeDeroulante.setViewportView(tableAfficher);

                //On rafraichit le cadre avec la nouvelle table/liste
                UtilitaireSwing.rafraichirCadre(panneauPrincipal);
            }

        }

    }

    

}
