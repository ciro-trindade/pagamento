package br.fatec.pagamento.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

public class Pagamento {
	@Max(100000)
	@Min(10)
	private BigDecimal valor;
	/*
	@Pattern(regexp = "^([0-9]{4}[.]){3}[0-9]{4}$",
             message = "{cartao.validator.message}") */
	private String cartao;
	
	private String bandeira;
	
	@Future
	private Date validade;

	public Pagamento() {
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}


	public String getCartao() {
		return cartao;
	}

	public void setCartao(String cartao) {
		this.cartao = cartao;
	}

	public String getBandeira() {
		return bandeira;
	}

	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}

	public Date getValidade() {
		return validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
	}

}
