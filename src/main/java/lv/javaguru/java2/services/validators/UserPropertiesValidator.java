package lv.javaguru.java2.services.validators;

import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.UserState;

public interface UserPropertiesValidator {

    void validate (String login, String password, String firstName, String lastName, UserState state);

}
