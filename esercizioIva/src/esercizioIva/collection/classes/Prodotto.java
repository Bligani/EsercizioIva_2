package esercizioIva.collection.classes;

public class Prodotto {
	private String nomeProdotto;
	private int ivaProdotto;
	
	public Prodotto() {
		super();
	}
	
	public Prodotto(String nomeProdotto, int ivaProdotto) {
		super();
		this.nomeProdotto = nomeProdotto;
		this.ivaProdotto = ivaProdotto;
	}
	
	public String getNomeProdotto() {
		return nomeProdotto;
	}
	
	public void setNomeProdotto(String nomeProdotto) {
		this.nomeProdotto = nomeProdotto;
	}
	
	public int getIvaProdotto() {
		return ivaProdotto;
	}

	public void setIvaProdotto(int ivaProdotto) {
		this.ivaProdotto = ivaProdotto;
	}
	
	
}
