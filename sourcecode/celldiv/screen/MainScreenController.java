package celldiv.screen;

import javax.swing.JOptionPane;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import celldiv.cell.*;

public class MainScreenController {
	private CellCollection proka_collection;
	private CellCollection euka_collection;
	@FXML
    void btnHelpPressed(ActionEvent event) {
		new HelpScreen();
    }
    @FXML
    void btnQuitPressed(ActionEvent event) {
    	int input = JOptionPane.showConfirmDialog(null, "DO YOU WANT TO QUIT?", "Confirm to quit", JOptionPane.YES_NO_OPTION);
    	if (input == 0) System.exit(0);
    }

    @FXML
    void btnProkaPressed(ActionEvent event) {
    	String[] choices = {"Amitosis"};
        String input = (String) JOptionPane.showInputDialog(null, "But ... which type?",
            "You choose ... Prokaryote!", JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
        System.out.println(input);
        if (proka_collection.checkCellByName("Amitosis")) new DemoScreen(proka_collection.getCellByName("Amitosis"));
        else System.out.println("[EXCEPTION]"); // handle when User hit "Cancel"
    }

    @FXML
    void btnEukaPressed(ActionEvent event) {
    	String[] choices = {"Mitosis","Meiosis"};
        String input = (String) JOptionPane.showInputDialog(null, "But ... which type?",
            "You choose ... Eukaryote!", JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
        System.out.println(input);
        if (input=="Mitosis") new DemoScreen(euka_collection.getCellByName("Mitosis"));
        else if (input=="Meiosis") new DemoScreen(euka_collection.getCellByName("Meiosis"));
		else System.out.println("[EXCEPTION]"); // handle when User hit "Cancel"
    }
    // function for main screen
    
    public MainScreenController(CellCollection proka_collection, CellCollection euka_collection) {
    	super();
    	this.proka_collection = proka_collection;
    	this.euka_collection = euka_collection;
	}
}
