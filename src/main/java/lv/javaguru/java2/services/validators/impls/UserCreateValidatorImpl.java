package lv.javaguru.java2.services.validators.impls;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.database.jdbc.UserDAOImpl;
import lv.javaguru.java2.domain.UserState;
import lv.javaguru.java2.services.exceptions.UserPropertyException;
import lv.javaguru.java2.services.validators.UserCreateValidator;
import lv.javaguru.java2.services.validators.DataInputValidator;
import lv.javaguru.java2.services.validators.rules.inputimpls.*;

import javax.inject.Inject;

/**
 * Created by Yekaterina Savelyeva
 * on 16.07.2018
 */

public class UserCreateValidatorImpl implements UserCreateValidator {

    //TODO implement UserState validator

    @Inject
    private UserDAO userDAO;

    private DataInputValidator inputValidator =
            new DataInputValidatorImpl(userDAO, new EmptyOrNullInputRule(),
                    new MinLengthInputRule(), new InputRule());

    private DataInputValidator loginValidator =
            new DataInputValidatorImpl(userDAO, new EmptyOrNullInputRule(),
                    new LetterAndNumberInputRule(),new MinLengthInputRule(),
                    new LoginUniqueRule(),
                    new InputRule());

    private DataInputValidator passwordValidator =
            new DataInputValidatorImpl(userDAO, new EmptyOrNullInputRule(),
                    new LetterAndNumberInputRule(),
                    new MinLengthInputRule(), new InputRule());

    private StringBuilder validationErrors = new StringBuilder();

    @Override
    public void validate(String login, String password, String firstName, String lastName, UserState state) {
        validateLogin(login);
        validatePasword(password);
        validateFirstnameLastname(firstName, lastName);
        //validateState(state);
        handleValidationErrors();
    }

    public void validateLogin(String login) {
        try {
            loginValidator.validateData(null, login, "Login");
        } catch (IllegalArgumentException e) {
            collectMessage(e.getMessage());
        }
    }

    public void validateFirstnameLastname(String lastName, String firstName) {
        try {
            inputValidator.validateInput(lastName, "Lastname");
            inputValidator.validateInput(firstName, "Firstname");
        } catch (IllegalArgumentException e) {
            collectMessage(e.getMessage());
        }
    }

    public void validatePasword(String password) {
        try {
            passwordValidator.validateInput(password, "Password");
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
