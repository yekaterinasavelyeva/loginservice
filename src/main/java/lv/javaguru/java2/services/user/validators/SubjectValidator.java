package lv.javaguru.java2.services.user.validators;

import lv.javaguru.java2.domain.User;

/**
 * Created by user Yekaterina Savelyeva
 * on 12.03.2019
 */

public interface SubjectValidator {
    void validateLogin(String login);
    void validatePassword(String password, User user);
}
