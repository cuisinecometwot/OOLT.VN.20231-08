package celldiv.screen;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import celldiv.cell.*;

public class ComponentsController {
	private Cell cell = DemoScreen.cell;
	@FXML
    private RadioButton chromosome;
	@FXML
    private RadioButton ribosome;
	@FXML
    private RadioButton cytoplasm;
	@FXML
    private RadioButton membrane;
	@FXML
	private RadioButton fagellum;
	@FXML
	private RadioButton nucleus;
	@FXML
	private RadioButton microtubules;
	@FXML
    private ToggleGroup selections;
	@FXML
    private ImageView componentView;
	@FXML
    private TextArea componentDesc;
    
    public void setImage(String path) throws IOException{
    	Image image = new Image(path);
		componentView.setImage(image);
	}
	public void setText(String description) throws IOException{
		componentDesc.setText(description);
	}
	@FXML
    public void initialize() throws IOException{
		String path = new String(cell.getIMG());
		setImage(path);
		if (cell instanceof Prokaryote) fagellum.setVisible(true);
		if (cell instanceof Eukaryote) {
			nucleus.setDisable(false);
			microtubules.setVisible(true);
		}
		
    }
	public void btnOnAction() throws IOException{
		if (chromosome.isSelected()) setText(cell.getChromosome());
		else if (ribosome.isSelected()) setText(cell.getRibosome());
		else if (cytoplasm.isSelected()) setText(cell.getCytoplasm());
		else if (membrane.isSelected()) setText(cell.getMembrane());
		else if (fagellum.isSelected()) {
			Prokaryote temp = (Prokaryote) cell;
			setText(temp.getFagellum());
		}
		else if (nucleus.isSelected()) {
			Eukaryote temp = (Eukaryote) cell;
			setText(temp.getNucleus());
		}
		else if (microtubules.isSelected()) {
			Eukaryote temp = (Eukaryote) cell;
			setText(temp.getMicrotubules());
		}
	}
}
