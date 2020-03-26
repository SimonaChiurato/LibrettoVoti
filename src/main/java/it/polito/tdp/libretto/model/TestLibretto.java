package it.polito.tdp.libretto.model;

import java.time.LocalDate;

public class TestLibretto {
	Libretto lib;
	private void run() {
		this.lib = new Libretto(); // crea libretto vuoto
		// 1. Inserire voti libretto
		Voto v1= new Voto("Tecniche di programmazione", 30, LocalDate.of(2020, 06, 15));
		Voto v2= new Voto("Analisi I", 28, LocalDate.of(2019, 06, 28));
		lib.add(v1);
		lib.add(v2);
		lib.add(new Voto("Economia", 18, LocalDate.of(2019, 02, 10)));
		lib.add(new Voto("Economia e organizzazione aziendale", 25, LocalDate.of(2019, 02, 11)));
		lib.add(new Voto("Analisi II", 30, LocalDate.of(2019, 01, 28)));
		 //2. stampare voti uguali a X
		 System.out.println(this.lib);
		 System.out.println(this.lib.stampaVotiUguali(25));
		 System.out.println(this.lib.estraiVotiUguali(30));
		 // 3. cercare il voto di un esame dato il corso
		 String nomeCorso= "Analisi II";
		Voto cercato= lib.cercaNomeCorso(nomeCorso);
		System.out.println("Il voto di "+ nomeCorso+" é "+ cercato.getVoto());
		//4.creare un nuovo oggetto Voto, e verificare se tale valutazione esiste già nel Libretto (stesso esame con stesso voto)
		//5.creare un nuovo oggetto Voto, e verificare se esiste un conflitto con il Libretto (stesso esame e voto diverso)
		Voto economia2= new Voto("Economia", 24, LocalDate.now());
		Voto economia3= new Voto("Economia", 21, LocalDate.now());
		System.out.println("Economia con 24 è duplicato: "+ lib.isDuplicato(economia2)+ " /conflitto: "+lib.isConflitto(economia2));
		System.out.println("Economia con 21 è duplicato: "+ lib.isDuplicato(economia3)+ " /conflitto: "+lib.isConflitto(economia3));
		//6.modificare il metodo Libretto.add() in modo da evitare di inserire valutazioni duplicate (stesso esame con stesso voto) o in conflitto
		
		
		//7.creare un libretto "migliorato" in cui ciascun voto maggiore o uguale di 18 viene incrementato di 1 punto, 
		//e ciascun voto maggiore o ugale di 24 viene incrementato di 2 punti (senza superare il 30). Tenereseparatidue libretti, 
		//e stamparli _entrambi_.
		
		Libretto migliorato= lib.creaLibrettoMigliorato();
		System.out.println("Miglioramento del libretto");
		System.out.println("Prima:\n"+lib);
		System.out.println("Dopo:\n"+migliorato);
		
		//8.stampare il libretto in ordine alfabetico di esame, ed in ordine numerico decrescente di voto
		Libretto alfabetico= new Libretto(lib);
		alfabetico.ordinaPerCorso();
		System.out.println(alfabetico);
		
		Libretto ordineVoti= new Libretto(lib);
		ordineVoti.ordinaPerVoto();
		System.out.println(ordineVoti);
		
		//9.cancellare dal libretto tutti i voti inferiori a 24
		
		Libretto senzaVotiScarsi= new Libretto(lib);
		senzaVotiScarsi.cancellaVotiScarsi();
		System.out.println(senzaVotiScarsi);
	}

	public static void main(String[] args) {

		TestLibretto test = new TestLibretto();
		test.run();
	}
	
}
