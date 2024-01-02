package celldiv.screen;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.naming.LimitExceededException;
import celldiv.cell.*;

public class DivisionController {
	private Cell cell = DemoScreen.cell;
	private int currPhaseID = -1;				// Counter
	private int totalPhases = cell.getPhase();	// Total phases
	private Phase currPhase;					// Current Phase
	private boolean isRunning = false;
	@FXML
	private ProgressBar pb;
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
	public TextArea phaseDesc;
	@FXML
	public ImageView phaseView;
	
	@FXML
    public void initialize() throws IOException{
		String path = new String(cell.getIMG());
		setImage(path);
	}
	@FXML
	public void handlePlayButtonAction(ActionEvent event) {
		if (currPhaseID == -1) currPhaseID = 0;
		if (play.getText()=="PAUSE") {
			isRunning = false;
			play.setText("PLAY");
		}
		else {
			isRunning = true;
			play.setText("PAUSE");
			new Thread(){
				@Override
	            public void run() {
	                for (double i = currPhaseID; i < totalPhases; i++){
	                	if (!isRunning) break;
	                    final double step = i+1;
	                    Platform.runLater(() -> pb.setProgress(step/totalPhases));
	                    back.setVisible(true);
	            		currPhase = cell.getPhase(currPhaseID);
	            		currPhaseID = currPhaseID + 1;
	            		
	            		if (currPhaseID==totalPhases) next.setVisible(false);
	            		String path = new String(currPhase.getIMG());
	            		
	                    try {
	                    	setImage(path);
	                		setText(currPhase.toString());
	                        Thread.sleep(1000); 
	                    } catch(IOException | InterruptedException e) {
	                        Thread.currentThread().interrupt();
	                    }
	                }
	            }
	        }.start();
		}
	}
	@FXML
	public void handleReplayButtonAction(ActionEvent event) throws IOException {
		isRunning = true;
		play.setText("PAUSE");
		back.setVisible(false); next.setVisible(true);
		currPhase = cell.getPhase(0);
		currPhaseID = 0;
		new Thread(){
			@Override
            public void run() {
                for (double i = currPhaseID; i < totalPhases; i++){
                	if (!isRunning) break;
                    final double step = i+1;
                    Platform.runLater(() -> pb.setProgress(step/totalPhases));
                    
                    back.setVisible(true);
            		currPhase = cell.getPhase(currPhaseID);
            		currPhaseID = currPhaseID + 1;
            		
            		if (currPhaseID==totalPhases) next.setVisible(false);
            		String path = new String(currPhase.getIMG());
            		
                    try {
                    	setImage(path);
                		setText(currPhase.toString());
                        Thread.sleep(1000); 
                    } catch(IOException | InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }.start();
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
		double newProgress = (double)(currPhaseID + 1) / totalPhases;
	}
	@FXML
	public void handleNextButtonAction(ActionEvent event) throws LimitExceededException, IOException {
		back.setVisible(true);
		currPhase = cell.getPhase(currPhaseID + 1);
		currPhaseID = currPhaseID + 1;
		
		if (currPhaseID+1==totalPhases) next.setVisible(false);
		String path = new String(currPhase.getIMG());
		setImage(path);
		setText(currPhase.toString());
		double newProgress = (double)(currPhaseID + 1) / totalPhases;
	}
	
	public void setImage(String path) throws IOException{
		Image image = new Image(path);
		phaseView.setImage(image);
	}
	public void setText(String description) throws IOException{
		phaseDesc.setText(description);
	}
}
