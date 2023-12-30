package celldiv.cell;

public class Phase {
	private String phaseIMG;    // Illustration image link (/celldiv/img/*.png)
    private String phaseTitle;	// Phase name
	private String phaseInfo;   // Phase description
	// Constructor
	public Phase(String phaseIMG, String phaseTitle) {
		super();
		this.phaseIMG = "/celldiv/img/"+phaseIMG;
        this.phaseTitle = phaseTitle;
	}
	
	public Phase(String phaseIMG, String phaseTitle, String phaseInfo) {
		super();
		this.phaseIMG = "/celldiv/img/"+phaseIMG;
        this.phaseTitle = phaseTitle;
		this.phaseInfo = phaseInfo;
	}

	// Getter
	public String getIMG() {
		return this.phaseIMG;
	}

	public String getTitle() {
		return this.phaseTitle;
	}

    public String getInfo() {
		return this.phaseInfo;
	}
    
    public String toString() {
    	return this.getTitle()+'\n'+this.getInfo();
    }
}
