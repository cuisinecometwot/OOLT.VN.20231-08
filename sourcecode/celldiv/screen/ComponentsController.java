package celldiv.screen;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import celldiv.cell.*;

public class ComponentsController {
	private int type = DemoScreen.type;
	private Button start;
	
    private ImageView componentView;
    private RadioButton chromosome;
    private RadioButton ribosome;
    private RadioButton cytoplasm;
    private RadioButton membrane; 
    
    private ToggleGroup selections;
    private TextArea componentDesc;
    
    public void setImage(String path) throws IOException{
    	Image image = new Image("/celldiv/img/"+path);
		componentView.setImage(image);
	
	}
	public void setText(String description) throws IOException{
		componentDesc.setText(description);
		
	}
	
	public void btnOnAction() throws IOException{
		String path = new String(cell.getIMG());
		setImage(path);		
		if(chromosome.isSelected()) {
			setText(cell.getChromosome());
		}
		else if(ribosome.isSelected()) {
			setText(cell.getRibosome());
		}
		else if (cytoplasm.isSelected()) {
			setText(cell.getCytoplasm());
		}
		else if (membrane.isSelected()) {
			setText(cell.getMembrane());
		}
	}
}
