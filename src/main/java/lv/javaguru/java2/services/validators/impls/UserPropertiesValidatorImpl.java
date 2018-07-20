package lv.javaguru.java2.services.validators.impls;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.database.jdbc.UserDAOImpl;
import lv.javaguru.java2.domain.UserState;
import lv.javaguru.java2.services.exceptions.UserPropertyException;
import lv.javaguru.java2.services.validators.UserPropertiesValidator;
import lv.javaguru.java2.services.validators.DataInputValidator;
import lv.javaguru.java2.services.validators.rules.passwordinput.EmptyOrNullPasswordRule;
import lv.javaguru.java2.services.validators.rules.passwordinput.LetterAndNumberPasswordRule;
import lv.javaguru.java2.services.validators.rules.passwordinput.MinLengthPasswordRule;
import lv.javaguru.java2.services.validators.rules.passwordinput.PasswordRule;

public class UserPropertiesValidatorImpl implements UserPropertiesValidator {

    private UserDAO userDAO = new UserDAOImpl();

    private DataInputValidator passwordInputValidator =
            new DataInputValidatorImpl(userDAO, new EmptyOrNullPasswordRule(),
            new LetterAndNumberPasswordRule(),
            new MinLengthPasswordRule(),
                    new PasswordRule());

    private StringBuilder validationErrors = new StringBuilder();

    @Override
    public void validate(String login, String password, String firstName, String lastName, UserState state) {
        validatePasword(password);
        //validateFirstName(firstName);
        //validateLastName(lastName);
        //validateState(state);
        handleValidationErrors();
    }

    public void validatePasword(String password) {
        try {
            passwordInputValidator.validateInput(password);
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
