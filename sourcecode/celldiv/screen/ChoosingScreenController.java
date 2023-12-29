package celldiv.screen;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import celldiv.screen.HelpScreen;
import celldiv.screen.MainScreen;
import celldiv.screen.DemoScreen;
import celldiv.cell.Cell;
public class ChoosingScreenController {
	@FXML
    void btnHelpPressed(ActionEvent event) {
		new HelpScreen();
    }

    @FXML
    void btnHomePressed(ActionEvent event) {
    	MainScreen.main(null);
    }
    
    @FXML
    private Button btnInvestigation;

    @FXML
    void btnInvestigatePressed(ActionEvent event) {
    	new DemoScreen();
    }
}
