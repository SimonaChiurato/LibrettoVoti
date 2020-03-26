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
	 * @return {@code true} se ha inserito il voto, {@code false} se non l'ha
	 *         inserito perchè era il conflitto oppure era duplicato
	 */
	public boolean add(Voto v) {
		if (this.isConflitto(v) || this.isDuplicato(v)) {
			// non inserire il voto
			return false;
		} else {
			this.voti.add(v);
			return true;
		}
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
	 * Genera un nuovo libretto a partire da quello esistete che conterrà
	 * esclusivamente i voti con votazione pari a quella specificata
	 * 
	 * @param voto votazione specificata
	 * @return nuovo libretto "ridotto"
	 */
	public Libretto estraiVotiUguali(int voto) {
		Libretto nuovo = new Libretto();
		for (Voto v : voti) {
			if (v.getVoto() == voto) {
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

	/**
	 * Dato il nome di un corso, ricerca se quell' esame esiste nel libretto e
	 * resituisce il {@link Voto} restituisce null se l'esame non esiste
	 * 
	 * @param nomeCorso nome esame da cercare
	 * @return {@link Voto} corrispondende o {@code null}
	 */
	public Voto cercaNomeCorso(String nomeCorso) {
		Voto v = new Voto(nomeCorso, -1, null);
		int pos = this.voti.indexOf(v);
		if (pos != -1) {
			return this.voti.get(pos);
		}
		return null;
	}

	/**
	 * Ritorna {@code true} se il corso specificato da {@code v} esiste nel
	 * libretto, con la stessa valutazione. Se non esiste, o se la valutazione è
	 * diversa, ritorna {@code false}.
	 * 
	 * @param v il {@link Voto} da ricercare
	 * @return l'esistenza di un duplicato
	 */

	public boolean isDuplicato(Voto v) {
		Voto esiste = this.cercaNomeCorso(v.getCorso());
		if (esiste == null) {// non lo trovato--> NON è UN DUPLICATO;
			return false;
		}
		/*
		 * if(esiste.getVoto()== v.getVoto()) { return true; }else { return false; }
		 */
		return (esiste.getVoto() == v.getVoto());
	}

	/**
	 * Determina se esiste un {@link Voto} con lo stesso nome corso ma con
	 * valutazione diversa;
	 * 
	 * @param v
	 * @return
	 */
	public boolean isConflitto(Voto v) {
		Voto esiste = this.cercaNomeCorso(v.getCorso());
		if (esiste == null) {// non lo trovato--> NON è UN DUPLICATO;
			return false;
		}
		return (esiste.getVoto() != v.getVoto());
	}

	/**
	 * Restituisce un nuovo libretto migliorando i voti del libretto attuale
	 * 
	 * @return
	 */
	public Libretto creaLibrettoMigliorato() {
		Libretto nuovo = new Libretto();
		for (Voto v : this.voti) {
			//Voto v2 = v; SBAGLIATO!! PERCHè MODIFICO SEMPRE LO STESSO OGGETTO E NON UN'ALTRO
		//	Voto v2= new Voto(v.getCorso(),v.getVoto(),v.getData()); NOPE!!!!!
			Voto v2= new Voto(v);
			if (v2.getVoto() >= 24) {
				v2.setVoto(v2.getVoto() + 2);
				if (v2.getVoto() >= 30) {
					v2.setVoto(30);
				}
			} else if (v2.getVoto() >= 18) {
				v2.setVoto(v2.getVoto() + 1);
			}
			nuovo.add(v2);
		}
		return nuovo;

	}

}
