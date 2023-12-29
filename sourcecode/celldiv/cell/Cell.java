package celldiv.cell;
import java.util.ArrayList;

public abstract class Cell {
	private final int MAX_PHASES = 10;	// depend on how to split phases ...
										// ... but we believe 10 is very very enough
	private String cellName; 			// cell name, if necessary
    private String cellIMG; 			// Illustration image link
    // Description of cell components
    private String chromosome;
    private String ribosome;
    private String cytoplasm;
    private String membrance;
    private ArrayList<Phase> phases = new ArrayList<Phase>(MAX_PHASES);
    // Constructor
	public Cell(String cellName, String cellIMG) {
		super();
		this.cellName = cellName;
		this.cellIMG = "/celldiv/img/"+cellIMG;
		this.chromosome = "store and transmit genetic information, ensure the cell's proper functioning and inheritance of traits to offspring";
		this.ribosome = "read the cell's genetic code and assemble proteins from amino acids";
		this.cytoplasm = "fills the interior of the cell and contains all the other cellular components";
		this.membrance = "forms a selective barrier around the cell, controlling what comes in and out";
	}

	public void addPhase(Phase phase) { // handle this pls
		if (phases.size()<MAX_PHASES) phases.add(phase);
		else System.out.println("[EXCEPTION] DID YOU THINK THAT MORE THAN 10 PHASES IS JUST TOO MUCH?");
	}
	
    // Getter
    public String getName() {
    	return this.cellName;
    }

    public String getIMG() {
    	return this.cellIMG;
    }

}
