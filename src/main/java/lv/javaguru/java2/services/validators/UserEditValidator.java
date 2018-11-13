package lv.javaguru.java2.services.validators;

import lv.javaguru.java2.domain.UserState;

/**
 * Created by Yekaterina Savelyeva
 * on 16.07.2018
 */

public interface UserEditValidator {

    public void validate(String firstName, String lastName, UserState state);

}
