package celldiv.cell;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public abstract class Cell {
    // First draft of Cell abstract
	private String name; // name if necessary
    private String image; // illust-image link
    private String otherComponents; // and function explaination
    public ObservableList<Phase> phases = FXCollections.observableArrayList(); // phase information
    // Constructor
	public Cell() {
		super();
		
	}
    // Getter - Setter

    public void addPhase(Phase phase) {
		phases.add(phase);
	}

}
