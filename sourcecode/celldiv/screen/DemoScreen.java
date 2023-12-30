package celldiv.screen;
import java.io.IOException;
import javax.swing.JFrame;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import celldiv.cell.*;

public class DemoScreen extends JFrame{
	protected static int type; // (0-2) Amitosis, Mitosis, Meiosis
	public DemoScreen(int number) {
		super();
		this.type = number;
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		
		setTitle("Demonstration");
		setVisible(true);
		setSize(896, 672);
			
		Platform.runLater(new Runnable() {
			@Override 
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/celldiv/screen/Demo.fxml"));
					DemoScreenController controller = new DemoScreenController(number);
					loader.setController(controller);
					Parent root = loader.load();
					fxPanel.setScene(new Scene(root));
				}	catch(IOException e) {
					e.printStackTrace();
				}				
			}
		});	
	}
}
