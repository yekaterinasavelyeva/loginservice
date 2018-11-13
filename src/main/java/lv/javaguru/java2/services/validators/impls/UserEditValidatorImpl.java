package lv.javaguru.java2.services.validators.impls;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.database.jdbc.UserDAOImpl;
import lv.javaguru.java2.domain.UserState;
import lv.javaguru.java2.services.exceptions.UserEditException;
import lv.javaguru.java2.services.validators.UserEditValidator;
import lv.javaguru.java2.services.validators.DataInputValidator;
import lv.javaguru.java2.services.validators.rules.inputimpls.EmptyOrNullInputRule;
import lv.javaguru.java2.services.validators.rules.inputimpls.InputRule;
import lv.javaguru.java2.services.validators.rules.inputimpls.LetterAndNumberInputRule;
import lv.javaguru.java2.services.validators.rules.inputimpls.MinLengthInputRule;

import javax.inject.Named;

/**
 * Created by Yekaterina Savelyeva
 * on 16.07.2018
 */

public class UserEditValidatorImpl implements UserEditValidator {

    private UserDAO userDAO = new UserDAOImpl();

    ///TODO implement UserState validator

    private DataInputValidator inputValidator =
            new DataInputValidatorImpl(userDAO, new EmptyOrNullInputRule(),
                    new LetterAndNumberInputRule(),new MinLengthInputRule(), new InputRule());


    private StringBuilder validationErrors = new StringBuilder();

    @Override
    public void validate(String firstName, String lastName, UserState state) {

        validateFirstName(firstName);
        validateLastName(lastName);
        //validateState(state);
        handleValidationErrors();
    }

    private void validateFirstName(String firstName){
        try {
            inputValidator.validateInput(firstName, "Firstname");
        } catch (IllegalArgumentException e) {
            collectMessage(e.getMessage());
        }
    }

    private void validateLastName(String lastName){
        try {
            inputValidator.validateInput(lastName, "LastName");
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
