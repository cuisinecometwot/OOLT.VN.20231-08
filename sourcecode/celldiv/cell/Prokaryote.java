package celldiv.cell;
public class Prokaryote extends Cell {
	public String fagellum;
	public Prokaryote(String cellName, String cellIMG) {
		super(cellName, cellIMG);
		this.fagellum = "help moving around in their environment";
	}
	public String getFagellum() {
		return this.fagellum;
	}
}