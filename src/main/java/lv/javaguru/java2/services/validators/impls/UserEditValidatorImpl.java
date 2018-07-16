package lv.javaguru.java2.services.validators.impls;

import lv.javaguru.java2.domain.UserState;
import lv.javaguru.java2.services.exceptions.UserEditException;
import lv.javaguru.java2.services.exceptions.UserPropertyException;
import lv.javaguru.java2.services.validators.UserPropertiesValidator;
import lv.javaguru.java2.services.validators.UserEditValidator;
import lv.javaguru.java2.services.validators.rules.DataInputValidator;
import lv.javaguru.java2.services.validators.rules.passwordinput.EmptyOrNullPasswordRule;
import lv.javaguru.java2.services.validators.rules.passwordinput.LetterAndNumberPasswordRule;
import lv.javaguru.java2.services.validators.rules.passwordinput.MinLengthPasswordRule;

/**
 * Created by Yekaterina Savelyeva
 * on 16.07.2018
 */

public class UserEditValidatorImpl implements UserEditValidator {

    DataInputValidator passwordValidator =
            new DataInputValidatorImpl(new EmptyOrNullPasswordRule(),
            new LetterAndNumberPasswordRule(),
            new MinLengthPasswordRule());

    private StringBuilder validationErrors = new StringBuilder();

    @Override
    public void validate(Long userId, String password, String firstName, String lastName, UserState state) {
        validateUserId(userId);
        validatePassword(password);
        //validateFirstName(firstName);
        //validateLastName(lastName);
        //validateState(state);
        handleValidationErrors();
    }

    public void validateUserId(Long userId){

    }

    public void validatePassword(String password){
        try {
            passwordValidator.validatePassword(password);
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
