package processing.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@FacesValidator(value = "validators.pwd")
public class PwdValidator implements Validator {

    public PwdValidator() { }

    @Override
    public void validate(FacesContext context, UIComponent component,
                         Object value) throws ValidatorException {
        String password = value.toString();

        UIInput uiInputConfirmPassword = (UIInput) component.getAttributes().get("pwd2");
        String confirmPassword = uiInputConfirmPassword.getSubmittedValue().toString();

        // Let required="true" do its job.
        if (password == null || password.isEmpty() || confirmPassword == null
                || confirmPassword.isEmpty()) {
            return;
        }

        if (!password.equals(confirmPassword)) {
            FacesMessage msg =
                    new FacesMessage("Pwd validation failed.",
                            "Pwd Validation failed please follow the contraint");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            uiInputConfirmPassword.setValid(false);
            throw new ValidatorException(msg);
        }
    }
}
