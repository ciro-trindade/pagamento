package br.fatec.pagamento.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import br.fatec.pagamento.util.Messages;

@FacesValidator("validator.Cartao")
public class CartaoValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		if (value.toString().length() != 16) {
			String msg = Messages.getString("msgs", "erroValidacaoCartao");
			FacesMessage message = new FacesMessage(msg);
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		}
	}

}
