package it.polito.tdp.libretto.model;

import java.util.*;

/**
 * Memorizza e gestiti i voti superati
 * 
 * @author Simona
 *
 */
public class Libretto {

	private List<Voto> voti = new ArrayList<>();

	/**
	 * Aggiunge nuovo voto al libretto
	 * 
	 * @param v
	 */
	public void add(Voto v) {
		this.voti.add(v);
	}

	/**
	 * Dato un libretto restituisce una stringa con gli esami che hanno il voto come
	 * quello passato
	 * 
	 * @param voto valore specificato
	 * @return Stringa formattata per visualizzare il sotto libretto
	 */
	public String stampaVotiUguali(int voto) { // METODO MENO EFFICACE, MEGLIO CREARE UNA NUOVA LISTA CHE CONTIENE GLI
												// ESAMI CERCATI
		String s = "";
		for (Voto v : this.voti) {
			if (v.getVoto() == voto) {
				s += v.toString() + "\n";
			}
		}
		return s;
	}
/**
 * Genera un nuovo libretto a partire da quello esistete che conterrà esclusivamente i voti con votazione pari a quella specificata
 * @param voto votazione specificata
 * @return nuovo libretto "ridotto"
 */
	public Libretto estraiVotiUguali(int voto) {
		Libretto nuovo= new Libretto();
		for(Voto v: voti) {
			if(v.getVoto()==voto) {
			nuovo.add(v);
			}
		}
		return nuovo;
	}

	public String toString() {
		String s = "";
		for (Voto v : this.voti) {
			s += v.toString() + "\n";
		}
		return s;
	}

}
