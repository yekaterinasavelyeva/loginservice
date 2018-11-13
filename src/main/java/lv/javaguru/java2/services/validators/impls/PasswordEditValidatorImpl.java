package lv.javaguru.java2.services.validators.impls;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.database.jdbc.UserDAOImpl;
import lv.javaguru.java2.services.exceptions.UserEditException;
import lv.javaguru.java2.services.validators.DataInputValidator;
import lv.javaguru.java2.services.validators.PasswordEditValidator;
import lv.javaguru.java2.services.validators.rules.inputimpls.*;

import javax.inject.Named;

/**
 * Created by user
 * on 13.11.2018
 */

public class PasswordEditValidatorImpl implements PasswordEditValidator {

    private UserDAO userDAO = new UserDAOImpl();

    private DataInputValidator passwordInputValidator =
            new DataInputValidatorImpl(userDAO, new EmptyOrNullInputRule(),
                    new LetterAndNumberInputRule(),
                    new MinLengthInputRule(),
                    new LastPasswordRule(),
                    new InputRule());

    private StringBuilder validationErrors = new StringBuilder();

    @Override
    public void validate(Long userId, String password) {
        validatePassword(userId, password);
        handleValidationErrors();
    }

    public void validatePassword(Long userId, String password){
        try {
            passwordInputValidator.validateData(userId, password, "Password");
        } catch (IllegalArgumentException e) {
            collectMessage(e.getMessage());
        }
    }

    public void handleValidationErrors(){
        String errors = validationErrors.toString();
        if(!errors.isEmpty()) {
            throw new UserEditException(errors);
        }
    }

    private void collectMessage(String message) {
        validationErrors.append(message).append("\n");
    }
}
