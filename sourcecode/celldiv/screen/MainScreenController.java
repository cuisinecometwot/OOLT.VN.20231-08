package celldiv.screen;

import javax.swing.JOptionPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MainScreenController {
	@FXML
    void btnHelpPressed(ActionEvent event) {
		new HelpScreen();
    }
    @FXML
    void btnQuitPressed(ActionEvent event) {
    	int input = JOptionPane.showConfirmDialog(null, "Do you want to quit?", "Confirm to quit", JOptionPane.YES_NO_CANCEL_OPTION);
    	if (input == 0) System.exit(0);
    }

    @FXML
    void btnProkaPressed(ActionEvent event) {
    	//new HelpScreen();
    }

    @FXML
    void btnEukaPressed(ActionEvent event) {
    	//new HelpScreen();
    }
    // Function for Main Screen
    public MainScreenController() {
		// TODO Auto-generated constructor stub
    	super();
	}
}
