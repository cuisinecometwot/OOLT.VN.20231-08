package celldiv.cell;

import javax.naming.LimitExceededException;
import java.util.ArrayList;

public class CellCollection {
	public static final int MAX_CELL = 5;
	private ArrayList<Cell> collection = new ArrayList<>();
	
	public void addCell(Cell cell) throws LimitExceededException {
		if (collection.size() < MAX_CELL) {
			collection.add(cell);
			System.out.println("+1 cell!");
		}
		else {
			throw new LimitExceededException("[ERROR] Limit reached! Hãy nạp lần đầu để tăng hạn mức!");
		}
	}
	public boolean checkCellByName(String name) {
		for (Cell cell : collection) {
			if (cell.getName()==name) return true;
		}
		return false;
	}
	public Cell getCellByName(String name) {
		for (Cell cell : collection) {
			if (cell.getName()==name) return cell;
		}
		return null;
	}
	public ArrayList<Cell> getCellList() {
		return collection;
	}
}
