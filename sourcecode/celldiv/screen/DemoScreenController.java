package celldiv.screen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javax.swing.JFrame;
import javafx.scene.control.Button;
import celldiv.cell.*;
public class DemoScreenController {
	private Cell cell = DemoScreen.cell;
	private JFrame frame;
	@FXML
	private ComponentsController componentsController;
	@FXML
	private DivisionController divisionController;
	@FXML
	private Button home;
	
	@FXML
	public void handleHomeButtonAction(ActionEvent event) {
		frame.dispose();
	    MainScreen.main(null);
	}
	public DemoScreenController(JFrame frame, Cell cell) {
		super();
		this.frame = frame;
		this.cell = cell;
	}
}
