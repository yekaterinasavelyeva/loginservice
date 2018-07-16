package lv.javaguru.java2.services.validators.impls;

import lv.javaguru.java2.domain.UserState;
import lv.javaguru.java2.services.exceptions.UserPropertyException;
import lv.javaguru.java2.services.validators.UserPropertiesValidator;
import lv.javaguru.java2.services.validators.rules.DataInputValidator;
import lv.javaguru.java2.services.validators.rules.passwordinput.EmptyOrNullPasswordRule;
import lv.javaguru.java2.services.validators.rules.passwordinput.LetterAndNumberPasswordRule;
import lv.javaguru.java2.services.validators.rules.passwordinput.MinLengthPasswordRule;

public class UserPropertiesValidatorImpl implements UserPropertiesValidator {

    private DataInputValidator passwordValidator =
            new DataInputValidatorImpl(new EmptyOrNullPasswordRule(),
            new LetterAndNumberPasswordRule(),
            new MinLengthPasswordRule());
    private StringBuilder validationErrors = new StringBuilder();

    @Override
    public void validate(String login, String password, String firstName, String lastName, UserState state) {
        validatePasword(password);
        //validateFirstName(firstName);
        //validateLastName(lastName);
        //validateState(state);
        handleValidationErrors();
    }

    @Override
    public void validatePasword(String password) {
        try {
            passwordValidator.validatePassword(password);
        } catch (IllegalArgumentException e) {
            collectMessage(e.getMessage());
        }
    }

    private void handleValidationErrors() {
        String errors = validationErrors.toString();
        if (!errors.isEmpty()) {
            throw new UserPropertyException(errors);
        }
    }

    private void collectMessage(String message) {
        validationErrors.append(message).append("\n");
    }
}
