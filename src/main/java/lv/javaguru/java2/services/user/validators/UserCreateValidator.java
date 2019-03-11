package lv.javaguru.java2.services.user.validators;

import lv.javaguru.java2.domain.UserState;

/**
 * Created by user
 * on 28.02.2019
 */

public interface UserCreateValidator {
    void validate(String login, String password, String firstName, String lastName, UserState state);
}
