package celldiv.cell;
public class Eukaryote extends Cell {
	public String nucleus;
	public String microtubules;
	public Eukaryote(String cellName, String cellIMG) {
		super(cellName, cellIMG);
		this.nucleus = "Control center of the cell, housing the genetic material (DNA) and regulating cell activities like growth, division, and protein synthesis";
		this.microtubules = "provide shape and support, and enable movement like transport of vesicles and cell division";
	}
	public String getNucleus() {
		return this.nucleus;
	}
	public String getMicrotubules() {
		return this.microtubules;
	}
}