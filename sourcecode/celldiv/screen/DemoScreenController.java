package celldiv.screen;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import celldiv.cell.*;


public class DemoScreenController {
	private int type;
	private Scene scene;
	private Stage stage;
	
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
	
	public DemoScreenController(int number) {
		super();
		this.type = number;
	}
}
