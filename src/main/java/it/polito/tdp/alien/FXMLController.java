package it.polito.tdp.alien;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.TreeMap;

import it.polito.tdp.parole.model.ParolaAliena;
import it.polito.tdp.parole.model.Traduzione;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private TreeMap<String,ParolaAliena> mappaParole = new TreeMap<String,ParolaAliena>();
	private TreeMap<String,Traduzione> mappaTraduzioni = new TreeMap<String,Traduzione>();

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
    	if (array.length==2) {
    		String parolaAliena = array[0].toLowerCase();
        	String traduzione = array[1].toLowerCase();
        	if (!parolaAliena.matches("[a-z]*") || !traduzione.matches("[a-z]*"))
        		txtResult.setText("ERRORE");
        	if (!mappaParole.containsKey(parolaAliena)) {
        		ParolaAliena pa = new ParolaAliena(parolaAliena,traduzione);
        		mappaParole.put(parolaAliena, pa);
        	}
        	else if (mappaParole.containsKey(parolaAliena))
        		mappaParole.get(parolaAliena).addTraduzione(traduzione);
        	if (!mappaTraduzioni.containsKey(traduzione)) {
        		Traduzione t = new Traduzione (traduzione,parolaAliena);
        		mappaTraduzioni.put(traduzione, t);
        	}
        	else if (mappaTraduzioni.containsKey(traduzione)) 
        		mappaTraduzioni.get(traduzione).addParola(parolaAliena);
    	}
    	else if (array.length==1) {
    		String parolaAliena = array[0].toLowerCase();
    		LinkedList<String> traduzioni = mappaParole.get(parolaAliena).getTraduzioni();
    		for (String t : traduzioni) {
    			txtResult.appendText(t+"\n");
    		}
    	}
    	
    }

    @FXML
    void initialize() {
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtInsert != null : "fx:id=\"txtInsert\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";

    }

}
