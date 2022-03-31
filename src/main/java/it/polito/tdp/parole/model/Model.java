package it.polito.tdp.parole.model;

import java.util.LinkedList;
import java.util.TreeMap;

public class Model {
	
	private TreeMap<String,ParolaAliena> mappaParole = new TreeMap<String,ParolaAliena>();
	
	public String translate(String[] array) throws Exception {
		String s = "";
		if (array.length==2) {
    		String parolaAliena = array[0].toLowerCase();
        	String traduzione = array[1].toLowerCase();
        	if (!parolaAliena.matches("[a-z]*") || !traduzione.matches("[a-z]*"))
        		throw new Exception();
        	if (!mappaParole.containsKey(parolaAliena)) {
        		ParolaAliena pa = new ParolaAliena(parolaAliena,traduzione);
        		mappaParole.put(parolaAliena, pa);
        	}
        	else if (mappaParole.containsKey(parolaAliena))
        		mappaParole.get(parolaAliena).addTraduzione(traduzione);
    	}
    	else if (array.length==1) {
    		String parolaAliena = array[0].toLowerCase();
    		LinkedList<String> traduzioni = mappaParole.get(parolaAliena).getTraduzioni();
    		for (String t : traduzioni) {
    			s += t+"\n";
    		}
    	}
		return s;
	}

}
