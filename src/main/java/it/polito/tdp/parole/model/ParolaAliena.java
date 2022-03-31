package it.polito.tdp.parole.model;

import java.util.LinkedList;
import java.util.TreeMap;

public class ParolaAliena {
	
	private String parola;
	private TreeMap<String,String> mappaTraduzioni = new TreeMap<String,String>();
	
	public ParolaAliena(String parolaAliena, String traduzione) {
		parola = parolaAliena;
		mappaTraduzioni.put(traduzione,traduzione);
	}

	public void addTraduzione(String traduzione) {
		if (!mappaTraduzioni.containsKey(traduzione))
			mappaTraduzioni.put(traduzione,traduzione);
	}

	public LinkedList<String> getTraduzioni() {
		return new LinkedList<String>(mappaTraduzioni.keySet());
	}

}
