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
import celldiv.cell.*;

public class DivisionController {
	private Cell cell = DemoScreen.cell;
	private int currPhaseID;				// Counter
	private int totalPhases;				// Total phases
	private Phase currPhase;				// Current Phase
	private boolean isRunning;				// Play/Pause handler
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
		isRunning = false;
		currPhaseID = 0;
		currPhase = cell.getPhase(0);
		totalPhases = cell.getPhase();
		pb.setProgress(1/totalPhases); // not effect
		String path = new String(currPhase.getIMG());
		setImage(path);
		setText(currPhase.toString());
	}
	// This is MADNESS!
	@FXML
	public void handlePlayButtonAction(ActionEvent event) {
		if (play.getText()=="PAUSE") { // user want to pause
			play.setText("PLAY");
			isRunning = false;
			back.setDisable(false);
			next.setDisable(false);
			replay.setDisable(false);
		}
		else { // user want to play
			isRunning = true;
			play.setText("PAUSE");
			new Thread(){
				@Override
	            public void run() {
	                for (double i = currPhaseID; i < totalPhases; i++){
	                    final double step = i+1;
	                    Platform.runLater(() -> pb.setProgress(step/totalPhases));
	                    //back.setDisable(false);
	            		currPhase = cell.getPhase(currPhaseID);
	            		back.setDisable(true);
	            		next.setDisable(true);
	            		replay.setDisable(true);
	            		
	            		if (currPhaseID+1==totalPhases) {
	            			//next.setDisable(true);
	            			//play.setDisable(true);
	            			//play.setText("DONE");
	            			isRunning = false;
	            			play.setDisable(true);
	            		}
	            		
	                    try {
	                    	String path = new String(currPhase.getIMG());
	                    	setImage(path);
	                		setText(currPhase.toString());
	                        Thread.sleep(1000); 
	                    } catch(IOException | InterruptedException e) {
	                        Thread.currentThread().stop();
	                    	//throw new RuntimeException("Interuppted ...\n"+e);
	                    }
	                    // if paused, stop current thread
	                    if (!isRunning) {
	                    	// isRunning = false;
	                    	if (currPhaseID!=0) back.setDisable(false);
	            	        next.setDisable(false); //
	            			replay.setDisable(false);
	                    	Thread.currentThread().stop();
	                    }
	                    currPhaseID = currPhaseID + 1;
	                }
	                // reached the end of division process
	                isRunning = false;
        	        back.setDisable(false);
        	        next.setDisable(true);
        			replay.setDisable(false);
	            }
	        }.start();
		}
	}
	@FXML
	public void handleReplayButtonAction(ActionEvent event) throws IOException {
		isRunning = true;
		// replay.setDisable(true);
		play.setDisable(false); play.setText("PAUSE");
		// back.setDisable(true); next.setDisable(true);
		// currPhase = cell.getPhase(0);
		currPhaseID = 0;
		new Thread(){
			@Override
            public void run() {
                for (double i = currPhaseID; i < totalPhases; i++){
                    final double step = i+1;
                    Platform.runLater(() -> pb.setProgress(step/totalPhases));
                    // back.setDisable(false);
            		currPhase = cell.getPhase(currPhaseID);
            		back.setDisable(true);
            		next.setDisable(true);
            		// play.setText("PAUSE");
            		replay.setDisable(true);
            		
            		if (currPhaseID+1==totalPhases) {
            			//next.setDisable(true);
            			//play.setDisable(true);
            			isRunning = false;
            			play.setDisable(true);
            			replay.setDisable(false);
            		}
            		
                    try {
                    	String path = new String(currPhase.getIMG());
                    	setImage(path);
                		setText(currPhase.toString());
                        Thread.sleep(1000); 
                    } catch(IOException | InterruptedException e) {
                        Thread.currentThread().stop();
                    	//throw new RuntimeException("Interuppted ...\n"+e);
                    } if (!isRunning) { // if paused
                    	if (currPhaseID!=0) back.setDisable(false);
            	        next.setDisable(false); //
            			replay.setDisable(false);
                    	Thread.currentThread().stop();
                    }
            		currPhaseID = currPhaseID + 1;
                }
                // reached the end of division process
                isRunning = false;
    	        back.setDisable(false);
    	        next.setDisable(true);
    			replay.setDisable(false);
            }
        }.start();
	}
	@FXML
	public void handleBackButtonAction(ActionEvent event) throws IOException {
		replay.setDisable(false);
		new Thread(){
			@Override
            public void run() {
                try {
                	final double step = currPhaseID;
            		next.setDisable(false);
            		currPhaseID = currPhaseID - 1;
            		currPhase = cell.getPhase(currPhaseID);
            		if (currPhaseID==0) back.setDisable(true);
            		String path = new String(currPhase.getIMG());
            		setImage(path);
            		setText(currPhase.toString());
            		Platform.runLater(() -> pb.setProgress(step/totalPhases));
                } catch(ArrayIndexOutOfBoundsException | IOException e) {
                    // e.printStackTrace();
                	System.out.println("[EXCEPTION] Uh, oh!");
                }
            }
        }.start();
	}
	@FXML
	public void handleNextButtonAction(ActionEvent event) throws IOException {
		replay.setDisable(false);
		new Thread(){
			@Override
            public void run() {
                try {
                	back.setDisable(false);
                	currPhaseID = currPhaseID + 1;
            		currPhase = cell.getPhase(currPhaseID);
            		final double step = currPhaseID+1;
            		if (currPhaseID==totalPhases-1) next.setDisable(true);
            		String path = new String(currPhase.getIMG());
            		setImage(path);
            		setText(currPhase.toString());
            		Platform.runLater(() -> pb.setProgress(step/totalPhases));
                } catch(ArrayIndexOutOfBoundsException | IOException e) {
                	// e.printStackTrace();
                	System.out.println("[EXCEPTION] Uh, oh!");
                }
            }
        }.start();
	}
	
	public void setImage(String path) throws IOException{
		Image image = new Image(path);
		phaseView.setImage(image);
	}
	public void setText(String description) throws IOException{
		phaseDesc.setText(description);
	}
}