package celldiv.cell;

public class Phase {
	private String phaseIMG;    // Illust image link
    private String phaseTitle;
	private String phaseInfo;   // Phase description
	
	public Phase(String phaseIMG, String phaseInfo) {
		super();
		this.phaseIMG = phaseIMG;
        this.phaseTitle = phaseTitle;
		this.phaseInfo = phaseInfo;
	}

	public String getPhaseIMG() {
		return phaseIMG;
	}

	public String getPhaseTitle() {
		return phaseTitle;
	}

    public String getPhaseInfo() {
		return phaseInfo;
	}
}
