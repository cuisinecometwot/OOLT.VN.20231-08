package celldiv.screen;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.naming.LimitExceededException;
import celldiv.cell.*;

public class DivisionController {
	private Cell cell = DemoScreen.cell;
	private int currPhaseID = -1;				// counter
	private Phase currPhase; 					// get first phase
	@FXML
	private Button home;
	@FXML
	private Button play;
	@FXML
	private Button replay;
	@FXML
	private Button pause;
	@FXML
	private Button next;
	@FXML
	private Button back;
	
	@FXML
    public void initialize() throws IOException{
		String path = new String(cell.getIMG());
		setImage(path);
	}
	
	@FXML
	public void handlePlayButtonAction(ActionEvent event) {
		// nanika
	}
	@FXML
	public void handleReplayButtonAction(ActionEvent event) throws IOException {
		back.setVisible(false); next.setVisible(true);
		currPhase = cell.getPhase(0);
		currPhaseID = 0;
		String path = new String(currPhase.getIMG());
		setImage(path);
		setText(currPhase.toString());
	}
	@FXML
	public void handlePauseButtonAction(ActionEvent event) {
		// nanika
	}
	@FXML
	public void handleBackButtonAction(ActionEvent event) throws LimitExceededException, IOException {
		next.setVisible(true);
		currPhase = cell.getPhase(currPhaseID - 1);
		currPhaseID = currPhaseID - 1;
		if (currPhaseID==0) back.setVisible(false);
		String path = new String(currPhase.getIMG());
		setImage(path);
		setText(currPhase.toString());
	}
	@FXML
	public void handleNextButtonAction(ActionEvent event) throws LimitExceededException, IOException {
		back.setVisible(true);
		currPhase = cell.getPhase(currPhaseID + 1);
		currPhaseID = currPhaseID + 1;
		
		if (currPhaseID+1==cell.getPhase()) next.setVisible(false);
		String path = new String(currPhase.getIMG());
		setImage(path);
		setText(currPhase.toString());
	}
	@FXML
	public TextArea phaseDesc;
	@FXML
	public ImageView phaseView;
	
	public void setImage(String path) throws IOException{
		Image image = new Image(path);
		phaseView.setImage(image);
	}
	public void setText(String description) throws IOException{
		phaseDesc.setText(description);
	}
}
