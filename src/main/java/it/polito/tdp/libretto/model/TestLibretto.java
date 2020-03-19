package it.polito.tdp.libretto.model;

import java.time.LocalDate;

public class TestLibretto {
	Libretto lib;
	private void run() {
		this.lib = new Libretto(); // crea libretto vuoto
		Voto v1= new Voto("Tecniche di programmazione", 30, LocalDate.of(2020, 06, 15));
		Voto v2= new Voto("Analisi I", 28, LocalDate.of(2019, 06, 28));
		
		lib.add(v1);
		lib.add(v2);
		lib.add(new Voto("Economia", 24, LocalDate.of(2019, 02, 10)));
		lib.add(new Voto("Economia e organizzazione aziendale", 25, LocalDate.of(2019, 02, 11)));
		lib.add(new Voto("Analisi II", 30, LocalDate.of(2019, 01, 28)));
		 System.out.println(this.lib);
		 System.out.println(this.lib.stampaVotiUguali(25));
		 System.out.println(this.lib.estraiVotiUguali(30));
	}

	public static void main(String[] args) {

		TestLibretto test = new TestLibretto();
		test.run();
	}
	
}
