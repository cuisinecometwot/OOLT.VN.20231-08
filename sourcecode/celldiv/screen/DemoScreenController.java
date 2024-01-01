package celldiv.screen;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import celldiv.cell.*;

public class DemoScreenController {
	private Cell cell = DemoScreen.cell;
	
	@FXML
	private ComponentsController componentsController;
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
