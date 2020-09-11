package br.fatec.pagamento.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.primefaces.event.RowEditEvent;

import br.fatec.pagamento.model.Pagamento;
import br.fatec.pagamento.util.Messages;

@ManagedBean
@RequestScoped
public class PagamentoBean {
	private Pagamento pagamento = new Pagamento();

	public PagamentoBean() {
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	
	public String validaData() {		
		if (pagamento.getValidade().before(new Date(System.currentTimeMillis()))) {
			FacesMessage msg = new FacesMessage("A data de validade de cartão expirou!");
			FacesContext.getCurrentInstance().addMessage("frm:data", msg);
			return null;
		}
		return "/pagamento";		
	}
	
	public void validaCartao(FacesContext context, UIComponent component, Object value) throws ValidatorException  {
		if (value.toString().length() != 16) {
			String msg = Messages.getString("msgs", "erroValidacaoCartao");
			FacesMessage message = new FacesMessage(msg);
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		}
	}
	
	public String pagar() {
		PagamentoService.addPagamento(pagamento);
		return "/pagamento";
	}
	
	public List<Pagamento> getPagamentos() {
		return PagamentoService.getPagamentos();
	}
	
	public void onEdit(RowEditEvent event) {
		Pagamento p = (Pagamento) event.getObject();
		FacesMessage msg = new FacesMessage("Pagamento atualizado", p.getValor().toString());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Edição cancelada");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public List<SelectItem> getListarBandeiras() {
		List<SelectItem> lista = new ArrayList<>();
		lista.add(new SelectItem("Visa", "Visa"));
		lista.add(new SelectItem("MasterCard", "MasterCard"));
		lista.add(new SelectItem("Dinners", "Dinners"));
		lista.add(new SelectItem("Elo", "Elo"));
		lista.add(new SelectItem("Outro", "Outro"));
		return lista;
	}

}
