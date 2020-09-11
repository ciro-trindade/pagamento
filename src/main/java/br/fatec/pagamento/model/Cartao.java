package br.fatec.pagamento.model;

public class Cartao {
	private String numero;

	public Cartao(String numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return numero;
	}	

}
