package gui;

import javax.swing.JPanel;

import clinique.Participant;

/**
 * � vous de commenter
 * 
 * @author
 * @version
 *
 */

public class PanneauSaisieParticipant extends JPanel 
implements InterfacePanSaisieParticipant {
	
    private static final long serialVersionUID = 1L;

    /**
     * � vous de commenter
     * 
     */
    public PanneauSaisieParticipant() {

    }

    @Override
    public Participant getParticipant() {
        return null;
    }

    @Override
    public boolean aviserDuneErreur() {
        return false;
    }

    @Override
    public void reset() {
        
    }
}
