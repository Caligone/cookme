package processing.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

@FacesValidator(value = "validators.name")
public class NameValidator implements Validator {
    private static final String PATTERN = "^[a-zA-Z0-9]+" ;
    private Pattern pattern;
    private Matcher matcher;

    public NameValidator() {
        pattern = Pattern.compile(PATTERN);
    }

    @Override
    public void validate(FacesContext context, UIComponent component,
                         Object value) throws ValidatorException {
        matcher = pattern.matcher(value.toString());
        if(!matcher.matches()){

            FacesMessage msg =
                    new FacesMessage("Name validation failed.",
                                    "Name Validation failed please follow the contraint");
                                    msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
}
