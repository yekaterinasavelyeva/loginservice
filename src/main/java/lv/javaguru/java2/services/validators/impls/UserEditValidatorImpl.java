package lv.javaguru.java2.services.validators.impls;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.database.jdbc.UserDAOImpl;
import lv.javaguru.java2.domain.UserState;
import lv.javaguru.java2.services.exceptions.UserEditException;
import lv.javaguru.java2.services.validators.UserEditValidator;
import lv.javaguru.java2.services.validators.DataInputValidator;
import lv.javaguru.java2.services.validators.rules.passwordinput.EmptyOrNullPasswordRule;
import lv.javaguru.java2.services.validators.rules.passwordinput.LetterAndNumberPasswordRule;
import lv.javaguru.java2.services.validators.rules.passwordinput.MinLengthPasswordRule;
import lv.javaguru.java2.services.validators.rules.passwordinput.PasswordRule;

/**
 * Created by Yekaterina Savelyeva
 * on 16.07.2018
 */

public class UserEditValidatorImpl implements UserEditValidator {

    private UserDAO userDAO = new UserDAOImpl();

    private DataInputValidator passwordInputValidator =
            new DataInputValidatorImpl(userDAO, new EmptyOrNullPasswordRule(),
            new LetterAndNumberPasswordRule(),
            new MinLengthPasswordRule(),
                    new PasswordRule());

    private StringBuilder validationErrors = new StringBuilder();

    @Override
    public void validate(Long userId, String password, String firstName, String lastName, UserState state) {
        validatePassword(userId, password);
        //validateFirstName(firstName);
        //validateLastName(lastName);
        //validateState(state);
        handleValidationErrors();
    }

    public void validatePassword(Long userId, String password){
        try {
            passwordInputValidator.validateData(userId, password);
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
