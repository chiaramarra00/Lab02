package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.parole.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextField txtInsert;

    @FXML
    private TextArea txtResult;

    @FXML
    void doClear(ActionEvent event) {

    }

    @FXML
    void doTranslate(ActionEvent event) {
    	txtResult.clear();
    	String s = txtInsert.getText();
    	txtInsert.clear();
    	String array[] = s.split(" ");
    	String t = "";
    	try {
    		t = model.translate(array);
    	} catch (Exception e) {
    		txtResult.setText("ERRORE");
    	}
    	if (t!="")
    		txtResult.setText(t);
    }

    @FXML
    void initialize() {
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtInsert != null : "fx:id=\"txtInsert\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";

    }

	public void setModel(Model model) {
		this.model = model;
	}

}
