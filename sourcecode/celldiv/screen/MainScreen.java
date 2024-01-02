package celldiv.screen;
import java.io.IOException;
import javax.naming.LimitExceededException;
import javax.swing.JFrame;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import celldiv.cell.*;


public class MainScreen extends JFrame {
	protected  CellCollection proka_collection;
	protected  CellCollection euka_collection;
	public MainScreen(CellCollection proka_collection, CellCollection euka_collection) {
		super();
		this.proka_collection = proka_collection;
		this.euka_collection = euka_collection;
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		this.setTitle("DIVIDE AND CONQUER");
		this.setVisible(true);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		JFrame frame = this;
		
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/celldiv/screen/MainScreen.fxml"));
					MainScreenController controller = new MainScreenController(frame, proka_collection, euka_collection);
					loader.setController(controller);
					Parent root = loader.load();
					fxPanel.setScene(new Scene(root));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void main(String[] args) {
		// Initialization
		CellCollection proka_collection = new CellCollection();
		CellCollection euka_collection = new CellCollection();
		
		// Create 3 cells with different cell division type and phases
		// Prokaryote only has Amitosis

		Prokaryote amitosis = new Prokaryote("Amitosis", "proka/proka-0.png");
		Phase amitosis1 = new Phase("proka/amitosis-1.png","Interphase","In this phase, the cell grows and replicates its DNA. The DNA is not condensed into chromosomes at this point.");
		Phase amitosis2 = new Phase("proka/amitosis-2.png","Nuclear division","The nucleus begins to elongate and then constricts in the middle.");
		Phase amitosis3 = new Phase("proka/amitosis-3.png","Cytoplasmic division","The cytoplasm of the cell is pinched in two along with the nucleus, forming two daughter cells.");
		amitosis.addPhase(amitosis1);
		amitosis.addPhase(amitosis2);
		amitosis.addPhase(amitosis3);
		
		// Eukaryote has Mitosis and Meiosis
		Eukaryote mitosis = new Eukaryote("Mitosis", "euka/euka-0.png");
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
		
		Eukaryote meiosis = new Eukaryote("Meiosis", "euka/euka-0.png");
		Phase meiosis1 = new Phase("euka/meiosis-1.png","Prophase I","- Chromosomes condense, pair up and also exchange fragments.");
		Phase meiosis2 = new Phase("euka/meiosis-1.png","Metaphase I","- Homologue pairs—not individual chromosomes—line up at the metaphase plate for separation.");
		Phase meiosis3 = new Phase("euka/meiosis-1.png","Anaphase I","- The homologues are pulled apart and move apart to opposite ends of the cell.\n"
				+ "- The sister chromatids of each chromosome remain attached to one another and don't come apart.");
		Phase meiosis4 = new Phase("euka/meiosis-1.png","Telophase I","- The chromosomes arrive at opposite poles of the cell.\n"
				+ "- Cytokinesis usually occurs at the same time as telophase I, forming two haploid daughter cells.");
		Phase meiosis5 = new Phase("euka/meiosis-2.png","Prophase II","- Chromosomes condense and the nuclear envelope breaks down, if needed.\n"
				+ "- The centrosomes move apart, the spindle forms between them, and the spindle microtubules begin to capture chromosomes.");
		Phase meiosis6 = new Phase("euka/meiosis-2.png","Metaphase II","- The chromosomes line up individually along the metaphase plate.");
		Phase meiosis7 = new Phase("euka/meiosis-2.png","Anaphase II","- The sister chromatids separate and are pulled towards opposite poles of the cell.");
		Phase meiosis8 = new Phase("euka/meiosis-2.png","Telophase II","- Nuclear membranes form around each set of chromosomes, and the chromosomes decondense.\n"
				+ "- Cytokinesis splits the chromosome sets into new cells, forming the final products of meiosis: four haploid cells in which each chromosome has just one chromatid.");
		meiosis.addPhase(meiosis1);
		meiosis.addPhase(meiosis2);
		meiosis.addPhase(meiosis3);
		meiosis.addPhase(meiosis4);
		meiosis.addPhase(meiosis5);
		meiosis.addPhase(meiosis6);
		meiosis.addPhase(meiosis7);
		meiosis.addPhase(meiosis8);
		
		try {
			proka_collection.addCell(amitosis);
			euka_collection.addCell(mitosis);
			euka_collection.addCell(meiosis);
		} catch (LimitExceededException e) {e.printStackTrace();}
		
		new MainScreen(proka_collection, euka_collection);
	}
}