package it.polito.tdp.libretto.model;

import java.time.LocalDate;

/**
 * Classe Voto, contiene informazioni su un esame superato nome corso, voto e
 * data
 * 
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
	 * @param voto  valore del voto acquisito
	 * @param data  data di superamento esame
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
		return corso + ": " + voto + " (" + data + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((corso == null) ? 0 : corso.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Voto other = (Voto) obj;
		if (corso == null) {
			if (other.corso != null)
				return false;
		} else if (!corso.equals(other.corso))
			return false;
		return true;
	}

	/**
	 * Copy constructor di {@link Voto}: crea un nuovo {@link Voto}, copiando il contenuto del parametro {@code v}
	 * @param v il voto da copiare
	 */
	public Voto(Voto v) {
		this.corso= v.corso;
		this.data= v.data;
		this.voto=v.voto;
	}
	/**
	 * crea una copia (clone) dell0oggetto presente ( this), come nuovo oggetto
	 */
	public Voto clone() {
		Voto v= new Voto(this.corso,this.voto,this.data);
		return v;
	}

}
