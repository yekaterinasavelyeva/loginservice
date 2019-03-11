package lv.javaguru.java2.services.user.validators.impls;

import lv.javaguru.java2.domain.UserState;
import lv.javaguru.java2.services.exceptions.UserPropertyException;
import lv.javaguru.java2.services.user.validators.DataInputValidator;
import lv.javaguru.java2.services.user.validators.UserCreateValidator;

import javax.inject.Inject;

/**
 * Created by user
 * on 28.02.2019
 */

public class UserCreateValidatorImpl implements UserCreateValidator {

    @Inject
    private DataInputValidator inputValidator;

    private StringBuilder validationErrors = new StringBuilder();

    @Override
    public void validate(String login, String password, String firstName, String lastName, UserState state) {
        validateFirstName(firstName);
        validateLastName(lastName);
        validateState(state);
        validateLogin(login);
        validatePassword(password);
        handleValidationErrors();
    }

    private void validateLogin(String login){
        try {
            inputValidator.validateUserLogin(login);
        } catch (IllegalArgumentException e) {
            collectMessage(e.getMessage());
        }
    }

    private void  validatePassword(String password){
        try {
            inputValidator.validateUserPassword(password);
        } catch (IllegalArgumentException e) {
            collectMessage(e.getMessage());
        }
    }

    private void validateFirstName(String firstName) {
        try {
            inputValidator.validateUserFirstNameInput(firstName);
        } catch (IllegalArgumentException e) {
            collectMessage(e.getMessage());
        }
    }

    private void validateLastName(String lastName) {
        try {
            inputValidator.validateUserLastNameInput(lastName);
        } catch (IllegalArgumentException e) {
            collectMessage(e.getMessage());
        }
    }

    private void validateState(UserState state) {
        try {
            inputValidator.validateUserStateInput(state);
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
