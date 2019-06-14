package esercizioIva.collection.classes;

import java.util.Collection;
import java.util.stream.Collectors;

import esercizioIva.collection.interfaces.OrderCollection;

public class OrdineDiretto implements OrderCollection{

	/*Creo un metodo che riordina il listino mettendo i prodotti in ordine alfabetico in base al nome.
	 * In input prende una Collection e in output ne restituisce una nuova. 
	 * Quindi esiste ancora l'oggetto vecchio non ordinato.*/
	public Collection<Prodotto> ordNome(Collection<Prodotto> lista) {
		/*Faccio uno stream sull'argomento lista.
		 * sorted() contiene le istruzioni per confrontare una coppia di oggetti. 
		 * Lo stream ordina tutta la lista ripetendo il confronto più volte.
		 * A.compareTo(b) è negativo se A è minore di B, 0 se sono uguali, positivo se A è maggiore di B.
		 * sorted(...).collect(COLLETTORE) serve per rimettere i prodotti in collettore di tipo lista.*/
		return lista.stream().sorted(    (a,b)    ->    a.getNomeProdotto().compareTo(b.getNomeProdotto())  ).collect(Collectors.toList());
		
	}

	/*Creo un metodo che riordina il listino mettendo i prodotti in ordine di Iva crescente*/
	public Collection<Prodotto> ordIva(Collection<Prodotto> lista) {
		return lista.stream().sorted(    (a,b)    ->    a.getIvaProdotto() - b.getIvaProdotto()  ).collect(Collectors.toList());
		
	}

}
