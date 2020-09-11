package br.fatec.pagamento.control;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import br.fatec.pagamento.model.Pagamento;

@ManagedBean
@ApplicationScoped
public class PagamentoService {
	private static List<Pagamento> pagamentos = new ArrayList<>();

	public PagamentoService() {
	}

	public static List<Pagamento> getPagamentos() {
		return pagamentos;
	}

	public static void addPagamento(Pagamento pagamento) {
		pagamentos.add(pagamento);
	}
	
}
