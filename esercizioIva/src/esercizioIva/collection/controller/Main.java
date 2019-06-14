package esercizioIva.collection.controller;
import esercizioIva.collection.classes.OrdineDiretto;
import esercizioIva.collection.classes.OrdineInverso;
import esercizioIva.collection.classes.Prodotto;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Main {	
public static void main(String[] args) {
	
	  //Creating a generic ArrayList
	  Collection<Prodotto> listino = new ArrayList<Prodotto>();
	  
	  try {
		  /*Creare un oggetto di tipo path per trovare il file.
		   * se il file è salvato nella stessa cartella basta inserire il nome tra virgolette*/
			  
		  Path r = Paths.get("Products.txt");
		  	
		  /* Il metodo lines(Path path) della classe files legge tutte le righe di un file come Stream.
		   * Il metodo lines è uno stream, quindi va continuato con un ".collect(COLLETTORE)",
		   *  ed il collettore riporta il tipo di variabile che voglio in uscita. 
		   * In questo caso Collectors.toList() mi restituisce una lista */
		  
		  Collection<String> linee = Files.lines(r).collect(Collectors.toList());
		  
		  /*Per ogni stringa che compone la lista creo un array che contiene due ulteriori stringhe. 
		   * Una diventerà il nome del prodotto e una l'Iva. */
		  for(String l : linee) {
		     //Non specifico la size della stringa nelle quadre anche se so che sarà 2.  
			 //STRINGA.split("SEPARATORE") mi spezza la stringa STRINGA in più stringhe in base al separatore ";"
			  String[] parole= l.split(";");
			  
			//System.out.println(parole.length);
			  
			  /*Per ogni array creo un nuovo prodotto.
			   *Il suo nome è l'entrata 0 dell'array.
			   *La sua Iva è l'intero che viene dalla conversione della stringa,
			   *togliendo l'ultimo carattere, cioè il "%" */
			  try{
					  Prodotto q = new Prodotto(parole[0].toLowerCase(),Integer.parseInt(parole[1].substring(0,parole[1].length()-1)));
					  
					  /*Ogni prodotto viene aggiunto alla Collection che ho chiamato listino.*/
					  listino.add(q);
					  
					  /*Per controllare stampo il listino mano a mano che aggiungo i prodotti*/
					  //System.out.println(q.getNomeProdotto()+" "+q.getIvaProdotto()); 
			  	}
			
			  catch(NumberFormatException f)
				  {
					    throw new IllegalArgumentException("Il formato dell'Iva è invalido nel prodotto "+l, f);
					}
			  }
		  PrintStream fileOut = new PrintStream("output.txt");
		  
		  ////////////////////RICERCA PRODOTTO/////////////////////////////	
		  System.out.println(" ");
		  System.out.println("QUALE PRODOTTO CERCHI?");
		  /*Prendiamo una stringa in input da tastiera */
		  Scanner scanner = new Scanner(System.in);
		  String inputString = scanner.nextLine();
		  
		  System.setOut(fileOut);
		  System.out.println("HAI CERCATO: " + inputString);
		  
		  //Stampiamo tutti i prodotti con quella stringa nel nome
		  System.out.println("IL PRODOTO CHE CERCHI POTREBBE ESSERE: ");
		  /*Controlliamo tutti i prodotti, e se nel nome c'è la stringa in input lo stampiamo*/
		  for(Prodotto p : listino) 
		  {
			  if (p.getNomeProdotto().contains(inputString))
			  {System.out.println(p.getNomeProdotto() + " " +p.getIvaProdotto());}
		  }
		  //////////////////////////////////////////////////////////
		  
		  
		  
		  ////////////////////ORDINARE/////////////////////////////	
		  	/*Creo un oggetto della classe OrdineInverso per poter accedere 
		  	 * ai metodi di questa classe (gli ordini inversi).*/
		  OrdineDiretto i = new OrdineDiretto();
		  	/*o.ordIva(listino) è quindi una nuova collezione che riscrive il listino in ordine crescente in base all'Iva.
		  	 * per vedere se f quello che deve la stampo*/
		  
		  System.out.println(" ");
		  System.out.println("NOME CRESCENTE: ");
			for (Prodotto p : i.ordNome(listino))
			{
				  System.out.println(p.getNomeProdotto() + " " +p.getIvaProdotto());
			}
		  //////////////////////////////////////////////////////////

		  //////////////////////////////////////////////////////////
		  OrdineInverso o = new OrdineInverso();
		  System.out.println(" ");
		  System.out.println("NOME DECRESCENTE: ");
		  for (Prodotto p : o.ordNome(listino))
		  {
			  System.out.println(p.getNomeProdotto() + " " +p.getIvaProdotto());
		  }
		  //////////////////////////////////////////////////////////

		  //////////////////////////////////////////////////////////
		  System.out.println(" ");
		  System.out.println("IVA CRESCENTE: ");
    	  for (Prodotto p : o.ordIva(listino))
			{
				  System.out.println(p.getNomeProdotto() + " " +p.getIvaProdotto());
			}
		  //////////////////////////////////////////////////////////
		  
		  //////////////////////////////////////////////////////////
		  System.out.println(" ");
		  System.out.println("IVA DECRESCENTE: ");
		  for (Prodotto p : i.ordIva(listino))
		  {
			  System.out.println(p.getNomeProdotto() + " " +p.getIvaProdotto());
		  }
	      //////////////////////////////////////////////////////////
	  }
	  //Eccezione: potrebbe non esistere il file con quel path
	  catch (IOException e) {}
	}
}