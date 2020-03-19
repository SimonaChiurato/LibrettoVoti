package it.polito.tdp.libretto.model;

import java.time.LocalDate;
/**
 * Classe Voto, contiene informazioni su un esame superato
 * @author Simona
 *
 */
public class Voto {
	private String corso;
	private int voto;
	private LocalDate data;
	
	/**
	 * Costruisce un nuovo voto
	 * 
	 * @param corso nome del corso superato
	 * @param voto valore del voto acquisito
	 * @param data data di superamento esame
	 */
	public Voto(String corso, int voto, LocalDate data) {
		super();
		this.corso = corso;
		this.voto = voto;
		this.data = data;
	}


	public void setCorso(String corso) {
		this.corso = corso;
	}


	public void setVoto(int voto) {
		this.voto = voto;
	}


	public void setData(LocalDate data) {
		this.data = data;
	}


	public String getCorso() {
		return corso;
	}

	public int getVoto() {
		return voto;
	}

	public LocalDate getData() {
		return data;
	}


	@Override
	public String toString() {
		return corso + ": "+ voto + " (" + data + ")";
	}
	
}
