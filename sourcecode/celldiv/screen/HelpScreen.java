package celldiv.screen;

import java.io.IOException;
import javax.swing.JFrame;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class HelpScreen extends JFrame {
	public HelpScreen() {
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		this.setTitle("Help");
		this.setVisible(true);
		this.setSize(500, 250);
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/celldiv/screen/HelpScreen.fxml"));
					Parent root = loader.load();
					fxPanel.setScene(new Scene(root));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
