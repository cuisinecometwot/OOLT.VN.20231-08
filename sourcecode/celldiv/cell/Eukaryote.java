package celldiv.cell;
public class Eukaryote extends Cell {
	public String nucleus;
	public String microtubules;
	public Eukaryote(String cellName, String cellIMG) {
		super(cellName, cellIMG);
		this.nucleus = "Control center of the cell, housing the genetic material (DNA) and regulating cell activities like growth, division, and protein synthesis";
		this.microtubules = "provide shape and support, and enable movement like transport of vesicles and cell division";
	}
}
/* The main difference between Prokaryotic cells and Eukaryotic cells
 * is that Proka lack membrance-bound organelles and a true nucleus,
 * while Euka contain membrance-bound organelles, including a true nucleus.
 */ 
/* Mitosis (Nguyen Phan)
 * Prophase / Early Prophase
 * - Chromosomes condense and become visible. 
 * - Nuclear envelope starts to break down. 
 * - Spindle fibers begin to form.
 * Prometaphase / Late Prophase
 * - Nuclear envelope fully disintegrates.
 * - Spindle fibers extend across the cell, connecting to chromosomes.
 * Metaphase
 * - Chromosomes line up in the middle of the cell to divide.
 * - Two kinetochores of each chromosome attaches to microtubules from opposite spindle poles.
 * Anaphase
 * - The sister chromatids separate from each other and are pulled towards opposite ends of the cell.
 * Telophase
 * - The cell is almost divided and starts to re-establish its normal cellular structures as cytokinesis takes place.
 * - Chromatids reach opposite poles and decondense into chromosomes.
 * - The mitotic spindle breaks down and two new nuclei are formed, one for each set of chromosomes.
 * - Finally, after Cytokinesis process, two genetically identical daughter cells with complete cellular components are formed.
 */
/* Meiosis (Giam Phan)
 * Prophase I
 * - Chromosomes condense, pair up and also exchange fragments.
 * Metaphase I
 * - Homologue pairs—not individual chromosomes—line up at the metaphase plate for separation.
 * Anaphase I
 * - The homologues are pulled apart and move apart to opposite ends of the cell.
 * - The sister chromatids of each chromosome remain attached to one another and don't come apart.
 * Telophase I
 * - The chromosomes arrive at opposite poles of the cell.
 * - Cytokinesis usually occurs at the same time as telophase I, forming two haploid daughter cells.
 * Prophase II
 * - Chromosomes condense and the nuclear envelope breaks down, if needed.
 * - The centrosomes move apart, the spindle forms between them, and the spindle microtubules begin to capture chromosomes.
 * Metaphase II
 * - The chromosomes line up individually along the metaphase plate.
 * Anaphase II
 * - The sister chromatids separate and are pulled towards opposite poles of the cell.
 * Telophase II
 * - Nuclear membranes form around each set of chromosomes, and the chromosomes decondense.
 * - Cytokinesis splits the chromosome sets into new cells, forming the final products of meiosis: four haploid cells in which each chromosome has just one chromatid.
 */