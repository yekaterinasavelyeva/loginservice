package lv.javaguru.java2.services.user.validators;

import lv.javaguru.java2.domain.UserState;

/**
 * Created by user
 * on 01.03.2019
 */

public interface DataInputValidator {

    void validateUserFirstNameInput(String firstName);
    void validateUserLastNameInput(String lastName);
    void validateUserStateInput(UserState state);
    void validateUserLogin(String login);
    void validateUserPassword(String password);

}
