package it.polito.tdp.parole.model;

import java.util.TreeMap;

public class Traduzione {
	
	private String traduzione;
	private TreeMap<String,String> mappaParole = new TreeMap<String,String>();

	public Traduzione(String traduzione, String parolaAliena) {
		this.traduzione = traduzione;
		mappaParole.put(parolaAliena, parolaAliena);
	}

	public void addParola(String parolaAliena) {
		if (!mappaParole.containsKey(parolaAliena))
			mappaParole.put(parolaAliena, parolaAliena);
	}

}
