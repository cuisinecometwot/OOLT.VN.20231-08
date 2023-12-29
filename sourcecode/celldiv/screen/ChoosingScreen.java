package celldiv.screen;
import java.io.IOException;
import javax.swing.JFrame;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
public class ChoosingScreen extends JFrame{

	public ChoosingScreen(int choice) {
		super();
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		this.setTitle("Choosing Cell Division Type");
		this.setVisible(true);
		this.setSize(896, 672);
		Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/oop/globalict/project/gui/ChoosingType.fxml"));
					ChoosingScreenController controller = new ChoosingScreenController();
					loader.setController(controller);
					Parent root = loader.load();
					fxPanel.setScene(new Scene(root));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}

}
