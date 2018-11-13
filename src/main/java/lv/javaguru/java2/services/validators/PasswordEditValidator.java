package lv.javaguru.java2.services.validators;

import lv.javaguru.java2.domain.UserState;

/**
 * Created by user
 * on 13.11.2018
 */

public interface PasswordEditValidator {

    public void validate(Long userId, String password);

}
