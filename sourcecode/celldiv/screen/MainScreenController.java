package celldiv.screen;

import javax.swing.JOptionPane;

import celldiv.cell.Eukaryote;
import celldiv.cell.Phase;
import celldiv.cell.Prokaryote;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MainScreenController {
	@FXML
    void btnHelpPressed(ActionEvent event) {
		new HelpScreen();
    }
    @FXML
    void btnQuitPressed(ActionEvent event) {
    	int input = JOptionPane.showConfirmDialog(null, "Do you want to quit?", "Confirm to quit", JOptionPane.YES_NO_OPTION);
    	if (input == 0) System.exit(0);
    }

    @FXML
    void btnProkaPressed(ActionEvent event) {
    	String[] choices = {"Amitosis"};
        String input = (String) JOptionPane.showInputDialog(null, "Choose type...",
            "You choose ... Prokaryote!", JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
        System.out.println(input);
        // forward to Demo Amitosis
        if (input=="Amitosis") {
        	Prokaryote amitosis = new Prokaryote("Prokaryotic Cell", "proka/proka-0.png");
        	Phase amitosis1 = new Phase("proka/amitosis-1.png","Interphase","In this phase, the cell grows and replicates its DNA. The DNA is not condensed into chromosomes at this point.");
        	Phase amitosis2 = new Phase("proka/amitosis-2.png","Nuclear division","The nucleus begins to elongate and then constricts in the middle.");
        	Phase amitosis3 = new Phase("proka/amitosis-3.png","Cytoplasmic division","The cytoplasm of the cell is pinched in two along with the nucleus, forming two daughter cells.");
        	amitosis.addPhase(amitosis1);
        	amitosis.addPhase(amitosis2);
        	amitosis.addPhase(amitosis3);
        	// new DemoScreen(0);
        	new HelpScreen();
        } else System.out.println("EXCEPTION!"); // handle this pls
    }

    @FXML
    void btnEukaPressed(ActionEvent event) {
    	// new ChoosingScreen(1);
    	String[] choices = {"Mitosis","Meiosis"};
        String input = (String) JOptionPane.showInputDialog(null, "Choose type...",
            "You choose ... Eukaryote!", JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
        System.out.println(input);
        
        Eukaryote mitosis = new Eukaryote("Eukaryotic Cell", "euka/euka-0.png");
		Phase mitosis1 = new Phase("euka/mitosis-1.png","Prophase","- Chromosomes condense and become visible.\n"
				+ "- Nuclear envelope starts to break down.\n"
				+ "- Spindle fibers begin to form.");
		Phase mitosis2 = new Phase("euka/mitosis-2.png","Prometaphase","- Nuclear envelope fully disintegrates.\n"
				+ "- Spindle fibers extend across the cell, connecting to chromosomes.");
		Phase mitosis3 = new Phase("euka/mitosis-3.png","Metaphase","- Chromosomes line up in the middle of the cell to divide.\n"
				+ "- Two kinetochores of each chromosome attaches to microtubules from opposite spindle poles.");
		Phase mitosis4 = new Phase("euka/mitosis-4.png","Anaphase","- The sister chromatids separate from each other and are pulled towards opposite ends of the cell.");
		Phase mitosis5 = new Phase("euka/mitosis-5.png","Telophase","- The cell is almost divided and starts to re-establish its normal cellular structures as cytokinesis takes place.\n"
				+ "- Chromatids reach opposite poles and decondense into chromosomes.\n"
				+ "- The mitotic spindle breaks down and two new nuclei are formed, one for each set of chromosomes.\n"
				+ "- Finally, after Cytokinesis process, two genetically identical daughter cells with complete cellular components are formed.");
		mitosis.addPhase(mitosis1);
		mitosis.addPhase(mitosis2);
		mitosis.addPhase(mitosis3);
		mitosis.addPhase(mitosis4);
		mitosis.addPhase(mitosis5);
		
		Eukaryote meiosis = new Eukaryote("Eukaryotic Cell", "euka/euka-0.png");
		Phase meiosis1 = new Phase("euka/meiosis1.png","Prophase I","- Chromosomes condense, pair up and also exchange fragments.");
		Phase meiosis2 = new Phase("euka/meiosis1.png","Metaphase I","- Homologue pairs—not individual chromosomes—line up at the metaphase plate for separation.");
		Phase meiosis3 = new Phase("euka/meiosis1.png","Anaphase I","- The homologues are pulled apart and move apart to opposite ends of the cell.\n"
				+ "- The sister chromatids of each chromosome remain attached to one another and don't come apart.");
		Phase meiosis4 = new Phase("euka/meiosis1.png","Telophase I","- The chromosomes arrive at opposite poles of the cell.\n"
				+ "- Cytokinesis usually occurs at the same time as telophase I, forming two haploid daughter cells.");
		Phase meiosis5 = new Phase("euka/meiosis2.png","Prophase II","- Chromosomes condense and the nuclear envelope breaks down, if needed.\n"
				+ "- The centrosomes move apart, the spindle forms between them, and the spindle microtubules begin to capture chromosomes.");
		Phase meiosis6 = new Phase("euka/meiosis2.png","Metaphase II","- The chromosomes line up individually along the metaphase plate.");
		Phase meiosis7 = new Phase("euka/meiosis2.png","Anaphase II","- The sister chromatids separate and are pulled towards opposite poles of the cell.");
		Phase meiosis8 = new Phase("euka/meiosis2.png","Telophase II","- Nuclear membranes form around each set of chromosomes, and the chromosomes decondense.\n"
				+ "- Cytokinesis splits the chromosome sets into new cells, forming the final products of meiosis: four haploid cells in which each chromosome has just one chromatid.");
		meiosis.addPhase(meiosis1);
		meiosis.addPhase(meiosis2);
		meiosis.addPhase(meiosis3);
		meiosis.addPhase(meiosis4);
		meiosis.addPhase(meiosis5);
		meiosis.addPhase(meiosis6);
		meiosis.addPhase(meiosis7);
		meiosis.addPhase(meiosis8);
		
		if (input=="Mitosis") new DemoScreen(1);
		else if (input=="Meiosis") new DemoScreen(2);
		else System.out.println("EXCEPTION!"); // handle this pls
    }    
    // function for main screen
    
    public MainScreenController() {
    	super();
	}
}
