package esercizioIva.collection.classes;

import java.util.Collection;
import java.util.stream.Collectors;
import esercizioIva.collection.interfaces.OrderCollection;

public class OrdineInverso implements OrderCollection{

	
	public Collection<Prodotto> ordNome(Collection<Prodotto> lista) {
		return lista.stream().sorted(    (a,b)    ->    b.getNomeProdotto().compareTo(a.getNomeProdotto())  ).collect(Collectors.toList());
		
	}


	public Collection<Prodotto> ordIva(Collection<Prodotto> lista) {
		return lista.stream().sorted(    (a,b)    ->    b.getIvaProdotto() - a.getIvaProdotto()  ).collect(Collectors.toList());
		
	}

}
