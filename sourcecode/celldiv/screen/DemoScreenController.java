package celldiv.screen;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import celldiv.cell.*;

public class DemoScreenController {
	private Cell cell = DemoScreen.cell;
	private Scene scene;
	private Stage stage;
	
	@FXML
	private ComponentsController componentsController;
	private DivisionController divisionController;
	@FXML
	private Button home;
	private Button play;
	private Button pause;
	private Button next;
	private Button back;
	private Button replay;
	
	@FXML
	public void handleHomeButtonAction(ActionEvent event) {
	    MainScreen.main(null);
	}
	public void handlePlayButtonAction(ActionEvent event) {
		// nanika
	}
	public void handlePauseButtonAction(ActionEvent event) {
		// nanika
	}
	public void handleBackButtonAction(ActionEvent event) {
		// nanika
	}
	public void handleNextButtonAction(ActionEvent event) {
		// nanika
	}
	public void handleReplayButtonAction(ActionEvent event) {
		// nanika
	}
	
	public DemoScreenController(Cell cell) {
		super();
		this.cell = cell;
	}
}
