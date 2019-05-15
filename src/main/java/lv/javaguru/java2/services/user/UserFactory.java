package lv.javaguru.java2.services.user;

import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.UserState;

import javax.validation.ConstraintViolation;
import java.util.Set;

public interface UserFactory {

    User create(String login, String password, String firstName, String lastName, UserState state);

    String getErrors();

    void setErrors(String errors);
}
