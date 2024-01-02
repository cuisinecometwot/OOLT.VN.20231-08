package celldiv.screen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import celldiv.cell.*;

public class DemoScreenController {
	private Cell cell = DemoScreen.cell;
	@FXML
	private ComponentsController componentsController;
	@FXML
	private DivisionController divisionController;
	@FXML
	private Button home;
	
	@FXML
	public void handleHomeButtonAction(ActionEvent event) {
	    MainScreen.main(null);
	}
	public DemoScreenController(Cell cell) {
		super();
		this.cell = cell;
	}
}
