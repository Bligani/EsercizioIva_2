package esercizioIva.collection.interfaces;

import java.util.Collection;

import esercizioIva.collection.classes.Prodotto;

public interface OrderCollection {
	Collection<Prodotto> ordNome (Collection<Prodotto> lista);
	Collection<Prodotto> ordIva (Collection<Prodotto> lista);
}
